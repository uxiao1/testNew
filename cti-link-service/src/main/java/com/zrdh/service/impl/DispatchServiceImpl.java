package com.zrdh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zrdh.constant.TagsExcludeConstant;
import com.zrdh.dao.dispatchCenter.TagsMapper;
import com.zrdh.dao.dispatchCenterHistory.TbTagHdbTdMapper;
import com.zrdh.pojo.dispatchCenter.Tags;
import com.zrdh.pojo.dispatchCenterHistory.TbTagHdbTd;
import com.zrdh.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        TbTagHdbTd dcInfoList = tbTagHdbTdMapper.selectByTagId(dcId);
        return dcInfoList;
    }



    @Override
    public List<TbTagHdbTd> selectRLZTag() {
        //查询所有热力站信息
        List<Tags> rlzInfos = tagsMapper.selectRLZInfos(TagsExcludeConstant.NOT_BELONG_RLZ_ID);
        List<Integer> ids = new ArrayList<>();
        for (Tags rlzInfo : rlzInfos) {
            ids.add(rlzInfo.getId());
        }
        if(ids.isEmpty()){
            return null;
        }
        List<TbTagHdbTd> rlzInfoList = tbTagHdbTdMapper.selectByTagIds(ids);
        return rlzInfoList;
    }

    @Override
    public double findDCHeatNumByBeginTimeAndEndTime(Long beginTime, Long endTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM");
        Integer dcId = tagsMapper.selectDCId();
        String beginFormat = dateFormat.format(beginTime);
        String begintableName = "tb_tag_hdb_"+beginFormat;
        TbTagHdbTd dcBeginInfo = tbTagHdbTdMapper.findHistoryByTagId(dcId,begintableName,new Date(beginTime));
        String endFormat = dateFormat.format(endTime);
        String endTableName = "tb_tag_hdb_"+endFormat;
        TbTagHdbTd dcEndInfo = tbTagHdbTdMapper.findHistoryByTagId(dcId,endTableName,new Date(endTime));
        if(dcBeginInfo != null && dcEndInfo != null){
            return dcEndInfo.getValue() - dcBeginInfo.getValue();
        }
        return 0;
    }

    @Override
    public double findRLZHeatNumByBeginTimeAndEndTime(Long beginTime, Long endTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM");
        List<Tags> rlzInfos = tagsMapper.selectRLZInfos(TagsExcludeConstant.NOT_BELONG_RLZ_ID);
        if(rlzInfos == null){
            return 0;
        }
        ArrayList<Integer> tagsIds = new ArrayList<>();
        for (Tags rlzInfo : rlzInfos) {
            tagsIds.add(rlzInfo.getId());
        }
        String beginFormat = dateFormat.format(beginTime);
        String begintableName = "tb_tag_hdb_"+beginFormat;
        List<TbTagHdbTd> beginTbTagHdbTds = tbTagHdbTdMapper.findHistoryByTagIds(tagsIds,begintableName,beginTime);
        String endFormat = dateFormat.format(endTime);
        String endTableName = "tb_tag_hdb_"+endFormat;
        List<TbTagHdbTd> endTbTagHdbTds = tbTagHdbTdMapper.findHistoryByTagIds(tagsIds,endTableName,endTime);
        if(beginTbTagHdbTds != null && endTbTagHdbTds != null) {
            Double beginHeatNum = 0.00;
            for (TbTagHdbTd beginTbTagHdbTd : beginTbTagHdbTds) {
                beginHeatNum += beginTbTagHdbTd.getValue();
            }
            Double endHeatNum = 0.00;
            for (TbTagHdbTd endTbTagHdbTd : endTbTagHdbTds) {
                endHeatNum += endTbTagHdbTd.getValue();
            }
            return endHeatNum - beginHeatNum;
        }

        return 0;
    }

}
