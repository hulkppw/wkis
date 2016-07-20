package com.ising99.wkis.service;

import com.ising99.wkis.domain.*;
import com.ising99.wkis.parameter.*;

import java.util.List;

/**
 * Created by Hulk on 2014/11/11.
 */
public interface PKService {

    List<PKArena> getArenaList(Integer language);

    PKArenaSongInfoBasic getArenaSongById(Integer arena_song_id);

    List<PKStar> getStarList(Integer language);

    List<PKNickName> getNickNameList(Integer language);

    List<PKHead> getHeadList(Integer language);

    String getHeadUrlById(Integer id);

    PageData<PKArenaSong> getArenaSongList(PKArenaSongParam param);

    PageData<PKTop> getTopList(PKTopParam param);

    PKSingerInfo getSingerInfo(Integer singerid);

    PKSingerSongInfo getSingerSongInfoById(Integer singer_song_id);

    PKArenaSong getArenaSongExpired(Integer arena_song_id);

    PKSingerSongInfo getSingerSongInfo(Integer songid);

    PageData<PKSingerSongList> getSingerSongList(PKSingerSongListParam param);

    List<PKSingerBasic> getSingerBasic(PKSingerParam param);

    List<PKSingerMore> getSingerMore(PKSingerParam param);

    void addTempSinger(PKTempSingerParam param);

    PKTempSinger getTempSingerById(String id);

    PKCheckUpload getCheckUpload(String tempid);

    PKSingerAdd addSinger(PKAddSingerParam param);

    Integer addSingerSong(PKAddSingerSongParam param);

    PKResult delSinger(Integer singer_id);

    /**
     * 删除某台盒子的所有歌手及作品
     *
     * @param userid
     * @return
     */
    PKResult delAllSinger(Integer userid, Integer language);

    /**
     * 删除歌手所有歌曲
     *
     * @param singer_id
     * @return
     */
    PKResult delAllSingerSong(Integer singer_id);

    PKResult cancelAddSinger(String temp_id);

    /**
     * 根据歌手歌曲id删除歌曲
     * @param singer_songid
     * @return
     */
    PKResult delSingerSongById(Integer singer_songid);

    PKResult addListen(PKListenParam param);

    PKResult addLike(PKLikeParam param);

    PKArenaSongInfo getArenaSongInfo(Integer arena_song_id);

    void updateTempSinger(PKUpdateTempSingerParam tempParam);

    PKResult updateSingerHead(PKUpdateSingerHeadParam headParam);

    Integer getRankingByScore(PKRankingByScoreParam param);

    Integer getTopScore(int arenaSongId);
}
