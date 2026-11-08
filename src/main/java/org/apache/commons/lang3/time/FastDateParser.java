/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.DateParser;

public class FastDateParser
implements DateParser,
Serializable {
    private static final long serialVersionUID = 2L;
    static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
    private final String pattern;
    private final TimeZone timeZone;
    private final Locale locale;
    private final int century;
    private final int startYear;
    private transient Pattern parsePattern;
    private transient Strategy[] strategies;
    private transient String currentFormatField;
    private transient Strategy nextStrategy;
    private static final Pattern formatPattern = Pattern.compile("D+|E+|F+|G+|H+|K+|M+|S+|W+|Z+|a+|d+|h+|k+|m+|s+|w+|y+|z+|''|'[^']++(''[^']*+)*+'|[^'A-Za-z]++");
    private static final ConcurrentMap<Locale, Strategy>[] caches = new ConcurrentMap[17];
    private static final Strategy ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1){

        @Override
        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String string) {
            int n = Integer.parseInt(string);
            if (n < 100) {
                n = fastDateParser.adjustYear(n);
            }
            calendar.set(1, n);
        }
    };
    private static final Strategy NUMBER_MONTH_STRATEGY = new NumberStrategy(2){

        @Override
        int modify(int n) {
            return n - 1;
        }
    };
    private static final Strategy LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
    private static final Strategy WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
    private static final Strategy WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
    private static final Strategy DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
    private static final Strategy DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
    private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
    private static final Strategy HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
    private static final Strategy MODULO_HOUR_OF_DAY_STRATEGY = new NumberStrategy(11){

        @Override
        int modify(int n) {
            return n % 24;
        }
    };
    private static final Strategy MODULO_HOUR_STRATEGY = new NumberStrategy(10){

        @Override
        int modify(int n) {
            return n % 12;
        }
    };
    private static final Strategy HOUR_STRATEGY = new NumberStrategy(10);
    private static final Strategy MINUTE_STRATEGY = new NumberStrategy(12);
    private static final Strategy SECOND_STRATEGY = new NumberStrategy(13);
    private static final Strategy MILLISECOND_STRATEGY = new NumberStrategy(14);

    protected FastDateParser(String string, TimeZone timeZone, Locale locale) {
        this(string, timeZone, locale, null);
    }

    protected FastDateParser(String string, TimeZone timeZone, Locale locale, Date date) {
        int n;
        this.pattern = string;
        this.timeZone = timeZone;
        this.locale = locale;
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        if (date != null) {
            calendar.setTime(date);
            n = calendar.get(1);
        } else if (locale.equals(JAPANESE_IMPERIAL)) {
            n = 0;
        } else {
            calendar.setTime(new Date());
            n = calendar.get(1) - 80;
        }
        this.century = n / 100 * 100;
        this.startYear = n - this.century;
        this.init(calendar);
    }

    private void init(Calendar calendar) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Strategy> arrayList = new ArrayList<Strategy>();
        Matcher matcher = formatPattern.matcher(this.pattern);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("Illegal pattern character '" + this.pattern.charAt(matcher.regionStart()) + "'");
        }
        this.currentFormatField = matcher.group();
        Strategy strategy = this.getStrategy(this.currentFormatField, calendar);
        while (true) {
            matcher.region(matcher.end(), matcher.regionEnd());
            if (!matcher.lookingAt()) break;
            String string = matcher.group();
            this.nextStrategy = this.getStrategy(string, calendar);
            if (strategy.addRegex(this, stringBuilder)) {
                arrayList.add(strategy);
            }
            this.currentFormatField = string;
            strategy = this.nextStrategy;
        }
        this.nextStrategy = null;
        if (matcher.regionStart() != matcher.regionEnd()) {
            throw new IllegalArgumentException("Failed to parse \"" + this.pattern + "\" ; gave up at index " + matcher.regionStart());
        }
        if (strategy.addRegex(this, stringBuilder)) {
            arrayList.add(strategy);
        }
        this.currentFormatField = null;
        this.strategies = arrayList.toArray(new Strategy[arrayList.size()]);
        this.parsePattern = Pattern.compile(stringBuilder.toString());
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }

    @Override
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    @Override
    public Locale getLocale() {
        return this.locale;
    }

    Pattern getParsePattern() {
        return this.parsePattern;
    }

    public boolean equals(Object object) {
        if (!(object instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser)object;
        return this.pattern.equals(fastDateParser.pattern) && this.timeZone.equals(fastDateParser.timeZone) && this.locale.equals(fastDateParser.locale);
    }

    public int hashCode() {
        return this.pattern.hashCode() + 13 * (this.timeZone.hashCode() + 13 * this.locale.hashCode());
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.init(calendar);
    }

    @Override
    public Object parseObject(String string) throws ParseException {
        return this.parse(string);
    }

    @Override
    public Date parse(String string) throws ParseException {
        Date date = this.parse(string, new ParsePosition(0));
        if (date == null) {
            if (this.locale.equals(JAPANESE_IMPERIAL)) {
                throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\n" + "Unparseable date: \"" + string + "\" does not match " + this.parsePattern.pattern(), 0);
            }
            throw new ParseException("Unparseable date: \"" + string + "\" does not match " + this.parsePattern.pattern(), 0);
        }
        return date;
    }

    @Override
    public Object parseObject(String string, ParsePosition parsePosition) {
        return this.parse(string, parsePosition);
    }

    @Override
    public Date parse(String string, ParsePosition parsePosition) {
        int n = parsePosition.getIndex();
        Matcher matcher = this.parsePattern.matcher(string.substring(n));
        if (!matcher.lookingAt()) {
            return null;
        }
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        calendar.clear();
        int n2 = 0;
        while (n2 < this.strategies.length) {
            Strategy strategy = this.strategies[n2++];
            strategy.setCalendar(this, calendar, matcher.group(n2));
        }
        parsePosition.setIndex(n + matcher.end());
        return calendar.getTime();
    }

    private static StringBuilder escapeRegex(StringBuilder stringBuilder, String string, boolean bl) {
        stringBuilder.append("\\Q");
        for (int i = 0; i < string.length(); ++i) {
            int n = string.charAt(i);
            switch (n) {
                case 39: {
                    if (!bl) break;
                    if (++i == string.length()) {
                        return stringBuilder;
                    }
                    n = string.charAt(i);
                    break;
                }
                case 92: {
                    if (++i == string.length()) break;
                    stringBuilder.append((char)n);
                    n = string.charAt(i);
                    if (n != 69) break;
                    stringBuilder.append("E\\\\E\\");
                    n = 81;
                    break;
                }
            }
            stringBuilder.append((char)n);
        }
        stringBuilder.append("\\E");
        return stringBuilder;
    }

    private static Map<String, Integer> getDisplayNames(int n, Calendar calendar, Locale locale) {
        return calendar.getDisplayNames(n, 0, locale);
    }

    private int adjustYear(int n) {
        int n2 = this.century + n;
        return n >= this.startYear ? n2 : n2 + 100;
    }

    boolean isNextNumber() {
        return this.nextStrategy != null && this.nextStrategy.isNumber();
    }

    int getFieldWidth() {
        return this.currentFormatField.length();
    }

    private Strategy getStrategy(String string, Calendar calendar) {
        switch (string.charAt(0)) {
            case '\'': {
                if (string.length() > 2) {
                    return new CopyQuotedStrategy(string.substring(1, string.length() - 1));
                }
            }
            default: {
                return new CopyQuotedStrategy(string);
            }
            case 'D': {
                return DAY_OF_YEAR_STRATEGY;
            }
            case 'E': {
                return this.getLocaleSpecificStrategy(7, calendar);
            }
            case 'F': {
                return DAY_OF_WEEK_IN_MONTH_STRATEGY;
            }
            case 'G': {
                return this.getLocaleSpecificStrategy(0, calendar);
            }
            case 'H': {
                return MODULO_HOUR_OF_DAY_STRATEGY;
            }
            case 'K': {
                return HOUR_STRATEGY;
            }
            case 'M': {
                return string.length() >= 3 ? this.getLocaleSpecificStrategy(2, calendar) : NUMBER_MONTH_STRATEGY;
            }
            case 'S': {
                return MILLISECOND_STRATEGY;
            }
            case 'W': {
                return WEEK_OF_MONTH_STRATEGY;
            }
            case 'a': {
                return this.getLocaleSpecificStrategy(9, calendar);
            }
            case 'd': {
                return DAY_OF_MONTH_STRATEGY;
            }
            case 'h': {
                return MODULO_HOUR_STRATEGY;
            }
            case 'k': {
                return HOUR_OF_DAY_STRATEGY;
            }
            case 'm': {
                return MINUTE_STRATEGY;
            }
            case 's': {
                return SECOND_STRATEGY;
            }
            case 'w': {
                return WEEK_OF_YEAR_STRATEGY;
            }
            case 'y': {
                return string.length() > 2 ? LITERAL_YEAR_STRATEGY : ABBREVIATED_YEAR_STRATEGY;
            }
            case 'Z': 
            case 'z': 
        }
        return this.getLocaleSpecificStrategy(15, calendar);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static ConcurrentMap<Locale, Strategy> getCache(int n) {
        ConcurrentMap<Locale, Strategy>[] concurrentMapArray = caches;
        synchronized (caches) {
            if (caches[n] == null) {
                FastDateParser.caches[n] = new ConcurrentHashMap<Locale, Strategy>(3);
            }
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return caches[n];
        }
    }

    private Strategy getLocaleSpecificStrategy(int n, Calendar calendar) {
        Strategy strategy;
        ConcurrentMap<Locale, Strategy> concurrentMap = FastDateParser.getCache(n);
        Strategy strategy2 = (Strategy)concurrentMap.get(this.locale);
        if (strategy2 == null && (strategy = concurrentMap.putIfAbsent(this.locale, strategy2 = n == 15 ? new TimeZoneStrategy(this.locale) : new TextStrategy(n, calendar, this.locale))) != null) {
            return strategy;
        }
        return strategy2;
    }

    private static class TimeZoneStrategy
    extends Strategy {
        private final String validTimeZoneChars;
        private final SortedMap<String, TimeZone> tzNames = new TreeMap<String, TimeZone>(String.CASE_INSENSITIVE_ORDER);
        private static final int ID = 0;
        private static final int LONG_STD = 1;
        private static final int SHORT_STD = 2;
        private static final int LONG_DST = 3;
        private static final int SHORT_DST = 4;

        TimeZoneStrategy(Locale locale) {
            String[][] stringArray = DateFormatSymbols.getInstance(locale).getZoneStrings();
            for (String[] stringArray2 : stringArray) {
                if (stringArray2[0].startsWith("GMT")) continue;
                TimeZone timeZone = TimeZone.getTimeZone(stringArray2[0]);
                if (!this.tzNames.containsKey(stringArray2[1])) {
                    this.tzNames.put(stringArray2[1], timeZone);
                }
                if (!this.tzNames.containsKey(stringArray2[2])) {
                    this.tzNames.put(stringArray2[2], timeZone);
                }
                if (!timeZone.useDaylightTime()) continue;
                if (!this.tzNames.containsKey(stringArray2[3])) {
                    this.tzNames.put(stringArray2[3], timeZone);
                }
                if (this.tzNames.containsKey(stringArray2[4])) continue;
                this.tzNames.put(stringArray2[4], timeZone);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(GMT[+\\-]\\d{0,1}\\d{2}|[+\\-]\\d{2}:?\\d{2}|");
            for (String string : this.tzNames.keySet()) {
                FastDateParser.escapeRegex(stringBuilder, string, false).append('|');
            }
            stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
            this.validTimeZoneChars = stringBuilder.toString();
        }

        @Override
        boolean addRegex(FastDateParser fastDateParser, StringBuilder stringBuilder) {
            stringBuilder.append(this.validTimeZoneChars);
            return true;
        }

        @Override
        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String string) {
            TimeZone timeZone;
            if (string.charAt(0) == '+' || string.charAt(0) == '-') {
                timeZone = TimeZone.getTimeZone("GMT" + string);
            } else if (string.startsWith("GMT")) {
                timeZone = TimeZone.getTimeZone(string);
            } else {
                timeZone = (TimeZone)this.tzNames.get(string);
                if (timeZone == null) {
                    throw new IllegalArgumentException(string + " is not a supported timezone name");
                }
            }
            calendar.setTimeZone(timeZone);
        }
    }

    private static class NumberStrategy
    extends Strategy {
        private final int field;

        NumberStrategy(int n) {
            this.field = n;
        }

        @Override
        boolean isNumber() {
            return true;
        }

        @Override
        boolean addRegex(FastDateParser fastDateParser, StringBuilder stringBuilder) {
            if (fastDateParser.isNextNumber()) {
                stringBuilder.append("(\\p{Nd}{").append(fastDateParser.getFieldWidth()).append("}+)");
            } else {
                stringBuilder.append("(\\p{Nd}++)");
            }
            return true;
        }

        @Override
        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String string) {
            calendar.set(this.field, this.modify(Integer.parseInt(string)));
        }

        int modify(int n) {
            return n;
        }
    }

    private static class TextStrategy
    extends Strategy {
        private final int field;
        private final Map<String, Integer> keyValues;

        TextStrategy(int n, Calendar calendar, Locale locale) {
            this.field = n;
            this.keyValues = FastDateParser.getDisplayNames(n, calendar, locale);
        }

        @Override
        boolean addRegex(FastDateParser fastDateParser, StringBuilder stringBuilder) {
            stringBuilder.append('(');
            for (String string : this.keyValues.keySet()) {
                FastDateParser.escapeRegex(stringBuilder, string, false).append('|');
            }
            stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
            return true;
        }

        @Override
        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String string) {
            Integer n = this.keyValues.get(string);
            if (n == null) {
                StringBuilder stringBuilder = new StringBuilder(string);
                stringBuilder.append(" not in (");
                for (String string2 : this.keyValues.keySet()) {
                    stringBuilder.append(string2).append(' ');
                }
                stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            calendar.set(this.field, n);
        }
    }

    private static class CopyQuotedStrategy
    extends Strategy {
        private final String formatField;

        CopyQuotedStrategy(String string) {
            this.formatField = string;
        }

        @Override
        boolean isNumber() {
            char c = this.formatField.charAt(0);
            if (c == '\'') {
                c = this.formatField.charAt(1);
            }
            return Character.isDigit(c);
        }

        @Override
        boolean addRegex(FastDateParser fastDateParser, StringBuilder stringBuilder) {
            FastDateParser.escapeRegex(stringBuilder, this.formatField, true);
            return false;
        }
    }

    private static abstract class Strategy {
        private Strategy() {
        }

        boolean isNumber() {
            return false;
        }

        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String string) {
        }

        abstract boolean addRegex(FastDateParser var1, StringBuilder var2);
    }
}

