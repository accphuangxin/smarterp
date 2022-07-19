package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
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
    public PageResponse<SysRoleTypePo> queryByPage(PageRequest<SysRoleTypePo> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysRoleTypePo> sysRoleTypePoList = sysRoleTypeDao.selectAll();
        PageInfo<SysRoleTypePo> pageInfo = new PageInfo<>(sysRoleTypePoList);
        return PageResponse.<SysRoleTypePo>builder(pageInfo);
    }

    @Override
    public Boolean create(SysRoleTypePo sysRoleTypePo) {
        if (sysRoleTypePo == null){
            throw new AppException("sysRoleType 参数不能为空!");
        }
        return sysRoleTypeDao.insert(sysRoleTypePo) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysRoleTypePo sysRoleTypePo) {
        if (sysRoleTypePo == null){
            throw new AppException("sysRoleType 参数不能为空!");
        }
        return sysRoleTypeDao.updateByPrimaryKey(sysRoleTypePo) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysRoleTypeDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}