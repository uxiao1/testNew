package com.zrdh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zrdh.dao.lorawanUser.HmOrigindataMapper;
import com.zrdh.dao.nbUser.TestNameMapper;
import com.zrdh.pojo.lorawanUser.HmOrigindata;
import com.zrdh.pojo.nbUser.TestName;
import com.zrdh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Override
    public String findById(Integer id) {
        HmOrigindata hmOrigindata = hmOrigindataMapper.selectByDataId(1);
        TestName testName = testNameMapper.findById(1);
        return hmOrigindata.getReceivetime() + "--------" + testName.getName();
    }
}
