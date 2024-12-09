/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.RequestDispatcher
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.annotation.WebServlet
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.controller.RequestControllerMapping;
import org.iclass.controller.RequestKeyValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns={"/"})
public class FrontController
extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(FrontController.class);
    private RequestKeyValue key = null;

    public void init() throws ServletException {
        RequestControllerMapping.init();
        logger.info(">>>>>>> FrontController \uc11c\ube14\ub9bf \uc0dd\uc131  <<<<<<<");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getServletPath();
        String method = request.getMethod();
        this.key = new RequestKeyValue(url, method);
        Controller controller = RequestControllerMapping.getController(this.key);
        if (url.equals("/")) {
            logger.info("::::::::::::::::::::");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward((ServletRequest)request, (ServletResponse)response);
        } else if (controller != null) {
            logger.info("::::::::::{}-{}::::::::::", (Object)this.key, controller.getClass());
            controller.handle(request, response);
        }
    }

    public void destroy() {
        logger.info("::::::::::destroy -{}::::::::::", (Object)this.key);
    }
}
