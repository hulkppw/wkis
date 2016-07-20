package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;

import java.util.Date;

/**
 * Created by Hulk on 2015/02/07.
 */
public class Tone {
    private int id;
    private String userid;
    private int singerid;
    private int topnote;
    private int highkey;
    private int ddtype;
    private int sex;
    private int ismusictraining;
    private int autokeytip;
    private String touxiang;
    private String result;
    private String hkfreqz;
    private String hasdd;
    private Date createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getSingerid() {
        return singerid;
    }

    public void setSingerid(int singerid) {
        this.singerid = singerid;
    }

    public int getTopnote() {
        return topnote;
    }

    public void setTopnote(int topnote) {
        this.topnote = topnote;
    }

    public int getHighkey() {
        return highkey;
    }

    public void setHighkey(int highkey) {
        this.highkey = highkey;
    }

    public int getDdtype() {
        return ddtype;
    }

    public void setDdtype(int ddtype) {
        this.ddtype = ddtype;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getIsmusictraining() {
        return ismusictraining;
    }

    public void setIsmusictraining(int ismusictraining) {
        this.ismusictraining = ismusictraining;
    }

    public int getAutokeytip() {
        return autokeytip;
    }

    public void setAutokeytip(int autokeytip) {
        this.autokeytip = autokeytip;
    }

    public String getTouxiang() {
        return touxiang;
    }

    public void setTouxiang(String touxiang) {
        this.touxiang = touxiang;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getHkfreqz() {
        return hkfreqz;
    }

    public void setHkfreqz(String hkfreqz) {
        this.hkfreqz = hkfreqz;
    }

    public String getHasdd() {
        return hasdd;
    }

    public void setHasdd(String hasdd) {
        this.hasdd = hasdd;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
