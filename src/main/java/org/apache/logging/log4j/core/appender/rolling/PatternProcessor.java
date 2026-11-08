/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.rolling;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rolling.RolloverFrequency;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.core.lookup.StrSubstitutor;
import org.apache.logging.log4j.core.pattern.ArrayPatternConverter;
import org.apache.logging.log4j.core.pattern.DatePatternConverter;
import org.apache.logging.log4j.core.pattern.FormattingInfo;
import org.apache.logging.log4j.core.pattern.PatternConverter;
import org.apache.logging.log4j.core.pattern.PatternParser;

public class PatternProcessor {
    private static final String KEY = "FileConverter";
    private static final char YEAR_CHAR = 'y';
    private static final char MONTH_CHAR = 'M';
    private static final char[] WEEK_CHARS = new char[]{'w', 'W'};
    private static final char[] DAY_CHARS = new char[]{'D', 'd', 'F', 'E'};
    private static final char[] HOUR_CHARS = new char[]{'H', 'K', 'h', 'k'};
    private static final char MINUTE_CHAR = 'm';
    private static final char SECOND_CHAR = 's';
    private static final char MILLIS_CHAR = 'S';
    private final ArrayPatternConverter[] patternConverters;
    private final FormattingInfo[] patternFields;
    private long prevFileTime = 0L;
    private long nextFileTime = 0L;
    private RolloverFrequency frequency = null;

    public PatternProcessor(String string) {
        PatternParser patternParser = this.createPatternParser();
        ArrayList<PatternConverter> arrayList = new ArrayList<PatternConverter>();
        ArrayList<FormattingInfo> arrayList2 = new ArrayList<FormattingInfo>();
        patternParser.parse(string, arrayList, arrayList2);
        FormattingInfo[] formattingInfoArray = new FormattingInfo[arrayList2.size()];
        this.patternFields = arrayList2.toArray(formattingInfoArray);
        ArrayPatternConverter[] arrayPatternConverterArray = new ArrayPatternConverter[arrayList.size()];
        for (ArrayPatternConverter arrayPatternConverter : this.patternConverters = arrayList.toArray(arrayPatternConverterArray)) {
            if (!(arrayPatternConverter instanceof DatePatternConverter)) continue;
            DatePatternConverter datePatternConverter = (DatePatternConverter)arrayPatternConverter;
            this.frequency = this.calculateFrequency(datePatternConverter.getPattern());
        }
    }

