/*
 * Decompiled with CFR 0.152.
 */
package org.iclass.vo;

import java.sql.Timestamp;
import org.iclass.vo.Community;

public static class Community.CommunityBuilder {
    private long idx;
    private String writer;
    private String title;
    private String content;
    private int readCount;
    private Timestamp createdAt;
    private String ip;
    private String commentCount;

    Community.CommunityBuilder() {
    }

    public Community.CommunityBuilder idx(long idx) {
        this.idx = idx;
        return this;
    }

    public Community.CommunityBuilder writer(String writer) {
        this.writer = writer;
        return this;
    }

    public Community.CommunityBuilder title(String title) {
        this.title = title;
        return this;
    }

    public Community.CommunityBuilder content(String content) {
        this.content = content;
        return this;
    }

    public Community.CommunityBuilder readCount(int readCount) {
        this.readCount = readCount;
        return this;
    }

    public Community.CommunityBuilder createdAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Community.CommunityBuilder ip(String ip) {
        this.ip = ip;
        return this;
    }

    public Community.CommunityBuilder commentCount(String commentCount) {
        this.commentCount = commentCount;
        return this;
    }

    public Community build() {
        return new Community(this.idx, this.writer, this.title, this.content, this.readCount, this.createdAt, this.ip, this.commentCount);
    }

    public String toString() {
        return "Community.CommunityBuilder(idx=" + this.idx + ", writer=" + this.writer + ", title=" + this.title + ", content=" + this.content + ", readCount=" + this.readCount + ", createdAt=" + String.valueOf(this.createdAt) + ", ip=" + this.ip + ", commentCount=" + this.commentCount + ")";
    }
}
