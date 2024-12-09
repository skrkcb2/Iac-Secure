/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.jsonwebtoken.Claims
 *  javax.servlet.Filter
 *  javax.servlet.FilterChain
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.filter;

import io.jsonwebtoken.Claims;
import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jwt.JwtModule;
import org.iclass.vo.DemoMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionFilter
implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(SessionFilter.class);

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Claims accessTokenClaims;
        List nosessions = List.of((Object)"/member/join", (Object)"/login", (Object)"/test");
        List logins = List.of((Object)"/community/update", (Object)"/community/delete", (Object)"/community/comments", (Object)"/community/write", (Object)"/member/modify", (Object)"/member/drop", (Object)"/api/modify");
        List admins = List.of((Object)"/notice/write", (Object)"/notice/update", (Object)"/notice/delete", (Object)"/admin");
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        logger.info(":::::::: \uc694\uccad \uc804 SessionFilter: {} ::::::::", (Object)httpRequest.getServletPath());
        HttpSession session = httpRequest.getSession();
        DemoMember user = (DemoMember)session.getAttribute("user");
        String accessToken = (String)session.getAttribute("accessToken");
        String refreshToken = (String)session.getAttribute("refreshToken");
        System.out.println("context : " + httpRequest.getContextPath());
        System.out.println("servlet : " + httpRequest.getServletPath());
        if (accessToken != null && (accessTokenClaims = JwtModule.validateToken(accessToken)) == null) {
            System.out.println("\ud1a0\ud070null\ubc1c\uacac");
            Claims refreshTokenClaims = JwtModule.validateToken(refreshToken);
            if (refreshTokenClaims != null) {
                System.out.println("\ub9ac\ud504\ub798\uc26c\ud1a0\ud070\uac80\uc99d\ud6c4 \uc7ac\ubc1c\uae09");
                String beforeaccessToken = accessToken;
                String newaccessToken = JwtModule.generateAccessToken(refreshTokenClaims.getSubject());
                String newrefreshToken = JwtModule.generateRefreshToken(refreshTokenClaims.getSubject());
                session.setAttribute("accessToken", (Object)newaccessToken);
                session.setAttribute("beforeaccessToken", (Object)beforeaccessToken);
                session.setAttribute("refreshToken", (Object)newrefreshToken);
                session.setAttribute("url", (Object)(httpRequest.getContextPath() + httpRequest.getServletPath()));
                accessToken = newaccessToken;
                refreshToken = newrefreshToken;
                String url = "tokenaccess.jsp";
                ((HttpServletResponse)response).sendRedirect(url);
            } else {
                System.out.println("\ub098\uac00\ub9ac");
                session.invalidate();
                return;
            }
        }
        if (nosessions.contains(httpRequest.getServletPath()) && user != null || logins.contains(httpRequest.getServletPath()) && user == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath());
            return;
        }
        if (admins.contains(httpRequest.getServletPath()) && (user == null || !user.getUserid().equals("admin"))) {
            throw new IOException();
        }
        chain.doFilter(request, response);
        logger.info(":::::::: \uc694\uccad \ud6c4  SessionFilter: {} ::::::::", (Object)httpRequest.getServletPath());
    }
}
