package com.zrdh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zrdh.constant.TagsExcludeConstant;
import com.zrdh.dao.dataAnalyze.*;
import com.zrdh.dao.dispatchCenter.TagsMapper;
import com.zrdh.pojo.dataAnalyze.*;
import com.zrdh.pojo.dispatchCenter.Tags;
import com.zrdh.service.DataAnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
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
        List<Cardnumberaddress> cardnumberaddresses = cardnumberaddressMapper.selectByBoroughNames(address);
        return cardnumberaddresses;
    }

    @Override
    public void saveSecondLeaveLeakage(SecondLevelLeakage secondLevelLeakage) {
        secondLevelLeakageMapper.insert(secondLevelLeakage);
    }

    @Override
    public double findDCHeatNumByFirstLevelLeakage(Long beginTime, Long endTime) {
        //TODO sql待完成
        FirstLevelLeakage beginFirstLeaveLeakage = firstLevelLeakageMapper.selectByNearTime(new Date(beginTime));
        FirstLevelLeakage endFirstLeaveLeakage = firstLevelLeakageMapper.selectByNearTime(new Date(endTime));
        if(beginFirstLeaveLeakage != null && endFirstLeaveLeakage != null) {
            return endFirstLeaveLeakage.getDccurheatnumer() - beginFirstLeaveLeakage.getDccurheatnumer();
        }
        return 0;
    }

    @Override
    public double findRLZHeatNumBySecondLevelLeakage(Long beginTime, Long endTime) {
        List<Tags> tags = tagsMapper.selectRLZInfos(TagsExcludeConstant.NOT_BELONG_RLZ_ID);
        if(tags != null){
            ArrayList<Integer> tagIds = new ArrayList<>();
            for (Tags tag : tags) {
                tagIds.add(tag.getId());
            }
            //TODO sql待完成
            List<SecondLevelLeakage> beginSecondLeaveLeakage = secondLevelLeakageMapper.selectByTagIds4NearTime(tagIds,new Date(beginTime));
            List<SecondLevelLeakage> endSecondLeaveLeakage = secondLevelLeakageMapper.selectByTagIds4NearTime(tagIds,new Date(endTime));
            if(!beginSecondLeaveLeakage.isEmpty() && !endSecondLeaveLeakage.isEmpty()){
                double beginHeatNumSum = 0;
                for (SecondLevelLeakage levelLeakage : beginSecondLeaveLeakage) {
                    beginHeatNumSum += levelLeakage.getTagcurheatnumer();
                }
                double endHeatNumSum = 0;
                for (SecondLevelLeakage levelLeakage : endSecondLeaveLeakage) {
                    endHeatNumSum += levelLeakage.getTagcurheatnumer();
                }
                return endHeatNumSum - beginHeatNumSum;
            }
        }
        return 0;
    }

    @Override
    public void findLeakageNumAndTimeByBeginTime2EndTime(Date begin, Date end) {

    }

}
