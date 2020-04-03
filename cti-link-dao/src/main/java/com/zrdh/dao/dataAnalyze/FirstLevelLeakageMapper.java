package com.zrdh.dao.dataAnalyze;

import com.zrdh.pojo.dataAnalyze.FirstLevelLeakage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

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
    @Select("select * from first_level_leakage where currentTime <= #{dateTime} order by currentTime desc LIMIT 1")
    FirstLevelLeakage selectByNearTime(@Param("dateTime") Date dateTime);

    /**
     * 查询在指定时间内的所有数据
     * @param begin
     * @param end
     * @return
     */
    @Select("select * from first_level_leakage where currentTime BETWEEN #{begin} and #{end}")
    List<FirstLevelLeakage> selectBetweenBeginAndEnd(@Param("begin") Date begin,@Param("end") Date end);
}