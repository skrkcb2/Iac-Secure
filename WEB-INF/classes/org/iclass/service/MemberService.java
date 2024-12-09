/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.iclass.dao.DemoMemberDao;
import org.iclass.vo.DemoMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberService {
    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
    private DemoMemberDao dao = DemoMemberDao.getInstance();

    public void join(DemoMember member) {
        try {
            String password = this.encrypt(member.getPassword());
            member.setPassword(password);
            this.dao.join(member);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public DemoMember login(Map<String, String> map) {
        DemoMember result = null;
        try {
            String password = this.encrypt(map.get("password"));
            map.put("password", password);
            result = this.dao.login(map);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());
        return this.bytesToHex(md.digest());
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        byte[] byArray = bytes;
        int n = bytes.length;
        int n2 = 0;
        while (n2 < n) {
            byte b = byArray[n2];
            builder.append(String.format("%02x", b));
            ++n2;
        }
        return builder.toString();
    }
}
