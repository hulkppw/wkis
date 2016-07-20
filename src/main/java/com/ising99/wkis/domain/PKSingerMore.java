package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;

/**
 * Created by Hulk on 2014/11/13.
 */
public class PKSingerMore extends PKSingerBasic {
    private int song_count;
    private String head;
    private String resourcesurl;

    public int getSong_count() {
        return song_count;
    }

    public void setSong_count(int song_count) {
        this.song_count = song_count;
    }

    public String getHead() {
        if (head != null && head.length() != 0)
            return resourcesurl + head;
        return head;
    }

    public void setHead(String head) {

        this.head = head;
    }


    public void setResourcesUrl(String resourcesurl) {
        this.resourcesurl = resourcesurl;
    }
}
