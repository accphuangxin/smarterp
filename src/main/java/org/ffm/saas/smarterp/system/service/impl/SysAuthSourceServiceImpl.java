package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.common.util.BeanUtilsWrapper;
import org.ffm.saas.smarterp.system.model.SysAuthSourceDto;
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
    public PageResponse<SysAuthSourceDto> queryByPage(PageRequest<SysAuthSourceDto> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysAuthSourcePo> sysAuthSourcePoList = sysAuthSourceDao.selectAll();
        List<SysAuthSourceDto> dtoList = sysAuthSourcePoList.stream().map(po ->{
            return BeanUtilsWrapper.copy(po, new SysAuthSourceDto());
        }).collect(Collectors.toList());
        PageInfo<SysAuthSourceDto> pageInfo = new PageInfo<>(dtoList);
        return PageResponse.<SysAuthSourceDto>builder(pageInfo);
    }

    @Override
    public Boolean create(SysAuthSourceDto sysAuthSourceDto) {
        if (sysAuthSourceDto == null){
            throw new AppException("sysAuthSource 参数不能为空!");
        }
        return sysAuthSourceDao.insert(BeanUtilsWrapper.copy(sysAuthSourceDto, new SysAuthSourcePo())) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysAuthSourceDto sysAuthSourceDto) {
        if (sysAuthSourceDto == null){
            throw new AppException("sysAuthSource 参数不能为空!");
        }
        return sysAuthSourceDao.updateByPrimaryKey(BeanUtilsWrapper.copy(sysAuthSourceDto, new SysAuthSourcePo())) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysAuthSourceDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}