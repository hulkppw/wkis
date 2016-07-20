package com.ising99.wkis.dao;
import com.ising99.wkis.domain.ImusicBg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImusicBgMapper {

    List<ImusicBg> getBgList();
}