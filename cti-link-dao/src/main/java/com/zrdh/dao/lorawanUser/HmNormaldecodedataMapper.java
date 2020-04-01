package com.zrdh.dao.lorawanUser;

import com.zrdh.entity.AlarmConditions;
import com.zrdh.pojo.lorawanUser.HmNormaldecodedata;
import com.zrdh.pojo.lorawanUser.HmNormaldecodedataKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HmNormaldecodedataMapper {
    int deleteByPrimaryKey(HmNormaldecodedataKey key);

    int insert(HmNormaldecodedata record);

    int insertSelective(HmNormaldecodedata record);

    HmNormaldecodedata selectByPrimaryKey(HmNormaldecodedataKey key);

    int updateByPrimaryKeySelective(HmNormaldecodedata record);

    int updateByPrimaryKey(HmNormaldecodedata record);

    /**
     * 根据报警信息查找
     * @param alarmConditions
     * @return
     */
    List<HmNormaldecodedata> selectByAlarmConditions(AlarmConditions alarmConditions);

    HmNormaldecodedata selectByHouseCard(@Param("cardNumber") int cardNumber,@Param("partition") String partition);
}