package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.model.SysMenuPo;

public interface SysMenuService {
    PageResponse<SysMenuPo> queryByPage(PageRequest<SysMenuPo> pageParam);

    Boolean create(SysMenuPo sysMenuPo);

    Boolean update(SysMenuPo sysMenuPo);

    Boolean delete(Integer id);
}