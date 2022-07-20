package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysAuthSourceDto;

public interface SysAuthSourceService {
    PageResponse<SysAuthSourceDto> queryByPage(PageRequest<SysAuthSourceDto> pageParam);

    Boolean create(SysAuthSourceDto sysAuthSourceDto);

    Boolean update(SysAuthSourceDto sysAuthSourceDto);

    Boolean delete(Integer id);
}