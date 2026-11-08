/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.DatePatternConverter;
import org.apache.logging.log4j.core.pattern.PatternConverter;

@Plugin(name="FileDatePatternConverter", category="FileConverter")
@ConverterKeys(value={"d", "date"})
public class FileDatePatternConverter {
    private FileDatePatternConverter() {
    }

    public static PatternConverter newInstance(String[] stringArray) {
        if (stringArray == null || stringArray.length == 0) {
            return DatePatternConverter.newInstance(new String[]{"yyyy-MM-dd"});
        }
        return DatePatternConverter.newInstance(stringArray);
    }
}

