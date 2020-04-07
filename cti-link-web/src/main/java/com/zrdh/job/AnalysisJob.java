package com.zrdh.job;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zrdh.pojo.dataAnalyze.Cardnumberaddress;
import com.zrdh.pojo.dataAnalyze.FirstLevelLeakage;
import com.zrdh.pojo.dataAnalyze.SecondLevelLeakage;
import com.zrdh.pojo.dataAnalyze.SecondLevelLeakageSum;
import com.zrdh.pojo.dispatchCenterHistory.TbTagHdbTd;
import com.zrdh.pojo.lorawanUser.HmNormaldecodedata;
import com.zrdh.pojo.nbUser.VmAmeterRlgs;
import com.zrdh.pojo.tradeSettlement.Devlasteststate;
import com.zrdh.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description: cti-link-dataAnalysis
 * 管网自动分析漏损定时任务
 *
 * Created by hua on 2020/3/25 15:38
 */
public class AnalysisJob {

    @Reference
    private DispatchService dispatchService;
    @Reference
    private DeerService deerService;
    @Reference
    private LorawanService lorawanService;
    @Reference
    private TradeService tradeService;
    @Reference
    private DeviceInfoService deviceInfoService;
    @Reference
    private DataAnalyzeService dataAnalyzeService;
    private Logger logger = LoggerFactory.getLogger(AnalysisJob.class);

    /**
     * 一级管网自动分析漏损
     */
    public void firstLeaveLeakage(){
        logger.debug("===============================*********一级管网漏损分析*********==============================");
        //电厂
        TbTagHdbTd dcTag = dispatchService.selectDcHeatNumber();
        if(dcTag != null) {
            //所有热力站最新数据
            List<TbTagHdbTd> rlzTags = dispatchService.selectRLZTag();
            Double rlzHeatNumbSum = 0.00;   //所有热力站总热力值
            for (TbTagHdbTd rlzTag : rlzTags) {
                rlzHeatNumbSum += rlzTag.getValue();
            }
            // 贸易中心数据有可能是直接对应电厂的
            //得到上级是电厂的贸易中心数据
            List<Devlasteststate> devlasteststateList = tradeService.query4DC();
            Double tradeHeatNumSum = 0.00;
            if(devlasteststateList != null && !devlasteststateList.isEmpty()) {
                for (Devlasteststate devlasteststate : devlasteststateList) {
                    tradeHeatNumSum += devlasteststate.getCurheatnum();
                }
            }
            //实时温度
            String currentTemperature = deviceInfoService.getCurrentTemperature(new Date());
            FirstLevelLeakage firstLevelLeakage = new FirstLevelLeakage();
            firstLevelLeakage.setDcid(dcTag.getTagid());
            firstLevelLeakage.setDccurheatnumer(dcTag.getValue());
            firstLevelLeakage.setRlzcurheatnumber(rlzHeatNumbSum + tradeHeatNumSum);
            firstLevelLeakage.setLeakagenumber(dcTag.getValue() - rlzHeatNumbSum - tradeHeatNumSum);
            firstLevelLeakage.setTemperature(currentTemperature);
            firstLevelLeakage.setCurrenttime(new Date());
            logger.debug("------------------------------一级管网漏损分析结果:" + firstLevelLeakage.toString() + "-----------------------------");
            dataAnalyzeService.saveFirstLevelLeakage(firstLevelLeakage);
        }
    }

