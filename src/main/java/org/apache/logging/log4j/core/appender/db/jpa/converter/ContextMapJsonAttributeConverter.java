/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.jpa.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.persistence.PersistenceException;
import org.apache.logging.log4j.core.helpers.Strings;

@Converter(autoApply=false)
public class ContextMapJsonAttributeConverter
implements AttributeConverter<Map<String, String>, String> {
    static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public String convertToDatabaseColumn(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(map);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Failed to convert map to JSON string.", (Throwable)iOException);
        }
    }

    public Map<String, String> convertToEntityAttribute(String string) {
        if (Strings.isEmpty(string)) {
            return null;
        }
        try {
            return (Map)OBJECT_MAPPER.readValue(string, (TypeReference)new TypeReference<Map<String, String>>(){});
        }
        catch (IOException iOException) {
            throw new PersistenceException("Failed to convert JSON string to map.", (Throwable)iOException);
        }
    }
}

