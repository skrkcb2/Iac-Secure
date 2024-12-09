/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 */
package org.iclass.controller.community;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.iclass.vo.DemoMember;

public class DeleteController
implements Controller {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommunityDao dao = CommunityDao.getInstance();
        long idx = Long.parseLong(request.getParameter("idx"));
        HttpSession session = request.getSession();
        DemoMember user = (DemoMember)session.getAttribute("user");
        Community vo = dao.selectByIdx(idx);
        if (vo == null || !vo.getWriter().equals(user.getUserid())) {
            throw new RuntimeException();
        }
        int result = dao.delete(idx);
        if (result == 1) {
            response.sendRedirect("list?page=" + request.getParameter("page"));
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }
}
