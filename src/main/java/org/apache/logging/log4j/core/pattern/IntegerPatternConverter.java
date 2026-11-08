/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import java.util.Date;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.AbstractPatternConverter;
import org.apache.logging.log4j.core.pattern.ArrayPatternConverter;
import org.apache.logging.log4j.core.pattern.ConverterKeys;

@Plugin(name="IntegerPatternConverter", category="FileConverter")
@ConverterKeys(value={"i", "index"})
public class IntegerPatternConverter
extends AbstractPatternConverter
implements ArrayPatternConverter {
    private static final IntegerPatternConverter INSTANCE = new IntegerPatternConverter();

    private IntegerPatternConverter() {
        super("Integer", "integer");
    }

    public static IntegerPatternConverter newInstance(String[] stringArray) {
        return INSTANCE;
    }

    @Override
    public void format(StringBuilder stringBuilder, Object ... objectArray) {
        for (Object object : objectArray) {
            if (!(object instanceof Integer)) continue;
            this.format(object, stringBuilder);
            break;
        }
    }

    @Override
    public void format(Object object, StringBuilder stringBuilder) {
        if (object instanceof Integer) {
            stringBuilder.append(object.toString());
        }
        if (object instanceof Date) {
            stringBuilder.append(Long.toString(((Date)object).getTime()));
        }
    }
}

