package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;


import java.util.Date;

/**
 * Created by jerry on 2014/6/27.
 */
public class TVAppVersionInfo {

    public int getAppinfoid() {
        return appinfoid;
    }

    public void setAppinfoid(int appinfoid) {
        this.appinfoid = appinfoid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
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
    /**
     * 配置文件中的tv_app_web_url
     */
    private String tvAppUrl;

    public void setTvAppUrl(String tvAppUrl) {
        this.tvAppUrl = tvAppUrl;
    }
    public String getUrl() {
        if (url != null && url.length() != 0) {
            url = tvAppUrl + url;
        }
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    private int appinfoid;
    private String version;
    private int download;
    private int size;
    private Date createtime;
    private String resume;
    private String icon;
    private String url;
    private String md5;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    private String name;
    private String packagename;
}
