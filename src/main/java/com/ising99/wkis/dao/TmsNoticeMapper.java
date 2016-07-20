package com.ising99.wkis.dao;

import com.ising99.wkis.domain.TmsNotice;
import com.ising99.wkis.domain.TmsUserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raise on 2015/1/24.
 */
@Repository
public interface TmsNoticeMapper {
    //上架通知
    List<TmsNotice> findByL(int language);
    //通过userid、noticed=0（false） 获取上架通知列表
    List<TmsNotice> getNotice(int userid,Boolean noticed);


}
