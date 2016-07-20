package com.ising99.wkis.mvc;

import com.google.common.io.Resources;
import com.ising99.wkis.common.ErrorCode;
import com.ising99.wkis.common.SessionManager;
import com.ising99.wkis.common.WebConfig;
import com.ising99.wkis.domain.*;
import com.ising99.wkis.parameter.*;
import com.ising99.wkis.service.PKService;
import com.ising99.wkis.utils.UUIDGenerator;
import com.ising99.wkis.utils.WebUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

/**
 * Created by jerry on 2014/11/8.
 */
@Controller
@RequestMapping("pk")
public class PKController extends BaseController {
    static final Logger logger = Logger.getLogger(PKController.class);

    @Resource
    private PKService pkService;

    /**
     * 获取热门擂台
     *
     * @param language
     * @return
     * @throws Exception
     */
    @RequestMapping("/arena")
    @ResponseBody
    public List<PKArena> getArenaList(Integer language) throws Exception {
        List<PKArena> list = pkService.getArenaList(language);
        return list;
    }

    /**
     * 获取擂台歌曲信息
     *
     * @param session
     * @param arena_song_id
     * @return
     */
    @RequestMapping("/arena/songinfo")
    @ResponseBody
    public PKArenaSongInfo getArenaSongInfo(String session, Integer arena_song_id) {
        PKArenaSongInfo songInfo = pkService.getArenaSongInfo(arena_song_id);
        return songInfo;
    }


    /**
     * 获取PK之星
     *
     * @param language
     * @return
     * @throws Exception
     */
    @RequestMapping("/star")
    @ResponseBody
    public List<PKStar> getStarList(Integer language) throws Exception {
        List<PKStar> list = pkService.getStarList(language);
        return list;
    }

    /**
     * 获取默认昵称列表
     *
     * @param language
     * @return
     * @throws Exception
     */
    @RequestMapping("/nickname")
    @ResponseBody
    public List<PKNickName> getNickNameList(Integer language) throws Exception {
        List<PKNickName> list = pkService.getNickNameList(language);
        return list;
    }

    /**
     * 默认头像列表
     *
     * @param language
     * @return
     * @throws Exception
     */
    @RequestMapping("/head")
    @ResponseBody
    public List<PKHead> getHeadList(Integer language) throws Exception {
        List<PKHead> list = pkService.getHeadList(language);
        return list;
    }

    /**
     * 获取擂台歌曲列表
     *
     * @param pageindex
     * @param pagesize
     * @param session
     * @param language
     * @param arena_id
     * @return
     * @throws Exception
     */
    @RequestMapping("/arena/songlist")
    @ResponseBody
    public PageData<PKArenaSong> getArenaSongList(Integer pageindex, Integer pagesize, String session, Integer language, Integer arena_id) throws Exception {
        PKArenaSongParam param = new PKArenaSongParam();
        param.setArenaid(arena_id);
        param.setLanguage(language);
        param.setPageindex(pageindex);
        param.setPagesize(pagesize);
        return pkService.getArenaSongList(param);
    }

    @RequestMapping("/arena/song/expired")
    @ResponseBody
    public Object getArenaSongExpired(String session, Integer arena_song_id) throws Exception {
        PKArenaSong arenaSong = pkService.getArenaSongExpired(arena_song_id);
        if (arenaSong == null) {
            return "{\"result\":" + true + "}";
        }
        return "{\"result\":" + false + "}";
    }

    /**
     * 本期排行
     *
     * @param pageindex
     * @param pagesize
     * @param session
     * @param language
     * @param arena_song_id
     * @return
     * @throws Exception
     */
    @RequestMapping("/top")
    @ResponseBody
    public PageData<PKTop> getTopList(Integer pageindex, Integer pagesize, String session, Integer language, Integer arena_song_id) throws Exception {
        PKTopParam param = new PKTopParam();
        param.setArena_song_id(arena_song_id);
        param.setLanguage(language);
        param.setPageindex(pageindex);
        param.setPagesize(pagesize);
        return pkService.getTopList(param);
    }

