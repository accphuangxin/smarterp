package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysRoleDto;
import org.ffm.saas.smarterp.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysRole 服务列表")
@RestController
@RequestMapping("/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation("sysRole 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysRoleDto>> queryByPage(@RequestBody PageRequest<SysRoleDto> pageParam) {
        return DataResult.ok(sysRoleService.queryByPage(pageParam));
    }

    @ApiOperation("sysRole 创建服务")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysRoleDto sysRoleDto) {
        return DataResult.ok(sysRoleService.create(sysRoleDto));
    }

    @ApiOperation("sysRole 修改服务")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysRoleDto sysRoleDto) {
        return DataResult.ok(sysRoleService.update(sysRoleDto));
    }

    @ApiOperation("sysRole 删除服务")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysRoleService.delete(id));
    }
}