package com.zrdh;

import org.junit.Test;

import java.util.Date;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/26 9:41
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
public class TestSome {



    @Test
    public void test11(){
        long x = new Date().getTime() -24 * 60 * 60 * 1000;
        System.out.println(new Date(x));
    }
}
