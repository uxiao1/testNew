package com.zrdh.dao.dataAnalyze;

import com.zrdh.pojo.dataAnalyze.Cardnumberaddress;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CardnumberaddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cardnumberaddress record);

    int insertSelective(Cardnumberaddress record);

    Cardnumberaddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cardnumberaddress record);

    int updateByPrimaryKey(Cardnumberaddress record);

    @Select("select * from cardnumberaddress where C_BoroughName = #{name}")
    List<Cardnumberaddress> selectByBoroughName(@Param("name") String name);
}