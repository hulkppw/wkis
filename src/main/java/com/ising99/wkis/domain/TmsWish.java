package com.ising99.wkis.domain;

import java.sql.Timestamp;

/**
 * Created by Raise on 2015/1/21.
 */
public class TmsWish {
    private int id;
    private int userid;
    private String wish;
    private Timestamp createtime;
    private Boolean done;    //是否整理完毕
    private Timestamp donetime;
    private int language;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Timestamp getDonetime() {
        return donetime;
    }

    public void setDonetime(Timestamp donetime) {
        this.donetime = donetime;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }
}
