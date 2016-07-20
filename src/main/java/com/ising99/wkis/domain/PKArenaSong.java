package com.ising99.wkis.domain;

import java.util.Date;

/**
 * Created by Hulk on 2014/11/12.
 */
public class PKArenaSong {
    private int id;
    private String title;
    private String songname;
    private int isis9;
    private Date start;
    private Date end;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public int getIsis9() {
        return isis9;
    }

    public void setIsis9(int isis9) {
        this.isis9 = isis9;
    }

//    public long getStart() {
//        return start;
//    }
//
//    public void setStart(long start) {
//        this.start = start;
//    }
//
//    public long getEnd() {
//        return end;
//    }
//
//    public void setEnd(long end) {
//        this.end = end;
//    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