    /**
     * 获取歌手信息
     *
     * @param session
     * @param singerid
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/info")
    @ResponseBody
    public PKSingerInfo getSingerInfo(String session, Integer singerid) throws Exception {
        PKSingerInfo singerInfo = pkService.getSingerInfo(singerid);
        singerInfo.setMyHead();
        return singerInfo;
    }

    /**
     * 歌曲信息
     *
     * @param session
     * @param songid
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/songinfo")
    @ResponseBody
    public PKSingerSongInfo getSingerSongInfo(String session, Integer songid) throws Exception {
        PKSingerSongInfo singerSongInfo = pkService.getSingerSongInfoById(songid);
        return singerSongInfo;
    }

    /**
     * 歌手作品
     *
     * @param pageindex
     * @param pagesize
     * @param session
     * @param singer_id
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/songlist")
    @ResponseBody
    public PageData<PKSingerSongList> getSingerSongList(Integer pageindex, Integer pagesize, String session, Integer singer_id) throws Exception {
        PKSingerSongListParam param = new PKSingerSongListParam();
        param.setSinger_id(singer_id);
        param.setPageindex(pageindex);
        param.setPagesize(pagesize);
        return pkService.getSingerSongList(param);
    }

    /**
     * 本机歌手（基本）
     *
     * @param session
     * @param language
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/list/basic")
    @ResponseBody
    public List<PKSingerBasic> getSingerBasic(String session, Integer language) throws Exception {
        PKSingerParam param = new PKSingerParam();
        Integer userid = Integer.parseInt(SessionManager.readSession(session).getUserId());
        param.setUserid(userid);
        param.setLanguage(language);
        return pkService.getSingerBasic(param);
    }

    /**
     * @param session
     * @param language
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/list/more")
    @ResponseBody
    public List<PKSingerMore> getSingerMore(String session, Integer language) throws Exception {
        PKSingerParam param = new PKSingerParam();
        Integer userid = Integer.parseInt(SessionManager.readSession(session).getUserId());
        param.setUserid(userid);
        param.setLanguage(language);
        return pkService.getSingerMore(param);
    }

    /**
     * 获取网页上传的临时id
     *
     * @param session
     * @param language
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/upload/web/tempid")
    @ResponseBody
    public String getUploadTempId(String session, Integer language) throws Exception {
        String uuid = UUIDGenerator.generateId();
        //向临时用户表中插入一条数据
        PKTempSingerParam param = new PKTempSingerParam();
        param.setTempid(uuid);
        Integer userid = Integer.parseInt(SessionManager.readSession(session).getUserId());
        param.setUserid(userid);
        param.setCreatetime(new Date());
        param.setLanguage(language);
        param.setStatus(0);
        pkService.addTempSinger(param);
        return uuid;
    }

    /**
     * 检查上传进度
     *
     * @param session
     * @param tempid
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/upload/web/check")
    @ResponseBody
    public PKCheckUpload getCheckUpload(String session, String tempid) throws Exception {
        return pkService.getCheckUpload(tempid);
    }

    /**
     * 添加歌手
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/add")
    @ResponseBody
    public PKSingerAdd addSinger(String session, Integer type, String nickname, Integer language, Integer headimage_id, String resources_url, String head_path, String file_id, String kus_id) throws Exception {

        PKAddSingerParam param = new PKAddSingerParam();
        String headUrl = "";
        //判断头像类型,为0时，表示是摄像头头像,可以直接从request里取上传file文件
        if (type == 0) {
            FileInfo fileInfo = getFileInfoFromKus(file_id, kus_id);
            if (fileInfo == null) {
                return null;
            }
            param.setHead(fileInfo.resourcePath);
            param.setResourcesUrl(fileInfo.resourceUrl);
            headUrl = fileInfo.resourceUrl + fileInfo.resourcePath;
        } else if (type == 1) {
            //获取默认头像地址
            //验证路径，防止提交非法路径
//            String path = pkService.getHeadUrlById(headimage_id);
//            if(head_path.contains(path)){
//                responseErrorCode(ErrorCode.USER_ACCOUNT_ERROR);
//                return null;
//            }
            //验证路径，防止提交非法路径
            param.setHead(head_path);
            param.setResourcesUrl(resources_url);
            headUrl = resources_url + head_path;
        }

        Integer userid = Integer.parseInt(SessionManager.readSession(session).getUserId());
        param.setUserid(userid);
        param.setNickname(nickname);
        param.setLanguage(language);
        param.setBirthday(new Date());
        param.setGender(1);
        param.setCreatetime(new Date());
        PKSingerAdd singer = pkService.addSinger(param);
        singer.setHead(headUrl);
        singer.setNickname(nickname);

        return singer;
    }

    /**
     * 上传作品
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/song/add")
    @ResponseBody
    public Object addSingerSong(String session, Integer singer_id, Integer arena_song_id, Integer score, String is9_file_id, String wave_file_id, String kus_id) throws Exception {
        long start = System.currentTimeMillis();
        FileInfo is9FileInfo = getFileInfoFromKus(is9_file_id, kus_id);
        logger.debug("从kus 获取is9文件信息耗时："+(System.currentTimeMillis() -start)+"毫秒" );
        if (is9FileInfo == null) {
            return null;
        }
        start = System.currentTimeMillis();
        FileInfo waveFileInfo = getFileInfoFromKus(wave_file_id, kus_id);
        if (waveFileInfo == null) {
            return null;
        }
        logger.debug("从kus 获取wave文件信息耗时："+(System.currentTimeMillis() -start)+"毫秒" );

        start = System.currentTimeMillis();
        //获取擂台歌曲信息和本人歌手信息
        PKSingerInfo singerInfo = pkService.getSingerInfo(singer_id);
        PKArenaSongInfoBasic arenaSong = pkService.getArenaSongById(arena_song_id);
        logger.debug("从db 获取歌手和歌曲信息耗时："+(System.currentTimeMillis() -start)+"毫秒" );

        start = System.currentTimeMillis();
        PKAddSingerSongParam param = new PKAddSingerSongParam();
        try {
            String ip = WebUtils.getIpAddr(this.request);
            param.setIp(ip);
        }catch (Exception e){
            logger.debug(e);
            param.setIp("");
        }
        String userid = SessionManager.readSession(session).getUserId();
        param.setUserid(Integer.parseInt(userid));
        param.setSinger_id(singer_id);
        param.setArena_song_id(arena_song_id);
        param.setScore(score);
        param.setLanguage(arenaSong.getLanguage());
        param.setCreatetime(new Date());
        param.setIs9_path(is9FileInfo.resourcePath);
        param.setWaveform_path(waveFileInfo.resourcePath);
        param.setMp3_path("");
        param.setNickname(singerInfo.getNickname());
        param.setGender(singerInfo.getGender());
        param.setSinger_head(singerInfo.getHead());
        param.setArena_id(arenaSong.getArena_id());
        param.setSong_name(arenaSong.getSongname());
        param.setResourcesUrl(is9FileInfo.resourceUrl);//is9文件和wave文件同时上传到一个kus上
        String json = "{\"singer_song_id\":" + pkService.addSingerSong(param) + "}";
        logger.debug("从添加歌曲信息耗时："+(System.currentTimeMillis() -start)+"毫秒" );
        return json;

    }


    /**
     * 删除昵称（删除歌手）
     *
     * @param session
     * @param singer_id
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/delete")
    @ResponseBody
    public PKResult delSinger(String session, Integer singer_id) throws Exception {
        try {
            SessionManager.readSession(session);//验证ｓｅｓｓｉｏｎ
            return pkService.delSinger(singer_id);
        } catch (Exception e) {
            logger.error(e);
            responseErrorCode(ErrorCode.USER_ACCOUNT_ERROR);
            return null;
        }

    }

    /**
     * 删除所有歌手
     *
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/deleteall")
    @ResponseBody
    public PKResult delAllSinger(String session, Integer language) throws Exception {
        String userid = SessionManager.readSession(session).getUserId();
        return pkService.delAllSinger(Integer.parseInt(userid), language);
    }

    /**
     * 删除歌手所有歌曲
     *
     * @param session
     * @param singer_id
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/song/deleteall")
    @ResponseBody
    public PKResult delAllSingerSong(String session, Integer singer_id) throws Exception {
        return pkService.delAllSingerSong(singer_id);
    }

    /**
     * 取消添加歌手操作
     * @param session
     * @param temp_id
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/cancel")
    @ResponseBody
    public PKResult cancelAddSinger(String session, String temp_id) throws Exception {
        PKResult result = pkService.cancelAddSinger(temp_id);
        return result;
    }

    /**
     * 根据歌曲id删除歌手歌曲
     *
     * @param session
     * @param singer_songid
     * @return
     * @throws Exception
     */
    @RequestMapping("/singer/song/delete")
    @ResponseBody
    public PKResult delSingerSongById(String session, Integer singer_songid) throws Exception {
        return pkService.delSingerSongById(singer_songid);
    }

