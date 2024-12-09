/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.RequestDispatcher
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.controller.notice;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.dao.NoticeDao;
import org.iclass.vo.Notice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticeReadController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(NoticeReadController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temp = request.getParameter("idx");
        int idx = 0;
        try {
            idx = Integer.parseInt(temp);
            NoticeDao dao = NoticeDao.getInstance();
            Notice vo = dao.read(idx);
            if (vo == null) {
                throw new RuntimeException();
            }
            logger.debug("::::::: vo-{}:::::::", (Object)vo);
            request.setAttribute("vo", (Object)vo);
            RequestDispatcher dispatcher = request.getRequestDispatcher("read.jsp");
            dispatcher.forward((ServletRequest)request, (ServletResponse)response);
        }
        catch (NumberFormatException e) {
            response.sendRedirect("list");
        }
    }
}
