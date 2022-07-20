package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.common.util.BeanUtilsWrapper;
import org.ffm.saas.smarterp.system.model.SysMenuDto;
import org.ffm.saas.smarterp.system.persistence.dao.SysMenuDao;
import org.ffm.saas.smarterp.system.persistence.model.SysMenuPo;
import org.ffm.saas.smarterp.system.service.SysMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;
    
    @Override
    public List<SysMenuDto> queryAll() {
        List<SysMenuDto> lists = sysMenuDao.selectAll().stream().map(po ->{
            return BeanUtilsWrapper.copy(po, new SysMenuDto());
        }).collect(Collectors.toList());
        
        Map<String, List<SysMenuDto>> listsGroup = lists.stream().collect(Collectors.groupingBy(SysMenuDto::getParentCode));
        
        listsGroup.get("top").forEach(v ->{
            v.setChildren(listsGroup.get(v.getCode()));
        });
        return listsGroup.get("top");
    }
    
    
    @Override
    public PageResponse<SysMenuDto> queryByPage(PageRequest<SysMenuDto> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysMenuPo> sysMenuPoList = sysMenuDao.selectAll();
        
        List<SysMenuDto> dtoList = sysMenuPoList.stream().map(po ->{
            return BeanUtilsWrapper.copy(po, new SysMenuDto());
        }).collect(Collectors.toList());
        
        PageInfo<SysMenuDto> pageInfo = new PageInfo<>(dtoList);
        return PageResponse.builder(pageInfo);
    }
    

    @Override
    public Boolean create(SysMenuDto sysMenuDto) {
        if (sysMenuDto == null){
            throw new AppException("sysMenu 参数不能为空!");
        }
        
        return sysMenuDao.insert(BeanUtilsWrapper.copy(sysMenuDto, new SysMenuPo())) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysMenuDto sysMenuDto) {
        if (sysMenuDto == null){
            throw new AppException("sysMenu 参数不能为空!");
        }
        return sysMenuDao.updateByPrimaryKey(BeanUtilsWrapper.copy(sysMenuDto, new SysMenuPo())) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysMenuDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}
