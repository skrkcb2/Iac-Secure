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
 */
package org.iclass.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.iclass.controller.Controller;
import org.iclass.dao.DemoMemberDao;
import org.iclass.vo.DemoMember;

public class MemberDropController
implements Controller {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = ((DemoMember)session.getAttribute("user")).getUserid();
        DemoMemberDao dao = DemoMemberDao.getInstance();
        dao.drop(id);
        session.invalidate();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/member/drop.jsp");
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
    }
}
