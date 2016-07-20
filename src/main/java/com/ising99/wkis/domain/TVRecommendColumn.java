package com.ising99.wkis.domain;


import com.ising99.wkis.common.WebConfig;


/**
 * Created by jerry on 2014/6/27.
 */
public class TVRecommendColumn {

    private int id;
    private String title;
    /**
     * 配置文件中的tv_app_web_url
     */
    private String tvAppUrl;

    public void setTvAppUrl(String tvAppUrl) {
        this.tvAppUrl = tvAppUrl;
    }
    public String getIcon() {
        if (icon != null && icon.length() != 0) {
            icon = tvAppUrl + icon;
        }
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    private String icon;

    public int getAppinfoid() {
        return appinfoid;
    }

    public void setAppinfoid(int appinfoid) {
        this.appinfoid = appinfoid;
    }

    private int appinfoid;
    private String packageName;

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

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    private int tag;
}