    public long getNextTime(long l, int n, boolean bl) {
        this.prevFileTime = this.nextFileTime;
        if (this.frequency == null) {
            throw new IllegalStateException("Pattern does not contain a date");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(calendar.get(1), 0, 1, 0, 0, 0);
        calendar2.set(14, 0);
        if (this.frequency == RolloverFrequency.ANNUALLY) {
            this.increment(calendar2, 1, n, bl);
            long l2 = calendar2.getTimeInMillis();
            calendar2.add(1, -1);
            this.nextFileTime = calendar2.getTimeInMillis();
            return l2;
        }
        if (this.frequency == RolloverFrequency.MONTHLY) {
            this.increment(calendar2, 2, n, bl);
            long l3 = calendar2.getTimeInMillis();
            calendar2.add(2, -1);
            this.nextFileTime = calendar2.getTimeInMillis();
            return l3;
        }
        if (this.frequency == RolloverFrequency.WEEKLY) {
            this.increment(calendar2, 3, n, bl);
            long l4 = calendar2.getTimeInMillis();
            calendar2.add(3, -1);
            this.nextFileTime = calendar2.getTimeInMillis();
            return l4;
        }
        calendar2.set(6, calendar.get(6));
        if (this.frequency == RolloverFrequency.DAILY) {
            this.increment(calendar2, 6, n, bl);
            long l5 = calendar2.getTimeInMillis();
            calendar2.add(6, -1);
            this.nextFileTime = calendar2.getTimeInMillis();
            return l5;
        }
        calendar2.set(10, calendar.get(10));
        if (this.frequency == RolloverFrequency.HOURLY) {
            this.increment(calendar2, 10, n, bl);
            long l6 = calendar2.getTimeInMillis();
            calendar2.add(10, -1);
            this.nextFileTime = calendar2.getTimeInMillis();
            return l6;
        }
        calendar2.set(12, calendar.get(12));
        if (this.frequency == RolloverFrequency.EVERY_MINUTE) {
            this.increment(calendar2, 12, n, bl);
            long l7 = calendar2.getTimeInMillis();
            calendar2.add(12, -1);
            this.nextFileTime = calendar2.getTimeInMillis();
            return l7;
        }
        calendar2.set(13, calendar.get(13));
        if (this.frequency == RolloverFrequency.EVERY_SECOND) {
            this.increment(calendar2, 13, n, bl);
            long l8 = calendar2.getTimeInMillis();
            calendar2.add(13, -1);
            this.nextFileTime = calendar2.getTimeInMillis();
            return l8;
        }
        this.increment(calendar2, 14, n, bl);
        long l9 = calendar2.getTimeInMillis();
        calendar2.add(14, -1);
        this.nextFileTime = calendar2.getTimeInMillis();
        return l9;
    }

    private void increment(Calendar calendar, int n, int n2, boolean bl) {
        int n3 = bl ? n2 - calendar.get(n) % n2 : n2;
        calendar.add(n, n3);
    }

    public final void formatFileName(StringBuilder stringBuilder, Object object) {
        long l = this.prevFileTime == 0L ? System.currentTimeMillis() : this.prevFileTime;
        this.formatFileName(stringBuilder, new Date(l), object);
    }

    public final void formatFileName(StrSubstitutor strSubstitutor, StringBuilder stringBuilder, Object object) {
        long l = this.prevFileTime == 0L ? System.currentTimeMillis() : this.prevFileTime;
        this.formatFileName(stringBuilder, new Date(l), object);
        Log4jLogEvent log4jLogEvent = new Log4jLogEvent(l);
        String string = strSubstitutor.replace((LogEvent)log4jLogEvent, stringBuilder);
        stringBuilder.setLength(0);
        stringBuilder.append(string);
    }

    protected final void formatFileName(StringBuilder stringBuilder, Object ... objectArray) {
        for (int i = 0; i < this.patternConverters.length; ++i) {
            int n = stringBuilder.length();
            this.patternConverters[i].format(stringBuilder, objectArray);
            if (this.patternFields[i] == null) continue;
            this.patternFields[i].format(n, stringBuilder);
        }
    }

    private RolloverFrequency calculateFrequency(String string) {
        if (this.patternContains(string, 'S')) {
            return RolloverFrequency.EVERY_MILLISECOND;
        }
        if (this.patternContains(string, 's')) {
            return RolloverFrequency.EVERY_SECOND;
        }
        if (this.patternContains(string, 'm')) {
            return RolloverFrequency.EVERY_MINUTE;
        }
        if (this.patternContains(string, HOUR_CHARS)) {
            return RolloverFrequency.HOURLY;
        }
        if (this.patternContains(string, DAY_CHARS)) {
            return RolloverFrequency.DAILY;
        }
        if (this.patternContains(string, WEEK_CHARS)) {
            return RolloverFrequency.WEEKLY;
        }
        if (this.patternContains(string, 'M')) {
            return RolloverFrequency.MONTHLY;
        }
        if (this.patternContains(string, 'y')) {
            return RolloverFrequency.ANNUALLY;
        }
        return null;
    }

    private PatternParser createPatternParser() {
        return new PatternParser(null, KEY, null);
    }

    private boolean patternContains(String string, char ... cArray) {
        for (char c : cArray) {
            if (!this.patternContains(string, c)) continue;
            return true;
        }
        return false;
    }

    private boolean patternContains(String string, char c) {
        return string.indexOf(c) >= 0;
    }
}

