package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.model.SysAuthUserDto;

public interface SysAuthUserService {
    PageResponse<SysAuthUserDto> queryByPage(PageRequest<SysAuthUserDto> pageParam);

    Boolean create(SysAuthUserDto sysAuthUserDto);

    Boolean update(SysAuthUserDto sysAuthUserDto);

    Boolean delete(Integer id);
}