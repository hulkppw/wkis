package com.ising99.wkis.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jerry on 2014/6/28.
 */
public class WebUtils {
    /**
     * 获取客户端机器IP地址
     *
     * @param request
     * @return
     * @author guobingbing
     * @version 1.0
     * @since 2011-2-18 下午02:14:18
     */
    public static String getIpAddr(HttpServletRequest request) throws  NullPointerException{
        String ip = request.getHeader("x-forwarded-for");
        if (!checkIp(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (!checkIp(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (!checkIp(ip)) {
            ip = request.getRemoteAddr();
        }
        if(!checkIp(ip)){
            throw new NullPointerException("获取的ip地址为空");
        }
        //如果ip地址中包含逗号，例如：202.108.137.84, 114.80.174.81, 121.42.17.203，截取第一个ip地址为真实ip
        String d = ",";
        if (ip.contains(d)) {
            int index = ip.indexOf(d);
            ip = ip.substring(0, index);
        }
        return ip;
    }

    /**
     * 检查ip是否合法
     * @param ip
     * @return
     */
    private static boolean checkIp(String ip){
        if(ip == null){
            return false;
        }
        ip = ip.trim();
        if(ip.length() == 0){
            return false;
        }
        if("unknown".equalsIgnoreCase(ip)){
            return false;
        }
        return true;
    }
}
