package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysAuthServiceDto;
import org.ffm.saas.smarterp.system.service.SysAuthServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysAuthService 服务列表")
@RestController
@RequestMapping("/system/sysAuthService")
public class SysAuthServiceController {
    @Autowired
    private SysAuthServiceService sysAuthServiceService;

    @ApiOperation("sysAuthService 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysAuthServiceDto>> queryByPage(@RequestBody PageRequest<SysAuthServiceDto> pageParam) {
        return DataResult.ok(sysAuthServiceService.queryByPage(pageParam));
    }

    @ApiOperation("sysAuthService 创建服务")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysAuthServiceDto sysAuthServiceDto) {
        return DataResult.ok(sysAuthServiceService.create(sysAuthServiceDto));
    }

    @ApiOperation("sysAuthService 修改服务")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysAuthServiceDto sysAuthServiceDto) {
        return DataResult.ok(sysAuthServiceService.update(sysAuthServiceDto));
    }

    @ApiOperation("sysAuthService 删除服务")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysAuthServiceService.delete(id));
    }
}