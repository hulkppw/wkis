package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;

/**
 * Created by is214001 on 2014/8/25.
 */
public class ImusicLike {

    private int id;
    private String songid;
    private String name;
    private String singer;
    private String singerid;
    private int isis9;
    private int ison;
    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongid() {
        return songid;
    }

    public void setSongid(String songid) {
        this.songid = songid;
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

    public String getSingerid() {
        return singerid;
    }

    public void setSingerid(String singerid) {
        this.singerid = singerid;
    }

    public int getIsis9() {
        return isis9;
    }

    public void setIsis9(int isis9) {
        this.isis9 = isis9;
    }

    public int getIson() {
        return ison;
    }

    public void setIson(int ison) {
        this.ison = ison;
    }

    public String getImg() {
        if (img != null && img.length() != 0) {
            img = WebConfig.MANAGE_URL + img;
        }
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
