package com.zrdh.service;

import com.zrdh.entity.AlarmConditions;
import com.zrdh.entity.AlarmInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/27 9:48
 */
public interface DeviceInfoService {

    /**
     * 获取开封市实时温度
     * @param date  如果date为null,就查询当前时间
     * @return  温度
     */
    String getCurrentTemperature(Date date);

    /**
     * 根据报警信息条件查询出告警设备基本信息
     * @param alarmConditions
     * @return
     */
    Map<String, List<AlarmInfo>> queryforAlarmInfo(AlarmConditions alarmConditions);
}
