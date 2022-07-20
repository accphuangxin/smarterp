package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysRoleDto;

public interface SysRoleService {
    PageResponse<SysRoleDto> queryByPage(PageRequest<SysRoleDto> pageParam);

    Boolean create(SysRoleDto sysRoleDto);

    Boolean update(SysRoleDto sysRoleDto);

    Boolean delete(Integer id);
}