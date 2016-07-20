package com.ising99.wkis.parameter;

import java.util.Date;

/**
 * Created by Hulk on 2014/11/25.
 */
public class PKListenParam {
    private int id;
    private int singer_id;
    private int singer_song_id;
    private String ip;
    private int listener_singer_id;
    private int listener_user_id;
    private Date createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSinger_id() {
        return singer_id;
    }

    public void setSinger_id(int singer_id) {
        this.singer_id = singer_id;
    }

    public int getSinger_song_id() {
        return singer_song_id;
    }

    public void setSinger_song_id(int singer_song_id) {
        this.singer_song_id = singer_song_id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getListener_singer_id() {
        return listener_singer_id;
    }

    public void setListener_singer_id(int listener_singer_id) {
        this.listener_singer_id = listener_singer_id;
    }

    public int getListener_user_id() {
        return listener_user_id;
    }

    public void setListener_user_id(int listener_user_id) {
        this.listener_user_id = listener_user_id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
