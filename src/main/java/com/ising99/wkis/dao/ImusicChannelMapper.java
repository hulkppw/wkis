package com.ising99.wkis.dao;

import com.ising99.wkis.domain.ImusicChannelPage;
import com.ising99.wkis.domain.ImusicChannelV2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.ising99.wkis.domain.ImusicChannel;

import java.util.List;

@Repository
public interface ImusicChannelMapper {

    List<ImusicChannel> getChannelList(int language);

    List<ImusicChannelPage> getChannelPageList(int language);

    List<ImusicChannelV2> getChannelListBy23Layer();
}