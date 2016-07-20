package com.ising99.wkis.domain;

import java.util.Date;

/**
 * Created by Hulk on 2014/11/13.
 * 歌手作品
 */
public class PKSingerSongList {
    private int id;
    private String songname;
    private int score;
    private int listen_count;
    private int like_count;
    private Date createtime;
    private int ranking;
    private int arena_song_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public int getRanking() {
        return ranking;
    }

    public long getCreatetime() {
        return createtime.getTime();
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getArena_song_id() {
        return arena_song_id;
    }

    public void setArena_song_id(int arena_song_id) {
        this.arena_song_id = arena_song_id;
    }
}
