package com.zrdh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.zrdh.dao.dispatchCenter.TagsMapper;
import com.zrdh.dao.dispatchCenterHistory.TbTagHdbTdMapper;
import com.zrdh.dao.lorawanUser.HmNormaldecodedataMapper;
import com.zrdh.dao.nbUser.VmAmeterRlgsMapper;
import com.zrdh.dao.tradeSettlement.DevlasteststateMapper;
import com.zrdh.entity.AlarmConditions;
import com.zrdh.entity.AlarmInfo;
import com.zrdh.pojo.lorawanUser.HmNormaldecodedata;
import com.zrdh.pojo.nbUser.VmAmeterRlgs;
import com.zrdh.pojo.tradeSettlement.Devlasteststate;
import com.zrdh.service.DeviceInfoService;
import com.zrdh.utils.HttpClientUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/27 9:49
 */
@Service(interfaceClass = DeviceInfoService.class)
public class DeviceInfoServiceImpl implements DeviceInfoService {

    @Autowired
    private TagsMapper tagsMapper;  //调度中心中自系统
    @Autowired
    private TbTagHdbTdMapper tbTagHdbTdMapper;
    @Autowired
    private HmNormaldecodedataMapper normaldecodedataMapper; //lorawan系统
    @Autowired
    private DevlasteststateMapper devlasteststateMapper; //贸易结算系统
    @Autowired
    private VmAmeterRlgsMapper vmAmeterRlgsMapper; //德尔系统(nb)

    @Override
    public String getCurrentTemperature(Date date) {
        Date currentDate = new Date();
        if(date != null){
            currentDate = date;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = simpleDateFormat.format(currentDate);
        String returnJson = HttpClientUtil.httpGet("http://api.k780.com:88/?app=weather.history&weaid=kaifeng&date="+formatDate+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json", null);
        String temperature = "";
        Gson gson = new Gson();
        HashMap temperatureMap = gson.fromJson(returnJson, HashMap.class);
        if(!temperatureMap.isEmpty()){
            ArrayList<LinkedTreeMap<String,String>> result = (ArrayList<LinkedTreeMap<String, String>>) temperatureMap.get("result");
            ArrayList<HashMap<String,String>> diffTime = new ArrayList<HashMap<String,String>>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (LinkedTreeMap<String, String> map : result) {
                try {
                    Date uptime = dateFormat.parse(map.get("uptime"));
                    long abs = Math.abs(currentDate.getTime() - uptime.getTime());
                    HashMap<String, String> tempMap = new HashMap<>();
                    tempMap.put("temp",map.get("temp"));
                    tempMap.put("diffTime",abs+"");
                    diffTime.add(tempMap);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if(!diffTime.isEmpty()){
                Collections.sort(diffTime, new Comparator<HashMap<String, String>>() {
                    @Override
                    public int compare(HashMap<String, String> o1, HashMap<String, String> o2) {
                        return Integer.parseInt(o1.get("diffTime"))-Integer.parseInt(o2.get("diffTime"));
                    }
                });
                for (HashMap<String, String> map : diffTime) {
                    return map.get("temp");
                }
            }
        }
        return temperature;
    }

    @Override
    public Map<String,List<AlarmInfo>> queryforAlarmInfo(AlarmConditions alarmConditions) {
        if(alarmConditions == null){
            return null;
        }
        HashMap<String, List<AlarmInfo>> resultMap = new HashMap<>();
        //---------------------------lorawan系统-----------------------------
        List<HmNormaldecodedata> normaldecodedataList = normaldecodedataMapper.selectByAlarmConditions(alarmConditions);
        List<AlarmInfo> lorawanList = new ArrayList<>();
        BeanUtils.copyProperties(normaldecodedataList,lorawanList);
        resultMap.put("loranwan",lorawanList);

        //---------------------------贸易结算系统    TODO 字段名还未调整----------------------
        List<Devlasteststate> devlasteststateList = devlasteststateMapper.selectByAlarmCoditions(alarmConditions);
        //添加入集合

        //----------------------------deer(nb)系统--------------------------------
        List<VmAmeterRlgs> vmAmeterRlgsList = vmAmeterRlgsMapper.selectByAlarmConditions(alarmConditions);
        List<AlarmInfo> deerList = new ArrayList<>();
        for (VmAmeterRlgs vmAmeterRlgs : vmAmeterRlgsList) {
            AlarmInfo deer = new AlarmInfo();
            deer.setMeterno(vmAmeterRlgs.getMeter_no());
            deer.setCurrentheatnumber(vmAmeterRlgs.getDqrl());
            deer.setFlowrate(vmAmeterRlgs.getLs());
            deer.setHeatpower(vmAmeterRlgs.getGl());
            deer.setReturnwatertemperature(vmAmeterRlgs.getHswd());
            deer.setSupplywatertemperature(vmAmeterRlgs.getGswd());
            deer.setTotalflow(vmAmeterRlgs.getLjll());
            deer.setWdc(vmAmeterRlgs.getWdc());
            deer.setCurrentTime(vmAmeterRlgs.getCjq_time());
            deerList.add(deer);
        }
        resultMap.put("deer",deerList);
        //
        return resultMap;
    }

}
