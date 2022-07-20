package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysCodeDto;

public interface SysCodeService {
    PageResponse<SysCodeDto> queryByPage(PageRequest<SysCodeDto> pageParam);

    Boolean create(SysCodeDto sysCodeDto);

    Boolean update(SysCodeDto sysCodeDto);

    Boolean delete(Integer id);
}