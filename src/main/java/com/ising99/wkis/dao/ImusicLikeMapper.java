package com.ising99.wkis.dao;

import com.ising99.wkis.domain.ImusicLike;
import com.ising99.wkis.parameter.ImusicLikeParam;
import com.ising99.wkis.parameter.ImusicMusicAddParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImusicLikeMapper {

    List<ImusicLike> getList(ImusicLikeParam param);

    Integer getCount(ImusicLikeParam param);

    int add(ImusicMusicAddParam param);

    int delete(ImusicLikeParam param);
}