package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysOrgDto;
import org.ffm.saas.smarterp.system.service.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysOrg 服务列表")
@RestController
@RequestMapping("/system/sysOrg")
public class SysOrgController {
    @Autowired
    private SysOrgService sysOrgService;

    @ApiOperation("sysOrg 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysOrgDto>> queryByPage(@RequestBody PageRequest<SysOrgDto> pageParam) {
        return DataResult.ok(sysOrgService.queryByPage(pageParam));
    }

    @ApiOperation("sysOrg 创建服务")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysOrgDto sysOrgDto) {
        return DataResult.ok(sysOrgService.create(sysOrgDto));
    }

    @ApiOperation("sysOrg 修改服务")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysOrgDto sysOrgDto) {
        return DataResult.ok(sysOrgService.update(sysOrgDto));
    }

    @ApiOperation("sysOrg 删除服务")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysOrgService.delete(id));
    }
}