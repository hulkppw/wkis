package com.ising99.wkis.service;

import com.ising99.wkis.domain.PageData;
import com.ising99.wkis.domain.SingHistory;
import com.ising99.wkis.parameter.SingHistoryParam;

public interface SingHistoryService {

    int add(SingHistoryParam param);
    PageData<SingHistory> getList(SingHistoryParam param);
    int delete(SingHistoryParam param);
}

