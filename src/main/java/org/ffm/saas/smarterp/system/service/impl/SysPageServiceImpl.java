package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.common.util.BeanUtilsWrapper;
import org.ffm.saas.smarterp.system.model.SysPageDto;
import org.ffm.saas.smarterp.system.persistence.dao.SysPageDao;
import org.ffm.saas.smarterp.system.persistence.model.SysPagePo;
import org.ffm.saas.smarterp.system.service.SysPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysPageServiceImpl implements SysPageService {
    @Autowired
    private SysPageDao sysPageDao;

    @Override
    public PageResponse<SysPageDto> queryByPage(PageRequest<SysPageDto> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysPagePo> sysPagePoList = sysPageDao.selectAll();
        List<SysPageDto> dtoList = sysPagePoList.stream().map(po ->{
            return BeanUtilsWrapper.copy(po, new SysPageDto());
        }).collect(Collectors.toList());
        PageInfo<SysPageDto> pageInfo = new PageInfo<>(dtoList);
        return PageResponse.<SysPageDto>builder(pageInfo);
    }

    @Override
    public Boolean create(SysPageDto sysPageDto) {
        if (sysPageDto == null){
            throw new AppException("sysPage 参数不能为空!");
        }
        return sysPageDao.insert(BeanUtilsWrapper.copy(sysPageDto, new SysPagePo())) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysPageDto sysPageDto) {
        if (sysPageDto == null){
            throw new AppException("sysPage 参数不能为空!");
        }
        return sysPageDao.updateByPrimaryKey(BeanUtilsWrapper.copy(sysPageDto, new SysPagePo())) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysPageDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}