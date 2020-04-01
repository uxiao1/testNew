package com.zrdh.dao.dispatchCenter;

import com.zrdh.pojo.dispatchCenter.Tags;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagsMapper {
    int insert(Tags record);

    int insertSelective(Tags record);

    @Select("SELECT * FROM `tags` where TagName = #{TagName}")
    Tags findByTagName(@Param("TagName") String TagName);

    /**
     * 查询电厂id
     * @return
     */
    @Select("SELECT id FROM `tags` where TagName = 'RL_GSUM'")
    Integer selectDCId();

    /**
     * 查询所有热力站信息
     * @return
     */
    @Select("SELECT * FROM `tags` where TagComment = '累积热量'")
    List<Tags> selectRLZInfos();

    @Select("select * from tags where id = #{tagid}")
    Tags selectByTagId(@Param("tagid") Integer tagid);

    /**
     * 查询电厂信息
     * @return
     */
    @Select("SELECT * FROM `tags` where TagName = 'RL_GSUM'")
    Tags selectDcInfo();
}