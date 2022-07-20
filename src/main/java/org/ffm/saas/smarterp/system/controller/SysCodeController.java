package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysCodeDto;
import org.ffm.saas.smarterp.system.service.SysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysCode 服务列表")
@RestController
@RequestMapping("/system/sysCode")
public class SysCodeController {
    @Autowired
    private SysCodeService sysCodeService;

    @ApiOperation("sysCode 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysCodeDto>> queryByPage(@RequestBody PageRequest<SysCodeDto> pageParam) {
        return DataResult.ok(sysCodeService.queryByPage(pageParam));
    }

    @ApiOperation("sysCode 创建服务")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysCodeDto sysCodeDto) {
        return DataResult.ok(sysCodeService.create(sysCodeDto));
    }

    @ApiOperation("sysCode 修改服务")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysCodeDto sysCodeDto) {
        return DataResult.ok(sysCodeService.update(sysCodeDto));
    }

    @ApiOperation("sysCode 删除服务")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysCodeService.delete(id));
    }
}