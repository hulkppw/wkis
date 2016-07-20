package com.ising99.wkis.dao;

import com.ising99.wkis.domain.TmsMixer;
import com.ising99.wkis.domain.TmsNotice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raise on 2015/1/24.
 */
@Repository
public interface TmsMixerMapper {
    TmsMixer selectById(int id);
    //获取我的调音台信息
    TmsMixer getMixer(int userid);
    //更新我的调音台信息
    void update(TmsMixer tmsMixer);
}
