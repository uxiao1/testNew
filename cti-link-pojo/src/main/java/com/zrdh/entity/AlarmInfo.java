package com.zrdh.entity;

/**
 * Description: cti-link-dataAnalysis
 * 返回前端告警信息
 * Created by hua on 2020/3/26 15:40
 */
public class AlarmInfo {

    private String DeviceName;      //设备名称
    private String voltage;         //电压
    private String equipmenttype;   //设备类型
    private String meterno;         //仪表号
    private Float currentheatnumber;//热力值
    private Float heatpower;        //功率
    private Float totalflow;        //总流量
    private Float supplywatertemperature;//进水温度
    private Float returnwatertemperature;//回水温度
    private Float wdc;              //水温差

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String deviceName) {
        DeviceName = deviceName;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getEquipmenttype() {
        return equipmenttype;
    }

    public void setEquipmenttype(String equipmenttype) {
        this.equipmenttype = equipmenttype;
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
}
