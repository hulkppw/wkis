package com.ising99.wkis.dao;

import com.ising99.wkis.domain.TmsUserInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by Raise on 2015/1/24.
 */
@Repository
public interface TmsUserInfoMapper {
    //获取用户信息
    TmsUserInfo selectById(int id);

    //更新用户资料
    void update(TmsUserInfo tmsUserInfo);
    //根据platform_userid 查
    TmsUserInfo selectByUserId(String id,int platform);
    //添加
    void insert(TmsUserInfo tmsUserInfo);
}
