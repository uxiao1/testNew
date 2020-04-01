package com.zrdh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zrdh.dao.dataAnalyze.HeatstationMapper;
import com.zrdh.dao.dataAnalyze.TraderelatedMapper;
import com.zrdh.dao.dispatchCenter.TagsMapper;
import com.zrdh.dao.dispatchCenterHistory.TbTagHdbTdMapper;
import com.zrdh.dao.tradeSettlement.DevlasteststateMapper;
import com.zrdh.pojo.dataAnalyze.Heatstation;
import com.zrdh.pojo.dataAnalyze.Traderelated;
import com.zrdh.pojo.dispatchCenter.Tags;
import com.zrdh.pojo.tradeSettlement.Devlasteststate;
import com.zrdh.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/31 15:15
 */
@Service(interfaceClass = TradeService.class)
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TraderelatedMapper traderelatedMapper;
    @Autowired
    private HeatstationMapper heatstationMapper;
    @Autowired
    private DevlasteststateMapper devlasteststateMapper;
    @Autowired
    private TagsMapper tagsMapper;
    @Autowired
    private TbTagHdbTdMapper tbTagHdbTdMapper;

    @Override
    public List<Devlasteststate> query4DC() {
        Tags tags = tagsMapper.selectDcInfo();
        Heatstation heatstation = heatstationMapper.selectByName(tags.getDevname());
        List<Traderelated> traderelateds = traderelatedMapper.selectByHid(heatstation.getHid());
        ArrayList<Devlasteststate> resultList = new ArrayList<>();
        if(traderelateds != null){
            for (Traderelated traderelated : traderelateds) {
                String meterid = traderelated.getMeterid();
                Devlasteststate devlasteststate = devlasteststateMapper.selectByMeterNo(meterid);
                resultList.add(devlasteststate);
            }
        }
        return resultList;
    }

    @Override
    public ArrayList<Devlasteststate> query4RLZInfos(Integer tagid) {
        Tags tags = tagsMapper.selectByTagId(tagid);
        ArrayList<Devlasteststate> resultList = new ArrayList<>();
        String devname = tags.getDevname();
        //根据热力站名称去heatstation表中拿到hid
        Heatstation heatstation = heatstationMapper.selectByName(devname);
        //然后再去tradereleate表中取出相关的贸易系统信息
        List<Traderelated> traderelateds = traderelatedMapper.selectByHid(heatstation.getHid());
        //再冲tradereleate表取出meterNo去贸易结构系统视图中查找
        for (Traderelated traderelated : traderelateds) {
            Devlasteststate devlasteststate = devlasteststateMapper.selectByMeterNo(traderelated.getMeterid());
            resultList.add(devlasteststate);
        }
        return resultList;
    }




}
