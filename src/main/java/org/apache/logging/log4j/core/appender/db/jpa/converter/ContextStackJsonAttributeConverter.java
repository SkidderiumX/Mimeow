/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.jpa.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.List;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.persistence.PersistenceException;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.appender.db.jpa.converter.ContextMapJsonAttributeConverter;
import org.apache.logging.log4j.core.helpers.Strings;
import org.apache.logging.log4j.spi.DefaultThreadContextStack;

@Converter(autoApply=false)
public class ContextStackJsonAttributeConverter
implements AttributeConverter<ThreadContext.ContextStack, String> {
    public String convertToDatabaseColumn(ThreadContext.ContextStack contextStack) {
        if (contextStack == null) {
            return null;
        }
        try {
            return ContextMapJsonAttributeConverter.OBJECT_MAPPER.writeValueAsString(contextStack.asList());
        }
        catch (IOException iOException) {
            throw new PersistenceException("Failed to convert stack list to JSON string.", (Throwable)iOException);
        }
    }

    public ThreadContext.ContextStack convertToEntityAttribute(String string) {
        List list;
        if (Strings.isEmpty(string)) {
            return null;
        }
        try {
            list = (List)ContextMapJsonAttributeConverter.OBJECT_MAPPER.readValue(string, (TypeReference)new TypeReference<List<String>>(){});
        }
        catch (IOException iOException) {
            throw new PersistenceException("Failed to convert JSON string to list for stack.", (Throwable)iOException);
        }
        DefaultThreadContextStack defaultThreadContextStack = new DefaultThreadContextStack(true);
        defaultThreadContextStack.addAll(list);
        return defaultThreadContextStack;
    }
}

