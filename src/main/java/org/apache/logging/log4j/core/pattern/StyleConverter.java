/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import java.util.List;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.pattern.AnsiEscape;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.core.pattern.PatternFormatter;
import org.apache.logging.log4j.core.pattern.PatternParser;

@Plugin(name="style", category="Converter")
@ConverterKeys(value={"style"})
public class StyleConverter
extends LogEventPatternConverter {
    private final List<PatternFormatter> patternFormatters;
    private final String style;

    private StyleConverter(List<PatternFormatter> list, String string) {
        super("style", "style");
        this.patternFormatters = list;
        this.style = string;
    }

    public static StyleConverter newInstance(Configuration configuration, String[] stringArray) {
        if (stringArray.length < 1) {
            LOGGER.error("Incorrect number of options on style. Expected at least 1, received " + stringArray.length);
            return null;
        }
        if (stringArray[0] == null) {
            LOGGER.error("No pattern supplied on style");
            return null;
        }
        if (stringArray[1] == null) {
            LOGGER.error("No style attributes provided");
            return null;
        }
        PatternParser patternParser = PatternLayout.createPatternParser(configuration);
        List<PatternFormatter> list = patternParser.parse(stringArray[0]);
        String string = AnsiEscape.createSequence(stringArray[1].split("\\s*,\\s*"));
        return new StyleConverter(list, string);
    }

    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder();
        for (PatternFormatter patternFormatter : this.patternFormatters) {
            patternFormatter.format(logEvent, stringBuilder2);
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder.append(this.style).append(stringBuilder2.toString()).append(AnsiEscape.getDefaultStyle());
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("[style=");
        stringBuilder.append(this.style);
        stringBuilder.append(", patternFormatters=");
        stringBuilder.append(this.patternFormatters);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

