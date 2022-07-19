package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysMenuDto;
import org.ffm.saas.smarterp.system.persistence.model.SysMenuPo;
import org.ffm.saas.smarterp.system.service.SysMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysMenu Controller")
@RestController
@RequestMapping("/system/sysMenu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation("sysMenu 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysMenuPo>> queryByPage(@RequestBody PageRequest<SysMenuPo> pageParam) {
        PageRequest<SysMenuPo> pageParamPo = new PageRequest<SysMenuPo>();
        BeanUtils.copyProperties(pageParam, pageParamPo);
        return DataResult.ok(sysMenuService.queryByPage(pageParamPo));
    }

    @ApiOperation("sysMenu 创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysMenuDto sysMenuDto) {
        SysMenuPo sysMenuPo = new SysMenuPo();
        BeanUtils.copyProperties(sysMenuDto, sysMenuPo);
        return DataResult.ok(sysMenuService.create(sysMenuPo));
    }

    @ApiOperation("sysMenu 基于主键修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysMenuDto sysMenuDto) {
        SysMenuPo sysMenuPo = new SysMenuPo();
        BeanUtils.copyProperties(sysMenuDto, sysMenuPo);
        return DataResult.ok(sysMenuService.update(sysMenuPo));
    }

    @ApiOperation("sysMenu 基于主键删除")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysMenuService.delete(id));
    }
}