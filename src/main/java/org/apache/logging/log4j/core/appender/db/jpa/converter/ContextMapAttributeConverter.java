/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.jpa.converter;

import java.util.Map;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=false)
public class ContextMapAttributeConverter
implements AttributeConverter<Map<String, String>, String> {
    public String convertToDatabaseColumn(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        return map.toString();
    }

    public Map<String, String> convertToEntityAttribute(String string) {
        throw new UnsupportedOperationException("Log events can only be persisted, not extracted.");
    }
}

