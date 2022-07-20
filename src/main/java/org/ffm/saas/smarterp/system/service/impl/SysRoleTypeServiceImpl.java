package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.common.util.BeanUtilsWrapper;
import org.ffm.saas.smarterp.system.model.SysRoleTypeDto;
import org.ffm.saas.smarterp.system.persistence.dao.SysRoleTypeDao;
import org.ffm.saas.smarterp.system.persistence.model.SysRoleTypePo;
import org.ffm.saas.smarterp.system.service.SysRoleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysRoleTypeServiceImpl implements SysRoleTypeService {
    @Autowired
    private SysRoleTypeDao sysRoleTypeDao;

    @Override
    public PageResponse<SysRoleTypeDto> queryByPage(PageRequest<SysRoleTypeDto> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysRoleTypePo> sysRoleTypePoList = sysRoleTypeDao.selectAll();
        List<SysRoleTypeDto> dtoList = sysRoleTypePoList.stream().map(po ->{
            return BeanUtilsWrapper.copy(po, new SysRoleTypeDto());
        }).collect(Collectors.toList());
        PageInfo<SysRoleTypeDto> pageInfo = new PageInfo<>(dtoList);
        return PageResponse.<SysRoleTypeDto>builder(pageInfo);
    }

    @Override
    public Boolean create(SysRoleTypeDto sysRoleTypeDto) {
        if (sysRoleTypeDto == null){
            throw new AppException("sysRoleType 参数不能为空!");
        }
        return sysRoleTypeDao.insert(BeanUtilsWrapper.copy(sysRoleTypeDto, new SysRoleTypePo())) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysRoleTypeDto sysRoleTypeDto) {
        if (sysRoleTypeDto == null){
            throw new AppException("sysRoleType 参数不能为空!");
        }
        return sysRoleTypeDao.updateByPrimaryKey(BeanUtilsWrapper.copy(sysRoleTypeDto, new SysRoleTypePo())) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysRoleTypeDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}