package com.zrdh.dao.dataAnalyze;

import com.zrdh.pojo.dataAnalyze.SecondLevelLeakage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface SecondLevelLeakageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecondLevelLeakage record);

    int insertSelective(SecondLevelLeakage record);

    SecondLevelLeakage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecondLevelLeakage record);

    int updateByPrimaryKey(SecondLevelLeakage record);

    /**
     * 根据tagIds查找离date最近的数据
     * @param tagIds
     * @param date
     * @return
     */
    List<SecondLevelLeakage> selectByTagIds4NearTime(ArrayList<Integer> tagIds, Date date);
}