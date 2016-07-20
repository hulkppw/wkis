package com.ising99.wkis.dao;

//import com.ising99.wkis.domain.TFavorites;

import com.ising99.wkis.parameter.TFavoritesParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raise on 2015/2/6.
 */
@Repository
public interface TFavoritesMapper {
//    List<TFavorites> getList(TFavoritesParam param);

    Integer getCount(TFavoritesParam param);

}
