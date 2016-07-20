package com.ising99.wkis.parameter;


public class TFavoritesSongParam extends PageBaseParam{


    private String userid;

    private int id;
private int favoritesid;
    private String songspell;

    public int getFavoritesid() {
        return favoritesid;
    }

    public void setFavoritesid(int favoritesid) {
        this.favoritesid = favoritesid;
    }

    public String getSongspell() {
        return songspell;
    }

    public void setSongspell(String songspell) {
        this.songspell = songspell;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


}