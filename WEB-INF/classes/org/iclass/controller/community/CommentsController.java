/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.controller.community;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.dao.CommunityCommentsDao;
import org.iclass.vo.CommunityComments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentsController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(CommentsController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommunityCommentsDao dao = CommunityCommentsDao.getInstance();
        String f = request.getParameter("f");
        Object url = null;
        long mref = Long.parseLong(request.getParameter("mref"));
        logger.info("::::::CommentesController  f={} :::::::", (Object)f);
        String page = request.getParameter("page");
        if (f.equals("1")) {
            CommunityComments vo = CommunityComments.builder().mref(mref).writer(request.getParameter("writer")).content(request.getParameter("content")).ip(request.getRemoteAddr()).build();
            url = dao.insert(vo) == 1 ? "read?idx=" + mref + "&page=" + page : "list";
        } else if (f.equals("2")) {
            int idx = Integer.parseInt(request.getParameter("idx"));
            url = dao.delete(idx) == 1 ? "read?idx=" + mref + "&page=" + page : "list";
        }
        dao.setCommentCount(mref);
        response.sendRedirect(url);
    }
}
