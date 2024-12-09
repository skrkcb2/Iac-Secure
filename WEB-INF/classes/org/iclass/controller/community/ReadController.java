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
package org.iclass.controller.community;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.iclass.vo.CommunityComments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(ReadController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temp = request.getParameter("idx");
        long idx = 0L;
        try {
            idx = Long.parseLong(temp);
            CommunityDao dao = CommunityDao.getInstance();
            dao.setReadCount(idx);
            Community vo = dao.selectByIdx(idx);
            if (vo == null) {
                throw new RuntimeException();
            }
            logger.debug("::::::: vo-{}:::::::", (Object)vo);
            request.setAttribute("vo", (Object)vo);
            List<CommunityComments> cmtlist = dao.comments(idx);
            request.setAttribute("cmtlist", cmtlist);
            request.setAttribute("page", (Object)request.getParameter("page"));
            RequestDispatcher dispatcher = request.getRequestDispatcher("read.jsp");
            dispatcher.forward((ServletRequest)request, (ServletResponse)response);
        }
        catch (NumberFormatException e) {
            response.sendRedirect("list");
        }
    }
}
