/*
 * Decompiled with CFR 0.152.
 */
package org.iclass.vo;

public class BookcaseBook {
    private String bcode;
    private String title;
    private String writer;
    private String publisher;
    private String pubdate;
    private String saleuser;
    private int price;
    private String cover;
    private String status;

    public String getBcode() {
        return this.bcode;
    }

    public String getTitle() {
        return this.title;
    }

    public String getWriter() {
        return this.writer;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getPubdate() {
        return this.pubdate;
    }

    public String getSaleuser() {
        return this.saleuser;
    }

    public int getPrice() {
        return this.price;
    }

    public String getCover() {
        return this.cover;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return "BookcaseBook(bcode=" + this.getBcode() + ", title=" + this.getTitle() + ", writer=" + this.getWriter() + ", publisher=" + this.getPublisher() + ", pubdate=" + this.getPubdate() + ", saleuser=" + this.getSaleuser() + ", price=" + this.getPrice() + ", cover=" + this.getCover() + ", status=" + this.getStatus() + ")";
    }

    public BookcaseBook() {
    }

    public BookcaseBook(String bcode, String title, String writer, String publisher, String pubdate, String saleuser, int price, String cover, String status) {
        this.bcode = bcode;
        this.title = title;
        this.writer = writer;
        this.publisher = publisher;
        this.pubdate = pubdate;
        this.saleuser = saleuser;
        this.price = price;
        this.cover = cover;
        this.status = status;
    }
}
