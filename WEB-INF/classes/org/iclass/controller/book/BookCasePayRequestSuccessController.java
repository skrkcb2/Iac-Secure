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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.iclass.controller.Controller;
import org.iclass.dao.BookcaseDao;
import org.iclass.vo.BookcaseBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookCasePayRequestSuccessController
implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(BookCasePayRequestSuccessController.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object outputStream;
        String orderId = request.getParameter("orderId");
        int amount = Integer.parseInt(request.getParameter("amount"));
        BookcaseDao dao = BookcaseDao.getInstance();
        BookcaseBook item = dao.getOne(orderId.substring(0, 7));
        if (item.getPrice() != amount) {
            throw new IOException("\uae08\uc561\uc5d0 \ubb38\uc81c\uac00 \uc788\uc2b5\ub2c8\ub2e4.");
        }
        String apiUrl = "https://api.tosspayments.com/v1/payments/confirm";
        String paymentKey = request.getParameter("paymentKey");
        String secretKey = "";
        String authorizationHeader = BookCasePayRequestSuccessController.createAuthorizationHeader(secretKey);
        String jsonData = String.format("{\"paymentKey\":\"%s\",\"amount\":%d,\"orderId\":\"%s\"}", paymentKey, amount, orderId);
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", authorizationHeader);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        Throwable throwable = null;
        Object var15_17 = null;
        try {
            outputStream = new DataOutputStream(connection.getOutputStream());
            try {
                ((DataOutputStream)outputStream).writeBytes(jsonData);
                ((DataOutputStream)outputStream).flush();
            }
            finally {
                if (outputStream != null) {
                    ((FilterOutputStream)outputStream).close();
                }
            }
        }
        catch (Throwable throwable2) {
            if (throwable == null) {
                throwable = throwable2;
            } else if (throwable != throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
        int responseCode = connection.getResponseCode();
        if (responseCode != 200 && responseCode != 201) {
            throw new IOException("\uacb0\uc81c \uc624\ub958\uac00 \ubc1c\uc0dd\ud588\uc2b5\ub2c8\ub2e4.");
        }
        logger.info("Response Code: {}", (Object)responseCode);
        String payment = null;
        outputStream = null;
        Object var17_21 = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));){
            String line;
            StringBuilder responseStr = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                responseStr.append(line);
            }
            payment = responseStr.toString();
            logger.info("Response: {}", (Object)payment);
        }
        catch (Throwable throwable3) {
            if (outputStream == null) {
                outputStream = throwable3;
            } else if (outputStream != throwable3) {
                ((Throwable)outputStream).addSuppressed(throwable3);
            }
            throw outputStream;
        }
        connection.disconnect();
        request.setAttribute("payment", (Object)payment);
        request.setAttribute("item", (Object)item);
        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
    }

    private static String createAuthorizationHeader(String secretKey) {
        String credentials = secretKey + ":";
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
        return "Basic " + encodedCredentials;
    }
}
