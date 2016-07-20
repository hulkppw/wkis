package com.ising99.wkis.service.impl;


import com.ising99.wkis.dao.*;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.domain.*;

import com.ising99.wkis.parameter.TmsFavoriteParam;
import com.ising99.wkis.parameter.TmsThemeMusicParam;
import com.ising99.wkis.parameter.TmsWishParam;
import com.ising99.wkis.service.MultiscreenService;

import com.ising99.wkis.utils.PageUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("MultiscreenService")
public class MultiscreenServiceImpl implements MultiscreenService {
    @Resource
    TmsUserInfoMapper tmsUserInfoMapper;
    @Resource
    TmsThemeMapper tmsThemeMapper;
    @Resource
    TmsNoticeMapper tmsNoticeMapper;
    @Resource
    TmsMixerMapper tmsMixerMapper;
    @Resource
    TmsThemeMusicMapper tmsThemeMusicMapper;
    @Resource
    TmsFavoriteMapper tmsFavoriteMapper;
    @Resource
    TmsWishMapper tmsWishMapper;
    @Resource
     VersionMapper versionMapper;
    @Resource
    MusicListMapper musicListMapper;
    @Override

    public String getIsing99Version() {
      DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return versionMapper.getIsing99Version();
    }
    @Override

    public  List<MusicList> getMusicList( String version,  String language,  String songid) {
       DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return musicListMapper.MusicList(version,language,songid);
    }
    @Override

    public  List<MusicList> getMusicLists( String version,  String language) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return musicListMapper.getMusicList(version,language);
    }
    @Override
    public TmsUserInfo selectByUserId(String userid,int platform){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return tmsUserInfoMapper.selectByUserId(userid,platform);
    }
    @Override
    public void userinsert(TmsUserInfo tmsUserInfo){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        tmsUserInfoMapper.insert(tmsUserInfo);
    }
    @Override
    public TmsUserInfo selectById(int id){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return tmsUserInfoMapper.selectById(id);
    }

    @Override
  public  void userupdate(TmsUserInfo tmsUserInfo){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        tmsUserInfoMapper.update(tmsUserInfo);
    }

    @Override
    public List<TmsTheme> findByL(int language){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return tmsThemeMapper.findByL(language);
    }

    public TmsThemeMusic selectBysongId(String songid){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return tmsThemeMusicMapper.selectBysongId(songid);
    }

    @Override
    public List<TmsNotice> findBy(int language){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return tmsNoticeMapper.findByL(language);
    }
    @Override
    public List<TmsNotice> getNotice(int userid,Boolean noticed){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return tmsNoticeMapper.getNotice(userid,noticed);
    }
    @Override
    public TmsMixer getMixer(int userid){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return   tmsMixerMapper.getMixer(userid);
    }
    @Override
    public TmsMixer selectId(int id){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return tmsMixerMapper.selectById(id);
    }
    @Override
    public void updatetmsMixer(TmsMixer tmsMixer){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
       // tmsMixerMapper.update(tmsMixer);
    }

    @Override
    public void delete(int id,int userid){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        tmsFavoriteMapper.delete(id,userid);
    }
    @Override
    public  void insert(TmsFavorite tmsFavorite){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        tmsFavoriteMapper.insert(tmsFavorite);
    }
    @Override
    public void add(TmsWish tmsWish){
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        tmsWishMapper.insert(tmsWish);

       // tmsWishMapper.add(tmsWish);

    }
    @Override
    public PageData<TmsThemeMusic> getList(TmsThemeMusicParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PageData<TmsThemeMusic> pageData = new PageData<TmsThemeMusic>();
        pageData.setRecordcount(tmsThemeMusicMapper.getCount(param));
        if (pageData.getRecordcount() == 0) {
            return pageData;
        }
        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pageData.setList(tmsThemeMusicMapper.getList(param));
        return pageData;
    }
    @Override
    public PageData<TmsWish> getList(TmsWishParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PageData<TmsWish> pageData = new PageData<TmsWish>();
        pageData.setRecordcount(tmsWishMapper.getCount(param));
        if (pageData.getRecordcount() == 0) {
            return pageData;
        }
        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pageData.setList(tmsWishMapper.getList(param));
        return pageData;
    }
    @Override
    public PageData<TmsFavorite> getFavoriteList(TmsFavoriteParam param) {
    DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PageData<TmsFavorite> pageData = new PageData<TmsFavorite>();
        pageData.setRecordcount(tmsFavoriteMapper.getCount(param));
        if (pageData.getRecordcount() == 0) {
            return pageData;
        }
        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
       DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pageData.setList(tmsFavoriteMapper.getList(param));
        return pageData;
    }
}
