package com.ising99.wkis.dao;

import com.ising99.wkis.domain.KoicCode;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2015-02-06.
 */
@Repository
public interface KoicCodeMapper {

    KoicCode checkCode(String koiccode);
}
