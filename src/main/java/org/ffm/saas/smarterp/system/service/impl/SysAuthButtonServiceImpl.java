package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.dao.SysAuthButtonDao;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthButtonPo;
import org.ffm.saas.smarterp.system.service.SysAuthButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysAuthButtonServiceImpl implements SysAuthButtonService {
    @Autowired
    private SysAuthButtonDao sysAuthButtonDao;

    @Override
    public PageResponse<SysAuthButtonPo> queryByPage(PageRequest<SysAuthButtonPo> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysAuthButtonPo> sysAuthButtonPoList = sysAuthButtonDao.selectAll();
        PageInfo<SysAuthButtonPo> pageInfo = new PageInfo<>(sysAuthButtonPoList);
        return PageResponse.<SysAuthButtonPo>builder(pageInfo);
    }

    @Override
    public Boolean create(SysAuthButtonPo sysAuthButtonPo) {
        if (sysAuthButtonPo == null){
            throw new AppException("sysAuthButton 参数不能为空!");
        }
        return sysAuthButtonDao.insert(sysAuthButtonPo) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysAuthButtonPo sysAuthButtonPo) {
        if (sysAuthButtonPo == null){
            throw new AppException("sysAuthButton 参数不能为空!");
        }
        return sysAuthButtonDao.updateByPrimaryKey(sysAuthButtonPo) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysAuthButtonDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}