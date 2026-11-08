/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.apache.logging.log4j.ThreadContext;

@Converter(autoApply=false)
public class ContextStackAttributeConverter
implements AttributeConverter<ThreadContext.ContextStack, String> {
    public String convertToDatabaseColumn(ThreadContext.ContextStack contextStack) {
        if (contextStack == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : contextStack.asList()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append('\n');
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public ThreadContext.ContextStack convertToEntityAttribute(String string) {
        throw new UnsupportedOperationException("Log events can only be persisted, not extracted.");
    }
}

