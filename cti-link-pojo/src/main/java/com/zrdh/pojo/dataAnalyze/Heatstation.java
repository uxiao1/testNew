package com.zrdh.pojo.dataAnalyze;

import java.io.Serializable;

public class Heatstation implements Serializable {
    private Integer id;

    private String name;

    private Integer hid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }
}