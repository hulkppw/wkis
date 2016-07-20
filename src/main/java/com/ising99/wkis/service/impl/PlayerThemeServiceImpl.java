package com.ising99.wkis.service.impl;

import com.ising99.wkis.dao.PlayerThemeMapper;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.domain.PlayerTheme;
import com.ising99.wkis.service.PlayerThemeService;
import com.ising99.wkis.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jerry on 2014/7/4.
 */
@Service("playerThemeService")
public class PlayerThemeServiceImpl implements PlayerThemeService {
    @Resource
    PlayerThemeMapper playerThemeMapper;
    @Override
    public Long getVersionInfoByAppId(Integer appVersionId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return playerThemeMapper.getVersionInfoByAppId(appVersionId);
    }

    @Override
    public List<PlayerTheme> getListByAppId(Integer appVersionId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return playerThemeMapper.getListByAppId(appVersionId);
    }


}
