package com.ising99.wkis.mvc;

import com.ising99.wkis.common.ErrorCode;
import com.ising99.wkis.common.SessionManager;
import com.ising99.wkis.domain.*;
import com.ising99.wkis.parameter.TmsFavoriteParam;
import com.ising99.wkis.parameter.TmsThemeMusicParam;
import com.ising99.wkis.parameter.TmsWishParam;
import com.ising99.wkis.service.MultiscreenService;


import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * Created by Raise on 2015/1/16.
 */
@Controller
@RequestMapping("multiscreen")
public class MultiscreenController extends BaseController {
    private static final Logger logger = Logger.getLogger(MultiscreenController.class);
    @Resource
    private MultiscreenService multiscreenService;

    /**
     * 更新用户信息
     */
    @RequestMapping("/userinfo/update")
    @ResponseBody
    public Object userinfoUpdate(String session) throws IOException {
        SimpleDateFormat ds = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        String nickname = request.getParameter("nickname");
        String gender = request.getParameter("gender");
        String head = request.getParameter("head");
        String birthday = request.getParameter("birthday");
        String mobile = request.getParameter("mobile");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        Integer userid = SessionManager.getUserId(session);

        TmsUserInfo user;
        user = multiscreenService.selectById(userid);
        if(user==null){
            this.responseErrorCode(ErrorCode.NO_RECORD);
            return null;
        }else{
            user.setId(userid);
            user.setNickname(nickname);
            if(gender==""){
                user.setGender(0);
            }else{
                user.setGender(Integer.parseInt(gender));
            }


            java.util.Date date = new Date(Long.parseLong(birthday));
         //   Timestamp d = new Timestamp(date.getTime());
            user.setHead(head);
            user.setBirthday(date);
            user.setMobile(mobile);
            user.setProvince(province);
            user.setCity(city);
            multiscreenService.userupdate(user);
            return "{'result':'ok'}";
        }


    }

    /**
     * 获取用户信息
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object login(String userid, Integer platform, String token) {
        //1 验证 platform_userid 是否存在 userid传出的值，如果有得到 t_ms_userinfo 的id，如果没有创建一条t_ms_userinfo 数据，得到id。
        //2 调用 SessionManager.createSession(id) ,得到session 返回给客户端
        String session = "";
        TmsUserInfo user = multiscreenService.selectByUserId(userid, platform);
        if (user == null) {
            TmsUserInfo tmsUserInfo = new TmsUserInfo();
            tmsUserInfo.setPlatform(platform);
            tmsUserInfo.setPlatform_userid(userid);
            tmsUserInfo.setNickname("");
            tmsUserInfo.setHead("");
            tmsUserInfo.setGender(0);
            Date date = new Date();
            Timestamp d = new Timestamp(date.getTime());
            tmsUserInfo.setBirthday(d);
            tmsUserInfo.setMobile("");
            tmsUserInfo.setProvince("");
            tmsUserInfo.setCity("");
            tmsUserInfo.setModifytime(d);
            tmsUserInfo.setCreatetime(d);
            multiscreenService.userinsert(tmsUserInfo);

            session = SessionManager.createSession(tmsUserInfo.getId());
        } else {
            System.out.print(user.getId());
            session = SessionManager.createSession(user.getId());
        }
        JSONObject json = new JSONObject();
        json.put("session", session);
        return json;
    }

    /**
     * 获取用户信息
     */
    @RequestMapping("/userinfo")
    @ResponseBody
    public Object getUser(String session) {
        Integer id = SessionManager.getUserId(session);
        TmsUserInfo userInfo= multiscreenService.selectById(id);
        if(userInfo == null){
            this.responseErrorCode(ErrorCode.NO_RECORD);
            return null;
        }
        return userInfo;
    }

    /**
     * 上架通知
     */
    @RequestMapping("/wish/notice")
    @ResponseBody
    public Object getNotice(String session,int language) {
        //流程：
        //a、首先通过userid、noticed=0（false） 获取上架通知列表，（inner join kds数据库中最新歌曲表，根据language不同join不同的表）
        //b、批量更新t_ms_notice（上架通知列表中的返回的数据） 表中字段更新为noticed=true、noticetime=now。
        Integer userid = SessionManager.getUserId(session);
        Boolean noticed=false;
        return multiscreenService.getNotice(userid,noticed);
    }

    /**
     * 获取主题
     */
    @RequestMapping("/theme")
    @ResponseBody
    public Object getTheme() {
        String id = request.getParameter("id");


        if ("简体中文".equals(id)) {
            int language = 0;
            return multiscreenService.findByL(language);
        } else {
            int language = 1;
            return multiscreenService.findByL(language);
        }

    }

    /**
     * 获取主题歌曲
     */
    @RequestMapping("/theme/musiclist")
    @ResponseBody
    public PageData<TmsThemeMusic> getList(Integer pageindex, Integer pagesize, String session, Integer theme_id) throws Exception {

        TmsThemeMusicParam param = new TmsThemeMusicParam();
        Integer userid = SessionManager.getUserId(session);
        // param.setUserid(userid);
        param.setPageindex(pageindex);
        param.setPagesize(pagesize);
        param.setTheme_id(theme_id);
        return multiscreenService.getList(param);
    }

