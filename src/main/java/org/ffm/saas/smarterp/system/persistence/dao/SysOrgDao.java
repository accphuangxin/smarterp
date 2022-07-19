package org.ffm.saas.smarterp.system.persistence.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.ffm.saas.smarterp.system.persistence.model.SysOrgPo;

@Mapper
public interface SysOrgDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOrgPo record);

    int insertSelective(SysOrgPo record);

    List<SysOrgPo> selectAll();

    SysOrgPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOrgPo record);

    int updateByPrimaryKey(SysOrgPo record);
}