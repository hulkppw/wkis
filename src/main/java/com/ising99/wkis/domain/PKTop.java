package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;

/**
 * Created by Hulk on 2014/11/11.
 */
public class PKTop {
    private int singer_song_id;
    private int singer_id;
    private String nickname;
    private int score;
    private String ip;
    private String head;
    private int listen_count;
    private int like_count;
    private int arena_song_id;
    private String resourcesurl;

    public int getSinger_song_id() {
        return singer_song_id;
    }

    public void setSinger_song_id(int singer_song_id) {
        this.singer_song_id = singer_song_id;
    }

    public int getSinger_id() {
        return singer_id;
    }

    public void setSinger_id(int singer_id) {
        this.singer_id = singer_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        if (ip != null && ip.length() != 0) {
            try {
                String[] numbers = ip.split("\\.");
                this.ip = numbers[0] + "." + numbers[1] + "." + "*.*";
            }catch (Exception e) {
                this.ip = "127.0.*.*";
            }
        }
    }

    public String getHead() {
        if (head != null && head.length() != 0)
            return resourcesurl + head;
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

    public int getArena_song_id() {
        return arena_song_id;
    }

    public void setArena_song_id(int arena_song_id) {
        this.arena_song_id = arena_song_id;
    }

    public void setResourcesUrl(String resourcesurl) {
        this.resourcesurl = resourcesurl;
    }
}
