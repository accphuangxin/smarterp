package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.dao.SysMenuDao;
import org.ffm.saas.smarterp.system.persistence.model.SysMenuPo;
import org.ffm.saas.smarterp.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public PageResponse<SysMenuPo> queryByPage(PageRequest<SysMenuPo> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysMenuPo> sysMenuPoList = sysMenuDao.selectAll();
        PageInfo<SysMenuPo> pageInfo = new PageInfo<>(sysMenuPoList);
        return PageResponse.<SysMenuPo>builder(pageInfo);
    }

    @Override
    public Boolean create(SysMenuPo sysMenuPo) {
        if (sysMenuPo == null){
            throw new AppException("sysMenu 参数不能为空!");
        }
        return sysMenuDao.insert(sysMenuPo) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysMenuPo sysMenuPo) {
        if (sysMenuPo == null){
            throw new AppException("sysMenu 参数不能为空!");
        }
        return sysMenuDao.updateByPrimaryKey(sysMenuPo) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysMenuDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}