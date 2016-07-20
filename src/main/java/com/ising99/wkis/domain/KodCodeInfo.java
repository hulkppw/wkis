package com.ising99.wkis.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2014-12-06.
 */
public class KodCodeInfo implements Serializable {
    private int id;
    private String mac;
    private String sncode;
    private String hnuserid;
    //    private String randusercode;
    private int stated;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getMac()
    {
        return mac;
    }
    public void setMac(String mac)
    {
        this.mac = mac;
    }
    public String getSncode()
    {
        return sncode;
    }
    public void setSncode(String sncode)
    {
        this.sncode = sncode;
    }

    public String getHnuserid()
    {
        return hnuserid;
    }
    public void setHnuserid(String hnuserid)
    {
        this.hnuserid = hnuserid;
    }
    public int getStated()
    {
        return stated;
    }
    public void setStated(int stated)
    {
        this.stated = stated;
    }



}