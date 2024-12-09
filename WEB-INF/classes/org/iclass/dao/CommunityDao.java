/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.session.SqlSession
 */
package org.iclass.dao;

import java.util.List;
import java.util.Map;
import mybatis.SqlSessionBean;
import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Community;
import org.iclass.vo.CommunityComments;

public class CommunityDao {
    private static CommunityDao dao = new CommunityDao();

    private CommunityDao() {
    }

    public static CommunityDao getInstance() {
        return dao;
    }

    public long insert(Community vo) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        mapperSession.insert("community.insert", (Object)vo);
        mapperSession.commit();
        mapperSession.close();
        return vo.getIdx();
    }

    public int update(Community vo) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        int result = mapperSession.update("community.update", (Object)vo);
        mapperSession.commit();
        mapperSession.close();
        return result;
    }

    public int delete(long idx) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        int result = mapperSession.delete("community.delete", (Object)idx);
        mapperSession.commit();
        mapperSession.close();
        return result;
    }

    public Community selectByIdx(long idx) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        Community vo = (Community)mapperSession.selectOne("community.selectByIdx", (Object)idx);
        mapperSession.close();
        return vo;
    }

    public int count() {
        SqlSession mapperSession = SqlSessionBean.getSession();
        int result = (Integer)mapperSession.selectOne("community.count");
        mapperSession.close();
        return result;
    }

    public int setReadCount(long idx) {
        SqlSession session = SqlSessionBean.getSession();
        int result = session.update("community.setReadCount", (Object)idx);
        session.commit();
        session.close();
        return result;
    }

    public int commentsCount(long mref) {
        SqlSession session = SqlSessionBean.getSession();
        int result = (Integer)session.selectOne("community.commentsCount", (Object)mref);
        session.close();
        return result;
    }

    public int maxOf() {
        SqlSession session = SqlSessionBean.getSession();
        int result = (Integer)session.selectOne("community.maxOf");
        session.close();
        return result;
    }

    public List<CommunityComments> comments(long mref) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        List commentList = mapperSession.selectList("community.comments", (Object)mref);
        mapperSession.close();
        return commentList;
    }

    public List<Community> list() {
        SqlSession mapperSession = SqlSessionBean.getSession();
        List list = mapperSession.selectList("community.list");
        mapperSession.close();
        return list;
    }

    public List<Community> pagelist(Map<String, Integer> map) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        List list = mapperSession.selectList("community.pagelist", map);
        mapperSession.close();
        return list;
    }
}
