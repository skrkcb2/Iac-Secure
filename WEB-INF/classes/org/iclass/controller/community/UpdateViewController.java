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
 *  javax.servlet.http.HttpSession
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.controller.community;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.iclass.vo.DemoMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateViewController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(UpdateViewController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temp = request.getParameter("idx");
        long idx = 0L;
        HttpSession session = request.getSession();
        DemoMember user = (DemoMember)session.getAttribute("user");
        try {
            idx = Long.parseLong(temp);
            CommunityDao dao = CommunityDao.getInstance();
            Community vo = dao.selectByIdx(idx);
            if (vo == null || !vo.getWriter().equals(user.getUserid())) {
                throw new RuntimeException();
            }
            request.setAttribute("vo", (Object)vo);
            logger.info(":::::::UpdateViewController page - {} ::::::::::", (Object)request.getParameter("page"));
            request.setAttribute("page", (Object)request.getParameter("page"));
            RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
            dispatcher.forward((ServletRequest)request, (ServletResponse)response);
        }
        catch (NumberFormatException e) {
            response.sendRedirect("list");
        }
    }
}
