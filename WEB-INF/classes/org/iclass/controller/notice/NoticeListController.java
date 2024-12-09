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
package org.iclass.controller.notice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.iclass.controller.Controller;
import org.iclass.dao.NoticeDao;
import org.iclass.vo.Paging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticeListController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(NoticeListController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        logger.info(":::::::: \uc694\uccad {} \ucc98\ub9ac \uc2dc\uc791 : {} ::::::::", this.getClass(), (Object)request.getServletPath());
        int currentPage = 1;
        NoticeDao dao = NoticeDao.getInstance();
        String page = request.getParameter("page");
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }
        int pageSize = 7;
        int totalCount = 0;
        String findText = request.getParameter("findText");
        String column = request.getParameter("column");
        if (column != null && (column.equals("none") || column.length() == 0)) {
            column = null;
        }
        HashMap<String, String> findMap = null;
        if (findText != null) {
            findMap = new HashMap<String, String>();
            findMap.put("findText", findText);
            findMap.put("column", column);
        }
        totalCount = dao.count(findMap);
        Paging paging = new Paging(currentPage, totalCount, pageSize);
        logger.info(":::::::: ListController paging : {} ::::::::", (Object)paging);
        paging.setFind(findMap);
        request.setAttribute("list", dao.list(paging));
        HttpSession session = request.getSession();
        session.setAttribute("paging", (Object)paging);
        request.setAttribute("today", (Object)LocalDate.now());
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
    }
}
