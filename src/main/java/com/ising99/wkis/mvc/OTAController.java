package com.ising99.wkis.mvc;

import com.ising99.wkis.common.ErrorCode;
import com.ising99.wkis.common.WebConfig;
import com.ising99.wkis.domain.Os;
import com.ising99.wkis.parameter.OsDownloadInfoParam;
import com.ising99.wkis.parameter.OsLatestVersionParam;
import com.ising99.wkis.service.OsDownloadInfoService;
import com.ising99.wkis.service.OsService;
import com.ising99.wkis.utils.IPInfo;
import com.ising99.wkis.utils.IPUtils;
import com.ising99.wkis.utils.WebUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("ota")
public class OTAController extends BaseController {
    private static Logger logger = Logger.getLogger(OTAController.class);
    @Resource
    private OsService osService;

    @Resource
    private OsDownloadInfoService osDownloadInfoService;


    @RequestMapping("/os")
    @ResponseBody
    public Os checkUpdate(String devicecode, Long utc) throws Exception {
        OsLatestVersionParam param = new OsLatestVersionParam();
        param.setCode(devicecode);
        param.setUtc(utc);

        List<Os> list = osService.latestVersionByDeviceCode(param);
        if (list.size() == 0) {
            //如果没有更新数据，根据utc时间返回当前设备Os信息（客户端提出的bt需求）
            return getOwnOsInfo(utc);
        } else {
            Os wholePackageOs = null;//整包
            //list 按照ｕｔｃ时间从大到小排列，先找到ｕｔｃ时间最大的整包
            for (Os os : list) {
                if (os.getType() == 0) {
                    wholePackageOs = os;
                    break;
                }
            }
            //判断是否有整包更新
            if (wholePackageOs == null) {
                //没有整包更新,找到针对当前设备utc时间的增量包
                return getIncrementalPackageOs(list, utc);
            } else {
                wholePackageOs.setOtaUrl(getOTAUrl());
                return wholePackageOs;
            }
        }
    }

    /**
     * 获取增量包信息
     *
     * @param list
     * @param utc
     * @return
     */
    private Os getIncrementalPackageOs(List<Os> list, long utc) {

        Os incrementalPackageOs = null;//增量包
        //找到针对当前设备utc时间的增量包
        for (Os os : list) {
            if (os.getPreviousUtc() == utc) {
                incrementalPackageOs = os;
                break;
            }
        }
        if (incrementalPackageOs == null) {
            //没有针对当前设备utc时间的增量包
            return getOwnOsInfo(utc);//根据utc时间返回当前设备Os信息（客户端提出的bt需求）
        } else {
            //返回增量包信息
            incrementalPackageOs.setOtaUrl(getOTAUrl());
            return incrementalPackageOs;
        }
    }

    private Os getNoOsInfo(long utc) {
        Os os = new Os();
        os.setCode("");
        os.setDescription("");
        os.setMd5("");
        os.setName("");
        os.setSize(0);
        os.setUrl("");
        os.setUtc(utc);
        os.setVersion("");
        os.setOtaUrl(getOTAUrl());
        return os;
    }

    private Os getOwnOsInfo(long utc) {
        List<Os> list = osService.getInfoByUTC(utc);
        if (list.size() == 0) {
            //responseErrorCode(ErrorCode.NO_RECORD);
            logger.debug("utc:" + utc + " 数据库没有信息！");
            return getNoOsInfo(utc);
        } else {
            Os os = list.get(0);
            os.setOtaUrl(getOTAUrl());
            return os;
        }
    }

    private String getOTAUrl() {
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
            return WebConfig.OTA_URL_TW;
        } else {
            if (ipInfo.getCountry().toUpperCase().equals("TW")) {
                return WebConfig.OTA_URL_TW;
            } else {
                return WebConfig.OTA_URL_CN;
            }
        }
    }

    @RequestMapping("/statistics/os")
    @ResponseBody
    public String insert(OsDownloadInfoParam osDownloadInfoParam) throws Exception {

        if (osDownloadInfoParam != null) {
            osDownloadInfoParam.setIp(WebUtils.getIpAddr(this.request));
        }
        osDownloadInfoService.insert(osDownloadInfoParam);
        return "{\"result\":\"ok\"}";
    }


}