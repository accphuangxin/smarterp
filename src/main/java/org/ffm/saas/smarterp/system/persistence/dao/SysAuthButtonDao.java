package org.ffm.saas.smarterp.system.persistence.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthButtonPo;

@Mapper
public interface SysAuthButtonDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAuthButtonPo record);

    int insertSelective(SysAuthButtonPo record);

    List<SysAuthButtonPo> selectAll();

    SysAuthButtonPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAuthButtonPo record);

    int updateByPrimaryKey(SysAuthButtonPo record);
}