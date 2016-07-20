package com.ising99.wkis.service;

import com.ising99.wkis.domain.PageData;
import com.ising99.wkis.domain.Tone;
import com.ising99.wkis.parameter.ToneParam;

public interface ToneService {

    int add(ToneParam param);
    PageData<Tone> getList(ToneParam param);
    int delete(ToneParam param);
}

