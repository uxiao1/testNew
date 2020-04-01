package com.zrdh.service;

import com.zrdh.pojo.dataAnalyze.Cardnumberaddress;
import com.zrdh.pojo.dataAnalyze.FirstLevelLeakage;
import com.zrdh.pojo.dataAnalyze.SecondLevelLeakage;

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
}
