package com.zrdh.pojo.dataAnalyze;

import java.io.Serializable;
import java.util.Date;

public class SecondLevelLeakage implements Serializable {
    private Integer id;

    private Integer tagid;

    private Double tagcurheatnumer;

    private Double hycurheatnumber;

    private Double leakagenumber;

    private Float hyheatpower;

    private Float hywdc;

    private String temperature;

    private Date currenttime;

    @Override
    public String toString() {
        return "SecondLevelLeakage{" +
                "id=" + id +
                ", tagid=" + tagid +
                ", tagcurheatnumer=" + tagcurheatnumer +
                ", hycurheatnumber=" + hycurheatnumber +
                ", leakagenumber=" + leakagenumber +
                ", hyheatpower=" + hyheatpower +
                ", hywdc=" + hywdc +
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

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    public Double getTagcurheatnumer() {
        return tagcurheatnumer;
    }

    public void setTagcurheatnumer(Double tagcurheatnumer) {
        this.tagcurheatnumer = tagcurheatnumer;
    }

    public Double getHycurheatnumber() {
        return hycurheatnumber;
    }

    public void setHycurheatnumber(Double hycurheatnumber) {
        this.hycurheatnumber = hycurheatnumber;
    }

    public Double getLeakagenumber() {
        return leakagenumber;
    }

    public void setLeakagenumber(Double leakagenumber) {
        this.leakagenumber = leakagenumber;
    }

    public Float getHyheatpower() {
        return hyheatpower;
    }

    public void setHyheatpower(Float hyheatpower) {
        this.hyheatpower = hyheatpower;
    }

    public Float getHywdc() {
        return hywdc;
    }

    public void setHywdc(Float hywdc) {
        this.hywdc = hywdc;
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