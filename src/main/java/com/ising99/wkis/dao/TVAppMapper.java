package com.ising99.wkis.dao;

import com.ising99.wkis.domain.*;
import com.ising99.wkis.parameter.TVAppContentParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jerry on 2014-05-27.
 */
@Repository
public interface TVAppMapper {
    Long getColumnVersion();
    List<TVColumnInfo> getColumnListByPid(Integer parentId);
    List<TVRecommendColumn> getRecommendColumn();
    Integer getContentCount(TVAppContentParam tvAppContentParam);
    List<TVContent> getContentList(TVAppContentParam tvAppContentParam);
    TVAppInfo getAppInfo(Integer appinfoid);
    TVAppVersionInfo getAppVersionInfo(String packagename);
    void updateDownloadCount(Integer appinfoId);
}
