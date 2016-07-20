package com.ising99.wkis.parameter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by is214014 on 14-5-26.
 */
public class OsDownloadInfoParam implements Serializable{

    private String next_version;
    private String version;
    private String ip;
    private String wifimac;
    private String mac;
    private String sn;
    private String koiccode;

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public String getNext_version() {
        return next_version;
    }

    public void setNext_version(String next_version) {
        this.next_version = next_version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getWifimac() {
        return wifimac;
    }

    public void setWifimac(String wifimac) {
        this.wifimac = wifimac;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getKoiccode() {
        return koiccode;
    }

    public void setKoiccode(String koiccode) {
        this.koiccode = koiccode;
    }

    private String firmware;

}
