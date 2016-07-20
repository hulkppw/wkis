package com.ising99.wkis.service.impl;

import com.ising99.wkis.dao.PKMapper;
import com.ising99.wkis.dao.PKSingerMapper;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.domain.*;
import com.ising99.wkis.parameter.*;
import com.ising99.wkis.service.PKService;
import com.ising99.wkis.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wang Lingyun on 2014/11/11.
 */
@Service("pkService")
public class PKServiceImpl implements PKService {

    @Resource
    private PKMapper pkMapper;
    @Resource
    private PKSingerMapper pkSingerMapper;

    @Override
    public List<PKArena> getArenaList(Integer language) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        List<PKArena> list = pkMapper.getArenaList(language);
        return list;
    }

    @Override
    public PKArenaSongInfoBasic getArenaSongById(Integer arena_song_id) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return pkMapper.getArenaSongById(arena_song_id);
    }

    @Override
    public List<PKStar> getStarList(Integer language) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        List<PKStar> list = pkMapper.getStarList(language);
        return list;
    }

    @Override
    public List<PKNickName> getNickNameList(Integer language) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        List<PKNickName> list = pkMapper.getNickNameList(language);
        return list;
    }

    @Override
    public List<PKHead> getHeadList(Integer language) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        List<PKHead> list = pkMapper.getHeadList(language);
        return list;
    }

    @Override
    public String getHeadUrlById(Integer id) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return pkMapper.getHeadUrlById(id);
    }

    @Override
    public PageData<PKArenaSong> getArenaSongList(PKArenaSongParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PageData<PKArenaSong> pageData = new PageData<PKArenaSong>();
        pageData.setRecordcount(pkMapper.getArenaSongCount(param));
        if (pageData.getRecordcount() == 0) {
            return pageData;
        }
        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pageData.setList(pkMapper.getArenaSongList(param));
        return pageData;
    }

    @Override
    public PageData<PKTop> getTopList(PKTopParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PageData<PKTop> pageData = new PageData<PKTop>();
        pageData.setRecordcount(pkMapper.getTopCount(param));
        if (pageData.getRecordcount() == 0) {
            return pageData;
        }
        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pageData.setList(pkMapper.getTopList(param));
        return pageData;
    }

    @Override
    public PKSingerInfo getSingerInfo(Integer singerid) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PKSingerInfo singerInfo = pkSingerMapper.getSingerInfo(singerid);
        return singerInfo;
    }

    @Override
    public PKSingerSongInfo getSingerSongInfoById(Integer singer_song_id) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PKSingerSongInfo singerSongInfo = pkSingerMapper.getSingerSongInfoById(singer_song_id);
        return singerSongInfo;
    }

    @Override
    public PKArenaSong getArenaSongExpired(Integer arena_song_id) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PKArenaSong arenaSong = pkMapper.getArenaSongExpired(arena_song_id);
        return arenaSong;
    }

    @Override
    public PKSingerSongInfo getSingerSongInfo(Integer songid) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PKSingerSongInfo singerSongInfo = pkSingerMapper.getSingerSongInfo(songid);
        return singerSongInfo;
    }

    @Override
    public PageData<PKSingerSongList> getSingerSongList(PKSingerSongListParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PageData<PKSingerSongList> pageData = new PageData<PKSingerSongList>();
        pageData.setRecordcount(pkSingerMapper.getSingerSongListCount(param));
        if (pageData.getRecordcount() == 0) {
            return pageData;
        }
        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pageData.setList(pkSingerMapper.getSingerSongList(param));
        Map<String, Object> map = new HashMap<String, Object>();
//        for (PKSingerSongList singerSongList : pageData.getList()) {
//            map.put("song_id", singerSongList.getId());
//            map.put("score", singerSongList.getScore());
////            Integer rank = pkSingerMapper.getSingerSongListRank(map) + 1;
//            singerSongList.setRanking(rank);
//        }
        return pageData;
    }

    @Override
    public List<PKSingerBasic> getSingerBasic(PKSingerParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        List<PKSingerBasic> list = pkSingerMapper.getSingerBasic(param);
        return list;
    }

    @Override
    public List<PKSingerMore> getSingerMore(PKSingerParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        List<PKSingerMore> list = pkSingerMapper.getSingerMore(param);
        return list;
    }

    @Override
    public void addTempSinger(PKTempSingerParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pkMapper.addTempSinger(param);
    }

    @Override
    public PKTempSinger getTempSingerById(String id) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PKTempSinger tempSinger = new PKTempSinger();
        tempSinger = pkSingerMapper.getTempSingerById(id);
        return tempSinger;
    }

    @Override
    public PKCheckUpload getCheckUpload(String tempid) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PKCheckUpload checkUpload = new PKCheckUpload();
        checkUpload = pkSingerMapper.getCheckUpload(tempid);
        return checkUpload;
    }

    @Override
    public PKSingerAdd addSinger(PKAddSingerParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pkSingerMapper.addSinger(param);
        int singer_id = param.getId();
        PKSingerAdd singer = new PKSingerAdd();
        singer.setSinger_id(singer_id);
        return singer;
    }

    @Override
    public Integer addSingerSong(PKAddSingerSongParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pkSingerMapper.addSingerSong(param);
        return param.getId();
    }

    @Override
    public PKResult delSinger(Integer singer_id) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PKResult result = new PKResult();
        pkSingerMapper.delSinger(singer_id);
        pkSingerMapper.delSingerSong(singer_id);
        result.setResult("ok");
        return result;
    }

    /**
     * 删除某台盒子的所有歌手及作品
     *
     * @param userid
     * @return
     */
    @Override
    public PKResult delAllSinger(Integer userid, Integer language) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PKResult result = new PKResult();
        PKSingerParam param = new PKSingerParam();
        param.setUserid(userid);
        param.setLanguage(language);
        List<PKSingerBasic> list = pkSingerMapper.getSingerBasic(param);
        for (PKSingerBasic singer : list) {
            pkSingerMapper.delSinger(singer.getId());
            pkSingerMapper.delSingerSong(singer.getId());
        }
        result.setResult("ok");
        return result;
    }

    /**
     * 删除歌手所有歌曲
     *
     * @param singer_id
     * @return
     */
    @Override
    public PKResult delAllSingerSong(Integer singer_id) {
        PKResult result = new PKResult();
        pkSingerMapper.delSingerSong(singer_id);
        result.setResult("ok");
        return result;
    }

    /**
     * 取消添加歌手操作
     * @param temp_id
     * @return
     */
    @Override
    public PKResult cancelAddSinger(String temp_id) {
        CancelUpload cancelUpload = new CancelUpload();
        cancelUpload.setTempid(temp_id);
        pkSingerMapper.addCancelUpload(cancelUpload);
        pkSingerMapper.delSingerByTempId(temp_id);
        PKResult result = new PKResult();
        result.setResult("ok");
        return result;
    }

    /**
     * 根据歌手歌曲id删除歌曲
     *
     * @param singer_songid
     * @return
     */
    @Override
    public PKResult delSingerSongById(Integer singer_songid) {
        PKResult result = new PKResult();
        pkSingerMapper.delSingerSongById(singer_songid);
        result.setResult("ok");
        return result;
    }

    @Override
    public PKResult addListen(PKListenParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PKResult result = new PKResult();
        pkSingerMapper.addListen(param);
        result.setResult("ok");
        //更新试听记录
        if ("ok".equals(result.getResult())) {
            pkSingerMapper.updateListenCount(param.getSinger_song_id());
        }
        return result;
    }

    @Override
    public PKResult addLike(PKLikeParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PKResult result = new PKResult();
        Integer likeCount = pkSingerMapper.getLikeCount(param);
        if (likeCount == 0) {
            pkSingerMapper.addLike(param);
            result.setResult("ok");
            pkSingerMapper.updateLikeCount(param.getSinger_song_id());
        } else {
            result.setResult("repeat");
        }
        return result;
    }

    @Override
    public PKArenaSongInfo getArenaSongInfo(Integer arena_song_id) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return pkMapper.getArenaSongInfo(arena_song_id);
    }

    @Override
    public void updateTempSinger(PKUpdateTempSingerParam tempParam) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pkSingerMapper.updateTempSinger(tempParam);
    }

    @Override
    public PKResult updateSingerHead(PKUpdateSingerHeadParam headParam) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PKResult result = new PKResult();
        pkSingerMapper.updateSingerHead(headParam);
        result.setResult("ok");
        return result;
    }

    @Override
    public Integer getRankingByScore(PKRankingByScoreParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return pkMapper.getRankingByScore(param);
    }

    @Override
    public Integer getTopScore(int arenaSongId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return pkMapper.getTopScore(arenaSongId);
    }

}
