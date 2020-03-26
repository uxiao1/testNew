package com.zrdh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.zrdh.dao.lorawanUser.HmOrigindataMapper;
import com.zrdh.dao.nbUser.TestNameMapper;
import com.zrdh.dao.tradeSettlement.DevlasteststateMapper;
import com.zrdh.pojo.lorawanUser.HmOrigindata;
import com.zrdh.pojo.tradeSettlement.Devlasteststate;
import com.zrdh.pojo.tradeSettlement.DevlasteststateKey;
import com.zrdh.service.TestService;
import com.zrdh.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description: cti-link-dataAnalysis
 * Created by 17645 on 2020/3/24 13:42
 */
@Service(interfaceClass = TestService.class)
public class TestServiceImpl implements TestService {

    @Autowired
    private HmOrigindataMapper hmOrigindataMapper;
    @Autowired
    private TestNameMapper testNameMapper;
    @Autowired
    private DevlasteststateMapper devlasteststateMapper;

    @Override
    public String findById(Integer id) {
        HmOrigindata hmOrigindata = hmOrigindataMapper.selectByDataId(1);
        HashMap<String,Object> testName = testNameMapper.findById("000054137");
        DevlasteststateKey devlasteststateKey = new DevlasteststateKey();
        devlasteststateKey.setDtuid("000");
        devlasteststateKey.setDevname("000");
        Devlasteststate devlasteststate = devlasteststateMapper.selectByPrimaryKey(devlasteststateKey);
        return hmOrigindata.getReceivetime() + "--------" + testName.get("sfbm") + "---------" + devlasteststate.getDevname();
    }

    /**
     * 获取指定时间开封市实时温度
     * 若传入null,则取当前时间
     * @return  温度
     */
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
