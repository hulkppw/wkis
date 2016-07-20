package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;

/**
 * Created by is214001 on 2014/8/25.
 */
public class ImusicInstrument {
    private String name;
    private String tag;
    private String smallimg;
    private String bigimg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSmallimg() {
        return smallimg;
    }

    public void setSmallimg(String smallimg) {
        if (smallimg != null && smallimg.length() != 0) {
            smallimg = WebConfig.MANAGE_URL + smallimg;
        }
        this.smallimg = smallimg;
    }

    public String getBigimg() {
        return bigimg;
    }

    public void setBigimg(String bigimg) {
        if (bigimg != null && bigimg.length() != 0) {
            bigimg = WebConfig.MANAGE_URL + bigimg;
        }
        this.bigimg = bigimg;
    }
}
