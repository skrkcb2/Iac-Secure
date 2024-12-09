/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  javax.servlet.ServletException
 *  javax.servlet.ServletInputStream
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.dao.BookcaseDao;
import org.iclass.vo.SalePayDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiPaymentSaveController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(ApiPaymentSaveController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ServletInputStream inputStream = request.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader((InputStream)inputStream, StandardCharsets.UTF_8));
        StringBuffer sb = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        logger.info("json : {}", (Object)sb.toString());
        ObjectMapper objMapper = new ObjectMapper();
        SalePayDetails pay = (SalePayDetails)objMapper.readValue(sb.toString(), SalePayDetails.class);
        logger.info("member : {}", (Object)pay);
        BookcaseDao dao = BookcaseDao.getInstance();
        int cnt = dao.saleOne(pay);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0L);
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (cnt == 1) {
            out.print("\uacb0\uc81c\uac00 \uc644\ub8cc\ub418\uc5c8\uc2b5\ub2c8\ub2e4.");
        } else {
            out.print("\uacb0\uc81c \uc624\ub958\uac00 \ubc1c\uc0dd\ud588\uc2b5\ub2c8\ub2e4.");
        }
    }
}
