package com.zrdh.dao.lorawanUser;

import com.zrdh.pojo.lorawanUser.HmLongfaultdecodedata;
import com.zrdh.pojo.lorawanUser.HmLongfaultdecodedataKey;

public interface HmLongfaultdecodedataMapper{
    int deleteByPrimaryKey(HmLongfaultdecodedataKey key);

    int insert(HmLongfaultdecodedata record);

    int insertSelective(HmLongfaultdecodedata record);

    HmLongfaultdecodedata selectByPrimaryKey(HmLongfaultdecodedataKey key);

    int updateByPrimaryKeySelective(HmLongfaultdecodedata record);

    int updateByPrimaryKey(HmLongfaultdecodedata record);
}