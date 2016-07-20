package com.ising99.wkis.service.impl;


import com.ising99.wkis.dao.*;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.domain.PageData;
import com.ising99.wkis.domain.SingHistory;
import com.ising99.wkis.parameter.*;
import com.ising99.wkis.service.SingHistoryService;
import com.ising99.wkis.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("SingHistoryService")
public class SingHistoryServiceImpl implements SingHistoryService {
    @Resource
    SingHistoryMapper singHistoryMapper;


    @Override
    public int add(SingHistoryParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return singHistoryMapper.add(param);
    }

    @Override
    public PageData<SingHistory> getList(SingHistoryParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PageData<SingHistory> pageData = new PageData<SingHistory>();
        pageData.setRecordcount(singHistoryMapper.getCount(param));
        if (pageData.getRecordcount() == 0) {
            return pageData;
        }
        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pageData.setList(singHistoryMapper.getList(param));
        return pageData;
    }
    @Override
    public int delete(SingHistoryParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return singHistoryMapper.delete(param);
    }
}
