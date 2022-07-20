package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysPageDto;
import org.ffm.saas.smarterp.system.service.SysPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysPage 服务列表")
@RestController
@RequestMapping("/system/sysPage")
public class SysPageController {
    @Autowired
    private SysPageService sysPageService;

    @ApiOperation("sysPage 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysPageDto>> queryByPage(@RequestBody PageRequest<SysPageDto> pageParam) {
        return DataResult.ok(sysPageService.queryByPage(pageParam));
    }

    @ApiOperation("sysPage 创建服务")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysPageDto sysPageDto) {
        return DataResult.ok(sysPageService.create(sysPageDto));
    }

    @ApiOperation("sysPage 修改服务")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysPageDto sysPageDto) {
        return DataResult.ok(sysPageService.update(sysPageDto));
    }

    @ApiOperation("sysPage 删除服务")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysPageService.delete(id));
    }
}