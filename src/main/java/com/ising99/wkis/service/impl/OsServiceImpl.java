package com.ising99.wkis.service.impl;

import com.ising99.wkis.dao.OsMapper;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.domain.Os;
import com.ising99.wkis.parameter.OsLatestVersionParam;
import com.ising99.wkis.service.OsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jerry on 2014/6/28.
 */
@Service("osService")
public class OsServiceImpl implements OsService {

    @Resource
    private OsMapper osMapper;

    @Override
    public List<Os> latestVersionByDeviceCode(OsLatestVersionParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        return osMapper.latestVersionByDeviceCode(param);
    }

    @Override
    public List<Os> getInfoByUTC(Long utc) {
        return osMapper.getInfoByUTC(utc);
    }


}
