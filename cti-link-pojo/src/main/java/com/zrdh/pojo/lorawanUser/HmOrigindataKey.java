package com.zrdh.pojo.lorawanUser;

import java.util.Date;

public class HmOrigindataKey {
    private Integer dataid;

    private Date receivetime;

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }

    public Date getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(Date receivetime) {
        this.receivetime = receivetime;
    }

    public HmOrigindataKey() {
    }

    public HmOrigindataKey(Integer dataid, Date receivetime) {
        this.dataid = dataid;
        this.receivetime = receivetime;
    }
}