    /**
     * 点赞记录
     *
     * @param session
     * @param sender_singer_id
     * @param singer_id
     * @param singer_song_id
     * @return
     * @throws Exception
     */
    @RequestMapping("/record/like")
    @ResponseBody
    public PKResult like(String session, Integer sender_singer_id, Integer singer_id, Integer singer_song_id) throws Exception {
        PKLikeParam param = new PKLikeParam();
        String ip = SessionManager.readSession(session).getWanIp();
        Integer userid = Integer.parseInt(SessionManager.readSession(session).getUserId());
        param.setSinger_id(singer_id);
        param.setSinger_song_id(singer_song_id);
        param.setSender_singer_id(sender_singer_id);
        param.setSender_user_id(userid);
        param.setSender_ip(ip);
        param.setCreatetime(new Date());
        return pkService.addLike(param);
    }

    /**
     * 试听记录
     *
     * @param session
     * @param listen_singer_id
     * @param singer_id
     * @param singer_song_id
     * @return
     * @throws Exception
     */
    @RequestMapping("/record/listen")
    @ResponseBody
    public PKResult listen(String session, Integer listen_singer_id, Integer singer_id, Integer singer_song_id) throws Exception {
        PKListenParam param = new PKListenParam();
        String ip = SessionManager.readSession(session).getWanIp();
        Integer userid = Integer.parseInt(SessionManager.readSession(session).getUserId());
        param.setSinger_id(singer_id);
        param.setSinger_song_id(singer_song_id);
        param.setListener_singer_id(listen_singer_id);
        param.setListener_user_id(userid);
        param.setIp(ip);
        param.setCreatetime(new Date());
        return pkService.addListen(param);
    }

