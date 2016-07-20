package com.ising99.wkis.domain;

import java.io.Serializable;

public class SimpleMusicInfo implements Serializable {

    private String id;
    private int language;
    private String singerid;
    private String singer;
    private String singertype;//歌手类型 1.男歌手 2.女歌手
    private String name;
    private int isis9;
    private String spell;
    private int s1;
    private int s2;
    private String singername1;
    private String singername2;
    private String singername3;
    private String singername4;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSingertype() {
        return singertype;
    }

    public void setSingertype(String singertype) {
        this.singertype = singertype;
    }

    public void setSingername1(String singername1) {
        this.singername1 = singername1;
    }

    public void setSingername2(String singername2) {
        this.singername2 = singername2;
    }

    public void setSingername3(String singername3) {
        this.singername3 = singername3;
    }

    public void setSingername4(String singername4) {
        this.singername4 = singername4;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public String getSingerid() {
        return singerid;
    }

    public void setSingerid(String singerid) {
        this.singerid = singerid;
    }

    public String getSinger() {
        if (singer != null && !singer.equals("")) {
            return this.singer;
        }
        singer = singername1;
        if (singername2 != null && !singername2.equals("")) {
            singer = singer + "/" + singername2;
        }
        if (singername3 != null && !singername3.equals("")) {
            singer = singer + "/" + singername3;
        }
        if (singername4 != null && !singername4.equals("")) {
            singer = singer + "/" + singername4;
        }
        return singer;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsis9() {
        return isis9;
    }

    public void setIsis9(int isis9) {
        this.isis9 = isis9;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public int getS1() {
        return s1;
    }

    public void setS1(int s1) {
        this.s1 = s1;
    }

    public int getS2() {
        return s2;
    }

    public void setS2(int s2) {
        this.s2 = s2;
    }

}
