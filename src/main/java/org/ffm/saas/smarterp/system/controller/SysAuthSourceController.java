package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysAuthSourceDto;
import org.ffm.saas.smarterp.system.service.SysAuthSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysAuthSource 服务列表")
@RestController
@RequestMapping("/system/sysAuthSource")
public class SysAuthSourceController {
    @Autowired
    private SysAuthSourceService sysAuthSourceService;

    @ApiOperation("sysAuthSource 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysAuthSourceDto>> queryByPage(@RequestBody PageRequest<SysAuthSourceDto> pageParam) {
        return DataResult.ok(sysAuthSourceService.queryByPage(pageParam));
    }

    @ApiOperation("sysAuthSource 创建服务")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysAuthSourceDto sysAuthSourceDto) {
        return DataResult.ok(sysAuthSourceService.create(sysAuthSourceDto));
    }

    @ApiOperation("sysAuthSource 修改服务")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysAuthSourceDto sysAuthSourceDto) {
        return DataResult.ok(sysAuthSourceService.update(sysAuthSourceDto));
    }

    @ApiOperation("sysAuthSource 删除服务")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysAuthSourceService.delete(id));
    }
}