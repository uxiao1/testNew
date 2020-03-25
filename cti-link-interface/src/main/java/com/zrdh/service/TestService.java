package com.zrdh.service;

import java.util.Date;

/**
 * Description: cti-link-dataAnalysis
 * Created by 17645 on 2020/3/24 13:39
 */
public interface TestService {

    String findById(Integer id);

    String getCurrentTemperature(Date date);

}
