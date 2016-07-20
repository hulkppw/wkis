package com.ising99.wkis.service.impl;

import com.ising99.wkis.dao.TVAppMapper;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.domain.*;
import com.ising99.wkis.parameter.TVAppContentParam;
import com.ising99.wkis.service.TVAppService;
import com.ising99.wkis.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jerry on 2014/6/28.
 */
@Service("tvAppService")
public class TVAppServiceImpl implements TVAppService {

    @Resource
    private TVAppMapper tvAppMapper;

    @Override
    public Long getColumnVersion() {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        return tvAppMapper.getColumnVersion();
    }

    @Override
    public List<TVColumnInfo> getColumnListByPid(Integer parentId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        return tvAppMapper.getColumnListByPid(parentId);
    }

    @Override
    public List<TVRecommendColumn> getRecommendColumn() {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        return tvAppMapper.getRecommendColumn();
    }

    @Override
    public PageData<TVContent> getContentPageList(TVAppContentParam parameter) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        PageData<TVContent> pageData = new PageData<TVContent>();
        pageData.setRecordcount(tvAppMapper.getContentCount(parameter));
        if (pageData.getRecordcount() == 0) {
            return pageData;
        }
        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), parameter.getPagesize()));
        parameter.setPageindex(parameter.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : parameter.getPageindex());
        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        pageData.setList(tvAppMapper.getContentList(parameter));
        return pageData;

    }

    @Override
    public TVAppInfo getAppInfo(Integer appinfoid) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        return tvAppMapper.getAppInfo(appinfoid);
    }

    @Override
    public TVAppVersionInfo getAppVersionInfo(String packagename) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        return tvAppMapper.getAppVersionInfo(packagename);
    }

    @Override
    public void updateDownloadCount(Integer appinfoId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        tvAppMapper.updateDownloadCount(appinfoId);
    }


}
