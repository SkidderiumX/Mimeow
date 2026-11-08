/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import java.lang.management.ManagementFactory;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

@Plugin(name="RelativeTimePatternConverter", category="Converter")
@ConverterKeys(value={"r", "relative"})
public class RelativeTimePatternConverter
extends LogEventPatternConverter {
    private long lastTimestamp = Long.MIN_VALUE;
    private final long startTime = ManagementFactory.getRuntimeMXBean().getStartTime();
    private String relative;

    public RelativeTimePatternConverter() {
        super("Time", "time");
    }

    public static RelativeTimePatternConverter newInstance(String[] stringArray) {
        return new RelativeTimePatternConverter();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        long l = logEvent.getMillis();
        RelativeTimePatternConverter relativeTimePatternConverter = this;
        synchronized (relativeTimePatternConverter) {
            if (l != this.lastTimestamp) {
                this.lastTimestamp = l;
                this.relative = Long.toString(l - this.startTime);
            }
        }
        stringBuilder.append(this.relative);
    }
}

