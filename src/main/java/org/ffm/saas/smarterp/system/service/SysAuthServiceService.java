package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthServicePo;

public interface SysAuthServiceService {
    PageResponse<SysAuthServicePo> queryByPage(PageRequest<SysAuthServicePo> pageParam);

    Boolean create(SysAuthServicePo sysAuthServicePo);

    Boolean update(SysAuthServicePo sysAuthServicePo);

    Boolean delete(Integer id);
}