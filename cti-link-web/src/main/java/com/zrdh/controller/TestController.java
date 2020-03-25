package com.zrdh.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zrdh.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: cti-link-dataAnalysis
 *  测试
 * Created by 17645 on 2020/3/24 13:34
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Reference
    private TestService testService;

    @GetMapping(value="/aaa/{id}",produces = "text/plain;charset=utf-8")
    public String testMethod(@PathVariable("id")Integer id){
        return testService.findById(1);
    }

    @GetMapping(value="/bbb",produces = "text/plain;charset=utf-8")
    public String testMethodN(){
        return testService.getCurrentTemperature(null);
    }
}