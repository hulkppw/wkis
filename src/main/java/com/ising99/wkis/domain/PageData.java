package com.ising99.wkis.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerry on 2014/6/27.
 */
public class PageData<T> {
    public PageData() {
        this.pagecount = 0;
        this.recordcount = 0;
        this.list = new ArrayList<T>();
    }

    private int pagecount;

    public int getRecordcount() {
        return recordcount;
    }

    public void setRecordcount(int recordcount) {
        this.recordcount = recordcount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    private int recordcount;
    private List<T> list;


}
