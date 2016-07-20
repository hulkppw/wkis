package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;

import java.util.Date;

/**
 * Created by Hulk on 2014/11/12.
 */
public class PKSingerInfo {
    private int id;
    private String nickname;
    private int gender;
    private long birthday;
    private Date createtime;
    private String head;

    private String resourcesurl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public long getCreatetime() {
        return createtime.getTime();
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setMyHead() {
        //用户头像地址通过resourcesurl+head 获取
        if (head != null && head.length() != 0)
            head = resourcesurl + head;
    }

    public void setResourcesUrl(String resourcesurl) {
        this.resourcesurl = resourcesurl;
    }

}
