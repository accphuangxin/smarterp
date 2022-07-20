package org.ffm.saas.smarterp.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.common.util.BeanUtilsWrapper;
import org.ffm.saas.smarterp.system.model.SysCodeDto;
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
    public PageResponse<SysCodeDto> queryByPage(PageRequest<SysCodeDto> pageParam) {
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        List<SysCodePo> sysCodePoList = sysCodeDao.selectAll();
        List<SysCodeDto> dtoList = sysCodePoList.stream().map(po ->{
            return BeanUtilsWrapper.copy(po, new SysCodeDto());
        }).collect(Collectors.toList());
        PageInfo<SysCodeDto> pageInfo = new PageInfo<>(dtoList);
        return PageResponse.<SysCodeDto>builder(pageInfo);
    }

    @Override
    public Boolean create(SysCodeDto sysCodeDto) {
        if (sysCodeDto == null){
            throw new AppException("sysCode 参数不能为空!");
        }
        return sysCodeDao.insert(BeanUtilsWrapper.copy(sysCodeDto, new SysCodePo())) > 0 ? true : false;
    }

    @Override
    public Boolean update(SysCodeDto sysCodeDto) {
        if (sysCodeDto == null){
            throw new AppException("sysCode 参数不能为空!");
        }
        return sysCodeDao.updateByPrimaryKey(BeanUtilsWrapper.copy(sysCodeDto, new SysCodePo())) > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (id == null){
            throw new AppException("id 参数不能为空!");
        }
        return sysCodeDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}