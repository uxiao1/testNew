package com.zrdh.dao.dataAnalyze;

import com.zrdh.pojo.dataAnalyze.Plot;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PlotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plot record);

    int insertSelective(Plot record);

    Plot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Plot record);

    int updateByPrimaryKey(Plot record);

    @Select("SELECT * FROM `plot` where hId = #{hid}")
    List<Plot> queryByHid(@Param("hid") Integer hid);
}