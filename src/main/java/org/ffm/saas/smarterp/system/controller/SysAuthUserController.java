package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysAuthUserDto;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthUserPo;
import org.ffm.saas.smarterp.system.service.SysAuthUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysAuthUser Controller")
@RestController
@RequestMapping("/system/sysAuthUser")
public class SysAuthUserController {
    @Autowired
    private SysAuthUserService sysAuthUserService;

    @ApiOperation("sysAuthUser 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysAuthUserPo>> queryByPage(@RequestBody PageRequest<SysAuthUserPo> pageParam) {
        PageRequest<SysAuthUserPo> pageParamPo = new PageRequest<SysAuthUserPo>();
        BeanUtils.copyProperties(pageParam, pageParamPo);
        return DataResult.ok(sysAuthUserService.queryByPage(pageParamPo));
    }

    @ApiOperation("sysAuthUser 创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysAuthUserDto sysAuthUserDto) {
        SysAuthUserPo sysAuthUserPo = new SysAuthUserPo();
        BeanUtils.copyProperties(sysAuthUserDto, sysAuthUserPo);
        return DataResult.ok(sysAuthUserService.create(sysAuthUserPo));
    }

    @ApiOperation("sysAuthUser 基于主键修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysAuthUserDto sysAuthUserDto) {
        SysAuthUserPo sysAuthUserPo = new SysAuthUserPo();
        BeanUtils.copyProperties(sysAuthUserDto, sysAuthUserPo);
        return DataResult.ok(sysAuthUserService.update(sysAuthUserPo));
    }

    @ApiOperation("sysAuthUser 基于主键删除")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysAuthUserService.delete(id));
    }
}