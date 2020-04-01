package com.zrdh.dao.dataAnalyze;

import com.zrdh.pojo.dataAnalyze.FirstLevelLeakage;

public interface FirstLevelLeakageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FirstLevelLeakage record);

    int insertSelective(FirstLevelLeakage record);

    FirstLevelLeakage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FirstLevelLeakage record);

    int updateByPrimaryKey(FirstLevelLeakage record);
}