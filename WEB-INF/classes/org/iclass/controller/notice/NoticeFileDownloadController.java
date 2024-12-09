/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.ServletOutputStream
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package org.iclass.controller.notice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;

public class NoticeFileDownloadController implements Controller {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filePath = request.getServletContext().getRealPath("/") + "upload";
        String fileName = request.getParameter("uploadfile");
        String originfile = request.getParameter("attachfile");
        if (fileName == null) {
            throw new RuntimeException();
        }
        File file = new File(filePath, fileName);
        int fileSize = (int)file.length();
        if (fileSize == 0) {
            throw new RuntimeException();
        }
        response.setContentType("application/octet-stream;");
        response.setContentLength(fileSize);
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(originfile, "UTF-8"));
        response.setContentLengthLong((long)fileSize);
        FileInputStream in = new FileInputStream(file);
        ServletOutputStream out = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        in.close();
        out.close();
    }
}
