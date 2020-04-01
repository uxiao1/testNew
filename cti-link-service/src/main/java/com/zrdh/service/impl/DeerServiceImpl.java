package com.zrdh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zrdh.dao.nbUser.VmAmeterRlgsMapper;
import com.zrdh.pojo.dataAnalyze.Cardnumberaddress;
import com.zrdh.pojo.nbUser.VmAmeterRlgs;
import com.zrdh.service.DeerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/31 15:15
 */
@Service(interfaceClass = DeerService.class)
public class DeerServiceImpl implements DeerService {

    @Autowired
    private VmAmeterRlgsMapper vmAmeterRlgsMapper;

    @Override
    public List<VmAmeterRlgs> queryDeer4CardNumber(List<Cardnumberaddress> cardnumberaddresses) {
        if(cardnumberaddresses == null){
            return null;
        }
        ArrayList<VmAmeterRlgs> deerList = new ArrayList<>();
        for (Cardnumberaddress cardnumberaddress : cardnumberaddresses) {
            String cardnum = cardnumberaddress.getcCardnum();
            int cardNumber = Integer.parseInt(cardnum);
            VmAmeterRlgs vmAmeterRlgs = vmAmeterRlgsMapper.selectBySfbm(cardNumber);
            if(vmAmeterRlgs != null){
                deerList.add(vmAmeterRlgs);
            }
        }
        return deerList;
    }
}
