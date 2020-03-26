package com.zrdh.entity;

import java.io.Serializable;

/**
 * Description: cti-link-dataAnalysis
 * 告警条件集合
 * Created by hua on 2020/3/26 11:00
 */
public class AlarmConditions implements Serializable {

    private Float gtHeatNumber;     //超过用量(总热量)
    private Float ltHeatNumber;     //小于用量
    private Float gtWdc;            //超过温差
    private Float ltWdc;            //小于温差
    private Float gtHeatPower;      //超过功率
    private Float ltHeatPower;      //小于功率
    private Float gtTotalFlow;      //超过总流量
    private Float ltTotalFlow;      //小于总流量
    private Float gtVoltage;        //超过电压
    private Float ltVoltage;        //小于电压

    public Float getGtHeatNumber() {
        return gtHeatNumber;
    }

    public void setGtHeatNumber(Float gtHeatNumber) {
        this.gtHeatNumber = gtHeatNumber;
    }

    public Float getLtHeatNumber() {
        return ltHeatNumber;
    }

    public void setLtHeatNumber(Float ltHeatNumber) {
        this.ltHeatNumber = ltHeatNumber;
    }

    public Float getGtWdc() {
        return gtWdc;
    }

    public void setGtWdc(Float gtWdc) {
        this.gtWdc = gtWdc;
    }

    public Float getLtWdc() {
        return ltWdc;
    }

    public void setLtWdc(Float ltWdc) {
        this.ltWdc = ltWdc;
    }

    public Float getGtHeatPower() {
        return gtHeatPower;
    }

    public void setGtHeatPower(Float gtHeatPower) {
        this.gtHeatPower = gtHeatPower;
    }

    public Float getLtHeatPower() {
        return ltHeatPower;
    }

    public void setLtHeatPower(Float ltHeatPower) {
        this.ltHeatPower = ltHeatPower;
    }

    public Float getGtTotalFlow() {
        return gtTotalFlow;
    }

    public void setGtTotalFlow(Float gtTotalFlow) {
        this.gtTotalFlow = gtTotalFlow;
    }

    public Float getLtTotalFlow() {
        return ltTotalFlow;
    }

    public void setLtTotalFlow(Float ltTotalFlow) {
        this.ltTotalFlow = ltTotalFlow;
    }

    public Float getGtVoltage() {
        return gtVoltage;
    }

    public void setGtVoltage(Float gtVoltage) {
        this.gtVoltage = gtVoltage;
    }

    public Float getLtVoltage() {
        return ltVoltage;
    }

    public void setLtVoltage(Float ltVoltage) {
        this.ltVoltage = ltVoltage;
    }
}
