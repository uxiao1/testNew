package com.zrdh.dao.lorawanUser;

import com.zrdh.pojo.lorawanUser.HmOrigindata;
import com.zrdh.pojo.lorawanUser.HmOrigindataKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface HmOrigindataMapper {
    int deleteByPrimaryKey(HmOrigindataKey key);

    int insert(HmOrigindata record);

    int insertSelective(HmOrigindata record);

    HmOrigindata selectByPrimaryKey(HmOrigindataKey key);

    int updateByPrimaryKeySelective(HmOrigindata record);

    int updateByPrimaryKey(HmOrigindata record);

    @Select("select * from HM_OriginData where DataId = #{dataId}")
    HmOrigindata selectByDataId(@Param("dataId") Integer dataId);
}