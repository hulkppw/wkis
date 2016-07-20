package com.ising99.wkis.domain;

import java.util.Date;

/**
 * Created by Hulk on 2014/12/8.
 */
public class PKTempSinger {
    private String id;
    private int userid;
    private Date createtime;
    private int language;
    private int status;
    private int pk_singer_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPk_singer_id() {
        return pk_singer_id;
    }

    public void setPk_singer_id(int pk_singer_id) {
        this.pk_singer_id = pk_singer_id;
    }
}
