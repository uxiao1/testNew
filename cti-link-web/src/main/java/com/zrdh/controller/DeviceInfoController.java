package com.zrdh.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zrdh.entity.AlarmConditions;
import com.zrdh.entity.Result;
import com.zrdh.service.DeviceInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/26 15:32
 */
@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {

    @Reference
    private DeviceInfoService deviceInfoService;

    /**
     * 根据告警条件推送告警信息
     */
    @PostMapping("/queryAlarmInformation")
    public Result queryAlarmInformation(@RequestBody(required = false) AlarmConditions alarmConditions){
        Result result = new Result();
        try {
            result.setRstCode(0);

        } catch (Exception e) {
            e.printStackTrace();
            result.setRstCode(1);
        }
        return result;
    }

    /**
     * 提供各级设备的用量/瞬时热量/温差曲线以及开封市实时温度曲线
     */
    @GetMapping("/queryDeviceInfoCurve")
    public Result queryDeviceInfoCurve(){
        Result result = new Result();
        try {
            result.setRstCode(0);
            HashMap<String, Object> data = new HashMap<>();
            //----------------------------一级设备查询----------------------------
            //先查询所有一级设备,存入数组
            //遍历数组,查询对应的用量,瞬时热量,温差分别存入数组
            //----------------------------二级设备查询-----------------------------
            //先查询所有二级设备,存入数组
            //遍历数组,查询对应的用量,瞬时热量,温差分别存入数组
            //--------------------------开封市实时温度查询----------------------------
            String currentTemperature = deviceInfoService.getCurrentTemperature(null);
            data.put("currentTemperature",currentTemperature);
            result.setRstData(data);
        } catch (Exception e) {
            e.printStackTrace();
            result.setRstCode(1);
        }
        return result;
    }

    /**
     * 提供各级设备指定时间段用量
     */
    @GetMapping("/queryDeviceCurrentHeatNumberInfo")
    public Result queryDeviceCurrentHeatNumberInfo(@RequestParam(required = false) Long beginTime,@RequestParam(required = false) Long endTime){
        Result result = new Result();
        try {
            result.setRstCode(0);

        } catch (Exception e) {
            e.printStackTrace();
            result.setRstCode(1);
        }
        return result;
    }

    /**
     * 提供一二级管网漏损
     */
    @GetMapping("/queryFirstAndSecondLeakage")
    public Result queryFirstAndSecondLeakage(@RequestParam(required = false) Long beginTime,@RequestParam(required = false) Long endTime){
        Result result = new Result();
        try {
            result.setRstCode(0);

        } catch (Exception e) {
            e.printStackTrace();
            result.setRstCode(1);
        }
        return result;
    }
}
