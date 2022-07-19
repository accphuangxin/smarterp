package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthButtonPo;

public interface SysAuthButtonService {
    PageResponse<SysAuthButtonPo> queryByPage(PageRequest<SysAuthButtonPo> pageParam);

    Boolean create(SysAuthButtonPo sysAuthButtonPo);

    Boolean update(SysAuthButtonPo sysAuthButtonPo);

    Boolean delete(Integer id);
}