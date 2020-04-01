package com.zrdh.pojo.lorawanUser;

public class HmNormaldecodedata extends HmNormaldecodedataKey {
    private String devicename;

    private String deveui;

    private String gatewayid;

    private String gatewayname;

    private String voltage;

    private String equipmenttype;

    private String meterno;

    private String usercode;

    private Float currentcoldnumber;

    private Float currentheatnumber;        //热量

    private Float origincurrentheatnumber;

    private Float heatpower;    //功率

    private Float flowrate;     //瞬时流量

    private Float totalflow;    //总流量

    private Float supplywatertemperature;

    private Float returnwatertemperature;

    private String currenttime;

    private Float wdc;

    private String status1;

    private String status2;

    private String regflag;

    private String unit;

    @Override
    public String toString() {
        return "HmNormaldecodedata{" +
                "devicename='" + devicename + '\'' +
                ", deveui='" + deveui + '\'' +
                ", gatewayid='" + gatewayid + '\'' +
                ", gatewayname='" + gatewayname + '\'' +
                ", voltage='" + voltage + '\'' +
                ", equipmenttype='" + equipmenttype + '\'' +
                ", meterno='" + meterno + '\'' +
                ", usercode='" + usercode + '\'' +
                ", currentcoldnumber=" + currentcoldnumber +
                ", currentheatnumber=" + currentheatnumber +
                ", origincurrentheatnumber=" + origincurrentheatnumber +
                ", heatpower=" + heatpower +
                ", flowrate=" + flowrate +
                ", totalflow=" + totalflow +
                ", supplywatertemperature=" + supplywatertemperature +
                ", returnwatertemperature=" + returnwatertemperature +
                ", currenttime='" + currenttime + '\'' +
                ", wdc=" + wdc +
                ", status1='" + status1 + '\'' +
                ", status2='" + status2 + '\'' +
                ", regflag='" + regflag + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getDeveui() {
        return deveui;
    }

    public void setDeveui(String deveui) {
        this.deveui = deveui;
    }

    public String getGatewayid() {
        return gatewayid;
    }

    public void setGatewayid(String gatewayid) {
        this.gatewayid = gatewayid;
    }

    public String getGatewayname() {
        return gatewayname;
    }

    public void setGatewayname(String gatewayname) {
        this.gatewayname = gatewayname;
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

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public Float getCurrentcoldnumber() {
        return currentcoldnumber;
    }

    public void setCurrentcoldnumber(Float currentcoldnumber) {
        this.currentcoldnumber = currentcoldnumber;
    }

    public Float getCurrentheatnumber() {
        return currentheatnumber;
    }

    public void setCurrentheatnumber(Float currentheatnumber) {
        this.currentheatnumber = currentheatnumber;
    }

    public Float getOrigincurrentheatnumber() {
        return origincurrentheatnumber;
    }

    public void setOrigincurrentheatnumber(Float origincurrentheatnumber) {
        this.origincurrentheatnumber = origincurrentheatnumber;
    }

    public Float getHeatpower() {
        return heatpower;
    }

    public void setHeatpower(Float heatpower) {
        this.heatpower = heatpower;
    }

    public Float getFlowrate() {
        return flowrate;
    }

    public void setFlowrate(Float flowrate) {
        this.flowrate = flowrate;
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

    public String getCurrenttime() {
        return currenttime;
    }

    public void setCurrenttime(String currenttime) {
        this.currenttime = currenttime;
    }

    public Float getWdc() {
        return wdc;
    }

    public void setWdc(Float wdc) {
        this.wdc = wdc;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    public String getRegflag() {
        return regflag;
    }

    public void setRegflag(String regflag) {
        this.regflag = regflag;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}