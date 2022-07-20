package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysMenuDto;
import org.ffm.saas.smarterp.system.service.SysMenuService;
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
    public DataResult<PageResponse<SysMenuDto>> queryByPage(@RequestBody PageRequest<SysMenuDto> pageParam) {
        return DataResult.ok(sysMenuService.queryByPage(pageParam));
    }
    
    @ApiOperation("sysMenu 查询所有")
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public DataResult<List<SysMenuDto>> queryAll() {
        return DataResult.ok(sysMenuService.queryAll());
    }

    @ApiOperation("sysMenu 创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysMenuDto sysMenuDto) {
        return DataResult.ok(sysMenuService.create(sysMenuDto));
    }

    @ApiOperation("sysMenu 基于主键修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysMenuDto sysMenuDto) {
        return DataResult.ok(sysMenuService.update(sysMenuDto));
    }

    @ApiOperation("sysMenu 基于主键删除")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysMenuService.delete(id));
    }
}
