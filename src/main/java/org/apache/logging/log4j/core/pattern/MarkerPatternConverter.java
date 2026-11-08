/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

@Plugin(name="MarkerPatternConverter", category="Converter")
@ConverterKeys(value={"marker"})
public class MarkerPatternConverter
extends LogEventPatternConverter {
    private MarkerPatternConverter(String[] stringArray) {
        super("Marker", "marker");
    }

    public static MarkerPatternConverter newInstance(String[] stringArray) {
        return new MarkerPatternConverter(stringArray);
    }

    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        Marker marker = logEvent.getMarker();
        if (marker != null) {
            stringBuilder.append(marker.toString());
        }
    }
}

