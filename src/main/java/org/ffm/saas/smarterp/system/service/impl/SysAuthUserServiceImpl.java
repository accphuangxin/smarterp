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
import org.ffm.saas.smarterp.system.model.SysAuthUserDto;
import org.ffm.saas.smarterp.system.persistence.dao.SysAuthUserDao;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthUserPo;
import org.ffm.saas.smarterp.system.service.SysAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysAuthUserServiceImpl implements SysAuthUserService {
    @Autowired
    private SysAuthUserDao sysAuthUserDao;

    @Override
    public PageResponse<SysAuthUserDto> queryByPage(PageRequest<SysAuthUserDto> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysAuthUserPo> sysAuthUserPoList = sysAuthUserDao.selectAll();
        List<SysAuthUserDto> dtoList = sysAuthUserPoList.stream().map(po ->{
            return BeanUtilsWrapper.copy(po, new SysAuthUserDto());
        }).collect(Collectors.toList());
        PageInfo<SysAuthUserDto> pageInfo = new PageInfo<>(dtoList);
        return PageResponse.<SysAuthUserDto>builder(pageInfo);
    }

    @Override
    public Boolean create(SysAuthUserDto sysAuthUserDto) {
        if (sysAuthUserDto == null){
            throw new AppException("sysAuthUser 参数不能为空!");
        }
        return sysAuthUserDao.insert(BeanUtilsWrapper.copy(sysAuthUserDto, new SysAuthUserPo())) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysAuthUserDto sysAuthUserDto) {
        if (sysAuthUserDto == null){
            throw new AppException("sysAuthUser 参数不能为空!");
        }
        return sysAuthUserDao.updateByPrimaryKey(BeanUtilsWrapper.copy(sysAuthUserDto, new SysAuthUserPo())) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysAuthUserDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}