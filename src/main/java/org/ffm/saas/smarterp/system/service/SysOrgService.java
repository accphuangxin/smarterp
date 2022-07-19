package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.model.SysOrgPo;

public interface SysOrgService {
    PageResponse<SysOrgPo> queryByPage(PageRequest<SysOrgPo> pageParam);

    Boolean create(SysOrgPo sysOrgPo);

    Boolean update(SysOrgPo sysOrgPo);

    Boolean delete(Integer id);
}