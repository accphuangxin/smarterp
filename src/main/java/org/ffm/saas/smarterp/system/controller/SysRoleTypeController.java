package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysRoleTypeDto;
import org.ffm.saas.smarterp.system.service.SysRoleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysRoleType 服务列表")
@RestController
@RequestMapping("/system/sysRoleType")
public class SysRoleTypeController {
    @Autowired
    private SysRoleTypeService sysRoleTypeService;

    @ApiOperation("sysRoleType 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysRoleTypeDto>> queryByPage(@RequestBody PageRequest<SysRoleTypeDto> pageParam) {
        return DataResult.ok(sysRoleTypeService.queryByPage(pageParam));
    }

    @ApiOperation("sysRoleType 创建服务")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysRoleTypeDto sysRoleTypeDto) {
        return DataResult.ok(sysRoleTypeService.create(sysRoleTypeDto));
    }

    @ApiOperation("sysRoleType 修改服务")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysRoleTypeDto sysRoleTypeDto) {
        return DataResult.ok(sysRoleTypeService.update(sysRoleTypeDto));
    }

    @ApiOperation("sysRoleType 删除服务")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysRoleTypeService.delete(id));
    }
}