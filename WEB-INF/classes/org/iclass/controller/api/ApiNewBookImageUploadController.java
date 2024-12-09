/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.oreilly.servlet.MultipartRequest
 *  com.oreilly.servlet.multipart.FileRenamePolicy
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.controller.api.DateFileRenamePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiNewBookImageUploadController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(ApiNewBookImageUploadController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletContext().getRealPath("/") + "upload";
        int maxSize = 0xA00000;
        MultipartRequest multiRequest = new MultipartRequest(request, path, maxSize, "UTF-8", (FileRenamePolicy)new DateFileRenamePolicy());
        String filename = multiRequest.getFilesystemName("uploadFile");
        logger.info("::: \ud30c\uc77c\uba85-{}  :::", (Object)filename);
        ObjectMapper objmapper = new ObjectMapper();
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("filename", filename);
        String jsonData = objmapper.writeValueAsString(data);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0L);
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonData);
    }
}
