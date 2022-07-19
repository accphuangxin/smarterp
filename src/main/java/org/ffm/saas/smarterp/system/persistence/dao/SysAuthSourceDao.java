package org.ffm.saas.smarterp.system.persistence.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthSourcePo;

@Mapper
public interface SysAuthSourceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAuthSourcePo record);

    int insertSelective(SysAuthSourcePo record);

    List<SysAuthSourcePo> selectAll();

    SysAuthSourcePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAuthSourcePo record);

    int updateByPrimaryKey(SysAuthSourcePo record);
}