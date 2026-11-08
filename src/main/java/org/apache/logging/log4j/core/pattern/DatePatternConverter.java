/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ArrayPatternConverter;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

@Plugin(name="DatePatternConverter", category="Converter")
@ConverterKeys(value={"d", "date"})
public class DatePatternConverter
extends LogEventPatternConverter
implements ArrayPatternConverter {
    private static final String ABSOLUTE_FORMAT = "ABSOLUTE";
    private static final String COMPACT_FORMAT = "COMPACT";
    private static final String ABSOLUTE_TIME_PATTERN = "HH:mm:ss,SSS";
    private static final String DATE_AND_TIME_FORMAT = "DATE";
    private static final String DATE_AND_TIME_PATTERN = "dd MMM yyyy HH:mm:ss,SSS";
    private static final String ISO8601_FORMAT = "ISO8601";
    private static final String ISO8601_BASIC_FORMAT = "ISO8601_BASIC";
    private static final String ISO8601_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";
    private static final String ISO8601_BASIC_PATTERN = "yyyyMMdd HHmmss,SSS";
    private static final String COMPACT_PATTERN = "yyyyMMddHHmmssSSS";
    private String cachedDate;
    private long lastTimestamp;
    private final SimpleDateFormat simpleFormat;

    private DatePatternConverter(String[] stringArray) {
        super("Date", "date");
        SimpleDateFormat simpleDateFormat;
        String string = stringArray == null || stringArray.length == 0 ? null : stringArray[0];
        String string2 = string == null || string.equalsIgnoreCase(ISO8601_FORMAT) ? ISO8601_PATTERN : (string.equalsIgnoreCase(ISO8601_BASIC_FORMAT) ? ISO8601_BASIC_PATTERN : (string.equalsIgnoreCase(ABSOLUTE_FORMAT) ? ABSOLUTE_TIME_PATTERN : (string.equalsIgnoreCase(DATE_AND_TIME_FORMAT) ? DATE_AND_TIME_PATTERN : (string.equalsIgnoreCase(COMPACT_FORMAT) ? COMPACT_PATTERN : string))));
        try {
            simpleDateFormat = new SimpleDateFormat(string2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            LOGGER.warn("Could not instantiate SimpleDateFormat with pattern " + string, (Throwable)illegalArgumentException);
            simpleDateFormat = new SimpleDateFormat(ISO8601_PATTERN);
        }
        if (stringArray != null && stringArray.length > 1) {
            TimeZone timeZone = TimeZone.getTimeZone(stringArray[1]);
            simpleDateFormat.setTimeZone(timeZone);
        }
        this.simpleFormat = simpleDateFormat;
    }

    public static DatePatternConverter newInstance(String[] stringArray) {
        return new DatePatternConverter(stringArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        long l = logEvent.getMillis();
        DatePatternConverter datePatternConverter = this;
        synchronized (datePatternConverter) {
            if (l != this.lastTimestamp) {
                this.lastTimestamp = l;
                this.cachedDate = this.simpleFormat.format(l);
            }
        }
        stringBuilder.append(this.cachedDate);
    }

    @Override
    public void format(StringBuilder stringBuilder, Object ... objectArray) {
        for (Object object : objectArray) {
            if (!(object instanceof Date)) continue;
            this.format(object, stringBuilder);
            break;
        }
    }

    @Override
    public void format(Object object, StringBuilder stringBuilder) {
        if (object instanceof Date) {
            this.format((Date)object, stringBuilder);
        }
        super.format(object, stringBuilder);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void format(Date date, StringBuilder stringBuilder) {
        DatePatternConverter datePatternConverter = this;
        synchronized (datePatternConverter) {
            stringBuilder.append(this.simpleFormat.format(date.getTime()));
        }
    }

    public String getPattern() {
        return this.simpleFormat.toPattern();
    }
}

