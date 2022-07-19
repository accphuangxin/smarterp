package org.ffm.saas.smarterp.system.persistence.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.ffm.saas.smarterp.system.persistence.model.SysRolePo;

@Mapper
public interface SysRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRolePo record);

    int insertSelective(SysRolePo record);

    List<SysRolePo> selectAll();

    SysRolePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRolePo record);

    int updateByPrimaryKey(SysRolePo record);
}