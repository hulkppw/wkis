package com.ising99.wkis.domain;

/**
 * Created by Hulk on 2014/11/24.
 */
public class PKArenaSongInfo {
    private int id;
    private String song_name;
    private int is_is9;
    private int song_id;
    private int singer_id;
    private String singer_name;
    private int arena_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public int getIs_is9() {
        return is_is9;
    }

    public void setIs_is9(int is_is9) {
        this.is_is9 = is_is9;
    }

    public int getSinger_id() {
        return singer_id;
    }

    public void setSinger_id(int singer_id) {
        this.singer_id = singer_id;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public int getArena_id() {
        return arena_id;
    }

    public void setArena_id(int arena_id) {
        this.arena_id = arena_id;
    }

}
