package com.ising99.wkis.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jerry on 2015/4/7.
 */
@Controller
@RequestMapping("player/appuser")
public class AppUserController extends BaseController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(String uniqueid,String packagename,String version,String imei,String mac,String macwifi){
        return "";
    }
}
