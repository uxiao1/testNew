package com.zrdh;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zrdh.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/26 9:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
public class TestSome {

    @Reference
    private TestService testService;

    @Test
    public void testOne(){
        ArrayList<Object> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        System.out.println(list.toString());
    }


    @Test
    public void testTwo(){
        testService.findById(1);
    }

}
