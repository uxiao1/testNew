package com.zrdh.dao.dispatchCenterHistory;

import com.zrdh.pojo.dispatchCenterHistory.TbTagHdbTd;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Date;
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
     * @return  取出tagId对应的最新的数据
     */
    TbTagHdbTd selectByTagId(@Param("dcId") Integer dcId);

    /**
     * 根据tagIds取出最新的一条数据
     * @param ids
     * @return  每个tagsId只返回一条最新的
     */
    List<TbTagHdbTd> selectByTagIds(@Param("ids") List<Integer> ids);

    /**
     * 根据tagId查找在指定时间的数据
     * @param tagId
     * @param tableName  表名 ----因为是拆表的
     * @return
     */
    TbTagHdbTd findHistoryByTagId(@Param("tagId") Integer tagId,@Param("tableName") String tableName,@Param("date") Date date);

    /**
     * 根据tagId查找在指定时间的数据
     * @param tagsIds   tagId的集合
     * @param tableName  表名 ----因为是拆表的
     * @return
     */
    List<TbTagHdbTd> findHistoryByTagIds(@Param("tagsIds")ArrayList<Integer> tagsIds,@Param("tableName") String tableName,@Param("date") Long beginTime);
}