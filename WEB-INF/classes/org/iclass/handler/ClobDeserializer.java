/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.JsonParser
 *  com.fasterxml.jackson.databind.DeserializationContext
 *  com.fasterxml.jackson.databind.JsonDeserializer
 */
package org.iclass.handler;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialClob;

public class ClobDeserializer
extends JsonDeserializer<Clob> {
    public Clob deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        try {
            String value = jsonParser.getValueAsString();
            return this.stringToClob(value);
        }
        catch (SQLException e) {
            throw new IOException("Error converting String to CLOB", e);
        }
    }

    private Clob stringToClob(String value) throws SQLException, IOException {
        return new SerialClob(value.toCharArray());
    }
}
