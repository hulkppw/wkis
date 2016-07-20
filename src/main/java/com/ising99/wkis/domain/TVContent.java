package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;


/**
 * Created by jerry on 2014/6/27.
 */
public class TVContent {

    private int appinfoid;
    private String name;
    private String icon;
    private String version;
    /**
     * 配置文件中的tv_app_web_url
     */
    private String tvAppUrl;

    public void setTvAppUrl(String tvAppUrl) {
        this.tvAppUrl = tvAppUrl;
    }

    public int getAppinfoid() {
        return appinfoid;
    }

    public void setAppinfoid(int appinfoid) {
        this.appinfoid = appinfoid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getDownloadcount() {
        return downloadcount;
    }

    public void setDownloadcount(int downloadcount) {
        this.downloadcount = downloadcount;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private int downloadcount;
    private String packageName;
    private int tag;
    private String type;

}
