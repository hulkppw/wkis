package com.ising99.wkis.domain;

import com.ising99.wkis.common.WebConfig;

/**
 * Created by Hulk on 2014/11/11.
 */
public class PKHead {
    private int id;

    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        if (img != null && img.length() != 0) {
            img = WebConfig.MANAGE_URL + img;
        }
        this.img = img;
    }
}
