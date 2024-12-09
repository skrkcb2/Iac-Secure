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

public class SalePayDetails {
    private String bcode;
    private String orderid;
    private int amount;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
    private Timestamp paydate;
    private String buyuser;
    private String paytype;
    private String paymentkey;

    public static SalePayDetailsBuilder builder() {
        return new SalePayDetailsBuilder();
    }

    public String getBcode() {
        return this.bcode;
    }

    public String getOrderid() {
        return this.orderid;
    }

    public int getAmount() {
        return this.amount;
    }

    public Timestamp getPaydate() {
        return this.paydate;
    }

    public String getBuyuser() {
        return this.buyuser;
    }

    public String getPaytype() {
        return this.paytype;
    }

    public String getPaymentkey() {
        return this.paymentkey;
    }

    public String toString() {
        return "SalePayDetails(bcode=" + this.getBcode() + ", orderid=" + this.getOrderid() + ", amount=" + this.getAmount() + ", paydate=" + String.valueOf(this.getPaydate()) + ", buyuser=" + this.getBuyuser() + ", paytype=" + this.getPaytype() + ", paymentkey=" + this.getPaymentkey() + ")";
    }

    public SalePayDetails() {
    }

    public SalePayDetails(String bcode, String orderid, int amount, Timestamp paydate, String buyuser, String paytype, String paymentkey) {
        this.bcode = bcode;
        this.orderid = orderid;
        this.amount = amount;
        this.paydate = paydate;
        this.buyuser = buyuser;
        this.paytype = paytype;
        this.paymentkey = paymentkey;
    }

    public static class SalePayDetailsBuilder {
        private String bcode;
        private String orderid;
        private int amount;
        private Timestamp paydate;
        private String buyuser;
        private String paytype;
        private String paymentkey;

        SalePayDetailsBuilder() {
        }

        public SalePayDetailsBuilder bcode(String bcode) {
            this.bcode = bcode;
            return this;
        }

        public SalePayDetailsBuilder orderid(String orderid) {
            this.orderid = orderid;
            return this;
        }

        public SalePayDetailsBuilder amount(int amount) {
            this.amount = amount;
            return this;
        }

        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
        public SalePayDetailsBuilder paydate(Timestamp paydate) {
            this.paydate = paydate;
            return this;
        }

        public SalePayDetailsBuilder buyuser(String buyuser) {
            this.buyuser = buyuser;
            return this;
        }

        public SalePayDetailsBuilder paytype(String paytype) {
            this.paytype = paytype;
            return this;
        }

        public SalePayDetailsBuilder paymentkey(String paymentkey) {
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
}
