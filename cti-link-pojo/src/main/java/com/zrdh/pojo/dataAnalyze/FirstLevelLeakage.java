package com.zrdh.pojo.dataAnalyze;

import java.util.Date;

public class FirstLevelLeakage {
    private Integer id;

    private Integer dcid;

    private Double dccurheatnumer;

    private Double rlzcurheatnumber;

    private Double leakagenumber;

    private String temperature;

    private Date currenttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDcid() {
        return dcid;
    }

    public void setDcid(Integer dcid) {
        this.dcid = dcid;
    }

    public Double getDccurheatnumer() {
        return dccurheatnumer;
    }

    public void setDccurheatnumer(Double dccurheatnumer) {
        this.dccurheatnumer = dccurheatnumer;
    }

    public Double getRlzcurheatnumber() {
        return rlzcurheatnumber;
    }

    public void setRlzcurheatnumber(Double rlzcurheatnumber) {
        this.rlzcurheatnumber = rlzcurheatnumber;
    }

    public Double getLeakagenumber() {
        return leakagenumber;
    }

    public void setLeakagenumber(Double leakagenumber) {
        this.leakagenumber = leakagenumber;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Date getCurrenttime() {
        return currenttime;
    }

    public void setCurrenttime(Date currenttime) {
        this.currenttime = currenttime;
    }
}