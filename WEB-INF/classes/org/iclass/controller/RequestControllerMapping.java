/*
 * Decompiled with CFR 0.152.
 */
package org.iclass.controller;

import java.util.HashMap;
import java.util.Map;
import org.iclass.controller.Controller;
import org.iclass.controller.MemberDropController;
import org.iclass.controller.RequestKeyValue;
import org.iclass.controller.api.ApiCheckIdController;
import org.iclass.controller.api.ApiGetBookOneController;
import org.iclass.controller.api.ApiMemberJoinController;
import org.iclass.controller.api.ApiMemberModifyController;
import org.iclass.controller.api.ApiNewBookImageUploadController;
import org.iclass.controller.api.ApiPaymentSaveController;
import org.iclass.controller.book.BookCaseListController;
import org.iclass.controller.book.BookCasePayRequestFailController;
import org.iclass.controller.book.BookCasePayRequestSuccessController;
import org.iclass.controller.book.NewBookListController;
import org.iclass.controller.book.NewBookSaveController;
import org.iclass.controller.book.NewFormController;
import org.iclass.controller.community.CommentsController;
import org.iclass.controller.community.DeleteController;
import org.iclass.controller.community.ListController;
import org.iclass.controller.community.ReadController;
import org.iclass.controller.community.UpdateController;
import org.iclass.controller.community.UpdateViewController;
import org.iclass.controller.community.WriteController;
import org.iclass.controller.community.WriteViewController;
import org.iclass.controller.member.AuthCertSMSController;
import org.iclass.controller.member.LoginActionController;
import org.iclass.controller.member.LoginViewController;
import org.iclass.controller.member.LogoutController;
import org.iclass.controller.member.MemberJoinController;
import org.iclass.controller.member.MemberModifyController;
import org.iclass.controller.member.MemberSaveController;
import org.iclass.controller.notice.NoticeDeleteController;
import org.iclass.controller.notice.NoticeFileDownloadController;
import org.iclass.controller.notice.NoticeListController;
import org.iclass.controller.notice.NoticeReadController;
import org.iclass.controller.notice.NoticeUpdateController;
import org.iclass.controller.notice.NoticeUpdateSaveController;
import org.iclass.controller.notice.NoticeWriteController;
import org.iclass.controller.notice.NoticeWriteSaveController;

public class RequestControllerMapping {
    private static final Map<RequestKeyValue, Controller> mapping = new HashMap<RequestKeyValue, Controller>();

    public static void init() {
        mapping.put(new RequestKeyValue("/community/list", "GET"), new ListController());
        mapping.put(new RequestKeyValue("/community/write", "GET"), new WriteViewController());
        mapping.put(new RequestKeyValue("/community/write", "POST"), new WriteController());
        mapping.put(new RequestKeyValue("/community/read", "GET"), new ReadController());
        mapping.put(new RequestKeyValue("/community/update", "GET"), new UpdateViewController());
        mapping.put(new RequestKeyValue("/community/update", "POST"), new UpdateController());
        mapping.put(new RequestKeyValue("/community/delete", "GET"), new DeleteController());
        mapping.put(new RequestKeyValue("/community/comments", "POST"), new CommentsController());
        mapping.put(new RequestKeyValue("/join", "GET"), new MemberJoinController());
        mapping.put(new RequestKeyValue("/join", "POST"), new MemberSaveController());
        mapping.put(new RequestKeyValue("/auth/cert/sms", "GET"), new AuthCertSMSController());
        mapping.put(new RequestKeyValue("/member/modify", "GET"), new MemberModifyController());
        mapping.put(new RequestKeyValue("/api/modify", "POST"), new ApiMemberModifyController());
        mapping.put(new RequestKeyValue("/member/drop", "GET"), new MemberDropController());
        mapping.put(new RequestKeyValue("/login", "GET"), new LoginViewController());
        mapping.put(new RequestKeyValue("/login", "POST"), new LoginActionController());
        mapping.put(new RequestKeyValue("/logout", "GET"), new LogoutController());
        mapping.put(new RequestKeyValue("/book/new", "GET"), new NewFormController());
        mapping.put(new RequestKeyValue("/book/new", "POST"), new NewBookSaveController());
        mapping.put(new RequestKeyValue("/book/upload", "POST"), new ApiNewBookImageUploadController());
        mapping.put(new RequestKeyValue("/book/list", "GET"), new NewBookListController());
        mapping.put(new RequestKeyValue("/book/bookcase", "GET"), new BookCaseListController());
        mapping.put(new RequestKeyValue("/pay/success", "GET"), new BookCasePayRequestSuccessController());
        mapping.put(new RequestKeyValue("/pay/fail", "GET"), new BookCasePayRequestFailController());
        mapping.put(new RequestKeyValue("/notice/list", "GET"), new NoticeListController());
        mapping.put(new RequestKeyValue("/notice/read", "GET"), new NoticeReadController());
        mapping.put(new RequestKeyValue("/notice/write", "GET"), new NoticeWriteController());
        mapping.put(new RequestKeyValue("/notice/save", "POST"), new NoticeWriteSaveController());
        mapping.put(new RequestKeyValue("/notice/update", "GET"), new NoticeUpdateController());
        mapping.put(new RequestKeyValue("/notice/update", "POST"), new NoticeUpdateSaveController());
        mapping.put(new RequestKeyValue("/notice/delete", "GET"), new NoticeDeleteController());
        mapping.put(new RequestKeyValue("/notice/download", "POST"), new NoticeFileDownloadController());
        mapping.put(new RequestKeyValue("/api/auth/checkId", "POST"), new ApiCheckIdController());
        mapping.put(new RequestKeyValue("/api/auth/join", "POST"), new ApiMemberJoinController());
        mapping.put(new RequestKeyValue("/api/book", "GET"), new ApiGetBookOneController());
        mapping.put(new RequestKeyValue("/api/pay", "POST"), new ApiPaymentSaveController());
    }

    public static Controller getController(RequestKeyValue key) {
        return mapping.get(key);
    }
}
