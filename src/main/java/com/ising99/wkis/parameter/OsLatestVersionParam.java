package com.ising99.wkis.parameter;

/**
 * Created by jerry on 2014/11/12.
 */
public class OsLatestVersionParam {
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getUtc() {
        return utc;
    }

    public void setUtc(long utc) {
        this.utc = utc;
    }

    private String code;
    private long utc;
}
