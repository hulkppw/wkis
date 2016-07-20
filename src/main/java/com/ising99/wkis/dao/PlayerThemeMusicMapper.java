package com.ising99.wkis.dao;

import com.ising99.wkis.domain.PlayerThemeMusic;
import com.ising99.wkis.parameter.PlayerThemeMusicParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerThemeMusicMapper {

    Long getVersionInfoByAppId(Integer appId);

    List<PlayerThemeMusic> getList(PlayerThemeMusicParam param);

    Integer getCount(PlayerThemeMusicParam param);
}