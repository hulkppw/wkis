package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;


/**
 * Created by jerry on 2014/6/27.
 */
public class TVColumnInfo {

    private int id;
    private String title;

    /**
     * 配置文件中的tv_app_web_url
     */
    private String tvAppUrl;

    public void setTvAppUrl(String tvAppUrl) {
        this.tvAppUrl = tvAppUrl;
    }

    public String getImg() {
        if (img != null && img.length() != 0) {
            img = tvAppUrl + img;
        }
        return img;
    }

    public void setImg(String img) {

        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String img;
}
