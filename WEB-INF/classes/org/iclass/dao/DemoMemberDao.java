/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.session.SqlSession
 */
package org.iclass.dao;

import java.util.Map;
import mybatis.SqlSessionBean;
import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.DemoMember;

public class DemoMemberDao {
    private static DemoMemberDao dao = new DemoMemberDao();

    private DemoMemberDao() {
    }

    public static DemoMemberDao getInstance() {
        return dao;
    }

    public void join(DemoMember member) {
        SqlSession sqlSession = SqlSessionBean.getSession();
        sqlSession.insert("demomember.join", (Object)member);
        sqlSession.commit();
        sqlSession.close();
    }

    public void modify(DemoMember member) {
        SqlSession sqlSession = SqlSessionBean.getSession();
        sqlSession.update("demomember.modify", (Object)member);
        sqlSession.commit();
        sqlSession.close();
    }

    public DemoMember login(Map<String, String> map) {
        SqlSession sqlSession = SqlSessionBean.getSession();
        DemoMember vo = (DemoMember)sqlSession.selectOne("demomember.login", map);
        sqlSession.close();
        return vo;
    }

    public boolean isExistId(String id) {
        SqlSession sqlSession = SqlSessionBean.getSession();
        DemoMember vo = (DemoMember)sqlSession.selectOne("demomember.getById", (Object)id);
        boolean result = false;
        if (vo != null) {
            result = true;
        }
        return result;
    }

    public DemoMember getById(String id) {
        SqlSession sqlSession = SqlSessionBean.getSession();
        DemoMember vo = (DemoMember)sqlSession.selectOne("demomember.getById", (Object)id);
        return vo;
    }

    public void drop(String id) {
        SqlSession sqlSession = SqlSessionBean.getSession();
        sqlSession.update("demomember.drop", (Object)id);
        sqlSession.commit();
        sqlSession.close();
    }
}
