package com.ising99.wkis.mvc;

import com.ising99.wkis.common.ErrorCode;
import com.ising99.wkis.common.SessionInfo;
import com.ising99.wkis.common.SessionManager;
import com.ising99.wkis.domain.PageData;
import com.ising99.wkis.domain.SingHistory;
import com.ising99.wkis.parameter.SingHistoryParam;
import com.ising99.wkis.service.SingHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by jerry on 2014/9/22.
 */
@Controller
@RequestMapping("player/history")
public class SingHistoryController extends BaseController {

    @Resource
    private SingHistoryService singHistoryService;

    @RequestMapping("/add")
    @ResponseBody
    public String addRecord(Integer isis9,Integer languagecode,String singerid,String singername,String songid,String songname,String songspell,Integer songtype,String session){
        String userid = "";
        try {
            SessionInfo sessionInfo = SessionManager.readSession(session);
            userid = sessionInfo.getUserId();
        } catch (Exception e) {
            return null;
        }
        if(isis9==null||languagecode==null||singerid==null||singername==null||songid==null||songname==null||songspell==null||songtype==null||userid==null) {
            return "{'result':'参数不正确'}";
        }else{
            SingHistoryParam param = new SingHistoryParam();
            param.setIsis9(isis9);
            param.setLanguagecode(languagecode);
            param.setSingerid(singerid);
            param.setSingername(singername);
            param.setSongid(songid);
            param.setSongname(songname);
            param.setSongspell(songspell);
            param.setSongtype(songtype);
            param.setUserid(userid);
            param.setCreatetime(new Date());
            int file = singHistoryService.add(param);
            if (file == 1) {
                return "{'result':'ok'}";
            }else{
                return "{'result':'error'}";
            }
        }
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageData<SingHistory> getPageList(Integer pagesize, Integer pageindex,String session) throws Exception {
        String userid = "";
        try {
            SessionInfo sessionInfo = SessionManager.readSession(session);
            userid = sessionInfo.getUserId();
        } catch (Exception e) {
            return null;
        }
        if(pageindex==null||pagesize==null||userid==null){
            return null;
        }
        SingHistoryParam param = new SingHistoryParam();
        param.setUserid(userid);
        param.setPageindex(pageindex);
        param.setPagesize(pagesize);
        PageData<SingHistory> list=singHistoryService.getList(param);
        return list;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteRecrod(Integer id, String session) throws Exception {
        String userid = "";
        try {
            SessionInfo sessionInfo = SessionManager.readSession(session);
            userid = sessionInfo.getUserId();
        } catch (Exception e) {
            return null;
        }
        if(id==null||userid==null) {
            return "{'result':'参数不正确'}";
        }else {
            SingHistoryParam param = new SingHistoryParam();
            param.setId(id);
            param.setUserid(userid);
            int file = singHistoryService.delete(param);
            if (file == 1) {
                return "{'result':'ok'}";
            } else {
                return "{'result':'error'}";
            }
        }
    }
}
