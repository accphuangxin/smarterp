package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.common.util.BeanUtilsWrapper;
import org.ffm.saas.smarterp.system.model.SysOrgDto;
import org.ffm.saas.smarterp.system.persistence.dao.SysOrgDao;
import org.ffm.saas.smarterp.system.persistence.model.SysOrgPo;
import org.ffm.saas.smarterp.system.service.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysOrgServiceImpl implements SysOrgService {
    @Autowired
    private SysOrgDao sysOrgDao;

    @Override
    public PageResponse<SysOrgDto> queryByPage(PageRequest<SysOrgDto> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysOrgPo> sysOrgPoList = sysOrgDao.selectAll();
        List<SysOrgDto> dtoList = sysOrgPoList.stream().map(po ->{
            return BeanUtilsWrapper.copy(po, new SysOrgDto());
        }).collect(Collectors.toList());
        PageInfo<SysOrgDto> pageInfo = new PageInfo<>(dtoList);
        return PageResponse.<SysOrgDto>builder(pageInfo);
    }

    @Override
    public Boolean create(SysOrgDto sysOrgDto) {
        if (sysOrgDto == null){
            throw new AppException("sysOrg 参数不能为空!");
        }
        return sysOrgDao.insert(BeanUtilsWrapper.copy(sysOrgDto, new SysOrgPo())) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysOrgDto sysOrgDto) {
        if (sysOrgDto == null){
            throw new AppException("sysOrg 参数不能为空!");
        }
        return sysOrgDao.updateByPrimaryKey(BeanUtilsWrapper.copy(sysOrgDto, new SysOrgPo())) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysOrgDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}