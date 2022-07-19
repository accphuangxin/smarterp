package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.model.SysCodePo;

public interface SysCodeService {
    PageResponse<SysCodePo> queryByPage(PageRequest<SysCodePo> pageParam);

    Boolean create(SysCodePo sysCodePo);

    Boolean update(SysCodePo sysCodePo);

    Boolean delete(Integer id);
}