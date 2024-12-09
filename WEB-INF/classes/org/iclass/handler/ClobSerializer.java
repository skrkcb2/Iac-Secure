/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.JsonGenerator
 *  com.fasterxml.jackson.databind.JsonSerializer
 *  com.fasterxml.jackson.databind.SerializerProvider
 */
package org.iclass.handler;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

public class ClobSerializer
extends JsonSerializer<Clob> {
    public void serialize(Clob clob, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        try {
            String clobAsString = this.clobToString(clob);
            jsonGenerator.writeString(clobAsString);
        }
        catch (SQLException e) {
            throw new IOException("Error converting CLOB to String", e);
        }
    }

    private String clobToString(Clob clob) throws SQLException, IOException {
        StringBuilder sb = new StringBuilder();
        Throwable throwable = null;
        Object var4_5 = null;
        try (Reader reader = clob.getCharacterStream();){
            int bytesRead;
            char[] buffer = new char[1024];
            while ((bytesRead = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, bytesRead);
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
        return sb.toString();
    }
}
