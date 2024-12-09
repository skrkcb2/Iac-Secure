/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.session.SqlSession
 */
package org.iclass.dao;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import mybatis.SqlSessionBean;
import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.NewBooks;

public class NewBooksDao {
    private static NewBooksDao dao = new NewBooksDao();

    private NewBooksDao() {
    }

    public static NewBooksDao getInstance() {
        return dao;
    }

    public static Clob clobConvert(String temp) {
        SqlSession sqlSession = SqlSessionBean.getSession();
        Clob clob = null;
        try {
            clob = sqlSession.getConnection().createClob();
            clob.setString(1L, temp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return clob;
    }

    public List<NewBooks> list() {
        SqlSession sqlSession = SqlSessionBean.getSession();
        List list = sqlSession.selectList("books.listAll");
        sqlSession.close();
        return list;
    }

    public NewBooks bookOne(int idx) {
        SqlSession sqlSession = SqlSessionBean.getSession();
        NewBooks book = (NewBooks)sqlSession.selectOne("books.getOne", (Object)idx);
        sqlSession.close();
        return book;
    }

    public int insert(NewBooks book) {
        SqlSession sqlSession = SqlSessionBean.getSession();
        int result = sqlSession.insert("books.insert", (Object)book);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }
}
