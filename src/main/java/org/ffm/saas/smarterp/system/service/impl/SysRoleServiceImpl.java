package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.common.util.BeanUtilsWrapper;
import org.ffm.saas.smarterp.system.model.SysRoleDto;
import org.ffm.saas.smarterp.system.persistence.dao.SysRoleDao;
import org.ffm.saas.smarterp.system.persistence.model.SysRolePo;
import org.ffm.saas.smarterp.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public PageResponse<SysRoleDto> queryByPage(PageRequest<SysRoleDto> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysRolePo> sysRolePoList = sysRoleDao.selectAll();
        List<SysRoleDto> dtoList = sysRolePoList.stream().map(po ->{
            return BeanUtilsWrapper.copy(po, new SysRoleDto());
        }).collect(Collectors.toList());
        PageInfo<SysRoleDto> pageInfo = new PageInfo<>(dtoList);
        return PageResponse.<SysRoleDto>builder(pageInfo);
    }

    @Override
    public Boolean create(SysRoleDto sysRoleDto) {
        if (sysRoleDto == null){
            throw new AppException("sysRole 参数不能为空!");
        }
        return sysRoleDao.insert(BeanUtilsWrapper.copy(sysRoleDto, new SysRolePo())) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysRoleDto sysRoleDto) {
        if (sysRoleDto == null){
            throw new AppException("sysRole 参数不能为空!");
        }
        return sysRoleDao.updateByPrimaryKey(BeanUtilsWrapper.copy(sysRoleDto, new SysRolePo())) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysRoleDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}