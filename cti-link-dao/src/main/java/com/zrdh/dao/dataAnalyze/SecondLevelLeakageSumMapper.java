package com.zrdh.dao.dataAnalyze;

import com.zrdh.pojo.dataAnalyze.SecondLevelLeakageSum;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface SecondLevelLeakageSumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecondLevelLeakageSum record);

    int insertSelective(SecondLevelLeakageSum record);

    SecondLevelLeakageSum selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecondLevelLeakageSum record);

    int updateByPrimaryKey(SecondLevelLeakageSum record);

    @Select("select * from second_level_leakage_sum where currentTime <= #{date} order by currentTime desc LIMIT 1")
    SecondLevelLeakageSum selectByTagIds4NearTime(@Param("date") Date date);

    @Select("select * from second_level_leakage_sum where currentTime BETWEEN #{begin} and #{end}")
    List<SecondLevelLeakageSum> selectBetweenBeginAndEnd(@Param("begin") Date begin, @Param("end") Date end);
}