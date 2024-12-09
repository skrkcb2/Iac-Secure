/*
 * Decompiled with CFR 0.152.
 */
package org.iclass.vo;

import java.util.Map;

public class Paging {
    private int currentPage;
    private int totalCount;
    private int pageSize;
    private int totalPage;
    private int startNo;
    private int endNo;
    private int startPage;
    private int endPage;
    private String column;
    private String findText;

    public Paging(int currentPage, int totalCount, int pageSize) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.totalPage = (int)Math.ceil((double)totalCount / (double)pageSize);
        this.currentPage = currentPage > this.totalPage ? this.totalPage : currentPage;
        this.currentPage = currentPage < 1 ? 1 : this.currentPage;
        this.startNo = (this.currentPage - 1) * pageSize + 1;
        this.endNo = this.startNo + (pageSize - 1);
        this.startPage = (this.currentPage - 1) / 10 * 10 + 1;
        this.endPage = this.startPage + 9;
        this.endPage = this.endPage > this.totalPage ? this.totalPage : this.endPage;
    }

    public void setFind(Map<String, String> map) {
        if (map != null) {
            this.column = map.get("column");
            this.findText = map.get("findText");
        }
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getStartNo() {
        return this.startNo;
    }

    public int getEndNo() {
        return this.endNo;
    }

    public int getStartPage() {
        return this.startPage;
    }

    public int getEndPage() {
        return this.endPage;
    }

    public String getColumn() {
        return this.column;
    }

    public String getFindText() {
        return this.findText;
    }

    public String toString() {
        return "Paging(currentPage=" + this.getCurrentPage() + ", totalCount=" + this.getTotalCount() + ", pageSize=" + this.getPageSize() + ", totalPage=" + this.getTotalPage() + ", startNo=" + this.getStartNo() + ", endNo=" + this.getEndNo() + ", startPage=" + this.getStartPage() + ", endPage=" + this.getEndPage() + ", column=" + this.getColumn() + ", findText=" + this.getFindText() + ")";
    }
}
