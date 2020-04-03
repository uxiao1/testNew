package com.zrdh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zrdh.dao.dataAnalyze.*;
import com.zrdh.dao.dispatchCenter.TagsMapper;
import com.zrdh.pojo.dataAnalyze.*;
import com.zrdh.pojo.dispatchCenter.Tags;
import com.zrdh.service.DataAnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/4/1 10:34
 */
@Service(interfaceClass = DataAnalyzeService.class)
public class DataAnalyzeServiceImpl implements DataAnalyzeService {

    @Autowired
    private FirstLevelLeakageMapper firstLevelLeakageMapper;
    @Autowired
    private TagsMapper tagsMapper;
    @Autowired
    private HeatstationMapper heatstationMapper;
    @Autowired
    private PlotMapper plotMapper;
    @Autowired
    private CardnumberaddressMapper cardnumberaddressMapper;
    @Autowired
    private SecondLevelLeakageMapper secondLevelLeakageMapper;
    @Autowired
    private SecondLevelLeakageSumMapper secondLevelLeakageSumMapper;

    @Override
    public void saveFirstLevelLeakage(FirstLevelLeakage firstLevelLeakage) {
        firstLevelLeakageMapper.insert(firstLevelLeakage);
    }

    /**
     * //根据换热站id拿到换热站名称
     * //然后根据换热站名称去Heatstation表中拿到换热站对应的hid
     * //然后用hid去匹配plot表,拿到plot的名称
     * //根据plot名称去cardnumberAddress表匹配,拿到房卡号
     * @return
     * @param tagid
     */
    @Override
    public List<Cardnumberaddress> findCardNum4RlzTagId(Integer tagid) {
        Tags tags = tagsMapper.selectByTagId(tagid);        //根据换热站id拿到换热站信息
        if(tags == null){
            return null;
        }
        Heatstation heatstation = heatstationMapper.selectByName(tags.getDevname());        //根据欢乐站名称拿到换热站对应的hid
        if(heatstation == null){
            return null;
        }
        List<Plot> plots = plotMapper.queryByHid(heatstation.getHid());                 //根据hid拿到小区的信息
        if(plots == null){
            return null;
        }
        //根据小区的名称去房卡信息地址表中匹配,拿到房卡号
        List<String> address = new ArrayList<>();
        for (int i = 0; i < plots.size(); i++) {
            String name = plots.get(i).getName();
            address.add(name);
        }
        if(address.isEmpty()){
            return null;
        }
        if (address.size() > 2000) {
            int start = 0;
            int end = 1000;
            List<Cardnumberaddress> cardnumberaddresses = new ArrayList<>();
            while (true) {
                end += end;
                ArrayList<String> tempList = new ArrayList<>();
                if (end > address.size()) {
                    end = address.size();
                }
                for (int i = start; i < end; i++) {
                    tempList.add(address.get(i));
                }
                start = start + end;
                if (!tempList.isEmpty()) {
                    List<Cardnumberaddress> tempResult = cardnumberaddressMapper.selectByBoroughNames(tempList);
                    cardnumberaddresses.addAll(tempResult);
                }
                if (end >= address.size()) {
                    break;
                }
            }
            return cardnumberaddresses;
        }
        List<Cardnumberaddress> cardnumberaddresses = cardnumberaddressMapper.selectByBoroughNames(address);
        return cardnumberaddresses;
    }

    @Override
    public void saveSecondLeaveLeakage(SecondLevelLeakage secondLevelLeakage) {
        secondLevelLeakageMapper.insert(secondLevelLeakage);
    }

    @Override
    public double findDCHeatNumByFirstLevelLeakage(Long beginTime, Long endTime) {
        FirstLevelLeakage beginFirstLeaveLeakage = firstLevelLeakageMapper.selectByNearTime(new Date(beginTime));
        FirstLevelLeakage endFirstLeaveLeakage = firstLevelLeakageMapper.selectByNearTime(new Date(endTime));
        if(beginFirstLeaveLeakage != null && endFirstLeaveLeakage != null) {
            return endFirstLeaveLeakage.getDccurheatnumer() - beginFirstLeaveLeakage.getDccurheatnumer();
        }
        return 0;
    }

    @Override
    public double findRLZHeatNumBySecondLevelLeakage(Long beginTime, Long endTime) {
        //从二级汇总表中取数据
        SecondLevelLeakageSum beginSecondLeaveLeakageSum = secondLevelLeakageSumMapper.selectByTagIds4NearTime(new Date(beginTime));
        SecondLevelLeakageSum endSecondLeaveLeakageSum = secondLevelLeakageSumMapper.selectByTagIds4NearTime(new Date(endTime));
        if(beginSecondLeaveLeakageSum != null && endSecondLeaveLeakageSum != null){
            return endSecondLeaveLeakageSum.getLeakagenumbersum() - beginSecondLeaveLeakageSum.getLeakagenumbersum();
        }
        return 0;
    }

