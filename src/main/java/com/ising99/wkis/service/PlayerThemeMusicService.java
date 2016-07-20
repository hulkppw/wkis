package com.ising99.wkis.service;

import com.ising99.wkis.domain.PageData;
import com.ising99.wkis.domain.PlayerThemeMusic;
import com.ising99.wkis.parameter.PlayerThemeMusicParam;

/**
 * Created by jerry on 2014/7/4.
 */
public interface PlayerThemeMusicService {
    Long getVersionInfoByAppId(Integer appId);
    PageData<PlayerThemeMusic> getList(PlayerThemeMusicParam param);
}
