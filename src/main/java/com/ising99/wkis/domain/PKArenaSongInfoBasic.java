package com.ising99.wkis.domain;

/**
 * Created by Hulk on 2014/11/27.
 */
public class PKArenaSongInfoBasic extends PKArenaSong {
    private int arena_id;
    private int language;

    public int getArena_id() {
        return arena_id;
    }

    public void setArena_id(int arena_id) {
        this.arena_id = arena_id;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }
}
