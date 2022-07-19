package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysRoleDto;
import org.ffm.saas.smarterp.system.persistence.model.SysRolePo;
import org.ffm.saas.smarterp.system.service.SysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysRole Controller")
@RestController
@RequestMapping("/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation("sysRole 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysRolePo>> queryByPage(@RequestBody PageRequest<SysRolePo> pageParam) {
        PageRequest<SysRolePo> pageParamPo = new PageRequest<SysRolePo>();
        BeanUtils.copyProperties(pageParam, pageParamPo);
        return DataResult.ok(sysRoleService.queryByPage(pageParamPo));
    }

    @ApiOperation("sysRole 创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysRoleDto sysRoleDto) {
        SysRolePo sysRolePo = new SysRolePo();
        BeanUtils.copyProperties(sysRoleDto, sysRolePo);
        return DataResult.ok(sysRoleService.create(sysRolePo));
    }

    @ApiOperation("sysRole 基于主键修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysRoleDto sysRoleDto) {
        SysRolePo sysRolePo = new SysRolePo();
        BeanUtils.copyProperties(sysRoleDto, sysRolePo);
        return DataResult.ok(sysRoleService.update(sysRolePo));
    }

    @ApiOperation("sysRole 基于主键删除")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysRoleService.delete(id));
    }
}