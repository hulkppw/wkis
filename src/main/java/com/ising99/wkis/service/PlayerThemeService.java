package com.ising99.wkis.service;


import com.ising99.wkis.domain.PlayerTheme;

import java.util.List;


/**
 * Created by jerry on 2014/7/4.
 */
public interface PlayerThemeService {
    Long getVersionInfoByAppId(Integer appVersionId);
    List<PlayerTheme> getListByAppId(Integer appVersionId);
}
