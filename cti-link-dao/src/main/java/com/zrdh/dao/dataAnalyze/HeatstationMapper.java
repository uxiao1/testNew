package com.zrdh.dao.dataAnalyze;

import com.zrdh.pojo.dataAnalyze.Heatstation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface HeatstationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Heatstation record);

    int insertSelective(Heatstation record);

    Heatstation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Heatstation record);

    int updateByPrimaryKey(Heatstation record);

    @Select("SELECT * FROM `heatstation` where `name` = #{devname}")
    Heatstation selectByName(@Param("devname") String devname);

}