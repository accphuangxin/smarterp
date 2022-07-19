package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.dao.SysAuthSourceDao;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthSourcePo;
import org.ffm.saas.smarterp.system.service.SysAuthSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysAuthSourceServiceImpl implements SysAuthSourceService {
    @Autowired
    private SysAuthSourceDao sysAuthSourceDao;

    @Override
    public PageResponse<SysAuthSourcePo> queryByPage(PageRequest<SysAuthSourcePo> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysAuthSourcePo> sysAuthSourcePoList = sysAuthSourceDao.selectAll();
        PageInfo<SysAuthSourcePo> pageInfo = new PageInfo<>(sysAuthSourcePoList);
        return PageResponse.<SysAuthSourcePo>builder(pageInfo);
    }

    @Override
    public Boolean create(SysAuthSourcePo sysAuthSourcePo) {
        if (sysAuthSourcePo == null){
            throw new AppException("sysAuthSource 参数不能为空!");
        }
        return sysAuthSourceDao.insert(sysAuthSourcePo) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysAuthSourcePo sysAuthSourcePo) {
        if (sysAuthSourcePo == null){
            throw new AppException("sysAuthSource 参数不能为空!");
        }
        return sysAuthSourceDao.updateByPrimaryKey(sysAuthSourcePo) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysAuthSourceDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}