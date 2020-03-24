package com.zrdh.dao.lorawanUser;

import com.zrdh.pojo.lorawanUser.HmNormaldecodedata;
import com.zrdh.pojo.lorawanUser.HmNormaldecodedataKey;

public interface HmNormaldecodedataMapper {
    int deleteByPrimaryKey(HmNormaldecodedataKey key);

    int insert(HmNormaldecodedata record);

    int insertSelective(HmNormaldecodedata record);

    HmNormaldecodedata selectByPrimaryKey(HmNormaldecodedataKey key);

    int updateByPrimaryKeySelective(HmNormaldecodedata record);

    int updateByPrimaryKey(HmNormaldecodedata record);
}