package com.ising99.wkis.dao;

import com.ising99.wkis.domain.TmsMixer;
import com.ising99.wkis.domain.TmsWish;
import com.ising99.wkis.parameter.TmsThemeMusicParam;
import com.ising99.wkis.parameter.TmsWishParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raise on 2015/1/24.
 */
@Repository
public interface TmsWishMapper {
    //提交我的心愿歌单
    void insert(TmsWish tmsWish);
    //查询我的愿望歌单
    List<TmsWish> getList(TmsWishParam param);
    Integer getCount(TmsWishParam param);
}
