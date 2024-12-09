/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  javax.servlet.ServletException
 *  javax.servlet.ServletInputStream
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.iclass.controller.Controller;
import org.iclass.dao.DemoMemberDao;
import org.iclass.vo.DemoMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiMemberModifyController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(ApiMemberModifyController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ServletInputStream inputStream = request.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader((InputStream)inputStream, StandardCharsets.UTF_8));
        StringBuffer sb = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        logger.info("json : {}", (Object)sb.toString());
        ObjectMapper objMapper = new ObjectMapper();
        DemoMember member = (DemoMember)objMapper.readValue(sb.toString(), DemoMember.class);
        logger.info("member : {}", (Object)member);
        DemoMemberDao dao = DemoMemberDao.getInstance();
        dao.modify(member);
        HttpSession session = request.getSession();
        session.setAttribute("user", (Object)dao.getById(member.getUserid()));
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0L);
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("\ud68c\uc6d0\uc815\ubcf4\uac00 \uc218\uc815\ub418\uc5c8\uc2b5\ub2c8\ub2e4.");
    }
}
