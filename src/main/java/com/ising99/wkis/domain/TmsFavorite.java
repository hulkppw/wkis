package com.ising99.wkis.domain;

import java.sql.Timestamp;

/**
 * Created by Raise on 2015/1/21.
 */
public class TmsFavorite {
    private int id;
    private int userid;	//	用户编号
    private String song_id;	//	歌单编号
    private String name;	//	歌曲名称
    private String singer;	//	歌手名称
   private String singer_id;	//	歌手id
   private Boolean is_on;	//	是否上架
   private Boolean is_is9;	//	是否是人声导唱歌曲
   private int singertype;	//	类别1男歌手，2女歌手，3乐团组合，4男女合唱，5女女合唱，6男男合唱，7其它
   private int languagecode;//	语言类别
    private String spell;	//	拼音
    private int scene1;	//	主场景
    private int scene2;		//	副场景
    private Timestamp createtime	;//创建时间
    private int language;

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSinger_id() {
        return singer_id;
    }

    public void setSinger_id(String singer_id) {
        this.singer_id = singer_id;
    }

    public Boolean getIs_on() {
        return is_on;
    }

    public void setIs_on(Boolean is_on) {
        this.is_on = is_on;
    }

    public Boolean getIs_is9() {
        return is_is9;
    }

    public void setIs_is9(Boolean is_is9) {
        this.is_is9 = is_is9;
    }

    public int getSingertype() {
        return singertype;
    }

    public void setSingertype(int singertype) {
        this.singertype = singertype;
    }

    public int getLanguagecode() {
        return languagecode;
    }

    public void setLanguagecode(int languagecode) {
        this.languagecode = languagecode;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public int getScene1() {
        return scene1;
    }

    public void setScene1(int scene1) {
        this.scene1 = scene1;
    }

    public int getScene2() {
        return scene2;
    }

    public void setScene2(int scene2) {
        this.scene2 = scene2;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
}
