package com.zrdh.pojo.dispatchCenter;

import java.io.Serializable;

public class Tags implements Serializable {
    private Integer id;

    private String tagname;

    private String tagcomment;

    private String devname;

    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", tagname='" + tagname + '\'' +
                ", tagcomment='" + tagcomment + '\'' +
                ", devname='" + devname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getDevname() {
        return devname;
    }

    public void setDevname(String devname) {
        this.devname = devname;
    }
}