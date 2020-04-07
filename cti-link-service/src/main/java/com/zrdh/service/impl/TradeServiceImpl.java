package com.zrdh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zrdh.dao.dataAnalyze.HeatstationMapper;
import com.zrdh.dao.dataAnalyze.TraderelatedMapper;
import com.zrdh.dao.dispatchCenter.TagsMapper;
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

    @Override
    public List<Devlasteststate> query4DC() {
        Tags tags = tagsMapper.selectDcInfo();
        Heatstation heatstation = heatstationMapper.selectByName(tags.getDevname());
        if(heatstation == null) {
            return null;
        }
        List<Traderelated> traderelateds = traderelatedMapper.selectByHid(heatstation.getHid());
        if(traderelateds == null) {
            return null;
        }
        ArrayList<String> meterNoList = new ArrayList<>();
        if(traderelateds != null && !traderelateds.isEmpty()){
            for (Traderelated traderelated : traderelateds) {
                String meterid = traderelated.getMeterid();
                meterNoList.add(meterid);
            }
        }
        if(meterNoList == null || meterNoList.isEmpty()){
            return null;
        }
        if (meterNoList.size() > 2000){
            int start = 0;
            int end = 1000;
            List<Devlasteststate> devlasteststateList = new ArrayList<>();
            while (true) {
                end += end;
                ArrayList<String> tempList = new ArrayList<>();
                if (end > meterNoList.size()) {
                    end = meterNoList.size();
                }
                for (int i = start; i < end; i++) {
                    tempList.add(meterNoList.get(i));
                }
                start = start + end;
                if(tempList != null && !tempList.isEmpty()) {
                    List<Devlasteststate> tempResult = devlasteststateMapper.selectByMeterNos(tempList);
                    devlasteststateList.addAll(tempResult);
                }
                if (end >= meterNoList.size()){
                    break;
                }
            }
            return devlasteststateList;
        }
        List<Devlasteststate> devlasteststateList = devlasteststateMapper.selectByMeterNos(meterNoList);
        return devlasteststateList;
    }

    @Override
    public ArrayList<Devlasteststate> query4RLZInfos(Integer tagid) {
        Tags tags = tagsMapper.selectByTagId(tagid);
        String devname = tags.getDevname();
        //根据热力站名称去heatstation表中拿到hid
        Heatstation heatstation = heatstationMapper.selectByName(devname);
        //然后再去tradereleate表中取出相关的贸易系统信息
        List<Traderelated> traderelateds = traderelatedMapper.selectByHid(heatstation.getHid());
        //再冲tradereleate表取出meterNo去贸易结构系统视图中查找
        ArrayList<String> meterNoList = new ArrayList<>();
        for (Traderelated traderelated : traderelateds) {
            String meterNo = traderelated.getMeterid();
            meterNoList.add(meterNo);
        }
        if(meterNoList == null || meterNoList.isEmpty()){
            return null;
        }
        if (meterNoList.size() > 2000){
            int start = 0;
            int end = 1000;
            ArrayList<Devlasteststate> devlasteststateList = new ArrayList<>();
            while (true) {
                end += end;
                ArrayList<String> tempList = new ArrayList<>();
                if (end > meterNoList.size()) {
                    end = meterNoList.size();
                }
                for (int i = start; i < end; i++) {
                    tempList.add(meterNoList.get(i));
                }
                start = start + end;
                if(tempList != null && !tempList.isEmpty()) {
                    ArrayList<Devlasteststate> tempResult = devlasteststateMapper.selectByMeterNos(tempList);
                    devlasteststateList.addAll(tempResult);
                }
                if (end >= meterNoList.size()){
                    break;
                }
            }
            return devlasteststateList;
        }
        ArrayList<Devlasteststate> devlasteststateList = devlasteststateMapper.selectByMeterNos(meterNoList);
        return devlasteststateList;
    }




}
