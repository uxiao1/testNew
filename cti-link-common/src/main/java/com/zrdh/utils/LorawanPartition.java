package com.zrdh.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/31 9:39
 */
public class LorawanPartition {

    /**
     * 根据指定的日期获取数据所在分区
     * @param date  默认当前时间
     * @return  p1,p2,p3
     * p1  ----------  2019-08-01(包括)之前的数据
     * p2  ----------  2019-08-02 到 2019-09-01(包括)
     * p3  ----------  2019-09-02 到 2019-10-01(包括)
     * 以此类推
     */
    public static String getPartitionByDate(Date date){
        if (date == null){
            date = new Date();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(date.compareTo(dateFormat.parse("2019-08-01")) < 0){
                return "p1";
            }else if(date.compareTo(dateFormat.parse("2019-09-01")) < 0){
                return "p2";
            }else if(date.compareTo(dateFormat.parse("2019-10-01")) < 0){
                return "p3";
            }else if(date.compareTo(dateFormat.parse("2019-11-01")) < 0){
                return "p4";
            }else if(date.compareTo(dateFormat.parse("2019-12-01")) < 0){
                return "p5";
            }else if(date.compareTo(dateFormat.parse("2020-01-01")) < 0){
                return "p6";
            }else if(date.compareTo(dateFormat.parse("2020-02-01")) < 0){
                return "p7";
            }else if(date.compareTo(dateFormat.parse("2020-03-01")) < 0){
                return "p8";
            }else if(date.compareTo(dateFormat.parse("2020-04-01")) < 0){
                return "p9";
            }else if(date.compareTo(dateFormat.parse("2020-05-01")) < 0){
                return "p10";
            }else if(date.compareTo(dateFormat.parse("2020-06-01")) < 0){
                return "p11";
            }else if(date.compareTo(dateFormat.parse("2020-07-01")) < 0){
                return "p12";
            }else if(date.compareTo(dateFormat.parse("2020-08-01")) < 0){
                return "p13";
            }else if(date.compareTo(dateFormat.parse("2020-09-01")) < 0){
                return "p14";
            }else if(date.compareTo(dateFormat.parse("2020-10-01")) < 0){
                return "p15";
            }else if(date.compareTo(dateFormat.parse("2020-11-01")) < 0){
                return "p16";
            }else if(date.compareTo(dateFormat.parse("2020-12-01")) < 0){
                return "p17";
            }else{
                return "p99";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
