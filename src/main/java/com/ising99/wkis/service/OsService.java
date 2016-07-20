package com.ising99.wkis.service;

import com.ising99.wkis.domain.Os;
import com.ising99.wkis.parameter.OsLatestVersionParam;

import java.util.List;

/**
 * Created by jerry on 2014/6/28.
 */
public interface OsService {
    List<Os> latestVersionByDeviceCode(OsLatestVersionParam param);

    List<Os> getInfoByUTC(Long utc);
}
