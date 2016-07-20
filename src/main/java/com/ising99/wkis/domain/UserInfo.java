package com.ising99.wkis.domain;

import java.util.Date;

/**
 * Created by Administrator on 2015-02-06.
 */
public class UserInfo {

    private int id;
    private int userid;
    private String password;
    private String machineno;
    private int devtype;
    private String nickname;
    private String province;
    private String mobile;
    private int sex;
    private int loginnodeid;
    private int partner;
    private String member;
    private Date createtime;


    public UserInfo() {
        this.userid = 0;
        this.password = "";
        this.machineno = "";
        this.devtype = 0;
        this.nickname = "";
        this.province = "";
        this.mobile = "";
        this.sex = 0;
        this.loginnodeid = 0;
        this.partner = 0;
        this.member = "";
        this.createtime=new java.sql.Date(new Date().getTime());
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMachineno() {
        return machineno;
    }

    public void setMachineno(String machineno) {
        this.machineno = machineno;
    }

    public int getDevtype() {
        return devtype;
    }

    public void setDevtype(int devtype) {
        this.devtype = devtype;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getLoginnodeid() {
        return loginnodeid;
    }

    public void setLoginnodeid(int loginnodeid) {
        this.loginnodeid = loginnodeid;
    }

    public int getPartner() {
        return partner;
    }

    public void setPartner(int partner) {
        this.partner = partner;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}