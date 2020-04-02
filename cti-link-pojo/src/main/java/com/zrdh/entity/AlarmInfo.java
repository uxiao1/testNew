package com.zrdh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description: cti-link-dataAnalysis
 * 返回前端告警信息
 * Created by hua on 2020/3/26 15:40
 */
public class AlarmInfo implements Serializable {

//    private String DeviceName;      //设备名称
//    private String voltage;         //电压
//    private String equipmenttype;   //设备类型
    private String meterno;         //仪表号
    private Float currentheatnumber;//热力值
    private Float heatpower;        //功率
    private Float totalflow;        //总流量
    private Float supplywatertemperature;//进水温度
    private Float returnwatertemperature;//回水温度
    private Float wdc;              //水温差
    private Float flowrate;         //瞬时流量
    private Date currentTime;       //时间

    @Override
    public String toString() {
        return "AlarmInfo{" +
                "meterno='" + meterno + '\'' +
                ", currentheatnumber=" + currentheatnumber +
                ", heatpower=" + heatpower +
                ", totalflow=" + totalflow +
                ", supplywatertemperature=" + supplywatertemperature +
                ", returnwatertemperature=" + returnwatertemperature +
                ", wdc=" + wdc +
                ", flowrate=" + flowrate +
                ", currentTime=" + currentTime +
                '}';
    }

    public String getMeterno() {
        return meterno;
    }

    public void setMeterno(String meterno) {
        this.meterno = meterno;
    }

    public Float getCurrentheatnumber() {
        return currentheatnumber;
    }

    public void setCurrentheatnumber(Float currentheatnumber) {
        this.currentheatnumber = currentheatnumber;
    }

    public Float getHeatpower() {
        return heatpower;
    }

    public void setHeatpower(Float heatpower) {
        this.heatpower = heatpower;
    }

    public Float getTotalflow() {
        return totalflow;
    }

    public void setTotalflow(Float totalflow) {
        this.totalflow = totalflow;
    }

    public Float getSupplywatertemperature() {
        return supplywatertemperature;
    }

    public void setSupplywatertemperature(Float supplywatertemperature) {
        this.supplywatertemperature = supplywatertemperature;
    }

    public Float getReturnwatertemperature() {
        return returnwatertemperature;
    }

    public void setReturnwatertemperature(Float returnwatertemperature) {
        this.returnwatertemperature = returnwatertemperature;
    }

    public Float getWdc() {
        return wdc;
    }

    public void setWdc(Float wdc) {
        this.wdc = wdc;
    }

    public Float getFlowrate() {
        return flowrate;
    }

    public void setFlowrate(Float flowrate) {
        this.flowrate = flowrate;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }
}
