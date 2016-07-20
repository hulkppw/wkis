package com.ising99.wkis.service.impl;

import com.ising99.wkis.dao.PayinfoByUrlMapper;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.parameter.PayinfoByUrlParam;
import com.ising99.wkis.service.PayinfoByUrlService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jerry on 2014/7/3.
 */
@Service("payinfoByUrlService")
public class PayinfoByUrlServiceImpl implements PayinfoByUrlService{
    @Resource
    PayinfoByUrlMapper payinfoByUrlMapper;
    @Override
    public int insert(PayinfoByUrlParam record) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return  payinfoByUrlMapper.insert(record);
    }
}
