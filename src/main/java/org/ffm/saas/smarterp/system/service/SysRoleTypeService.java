package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysRoleTypeDto;

public interface SysRoleTypeService {
    PageResponse<SysRoleTypeDto> queryByPage(PageRequest<SysRoleTypeDto> pageParam);

    Boolean create(SysRoleTypeDto sysRoleTypeDto);

    Boolean update(SysRoleTypeDto sysRoleTypeDto);

    Boolean delete(Integer id);
}