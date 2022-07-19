package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysRoleTypeDto;
import org.ffm.saas.smarterp.system.persistence.model.SysRoleTypePo;
import org.ffm.saas.smarterp.system.service.SysRoleTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysRoleType Controller")
@RestController
@RequestMapping("/system/sysRoleType")
public class SysRoleTypeController {
    @Autowired
    private SysRoleTypeService sysRoleTypeService;

    @ApiOperation("sysRoleType 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysRoleTypePo>> queryByPage(@RequestBody PageRequest<SysRoleTypePo> pageParam) {
        PageRequest<SysRoleTypePo> pageParamPo = new PageRequest<SysRoleTypePo>();
        BeanUtils.copyProperties(pageParam, pageParamPo);
        return DataResult.ok(sysRoleTypeService.queryByPage(pageParamPo));
    }

    @ApiOperation("sysRoleType 创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysRoleTypeDto sysRoleTypeDto) {
        SysRoleTypePo sysRoleTypePo = new SysRoleTypePo();
        BeanUtils.copyProperties(sysRoleTypeDto, sysRoleTypePo);
        return DataResult.ok(sysRoleTypeService.create(sysRoleTypePo));
    }

    @ApiOperation("sysRoleType 基于主键修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysRoleTypeDto sysRoleTypeDto) {
        SysRoleTypePo sysRoleTypePo = new SysRoleTypePo();
        BeanUtils.copyProperties(sysRoleTypeDto, sysRoleTypePo);
        return DataResult.ok(sysRoleTypeService.update(sysRoleTypePo));
    }

    @ApiOperation("sysRoleType 基于主键删除")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysRoleTypeService.delete(id));
    }
}