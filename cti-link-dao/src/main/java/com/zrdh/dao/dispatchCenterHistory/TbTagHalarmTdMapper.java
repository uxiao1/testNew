package com.zrdh.dao.dispatchCenterHistory;

import com.zrdh.pojo.dispatchCenterHistory.TbTagHalarmTd;

public interface TbTagHalarmTdMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbTagHalarmTd record);

    int insertSelective(TbTagHalarmTd record);

    TbTagHalarmTd selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbTagHalarmTd record);

    int updateByPrimaryKey(TbTagHalarmTd record);
}