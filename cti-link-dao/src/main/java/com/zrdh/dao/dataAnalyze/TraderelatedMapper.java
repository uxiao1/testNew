package com.zrdh.dao.dataAnalyze;

import com.zrdh.pojo.dataAnalyze.Traderelated;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TraderelatedMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Traderelated record);

    int insertSelective(Traderelated record);

    Traderelated selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Traderelated record);

    int updateByPrimaryKey(Traderelated record);

    /**
     * 根据hid查找
     * @return
     */
    @Select("SELECT * FROM `traderelated` where hId = #{hid}")
    List<Traderelated> selectByHid(@Param("hid") Integer hid);
}