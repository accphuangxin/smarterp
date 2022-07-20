package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysUserDto;

public interface SysUserService {
    PageResponse<SysUserDto> queryByPage(PageRequest<SysUserDto> pageParam);

    Boolean create(SysUserDto sysUserDto);

    Boolean update(SysUserDto sysUserDto);

    Boolean delete(Integer id);
}