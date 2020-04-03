package com.zrdh;

import com.zrdh.job.AnalysisJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/4/2 11:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
public class TestTwo {

    @Test
    public void test(){
        AnalysisJob analysisJob = new AnalysisJob();
        analysisJob.secondLeaveLeakage();
    }
}
