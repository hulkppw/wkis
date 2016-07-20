package com.ising99.wkis.dao;
import com.ising99.wkis.domain.ImusicScene;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImusicSceneMapper {

    List<ImusicScene> getSceneList(int language);
}