/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.session.SqlSession
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.iclass.dao;

import java.util.List;
import java.util.Map;
import mybatis.SqlSessionBean;
import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.BookcaseBook;
import org.iclass.vo.SalePayDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookcaseDao {
    private static final Logger logger = LoggerFactory.getLogger(BookcaseDao.class);
    private static BookcaseDao dao = new BookcaseDao();

    private BookcaseDao() {
    }

    public static BookcaseDao getInstance() {
        return dao;
    }

    public List<BookcaseBook> saleList(Map<String, String> map) {
        SqlSession sqlSession = SqlSessionBean.getSession();
        List list = sqlSession.selectList("bookcase.saleList", map);
        logger.info("saleList :{}", (Object)list);
        sqlSession.close();
        return list;
    }

    public BookcaseBook getOne(String bcode) {
        SqlSession sqlSession = SqlSessionBean.getSession();
        BookcaseBook book = (BookcaseBook)sqlSession.selectOne("bookcase.getOne", (Object)bcode);
        sqlSession.close();
        return book;
    }

    public int saleOne(SalePayDetails book) {
        int result = 0;
        try (SqlSession sqlSession = SqlSessionBean.getSession();){
            try {
                result = sqlSession.insert("bookcase.saleOne", (Object)book);
                sqlSession.update("bookcase.changeStatus", (Object)book.getBcode());
                sqlSession.commit();
            }
            catch (Exception e) {
                logger.warn("\ub3c4\uc11c \uad6c\ub9e4 \uc624\ub958 : {}", (Object)e.getMessage());
                sqlSession.rollback();
                sqlSession.close();
            }
        }
        return result;
    }
}
