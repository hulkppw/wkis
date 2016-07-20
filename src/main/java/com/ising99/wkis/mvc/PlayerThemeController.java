package com.ising99.wkis.mvc;

import com.ising99.wkis.domain.PageData;
import com.ising99.wkis.domain.PlayerTheme;
import com.ising99.wkis.domain.PlayerThemeMusic;
import com.ising99.wkis.parameter.PlayerThemeMusicParam;
import com.ising99.wkis.parameter.PlayerThemeParam;
import com.ising99.wkis.service.PlayerThemeMusicService;
import com.ising99.wkis.service.PlayerThemeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jerry on 2014/7/4.
 */
@Controller
@RequestMapping("player/theme")
public class PlayerThemeController extends BaseController{
    @Resource
    PlayerThemeService playerThemeService;
    @Resource
    PlayerThemeMusicService playerThemeMusicService;

    /**
     * 获取主题菜单版本
     *
     * @param appid
     * @return
     */
    @RequestMapping("/ver")
    @ResponseBody
    public String getVersion(Integer appid) {
        return "{\"version\":\"" + playerThemeService.getVersionInfoByAppId(appid) + "\"}";
    }

    /**
     * 获取主题菜单列表
     *
     * @param appid
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<PlayerTheme> getList(Integer appid) {
        PlayerThemeParam param = new PlayerThemeParam();
        param.setAppVersionId(appid);
        return playerThemeService.getListByAppId(appid);
    }

    /**
     * 获取主题菜单版本
     *
     * @param appid
     * @return
     */
    @RequestMapping("/music/ver")
    @ResponseBody
    public String getMusicVersion(Integer appid) {
        return "{\"version\":\"" + playerThemeMusicService.getVersionInfoByAppId(appid) + "\"}";
    }

    /**
     * 获取主题菜单歌曲列表
     *
     * @param pageindex
     * @param pagesize
     * @param themeid
     * @return
     */
    @RequestMapping("/music/list")
    @ResponseBody
    public PageData<PlayerThemeMusic> getMusicList(Integer pageindex, Integer pagesize, Integer themeid) {
        PlayerThemeMusicParam param = new PlayerThemeMusicParam();
        param.setThemeid(themeid);
        param.setPageindex(pageindex);
        param.setPagesize(pagesize);
        return playerThemeMusicService.getList(param);
    }
}
