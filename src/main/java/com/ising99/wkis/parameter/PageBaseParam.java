package com.ising99.wkis.parameter;

/**
 * Created by jerry on 2014/6/27.
 */
public class PageBaseParam {

    public Integer getOffset() {
        this.offset = (pageindex - 1) * pagesize;
        return offset;
    }

    private Integer offset;

    public Integer getPageindex() {
        return pageindex;
    }

    public void setPageindex(Integer pageindex) {
        if (pageindex == null) {
            pageindex = 1;
        } else {
            if (pageindex < 1) {
                pageindex = 1;
            }
        }
        this.pageindex = pageindex;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        if (pagesize == null) {
            pagesize = 5;
        } else {
            if (pagesize < 1) {
                pagesize = 1;
            }
        }
        this.pagesize = pagesize;
    }

    private Integer pageindex;
    private Integer pagesize;
}
