package com.zrdh.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zrdh.entity.AlarmConditions;
import com.zrdh.entity.AlarmInfo;
import com.zrdh.entity.Result;
import com.zrdh.service.DataAnalyzeService;
import com.zrdh.service.DeviceInfoService;
import com.zrdh.service.DispatchService;
import com.zrdh.service.TradeService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/26 15:32
 */
@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {

    @Reference
    private DeviceInfoService deviceInfoService;
    @Reference
    private DispatchService dispatchService;
    @Reference
    private TradeService tradeService;
    @Reference
    private DataAnalyzeService dataAnalyzeService;

    /**
     * 根据告警条件推送告警信息
     */
    @PostMapping("/queryAlarmInformation")
    public Result queryAlarmInformation(@RequestBody(required = false) AlarmConditions alarmConditions){
        Result result = new Result();
        try {
            result.setRstCode(0);
            Map<String, List<AlarmInfo>> resultMap = deviceInfoService.queryforAlarmInfo(alarmConditions);
            result.setRstData(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            result.setRstCode(1);
            result.setRstMsg("接口出错,请重试");
        }
        return result;
    }

    /**
     * 提供各级设备的用量/瞬时热量/温差曲线以及开封市实时温度曲线
     * 未填写默认最近24小时
     */
    @GetMapping("/queryDeviceInfoCurve")
    public Result queryDeviceInfoCurve(@RequestParam(required = false) Long beginTime,@RequestParam(required = false) Long endTime){
        Result result = new Result();
        try {
            result.setRstCode(0);
            HashMap<String, Object> data = new HashMap<>();
            //----------------------------一级设备查询----------------------------
            //取定时任务存的表的数据
            //----------------------------二级设备查询-----------------------------

            //--------------------------开封市实时温度----------------------------

            result.setRstData(data);
        } catch (Exception e) {
            e.printStackTrace();
            result.setRstCode(1);
        }
        return result;
    }

    /**
     * 提供各级设备指定时间段用量
     * 时间限制为定时任务开始时间
     */
    @GetMapping("/queryDeviceCurrentHeatNumberInfo")
    public Result queryDeviceCurrentHeatNumberInfo(@RequestParam(required = false) Long beginTime,@RequestParam(required = false) Long endTime){
        if(beginTime == null){
            beginTime = new Date().getTime() - 24*60*60*1000;
        }
        if(endTime == null){
            endTime = new Date().getTime();
        }
        Result result = new Result();
        try {
            result.setRstCode(0);
            //电厂(即一级)指定时间段内用量
            double dcHeatNum = dataAnalyzeService.findDCHeatNumByFirstLevelLeakage(beginTime, endTime);
            //热力站和部分上级为电厂的贸易系统在指定时间段内的用量,定时任务表中已经计算了
            double rlzHeatnum = dataAnalyzeService.findRLZHeatNumBySecondLevelLeakage(beginTime, endTime);
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("firstDCHeatNum",dcHeatNum);
            resultMap.put("secondRLZHeatNum",rlzHeatnum);
            result.setRstData(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            result.setRstCode(1);
        }
        return result;
    }

    /**
     * 提供一二级管网漏损的曲线图
     * 曲线需要返回漏损值和漏损值对应的时间
     * 未填写默认2最近4小时
     */
    @GetMapping("/queryFirstAndSecondLeakage")
    public Result queryFirstAndSecondLeakage(@RequestParam(required = false) Long beginTime,@RequestParam(required = false) Long endTime){
        if(beginTime == null){
            beginTime = new Date().getTime() - 24*60*60*1000;
        }
        if(endTime == null){
            endTime = new Date().getTime();
        }
        Result result = new Result();
        try {
            result.setRstCode(0);
            //电厂(一级)漏损值和时间
            dataAnalyzeService.findLeakageNumAndTimeByBeginTime2EndTime(new Date(beginTime),new Date(endTime));
        } catch (Exception e) {
            e.printStackTrace();
            result.setRstCode(1);
        }
        return result;
    }
}
