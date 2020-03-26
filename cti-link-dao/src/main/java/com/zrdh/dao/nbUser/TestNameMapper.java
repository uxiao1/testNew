package com.zrdh.dao.nbUser;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;

public interface TestNameMapper {

    @Select("select * from Vw_ameter_data_to_rlgs where sfbm = #{sfbm}")
    HashMap<String,Object> findById(@Param("sfbm") String sfbm);
}