    /**
     * 二级管网自动分析漏损
     */
    public void secondLeaveLeakage(){
        logger.debug("=====================================**********二级管网漏损分析***********====================================");
        //所有热力站最新数据
        List<TbTagHdbTd> rlzTags = dispatchService.selectRLZTag();
        if(rlzTags != null && !rlzTags.isEmpty()) {
            //实时温度
            String currentTemperature = deviceInfoService.getCurrentTemperature(new Date());
            SecondLevelLeakageSum secondLevelLeakageSum = new SecondLevelLeakageSum();
            Double tagHeatNumSum = 0d;
            Double hyHeatNumbSum = 0d;
            Double leakageNumSum = 0d;
            Double heatPowerSum = 0d;
            Double wdcSum = 0d;
            for (TbTagHdbTd rlzTag : rlzTags) {
                SecondLevelLeakage secondLevelLeakage = new SecondLevelLeakage();
                secondLevelLeakage.setTagid(rlzTag.getTagid());
                secondLevelLeakage.setTagcurheatnumer(rlzTag.getValue());
                //拿到该热力站所对应的全部房卡号信息(全部系统的房卡号信息)
                List<Cardnumberaddress> cardnumberaddresses = dataAnalyzeService.findCardNum4RlzTagId(rlzTag.getTagid());
                if (cardnumberaddresses != null && !cardnumberaddresses.isEmpty()) {
                    logger.debug("------------------------------热力站tagId为" + rlzTag.getTagid() + "对应的全部房卡号信息:" + cardnumberaddresses.toString() + "-----------------------------");
                    //根据房卡信息拿到德尔系统对应的信息
                    List<VmAmeterRlgs> deers = deerService.queryDeer4CardNumber(cardnumberaddresses);
                    Double deerCurHeatNumber = 0.00;    //热力值
                    Double deerHeatPower = 0.00;        //功率
                    Double deerWdc = 0.00;              //温差
                    if(deers != null && !deers.isEmpty()) {
                        logger.debug("------------------------------该热力站德尔系统对应的数据:" + deers.toString() + "---------------------------------");
                        for (VmAmeterRlgs deer : deers) {
                            deerCurHeatNumber += (deer.getDqrl() == null) ? 0 : deer.getDqrl();
                            deerHeatPower += (deer.getGl() == null) ? 0 : deer.getGl();
                            deerWdc += (deer.getWdc() == null) ? 0 : deer.getWdc();
                        }
                    }

                    //贸易系统的数据
                    ArrayList<Devlasteststate> devlasteststates = tradeService.query4RLZInfos(rlzTag.getTagid());
                    Double tradeCurHeatNumber = 0.00;
                    Double tradeHeatPower = 0.00;
                    Double tradeWdc = 0.00;
                    if(devlasteststates != null && !devlasteststates.isEmpty()) {
                        logger.debug("------------------------------该热力站贸易系统对应的数据:" + devlasteststates.toString() + "---------------------------------");
                        for (Devlasteststate devlasteststate : devlasteststates) {
                            tradeCurHeatNumber += (devlasteststate.getCurheatnum() == null) ? 0 : devlasteststate.getCurheatnum();
                            tradeHeatPower += (devlasteststate.getHeatpower() == null) ? 0 :devlasteststate.getHeatpower();
                            tradeWdc += ((devlasteststate.getSupplywatertmp() == null) ? 0 : devlasteststate.getSupplywatertmp()) - ((devlasteststate.getReturnwatertmp() == null) ? 0 : devlasteststate.getReturnwatertmp());
                        }
                    }

                    //根据房卡信息拿到lorawan系统对应的信息
                    List<HmNormaldecodedata> lorawans = lorawanService.query4HouseCard(cardnumberaddresses);
                    Double lorawanCurHeatNumber = 0.00;
                    Double lorawanHeatPower = 0.00;
                    Double lorawanWdc = 0.00;
                    if(lorawans != null && !lorawans.isEmpty()) {
                        logger.debug("------------------------------该热力站lorawan系统对应的数据:" + lorawans.toString() + "---------------------------------");
                        for (HmNormaldecodedata lorawan : lorawans) {
                            lorawanCurHeatNumber += (lorawan.getCurrentheatnumber() == null) ? 0 : lorawan.getCurrentheatnumber();
                            lorawanHeatPower += (lorawan.getHeatpower() == null) ? 0 : lorawan.getHeatpower();
                            lorawanWdc += (lorawan.getWdc() == null) ? 0 : lorawan.getWdc();
                        }
                    }
                    //热力站对应的三大系统的总热力值
                    Double hyCurHeatNumber = deerCurHeatNumber + lorawanCurHeatNumber + tradeCurHeatNumber;
                    Double hyHeatPower = deerHeatPower + lorawanHeatPower + tradeHeatPower;
                    Double hyWdc = deerWdc + lorawanWdc + tradeWdc;

                    tagHeatNumSum += rlzTag.getValue();
                    hyHeatNumbSum += hyCurHeatNumber;
                    leakageNumSum += rlzTag.getValue() - hyCurHeatNumber;
                    heatPowerSum += hyHeatPower;
                    wdcSum += hyWdc;

                    secondLevelLeakage.setHycurheatnumber(hyCurHeatNumber);
                    secondLevelLeakage.setHyheatpower(hyHeatPower.floatValue());
                    secondLevelLeakage.setHywdc(hyWdc.floatValue());
                    secondLevelLeakage.setTemperature(currentTemperature);
                    secondLevelLeakage.setCurrenttime(new Date());
                    secondLevelLeakage.setLeakagenumber(rlzTag.getValue() - hyCurHeatNumber);
                    logger.debug("------------------------------二级管网漏损分析结果:" + secondLevelLeakage.toString() + "-----------------------------");
                    dataAnalyzeService.saveSecondLeaveLeakage(secondLevelLeakage);
                }
            }
            secondLevelLeakageSum.setCurrenttime(new Date());
            secondLevelLeakageSum.setHycurheatnumbersum(hyHeatNumbSum);
            secondLevelLeakageSum.setHyheatpowersum(heatPowerSum.floatValue());
            secondLevelLeakageSum.setHywdcsum(wdcSum.floatValue());
            secondLevelLeakageSum.setLeakagenumbersum(leakageNumSum);
            secondLevelLeakageSum.setTemperature(currentTemperature);
            secondLevelLeakageSum.setTagcurheatnumersum(tagHeatNumSum);
            //统计存入汇总表
            dataAnalyzeService.saveSecondLeaveLeakageSum(secondLevelLeakageSum);
            logger.debug("=====================================**********二级管网漏损分析汇总结果"+secondLevelLeakageSum.toString()+"***********====================================");
        }
    }
}
