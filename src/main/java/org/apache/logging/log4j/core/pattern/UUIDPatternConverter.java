/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import java.util.UUID;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.helpers.UUIDUtil;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

@Plugin(name="UUIDPatternConverter", category="Converter")
@ConverterKeys(value={"u", "uuid"})
public class UUIDPatternConverter
extends LogEventPatternConverter {
    private final boolean isRandom;

    private UUIDPatternConverter(boolean bl) {
        super("u", "uuid");
        this.isRandom = bl;
    }

    public static UUIDPatternConverter newInstance(String[] stringArray) {
        if (stringArray.length == 0) {
            return new UUIDPatternConverter(false);
        }
        if (stringArray.length > 1 || !stringArray[0].equalsIgnoreCase("RANDOM") && !stringArray[0].equalsIgnoreCase("Time")) {
            LOGGER.error("UUID Pattern Converter only accepts a single option with the value \"RANDOM\" or \"TIME\"");
        }
        return new UUIDPatternConverter(stringArray[0].equalsIgnoreCase("RANDOM"));
    }

    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        UUID uUID = this.isRandom ? UUID.randomUUID() : UUIDUtil.getTimeBasedUUID();
        stringBuilder.append(uUID.toString());
    }
}

