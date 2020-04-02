package com.zrdh.pojo.tradeSettlement;

import java.util.Date;

public class Devlasteststate extends DevlasteststateKey {
    private Float flowrate;        //瞬时流量

    private Float heatpower;        //功率

    private Integer curwaterflow;   //总流量

    private Integer curheatnum;     //热量

    private Float supplywatertmp;

    private Float returnwatertmp;

    private Date lastsynctime;

    @Override
    public String toString() {
        return "Devlasteststate{" +
                "flowrate=" + flowrate +
                ", heatpower=" + heatpower +
                ", curwaterflow=" + curwaterflow +
                ", curheatnum=" + curheatnum +
                ", supplywatertmp=" + supplywatertmp +
                ", returnwatertmp=" + returnwatertmp +
                ", lastsynctime=" + lastsynctime +
                '}';
    }

    public Float getFlowrate() {
        return flowrate;
    }

    public void setFlowrate(Float flowrate) {
        this.flowrate = flowrate;
    }

    public Float getHeatpower() {
        return heatpower;
    }

    public void setHeatpower(Float heatpower) {
        this.heatpower = heatpower;
    }

    public Integer getCurwaterflow() {
        return curwaterflow;
    }

    public void setCurwaterflow(Integer curwaterflow) {
        this.curwaterflow = curwaterflow;
    }

    public Integer getCurheatnum() {
        return curheatnum;
    }

    public void setCurheatnum(Integer curheatnum) {
        this.curheatnum = curheatnum;
    }

    public Float getSupplywatertmp() {
        return supplywatertmp;
    }

    public void setSupplywatertmp(Float supplywatertmp) {
        this.supplywatertmp = supplywatertmp;
    }

    public Float getReturnwatertmp() {
        return returnwatertmp;
    }

    public void setReturnwatertmp(Float returnwatertmp) {
        this.returnwatertmp = returnwatertmp;
    }

    public Date getLastsynctime() {
        return lastsynctime;
    }

    public void setLastsynctime(Date lastsynctime) {
        this.lastsynctime = lastsynctime;
    }
}