/*
 * Decompiled with CFR 0.152.
 */
package org.iclass.vo;

import java.sql.Timestamp;
import org.iclass.vo.Notice;

public static class Notice.NoticeBuilder {
    private long idx;
    private String title;
    private String content;
    private int readCount;
    private Timestamp createdAt;
    private String attachFile;
    private String uploadFile;

    Notice.NoticeBuilder() {
    }

    public Notice.NoticeBuilder idx(long idx) {
        this.idx = idx;
        return this;
    }

    public Notice.NoticeBuilder title(String title) {
        this.title = title;
        return this;
    }

    public Notice.NoticeBuilder content(String content) {
        this.content = content;
        return this;
    }

    public Notice.NoticeBuilder readCount(int readCount) {
        this.readCount = readCount;
        return this;
    }

    public Notice.NoticeBuilder createdAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Notice.NoticeBuilder attachFile(String attachFile) {
        this.attachFile = attachFile;
        return this;
    }

    public Notice.NoticeBuilder uploadFile(String uploadFile) {
        this.uploadFile = uploadFile;
        return this;
    }

    public Notice build() {
        return new Notice(this.idx, this.title, this.content, this.readCount, this.createdAt, this.attachFile, this.uploadFile);
    }

    public String toString() {
        return "Notice.NoticeBuilder(idx=" + this.idx + ", title=" + this.title + ", content=" + this.content + ", readCount=" + this.readCount + ", createdAt=" + String.valueOf(this.createdAt) + ", attachFile=" + this.attachFile + ", uploadFile=" + this.uploadFile + ")";
    }
}
