package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.model.SysRolePo;

public interface SysRoleService {
    PageResponse<SysRolePo> queryByPage(PageRequest<SysRolePo> pageParam);

    Boolean create(SysRolePo sysRolePo);

    Boolean update(SysRolePo sysRolePo);

    Boolean delete(Integer id);
}