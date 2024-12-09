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
 */
package org.iclass.controller.book;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.dao.BookcaseDao;
import org.iclass.vo.BookcaseBook;

public class BookCaseListController
implements Controller {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookcaseDao dao = BookcaseDao.getInstance();
        List<BookcaseBook> list = dao.saleList(null);
        request.setAttribute("saleList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookcase.jsp");
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
    }
}
