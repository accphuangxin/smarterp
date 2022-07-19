package org.ffm.saas.smarterp.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysCodeDto;
import org.ffm.saas.smarterp.system.persistence.model.SysCodePo;
import org.ffm.saas.smarterp.system.service.SysCodeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("sysCode Controller")
@RestController
@RequestMapping("/system/sysCode")
public class SysCodeController {
    @Autowired
    private SysCodeService sysCodeService;

    @ApiOperation("sysCode 分页查询")
    @RequestMapping(value = "/queryByPage", method = RequestMethod.POST)
    public DataResult<PageResponse<SysCodePo>> queryByPage(@RequestBody PageRequest<SysCodePo> pageParam) {
        PageRequest<SysCodePo> pageParamPo = new PageRequest<SysCodePo>();
        BeanUtils.copyProperties(pageParam, pageParamPo);
        return DataResult.ok(sysCodeService.queryByPage(pageParamPo));
    }

    @ApiOperation("sysCode 创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataResult<Boolean> create(@RequestBody SysCodeDto sysCodeDto) {
        SysCodePo sysCodePo = new SysCodePo();
        BeanUtils.copyProperties(sysCodeDto, sysCodePo);
        return DataResult.ok(sysCodeService.create(sysCodePo));
    }

    @ApiOperation("sysCode 基于主键修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public DataResult<Boolean> update(@RequestBody SysCodeDto sysCodeDto) {
        SysCodePo sysCodePo = new SysCodePo();
        BeanUtils.copyProperties(sysCodeDto, sysCodePo);
        return DataResult.ok(sysCodeService.update(sysCodePo));
    }

    @ApiOperation("sysCode 基于主键删除")
    @GetMapping("/delete")
    public DataResult<Boolean> delete(Integer id) {
        return DataResult.ok(sysCodeService.delete(id));
    }
}