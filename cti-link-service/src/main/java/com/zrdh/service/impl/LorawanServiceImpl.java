package com.zrdh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zrdh.dao.lorawanUser.HmNormaldecodedataMapper;
import com.zrdh.pojo.dataAnalyze.Cardnumberaddress;
import com.zrdh.pojo.lorawanUser.HmNormaldecodedata;
import com.zrdh.service.LorawanService;
import com.zrdh.utils.LorawanPartition;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/31 15:15
 */
@Service(interfaceClass = LorawanService.class)
public class LorawanServiceImpl implements LorawanService {

    @Autowired
    private HmNormaldecodedataMapper hmNormaldecodedataMapper;

    @Override
    public List<HmNormaldecodedata> query4HouseCard(List<Cardnumberaddress> cardnumberaddresses) {
        if(cardnumberaddresses == null) {
            return null;
        }
        String partition = LorawanPartition.getPartitionByDate(new Date());
        ArrayList<String> cardNumberList = new ArrayList<>();
        for (Cardnumberaddress cardnumberaddress : cardnumberaddresses) {
            String cardnum = cardnumberaddress.getcCardnum();
            cardNumberList.add(cardnum);
        }
        if(cardNumberList.isEmpty()){
            return null;
        }
        List<HmNormaldecodedata> hmNormaldecodedata = hmNormaldecodedataMapper.selectByHouseCard(cardNumberList,partition);
        return hmNormaldecodedata;
    }
}
