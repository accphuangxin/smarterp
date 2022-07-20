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
import org.ffm.saas.smarterp.system.model.SysAuthServiceDto;
import org.ffm.saas.smarterp.system.persistence.dao.SysAuthServiceDao;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthServicePo;
import org.ffm.saas.smarterp.system.service.SysAuthServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysAuthServiceServiceImpl implements SysAuthServiceService {
    @Autowired
    private SysAuthServiceDao sysAuthServiceDao;

    @Override
    public PageResponse<SysAuthServiceDto> queryByPage(PageRequest<SysAuthServiceDto> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysAuthServicePo> sysAuthServicePoList = sysAuthServiceDao.selectAll();
        List<SysAuthServiceDto> dtoList = sysAuthServicePoList.stream().map(po ->{
            return BeanUtilsWrapper.copy(po, new SysAuthServiceDto());
        }).collect(Collectors.toList());
        PageInfo<SysAuthServiceDto> pageInfo = new PageInfo<>(dtoList);
        return PageResponse.<SysAuthServiceDto>builder(pageInfo);
    }

    @Override
    public Boolean create(SysAuthServiceDto sysAuthServiceDto) {
        if (sysAuthServiceDto == null){
            throw new AppException("sysAuthService 参数不能为空!");
        }
        return sysAuthServiceDao.insert(BeanUtilsWrapper.copy(sysAuthServiceDto, new SysAuthServicePo())) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysAuthServiceDto sysAuthServiceDto) {
        if (sysAuthServiceDto == null){
            throw new AppException("sysAuthService 参数不能为空!");
        }
        return sysAuthServiceDao.updateByPrimaryKey(BeanUtilsWrapper.copy(sysAuthServiceDto, new SysAuthServicePo())) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysAuthServiceDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}