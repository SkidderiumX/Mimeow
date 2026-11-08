/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.NamePatternConverter;

@Plugin(name="ClassNamePatternConverter", category="Converter")
@ConverterKeys(value={"C", "class"})
public class ClassNamePatternConverter
extends NamePatternConverter {
    private static final String NA = "?";

    private ClassNamePatternConverter(String[] stringArray) {
        super("Class Name", "class name", stringArray);
    }

    public static ClassNamePatternConverter newInstance(String[] stringArray) {
        return new ClassNamePatternConverter(stringArray);
    }

    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        StackTraceElement stackTraceElement = logEvent.getSource();
        if (stackTraceElement == null) {
            stringBuilder.append(NA);
        } else {
            stringBuilder.append(this.abbreviate(stackTraceElement.getClassName()));
        }
    }
}

