package com.ising99.wkis.service.impl;

import com.ising99.wkis.dao.TFavoritesMapper;
import com.ising99.wkis.dao.TFavoritesSongMapper;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.domain.PageData;
//import com.ising99.wkis.domain.TFavorites;
//import com.ising99.wkis.domain.TFavoritesSong;
import com.ising99.wkis.parameter.TFavoritesParam;
import com.ising99.wkis.parameter.TFavoritesSongParam;
import com.ising99.wkis.service.FavoritesService;
import com.ising99.wkis.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Raise on 2015/2/6.
 */
@Service("FavoritesService")
public class FavoritesServiceImpl implements FavoritesService{
//    @Resource
//    TFavoritesSongMapper tFavoritesSongMapper;
//    @Resource
//    TFavoritesMapper tFavoritesMapper;
//    @Override
////    public  void insert(TFavoritesSong tFavoritesSong){
////        tFavoritesSongMapper.insert(tFavoritesSong);
////    }
//    @Override
////    public PageData<TFavorites> getList(TFavoritesParam param) {
////        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
////        PageData<TFavorites> pageData = new PageData<TFavorites>();
////        pageData.setRecordcount(tFavoritesMapper.getCount(param));
////        if (pageData.getRecordcount() == 0) {
////            return pageData;
////        }
////        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
////        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
////        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
////        pageData.setList(tFavoritesMapper.getList(param));
////        return pageData;
////    }
//    @Override
////    public PageData<TFavoritesSong> getLists(TFavoritesSongParam param) {
////        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
////        PageData<TFavoritesSong> pageData = new PageData<TFavoritesSong>();
////        pageData.setRecordcount(tFavoritesSongMapper.getCount(param));
////        if (pageData.getRecordcount() == 0) {
////            return pageData;
////        }
////        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
////        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
////        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
////        pageData.setList(tFavoritesSongMapper.getList(param));
////        return pageData;
////    }
//    @Override
//    public  void delete(String userid,int id){
//        tFavoritesSongMapper.delete(userid,id);
//    }
//    @Override
//  public   void deleteAll(String userid,int favoritesid){
//        tFavoritesSongMapper.deleteAll(userid,favoritesid);
//    }
}
