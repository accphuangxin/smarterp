package org.ffm.saas.smarterp.system.service;

import org.ffm.saas.smarterp.common.model.PageRequest;
import org.ffm.saas.smarterp.common.model.PageResponse;
import org.ffm.saas.smarterp.system.persistence.model.SysPagePo;

public interface SysPageService {
    PageResponse<SysPagePo> queryByPage(PageRequest<SysPagePo> pageParam);

    Boolean create(SysPagePo sysPagePo);

    Boolean update(SysPagePo sysPagePo);

    Boolean delete(Integer id);
}