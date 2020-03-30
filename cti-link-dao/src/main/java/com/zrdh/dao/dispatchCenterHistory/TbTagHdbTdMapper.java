package com.zrdh.dao.dispatchCenterHistory;

import com.zrdh.pojo.dispatchCenterHistory.TbTagHdbTd;

/**
 * 存储热力站最新且唯一的信息
 */
public interface TbTagHdbTdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbTagHdbTd record);

    int insertSelective(TbTagHdbTd record);

    TbTagHdbTd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbTagHdbTd record);

    int updateByPrimaryKey(TbTagHdbTd record);

}