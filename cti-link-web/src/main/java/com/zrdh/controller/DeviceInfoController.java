package com.zrdh.controller;

import com.zrdh.entity.AlarmConditions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/26 15:32
 */
@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {

    /**
     * 根据告警条件推送告警信息
     */
    @PostMapping("/queryAlarmInformation")
    public void queryAlarmInformation(@RequestBody(required = false) AlarmConditions alarmConditions){

    }

}
