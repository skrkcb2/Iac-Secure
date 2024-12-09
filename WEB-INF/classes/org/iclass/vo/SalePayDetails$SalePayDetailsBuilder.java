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
import org.iclass.vo.SalePayDetails;

public static class SalePayDetails.SalePayDetailsBuilder {
    private String bcode;
    private String orderid;
    private int amount;
    private Timestamp paydate;
    private String buyuser;
    private String paytype;
    private String paymentkey;

    SalePayDetails.SalePayDetailsBuilder() {
    }

    public SalePayDetails.SalePayDetailsBuilder bcode(String bcode) {
        this.bcode = bcode;
        return this;
    }

    public SalePayDetails.SalePayDetailsBuilder orderid(String orderid) {
        this.orderid = orderid;
        return this;
    }

    public SalePayDetails.SalePayDetailsBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
    public SalePayDetails.SalePayDetailsBuilder paydate(Timestamp paydate) {
        this.paydate = paydate;
        return this;
    }

    public SalePayDetails.SalePayDetailsBuilder buyuser(String buyuser) {
        this.buyuser = buyuser;
        return this;
    }

    public SalePayDetails.SalePayDetailsBuilder paytype(String paytype) {
        this.paytype = paytype;
        return this;
    }

    public SalePayDetails.SalePayDetailsBuilder paymentkey(String paymentkey) {
        this.paymentkey = paymentkey;
        return this;
    }

    public SalePayDetails build() {
        return new SalePayDetails(this.bcode, this.orderid, this.amount, this.paydate, this.buyuser, this.paytype, this.paymentkey);
    }

    public String toString() {
        return "SalePayDetails.SalePayDetailsBuilder(bcode=" + this.bcode + ", orderid=" + this.orderid + ", amount=" + this.amount + ", paydate=" + String.valueOf(this.paydate) + ", buyuser=" + this.buyuser + ", paytype=" + this.paytype + ", paymentkey=" + this.paymentkey + ")";
    }
}
