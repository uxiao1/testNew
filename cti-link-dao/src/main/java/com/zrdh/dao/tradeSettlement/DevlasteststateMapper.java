package com.zrdh.dao.tradeSettlement;

import com.zrdh.pojo.tradeSettlement.Devlasteststate;
import com.zrdh.pojo.tradeSettlement.DevlasteststateKey;

public interface DevlasteststateMapper {
    int deleteByPrimaryKey(DevlasteststateKey key);

    int insert(Devlasteststate record);

    int insertSelective(Devlasteststate record);

    Devlasteststate selectByPrimaryKey(DevlasteststateKey key);

    int updateByPrimaryKeySelective(Devlasteststate record);

    int updateByPrimaryKey(Devlasteststate record);
}