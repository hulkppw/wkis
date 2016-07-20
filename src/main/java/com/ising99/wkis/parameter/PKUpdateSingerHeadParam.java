package com.ising99.wkis.parameter;

/**
 * Created by Hulk on 2014/12/17.
 */
public class PKUpdateSingerHeadParam {
    private int singerid;
    private String head_image;

    public String getResourcesUrl() {
        return resourcesUrl;
    }

    public void setResourcesUrl(String resourcesUrl) {
        this.resourcesUrl = resourcesUrl;
    }

    private String resourcesUrl;

    public PKUpdateSingerHeadParam() {
    }

    public PKUpdateSingerHeadParam(int singerid, String head_image, String resourcesUrl) {
        this.singerid = singerid;
        this.head_image = head_image;
        this.resourcesUrl = resourcesUrl;
    }

    public int getSingerid() {
        return singerid;
    }

    public void setSingerid(int singerid) {
        this.singerid = singerid;
    }

    public String getHead_image() {
        return head_image;
    }

    public void setHead_image(String head_image) {
        this.head_image = head_image;
    }
}
