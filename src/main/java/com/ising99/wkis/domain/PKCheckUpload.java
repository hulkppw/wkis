package com.ising99.wkis.domain;

/**
 * Created by Hulk on 2014/11/15.
 * 检查添加歌手进度
 */
public class PKCheckUpload {
    private int status;
    private int pk_singer_id;

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
