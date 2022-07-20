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
import org.ffm.saas.smarterp.system.model.SysUserDto;
import org.ffm.saas.smarterp.system.persistence.dao.SysUserDao;
import org.ffm.saas.smarterp.system.persistence.model.SysUserPo;
import org.ffm.saas.smarterp.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public PageResponse<SysUserDto> queryByPage(PageRequest<SysUserDto> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysUserPo> sysUserPoList = sysUserDao.selectAll();
        List<SysUserDto> dtoList = sysUserPoList.stream().map(po ->{
            return BeanUtilsWrapper.copy(po, new SysUserDto());
        }).collect(Collectors.toList());
        PageInfo<SysUserDto> pageInfo = new PageInfo<>(dtoList);
        return PageResponse.<SysUserDto>builder(pageInfo);
    }

    @Override
    public Boolean create(SysUserDto sysUserDto) {
        if (sysUserDto == null){
            throw new AppException("sysUser 参数不能为空!");
        }
        return sysUserDao.insert(BeanUtilsWrapper.copy(sysUserDto, new SysUserPo())) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysUserDto sysUserDto) {
        if (sysUserDto == null){
            throw new AppException("sysUser 参数不能为空!");
        }
        return sysUserDao.updateByPrimaryKey(BeanUtilsWrapper.copy(sysUserDto, new SysUserPo())) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysUserDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}