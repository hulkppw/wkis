package com.ising99.wkis.service.impl;

import com.ising99.wkis.dao.PlayerThemeMusicMapper;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.domain.PageData;
import com.ising99.wkis.domain.PlayerThemeMusic;
import com.ising99.wkis.parameter.PlayerThemeMusicParam;
import com.ising99.wkis.service.PlayerThemeMusicService;
import com.ising99.wkis.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jerry on 2014/7/4.
 */
@Service("playerThemeMusicService")
public class PlayerThemeMusicServiceImpl implements PlayerThemeMusicService {
    @Resource
    PlayerThemeMusicMapper playerThemeMusicMapper;
    @Override
    public Long getVersionInfoByAppId(Integer appVersionId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return playerThemeMusicMapper.getVersionInfoByAppId(appVersionId);
    }

    @Override
    public PageData<PlayerThemeMusic> getList(PlayerThemeMusicParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PageData<PlayerThemeMusic> pageData = new PageData<PlayerThemeMusic>();
        pageData.setRecordcount(playerThemeMusicMapper.getCount(param));
        if (pageData.getRecordcount() == 0) {
            return pageData;
        }
        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pageData.setList(playerThemeMusicMapper.getList(param));
        return pageData;
    }

}
