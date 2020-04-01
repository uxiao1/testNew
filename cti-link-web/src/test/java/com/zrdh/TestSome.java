package com.zrdh;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zrdh.entity.AlarmConditions;
import com.zrdh.entity.AlarmInfo;
import com.zrdh.service.DeviceInfoService;
import com.zrdh.utils.LorawanPartition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/26 9:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
public class TestSome {

    @Reference
    private DeviceInfoService deviceInfoService;

    @Test
    public void testOne(){
        AlarmConditions alarmConditions = new AlarmConditions();
        alarmConditions.setGtHeatNumber((float) 100);
        alarmConditions.setLtHeatNumber((float) 500);
        alarmConditions.setPartition(LorawanPartition.getPartitionByDate(new Date()));
        Map<String, List<AlarmInfo>> alarmInfo = deviceInfoService.queryforAlarmInfo(alarmConditions);
        System.out.println(alarmInfo.toString());
    }


    /**
     * 随机生成10个字母,并按照从小到大的顺序排序
     */
    @Test
    public void testThird(){
        HashSet<Integer> hashSet = new HashSet<>();
        Random random = new Random();
        while (hashSet.size()<10){
            int i = random.nextInt(26);
            hashSet.add(i+97);
        }
        ArrayList<Integer> letter = new ArrayList<>();
        for (Integer i : hashSet) {
            letter.add(i);
        }
        Collections.sort(letter);
        for (int i : letter) {
            char c = (char) i;
            System.out.println(c);
        }
    }

    /**
     * 求0-100的素数
     */
    @Test
    public void testFour(){
        int a,b ;
        for (a = 1; a <= 100; a++) {
            for (b = 2; b < a; b++) {
                if(a%b == 0){
                    break;
                }
            }
            if(a == b){
                System.out.println(a);
            }
        }
    }



    public boolean testFive(String s1, String s2){
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars1);
        return new String(chars).equals(new String(chars1));
    }

    @Test
    public void testSix(){
        System.out.println(testFive("abcdrf","cdbafr"));
    }
}
