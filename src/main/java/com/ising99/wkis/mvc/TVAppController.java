package com.ising99.wkis.mvc;

import com.ising99.wkis.common.ErrorCode;
import com.ising99.wkis.common.WebConfig;
import com.ising99.wkis.domain.*;
import com.ising99.wkis.parameter.TVAppContentParam;
import com.ising99.wkis.parameter.TVAppDownloadInfoParam;
import com.ising99.wkis.service.TVAppDownloadInfoService;
import com.ising99.wkis.service.TVAppService;
import com.ising99.wkis.utils.IPInfo;
import com.ising99.wkis.utils.IPUtils;
import com.ising99.wkis.utils.WebUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by jerry on 2014-05-27.
 */
@Controller
@RequestMapping("app/tv")
public class TVAppController extends BaseController {

    static Logger logger = Logger.getLogger(TVAppController.class);
    @Resource
    TVAppService tvAppService;

    @Resource
    TVAppDownloadInfoService tvAppDownloadInfoService;

    @RequestMapping("/column/ver")
    @ResponseBody
    public String getColumnVersion() throws Exception {
        return "{\"version\":\"" + tvAppService.getColumnVersion() + "\"}";
    }

    @RequestMapping("/apps")
    @ResponseBody
    public PageData<TVContent> getAppList(Integer columnid, Integer pagesize, Integer pageindex, Integer order, String spell) throws Exception {
        TVAppContentParam parameter = new TVAppContentParam();
        parameter.setPageindex(pageindex);
        parameter.setPagesize(pagesize);
        parameter.setColumnid(columnid);
        parameter.setOrder(order);
        parameter.setSpell(spell);
        PageData<TVContent> pageData = tvAppService.getContentPageList(parameter);

        String tvAppUrl = getTvAppUrl();

        List<TVContent> list = pageData.getList();
        if (list != null) {
            for (TVContent tvContent : list) {
                tvContent.setTvAppUrl(tvAppUrl);
            }
            pageData.setList(list);
        }

        return pageData;
    }

    /**
     * 获取分类列表
     *
     * @return
     */
    @RequestMapping("/column/category")
    @ResponseBody
    public List<Map> getCategory() throws Exception {
        String tvAppUrl = getTvAppUrl();

        List<TVColumnInfo> list = tvAppService.getColumnListByPid(31);
        if (list != null) {
            for (TVColumnInfo tvColumnInfo : list) {
                tvColumnInfo.setTvAppUrl(tvAppUrl);
            }
        }
        Map avType = new HashMap();
        avType.put("category", "31");
        avType.put("list", list);

        list = tvAppService.getColumnListByPid(32);
        if (list != null) {
            for (TVColumnInfo tvColumnInfo : list) {
                tvColumnInfo.setTvAppUrl(tvAppUrl);
            }
        }
        Map appType = new HashMap();
        appType.put("category", "32");
        appType.put("list", list);

        list = tvAppService.getColumnListByPid(33);
        if (list != null) {
            for (TVColumnInfo tvColumnInfo : list) {
                tvColumnInfo.setTvAppUrl(tvAppUrl);
            }
        }
        Map gameType = new HashMap();
        gameType.put("category", "33");
        gameType.put("list", list);

        List<Map> data = new ArrayList<Map>();
        data.add(avType);
        data.add(appType);
        data.add(gameType);

        return data;
    }

    /**
     * 获取推荐栏目列表
     *
     * @return
     */
    @RequestMapping("/column/recommend")
    @ResponseBody
    public List<TVRecommendColumn> getRecommendColumn() throws Exception {
        List<TVRecommendColumn> list = tvAppService.getRecommendColumn();
        if (list == null) {
            this.responseErrorCode(ErrorCode.NO_RECORD);
        }
        String tvAppUrl = getTvAppUrl();
        for (TVRecommendColumn tvRecommendColumn : list) {
            tvRecommendColumn.setTvAppUrl(tvAppUrl);
        }
        return list;
    }

    private String getTvAppUrl() {
        String ip = "";
        try {
            ip = WebUtils.getIpAddr(this.request);
        } catch (Exception ex) {
            return WebConfig.OTA_URL_TW;
        }

        IPInfo ipInfo = IPUtils.getIpInfoFromBaiDu(ip);
        if (ipInfo == null) {
            ipInfo = IPUtils.getIpInfoFromTaoBao(ip);
        }
        if (ipInfo == null) {
            return WebConfig.TV_APP_WEB_URL_TW;
        } else {
            if (ipInfo.getCountry().toUpperCase().equals("TW")) {
                return WebConfig.TV_APP_WEB_URL_TW;
            } else {
                return WebConfig.TV_APP_WEB_URL_CN;
            }
        }
    }

    /**
     * 获取appinfo信息
     *
     * @param appinfoid
     * @return
     */
    @RequestMapping("/appinfo")
    @ResponseBody
    public TVAppInfo getTVAppInfo(int appinfoid) throws Exception {
        TVAppInfo tvAppInfo = tvAppService.getAppInfo(appinfoid);
        if (tvAppInfo == null) {
            this.responseErrorCode(ErrorCode.NO_RECORD);
        }
        tvAppInfo.setTvAppUrl(getTvAppUrl());
        return tvAppInfo;
    }


    /**
     * 获取app版本信息
     *
     * @param packagename
     * @return
     */

    @RequestMapping("/appver")
    @ResponseBody
    public TVAppVersionInfo getTVAppVersion(String packagename) throws Exception {
        TVAppVersionInfo tvAppVersionInfo = tvAppService.getAppVersionInfo(packagename);
        if (tvAppVersionInfo == null) {
            this.responseErrorCode(ErrorCode.NO_RECORD);
            return null;
        }
        //根据ip设置下载地址路径
        tvAppVersionInfo.setTvAppUrl(getTvAppUrl());
        return tvAppVersionInfo;
    }

    /**
     * 统计功能
     *
     * @param appDownloadInfo
     * @return
     */
    @RequestMapping("/statistics")
    @ResponseBody
    public boolean statistics(TVAppDownloadInfoParam appDownloadInfo) throws Exception {
        if (appDownloadInfo == null) {
            return false;
        }
        if (appDownloadInfo.getAppinfoid() == null) {
            return false;
        }
        try{
            appDownloadInfo.setIp(WebUtils.getIpAddr(request));
        }catch (Exception e){
            appDownloadInfo.setIp("");
        }

        appDownloadInfo.setCreatetime(new Date());
        TVAppInfo tvAppInfo = tvAppService.getAppInfo(appDownloadInfo.getAppinfoid());
        if (tvAppInfo == null) {
            return false;
        }
        //这个统计功能需要后期优化一下。增加鉴别刷榜行为
        tvAppService.updateDownloadCount(appDownloadInfo.getAppinfoid());
        return tvAppDownloadInfoService.insert(appDownloadInfo) == 1;
    }

}
