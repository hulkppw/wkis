package com.ising99.wkis.service.impl;

import com.ising99.wkis.domain.KodCodeInfo;
import com.ising99.wkis.service.KodCodeInfoService;
import com.ising99.wkis.dao.*;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2014-12-06.
 */
@Service("KodCodeInfoService")
public class KodCodeInfoServiceImpl implements KodCodeInfoService {

    @Resource
    private KodCodeInfoMapper kodCodeInfoMapper;


    @Override
    public KodCodeInfo getVo(KodCodeInfo vo) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        return kodCodeInfoMapper.getVo(vo);
    }

    @Override
    public KodCodeInfo isExists(KodCodeInfo vo) {

        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        return kodCodeInfoMapper.isExists(vo);

    }

    @Override
    public int insert(KodCodeInfo vo) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.OTT);
        return kodCodeInfoMapper.insert(vo);
    }


}
