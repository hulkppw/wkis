package com.ising99.wkis.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Raise on 2015/1/16.
 */
public class TmsUserInfo {
    private int id;
    private int platform;//平台来源 0：爱唱，1：facebook，2：qq，3：新浪，4：推特
   private String platform_userid;
  private String  nickname;
  private String  head;
   private int gender;
   private Date birthday;
   private String mobile;
  private String  province;
   private String city;
   private Timestamp modifytime;
  private Timestamp  createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public String getPlatform_userid() {
        return platform_userid;
    }

    public void setPlatform_userid(String platform_userid) {
        this.platform_userid = platform_userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }



    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Timestamp getModifytime() {
        return modifytime;
    }

    public void setModifytime(Timestamp modifytime) {
        this.modifytime = modifytime;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
}
