package com.ising99.wkis.service.impl;

import com.ising99.wkis.dao.OsDownloadInfoMapper;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.parameter.OsDownloadInfoParam;
import com.ising99.wkis.service.OsDownloadInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jerry on 2014/6/28.
 */
@Service("osDownloadInfoService")
public class OsDownloadInfoServiceImpl implements OsDownloadInfoService{

    @Resource
    OsDownloadInfoMapper osDownloadInfoMapper;

    @Override
    public void insert(OsDownloadInfoParam osDownloadInfoParam) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        osDownloadInfoMapper.insert(osDownloadInfoParam);
    }
}