    /**
     * 更新我的调音台信息
     */
    @RequestMapping("/mixer/update")
    @ResponseBody
    public Object updateMixer() {
        String main_volume = request.getParameter("main_volume");
        String music_volume = request.getParameter("music_volume");
        String microphone_volume = request.getParameter("microphone_volume");
        String microphone_echo_volume = request.getParameter("microphone_echo_volume");
        String melody_volume = request.getParameter("melody_volume");
        String tempo = request.getParameter("tempo");
        String key = request.getParameter("key");
        String micset_room_mode = request.getParameter("micset_room_mode");
        TmsMixer tmsMixer = multiscreenService.selectId(1);
        //System.out.print(tmsMixer.getId());
        tmsMixer.setId(tmsMixer.getId());
        tmsMixer.setUserid(2);
        tmsMixer.setMain_volume(Integer.parseInt(main_volume));
        tmsMixer.setMusic_volume(Integer.parseInt(music_volume));
        tmsMixer.setMicrophone_volume(Integer.parseInt(microphone_volume));
        tmsMixer.setMicrophone_echo_volume(Integer.parseInt(microphone_echo_volume));
        tmsMixer.setMelody_volume(Integer.parseInt(melody_volume));
        tmsMixer.setTempo(Integer.parseInt(tempo));
        tmsMixer.setKey(Integer.parseInt(key));
        tmsMixer.setMicset_room_mode(Integer.parseInt(micset_room_mode));
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        tmsMixer.setModifytime(time);
        tmsMixer.setCreatetime(time);
        multiscreenService.updatetmsMixer(tmsMixer);
        return "{'result':'ok'}";
    }

    /**
     * 获取我的调音台信息
     */
    @RequestMapping("/mixer")
    @ResponseBody
    public TmsMixer findMixer(String session) {
        //通过session获取userid
        Integer userid = SessionManager.getUserId(session);
        TmsMixer tmsMixer = multiscreenService.getMixer(userid);
       if(tmsMixer == null){
       this.responseErrorCode(ErrorCode.NO_RECORD);
           return null;
       }
        return tmsMixer;
    }


    /**
     * 提交我的心愿歌单
     */
    @RequestMapping("/wish/add")
    @ResponseBody
    public Object insert(String session) {
        String language = request.getParameter("language");
        String wish = request.getParameter("wish");
        Integer userid = SessionManager.getUserId(session);
        if (wish.length() > 100) {
            //提交的数据长度大于１００　返回错误。
            this.responseErrorCode(ErrorCode.REQUEST_DATA_TOO_LONG);
            return null;
        }
        TmsWish tmsWish = new TmsWish();
        tmsWish.setUserid(userid);
        tmsWish.setWish(wish);
        tmsWish.setDone(true);
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        tmsWish.setCreatetime(time);
        tmsWish.setDonetime(time);

        if ("简体中文".equals(language)) {
            int l = 0;
            tmsWish.setLanguage(0);
        } else {
            int l = 1;
            tmsWish.setLanguage(l);
        }
        multiscreenService.add(tmsWish);
        return "{'result':'ok'}";
    }
/**
 * 获取我的愿望歌单
 *
 */
@RequestMapping("/wish/wish")
@ResponseBody
public PageData<TmsWish> getList(Integer pageindex, Integer pagesize, String session) throws Exception {

    TmsWishParam param = new TmsWishParam();
    //Integer userid = SessionManager.getUserId(session);
    // param.setUserid(userid);
    param.setPageindex(pageindex);
    param.setPagesize(pagesize);
    return multiscreenService.getList(param);
}
    /**
     * 添加我收藏的歌曲
     */
    @RequestMapping("/favorite/add")
    @ResponseBody
    public Object addFavorite(String session, String songid, Integer language) {

        String version = multiscreenService.getIsing99Version();

        String l = language == 0 ? "sc" : "tc";

        List<MusicList> musicLists = multiscreenService.getMusicList(version, l, songid);


        Integer userid = SessionManager.getUserId(session);
        for (int i = 0; i < musicLists.size(); i++) {
            TmsFavorite tmsFavorite = new TmsFavorite();
            tmsFavorite.setUserid(userid);
            tmsFavorite.setSong_id(musicLists.get(i).getSongid());
            tmsFavorite.setName(musicLists.get(i).getSongname());
            tmsFavorite.setSinger(musicLists.get(i).getSingername1());
            tmsFavorite.setSinger_id(musicLists.get(0).getSingerid1());
            tmsFavorite.setIs_is9(musicLists.get(i).getIsis9());
            tmsFavorite.setSingertype(Integer.parseInt(musicLists.get(i).getSongtype()));
            tmsFavorite.setLanguagecode(musicLists.get(i).getLanguagecode());
            tmsFavorite.setSpell(musicLists.get(i).getSongspell());
            Date date = new Date();
            Timestamp time = new Timestamp(date.getTime());
            tmsFavorite.setCreatetime(time);
            tmsFavorite.setLanguage(language);

            multiscreenService.insert(tmsFavorite);

        }
        return "{'result':'ok'}";

    }

    /**
     * 删除我收藏的歌曲
     */
    @RequestMapping("/favorite/delete")
    @ResponseBody
    public Object deleteFavorite(String session) {
        String id = request.getParameter("id");
        Integer userid = SessionManager.getUserId(session);
        multiscreenService.delete(Integer.parseInt(id), userid);
        return "{'result':'ok'}";

    }

    /**
     * 获取我的收藏
     */
    @RequestMapping("/favorite")
    @ResponseBody
    public PageData<TmsFavorite> getFavoriteList(Integer pageindex, Integer pagesize, String session, Integer language) throws Exception {

        TmsFavoriteParam param = new TmsFavoriteParam();
        Integer userid = SessionManager.getUserId(session);
        param.setUserid(userid);
        param.setLanguage(language);
        param.setPageindex(pageindex);
        param.setPagesize(pagesize);

        return multiscreenService.getFavoriteList(param);
    }

}
