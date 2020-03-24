package com.zrdh.pojo.lorawanUser;

import java.util.Date;

public class HmLongfaultdecodedataKey {
    private Integer dataid;

    private Date decodetime;

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }

    public Date getDecodetime() {
        return decodetime;
    }

    public void setDecodetime(Date decodetime) {
        this.decodetime = decodetime;
    }

    public HmLongfaultdecodedataKey() {
    }

    public HmLongfaultdecodedataKey(Integer dataid, Date decodetime) {
        this.dataid = dataid;
        this.decodetime = decodetime;
    }
}