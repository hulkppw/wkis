package com.ising99.wkis.dao;

import com.ising99.wkis.domain.TmsNotice;
import com.ising99.wkis.domain.TmsTheme;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raise on 2015/1/24.
 */
@Repository
public interface TmsThemeMapper {
    //获取主题
    List<TmsTheme> findByL(int language);
}
