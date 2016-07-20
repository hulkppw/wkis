package com.ising99.wkis.dao;

import com.ising99.wkis.domain.*;
import com.ising99.wkis.parameter.PKArenaSongParam;
import com.ising99.wkis.parameter.PKRankingByScoreParam;
import com.ising99.wkis.parameter.PKTempSingerParam;
import com.ising99.wkis.parameter.PKTopParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hulk on 2014/11/11.
 */
@Repository
public interface PKMapper {
    List<PKArena> getArenaList(int language);

    PKArenaSongInfoBasic getArenaSongById(int arena_song_id);

    PKArenaSong getArenaSongExpired(int arena_song_id);

    List<PKStar> getStarList(int language);

    List<PKNickName> getNickNameList(int language);

    List<PKHead> getHeadList(int language);

    String getHeadUrlById(int id);

    Integer getArenaSongCount(PKArenaSongParam param);

    List<PKArenaSong> getArenaSongList(PKArenaSongParam param);

    Integer getTopCount(PKTopParam param);

    List<PKTop> getTopList(PKTopParam param);

    void addTempSinger(PKTempSingerParam param);

    PKArenaSongInfo getArenaSongInfo(int arena_song_id);

    Integer getRankingByScore(PKRankingByScoreParam param);

    Integer getTopScore(int arenaSongId);
}
