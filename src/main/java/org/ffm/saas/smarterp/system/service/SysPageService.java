package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysPageDto;

public interface SysPageService {
    PageResponse<SysPageDto> queryByPage(PageRequest<SysPageDto> pageParam);

    Boolean create(SysPageDto sysPageDto);

    Boolean update(SysPageDto sysPageDto);

    Boolean delete(Integer id);
}