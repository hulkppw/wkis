package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;

import java.util.Date;

/**
 * Created by jerry on 2014/6/27.
 */
public class TVAppInfo {


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

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        if (icon != null && icon.length() != 0) {
            icon = tvAppUrl + icon;
        }
        return icon;
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

    public String getDesign1() {
        if (design1 != null && design1.length() != 0) {
            design1 = tvAppUrl + design1;
        }
        return design1;
    }

    public void setDesign1(String design1) {
        this.design1 = design1;
    }

    public String getDesign2() {
        if (design2 != null && design2.length() != 0) {
            design2 = tvAppUrl + design2;
        }
        return design2;
    }

    public void setDesign2(String design2) {
        this.design2 = design2;
    }

    public String getDesign3() {
        if (design3 != null && design3.length() != 0) {
            design3 = tvAppUrl + design3;
        }
        return design3;
    }

    public void setDesign3(String design3) {
        this.design3 = design3;
    }

    public String getDesign4() {
        if (design4 != null && design4.length() != 0) {
            design4 = tvAppUrl + design4;
        }
        return design4;
    }

    public void setDesign4(String design4) {
        this.design4 = design4;
    }

    private int appinfoid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String icon;
    private String version;
    private Date createtime;
    private int size;
    private int download;
    private String design1;
    private String design2;
    private String design3;
    private String design4;
    private String resume;
    private String url;
}
