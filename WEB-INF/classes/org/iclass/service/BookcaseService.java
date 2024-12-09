/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.service;

import org.iclass.dao.BookcaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookcaseService {
    private static final Logger logger = LoggerFactory.getLogger(BookcaseService.class);
    private BookcaseDao dao = BookcaseDao.getInstance();
}
