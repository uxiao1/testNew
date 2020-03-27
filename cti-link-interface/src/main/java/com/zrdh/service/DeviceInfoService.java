package com.zrdh.service;

import java.util.Date;

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

}
