package org.ffm.saas.smarterp.system.persistence.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.ffm.saas.smarterp.system.persistence.model.SysRoleTypePo;

@Mapper
public interface SysRoleTypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleTypePo record);

    int insertSelective(SysRoleTypePo record);

    List<SysRoleTypePo> selectAll();

    SysRoleTypePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleTypePo record);

    int updateByPrimaryKey(SysRoleTypePo record);
}