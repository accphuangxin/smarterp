package org.ffm.saas.smarterp.system.persistence.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.ffm.saas.smarterp.system.persistence.model.SysMenuPo;

@Mapper
public interface SysMenuDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenuPo record);

    int insertSelective(SysMenuPo record);

    List<SysMenuPo> selectAll();

    SysMenuPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenuPo record);

    int updateByPrimaryKey(SysMenuPo record);
}