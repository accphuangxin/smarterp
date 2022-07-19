package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysOrgDto;
import org.ffm.saas.smarterp.system.persistence.model.SysOrgPo;
import org.ffm.saas.smarterp.system.service.SysOrgService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysOrg Controller")
@RestController
@RequestMapping("/system/sysOrg")
public class SysOrgController {
    @Autowired
    private SysOrgService sysOrgService;

    @ApiOperation("sysOrg 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysOrgPo>> queryByPage(@RequestBody PageRequest<SysOrgPo> pageParam) {
        PageRequest<SysOrgPo> pageParamPo = new PageRequest<SysOrgPo>();
        BeanUtils.copyProperties(pageParam, pageParamPo);
        return DataResult.ok(sysOrgService.queryByPage(pageParamPo));
    }

    @ApiOperation("sysOrg 创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysOrgDto sysOrgDto) {
        SysOrgPo sysOrgPo = new SysOrgPo();
        BeanUtils.copyProperties(sysOrgDto, sysOrgPo);
        return DataResult.ok(sysOrgService.create(sysOrgPo));
    }

    @ApiOperation("sysOrg 基于主键修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysOrgDto sysOrgDto) {
        SysOrgPo sysOrgPo = new SysOrgPo();
        BeanUtils.copyProperties(sysOrgDto, sysOrgPo);
        return DataResult.ok(sysOrgService.update(sysOrgPo));
    }

    @ApiOperation("sysOrg 基于主键删除")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysOrgService.delete(id));
    }
}