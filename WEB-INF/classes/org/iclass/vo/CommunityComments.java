/*
 * Decompiled with CFR 0.152.
 */
package org.iclass.vo;

import java.sql.Timestamp;

public class CommunityComments {
    private int idx;
    private long mref;
    private String writer;
    private String content;
    private Timestamp createdAt;
    private String ip;
    private int heart;

    public static CommunityCommentsBuilder builder() {
        return new CommunityCommentsBuilder();
    }

    public int getIdx() {
        return this.idx;
    }

    public long getMref() {
        return this.mref;
    }

    public String getWriter() {
        return this.writer;
    }

    public String getContent() {
        return this.content;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public String getIp() {
        return this.ip;
    }

    public int getHeart() {
        return this.heart;
    }

    public String toString() {
        return "CommunityComments(idx=" + this.getIdx() + ", mref=" + this.getMref() + ", writer=" + this.getWriter() + ", content=" + this.getContent() + ", createdAt=" + String.valueOf(this.getCreatedAt()) + ", ip=" + this.getIp() + ", heart=" + this.getHeart() + ")";
    }

    public CommunityComments() {
    }

    public CommunityComments(int idx, long mref, String writer, String content, Timestamp createdAt, String ip, int heart) {
        this.idx = idx;
        this.mref = mref;
        this.writer = writer;
        this.content = content;
        this.createdAt = createdAt;
        this.ip = ip;
        this.heart = heart;
    }

    public static class CommunityCommentsBuilder {
        private int idx;
        private long mref;
        private String writer;
        private String content;
        private Timestamp createdAt;
        private String ip;
        private int heart;

        CommunityCommentsBuilder() {
        }

        public CommunityCommentsBuilder idx(int idx) {
            this.idx = idx;
            return this;
        }

        public CommunityCommentsBuilder mref(long mref) {
            this.mref = mref;
            return this;
        }

        public CommunityCommentsBuilder writer(String writer) {
            this.writer = writer;
            return this;
        }

        public CommunityCommentsBuilder content(String content) {
            this.content = content;
            return this;
        }

        public CommunityCommentsBuilder createdAt(Timestamp createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CommunityCommentsBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public CommunityCommentsBuilder heart(int heart) {
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
}
