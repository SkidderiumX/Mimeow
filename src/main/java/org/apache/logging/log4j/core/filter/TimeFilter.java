/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;

@Plugin(name="TimeFilter", category="Core", elementType="filter", printObject=true)
public class TimeFilter
extends AbstractFilter {
    private static final long HOUR_MS = 3600000L;
    private static final long MINUTE_MS = 60000L;
    private static final long SECOND_MS = 1000L;
    private final long start;
    private final long end;
    private final TimeZone timezone;

    private TimeFilter(long l, long l2, TimeZone timeZone, Filter.Result result, Filter.Result result2) {
        super(result, result2);
        this.start = l;
        this.end = l2;
        this.timezone = timeZone;
    }

    @Override
    public Filter.Result filter(LogEvent logEvent) {
        Calendar calendar = Calendar.getInstance(this.timezone);
        calendar.setTimeInMillis(logEvent.getMillis());
        long l = (long)calendar.get(11) * 3600000L + (long)calendar.get(12) * 60000L + (long)calendar.get(13) * 1000L + (long)calendar.get(14);
        return l >= this.start && l < this.end ? this.onMatch : this.onMismatch;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("start=").append(this.start);
        stringBuilder.append(", end=").append(this.end);
        stringBuilder.append(", timezone=").append(this.timezone.toString());
        return stringBuilder.toString();
    }

    @PluginFactory
    public static TimeFilter createFilter(@PluginAttribute(value="start") String string, @PluginAttribute(value="end") String string2, @PluginAttribute(value="timezone") String string3, @PluginAttribute(value="onMatch") String string4, @PluginAttribute(value="onMismatch") String string5) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        long l = 0L;
        if (string != null) {
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                l = simpleDateFormat.parse(string).getTime();
            }
            catch (ParseException parseException) {
                LOGGER.warn("Error parsing start value " + string, (Throwable)parseException);
            }
        }
        long l2 = Long.MAX_VALUE;
        if (string2 != null) {
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                l2 = simpleDateFormat.parse(string2).getTime();
            }
            catch (ParseException parseException) {
                LOGGER.warn("Error parsing start value " + string2, (Throwable)parseException);
            }
        }
        TimeZone timeZone = string3 == null ? TimeZone.getDefault() : TimeZone.getTimeZone(string3);
        Filter.Result result = Filter.Result.toResult(string4, Filter.Result.NEUTRAL);
        Filter.Result result2 = Filter.Result.toResult(string5, Filter.Result.DENY);
        return new TimeFilter(l, l2, timeZone, result, result2);
    }
}

