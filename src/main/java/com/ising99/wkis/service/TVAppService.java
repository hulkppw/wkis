package com.ising99.wkis.service;

import com.ising99.wkis.domain.*;
import com.ising99.wkis.parameter.TVAppContentParam;

import java.util.List;

/**
 * Created by jerry on 2014/6/28.
 */
public interface TVAppService {
    Long getColumnVersion();
    List<TVColumnInfo> getColumnListByPid(Integer parentId);
    List<TVRecommendColumn> getRecommendColumn();
    PageData<TVContent> getContentPageList(TVAppContentParam parameter);
    TVAppInfo getAppInfo(Integer appinfoid);
    TVAppVersionInfo getAppVersionInfo(String packagename);
    void updateDownloadCount(Integer appinfoId);
}
