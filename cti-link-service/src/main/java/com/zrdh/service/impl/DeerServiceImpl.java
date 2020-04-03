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
        ArrayList<Integer> cardNumberList = new ArrayList<>();
        for (Cardnumberaddress cardnumberaddress : cardnumberaddresses) {
            String cardnum = cardnumberaddress.getcCardnum();
            int cardNumber = Integer.parseInt(cardnum);
            cardNumberList.add(cardNumber);
        }
        if(cardNumberList.isEmpty()){
            return null;
        }
        // in(param)最大不能超过2000左右
        if (cardNumberList.size() > 2000){
            int start = 0;
            int end = 1000;
            List<VmAmeterRlgs> vmAmeterRlgsList = new ArrayList<>();
            while (true) {
                end += end;
                ArrayList<Integer> tempList = new ArrayList<>();
                if (end > cardNumberList.size()) {
                    end = cardNumberList.size();
                }
                for (int i = start; i < end; i++) {
                    tempList.add(cardNumberList.get(i));
                }
                start = start + end;
                if(!tempList.isEmpty()) {
                    List<VmAmeterRlgs> tempResult = vmAmeterRlgsMapper.selectBySfbm(tempList);
                    vmAmeterRlgsList.addAll(tempResult);
                }
                if (end >= cardNumberList.size()){
                    break;
                }
            }
            return vmAmeterRlgsList;
        }else {
            List<VmAmeterRlgs> vmAmeterRlgs = vmAmeterRlgsMapper.selectBySfbm(cardNumberList);
            return vmAmeterRlgs;
        }
    }
}
