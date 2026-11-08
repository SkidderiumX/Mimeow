/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.NamePatternConverter;

@Plugin(name="LoggerPatternConverter", category="Converter")
@ConverterKeys(value={"c", "logger"})
public class LoggerPatternConverter
extends NamePatternConverter {
    private static final LoggerPatternConverter INSTANCE = new LoggerPatternConverter(null);

    private LoggerPatternConverter(String[] stringArray) {
        super("Logger", "logger", stringArray);
    }

    public static LoggerPatternConverter newInstance(String[] stringArray) {
        if (stringArray == null || stringArray.length == 0) {
            return INSTANCE;
        }
        return new LoggerPatternConverter(stringArray);
    }

    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        stringBuilder.append(this.abbreviate(logEvent.getLoggerName()));
    }
}

