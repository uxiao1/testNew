package com.zrdh.pojo.dataAnalyze;

import java.io.Serializable;
import java.util.Date;

public class SecondLevelLeakageSum implements Serializable {
    private Integer id;

    private Double tagcurheatnumersum;

    private Double hycurheatnumbersum;

    private Double leakagenumbersum;

    private Float hyheatpowersum;

    private Float hywdcsum;

    private String temperature;

    private Date currenttime;

    @Override
    public String toString() {
        return "SecondLevelLeakageSum{" +
                "id=" + id +
                ", tagcurheatnumersum=" + tagcurheatnumersum +
                ", hycurheatnumbersum=" + hycurheatnumbersum +
                ", leakagenumbersum=" + leakagenumbersum +
                ", hyheatpowersum=" + hyheatpowersum +
                ", hywdcsum=" + hywdcsum +
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

    public Double getTagcurheatnumersum() {
        return tagcurheatnumersum;
    }

    public void setTagcurheatnumersum(Double tagcurheatnumersum) {
        this.tagcurheatnumersum = tagcurheatnumersum;
    }

    public Double getHycurheatnumbersum() {
        return hycurheatnumbersum;
    }

    public void setHycurheatnumbersum(Double hycurheatnumbersum) {
        this.hycurheatnumbersum = hycurheatnumbersum;
    }

    public Double getLeakagenumbersum() {
        return leakagenumbersum;
    }

    public void setLeakagenumbersum(Double leakagenumbersum) {
        this.leakagenumbersum = leakagenumbersum;
    }

    public Float getHyheatpowersum() {
        return hyheatpowersum;
    }

    public void setHyheatpowersum(Float hyheatpowersum) {
        this.hyheatpowersum = hyheatpowersum;
    }

    public Float getHywdcsum() {
        return hywdcsum;
    }

    public void setHywdcsum(Float hywdcsum) {
        this.hywdcsum = hywdcsum;
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