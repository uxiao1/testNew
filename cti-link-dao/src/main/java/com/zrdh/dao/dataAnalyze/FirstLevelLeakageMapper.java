package com.zrdh.dao.dataAnalyze;

import com.zrdh.pojo.dataAnalyze.FirstLevelLeakage;

import java.util.Date;

public interface FirstLevelLeakageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FirstLevelLeakage record);

    int insertSelective(FirstLevelLeakage record);

    FirstLevelLeakage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FirstLevelLeakage record);

    int updateByPrimaryKey(FirstLevelLeakage record);

    /**
     * 查询离指定时间最近的一条数据
     * @param dateTime
     * @return
     */
    FirstLevelLeakage selectByNearTime(Date dateTime);
}