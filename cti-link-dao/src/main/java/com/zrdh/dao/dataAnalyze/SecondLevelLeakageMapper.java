package com.zrdh.dao.dataAnalyze;

import com.zrdh.pojo.dataAnalyze.SecondLevelLeakage;

public interface SecondLevelLeakageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecondLevelLeakage record);

    int insertSelective(SecondLevelLeakage record);

    SecondLevelLeakage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecondLevelLeakage record);

    int updateByPrimaryKey(SecondLevelLeakage record);

}