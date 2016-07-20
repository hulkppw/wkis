package com.ising99.wkis.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by jerry on 2015/4/7.
 */
@Repository
public interface AppUserMapper {
    Integer selectUserIdByUniqueID(String uniqueid);

}
