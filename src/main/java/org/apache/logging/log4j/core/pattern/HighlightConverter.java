/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.pattern.AnsiEscape;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.core.pattern.PatternFormatter;
import org.apache.logging.log4j.core.pattern.PatternParser;

@Plugin(name="highlight", category="Converter")
@ConverterKeys(value={"highlight"})
public class HighlightConverter
extends LogEventPatternConverter {
    private static final EnumMap<Level, String> DEFAULT_STYLES = new EnumMap(Level.class);
    private static final EnumMap<Level, String> LOGBACK_STYLES = new EnumMap(Level.class);
    private static final String STYLE_KEY = "STYLE";
    private static final String STYLE_KEY_DEFAULT = "DEFAULT";
    private static final String STYLE_KEY_LOGBACK = "LOGBACK";
    private static final Map<String, EnumMap<Level, String>> STYLES = new HashMap<String, EnumMap<Level, String>>();
    private final EnumMap<Level, String> levelStyles;
    private final List<PatternFormatter> patternFormatters;

    private static EnumMap<Level, String> createLevelStyleMap(String[] stringArray) {
        if (stringArray.length < 2) {
            return DEFAULT_STYLES;
        }
        Map<String, String> map = AnsiEscape.createMap(stringArray[1], new String[]{STYLE_KEY});
        EnumMap<Level, String> enumMap = new EnumMap<Level, String>(DEFAULT_STYLES);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Object object;
            String string = entry.getKey().toUpperCase(Locale.ENGLISH);
            String string2 = entry.getValue();
            if (STYLE_KEY.equalsIgnoreCase(string)) {
                object = STYLES.get(string2.toUpperCase(Locale.ENGLISH));
                if (object == null) {
                    LOGGER.error("Unknown level style: " + string2 + ". Use one of " + Arrays.toString(STYLES.keySet().toArray()));
                    continue;
                }
                enumMap.putAll((Map<Level, String>)object);
                continue;
            }
            object = Level.valueOf(string);
            if (object == null) {
                LOGGER.error("Unknown level name: " + string + ". Use one of " + Arrays.toString(DEFAULT_STYLES.keySet().toArray()));
                continue;
            }
            enumMap.put((Level)((Object)object), string2);
        }
        return enumMap;
    }

    public static HighlightConverter newInstance(Configuration configuration, String[] stringArray) {
        if (stringArray.length < 1) {
            LOGGER.error("Incorrect number of options on style. Expected at least 1, received " + stringArray.length);
            return null;
        }
        if (stringArray[0] == null) {
            LOGGER.error("No pattern supplied on style");
            return null;
        }
        PatternParser patternParser = PatternLayout.createPatternParser(configuration);
        List<PatternFormatter> list = patternParser.parse(stringArray[0]);
        return new HighlightConverter(list, HighlightConverter.createLevelStyleMap(stringArray));
    }

    private HighlightConverter(List<PatternFormatter> list, EnumMap<Level, String> enumMap) {
        super("style", "style");
        this.patternFormatters = list;
        this.levelStyles = enumMap;
    }

    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder();
        for (PatternFormatter patternFormatter : this.patternFormatters) {
            patternFormatter.format(logEvent, stringBuilder2);
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder.append(this.levelStyles.get((Object)logEvent.getLevel())).append(stringBuilder2.toString()).append(AnsiEscape.getDefaultStyle());
        }
    }

    @Override
    public boolean handlesThrowable() {
        for (PatternFormatter patternFormatter : this.patternFormatters) {
            if (!patternFormatter.handlesThrowable()) continue;
            return true;
        }
        return false;
    }

    static {
        DEFAULT_STYLES.put(Level.FATAL, AnsiEscape.createSequence("BRIGHT", "RED"));
        DEFAULT_STYLES.put(Level.ERROR, AnsiEscape.createSequence("BRIGHT", "RED"));
        DEFAULT_STYLES.put(Level.WARN, AnsiEscape.createSequence("YELLOW"));
        DEFAULT_STYLES.put(Level.INFO, AnsiEscape.createSequence("GREEN"));
        DEFAULT_STYLES.put(Level.DEBUG, AnsiEscape.createSequence("CYAN"));
        DEFAULT_STYLES.put(Level.TRACE, AnsiEscape.createSequence("BLACK"));
        LOGBACK_STYLES.put(Level.FATAL, AnsiEscape.createSequence("BLINK", "BRIGHT", "RED"));
        LOGBACK_STYLES.put(Level.ERROR, AnsiEscape.createSequence("BRIGHT", "RED"));
        LOGBACK_STYLES.put(Level.WARN, AnsiEscape.createSequence("RED"));
        LOGBACK_STYLES.put(Level.INFO, AnsiEscape.createSequence("BLUE"));
        LOGBACK_STYLES.put(Level.DEBUG, AnsiEscape.createSequence(null));
        LOGBACK_STYLES.put(Level.TRACE, AnsiEscape.createSequence(null));
        STYLES.put(STYLE_KEY_DEFAULT, DEFAULT_STYLES);
        STYLES.put(STYLE_KEY_LOGBACK, LOGBACK_STYLES);
    }
}

