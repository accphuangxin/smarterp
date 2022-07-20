package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysAuthButtonDto;

public interface SysAuthButtonService {
    PageResponse<SysAuthButtonDto> queryByPage(PageRequest<SysAuthButtonDto> pageParam);

    Boolean create(SysAuthButtonDto sysAuthButtonDto);

    Boolean update(SysAuthButtonDto sysAuthButtonDto);

    Boolean delete(Integer id);
}