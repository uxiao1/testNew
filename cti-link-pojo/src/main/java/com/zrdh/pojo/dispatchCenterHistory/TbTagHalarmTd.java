package com.zrdh.pojo.dispatchCenterHistory;

import java.io.Serializable;
import java.util.Date;

/**
 * 报警信息
 */
public class TbTagHalarmTd implements Serializable {
    private Long id;

    private String tagname;

    private String tagcomment;

    private Byte tagtype;

    private String chlgroup;

    private String chlname;

    private Date dbtime;

    private Double value;

    private Double alarmlimitvalue;

    private Byte alarmgroup;

    private Byte alarmpri;

    private String alarmmsg;

    private String alarmtype;

    private Byte alarmstatus;

    private Byte ackstatus;

    private String ackperson;

    private Date acktime;

    @Override
    public String toString() {
        return "TbTagHalarmTd{" +
                "id=" + id +
                ", tagname='" + tagname + '\'' +
                ", tagcomment='" + tagcomment + '\'' +
                ", tagtype=" + tagtype +
                ", chlgroup='" + chlgroup + '\'' +
                ", chlname='" + chlname + '\'' +
                ", dbtime=" + dbtime +
                ", value=" + value +
                ", alarmlimitvalue=" + alarmlimitvalue +
                ", alarmgroup=" + alarmgroup +
                ", alarmpri=" + alarmpri +
                ", alarmmsg='" + alarmmsg + '\'' +
                ", alarmtype='" + alarmtype + '\'' +
                ", alarmstatus=" + alarmstatus +
                ", ackstatus=" + ackstatus +
                ", ackperson='" + ackperson + '\'' +
                ", acktime=" + acktime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public String getTagcomment() {
        return tagcomment;
    }

    public void setTagcomment(String tagcomment) {
        this.tagcomment = tagcomment;
    }

    public Byte getTagtype() {
        return tagtype;
    }

    public void setTagtype(Byte tagtype) {
        this.tagtype = tagtype;
    }

    public String getChlgroup() {
        return chlgroup;
    }

    public void setChlgroup(String chlgroup) {
        this.chlgroup = chlgroup;
    }

    public String getChlname() {
        return chlname;
    }

    public void setChlname(String chlname) {
        this.chlname = chlname;
    }

    public Date getDbtime() {
        return dbtime;
    }

    public void setDbtime(Date dbtime) {
        this.dbtime = dbtime;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getAlarmlimitvalue() {
        return alarmlimitvalue;
    }

    public void setAlarmlimitvalue(Double alarmlimitvalue) {
        this.alarmlimitvalue = alarmlimitvalue;
    }

    public Byte getAlarmgroup() {
        return alarmgroup;
    }

    public void setAlarmgroup(Byte alarmgroup) {
        this.alarmgroup = alarmgroup;
    }

    public Byte getAlarmpri() {
        return alarmpri;
    }

    public void setAlarmpri(Byte alarmpri) {
        this.alarmpri = alarmpri;
    }

    public String getAlarmmsg() {
        return alarmmsg;
    }

    public void setAlarmmsg(String alarmmsg) {
        this.alarmmsg = alarmmsg;
    }

    public String getAlarmtype() {
        return alarmtype;
    }

    public void setAlarmtype(String alarmtype) {
        this.alarmtype = alarmtype;
    }

    public Byte getAlarmstatus() {
        return alarmstatus;
    }

    public void setAlarmstatus(Byte alarmstatus) {
        this.alarmstatus = alarmstatus;
    }

    public Byte getAckstatus() {
        return ackstatus;
    }

    public void setAckstatus(Byte ackstatus) {
        this.ackstatus = ackstatus;
    }

    public String getAckperson() {
        return ackperson;
    }

    public void setAckperson(String ackperson) {
        this.ackperson = ackperson;
    }

    public Date getAcktime() {
        return acktime;
    }

    public void setAcktime(Date acktime) {
        this.acktime = acktime;
    }
}