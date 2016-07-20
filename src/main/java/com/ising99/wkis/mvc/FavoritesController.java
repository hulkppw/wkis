package com.ising99.wkis.mvc;

import com.ising99.wkis.common.ErrorCode;
import com.ising99.wkis.common.SessionInfo;
import com.ising99.wkis.common.SessionManager;
import com.ising99.wkis.domain.PageData;
//import com.ising99.wkis.domain.TFavorites;
//import com.ising99.wkis.domain.TFavoritesSong;
import com.ising99.wkis.domain.TFavoritesSong;
import com.ising99.wkis.parameter.TFavoritesParam;
import com.ising99.wkis.parameter.TFavoritesSongParam;
import com.ising99.wkis.service.FavoritesService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Raise on 2015/2/6.
 */
@Controller
@RequestMapping("player/favorites")
public class FavoritesController extends BaseController{
    private static final Logger logger = Logger.getLogger(FavoritesController.class);
    @Resource
    private FavoritesService favoritesService;
    /**
     * 添加收藏歌曲
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object insert(String session){
       // private int id;
        String isis9 = request.getParameter("isis9");
        String languagecode = request.getParameter("languagecode");
        String favoritesid = request.getParameter("favoritesid");
        String singerid = request.getParameter("singerid");
        String singername = request.getParameter("singername");
        String songid = request.getParameter("songid");
        String songname = request.getParameter("songname");
        String songspell = request.getParameter("songspell");
        String songtype = request.getParameter("songtype");
        String userid="";


        try {
            SessionInfo sessionInfo = SessionManager.readSession(session);
            userid = sessionInfo.getUserId();
        } catch (Exception e) {
            logger.error(e.toString(), e);
            this.responseErrorCode(ErrorCode.USER_ACCOUNT_ERROR);
            return null;
        }
        TFavoritesSong tFavoritesSong=new TFavoritesSong();
        tFavoritesSong.setIsis9(Integer.parseInt(isis9));
        tFavoritesSong.setLanguagecode(Integer.parseInt(languagecode));
        tFavoritesSong.setFavoritesid(Integer.parseInt(favoritesid));
        tFavoritesSong.setSingerid(singerid);
        tFavoritesSong.setSingername(singername);
        tFavoritesSong.setSongid(songid);
        tFavoritesSong.setSongname(songname);
        tFavoritesSong.setSongspell(songspell);
        tFavoritesSong.setSongtype(Integer.parseInt(songtype));
        tFavoritesSong.setUserid(userid);
        Date date=new Date();
        Timestamp time=new Timestamp(date.getTime());
        tFavoritesSong.setCreatetime(time);
        //favoritesService.insert(tFavoritesSong);
        String msg = "{'result':'ok'}";
        JSONObject object = JSONObject.fromObject(msg.toString());
        return object;
      //  private String userid;
       // private Timestamp createtime;
    }
//    /**
//     * 获取收藏夹列表
//     */
//   // @RequestMapping("/findtfavorites")
//   // @ResponseBody
////    public PageData<TFavorites> getList(Integer pageindex, Integer pagesize) throws Exception {
//////        String userid = "";
//////        try {
//////            SessionInfo sessionInfo = SessionManager.readSession(session);
//////            userid = sessionInfo.getUserId();
//////        } catch (Exception e) {
//////            logger.error(e.toString(), e);
//////            this.responseErrorCode(ErrorCode.USER_ACCOUNT_ERROR);
//////            return null;
//////        }
////       // SessionInfo sessionInfo = SessionManager.createSession();
////        String userid="";
////        String session = SessionManager.createSession("17994902",1,"3242343","22424","424");
////        SessionInfo sessionInfo = SessionManager.readSession(session);
////        userid = sessionInfo.getUserId();
////        TFavoritesParam param=new TFavoritesParam();
////        // param.setUserid(userid);
////        param.setPageindex(pageindex);
////        param.setPagesize(pagesize);
////        param.setUserid(userid);
////        return  favoritesService.getList(param);
////    }
//    /**
//     * 获取收藏歌曲列表
//     */
////    @RequestMapping("/findtfavoritessong")
////    @ResponseBody
////    public PageData<TFavoritesSong> getLists(Integer pageindex, Integer pagesize,  String favoritesid,String songspell) throws Exception {
//////        String userid = "";
//////        try {
//////            SessionInfo sessionInfo = SessionManager.readSession(session);
//////            userid = sessionInfo.getUserId();
//////        } catch (Exception e) {
//////            logger.error(e.toString(), e);
//////            this.responseErrorCode(ErrorCode.USER_ACCOUNT_ERROR);
//////            return null;
//////        }
////        String userid="";
////        String session = SessionManager.createSession("76292069",1,"3242343","22424","424");
////        SessionInfo sessionInfo = SessionManager.readSession(session);
////        userid = sessionInfo.getUserId();
////        System.out.print(userid+"用户ID是。。。");
////        System.out.print(songspell+"。。。");
////        TFavoritesSongParam param=new TFavoritesSongParam();
////        // param.setUserid(userid);
////        param.setPageindex(pageindex);
////        param.setPagesize(pagesize);
////        param.setUserid(userid);
////        param.setFavoritesid(Integer.parseInt(favoritesid));
////        param.setSongspell(songspell);
////        return  favoritesService.getLists(param);
////    }
//    /**
//     * 删除收藏歌曲列表
//     */
//    @RequestMapping("/delete")
//    @ResponseBody
//    public Object delete(String id){
//        String userid="";
//        String session = SessionManager.createSession("76292069",1,"3242343","22424","424");
//        SessionInfo sessionInfo = SessionManager.readSession(session);
//        userid = sessionInfo.getUserId();
//        favoritesService.delete(userid,Integer.parseInt(id));
//        String msg = "{'result':'ok'}";
//        JSONObject object = JSONObject.fromObject(msg.toString());
//        return object;
//    }
//    /**
//     * 清空收藏夹
//     */
//    @RequestMapping("/deleteAll")
//    @ResponseBody
//    public Object deleteAll(String favoritesid){
//        String userid="";
//        String session = SessionManager.createSession("76292069",1,"3242343","22424","424");
//        SessionInfo sessionInfo = SessionManager.readSession(session);
//        userid = sessionInfo.getUserId();
//        favoritesService.deleteAll(userid,Integer.parseInt(favoritesid));
//        String msg = "{'result':'ok'}";
//        JSONObject object = JSONObject.fromObject(msg.toString());
//        return object;
//    }
}
