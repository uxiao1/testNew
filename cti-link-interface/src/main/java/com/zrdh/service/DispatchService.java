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
     * @return
     */
    List<TbTagHdbTd> selectRLZTag();
}
