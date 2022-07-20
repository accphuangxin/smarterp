package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysUserDto;
import org.ffm.saas.smarterp.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysUser 服务列表")
@RestController
@RequestMapping("/system/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("sysUser 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysUserDto>> queryByPage(@RequestBody PageRequest<SysUserDto> pageParam) {
        return DataResult.ok(sysUserService.queryByPage(pageParam));
    }

    @ApiOperation("sysUser 创建服务")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysUserDto sysUserDto) {
        return DataResult.ok(sysUserService.create(sysUserDto));
    }

    @ApiOperation("sysUser 修改服务")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysUserDto sysUserDto) {
        return DataResult.ok(sysUserService.update(sysUserDto));
    }

    @ApiOperation("sysUser 删除服务")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysUserService.delete(id));
    }
}