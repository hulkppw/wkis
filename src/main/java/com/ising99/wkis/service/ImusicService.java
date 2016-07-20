package com.ising99.wkis.service;

import com.ising99.wkis.domain.*;
import com.ising99.wkis.parameter.ImusicChannelMusicParam;
import com.ising99.wkis.parameter.ImusicLikeParam;
import com.ising99.wkis.parameter.ImusicHateParam;
import com.ising99.wkis.parameter.ImusicMusicAddParam;

import java.util.List;

public interface ImusicService {
    String getVersionInfoByAppId(Integer type, Integer language);
    List<ImusicChannelPage> getChannelPageList(Integer language);
    List<ImusicChannel> getChannelList(Integer language);
    List<ImusicChannelV2> getChannelListBy23Layer();
    PageData<ImusicChannelMusic> getMusicList(ImusicChannelMusicParam param);
    List<ImusicBg> getBgList();
    List<ImusicInstrument> getInstrumentList(Integer language);
    List<ImusicScene> getSceneList(Integer language);
    PageData<ImusicLike> getLikeList(ImusicLikeParam param);
    PageData<ImusicHate> getHateList(ImusicHateParam param);

    ImusicChannelMusic getMusicOne(ImusicChannelMusicParam musicone);
    int likeadd(ImusicMusicAddParam param);
    int hateadd(ImusicMusicAddParam param);
    int likedelete(ImusicLikeParam param);
    int hatedelete(ImusicHateParam param);

}

