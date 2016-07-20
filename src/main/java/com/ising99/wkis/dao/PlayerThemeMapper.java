package com.ising99.wkis.dao;

import com.ising99.wkis.domain.PlayerTheme;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerThemeMapper {

    Long getVersionInfoByAppId(Integer appVersionId);

    List<PlayerTheme> getListByAppId(Integer appVersionId);

}