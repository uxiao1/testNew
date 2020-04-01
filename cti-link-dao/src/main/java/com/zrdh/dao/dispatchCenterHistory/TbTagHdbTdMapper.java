package com.zrdh.dao.dispatchCenterHistory;

import com.zrdh.pojo.dispatchCenterHistory.TbTagHdbTd;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 存储热力站最新且唯一的信息
 */
public interface TbTagHdbTdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbTagHdbTd record);

    int insertSelective(TbTagHdbTd record);

    TbTagHdbTd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbTagHdbTd record);

    int updateByPrimaryKey(TbTagHdbTd record);

    /**
     * 根据tagId查询
     * @param dcId
     * @return
     */
    @Select("SELECT * FROM `tb_tag_hdb_td` where TagId = #{dcId}")
    List<TbTagHdbTd> selectByTagId(@Param("dcId") Integer dcId);
}