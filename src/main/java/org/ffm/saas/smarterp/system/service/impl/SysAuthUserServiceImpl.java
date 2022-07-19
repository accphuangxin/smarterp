package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
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
    public PageResponse<SysAuthUserPo> queryByPage(PageRequest<SysAuthUserPo> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysAuthUserPo> sysAuthUserPoList = sysAuthUserDao.selectAll();
        PageInfo<SysAuthUserPo> pageInfo = new PageInfo<>(sysAuthUserPoList);
        return PageResponse.<SysAuthUserPo>builder(pageInfo);
    }

    @Override
    public Boolean create(SysAuthUserPo sysAuthUserPo) {
        if (sysAuthUserPo == null){
            throw new AppException("sysAuthUser 参数不能为空!");
        }
        return sysAuthUserDao.insert(sysAuthUserPo) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysAuthUserPo sysAuthUserPo) {
        if (sysAuthUserPo == null){
            throw new AppException("sysAuthUser 参数不能为空!");
        }
        return sysAuthUserDao.updateByPrimaryKey(sysAuthUserPo) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysAuthUserDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}