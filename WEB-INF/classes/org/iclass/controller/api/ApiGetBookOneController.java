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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.dao.NewBooksDao;
import org.iclass.vo.NewBooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiGetBookOneController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(ApiGetBookOneController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objmapper = new ObjectMapper();
        String jsonData = null;
        try {
            int idx = Integer.parseInt(request.getParameter("idx"));
            logger.info("idx :{}", (Object)idx);
            NewBooksDao dao = NewBooksDao.getInstance();
            NewBooks book = dao.bookOne(idx);
            jsonData = objmapper.writeValueAsString((Object)book);
            logger.info("result :{}", (Object)book);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0L);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonData);
    }
}
