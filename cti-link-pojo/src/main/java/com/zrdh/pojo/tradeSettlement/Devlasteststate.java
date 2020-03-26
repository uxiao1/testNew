package com.zrdh.pojo.tradeSettlement;

import java.util.Date;

public class Devlasteststate extends DevlasteststateKey {
    private Float curwaterflow;

    private Float curheatnum;

    private Integer totalwaterflow;

    private Integer totalheatnum;

    private Float supplywatertmp;

    private Float returnwatertmp;

    private Date lastupdatetime;

    @Override
    public String toString() {
        return "Devlasteststate{" +
                "curwaterflow=" + curwaterflow +
                ", curheatnum=" + curheatnum +
                ", totalwaterflow=" + totalwaterflow +
                ", totalheatnum=" + totalheatnum +
                ", supplywatertmp=" + supplywatertmp +
                ", returnwatertmp=" + returnwatertmp +
                ", lastupdatetime=" + lastupdatetime +
                '}';
    }

    public Float getCurwaterflow() {
        return curwaterflow;
    }

    public void setCurwaterflow(Float curwaterflow) {
        this.curwaterflow = curwaterflow;
    }

    public Float getCurheatnum() {
        return curheatnum;
    }

    public void setCurheatnum(Float curheatnum) {
        this.curheatnum = curheatnum;
    }

    public Integer getTotalwaterflow() {
        return totalwaterflow;
    }

    public void setTotalwaterflow(Integer totalwaterflow) {
        this.totalwaterflow = totalwaterflow;
    }

    public Integer getTotalheatnum() {
        return totalheatnum;
    }

    public void setTotalheatnum(Integer totalheatnum) {
        this.totalheatnum = totalheatnum;
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

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }
}