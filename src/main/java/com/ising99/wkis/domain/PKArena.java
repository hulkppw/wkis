package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;

import java.util.Date;

/**
 * Created by Hulk on 2014/11/11.
 */
public class PKArena {
    private int id;
    private String name;
    private String image;
    private int arena_song_id;
    private String song_id;
    private String song_name;
    private String singer_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        if (image != null && image.length() != 0) {
            image = WebConfig.MANAGE_URL + image;
        }
        this.image = image;
    }

    public int getArena_song_id() {
        return arena_song_id;
    }

    public void setArena_song_id(int arena_song_id) {
        this.arena_song_id = arena_song_id;
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }
}