    @Override
    public HashMap<String, ArrayList> findFirstLeakageNumAndTimeByBeginTime2EndTime(Date begin, Date end) {
        List<FirstLevelLeakage> firstLevelLeakageList = firstLevelLeakageMapper.selectBetweenBeginAndEnd(begin,end);
        if(!firstLevelLeakageList.isEmpty()) {
            ArrayList<Double> leakageNumList = new ArrayList<>();
            ArrayList<Date> timeList = new ArrayList<>();
            for (FirstLevelLeakage firstLevelLeakage : firstLevelLeakageList) {
                leakageNumList.add(firstLevelLeakage.getLeakagenumber());
                timeList.add(firstLevelLeakage.getCurrenttime());
            }
            HashMap<String, ArrayList> resultMap = new HashMap<>();
            resultMap.put("leakageNumList",leakageNumList);
            resultMap.put("timeList",timeList);
            return resultMap;
        }
        return null;
    }

    @Override
    public HashMap<String, ArrayList> findSecondLeakageNumAndTimeByBeginTime2EndTime(Date begin, Date end) {
        //从二级漏损汇总表中取数据
        List<SecondLevelLeakageSum> secondLevelLeakageSumList = secondLevelLeakageSumMapper.selectBetweenBeginAndEnd(begin,end);
        if(!secondLevelLeakageSumList.isEmpty()){
            ArrayList<Double> leakageNumList = new ArrayList<>();
            ArrayList<Date> timeList = new ArrayList<>();
            for (SecondLevelLeakageSum leakageSum : secondLevelLeakageSumList) {
                leakageNumList.add(leakageSum.getLeakagenumbersum());
                timeList.add(leakageSum.getCurrenttime());
            }
            HashMap<String, ArrayList> resultMap = new HashMap<>();
            resultMap.put("leakageNumList",leakageNumList);
            resultMap.put("timeList",timeList);
            return resultMap;
        }
        return null;
    }

    @Override
    public HashMap<String, ArrayList> findFirstHeatNumAndTimeByBeginTime2EndTime(Date begin, Date end) {
        List<FirstLevelLeakage> firstLevelLeakageList = firstLevelLeakageMapper.selectBetweenBeginAndEnd(begin,end);
        if(!firstLevelLeakageList.isEmpty()) {
            ArrayList<Double> heatNumList = new ArrayList<>();
            ArrayList<Date> timeList = new ArrayList<>();
            for (FirstLevelLeakage firstLevelLeakage : firstLevelLeakageList) {
                heatNumList.add(firstLevelLeakage.getDccurheatnumer());
                timeList.add(firstLevelLeakage.getCurrenttime());
            }
            HashMap<String, ArrayList> resultMap = new HashMap<>();
            resultMap.put("heatNumList",heatNumList);
            resultMap.put("timeList",timeList);
            return resultMap;
        }
        return null;
    }

    @Override
    public HashMap<String, ArrayList> findSecondHeatNumAndTimeByBeginTime2EndTime(Date begin, Date end) {
        //从二级漏损汇总表中取数据
        List<SecondLevelLeakageSum> secondLevelLeakageSumList = secondLevelLeakageSumMapper.selectBetweenBeginAndEnd(begin,end);
        if(!secondLevelLeakageSumList.isEmpty()){
            ArrayList<Double> heatNumList = new ArrayList<>();
            ArrayList<Float> heatPowerList = new ArrayList<>();
            ArrayList<Float> wdcList = new ArrayList<>();
            ArrayList<Date> timeList = new ArrayList<>();
            for (SecondLevelLeakageSum leakageSum : secondLevelLeakageSumList) {
                heatNumList.add(leakageSum.getTagcurheatnumersum());
                heatPowerList.add(leakageSum.getHyheatpowersum());
                wdcList.add(leakageSum.getHywdcsum());
                timeList.add(leakageSum.getCurrenttime());
            }
            HashMap<String, ArrayList> resultMap = new HashMap<>();
            resultMap.put("heatNumList",heatNumList);
            resultMap.put("heatPowerList",heatPowerList);
            resultMap.put("wdcList",wdcList);
            resultMap.put("timeList",timeList);
            return resultMap;
        }
        return null;
    }

    @Override
    public void saveSecondLeaveLeakageSum(SecondLevelLeakageSum secondLevelLeakageSum) {
        secondLevelLeakageSumMapper.insert(secondLevelLeakageSum);
    }

}
