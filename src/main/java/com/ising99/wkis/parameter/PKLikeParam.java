package com.ising99.wkis.parameter;

import java.util.Date;

/**
 * Created by Hulk on 2014/11/25.
 */
public class PKLikeParam {
    private int id;
    private int singer_id;
    private int singer_song_id;
    private String sender_ip;
    private int sender_singer_id;
    private int sender_user_id;
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

    public String getSender_ip() {
        return sender_ip;
    }

    public void setSender_ip(String sender_ip) {
        this.sender_ip = sender_ip;
    }

    public int getSender_singer_id() {
        return sender_singer_id;
    }

    public void setSender_singer_id(int sender_singer_id) {
        this.sender_singer_id = sender_singer_id;
    }

    public int getSender_user_id() {
        return sender_user_id;
    }

    public void setSender_user_id(int sender_user_id) {
        this.sender_user_id = sender_user_id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
