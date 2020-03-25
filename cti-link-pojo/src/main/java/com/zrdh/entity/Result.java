package com.zrdh.entity;

import java.io.Serializable;

/**
 * Description: cti-link-dataAnalysis
 * 返回结果类
 * Created by hua on 2020/3/25 8:49
 */
public class Result implements Serializable {

    private Integer rstCode;
    private String rstMsg;
    private Object rstData;

    public Result() {
    }

    public Result(Integer rstCode, String rstMsg, Object rstData) {
        this.rstCode = rstCode;
        this.rstMsg = rstMsg;
        this.rstData = rstData;
    }

    public Integer getRstCode() {
        return rstCode;
    }

    public void setRstCode(Integer rstCode) {
        this.rstCode = rstCode;
    }

    public String getRstMsg() {
        return rstMsg;
    }

    public void setRstMsg(String rstMsg) {
        this.rstMsg = rstMsg;
    }

    public Object getRstData() {
        return rstData;
    }

    public void setRstData(Object rstData) {
        this.rstData = rstData;
    }
}
