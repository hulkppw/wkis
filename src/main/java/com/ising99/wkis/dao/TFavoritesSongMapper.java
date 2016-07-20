package com.ising99.wkis.dao;

//import com.ising99.wkis.domain.TFavoritesSong;

import com.ising99.wkis.parameter.TFavoritesSongParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raise on 2015/2/6.
 */
@Repository
public interface TFavoritesSongMapper {
   // List<TmsFavorite> getList(TmsFavoriteParam param);

//   // Integer getCount(TmsFavoriteParam param);
//   //添加收藏歌曲
//   void insert(TFavoritesSong tFavoritesSong);
//   //删除收藏歌曲列表
//   void delete(String userid,int id);
//   //清空收藏夹
//   void deleteAll(String userid,int favoritesid);
//   //获取收藏歌曲列表
//   List<TFavoritesSong> getList(TFavoritesSongParam param);
   Integer getCount(TFavoritesSongParam param);

}
