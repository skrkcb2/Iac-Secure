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
import java.time.LocalDate;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Paging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(ListController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info(":::::::: \uc694\uccad ListController \ucc98\ub9ac \uc2dc\uc791 : {} ::::::::", (Object)request.getServletPath());
        int currentPage = 1;
        CommunityDao dao = CommunityDao.getInstance();
        String page = request.getParameter("page");
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }
        int pageSize = 5;
        int totalCount = dao.count();
        Paging paging = new Paging(currentPage, totalCount, pageSize);
        logger.info(":::::::: ListController paging : {} ::::::::", (Object)paging);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("start", paging.getStartNo());
        map.put("end", paging.getEndNo());
        request.setAttribute("list", dao.pagelist(map));
        request.setAttribute("paging", (Object)paging);
        request.setAttribute("today", (Object)LocalDate.now());
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
    }
}
