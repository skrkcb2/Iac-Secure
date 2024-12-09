/*
 * Decompiled with CFR 0.152.
 */
package org.iclass.vo;

import java.sql.Timestamp;

public class Notice {
    private long idx;
    private String title;
    private String content;
    private int readCount;
    private Timestamp createdAt;
    private String attachFile;
    private String uploadFile;

    public static NoticeBuilder builder() {
        return new NoticeBuilder();
    }

    public long getIdx() {
        return this.idx;
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

    public String getAttachFile() {
        return this.attachFile;
    }

    public String getUploadFile() {
        return this.uploadFile;
    }

    public String toString() {
        return "Notice(idx=" + this.getIdx() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", readCount=" + this.getReadCount() + ", createdAt=" + String.valueOf(this.getCreatedAt()) + ", attachFile=" + this.getAttachFile() + ", uploadFile=" + this.getUploadFile() + ")";
    }

    public Notice() {
    }

    public Notice(long idx, String title, String content, int readCount, Timestamp createdAt, String attachFile, String uploadFile) {
        this.idx = idx;
        this.title = title;
        this.content = content;
        this.readCount = readCount;
        this.createdAt = createdAt;
        this.attachFile = attachFile;
        this.uploadFile = uploadFile;
    }

    public static class NoticeBuilder {
        private long idx;
        private String title;
        private String content;
        private int readCount;
        private Timestamp createdAt;
        private String attachFile;
        private String uploadFile;

        NoticeBuilder() {
        }

        public NoticeBuilder idx(long idx) {
            this.idx = idx;
            return this;
        }

        public NoticeBuilder title(String title) {
            this.title = title;
            return this;
        }

        public NoticeBuilder content(String content) {
            this.content = content;
            return this;
        }

        public NoticeBuilder readCount(int readCount) {
            this.readCount = readCount;
            return this;
        }

        public NoticeBuilder createdAt(Timestamp createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public NoticeBuilder attachFile(String attachFile) {
            this.attachFile = attachFile;
            return this;
        }

        public NoticeBuilder uploadFile(String uploadFile) {
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
}
