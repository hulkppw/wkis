package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;

/**
 * Created by Hulk on 2014/11/17.
 * 添加歌手返回的歌手信息对象
 */
public class PKSingerAdd {
    private int singer_id;
    private String nickname;
    private String head;
    private String resourcesurl;

    public int getSinger_id() {
        return singer_id;
    }

    public void setSinger_id(int singer_id) {
        this.singer_id = singer_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setResourcesUrl(String resourcesurl) {
        this.resourcesurl = resourcesurl;
    }
}
