/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.Cookie
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.controller.member;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.iclass.controller.Controller;
import org.iclass.service.MemberService;
import org.iclass.vo.DemoMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginActionController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(LoginActionController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("userid");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("userid", id);
        map.put("password", password);
        MemberService service = new MemberService();
        DemoMember user = service.login(map);
        String url = request.getContextPath();
        if (user != null) {
            session.setAttribute("user", (Object)user);
            url = request.getContextPath();
        } else {
            Cookie cookie = new Cookie("incorrect", "y");
            cookie.setPath("/");
            response.addCookie(cookie);
            url = "login";
        }
        response.sendRedirect(url);
    }
}
