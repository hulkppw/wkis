package com.ising99.wkis.service;


import com.ising99.wkis.domain.*;
import com.ising99.wkis.parameter.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MultiscreenService {
    /**
     * 获取爱唱音乐库版本号
     *
     * @return
     */
    String getIsing99Version();

    //根据songid查歌曲
    List<MusicList> getMusicList(@Param("version") String version, @Param("language") String language, @Param("songid") String songid);
    //inner join kds数据库中最新歌曲表数据
    List<MusicList> getMusicLists(@Param("version") String version, @Param("language") String language);
    //根据platform_userid 查
    TmsUserInfo selectByUserId(String userid, int platform);

    //获取用户信息
    TmsUserInfo selectById(int id);

    //上架通知
    List<TmsNotice> findBy(int language);
    //通过userid、noticed=0（false） 获取上架通知列表
    List<TmsNotice> getNotice(int userid,Boolean noticed);

    //获取主题
    List<TmsTheme> findByL(int language);

    //获取主题歌曲
    PageData<TmsThemeMusic> getList(TmsThemeMusicParam param);
//获取我的愿望歌单
PageData<TmsWish> getList(TmsWishParam param);
    //获取我的收藏
    PageData<TmsFavorite> getFavoriteList(TmsFavoriteParam param);

    //获取我的调音台信息
    TmsMixer getMixer(int userid);

    //更新用户资料
    void userupdate(TmsUserInfo tmsUserInfo);

    //添加用户资料
    void userinsert(TmsUserInfo tmsUserInfo);

    //提交我的心愿歌单
    void add(TmsWish tmsWish);

    //添加我收藏的歌曲
    void insert(TmsFavorite tmsFavorite);

    TmsThemeMusic selectBysongId(String songid);

    //删除我收藏的歌曲
    void delete(int id, int userid);

    //更新我的调音台信息
    void updatetmsMixer(TmsMixer tmsMixer);

    TmsMixer selectId(int id);


}

