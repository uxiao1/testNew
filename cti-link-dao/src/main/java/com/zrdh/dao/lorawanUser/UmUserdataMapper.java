package com.zrdh.dao.lorawanUser;

import com.zrdh.pojo.lorawanUser.UmUserdata;

public interface UmUserdataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UmUserdata record);

    int insertSelective(UmUserdata record);

    UmUserdata selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UmUserdata record);

    int updateByPrimaryKey(UmUserdata record);
}