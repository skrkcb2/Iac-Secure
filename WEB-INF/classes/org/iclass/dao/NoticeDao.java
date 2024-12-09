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
import org.iclass.vo.Notice;
import org.iclass.vo.Paging;

public class NoticeDao {
    private static NoticeDao dao = new NoticeDao();

    private NoticeDao() {
    }

    public static NoticeDao getInstance() {
        return dao;
    }

    public List<Notice> list(Paging paging) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        List list = mapperSession.selectList("notice.getList", (Object)paging);
        mapperSession.close();
        return list;
    }

    public int count(Map<String, String> map) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        int result = (Integer)mapperSession.selectOne("notice.count", map);
        mapperSession.close();
        return result;
    }

    public Notice read(int idx) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        Notice vo = (Notice)mapperSession.selectOne("notice.getOne", (Object)idx);
        mapperSession.close();
        return vo;
    }

    public int write(Notice notice) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        int result = mapperSession.insert("notice.insert", (Object)notice);
        mapperSession.commit();
        mapperSession.close();
        return result;
    }

    public int update(Notice notice) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        int result = mapperSession.update("notice.update", (Object)notice);
        mapperSession.commit();
        mapperSession.close();
        return result;
    }

    public int delete(int idx) {
        SqlSession mapperSession = SqlSessionBean.getSession();
        int result = mapperSession.update("notice.delete", (Object)idx);
        mapperSession.commit();
        mapperSession.close();
        return result;
    }
}
