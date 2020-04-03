package com.zrdh;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/26 9:41
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
public class TestSome {



    @Test
    public void test11(){
        ArrayList<Integer> cardNumberList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            cardNumberList.add(i);
        }
        int start = 0;
        int end = 10;
        if (cardNumberList.size() > 20){
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
                System.out.println(tempList);
                if (end >= cardNumberList.size()){
                    break;
                }
            }
        }
    }
}
