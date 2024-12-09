/*
 * Decompiled with CFR 0.152.
 */
package org.iclass.vo;

import java.sql.Timestamp;

public class Community {
    private long idx;
    private String writer;
    private String title;
    private String content;
    private int readCount;
    private Timestamp createdAt;
    private String ip;
    private String commentCount;

    public static CommunityBuilder builder() {
        return new CommunityBuilder();
    }

    public long getIdx() {
        return this.idx;
    }

    public String getWriter() {
        return this.writer;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public int getReadCount() {
        return this.readCount;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public String getIp() {
        return this.ip;
    }

    public String getCommentCount() {
        return this.commentCount;
    }

    public String toString() {
        return "Community(idx=" + this.getIdx() + ", writer=" + this.getWriter() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", readCount=" + this.getReadCount() + ", createdAt=" + String.valueOf(this.getCreatedAt()) + ", ip=" + this.getIp() + ", commentCount=" + this.getCommentCount() + ")";
    }

    public Community() {
    }

    public Community(long idx, String writer, String title, String content, int readCount, Timestamp createdAt, String ip, String commentCount) {
        this.idx = idx;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.readCount = readCount;
        this.createdAt = createdAt;
        this.ip = ip;
        this.commentCount = commentCount;
    }

    public static class CommunityBuilder {
        private long idx;
        private String writer;
        private String title;
        private String content;
        private int readCount;
        private Timestamp createdAt;
        private String ip;
        private String commentCount;

        CommunityBuilder() {
        }

        public CommunityBuilder idx(long idx) {
            this.idx = idx;
            return this;
        }

        public CommunityBuilder writer(String writer) {
            this.writer = writer;
            return this;
        }

        public CommunityBuilder title(String title) {
            this.title = title;
            return this;
        }

        public CommunityBuilder content(String content) {
            this.content = content;
            return this;
        }

        public CommunityBuilder readCount(int readCount) {
            this.readCount = readCount;
            return this;
        }

        public CommunityBuilder createdAt(Timestamp createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CommunityBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public CommunityBuilder commentCount(String commentCount) {
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
}
