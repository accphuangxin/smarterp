package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.model.SysUserPo;

public interface SysUserService {
    PageResponse<SysUserPo> queryByPage(PageRequest<SysUserPo> pageParam);

    Boolean create(SysUserPo sysUserPo);

    Boolean update(SysUserPo sysUserPo);

    Boolean delete(Integer id);
}