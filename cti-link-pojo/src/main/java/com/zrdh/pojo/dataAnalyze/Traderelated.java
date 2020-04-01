package com.zrdh.pojo.dataAnalyze;

/**
 * 贸易中心系统关联表  和heatstation表关联
 * 电厂默认hid为0
 */
public class Traderelated {
    private Integer id;

    private String meterid;

    private String devicename;

    private Integer hid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeterid() {
        return meterid;
    }

    public void setMeterid(String meterid) {
        this.meterid = meterid;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }
}