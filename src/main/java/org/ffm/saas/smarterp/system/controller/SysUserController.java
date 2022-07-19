package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysUserDto;
import org.ffm.saas.smarterp.system.persistence.model.SysUserPo;
import org.ffm.saas.smarterp.system.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysUser Controller")
@RestController
@RequestMapping("/system/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("sysUser 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysUserPo>> queryByPage(@RequestBody PageRequest<SysUserPo> pageParam) {
        PageRequest<SysUserPo> pageParamPo = new PageRequest<SysUserPo>();
        BeanUtils.copyProperties(pageParam, pageParamPo);
        return DataResult.ok(sysUserService.queryByPage(pageParamPo));
    }

    @ApiOperation("sysUser 创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysUserDto sysUserDto) {
        SysUserPo sysUserPo = new SysUserPo();
        BeanUtils.copyProperties(sysUserDto, sysUserPo);
        return DataResult.ok(sysUserService.create(sysUserPo));
    }

    @ApiOperation("sysUser 基于主键修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysUserDto sysUserDto) {
        SysUserPo sysUserPo = new SysUserPo();
        BeanUtils.copyProperties(sysUserDto, sysUserPo);
        return DataResult.ok(sysUserService.update(sysUserPo));
    }

    @ApiOperation("sysUser 基于主键删除")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysUserService.delete(id));
    }
}