package com.ising99.wkis.dao;
import com.ising99.wkis.parameter.SingHistoryParam;
import org.springframework.stereotype.Repository;
import com.ising99.wkis.domain.SingHistory;

import java.util.List;

@Repository
public interface SingHistoryMapper {

    int add(SingHistoryParam param);
    List<SingHistory> getList(SingHistoryParam param);
    Integer getCount(SingHistoryParam param);
    int delete(SingHistoryParam param);
}