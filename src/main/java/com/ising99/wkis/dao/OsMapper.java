package com.ising99.wkis.dao;

import com.ising99.wkis.domain.Os;
import com.ising99.wkis.parameter.OsLatestVersionParam;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OsMapper {
    List<Os> latestVersionByDeviceCode(OsLatestVersionParam param);

    List<Os> getInfoByUTC(Long utc);

}