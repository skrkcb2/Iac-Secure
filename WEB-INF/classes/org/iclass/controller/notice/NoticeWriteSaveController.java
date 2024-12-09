/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.oreilly.servlet.MultipartRequest
 *  com.oreilly.servlet.multipart.FileRenamePolicy
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.controller.notice;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.controller.notice.DateFileRenamePolicy;
import org.iclass.dao.NoticeDao;
import org.iclass.vo.Notice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticeWriteSaveController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(NoticeWriteSaveController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String path = "/opt/tomcat/upload/";
        int maxSize = 0x1E00000;
        MultipartRequest multiRequest = new MultipartRequest(request, path, maxSize, "UTF-8", (FileRenamePolicy)new DateFileRenamePolicy());
        String attachfile = multiRequest.getOriginalFileName("attachfile");
        String filename = multiRequest.getFilesystemName("attachfile");
        logger.info("::: \ud30c\uc77c\uba85-{} from {}  :::", (Object)filename, (Object)attachfile);
        String title = multiRequest.getParameter("title");
        String content = multiRequest.getParameter("content");
        Notice vo = Notice.builder().title(title).content(content).attachFile(attachfile).uploadFile(filename).build();
        NoticeDao dao = NoticeDao.getInstance();
        long result = dao.write(vo);
        if (result != 0L) {
            response.sendRedirect("list");
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }
}
