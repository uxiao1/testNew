package com.zrdh.service;

import com.zrdh.pojo.dataAnalyze.Cardnumberaddress;
import com.zrdh.pojo.dataAnalyze.FirstLevelLeakage;
import com.zrdh.pojo.dataAnalyze.SecondLevelLeakage;
import com.zrdh.pojo.dataAnalyze.SecondLevelLeakageSum;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/4/1 10:33
 */
public interface DataAnalyzeService {

    void saveFirstLevelLeakage(FirstLevelLeakage firstLevelLeakage);

    /**
     * //根据换热站id拿到换热站名称
     * //然后根据换热站名称去Heatstation表中拿到换热站对应的hid
     * //然后用hid去匹配plot表,拿到plot的名称
     * //根据plot名称去cardnumberAddress表匹配,拿到房卡号
     * @return
     * @param tagid
     */
    List<Cardnumberaddress> findCardNum4RlzTagId(Integer tagid);

    void saveSecondLeaveLeakage(SecondLevelLeakage secondLevelLeakage);

    /**
     * 查询电厂在定时任务表中指定时间内用量
     * @param beginTime
     * @param endTime
     * @return
     */
    double findDCHeatNumByFirstLevelLeakage(Long beginTime, Long endTime);

    /**
     * 查询热力站以及上级为电厂的贸易结算系统在任务表中指定时间内用量
     * @param beginTime
     * @param endTime
     * @return
     */
    double findRLZHeatNumBySecondLevelLeakage(Long beginTime, Long endTime);

    /**
     * 查询时间段内一级(电厂)漏损值和对应的时间
     * @param begin
     * @param end
     * @return  leakageNumList  漏损值     timeList  漏损值对应的时间
     */
    HashMap<String, ArrayList> findFirstLeakageNumAndTimeByBeginTime2EndTime(Date begin, Date end);

    /**
     * 查询时间段内二级(热力站,贸易)漏损值和对应的时间
     * @param begin
     * @param end
     * @return
     */
    HashMap<String, ArrayList> findSecondLeakageNumAndTimeByBeginTime2EndTime(Date begin, Date end);

    /**
     * 查询时间段内一级(电厂)用量和对应时间
     * @param begin
     * @param end
     * @return
     */
    HashMap<String, ArrayList> findFirstHeatNumAndTimeByBeginTime2EndTime(Date begin, Date end);

    /**
     * 查询时间段内二级(热力站,贸易)用量,功率,温差和对应时间
     * @param begin
     * @param end
     * @return
     */
    HashMap<String, ArrayList> findSecondHeatNumAndTimeByBeginTime2EndTime(Date begin, Date end);

    void saveSecondLeaveLeakageSum(SecondLevelLeakageSum secondLevelLeakageSum);
}
