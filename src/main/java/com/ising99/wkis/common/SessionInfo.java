package com.ising99.wkis.common;

/**
 * Created by jerry on 2014/8/26.
 */
public class SessionInfo {

    private String userId;
    private int devType;
    private String wanIp;
    private String lanIp;
    private String mac;
    private String member;
    private int partner;

    public SessionInfo() {
        this.userId = "";
        this.devType = 0;
        this.wanIp = "";
        this.lanIp = "";
        this.mac = "";
        this.member = "";
        this.partner = 0;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the devType
     */
    public int getDevType() {
        return devType;
    }

    /**
     * @param devType the devType to set
     */
    public void setDevType(int devType) {
        this.devType = devType;
    }

    /**
     * @return the wanIp
     */
    public String getWanIp() {
        return wanIp;
    }

    /**
     * @param wanIp the wanIp to set
     */
    public void setWanIp(String wanIp) {
        this.wanIp = wanIp;
    }

    /**
     * @return the lanIp
     */
    public String getLanIp() {
        return lanIp;
    }

    /**
     * @param lanIp the lanIp to set
     */
    public void setLanIp(String lanIp) {
        this.lanIp = lanIp;
    }

    /**
     * @return the mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * @param mac the mac to set
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * @return the member
     */
    public String getMember() {
        return member;
    }

    /**
     * @param member the member to set
     */
    public void setMember(String member) {
        this.member = member;
    }

    /**
     * @return 合作伙伴
     */
    public int getPartner() {
        return partner;
    }

    /**
     * @param partner 合作伙伴
     */
    public void setPartner(int partner) {
        this.partner = partner;
    }
}
