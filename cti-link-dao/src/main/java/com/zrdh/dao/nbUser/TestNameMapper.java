package com.zrdh.dao.nbUser;

import com.zrdh.pojo.nbUser.TestName;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TestNameMapper {

    @Select("select * from testname where id = #{id}")
    TestName findById(@Param("id") Integer id);
}
