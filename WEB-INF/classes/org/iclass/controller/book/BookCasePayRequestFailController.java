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
package org.iclass.controller.book;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookCasePayRequestFailController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(BookCasePayRequestFailController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, String> payErr = new HashMap<String, String>();
        payErr.put("code", request.getParameter("code"));
        payErr.put("orderId", request.getParameter("orderId"));
        payErr.put("message", request.getParameter("message"));
        logger.info("payErr : {}", payErr);
        request.setAttribute("payErr", payErr);
        RequestDispatcher dispatcher = request.getRequestDispatcher("reqfail.jsp");
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
    }
}
