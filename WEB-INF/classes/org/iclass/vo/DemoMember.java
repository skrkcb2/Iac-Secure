/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 */
package org.iclass.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DemoMember {
    private String userid;
    private String name;
    private String password;
    private String email;
    private int birth;
    private String gender;
    private String phone;
    private String favorites;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String postalCode;
    private String adultYn;
    private Timestamp joinDate;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return this.userid;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public int getBirth() {
        return this.birth;
    }

    public String getGender() {
        return this.gender;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getFavorites() {
        return this.favorites;
    }

    public String getAddress1() {
        return this.address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public String getAddress3() {
        return this.address3;
    }

    public String getAddress4() {
        return this.address4;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getAdultYn() {
        return this.adultYn;
    }

    public Timestamp getJoinDate() {
        return this.joinDate;
    }

    public DemoMember() {
    }

    public DemoMember(String userid, String name, String password, String email, int birth, String gender, String phone, String favorites, String address1, String address2, String address3, String address4, String postalCode, String adultYn, Timestamp joinDate) {
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.email = email;
        this.birth = birth;
        this.gender = gender;
        this.phone = phone;
        this.favorites = favorites;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.address4 = address4;
        this.postalCode = postalCode;
        this.adultYn = adultYn;
        this.joinDate = joinDate;
    }

    public String toString() {
        return "DemoMember(userid=" + this.getUserid() + ", name=" + this.getName() + ", password=" + this.getPassword() + ", email=" + this.getEmail() + ", birth=" + this.getBirth() + ", gender=" + this.getGender() + ", phone=" + this.getPhone() + ", favorites=" + this.getFavorites() + ", address1=" + this.getAddress1() + ", address2=" + this.getAddress2() + ", address3=" + this.getAddress3() + ", address4=" + this.getAddress4() + ", postalCode=" + this.getPostalCode() + ", adultYn=" + this.getAdultYn() + ", joinDate=" + String.valueOf(this.getJoinDate()) + ")";
    }
}
