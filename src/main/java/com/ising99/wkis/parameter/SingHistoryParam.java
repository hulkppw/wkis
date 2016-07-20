package com.ising99.wkis.parameter;

import java.util.Date;

/**
 * Created by Hulk on 2015/02/06.
 */
public class SingHistoryParam extends PageBaseParam{
    private int id;
    private int isis9;
    private int languagecode;
    private String singerid;
    private String singername;
    private String songid;
    private String songname;
    private String songspell;
    private int songtype;
    private String userid;
    private Date createtime;

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}

