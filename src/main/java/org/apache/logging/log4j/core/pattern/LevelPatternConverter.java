/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import java.util.EnumMap;
import java.util.Locale;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

@Plugin(name="LevelPatternConverter", category="Converter")
@ConverterKeys(value={"p", "level"})
public class LevelPatternConverter
extends LogEventPatternConverter {
    private static final String OPTION_LENGTH = "length";
    private static final String OPTION_LOWER = "lowerCase";
    private static final LevelPatternConverter INSTANCE = new LevelPatternConverter(null);
    private final EnumMap<Level, String> levelMap;

    private LevelPatternConverter(EnumMap<Level, String> enumMap) {
        super("Level", "level");
        this.levelMap = enumMap;
    }

    public static LevelPatternConverter newInstance(String[] stringArray) {
        Object object;
        String[] stringArray2;
        if (stringArray == null || stringArray.length == 0) {
            return INSTANCE;
        }
        EnumMap<Level, String> enumMap = new EnumMap<Level, String>(Level.class);
        int n = Integer.MAX_VALUE;
        boolean bl = false;
        for (String string : stringArray2 = stringArray[0].split(",")) {
            object = string.split("=");
            if (object == null || ((String[])object).length != 2) {
                LOGGER.error("Invalid option {}", string);
                continue;
            }
            String string2 = object[0].trim();
            String string3 = object[1].trim();
            if (OPTION_LENGTH.equalsIgnoreCase(string2)) {
                n = Integer.parseInt(string3);
                continue;
            }
            if (OPTION_LOWER.equalsIgnoreCase(string2)) {
                bl = Boolean.parseBoolean(string3);
                continue;
            }
            Level level = Level.toLevel(string2, null);
            if (level == null) {
                LOGGER.error("Invalid Level {}", string2);
                continue;
            }
            enumMap.put(level, string3);
        }
        if (enumMap.size() == 0 && n == Integer.MAX_VALUE && !bl) {
            return INSTANCE;
        }
        for (Level level : Level.values()) {
            if (enumMap.containsKey((Object)level)) continue;
            object = LevelPatternConverter.left(level, n);
            enumMap.put(level, (String)(bl ? ((String)object).toLowerCase(Locale.US) : object));
        }
        return new LevelPatternConverter(enumMap);
    }

    private static String left(Level level, int n) {
        String string = level.toString();
        if (n >= string.length()) {
            return string;
        }
        return string.substring(0, n);
    }

    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        stringBuilder.append(this.levelMap == null ? logEvent.getLevel().toString() : this.levelMap.get((Object)logEvent.getLevel()));
    }

    @Override
    public String getStyleClass(Object object) {
        if (object instanceof LogEvent) {
            Level level = ((LogEvent)object).getLevel();
            switch (level) {
                case TRACE: {
                    return "level trace";
                }
                case DEBUG: {
                    return "level debug";
                }
                case INFO: {
                    return "level info";
                }
                case WARN: {
                    return "level warn";
                }
                case ERROR: {
                    return "level error";
                }
                case FATAL: {
                    return "level fatal";
                }
            }
            return "level " + ((LogEvent)object).getLevel().toString();
        }
        return "level";
    }
}

