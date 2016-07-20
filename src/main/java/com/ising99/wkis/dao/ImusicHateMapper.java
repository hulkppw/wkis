package com.ising99.wkis.dao;

import com.ising99.wkis.domain.ImusicHate;
import com.ising99.wkis.parameter.ImusicHateParam;
import com.ising99.wkis.parameter.ImusicMusicAddParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImusicHateMapper {

    List<ImusicHate> getList(ImusicHateParam param);

    Integer getCount(ImusicHateParam param);

    int add(ImusicMusicAddParam param);

    int delete(ImusicHateParam param);
}