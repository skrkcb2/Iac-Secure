/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package org.iclass.controller.community;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;

public class UpdateController
implements Controller {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        long idx = Long.parseLong(request.getParameter("idx"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String ip = request.getRemoteAddr();
        Community vo = Community.builder().idx(idx).title(title).content(content).ip(ip).build();
        CommunityDao dao = CommunityDao.getInstance();
        int result = dao.update(vo);
        if (result == 1) {
            response.sendRedirect("read?idx=" + idx + "&page=" + request.getParameter("page"));
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }
}
