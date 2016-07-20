package com.ising99.wkis.common;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by jerry on 2014/6/28.
 */
public class WebConfig {

    public static String TV_APP_WEB_URL_CN = "";
    public static String TV_APP_WEB_URL_TW = "";
    public static String MANAGE_URL = "";
    public static String OTA_URL_CN = "";
    public static String OTA_URL_TW = "";
    private static final Properties sysConfig = new Properties();
    private static Map<String, String> KUS_SERVER;

    static {
        try {
            sysConfig.load(WebConfig.class.getResourceAsStream("/config.properties"));
            TV_APP_WEB_URL_CN = sysConfig.getProperty("WebConfig.TvAppWebUrlCN");
            System.out.print("TV_APP_WEB_URL_CN:" + TV_APP_WEB_URL_CN);
            TV_APP_WEB_URL_TW = sysConfig.getProperty("WebConfig.TvAppWebUrlTW");
            System.out.print("TV_APP_WEB_URL_TW:" + TV_APP_WEB_URL_TW);
            //System.out.print("TV_APP_WEB_URL:" + TV_APP_WEB_URL);
            MANAGE_URL = sysConfig.getProperty("WebConfig.ManageUrl");
            OTA_URL_CN = sysConfig.getProperty("WebConfig.OTAUrlCN");
            OTA_URL_TW = sysConfig.getProperty("WebConfig.OTAUrlTW");
            KUS_SERVER = new HashMap<String, String>();
            try{

                String servers = sysConfig.getProperty("KUS.Servers");
                if(servers.contains(",")) {
                    //有n条数据
                    String[] arr = servers.split(",");
                    for (String s:arr){
                        String[] tempArr = s.split("-");
                        KUS_SERVER.put(tempArr[0],tempArr[1]);
                    }
                }else{
                    //只有一条数据
                    String[] arr = servers.split("-");
                    KUS_SERVER.put(arr[0],arr[1]);
                }

            }catch (Exception ex){
                ex.printStackTrace();
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getKUSUrl(String id) {
        if (!KUS_SERVER.containsKey(id)) {
            return null;
        }
        String url = KUS_SERVER.get(id);
        if (url == null) {
            return null;
        }
        if (url.trim().length() == 0) {
            return null;
        }
        return url.endsWith("/") ? url : url + "/";
    }


}
