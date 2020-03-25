package com.zrdh.job;

/**
 * Description: cti-link-dataAnalysis
 * 管网自动分析漏损定时任务
 * Created by hua on 2020/3/25 15:38
 */
public class AnalysisJob {

    /**
     * 一级管网自动分析漏损
     */
    public void firstLeaveLeakage(){
        System.out.println("---------------------一级管网漏损分析----------------------");
    }

    /**
     * 二级管网自动分析漏损
     */
    public void secondLeaveLeakage(){
        System.out.println("----------------------二级管网漏损分析----------------------");
    }
}
