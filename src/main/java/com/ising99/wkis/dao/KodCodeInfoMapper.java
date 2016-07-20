package com.ising99.wkis.dao;

import com.ising99.wkis.domain.CmdInfo;
import com.ising99.wkis.domain.KodCodeInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2014-12-06.
 */
@Repository
public interface KodCodeInfoMapper {
    /**
     * 新增加
     * @param vo
     * @return
     */
    int insert(KodCodeInfo vo);

    /**
     * 判断是否存在
     * @param vo
     * @return
     */
    KodCodeInfo getVo (KodCodeInfo vo);


    KodCodeInfo isExists(KodCodeInfo vo);

}
