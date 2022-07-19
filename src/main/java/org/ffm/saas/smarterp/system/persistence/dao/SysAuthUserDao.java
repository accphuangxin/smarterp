package org.ffm.saas.smarterp.system.persistence.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.ffm.saas.smarterp.system.persistence.model.SysAuthUserPo;

@Mapper
public interface SysAuthUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAuthUserPo record);

    int insertSelective(SysAuthUserPo record);

    List<SysAuthUserPo> selectAll();

    SysAuthUserPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAuthUserPo record);

    int updateByPrimaryKey(SysAuthUserPo record);
}