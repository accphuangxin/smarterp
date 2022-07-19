package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysPageDto;
import org.ffm.saas.smarterp.system.persistence.model.SysPagePo;
import org.ffm.saas.smarterp.system.service.SysPageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysPage Controller")
@RestController
@RequestMapping("/system/sysPage")
public class SysPageController {
    @Autowired
    private SysPageService sysPageService;

    @ApiOperation("sysPage 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysPagePo>> queryByPage(@RequestBody PageRequest<SysPagePo> pageParam) {
        PageRequest<SysPagePo> pageParamPo = new PageRequest<SysPagePo>();
        BeanUtils.copyProperties(pageParam, pageParamPo);
        return DataResult.ok(sysPageService.queryByPage(pageParamPo));
    }

    @ApiOperation("sysPage 创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysPageDto sysPageDto) {
        SysPagePo sysPagePo = new SysPagePo();
        BeanUtils.copyProperties(sysPageDto, sysPagePo);
        return DataResult.ok(sysPageService.create(sysPagePo));
    }

    @ApiOperation("sysPage 基于主键修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysPageDto sysPageDto) {
        SysPagePo sysPagePo = new SysPagePo();
        BeanUtils.copyProperties(sysPageDto, sysPagePo);
        return DataResult.ok(sysPageService.update(sysPagePo));
    }

    @ApiOperation("sysPage 基于主键删除")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysPageService.delete(id));
    }
}