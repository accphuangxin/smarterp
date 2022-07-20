package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysAuthServiceDto;

public interface SysAuthServiceService {
    PageResponse<SysAuthServiceDto> queryByPage(PageRequest<SysAuthServiceDto> pageParam);

    Boolean create(SysAuthServiceDto sysAuthServiceDto);

    Boolean update(SysAuthServiceDto sysAuthServiceDto);

    Boolean delete(Integer id);
}