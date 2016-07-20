package com.ising99.wkis.service.impl;


import com.ising99.wkis.dao.*;
import com.ising99.wkis.dao.base.DataSourceInstances;
import com.ising99.wkis.dao.base.DataSourceSwitch;
import com.ising99.wkis.domain.*;
import com.ising99.wkis.parameter.ImusicChannelMusicParam;
import com.ising99.wkis.parameter.ImusicLikeParam;
import com.ising99.wkis.parameter.ImusicHateParam;
import com.ising99.wkis.parameter.ImusicMusicAddParam;
import com.ising99.wkis.service.ImusicService;
import com.ising99.wkis.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


@Service("ImusicService")
public class ImusicServiceImpl implements ImusicService {
    @Resource
    ImusicVerMapper imusicVerMapper;
    @Resource
    ImusicChannelMapper imusicChannelMapper;
    @Resource
    ImusicChannelMusicMapper imusicChannelMusicMapper;
    @Resource
    ImusicBgMapper imusicBgMapper;
    @Resource
    ImusicInstrumentMapper imusicInstrumentMapper;
    @Resource
    ImusicSceneMapper imusicSceneMapper;
    @Resource
    ImusicLikeMapper imusicLikeMapper;
    @Resource
    ImusicHateMapper imusicHateMapper;

    @Override
    public String getVersionInfoByAppId(Integer type,Integer language) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("type", type);
        param.put("language", language);
        String aa=imusicVerMapper.getVersionInfoByAppId(param);
        System.out.println(aa);
        return aa;
    }
    @Override
    public List<ImusicChannelPage> getChannelPageList(Integer language) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        List<ImusicChannelPage> list=imusicChannelMapper.getChannelPageList(language);
        return list;
    }
    @Override
    public List<ImusicChannel> getChannelList(Integer language) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        List<ImusicChannel> list=imusicChannelMapper.getChannelList(language);
        return list;
    }

    @Override
    public List<ImusicChannelV2> getChannelListBy23Layer() {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return imusicChannelMapper.getChannelListBy23Layer();
    }

    @Override
    public PageData<ImusicChannelMusic> getMusicList(ImusicChannelMusicParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PageData<ImusicChannelMusic> pageData = new PageData<ImusicChannelMusic>();
        pageData.setRecordcount(imusicChannelMusicMapper.getCount(param));
        if (pageData.getRecordcount() == 0) {
            return pageData;
        }
        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pageData.setList(imusicChannelMusicMapper.getList(param));
        return pageData;
    }
    @Override
    public ImusicChannelMusic getMusicOne(ImusicChannelMusicParam musicone) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return imusicChannelMusicMapper.getOne(musicone);
    }
    @Override
    public List<ImusicBg> getBgList() {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return imusicBgMapper.getBgList();
    }

    @Override
    public List<ImusicInstrument> getInstrumentList(Integer language) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return imusicInstrumentMapper.getInstrumentList(language);
    }

    @Override
    public List<ImusicScene> getSceneList(Integer language) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return imusicSceneMapper.getSceneList(language);
    }

    @Override
    public PageData<ImusicLike> getLikeList(ImusicLikeParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PageData<ImusicLike> pageData = new PageData<ImusicLike>();
        pageData.setRecordcount(imusicLikeMapper.getCount(param));
        if (pageData.getRecordcount() == 0) {
            return pageData;
        }
        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pageData.setList(imusicLikeMapper.getList(param));
        return pageData;
    }

    @Override
    public PageData<ImusicHate> getHateList(ImusicHateParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        PageData<ImusicHate> pageData = new PageData<ImusicHate>();
        pageData.setRecordcount(imusicHateMapper.getCount(param));
        if (pageData.getRecordcount() == 0) {
            return pageData;
        }
        pageData.setPagecount(PageUtils.getPageCount(pageData.getRecordcount(), param.getPagesize()));
        param.setPageindex(param.getPageindex() > pageData.getPagecount() ? pageData.getPagecount() : param.getPageindex());
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        pageData.setList(imusicHateMapper.getList(param));
        return pageData;
    }

    @Override
    public int likeadd(ImusicMusicAddParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return imusicLikeMapper.add(param);
    }

    @Override
    public int hateadd(ImusicMusicAddParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return imusicHateMapper.add(param);
    }

    @Override
    public int likedelete(ImusicLikeParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return imusicLikeMapper.delete(param);
    }
    @Override
    public int hatedelete(ImusicHateParam param) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.KOD);
        return imusicHateMapper.delete(param);
    }
}
