package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;

import java.io.File;

/**
 * Created by Hulk on 2014/11/13.
 * 歌曲信息
 */
public class PKSingerSongInfo {
    private int id;
    private String nickname;
    private int score;
    private String songid;
    private String songname;
    private String waveform_url;
    private String mp3_url;
    private String is9_url;
    private int arena_id;
    private int arena_song_id;
    private int singer_id;
    private String head;
    private int listen_count;
    private int like_count;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSongid() {
        return songid;
    }

    public void setSongid(String songid) {
        this.songid = songid;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getWaveform_url() {
        if (waveform_url != null && waveform_url.length() != 0)
            return resourcesurl + waveform_url;
        return waveform_url;
    }

    public void setWaveform_url(String waveform_url) {
        this.waveform_url = waveform_url;
    }

    public String getMp3_url() {
        if (mp3_url != null && mp3_url.length() != 0)
            return resourcesurl + mp3_url;
        return this.mp3_url;
    }

    public void setMp3_url(String mp3_url) {
        this.mp3_url = mp3_url;
    }

    public String getIs9_url() {
        if (is9_url != null && is9_url.length() != 0)
            return resourcesurl + is9_url;
        return is9_url;
    }

    public void setIs9_url(String is9_url) {
        this.is9_url = is9_url;
    }

    public int getArena_id() {
        return arena_id;
    }

    public void setArena_id(int arena_id) {
        this.arena_id = arena_id;
    }

    public int getArena_song_id() {
        return arena_song_id;
    }

    public void setArena_song_id(int arena_song_id) {
        this.arena_song_id = arena_song_id;
    }

    public int getSinger_id() {
        return singer_id;
    }

    public void setSinger_id(int singer_id) {
        this.singer_id = singer_id;
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

    public void setResourcesUrl(String resourcesurl) {
        this.resourcesurl = resourcesurl;
    }
}
