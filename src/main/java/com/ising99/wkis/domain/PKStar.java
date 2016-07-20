package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;

/**
 * Created by Hulk on 2014/11/11.
 */
public class PKStar {
    private String nickname;
    private int singer_song_id;
    private int index;
    private String songname;
    private String head;
    private int listen_count;
    private int like_count;
    private String resourcesUrl;
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSinger_song_id() {
        return singer_song_id;
    }

    public void setSinger_song_id(int singer_song_id) {
        this.singer_song_id = singer_song_id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getHead() {
        if (head != null && head.length() != 0)
           return resourcesUrl + head;
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getListen_count() {
        return listen_count;
    }

    public void setListen_count(int listen_count) {
        this.listen_count = listen_count;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public void setResourcesUrl(String resourcesurl) {
        this.resourcesUrl = resourcesurl;
    }
}
