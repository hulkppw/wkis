package com.ising99.wkis.dao;

import com.ising99.wkis.domain.ImusicChannelMusic;
import com.ising99.wkis.parameter.ImusicChannelMusicParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImusicChannelMusicMapper {

    List<ImusicChannelMusic> getList(ImusicChannelMusicParam param);

    Integer getCount(ImusicChannelMusicParam param);

    ImusicChannelMusic getOne(ImusicChannelMusicParam musicone);
}