package com.ising99.wkis.domain;

import java.sql.Timestamp;

/**
 * Created by Raise on 2015/1/16.
 */
public class TmsNotice {
    private int id;
    private int userid;
    private int wishid;    //愿望歌单编号对应t_ms_wish的id字段
    private String songid;
    private String songname;
    private String singerid;
    private String singername;
    private int noticed;        //是否已经提醒
    private Timestamp createtime;
    private Timestamp noticetime;    //记录提醒的时间
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

    public int getWishid() {
        return wishid;
    }

    public void setWishid(int wishid) {
        this.wishid = wishid;
    }

    public String getSongid() {
        return songid;
    }

    public void setSongid(String songid) {
        this.songid = songid;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSingerid() {
        return singerid;
    }

    public void setSingerid(String singerid) {
        this.singerid = singerid;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    public int getNoticed() {
        return noticed;
    }

    public void setNoticed(int noticed) {
        this.noticed = noticed;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getNoticetime() {
        return noticetime;
    }

    public void setNoticetime(Timestamp noticetime) {
        this.noticetime = noticetime;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }
}
