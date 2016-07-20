package com.ising99.wkis.service.impl;

import com.ising99.wkis.dao.KoicCodeMapper;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.domain.KoicCode;
import com.ising99.wkis.service.KoicCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015-02-06.
 */
@Service("KoicCodeService")
public class KoicCodeServiceImpl implements KoicCodeService {

    @Resource
    private KoicCodeMapper koicCodeMapper;

    @Override
    public KoicCode checkCode(String koiccode) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return koicCodeMapper.checkCode(koiccode);
    }
}
