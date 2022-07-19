package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthSourcePo;

public interface SysAuthSourceService {
    PageResponse<SysAuthSourcePo> queryByPage(PageRequest<SysAuthSourcePo> pageParam);

    Boolean create(SysAuthSourcePo sysAuthSourcePo);

    Boolean update(SysAuthSourcePo sysAuthSourcePo);

    Boolean delete(Integer id);
}