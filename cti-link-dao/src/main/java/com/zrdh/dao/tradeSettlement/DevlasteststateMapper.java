package com.zrdh.dao.tradeSettlement;

import com.zrdh.entity.AlarmConditions;
import com.zrdh.pojo.tradeSettlement.Devlasteststate;
import com.zrdh.pojo.tradeSettlement.DevlasteststateKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

public interface DevlasteststateMapper {
    int deleteByPrimaryKey(DevlasteststateKey key);

    int insert(Devlasteststate record);

    int insertSelective(Devlasteststate record);

    Devlasteststate selectByPrimaryKey(DevlasteststateKey key);

    int updateByPrimaryKeySelective(Devlasteststate record);

    int updateByPrimaryKey(Devlasteststate record);

    /**
     * 根据报警信息查找
     * @param alarmConditions
     * @return
     */
    List<Devlasteststate> selectByAlarmCoditions(AlarmConditions alarmConditions);

    /**
     * 根据仪表号查找
     * @param meterid
     * @return
     */
    @Select("SELECT * FROM `newestdata` where DtuId = #{meterid}")
    Devlasteststate selectByMeterNo(@Param("meterid") String meterid);

    ArrayList<Devlasteststate> selectByMeterNos(@Param("meterNoList") List<String> meterNoList);
}