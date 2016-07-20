package com.ising99.wkis.utils;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2015-02-06.
 */
public class SessionManager {

    //private static final Logger logger = Logger.getLogger(UserController.class);
    private static Logger logger = Logger.getLogger(SessionManager.class);
    private final static String key = "ising_99";
    private final static String delimiter = "<@#$%>";

    public static String createSession(String userId, int devType, String wanIp, String lanIp, String mac) {
        return createSession(userId, devType, wanIp, lanIp, mac, "", 0);
    }

    public static String createSession(String userId, int devType, String wanIp, String lanIp, String mac, String member, int partner) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(userId == null ? "" : userId);
            sb.append(delimiter);
            sb.append(devType);
            sb.append(delimiter);
            sb.append(wanIp == null ? "" : wanIp);
            sb.append(delimiter);
            sb.append(lanIp == null ? "" : lanIp);
            sb.append(delimiter);
            sb.append(mac == null ? "" : mac);
            sb.append(delimiter);
            sb.append(member == null ? "" : member);
            sb.append(delimiter);
            sb.append(partner);

            return DES.encrypt(sb.toString(), key);
        } catch (Exception e) {
            logger.error(e);
            return "";
        }
    }

   /* public static SessionInfo readSession(String session) {
        try {

            String s = DES.decrypt(session, key);
            // 1000020<@#$%>11<@#$%>192.168.0.28<@#$%><@#$%>
            int beginIndex = 0;
            int endIndex = s.indexOf(delimiter);
            SessionInfo sessionInfo = new SessionInfo();
            if (endIndex < 0) {
                return sessionInfo;
            }
            sessionInfo.setUserId(s.substring(0, endIndex));

            beginIndex = endIndex + delimiter.length();
            endIndex = s.indexOf(delimiter, endIndex + 1);
            String devType = s.substring(beginIndex, endIndex);
            devType = devType.length() == 0 ? "0" : devType;
            sessionInfo.setDevType(Integer.parseInt(devType));

            beginIndex = endIndex + delimiter.length();
            endIndex = s.indexOf(delimiter, endIndex + 1);
            sessionInfo.setWanIp(s.substring(beginIndex, endIndex));

            beginIndex = endIndex + delimiter.length();
            endIndex = s.indexOf(delimiter, endIndex + 1);
            sessionInfo.setLanIp(s.substring(beginIndex, endIndex));

            beginIndex = endIndex + delimiter.length();
            endIndex = s.indexOf(delimiter, endIndex + 1);
            if (endIndex < 0) {
                return sessionInfo;
            }
            sessionInfo.setMac(s.substring(beginIndex, endIndex));

            beginIndex = endIndex + delimiter.length();
            endIndex = s.indexOf(delimiter, endIndex + 1);
            if (endIndex < 0) {
                return sessionInfo;
            }
            sessionInfo.setMember(s.substring(beginIndex, endIndex));

            beginIndex = endIndex + delimiter.length();
            endIndex = s.length();
            String partner = s.substring(beginIndex, endIndex);
            partner = partner.length() == 0 ? "0" : partner;
            sessionInfo.setPartner(Integer.parseInt(partner));
            return sessionInfo;

        } catch (Exception e) {
            logger.error(e);
            return new SessionInfo();
        }
    }*/
}