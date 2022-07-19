package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
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
    public PageResponse<SysUserPo> queryByPage(PageRequest<SysUserPo> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysUserPo> sysUserPoList = sysUserDao.selectAll();
        PageInfo<SysUserPo> pageInfo = new PageInfo<>(sysUserPoList);
        return PageResponse.<SysUserPo>builder(pageInfo);
    }

    @Override
    public Boolean create(SysUserPo sysUserPo) {
        if (sysUserPo == null){
            throw new AppException("sysUser 参数不能为空!");
        }
        return sysUserDao.insert(sysUserPo) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysUserPo sysUserPo) {
        if (sysUserPo == null){
            throw new AppException("sysUser 参数不能为空!");
        }
        return sysUserDao.updateByPrimaryKey(sysUserPo) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysUserDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}