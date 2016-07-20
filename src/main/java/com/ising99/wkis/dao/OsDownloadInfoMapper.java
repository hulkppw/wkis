package com.ising99.wkis.dao;


import com.ising99.wkis.parameter.OsDownloadInfoParam;
import org.springframework.stereotype.Repository;

@Repository
public interface OsDownloadInfoMapper {
    void insert(OsDownloadInfoParam osDownloadInfoParam);
}