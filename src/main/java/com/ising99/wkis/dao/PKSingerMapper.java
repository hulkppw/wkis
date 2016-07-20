package com.ising99.wkis.dao;

import com.ising99.wkis.domain.*;
import com.ising99.wkis.parameter.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Hulk on 2014/11/12.
 */
@Repository
public interface PKSingerMapper {

    PKSingerInfo getSingerInfo(int singerid);

    PKSingerSongInfo getSingerSongInfoById(int singer_song_id);

    PKSingerSongInfo getSingerSongInfo(Integer songid);

    Integer getSingerSongListCount(PKSingerSongListParam param);

    List<PKSingerSongList> getSingerSongList(PKSingerSongListParam param);

    Integer getSingerSongListRank(Map<String, Object> map);

    List<PKSingerBasic> getSingerBasic(PKSingerParam param);

    List<PKSingerMore> getSingerMore(PKSingerParam param);

    PKTempSinger getTempSingerById(String id);

    PKCheckUpload getCheckUpload(String tempid);

    void addSinger(PKAddSingerParam param);

    void addSingerSong(PKAddSingerSongParam param);

    void delSinger(int singer_id);

    void delSingerSong(int singer_id);

    void delSingerSongById(int singer_songid);

    void addListen(PKListenParam param);

    void updateListenCount(int singer_song_id);

    void addLike(PKLikeParam param);

    Integer getLikeCount(PKLikeParam param);

    void updateLikeCount(int singer_song_id);

    void updateTempSinger(PKUpdateTempSingerParam tempParam);

    void updateSingerHead(PKUpdateSingerHeadParam headParam);

    void addCancelUpload(CancelUpload cancelUpload);

    void delSingerByTempId(String temp_id);
}
