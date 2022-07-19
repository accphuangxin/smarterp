package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.model.SysRoleTypePo;

public interface SysRoleTypeService {
    PageResponse<SysRoleTypePo> queryByPage(PageRequest<SysRoleTypePo> pageParam);

    Boolean create(SysRoleTypePo sysRoleTypePo);

    Boolean update(SysRoleTypePo sysRoleTypePo);

    Boolean delete(Integer id);
}