package com.ising99.wkis.utils;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * Created by jerry on 2015/3/11.
 */
public class IPUtils {
    private static final Logger logger = Logger.getLogger(IPUtils.class);
    /**
     * 将ip信息缓存
     */
    private static HashMap<String, IPInfo> ipDB = new HashMap<String, IPInfo>();

    public static IPInfo getIpInfoFromBaiDu(String ip) {
        if (ipDB.containsKey(ip)) {
            return ipDB.get(ip);
        }
        //http://developer.baidu.com/map/index.php?title=webapi/ip-api
        String s = "";
        try {
            String urlStr = "http://api.map.baidu.com/location/ip?ak=EE9237ba272fa4dc9a1756a3ccef618b&ip=" + ip;
            s = getString(urlStr);
            if (s == null) {
                return null;
            }
            if (s.equals("")) {
                return null;
            }
            JSONObject jObject = new JSONObject(s);
            IPInfo ipInfo = new IPInfo();
            String address = jObject.getString("address");
            ipInfo.setCountry(address.substring(0, address.indexOf("|")));
            jObject = jObject.getJSONObject("content").getJSONObject("address_detail");
            ipInfo.setCity(jObject.getString("city"));
            ipInfo.setProvince(jObject.getString("province"));
            ipDB.put(ip,ipInfo);
            return ipInfo;
        } catch (Exception e) {
            logger.error(s, e);
            return null;
        }
    }

    public static IPInfo getIpInfoFromTaoBao(String ip) {
        if (ipDB.containsKey(ip)) {
            return ipDB.get(ip);
        }
        //http://ip.taobao.com/instructions.php
        String s = "";
        try {
            String urlStr = "http://ip.taobao.com/service/getIpInfo.php?ip=" + ip;
            s = getString(urlStr);
            if (s == null) {
                return null;
            }
            if (s.equals("")) {
                return null;
            }
            JSONObject jObject = new JSONObject(s).getJSONObject("data");
            IPInfo ipInfo = new IPInfo();

            ipInfo.setCountry(jObject.getString("country_id"));
            ipInfo.setCity(jObject.getString("city"));
            ipInfo.setProvince(jObject.getString("region"));
            ipDB.put(ip,ipInfo);
            return ipInfo;
        } catch (Exception e) {
            logger.error(s, e);
            return null;
        }
    }

    private static String getString(String urlStr) {
        InputStream is = null;
        ByteArrayOutputStream swapStream = null;
        try {

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(2 * 1000);
            conn.setReadTimeout(4 * 1000);
            conn.setRequestMethod("GET");

            conn.setRequestProperty("Accept-Language", "zh-CN");
            conn.setRequestProperty("Host", "api.map.baidu.com");
            conn.setRequestProperty("Charset", "UTF-8");

            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.connect();
            if (conn.getResponseCode() == 200 || conn.getResponseCode() == 206) {
                is = conn.getInputStream();
                swapStream = new ByteArrayOutputStream();
                int len;
                byte[] buf = new byte[1024];
                while ((len = is.read(buf)) != -1) {
                    swapStream.write(buf, 0, len);
                }
                byte[] data = swapStream.toByteArray();
                return new String(data, Charset.forName("UTF-8"));
            } else {
                throw new IOException("response code is " + conn.getResponseCode());
            }
        } catch (IOException e) {
            logger.error(e);
            return "";
        } catch (Exception e) {
            logger.error(e);
            return "";
        } finally {
            try {
                if (swapStream != null) {
                    swapStream.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }
}
