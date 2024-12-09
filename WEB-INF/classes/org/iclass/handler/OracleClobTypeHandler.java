/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.type.BaseTypeHandler
 *  org.apache.ibatis.type.JdbcType
 */
package org.iclass.handler;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class OracleClobTypeHandler
extends BaseTypeHandler<String> {
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        Clob clob = preparedStatement.getConnection().createClob();
        clob.setString(1L, s);
        preparedStatement.setClob(i, clob);
    }

    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return this.clobToString(resultSet.getClob(s));
    }

    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return this.clobToString(resultSet.getClob(i));
    }

    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return this.clobToString(callableStatement.getClob(i));
    }

    private String clobToString(Clob clob) throws SQLException {
        if (clob == null) {
            return null;
        }
        try {
            int length = (int)clob.length();
            return clob.getSubString(1L, length);
        }
        catch (SQLException e) {
            throw new SQLException("Error converting CLOB to String", e);
        }
    }
}
