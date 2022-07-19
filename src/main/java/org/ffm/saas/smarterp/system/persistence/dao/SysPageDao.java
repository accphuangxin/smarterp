package org.ffm.saas.smarterp.system.persistence.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.ffm.saas.smarterp.system.persistence.model.SysPagePo;

@Mapper
public interface SysPageDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPagePo record);

    int insertSelective(SysPagePo record);

    List<SysPagePo> selectAll();

    SysPagePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPagePo record);

    int updateByPrimaryKey(SysPagePo record);
}