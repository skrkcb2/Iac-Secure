/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.oreilly.servlet.MultipartRequest
 *  com.oreilly.servlet.multipart.DefaultFileRenamePolicy
 *  com.oreilly.servlet.multipart.FileRenamePolicy
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.controller.book;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.dao.NewBooksDao;
import org.iclass.vo.NewBooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewBookSaveController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(NewBookSaveController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/opt/tomcat/upload/";
        int maxSize = 0xA00000;
        MultipartRequest multiRequest = new MultipartRequest(request, path, maxSize, "UTF-8", (FileRenamePolicy)new DefaultFileRenamePolicy());
        String title = multiRequest.getParameter("title");
        String temp = multiRequest.getParameter("summary");
        String userid = multiRequest.getParameter("userid");
        String cover = multiRequest.getFilesystemName("coverfile");
        logger.info("::: \ud30c\uc77c\uba85-{}  :::", (Object)cover);
        NewBooksDao dao = NewBooksDao.getInstance();
        String url = null;
        NewBooks book = new NewBooks(0, title, temp, null, cover, userid);
        url = dao.insert(book) == 1 ? "list" : "new";
        response.sendRedirect(url);
    }
}
