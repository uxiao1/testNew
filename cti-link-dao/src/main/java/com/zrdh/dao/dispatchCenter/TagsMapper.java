package com.zrdh.dao.dispatchCenter;

import com.zrdh.pojo.dispatchCenter.Tags;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TagsMapper {
    int insert(Tags record);

    int insertSelective(Tags record);

    @Select("SELECT * FROM `tags` where TagName = #{TagName}")
    Tags findByTagName(@Param("TagName") String TagName);
}