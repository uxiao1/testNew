package com.zrdh.service;

import com.zrdh.pojo.dataAnalyze.Cardnumberaddress;
import com.zrdh.pojo.lorawanUser.HmNormaldecodedata;

import java.util.List;

/**
 * Description: cti-link-dataAnalysis
 * lorawan系统服务
 * Created by hua on 2020/3/31 15:09
 */
public interface LorawanService {
    List<HmNormaldecodedata> query4HouseCard(List<Cardnumberaddress> cardnumberaddresses);
}
