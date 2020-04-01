package com.zrdh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zrdh.dao.dataAnalyze.*;
import com.zrdh.dao.dispatchCenter.TagsMapper;
import com.zrdh.pojo.dataAnalyze.*;
import com.zrdh.pojo.dispatchCenter.Tags;
import com.zrdh.service.DataAnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;

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
        Heatstation heatstation = heatstationMapper.selectByName(tags.getDevname());        //根据欢乐站名称拿到换热站对应的hid
        List<Plot> plots = plotMapper.queryByHid(heatstation.getHid());                 //根据hid拿到小区的信息
        //根据小区的名称去房卡信息地址表中匹配,拿到房卡号
        List<Cardnumberaddress> cardnumberaddresses = null;
        for (int i = 0; i < plots.size(); i++) {
            List<Cardnumberaddress> cards = cardnumberaddressMapper.selectByBoroughName(plots.get(i).getName());
            cardnumberaddresses.addAll(cards);
        }
        return cardnumberaddresses;
    }

    @Override
    public void saveSecondLeaveLeakage(SecondLevelLeakage secondLevelLeakage) {
        secondLevelLeakageMapper.insert(secondLevelLeakage);
    }
}
