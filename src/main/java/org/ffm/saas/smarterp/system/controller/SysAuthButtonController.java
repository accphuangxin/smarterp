package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysAuthButtonDto;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthButtonPo;
import org.ffm.saas.smarterp.system.service.SysAuthButtonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysAuthButton Controller")
@RestController
@RequestMapping("/system/sysAuthButton")
public class SysAuthButtonController {
    @Autowired
    private SysAuthButtonService sysAuthButtonService;

    @ApiOperation("sysAuthButton 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysAuthButtonPo>> queryByPage(@RequestBody PageRequest<SysAuthButtonPo> pageParam) {
        PageRequest<SysAuthButtonPo> pageParamPo = new PageRequest<SysAuthButtonPo>();
        BeanUtils.copyProperties(pageParam, pageParamPo);
        return DataResult.ok(sysAuthButtonService.queryByPage(pageParamPo));
    }

    @ApiOperation("sysAuthButton 创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysAuthButtonDto sysAuthButtonDto) {
        SysAuthButtonPo sysAuthButtonPo = new SysAuthButtonPo();
        BeanUtils.copyProperties(sysAuthButtonDto, sysAuthButtonPo);
        return DataResult.ok(sysAuthButtonService.create(sysAuthButtonPo));
    }

    @ApiOperation("sysAuthButton 基于主键修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysAuthButtonDto sysAuthButtonDto) {
        SysAuthButtonPo sysAuthButtonPo = new SysAuthButtonPo();
        BeanUtils.copyProperties(sysAuthButtonDto, sysAuthButtonPo);
        return DataResult.ok(sysAuthButtonService.update(sysAuthButtonPo));
    }

    @ApiOperation("sysAuthButton 基于主键删除")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysAuthButtonService.delete(id));
    }
}