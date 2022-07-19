package org.ffm.saas.smarterp.system.persistence.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthServicePo;

@Mapper
public interface SysAuthServiceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAuthServicePo record);

    int insertSelective(SysAuthServicePo record);

    List<SysAuthServicePo> selectAll();

    SysAuthServicePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAuthServicePo record);

    int updateByPrimaryKey(SysAuthServicePo record);
}