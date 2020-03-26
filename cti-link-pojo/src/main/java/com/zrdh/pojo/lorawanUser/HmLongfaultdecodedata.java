package com.zrdh.pojo.lorawanUser;

public class HmLongfaultdecodedata extends HmLongfaultdecodedataKey {
    private String devicename;

    private String deveui;

    private String gatewayid;

    private String gatewayname;

    private String voltage;

    private String equipmenttype;

    private String meterno;

    private String usercode;

    private String errorcode;

    @Override
    public String toString() {
        return "HmLongfaultdecodedata{" +
                "devicename='" + devicename + '\'' +
                ", deveui='" + deveui + '\'' +
                ", gatewayid='" + gatewayid + '\'' +
                ", gatewayname='" + gatewayname + '\'' +
                ", voltage='" + voltage + '\'' +
                ", equipmenttype='" + equipmenttype + '\'' +
                ", meterno='" + meterno + '\'' +
                ", usercode='" + usercode + '\'' +
                ", errorcode='" + errorcode + '\'' +
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

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }
}