    /*
    打开手机端页面
     */
    @RequestMapping("/mobilePage")
    public ModelAndView addSingerMobilePage(String tempid) throws Exception {
        ModelAndView view = new ModelAndView("addSinger");
        view.addObject("tempid", tempid);
        return view;
    }


    @RequestMapping("/addSinger")
    @ResponseBody
    public Object addSingerMobi(String nickname, String tempid, Integer gender, String kus_id, String file_id) throws Exception {

        FileInfo fileInfo = getFileInfoFromKus(file_id, kus_id);
        if (fileInfo == null) {
            return null;
        }

        PKTempSinger tempSinger = pkService.getTempSingerById(tempid);
        if (tempSinger == null) {
            return "{\"result\":" + "\"notempid\"" + "}";
        }

        PKAddSingerParam param = new PKAddSingerParam();
        param.setUserid(tempSinger.getUserid());
        param.setLanguage(tempSinger.getLanguage());
        param.setGender(gender);
        param.setNickname(nickname);
        param.setHead(fileInfo.resourcePath);
        param.setResourcesUrl(fileInfo.resourceUrl);
        param.setCreatetime(new Date());

        // 添加歌手
        PKSingerAdd singer = pkService.addSinger(param);
        //修改temp_singer表中的状态字段
        PKUpdateTempSingerParam tempParam = new PKUpdateTempSingerParam();
        tempParam.setId(tempid);
        tempParam.setStatus(1);
        tempParam.setPk_singer_id(singer.getSinger_id());
        pkService.updateTempSinger(tempParam);

        ModelAndView view = new ModelAndView("ok");
        return view;
        //String json = "{\"result\":" + "\"success\"" + ",\"singerid\":" + singer.getSinger_id() + "}";
//        ModelAndView view = new ModelAndView("ok");
//        return view;

        //return json;
    }

