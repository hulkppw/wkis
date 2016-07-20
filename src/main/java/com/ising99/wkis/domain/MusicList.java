package com.ising99.wkis.domain;

import java.sql.Timestamp;

/**
 * Created by Raise on 2015/3/10.
 */
public class MusicList {
    private String songid;
    private String songname;
    private String songspell;
    private int languagecode;
    private String songtype;
    private String singerid1;
    private String singername1;
    private Boolean isis9;

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

    public int getLanguagecode() {
        return languagecode;
    }

    public void setLanguagecode(int languagecode) {
        this.languagecode = languagecode;
    }

    public String getSongtype() {
        return songtype;
    }

    public void setSongtype(String songtype) {
        this.songtype = songtype;
    }

    public String getSingerid1() {
        return singerid1;
    }

    public void setSingerid1(String singerid1) {
        this.singerid1 = singerid1;
    }

    public String getSingername1() {
        return singername1;
    }

    public void setSingername1(String singername1) {
        this.singername1 = singername1;
    }

    public Boolean getIsis9() {
        return isis9;
    }

    public void setIsis9(Boolean isis9) {
        this.isis9 = isis9;
    }
}
