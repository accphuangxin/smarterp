package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysAuthServiceDto;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthServicePo;
import org.ffm.saas.smarterp.system.service.SysAuthServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysAuthService Controller")
@RestController
@RequestMapping("/system/sysAuthService")
public class SysAuthServiceController {
    @Autowired
    private SysAuthServiceService sysAuthServiceService;

    @ApiOperation("sysAuthService 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysAuthServicePo>> queryByPage(@RequestBody PageRequest<SysAuthServicePo> pageParam) {
        PageRequest<SysAuthServicePo> pageParamPo = new PageRequest<SysAuthServicePo>();
        BeanUtils.copyProperties(pageParam, pageParamPo);
        return DataResult.ok(sysAuthServiceService.queryByPage(pageParamPo));
    }

    @ApiOperation("sysAuthService 创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysAuthServiceDto sysAuthServiceDto) {
        SysAuthServicePo sysAuthServicePo = new SysAuthServicePo();
        BeanUtils.copyProperties(sysAuthServiceDto, sysAuthServicePo);
        return DataResult.ok(sysAuthServiceService.create(sysAuthServicePo));
    }

    @ApiOperation("sysAuthService 基于主键修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysAuthServiceDto sysAuthServiceDto) {
        SysAuthServicePo sysAuthServicePo = new SysAuthServicePo();
        BeanUtils.copyProperties(sysAuthServiceDto, sysAuthServicePo);
        return DataResult.ok(sysAuthServiceService.update(sysAuthServicePo));
    }

    @ApiOperation("sysAuthService 基于主键删除")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysAuthServiceService.delete(id));
    }
}