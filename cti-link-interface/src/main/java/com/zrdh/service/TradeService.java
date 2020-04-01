package com.zrdh.service;

import com.zrdh.pojo.tradeSettlement.Devlasteststate;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: cti-link-dataAnalysis
 * 贸易结算服务
 * Created by hua on 2020/3/31 15:11
 */
public interface TradeService {

    /**
     * 查询上一级是电厂的贸易结算系统的数据
     * @return
     */
    List<Devlasteststate> query4DC();


    /**
     * 查询热力站id对应的贸易结算系统
     * @param tagid
     * @return
     */
    ArrayList<Devlasteststate> query4RLZInfos(Integer tagid);
}
