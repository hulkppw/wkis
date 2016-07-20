package com.ising99.wkis.dao;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ImusicVerMapper {

    String getVersionInfoByAppId(Map map);
}