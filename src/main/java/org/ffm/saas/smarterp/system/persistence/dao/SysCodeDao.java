package org.ffm.saas.smarterp.system.persistence.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.ffm.saas.smarterp.system.persistence.model.SysCodePo;

@Mapper
public interface SysCodeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysCodePo record);

    int insertSelective(SysCodePo record);

    List<SysCodePo> selectAll();

    SysCodePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysCodePo record);

    int updateByPrimaryKey(SysCodePo record);
}