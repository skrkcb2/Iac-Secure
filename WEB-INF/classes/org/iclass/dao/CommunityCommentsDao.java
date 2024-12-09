/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.session.SqlSession
 */
package org.iclass.dao;

import mybatis.SqlSessionBean;
import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.CommunityComments;

public class CommunityCommentsDao {
    private static CommunityCommentsDao dao = new CommunityCommentsDao();

    private CommunityCommentsDao() {
    }

    public static CommunityCommentsDao getInstance() {
        return dao;
    }

    public int insert(CommunityComments vo) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        int idx = mapperSession.insert("communityComments.insert", (Object)vo);
        mapperSession.commit();
        mapperSession.close();
        return idx;
    }

    public int delete(int idx) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        int result = mapperSession.delete("communityComments.delete", (Object)idx);
        mapperSession.commit();
        mapperSession.close();
        return result;
    }

    public int maxOf() {
        SqlSession session = SqlSessionBean.getSession();
        int result = (Integer)session.selectOne("communityComments.maxOf");
        session.close();
        return result;
    }

    public int setCommentCount(long idx) {
        SqlSession session = SqlSessionBean.getSession();
        int result = session.update("community.setCommentCount", (Object)idx);
        session.commit();
        session.close();
        return result;
    }
}
