package com.ising99.wkis.domain;

import java.util.Date;

/**
 * Created by Administrator on 2015-02-07.
 */
public class KoicCode {

    /*    `ID` INT(11) NOT NULL AUTO_INCREMENT,
        `KOICCODE` VARCHAR(17) NOT NULL COMMENT 'KOICcode号码',
                `MAC` VARCHAR(17) NULL DEFAULT NULL COMMENT '机器MAC地址',
                `ACTIVEDATE` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '激活日期',*/
    private int id;
    private String koiccode;
    private String mac;
    private Date activedate;


    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getKoiccode() {
        return koiccode;
    }

    public void setKoiccode(String koiccode) {
        this.koiccode = koiccode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getActivedate() {
        return activedate;
    }

    public void setActivedate(Date activedate) {
        this.activedate = activedate;
    }
}
