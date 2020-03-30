package com.zrdh.pojo.nbUser;

import java.io.Serializable;
import java.util.Date;

/**
 * Description: cti-link-dataAnalysis
 * deer视图对应的实体类
 * Created by hua on 2020/3/30 11:53
 */
public class VmAmeterRlgs implements Serializable {


    private Integer sfbm;           //房卡号
    private String meter_no;         //仪表号
    private String meter_no_cb;       //德尔采集器的仪表号
    private Date cjq_time;           //抄表时间点 (根据此时间得到最近一条热表数据)
    private Date cjqcjTime;         //热量表真实上报数据时间点
    private Float dqrl;             //热量表累计热量
    private Float ljll;             //热量表累计流量
    private Float gl;               //热量表功率
    private Float ls;               //热量表瞬时流量
    private Float gswd;             //热量表供水温度
    private Float hswd;             //热量表回水温度
    private Float wdc;              //热量表供水和回水温度差
    private String txzt;            //系统通讯状态
    private String center_no;        //采集器编号
    private String mpid;            //计量器编号

    @Override
    public String toString() {
        return "VmAmeterRlgs{" +
                "sfbm=" + sfbm +
                ", meter_no='" + meter_no + '\'' +
                ", meter_no_cb='" + meter_no_cb + '\'' +
                ", cjq_time=" + cjq_time +
                ", cjqcjTime=" + cjqcjTime +
                ", dqrl=" + dqrl +
                ", ljll=" + ljll +
                ", gl=" + gl +
                ", ls=" + ls +
                ", gswd=" + gswd +
                ", hswd=" + hswd +
                ", wdc=" + wdc +
                ", txzt='" + txzt + '\'' +
                ", center_no='" + center_no + '\'' +
                ", mpid='" + mpid + '\'' +
                '}';
    }

    public Integer getSfbm() {
        return sfbm;
    }

    public void setSfbm(Integer sfbm) {
        this.sfbm = sfbm;
    }

    public String getMeter_no() {
        return meter_no;
    }

    public void setMeter_no(String meter_no) {
        this.meter_no = meter_no;
    }

    public String getMeter_no_cb() {
        return meter_no_cb;
    }

    public void setMeter_no_cb(String meter_no_cb) {
        this.meter_no_cb = meter_no_cb;
    }

    public Date getCjq_time() {
        return cjq_time;
    }

    public void setCjq_time(Date cjq_time) {
        this.cjq_time = cjq_time;
    }

    public Date getCjqcjTime() {
        return cjqcjTime;
    }

    public void setCjqcjTime(Date cjqcjTime) {
        this.cjqcjTime = cjqcjTime;
    }

    public Float getDqrl() {
        return dqrl;
    }

    public void setDqrl(Float dqrl) {
        this.dqrl = dqrl;
    }

    public Float getLjll() {
        return ljll;
    }

    public void setLjll(Float ljll) {
        this.ljll = ljll;
    }

    public Float getGl() {
        return gl;
    }

    public void setGl(Float gl) {
        this.gl = gl;
    }

    public Float getLs() {
        return ls;
    }

    public void setLs(Float ls) {
        this.ls = ls;
    }

    public Float getGswd() {
        return gswd;
    }

    public void setGswd(Float gswd) {
        this.gswd = gswd;
    }

    public Float getHswd() {
        return hswd;
    }

    public void setHswd(Float hswd) {
        this.hswd = hswd;
    }

    public Float getWdc() {
        return wdc;
    }

    public void setWdc(Float wdc) {
        this.wdc = wdc;
    }

    public String getTxzt() {
        return txzt;
    }

    public void setTxzt(String txzt) {
        this.txzt = txzt;
    }

    public String getCenter_no() {
        return center_no;
    }

    public void setCenter_no(String center_no) {
        this.center_no = center_no;
    }

    public String getMpid() {
        return mpid;
    }

    public void setMpid(String mpid) {
        this.mpid = mpid;
    }
}
