package com.zrdh.pojo.tradeSettlement;

import java.io.Serializable;

public class DevlasteststateKey implements Serializable {
    private String dtuid;

    private String devname;

    public String getDtuid() {
        return dtuid;
    }

    public void setDtuid(String dtuid) {
        this.dtuid = dtuid;
    }

    public String getDevname() {
        return devname;
    }

    public void setDevname(String devname) {
        this.devname = devname;
    }
}