package com.zrdh.pojo.dataAnalyze;

import java.io.Serializable;
import java.util.Date;

public class FirstLevelLeakage implements Serializable {
    private Integer id;

    private Integer dcid;

    private Double dccurheatnumer;  //电厂热力值

    private Double rlzcurheatnumber;    //电厂对应的热力站以及电厂对应所有的贸易结算系统的热力值

    private Double leakagenumber;

    private String temperature;

    private Date currenttime;

    @Override
    public String toString() {
        return "FirstLevelLeakage{" +
                "id=" + id +
                ", dcid=" + dcid +
                ", dccurheatnumer=" + dccurheatnumer +
                ", rlzcurheatnumber=" + rlzcurheatnumber +
                ", leakagenumber=" + leakagenumber +
                ", temperature='" + temperature + '\'' +
                ", currenttime=" + currenttime +
                '}';
    }

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