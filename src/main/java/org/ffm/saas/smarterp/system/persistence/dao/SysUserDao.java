package org.ffm.saas.smarterp.system.persistence.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.ffm.saas.smarterp.system.persistence.model.SysUserPo;

@Mapper
public interface SysUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserPo record);

    int insertSelective(SysUserPo record);

    List<SysUserPo> selectAll();

    SysUserPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserPo record);

    int updateByPrimaryKey(SysUserPo record);
}