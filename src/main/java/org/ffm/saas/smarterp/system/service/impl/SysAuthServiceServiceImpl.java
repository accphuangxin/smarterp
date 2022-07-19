package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
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
    public PageResponse<SysAuthServicePo> queryByPage(PageRequest<SysAuthServicePo> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysAuthServicePo> sysAuthServicePoList = sysAuthServiceDao.selectAll();
        PageInfo<SysAuthServicePo> pageInfo = new PageInfo<>(sysAuthServicePoList);
        return PageResponse.<SysAuthServicePo>builder(pageInfo);
    }

    @Override
    public Boolean create(SysAuthServicePo sysAuthServicePo) {
        if (sysAuthServicePo == null){
            throw new AppException("sysAuthService 参数不能为空!");
        }
        return sysAuthServiceDao.insert(sysAuthServicePo) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysAuthServicePo sysAuthServicePo) {
        if (sysAuthServicePo == null){
            throw new AppException("sysAuthService 参数不能为空!");
        }
        return sysAuthServiceDao.updateByPrimaryKey(sysAuthServicePo) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysAuthServiceDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}