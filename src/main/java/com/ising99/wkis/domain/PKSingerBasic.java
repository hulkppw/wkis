package com.ising99.wkis.domain;

import java.util.Date;

/**
 * Created by Hulk on 2014/11/13.
 */
public class PKSingerBasic {
    private int id;
    private String nickname;
    private Date createtime;

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

    public long getCreatetime() {
        return createtime.getTime();
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
