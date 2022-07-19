package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysAuthSourceDto;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthSourcePo;
import org.ffm.saas.smarterp.system.service.SysAuthSourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysAuthSource Controller")
@RestController
@RequestMapping("/system/sysAuthSource")
public class SysAuthSourceController {
    @Autowired
    private SysAuthSourceService sysAuthSourceService;

    @ApiOperation("sysAuthSource 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysAuthSourcePo>> queryByPage(@RequestBody PageRequest<SysAuthSourcePo> pageParam) {
        PageRequest<SysAuthSourcePo> pageParamPo = new PageRequest<SysAuthSourcePo>();
        BeanUtils.copyProperties(pageParam, pageParamPo);
        return DataResult.ok(sysAuthSourceService.queryByPage(pageParamPo));
    }

    @ApiOperation("sysAuthSource 创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysAuthSourceDto sysAuthSourceDto) {
        SysAuthSourcePo sysAuthSourcePo = new SysAuthSourcePo();
        BeanUtils.copyProperties(sysAuthSourceDto, sysAuthSourcePo);
        return DataResult.ok(sysAuthSourceService.create(sysAuthSourcePo));
    }

    @ApiOperation("sysAuthSource 基于主键修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysAuthSourceDto sysAuthSourceDto) {
        SysAuthSourcePo sysAuthSourcePo = new SysAuthSourcePo();
        BeanUtils.copyProperties(sysAuthSourceDto, sysAuthSourcePo);
        return DataResult.ok(sysAuthSourceService.update(sysAuthSourcePo));
    }

    @ApiOperation("sysAuthSource 基于主键删除")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysAuthSourceService.delete(id));
    }
}