package com.ising99.wkis.dao;

import com.ising99.wkis.domain.TmsFavorite;
import com.ising99.wkis.domain.TmsThemeMusic;
import com.ising99.wkis.parameter.TmsFavoriteParam;
import com.ising99.wkis.parameter.TmsThemeMusicParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raise on 2015/1/24.
 */
@Repository
public interface TmsThemeMusicMapper {
    TmsThemeMusic selectBysongId(String songid);
    List<TmsThemeMusic> getList(TmsThemeMusicParam param);

    Integer getCount(TmsThemeMusicParam param);
}