    @RequestMapping("/singer/head/update")
    @ResponseBody
    public PKResult updateSingerHead(String session, Integer singerid, String file_id, String kus_id) throws Exception {
        try {
            SessionManager.readSession(session);
        } catch (Exception ex) {
            logger.error(ex);
            responseErrorCode(ErrorCode.USER_ACCOUNT_ERROR);
            return null;
        }
        FileInfo fileInfo = getFileInfoFromKus(file_id, kus_id);
        if (fileInfo == null) {
            return null;
        }

        PKUpdateSingerHeadParam param = new PKUpdateSingerHeadParam();
        param.setResourcesUrl(fileInfo.resourceUrl);
        param.setHead_image(fileInfo.resourcePath);
        param.setSingerid(singerid);

        PKResult result = pkService.updateSingerHead(param);
        return result;
    }


    @RequestMapping("/singer/song/ranking_by_score")
    @ResponseBody
    public Object getRankingByScore(Integer arena_song_id, Integer score) {
        PKRankingByScoreParam param = new PKRankingByScoreParam();
        param.setArenaSongId(arena_song_id);
        param.setScore(score);
        String json = "{\"ranking\":" + pkService.getRankingByScore(param) + "}";
        return json;
    }

    @RequestMapping("/singer/song/topscore")
    @ResponseBody
    public Object getTopScore(Integer arena_song_id) {
        String json = "{\"topscore\":" + pkService.getTopScore(arena_song_id) + "}";
        return json;
    }

    @RequestMapping("/head/path")
    @ResponseBody
    public String getHeadPath(Integer id) {
        return pkService.getHeadUrlById(id);
    }

    /**
     * 从kus获取文件信息
     *
     * @param fileId
     * @param kusId
     * @return
     */
    private FileInfo getFileInfoFromKus(String fileId, String kusId) {
        String kusUrl = WebConfig.getKUSUrl(kusId);
        if (kusUrl == null) {
            responseErrorCode(ErrorCode.NO_KUS_SERVERINFO);
            return null;
        }
        FileInfo fileInfo;
        try {
            String json = Resources.toString(new URL(kusUrl + "file/info?id=" + fileId), Charset.forName("UTF-8"));
            JSONObject jsonObject = new JSONObject(json);
            fileInfo = new FileInfo();
            fileInfo.resourceUrl = jsonObject.getString("resources_url");
            fileInfo.resourcePath = jsonObject.getString("path");
            if (fileInfo.resourceUrl == null || fileInfo.resourcePath == null) {
                responseErrorCode(ErrorCode.SERVER_ERROR);
                return null;
            }
            if (fileInfo.resourceUrl.trim().equals("") || fileInfo.resourcePath.trim().equals("")) {
                responseErrorCode(ErrorCode.NO_RECORD);
                return null;
            }
            fileInfo.resourceUrl = fileInfo.resourceUrl.endsWith("/") ? fileInfo.resourceUrl : fileInfo.resourceUrl + "/";
        } catch (Exception ex) {
            logger.error(ex);
            responseErrorCode(ErrorCode.SERVER_ERROR);
            return null;
        }
        return fileInfo;
    }

}

class FileInfo {
    String resourceUrl;
    String resourcePath;
}
