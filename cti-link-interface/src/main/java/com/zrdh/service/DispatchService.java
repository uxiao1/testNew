package com.zrdh.service;

import com.zrdh.pojo.dispatchCenterHistory.TbTagHdbTd;

import java.util.List;

/**
 * Description: cti-link-dataAnalysis
 * 中自系统服务
 * Created by hua on 2020/3/31 15:08
 */
public interface DispatchService {

    /**
     * 查询电厂最新热量
     * @return
     */
    TbTagHdbTd selectDcHeatNumber();

    /**
     * 查询所有热力站最新数据
     * // 部分数据不是热力站,需要排除
     * TagsExcludeConstant 在该常量类中添加需要排除的id
     * @return
     */
    List<TbTagHdbTd> selectRLZTag();

    /**
     * 根据指定起始时间去历史表中查询电厂用量
     * @param beginTime
     * @param endTime
     * @return
     */
    double findDCHeatNumByBeginTimeAndEndTime(Long beginTime, Long endTime);

    /**
     * 根据指定起始时间去历史表中查询所有热力站用量
     * @param beginTime
     * @param endTime
     * @return
     */
    double findRLZHeatNumByBeginTimeAndEndTime(Long beginTime, Long endTime);

}
