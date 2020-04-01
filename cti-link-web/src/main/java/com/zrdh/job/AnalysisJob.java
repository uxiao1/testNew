package com.zrdh.job;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zrdh.pojo.dataAnalyze.Cardnumberaddress;
import com.zrdh.pojo.dataAnalyze.FirstLevelLeakage;
import com.zrdh.pojo.dataAnalyze.SecondLevelLeakage;
import com.zrdh.pojo.dispatchCenterHistory.TbTagHdbTd;
import com.zrdh.pojo.lorawanUser.HmNormaldecodedata;
import com.zrdh.pojo.nbUser.VmAmeterRlgs;
import com.zrdh.pojo.tradeSettlement.Devlasteststate;
import com.zrdh.service.*;

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

    /**
     * 一级管网自动分析漏损
     */
    public void firstLeaveLeakage(){
        System.out.println("---------------------一级管网漏损分析----------------------");
        //电厂
        TbTagHdbTd dcTag = dispatchService.selectDcHeatNumber();
        //所有热力站最新数据
        List<TbTagHdbTd> rlzTags = dispatchService.selectRLZTag();
        Double rlzHeatNumbSum = 0.00;   //所有热力站总热力值
        for (TbTagHdbTd rlzTag : rlzTags) {
            rlzHeatNumbSum += rlzTag.getValue();
        }
        //TODO 贸易中心数据有可能是直接对应电厂的
        //得到上级是电厂的贸易中心数据
        List<Devlasteststate> devlasteststateList = tradeService.query4DC();
        Double tradeHeatNumSum = 0.00;
        for (Devlasteststate devlasteststate : devlasteststateList) {
            tradeHeatNumSum += devlasteststate.getCurheatnum();
        }
        //实时温度
        String currentTemperature = deviceInfoService.getCurrentTemperature(new Date());
        FirstLevelLeakage firstLevelLeakage = new FirstLevelLeakage();
        firstLevelLeakage.setDcid(dcTag.getTagid());
        firstLevelLeakage.setDccurheatnumer(dcTag.getValue());
        firstLevelLeakage.setRlzcurheatnumber(rlzHeatNumbSum);
        firstLevelLeakage.setLeakagenumber(dcTag.getValue() - rlzHeatNumbSum - tradeHeatNumSum);
        firstLevelLeakage.setTemperature(currentTemperature);
        firstLevelLeakage.setCurrenttime(new Date());
        dataAnalyzeService.saveFirstLevelLeakage(firstLevelLeakage);
    }

    /**
     * 二级管网自动分析漏损
     */
    public void secondLeaveLeakage(){
        System.out.println("----------------------二级管网漏损分析----------------------");
        //所有热力站最新数据
        List<TbTagHdbTd> rlzTags = dispatchService.selectRLZTag();
        for (TbTagHdbTd rlzTag : rlzTags) {
            SecondLevelLeakage secondLevelLeakage = new SecondLevelLeakage();
            secondLevelLeakage.setTagid(rlzTag.getTagid());
            secondLevelLeakage.setTagcurheatnumer(rlzTag.getValue());
            //拿到该热力站所对应的全部房卡号信息(全部系统的房卡号信息)
            List<Cardnumberaddress> cardnumberaddresses = dataAnalyzeService.findCardNum4RlzTagId(rlzTag.getTagid());
            //根据房卡信息拿到德尔系统对应的信息
            List<VmAmeterRlgs> deers = deerService.queryDeer4CardNumber(cardnumberaddresses);
            Double deerCurHeatNumber = 0.00;    //热力值
            Double deerHeatPower = 0.00;        //功率
            Double deerWdc = 0.00;              //温差
            for (VmAmeterRlgs deer : deers) {
                deerCurHeatNumber += deer.getDqrl();
                deerHeatPower += deer.getGl();
                deerWdc += deer.getWdc();
            }
            //根据房卡信息拿到lorawan系统对应的信息
            List<HmNormaldecodedata> lorawans = lorawanService.query4HouseCard(cardnumberaddresses);
            Double lorawanCurHeatNumber = 0.00;
            Double lorawanHeatPower = 0.00;
            Double lorawanWdc = 0.00;
            for (HmNormaldecodedata lorawan : lorawans) {
                lorawanCurHeatNumber += lorawan.getCurrentheatnumber();
                lorawanHeatPower += lorawan.getHeatpower();
                lorawanWdc += lorawan.getWdc();
            }
            //贸易系统的数据
            ArrayList<Devlasteststate> devlasteststates = tradeService.query4RLZInfos(rlzTag.getTagid());
            Double tradeCurHeatNumber = 0.00;
            Double tradeHeatPower = 0.00;
            Double tradeWdc = 0.00;
            for (Devlasteststate devlasteststate : devlasteststates) {
                tradeCurHeatNumber += devlasteststate.getCurheatnum();
                tradeHeatPower += devlasteststate.getHeatpower();
                tradeWdc += devlasteststate.getSupplywatertmp() - devlasteststate.getReturnwatertmp();
            }

            //热力站对应的三大系统的总热力值
            Double hyCurHeatNumber = deerCurHeatNumber + lorawanCurHeatNumber + tradeCurHeatNumber;
            Double hyHeatPower = deerHeatPower + lorawanHeatPower + tradeHeatPower;
            Double hyWdc = deerWdc + lorawanWdc + tradeWdc;
            secondLevelLeakage.setHycurheatnumber(hyCurHeatNumber);
            secondLevelLeakage.setHyheatpower(hyHeatPower.floatValue());
            secondLevelLeakage.setHywdc(hyWdc.floatValue());
            //实时温度
            String currentTemperature = deviceInfoService.getCurrentTemperature(new Date());
            secondLevelLeakage.setTemperature(currentTemperature);
            secondLevelLeakage.setCurrenttime(new Date());
            dataAnalyzeService.saveSecondLeaveLeakage(secondLevelLeakage);
        }
    }
}
