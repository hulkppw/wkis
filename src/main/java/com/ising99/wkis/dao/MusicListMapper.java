package com.ising99.wkis.dao;

import com.ising99.wkis.domain.MusicList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raise on 2015/3/10.
 */
@Repository
public interface MusicListMapper {

    List<MusicList> MusicList(@Param("version") String version, @Param("language") String language, @Param("songid") String songid);
    //inner join kds数据库中最新歌曲表数据
    List<MusicList> getMusicList(@Param("version") String version, @Param("language") String language);
}
