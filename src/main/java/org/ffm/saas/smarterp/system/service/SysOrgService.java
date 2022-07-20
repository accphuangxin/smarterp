package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysOrgDto;

public interface SysOrgService {
    PageResponse<SysOrgDto> queryByPage(PageRequest<SysOrgDto> pageParam);

    Boolean create(SysOrgDto sysOrgDto);

    Boolean update(SysOrgDto sysOrgDto);

    Boolean delete(Integer id);
}