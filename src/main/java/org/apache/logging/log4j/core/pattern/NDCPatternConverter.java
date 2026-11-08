/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

@Plugin(name="NDCPatternConverter", category="Converter")
@ConverterKeys(value={"x", "NDC"})
public class NDCPatternConverter
extends LogEventPatternConverter {
    private static final NDCPatternConverter INSTANCE = new NDCPatternConverter();

    private NDCPatternConverter() {
        super("NDC", "ndc");
    }

    public static NDCPatternConverter newInstance(String[] stringArray) {
        return INSTANCE;
    }

    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        stringBuilder.append(logEvent.getContextStack());
    }
}

