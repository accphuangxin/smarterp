package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysAuthUserDto;
import org.ffm.saas.smarterp.system.service.SysAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysAuthUser 服务列表")
@RestController
@RequestMapping("/system/sysAuthUser")
public class SysAuthUserController {
    @Autowired
    private SysAuthUserService sysAuthUserService;

    @ApiOperation("sysAuthUser 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysAuthUserDto>> queryByPage(@RequestBody PageRequest<SysAuthUserDto> pageParam) {
        return DataResult.ok(sysAuthUserService.queryByPage(pageParam));
    }

    @ApiOperation("sysAuthUser 创建服务")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysAuthUserDto sysAuthUserDto) {
        return DataResult.ok(sysAuthUserService.create(sysAuthUserDto));
    }

    @ApiOperation("sysAuthUser 修改服务")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysAuthUserDto sysAuthUserDto) {
        return DataResult.ok(sysAuthUserService.update(sysAuthUserDto));
    }

    @ApiOperation("sysAuthUser 删除服务")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysAuthUserService.delete(id));
    }
}