package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;

/**
 * Created by is214001 on 2014/8/25.
 */
public class ImusicBg {
    private String title;
    private String smallimg;
    private String bigimg;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
