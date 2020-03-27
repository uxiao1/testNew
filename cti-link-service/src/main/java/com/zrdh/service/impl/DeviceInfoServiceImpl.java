package com.zrdh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.zrdh.service.DeviceInfoService;
import com.zrdh.utils.HttpClientUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/27 9:49
 */
@Service(interfaceClass = DeviceInfoService.class)
public class DeviceInfoServiceImpl implements DeviceInfoService {

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
}
