/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonFormat$Shape
 */
package org.iclass.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

public class NewBooks {
    private int idx;
    private String title;
    private String summary;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    private Timestamp regdate;
    private String coverfile;
    private String userid;

    public int getIdx() {
        return this.idx;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSummary() {
        return this.summary;
    }

    public Timestamp getRegdate() {
        return this.regdate;
    }

    public String getCoverfile() {
        return this.coverfile;
    }

    public String getUserid() {
        return this.userid;
    }

    public String toString() {
        return "NewBooks(idx=" + this.getIdx() + ", title=" + this.getTitle() + ", summary=" + this.getSummary() + ", regdate=" + String.valueOf(this.getRegdate()) + ", coverfile=" + this.getCoverfile() + ", userid=" + this.getUserid() + ")";
    }

    public NewBooks() {
    }

    public NewBooks(int idx, String title, String summary, Timestamp regdate, String coverfile, String userid) {
        this.idx = idx;
        this.title = title;
        this.summary = summary;
        this.regdate = regdate;
        this.coverfile = coverfile;
        this.userid = userid;
    }
}
