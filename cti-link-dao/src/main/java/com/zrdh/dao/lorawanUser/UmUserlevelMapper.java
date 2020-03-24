package com.zrdh.dao.lorawanUser;

import com.zrdh.pojo.lorawanUser.UmUserlevel;

public interface UmUserlevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UmUserlevel record);

    int insertSelective(UmUserlevel record);

    UmUserlevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UmUserlevel record);

    int updateByPrimaryKey(UmUserlevel record);
}