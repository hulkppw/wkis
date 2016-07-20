package com.ising99.wkis.service.impl;


import com.ising99.wkis.dao.ToneMapper;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.domain.PageData;
import com.ising99.wkis.domain.Tone;
import com.ising99.wkis.parameter.ToneParam;
import com.ising99.wkis.service.ToneService;
import com.ising99.wkis.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("ToneService")
public class ToneServiceImpl implements ToneService {
    @Resource
    ToneMapper toneMapper;


    @Override
    public int add(ToneParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return toneMapper.add(param);
    }

    @Override
    public PageData<Tone> getList(ToneParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PageData<Tone> pageData = new PageData<Tone>();
        pageData.setRecordcount(toneMapper.getCount(param));
        if (pageData.getRecordcount() == 0) {
            return pageData;
        }
        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pageData.setList(toneMapper.getList(param));
        return pageData;
    }
    @Override
    public int delete(ToneParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return toneMapper.delete(param);
    }
}
