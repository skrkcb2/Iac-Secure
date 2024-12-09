/*
 * Decompiled with CFR 0.152.
 */
package org.iclass.vo;

import java.sql.Timestamp;
import org.iclass.vo.CommunityComments;

public static class CommunityComments.CommunityCommentsBuilder {
    private int idx;
    private long mref;
    private String writer;
    private String content;
    private Timestamp createdAt;
    private String ip;
    private int heart;

    CommunityComments.CommunityCommentsBuilder() {
    }

    public CommunityComments.CommunityCommentsBuilder idx(int idx) {
        this.idx = idx;
        return this;
    }

    public CommunityComments.CommunityCommentsBuilder mref(long mref) {
        this.mref = mref;
        return this;
    }

    public CommunityComments.CommunityCommentsBuilder writer(String writer) {
        this.writer = writer;
        return this;
    }

    public CommunityComments.CommunityCommentsBuilder content(String content) {
        this.content = content;
        return this;
    }

    public CommunityComments.CommunityCommentsBuilder createdAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public CommunityComments.CommunityCommentsBuilder ip(String ip) {
        this.ip = ip;
        return this;
    }

    public CommunityComments.CommunityCommentsBuilder heart(int heart) {
        this.heart = heart;
        return this;
    }

    public CommunityComments build() {
        return new CommunityComments(this.idx, this.mref, this.writer, this.content, this.createdAt, this.ip, this.heart);
    }

    public String toString() {
        return "CommunityComments.CommunityCommentsBuilder(idx=" + this.idx + ", mref=" + this.mref + ", writer=" + this.writer + ", content=" + this.content + ", createdAt=" + String.valueOf(this.createdAt) + ", ip=" + this.ip + ", heart=" + this.heart + ")";
    }
}
