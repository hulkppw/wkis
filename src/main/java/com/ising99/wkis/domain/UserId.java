package com.ising99.wkis.domain;

import java.util.Date;

/**
 * Created by Administrator on 2015-02-07.
 */
public class UserId {
    private int userid;
    private Date createtime;

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
}
