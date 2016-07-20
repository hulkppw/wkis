package com.ising99.wkis.service.impl;

import com.ising99.wkis.dao.TVAppDownloadInfoMapper;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.parameter.TVAppDownloadInfoParam;
import com.ising99.wkis.service.TVAppDownloadInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jerry on 2014/6/28.
 */
@Service("tvAppDownloadInfoService")
public class TVAppDownloadInfoServiceImpl implements TVAppDownloadInfoService{
    @Resource
    private TVAppDownloadInfoMapper tvAppDownloadInfoMapper;
    @Override
    public int insert(TVAppDownloadInfoParam record) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        return tvAppDownloadInfoMapper.insert(record);
    }
}
