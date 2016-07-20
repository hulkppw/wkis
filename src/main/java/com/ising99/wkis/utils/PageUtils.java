package com.ising99.wkis.utils;

/**
 * Created by jerry on 2014/7/4.
 */
public class PageUtils {
    public static int getPageCount(int recordCount, int pageSize) {
        return recordCount % pageSize == 0 ? recordCount / pageSize
                : recordCount / pageSize + 1;
    }
}
