package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.dao.SysCodeDao;
import org.ffm.saas.smarterp.system.persistence.model.SysCodePo;
import org.ffm.saas.smarterp.system.service.SysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysCodeServiceImpl implements SysCodeService {
    @Autowired
    private SysCodeDao sysCodeDao;

    @Override
    public PageResponse<SysCodePo> queryByPage(PageRequest<SysCodePo> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysCodePo> sysCodePoList = sysCodeDao.selectAll();
        PageInfo<SysCodePo> pageInfo = new PageInfo<>(sysCodePoList);
        return PageResponse.<SysCodePo>builder(pageInfo);
    }

    @Override
    public Boolean create(SysCodePo sysCodePo) {
        if (sysCodePo == null){
            throw new AppException("sysCode 参数不能为空!");
        }
        return sysCodeDao.insert(sysCodePo) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysCodePo sysCodePo) {
        if (sysCodePo == null){
            throw new AppException("sysCode 参数不能为空!");
        }
        return sysCodeDao.updateByPrimaryKey(sysCodePo) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysCodeDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}