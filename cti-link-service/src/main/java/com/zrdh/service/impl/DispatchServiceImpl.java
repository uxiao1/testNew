package com.zrdh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zrdh.dao.dispatchCenter.TagsMapper;
import com.zrdh.dao.dispatchCenterHistory.TbTagHdbTdMapper;
import com.zrdh.pojo.dispatchCenter.Tags;
import com.zrdh.pojo.dispatchCenterHistory.TbTagHdbTd;
import com.zrdh.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/31 15:15
 */
@Service(interfaceClass = DispatchService.class)
public class DispatchServiceImpl implements DispatchService {

    @Autowired
    private TagsMapper tagsMapper;
    @Autowired
    private TbTagHdbTdMapper tbTagHdbTdMapper;

    @Override
    public TbTagHdbTd selectDcHeatNumber() {
        //查询电厂id
        Integer dcId = tagsMapper.selectDCId();
        List<TbTagHdbTd> dcInfoList = tbTagHdbTdMapper.selectByTagId(dcId);
        return getRecentData(dcInfoList);
    }



    @Override
    public List<TbTagHdbTd> selectRLZTag() {
        List<TbTagHdbTd> tbTagHdbTds = new ArrayList<TbTagHdbTd>();
        //查询所有热力站信息
        List<Tags> rlzInfos = tagsMapper.selectRLZInfos();
        for (Tags rlzInfo : rlzInfos) {
            List<TbTagHdbTd> rlzInfoList = tbTagHdbTdMapper.selectByTagId(rlzInfo.getId());
            if(rlzInfoList != null){
                tbTagHdbTds.add(getRecentData(rlzInfoList));
            }
        }
        return tbTagHdbTds;
    }


    /**
     * 取出最近的一条数据
     * @param tbTagHdbTds
     * @return
     */
    private TbTagHdbTd getRecentData(List<TbTagHdbTd> tbTagHdbTds) {
        if(tbTagHdbTds != null){
            Collections.sort(tbTagHdbTds, new Comparator<TbTagHdbTd>() {
                @Override
                public int compare(TbTagHdbTd o1, TbTagHdbTd o2) {
                    return o2.getDbtime().compareTo(o1.getDbtime());
                }
            });
            return tbTagHdbTds.get(0);
        }
        return null;
    }
}
