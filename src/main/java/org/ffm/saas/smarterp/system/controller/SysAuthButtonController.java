package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysAuthButtonDto;
import org.ffm.saas.smarterp.system.service.SysAuthButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysAuthButton 服务列表")
@RestController
@RequestMapping("/system/sysAuthButton")
public class SysAuthButtonController {
    @Autowired
    private SysAuthButtonService sysAuthButtonService;

    @ApiOperation("sysAuthButton 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysAuthButtonDto>> queryByPage(@RequestBody PageRequest<SysAuthButtonDto> pageParam) {
        return DataResult.ok(sysAuthButtonService.queryByPage(pageParam));
    }

    @ApiOperation("sysAuthButton 创建服务")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysAuthButtonDto sysAuthButtonDto) {
        return DataResult.ok(sysAuthButtonService.create(sysAuthButtonDto));
    }

    @ApiOperation("sysAuthButton 修改服务")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysAuthButtonDto sysAuthButtonDto) {
        return DataResult.ok(sysAuthButtonService.update(sysAuthButtonDto));
    }

    @ApiOperation("sysAuthButton 删除服务")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysAuthButtonService.delete(id));
    }
}