package com.ising99.wkis.dao;

import com.ising99.wkis.domain.Tone;
import com.ising99.wkis.parameter.ToneParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToneMapper {

    int add(ToneParam param);
    List<Tone> getList(ToneParam param);
    Integer getCount(ToneParam param);
    int delete(ToneParam param);
}