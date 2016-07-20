package com.ising99.wkis.dao;
import com.ising99.wkis.domain.ImusicInstrument;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImusicInstrumentMapper {

    List<ImusicInstrument> getInstrumentList(int language);
}