package org.ffm.saas.smarterp.system.service;

import java.util.List;
import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysMenuDto;
import org.ffm.saas.smarterp.system.persistence.model.SysMenuPo;

public interface SysMenuService {
    List<SysMenuDto> queryAll();
    
    PageResponse<SysMenuDto> queryByPage(PageRequest<SysMenuDto> pageParam);

    Boolean create(SysMenuDto sysMenuDto);

    Boolean update(SysMenuDto sysMenuDto);

    Boolean delete(Integer id);
}
