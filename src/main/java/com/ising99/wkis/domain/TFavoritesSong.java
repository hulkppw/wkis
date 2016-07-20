package com.ising99.wkis.domain;

import java.sql.Timestamp;

/**
 * Created by Raise on 2015/2/6.
 */
public class TFavoritesSong {
   private int id;
   private int isis9;
    private int languagecode;
    private int favoritesid;
   private String singerid;
  private String singername;
    private String songid;
   private String songname;
   private String songspell;
    private int songtype;
    private String userid;
    private Timestamp createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsis9() {
        return isis9;
    }

    public void setIsis9(int isis9) {
        this.isis9 = isis9;
    }

    public int getLanguagecode() {
        return languagecode;
    }

    public void setLanguagecode(int languagecode) {
        this.languagecode = languagecode;
    }

    public int getFavoritesid() {
        return favoritesid;
    }

    public void setFavoritesid(int favoritesid) {
        this.favoritesid = favoritesid;
    }

    public String getSingerid() {
        return singerid;
    }

    public void setSingerid(String singerid) {
        this.singerid = singerid;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
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

    public String getSongspell() {
        return songspell;
    }

    public void setSongspell(String songspell) {
        this.songspell = songspell;
    }

    public int getSongtype() {
        return songtype;
    }

    public void setSongtype(int songtype) {
        this.songtype = songtype;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
}
