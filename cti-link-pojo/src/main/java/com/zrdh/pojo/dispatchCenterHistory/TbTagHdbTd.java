package com.zrdh.pojo.dispatchCenterHistory;

import java.util.Date;

/**
 * 存储热力站最新且唯一的数据
 */
public class TbTagHdbTd {
    private Integer id;

    private Integer tagid;

    private Date dbtime;

    private Double value;

    private Integer qos;

    @Override
    public String toString() {
        return "TbTagHdbTd{" +
                "id=" + id +
                ", tagid=" + tagid +
                ", dbtime=" + dbtime +
                ", value=" + value +
                ", qos=" + qos +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
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

    public Integer getQos() {
        return qos;
    }

    public void setQos(Integer qos) {
        this.qos = qos;
    }
}