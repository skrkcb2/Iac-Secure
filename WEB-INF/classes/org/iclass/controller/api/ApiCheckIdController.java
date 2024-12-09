/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.dao.DemoMemberDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiCheckIdController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(ApiCheckIdController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objmapper = new ObjectMapper();
        DemoMemberDao memberDao = DemoMemberDao.getInstance();
        boolean result = memberDao.isExistId(request.getParameter("userid"));
        HashMap<String, Boolean> data = new HashMap<String, Boolean>();
        data.put("isExist", result);
        String jsonData = objmapper.writeValueAsString(data);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0L);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonData);
    }
}
