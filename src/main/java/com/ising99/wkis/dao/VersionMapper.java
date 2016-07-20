package com.ising99.wkis.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Raise on 2015/3/10.
 */
@Repository
public interface VersionMapper {

    /**
     * 获取爱唱音乐库版本号
     *
     * @return
     */
    String getIsing99Version();
}