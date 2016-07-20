package com.ising99.wkis.dao;

import com.ising99.wkis.domain.ImusicLike;
import com.ising99.wkis.domain.TmsFavorite;
import com.ising99.wkis.domain.TmsTheme;
import com.ising99.wkis.parameter.ImusicLikeParam;
import com.ising99.wkis.parameter.TmsFavoriteParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raise on 2015/1/24.
 */
@Repository
public interface TmsFavoriteMapper {
    //添加我收藏的歌曲
    void insert(TmsFavorite tmsFavorite);
    //删除我收藏的歌曲
    void delete(int id,int userid);
    List<TmsFavorite> getList(TmsFavoriteParam param);

    Integer getCount(TmsFavoriteParam param);
}
