package com.zrdh.service;

import com.zrdh.pojo.dataAnalyze.Cardnumberaddress;
import com.zrdh.pojo.nbUser.VmAmeterRlgs;

import java.util.List;

/**
 * Description: cti-link-dataAnalysis
 * 德尔系统(nb)服务
 * Created by hua on 2020/3/31 15:09
 */
public interface DeerService {

    List<VmAmeterRlgs> queryDeer4CardNumber(List<Cardnumberaddress> cardnumberaddresses);
}
