package com.ising99.wkis.service;

import com.ising99.wkis.domain.KodCodeInfo;
import com.ising99.wkis.parameter.KodCodeInfoParam;

/**
 * Created by Administrator on 2014-12-06.
 */
public interface KodCodeInfoService {

    int insert(KodCodeInfo vo);

    KodCodeInfo getVo(KodCodeInfo vo);

    KodCodeInfo isExists(KodCodeInfo vo);

}