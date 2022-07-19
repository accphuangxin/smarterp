package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthUserPo;

public interface SysAuthUserService {
    PageResponse<SysAuthUserPo> queryByPage(PageRequest<SysAuthUserPo> pageParam);

    Boolean create(SysAuthUserPo sysAuthUserPo);

    Boolean update(SysAuthUserPo sysAuthUserPo);

    Boolean delete(Integer id);
}