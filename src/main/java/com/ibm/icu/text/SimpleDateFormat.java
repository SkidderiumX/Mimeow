/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.CalendarData;
import com.ibm.icu.impl.DateNumberFormat;
import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.DateFormatSymbols;
import com.ibm.icu.text.DecimalFormat;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.DisplayContext;
import com.ibm.icu.text.MessageFormat;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.NumberingSystem;
import com.ibm.icu.text.TimeZoneFormat;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.BasicTimeZone;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.HebrewCalendar;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.TimeZoneTransition;
import com.ibm.icu.util.ULocale;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class SimpleDateFormat
extends DateFormat {
    private static final long serialVersionUID = 4774881970558875024L;
    static final int currentSerialVersion = 2;
    static boolean DelayedHebrewMonthCheck = false;
    private static final int[] CALENDAR_FIELD_TO_LEVEL = new int[]{0, 10, 20, 20, 30, 30, 20, 30, 30, 40, 50, 50, 60, 70, 80, 0, 0, 10, 30, 10, 0, 40};
    private static final int[] PATTERN_CHAR_TO_LEVEL = new int[]{-1, 40, -1, -1, 20, 30, 30, 0, 50, -1, -1, 50, 20, 20, -1, 0, -1, 20, -1, 80, -1, 10, 0, 30, 0, 10, 0, -1, -1, -1, -1, -1, -1, 40, -1, 30, 30, 30, -1, 0, 50, -1, -1, 50, -1, 60, -1, -1, -1, 20, -1, 70, -1, 10, 0, 20, 0, 10, 0, -1, -1, -1, -1, -1};
    private static final int HEBREW_CAL_CUR_MILLENIUM_START_YEAR = 5000;
    private static final int HEBREW_CAL_CUR_MILLENIUM_END_YEAR = 6000;
    private int serialVersionOnStream = 2;
    private String pattern;
    private String override;
    private HashMap<String, NumberFormat> numberFormatters;
    private HashMap<Character, String> overrideMap;
    private DateFormatSymbols formatData;
    private transient ULocale locale;
    private Date defaultCenturyStart;
    private transient int defaultCenturyStartYear;
    private transient long defaultCenturyBase;
    private transient TimeZoneFormat.TimeType tztype = TimeZoneFormat.TimeType.UNKNOWN;
    private static final int millisPerHour = 3600000;
    private static final int ISOSpecialEra = -32000;
    private static final String SUPPRESS_NEGATIVE_PREFIX = "\uab00";
    private transient boolean useFastFormat;
    private volatile TimeZoneFormat tzFormat;
    private transient DisplayContext capitalizationSetting;
    private static ULocale cachedDefaultLocale = null;
    private static String cachedDefaultPattern = null;
    private static final String FALLBACKPATTERN = "yy/MM/dd HH:mm";
    private static final int PATTERN_CHAR_BASE = 64;
    private static final int[] PATTERN_CHAR_TO_INDEX = new int[]{-1, 22, -1, -1, 10, 9, 11, 0, 5, -1, -1, 16, 26, 2, -1, 31, -1, 27, -1, 8, -1, 30, 29, 13, 32, 18, 23, -1, -1, -1, -1, -1, -1, 14, -1, 25, 3, 19, -1, 21, 15, -1, -1, 4, -1, 6, -1, -1, -1, 28, -1, 7, -1, 20, 24, 12, 33, 1, 17, -1, -1, -1, -1, -1};
    private static final int[] PATTERN_INDEX_TO_CALENDAR_FIELD = new int[]{0, 1, 2, 5, 11, 11, 12, 13, 14, 7, 6, 8, 3, 4, 9, 10, 10, 15, 17, 18, 19, 20, 21, 15, 15, 18, 2, 2, 2, 15, 1, 15, 15, 15};
    private static final int[] PATTERN_INDEX_TO_DATE_FORMAT_FIELD = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33};
    private static final DateFormat.Field[] PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE = new DateFormat.Field[]{DateFormat.Field.ERA, DateFormat.Field.YEAR, DateFormat.Field.MONTH, DateFormat.Field.DAY_OF_MONTH, DateFormat.Field.HOUR_OF_DAY1, DateFormat.Field.HOUR_OF_DAY0, DateFormat.Field.MINUTE, DateFormat.Field.SECOND, DateFormat.Field.MILLISECOND, DateFormat.Field.DAY_OF_WEEK, DateFormat.Field.DAY_OF_YEAR, DateFormat.Field.DAY_OF_WEEK_IN_MONTH, DateFormat.Field.WEEK_OF_YEAR, DateFormat.Field.WEEK_OF_MONTH, DateFormat.Field.AM_PM, DateFormat.Field.HOUR1, DateFormat.Field.HOUR0, DateFormat.Field.TIME_ZONE, DateFormat.Field.YEAR_WOY, DateFormat.Field.DOW_LOCAL, DateFormat.Field.EXTENDED_YEAR, DateFormat.Field.JULIAN_DAY, DateFormat.Field.MILLISECONDS_IN_DAY, DateFormat.Field.TIME_ZONE, DateFormat.Field.TIME_ZONE, DateFormat.Field.DAY_OF_WEEK, DateFormat.Field.MONTH, DateFormat.Field.QUARTER, DateFormat.Field.QUARTER, DateFormat.Field.TIME_ZONE, DateFormat.Field.YEAR, DateFormat.Field.TIME_ZONE, DateFormat.Field.TIME_ZONE, DateFormat.Field.TIME_ZONE};
    private static ICUCache<String, Object[]> PARSED_PATTERN_CACHE = new SimpleCache<String, Object[]>();
    private transient Object[] patternItems;
    private transient boolean useLocalZeroPaddingNumberFormat;
    private transient char[] decDigits;
    private transient char[] decimalBuf;
    private static final String NUMERIC_FORMAT_CHARS = "MYyudehHmsSDFwWkK";
    static final UnicodeSet DATE_PATTERN_TYPE = new UnicodeSet("[GyYuUQqMLlwWd]").freeze();

    public SimpleDateFormat() {
        this(SimpleDateFormat.getDefaultPattern(), null, null, null, null, true, null);
    }

    public SimpleDateFormat(String string) {
        this(string, null, null, null, null, true, null);
    }

    public SimpleDateFormat(String string, Locale locale) {
        this(string, null, null, null, ULocale.forLocale(locale), true, null);
    }

    public SimpleDateFormat(String string, ULocale uLocale) {
        this(string, null, null, null, uLocale, true, null);
    }

    public SimpleDateFormat(String string, String string2, ULocale uLocale) {
        this(string, null, null, null, uLocale, false, string2);
    }

    public SimpleDateFormat(String string, DateFormatSymbols dateFormatSymbols) {
        this(string, (DateFormatSymbols)dateFormatSymbols.clone(), null, null, null, true, null);
    }

    public SimpleDateFormat(String string, DateFormatSymbols dateFormatSymbols, ULocale uLocale) {
        this(string, (DateFormatSymbols)dateFormatSymbols.clone(), null, null, uLocale, true, null);
    }

    SimpleDateFormat(String string, DateFormatSymbols dateFormatSymbols, Calendar calendar, ULocale uLocale, boolean bl, String string2) {
        this(string, (DateFormatSymbols)dateFormatSymbols.clone(), (Calendar)calendar.clone(), null, uLocale, bl, string2);
    }

    private SimpleDateFormat(String string, DateFormatSymbols dateFormatSymbols, Calendar calendar, NumberFormat numberFormat, ULocale uLocale, boolean bl, String string2) {
        this.pattern = string;
        this.formatData = dateFormatSymbols;
        this.calendar = calendar;
        this.numberFormat = numberFormat;
        this.locale = uLocale;
        this.useFastFormat = bl;
        this.override = string2;
        this.initialize();
    }

    public static SimpleDateFormat getInstance(Calendar.FormatConfiguration formatConfiguration) {
        String string = formatConfiguration.getOverrideString();
        boolean bl = string != null && string.length() > 0;
        return new SimpleDateFormat(formatConfiguration.getPatternString(), formatConfiguration.getDateFormatSymbols(), formatConfiguration.getCalendar(), null, formatConfiguration.getLocale(), bl, formatConfiguration.getOverrideString());
    }

    private void initialize() {
        if (this.locale == null) {
            this.locale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        if (this.formatData == null) {
            this.formatData = new DateFormatSymbols(this.locale);
        }
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance(this.locale);
        }
        if (this.numberFormat == null) {
            NumberingSystem numberingSystem = NumberingSystem.getInstance(this.locale);
            if (numberingSystem.isAlgorithmic()) {
                this.numberFormat = NumberFormat.getInstance(this.locale);
            } else {
                String string = numberingSystem.getDescription();
                String string2 = numberingSystem.getName();
                this.numberFormat = new DateNumberFormat(this.locale, string, string2);
            }
        }
        this.defaultCenturyBase = System.currentTimeMillis();
        this.setLocale(this.calendar.getLocale(ULocale.VALID_LOCALE), this.calendar.getLocale(ULocale.ACTUAL_LOCALE));
        this.initLocalZeroPaddingNumberFormat();
        if (this.override != null) {
            this.initNumberFormatters(this.locale);
        }
        this.capitalizationSetting = DisplayContext.CAPITALIZATION_NONE;
    }

    private synchronized void initializeTimeZoneFormat(boolean bl) {
        if (bl || this.tzFormat == null) {
            this.tzFormat = TimeZoneFormat.getInstance(this.locale);
            String string = null;
            if (this.numberFormat instanceof DecimalFormat) {
                DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat)this.numberFormat).getDecimalFormatSymbols();
                string = new String(decimalFormatSymbols.getDigits());
            } else if (this.numberFormat instanceof DateNumberFormat) {
                string = new String(((DateNumberFormat)this.numberFormat).getDigits());
            }
            if (string != null && !this.tzFormat.getGMTOffsetDigits().equals(string)) {
                if (this.tzFormat.isFrozen()) {
                    this.tzFormat = this.tzFormat.cloneAsThawed();
                }
                this.tzFormat.setGMTOffsetDigits(string);
            }
        }
    }

    private TimeZoneFormat tzFormat() {
        if (this.tzFormat == null) {
            this.initializeTimeZoneFormat(false);
        }
        return this.tzFormat;
    }

    private static synchronized String getDefaultPattern() {
        ULocale uLocale = ULocale.getDefault(ULocale.Category.FORMAT);
        if (!uLocale.equals(cachedDefaultLocale)) {
            cachedDefaultLocale = uLocale;
            Calendar calendar = Calendar.getInstance(cachedDefaultLocale);
            try {
                CalendarData calendarData = new CalendarData(cachedDefaultLocale, calendar.getType());
                String[] stringArray = calendarData.getDateTimePatterns();
                int n = 8;
                if (stringArray.length >= 13) {
                    n += 4;
                }
                cachedDefaultPattern = MessageFormat.format(stringArray[n], stringArray[3], stringArray[7]);
            }
            catch (MissingResourceException missingResourceException) {
                cachedDefaultPattern = FALLBACKPATTERN;
            }
        }
        return cachedDefaultPattern;
    }

    private void parseAmbiguousDatesAsAfter(Date date) {
        this.defaultCenturyStart = date;
        this.calendar.setTime(date);
        this.defaultCenturyStartYear = this.calendar.get(1);
    }

    private void initializeDefaultCenturyStart(long l) {
        this.defaultCenturyBase = l;
        Calendar calendar = (Calendar)this.calendar.clone();
        calendar.setTimeInMillis(l);
        calendar.add(1, -80);
        this.defaultCenturyStart = calendar.getTime();
        this.defaultCenturyStartYear = calendar.get(1);
    }

    private Date getDefaultCenturyStart() {
        if (this.defaultCenturyStart == null) {
            this.initializeDefaultCenturyStart(this.defaultCenturyBase);
        }
        return this.defaultCenturyStart;
    }

    private int getDefaultCenturyStartYear() {
        if (this.defaultCenturyStart == null) {
            this.initializeDefaultCenturyStart(this.defaultCenturyBase);
        }
        return this.defaultCenturyStartYear;
    }

    public void set2DigitYearStart(Date date) {
        this.parseAmbiguousDatesAsAfter(date);
    }

    public Date get2DigitYearStart() {
        return this.getDefaultCenturyStart();
    }

    @Override
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone = null;
        if (calendar != this.calendar && !calendar.getType().equals(this.calendar.getType())) {
            this.calendar.setTimeInMillis(calendar.getTimeInMillis());
            timeZone = this.calendar.getTimeZone();
            this.calendar.setTimeZone(calendar.getTimeZone());
            calendar = this.calendar;
        }
        StringBuffer stringBuffer2 = this.format(calendar, this.capitalizationSetting, stringBuffer, fieldPosition, null);
        if (timeZone != null) {
            this.calendar.setTimeZone(timeZone);
        }
        return stringBuffer2;
    }

    private StringBuffer format(Calendar calendar, DisplayContext displayContext, StringBuffer stringBuffer, FieldPosition fieldPosition, List<FieldPosition> list) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        Object[] objectArray = this.getPatternItems();
        for (int i = 0; i < objectArray.length; ++i) {
            int n;
            if (objectArray[i] instanceof String) {
                stringBuffer.append((String)objectArray[i]);
                continue;
            }
            PatternItem patternItem = (PatternItem)objectArray[i];
            int n2 = 0;
            if (list != null) {
                n2 = stringBuffer.length();
            }
            if (this.useFastFormat) {
                this.subFormat(stringBuffer, patternItem.type, patternItem.length, stringBuffer.length(), i, displayContext, fieldPosition, calendar);
            } else {
                stringBuffer.append(this.subFormat(patternItem.type, patternItem.length, stringBuffer.length(), i, displayContext, fieldPosition, calendar));
            }
            if (list == null || (n = stringBuffer.length()) - n2 <= 0) continue;
            DateFormat.Field field = this.patternCharToDateFormatField(patternItem.type);
            FieldPosition fieldPosition2 = new FieldPosition(field);
            fieldPosition2.setBeginIndex(n2);
            fieldPosition2.setEndIndex(n);
            list.add(fieldPosition2);
        }
        return stringBuffer;
    }

    protected DateFormat.Field patternCharToDateFormatField(char c) {
        int n = -1;
        if ('A' <= c && c <= 'z') {
            n = PATTERN_CHAR_TO_INDEX[c - 64];
        }
        if (n != -1) {
            return PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[n];
        }
        return null;
    }

    protected String subFormat(char c, int n, int n2, FieldPosition fieldPosition, DateFormatSymbols dateFormatSymbols, Calendar calendar) throws IllegalArgumentException {
        return this.subFormat(c, n, n2, 0, DisplayContext.CAPITALIZATION_NONE, fieldPosition, calendar);
    }

    protected String subFormat(char c, int n, int n2, int n3, DisplayContext displayContext, FieldPosition fieldPosition, Calendar calendar) {
        StringBuffer stringBuffer = new StringBuffer();
        this.subFormat(stringBuffer, c, n, n2, n3, displayContext, fieldPosition, calendar);
        return stringBuffer.toString();
    }

    protected void subFormat(StringBuffer stringBuffer, char c, int n, int n2, int n3, DisplayContext displayContext, FieldPosition fieldPosition, Calendar calendar) {
        String[] stringArray;
        Object object;
        Object object2;
        int n4 = Integer.MAX_VALUE;
        int n5 = stringBuffer.length();
        TimeZone timeZone = calendar.getTimeZone();
        long l = calendar.getTimeInMillis();
        String string = null;
        int n6 = -1;
        if ('A' <= c && c <= 'z') {
            n6 = PATTERN_CHAR_TO_INDEX[c - 64];
        }
        if (n6 == -1) {
            if (c == 'l') {
                return;
            }
            throw new IllegalArgumentException("Illegal pattern character '" + c + "' in \"" + this.pattern + '\"');
        }
        int n7 = PATTERN_INDEX_TO_CALENDAR_FIELD[n6];
        int n8 = calendar.get(n7);
        NumberFormat numberFormat = this.getNumberFormat(c);
        DateFormatSymbols.CapitalizationContextUsage capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.OTHER;
        switch (n6) {
            case 0: {
                if (calendar.getType().equals("chinese")) {
                    this.zeroPaddingNumber(numberFormat, stringBuffer, n8, 1, 9);
                    break;
                }
                if (n == 5) {
                    SimpleDateFormat.safeAppend(this.formatData.narrowEras, n8, stringBuffer);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.ERA_NARROW;
                    break;
                }
                if (n == 4) {
                    SimpleDateFormat.safeAppend(this.formatData.eraNames, n8, stringBuffer);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.ERA_WIDE;
                    break;
                }
                SimpleDateFormat.safeAppend(this.formatData.eras, n8, stringBuffer);
                capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.ERA_ABBREV;
                break;
            }
            case 30: {
                if (this.formatData.shortYearNames != null && n8 <= this.formatData.shortYearNames.length) {
                    SimpleDateFormat.safeAppend(this.formatData.shortYearNames, n8 - 1, stringBuffer);
                    break;
                }
            }
            case 1: 
            case 18: {
                if (this.override != null && (this.override.compareTo("hebr") == 0 || this.override.indexOf("y=hebr") >= 0) && n8 > 5000 && n8 < 6000) {
                    n8 -= 5000;
                }
                if (n == 2) {
                    this.zeroPaddingNumber(numberFormat, stringBuffer, n8, 2, 2);
                    break;
                }
                this.zeroPaddingNumber(numberFormat, stringBuffer, n8, n, Integer.MAX_VALUE);
                break;
            }
            case 2: 
            case 26: {
                if (calendar.getType().equals("hebrew")) {
                    object2 = HebrewCalendar.isLeapYear(calendar.get(1));
                    if (object2 != 0 && n8 == 6 && n >= 3) {
                        n8 = 13;
                    }
                    if (object2 == 0 && n8 >= 6 && n < 3) {
                        --n8;
                    }
                }
                int n9 = object2 = this.formatData.leapMonthPatterns != null && this.formatData.leapMonthPatterns.length >= 7 ? calendar.get(22) : 0;
                if (n == 5) {
                    if (n6 == 2) {
                        SimpleDateFormat.safeAppendWithMonthPattern(this.formatData.narrowMonths, n8, stringBuffer, object2 != 0 ? this.formatData.leapMonthPatterns[2] : null);
                    } else {
                        SimpleDateFormat.safeAppendWithMonthPattern(this.formatData.standaloneNarrowMonths, n8, stringBuffer, object2 != 0 ? this.formatData.leapMonthPatterns[5] : null);
                    }
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.MONTH_NARROW;
                    break;
                }
                if (n == 4) {
                    if (n6 == 2) {
                        SimpleDateFormat.safeAppendWithMonthPattern(this.formatData.months, n8, stringBuffer, object2 != 0 ? this.formatData.leapMonthPatterns[0] : null);
                        capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.MONTH_FORMAT;
                        break;
                    }
                    SimpleDateFormat.safeAppendWithMonthPattern(this.formatData.standaloneMonths, n8, stringBuffer, object2 != 0 ? this.formatData.leapMonthPatterns[3] : null);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.MONTH_STANDALONE;
                    break;
                }
                if (n == 3) {
                    if (n6 == 2) {
                        SimpleDateFormat.safeAppendWithMonthPattern(this.formatData.shortMonths, n8, stringBuffer, object2 != 0 ? this.formatData.leapMonthPatterns[1] : null);
                        capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.MONTH_FORMAT;
                        break;
                    }
                    SimpleDateFormat.safeAppendWithMonthPattern(this.formatData.standaloneShortMonths, n8, stringBuffer, object2 != 0 ? this.formatData.leapMonthPatterns[4] : null);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.MONTH_STANDALONE;
                    break;
                }
                object = new StringBuffer();
                this.zeroPaddingNumber(numberFormat, (StringBuffer)object, n8 + 1, n, Integer.MAX_VALUE);
                stringArray = new String[]{((StringBuffer)object).toString()};
                SimpleDateFormat.safeAppendWithMonthPattern(stringArray, 0, stringBuffer, object2 != 0 ? this.formatData.leapMonthPatterns[6] : null);
                break;
            }
            case 4: {
                if (n8 == 0) {
                    this.zeroPaddingNumber(numberFormat, stringBuffer, calendar.getMaximum(11) + 1, n, Integer.MAX_VALUE);
                    break;
                }
                this.zeroPaddingNumber(numberFormat, stringBuffer, n8, n, Integer.MAX_VALUE);
                break;
            }
            case 8: {
                this.numberFormat.setMinimumIntegerDigits(Math.min(3, n));
                this.numberFormat.setMaximumIntegerDigits(Integer.MAX_VALUE);
                if (n == 1) {
                    n8 /= 100;
                } else if (n == 2) {
                    n8 /= 10;
                }
                object = new FieldPosition(-1);
                this.numberFormat.format(n8, stringBuffer, (FieldPosition)object);
                if (n <= 3) break;
                this.numberFormat.setMinimumIntegerDigits(n - 3);
                this.numberFormat.format(0L, stringBuffer, (FieldPosition)object);
                break;
            }
            case 19: {
                if (n < 3) {
                    this.zeroPaddingNumber(numberFormat, stringBuffer, n8, n, Integer.MAX_VALUE);
                    break;
                }
                n8 = calendar.get(7);
            }
            case 9: {
                if (n == 5) {
                    SimpleDateFormat.safeAppend(this.formatData.narrowWeekdays, n8, stringBuffer);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.DAY_NARROW;
                    break;
                }
                if (n == 4) {
                    SimpleDateFormat.safeAppend(this.formatData.weekdays, n8, stringBuffer);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.DAY_FORMAT;
                    break;
                }
                if (n == 6 && this.formatData.shorterWeekdays != null) {
                    SimpleDateFormat.safeAppend(this.formatData.shorterWeekdays, n8, stringBuffer);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.DAY_FORMAT;
                    break;
                }
                SimpleDateFormat.safeAppend(this.formatData.shortWeekdays, n8, stringBuffer);
                capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.DAY_FORMAT;
                break;
            }
            case 14: {
                SimpleDateFormat.safeAppend(this.formatData.ampms, n8, stringBuffer);
                break;
            }
            case 15: {
                if (n8 == 0) {
                    this.zeroPaddingNumber(numberFormat, stringBuffer, calendar.getLeastMaximum(10) + 1, n, Integer.MAX_VALUE);
                    break;
                }
                this.zeroPaddingNumber(numberFormat, stringBuffer, n8, n, Integer.MAX_VALUE);
                break;
            }
            case 17: {
                if (n < 4) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.SPECIFIC_SHORT, timeZone, l);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.METAZONE_SHORT;
                } else {
                    string = this.tzFormat().format(TimeZoneFormat.Style.SPECIFIC_LONG, timeZone, l);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.METAZONE_LONG;
                }
                stringBuffer.append(string);
                break;
            }
            case 23: {
                string = n < 4 ? this.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_LOCAL_FULL, timeZone, l) : (n == 5 ? this.tzFormat().format(TimeZoneFormat.Style.ISO_EXTENDED_FULL, timeZone, l) : this.tzFormat().format(TimeZoneFormat.Style.LOCALIZED_GMT, timeZone, l));
                stringBuffer.append(string);
                break;
            }
            case 24: {
                if (n == 1) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.GENERIC_SHORT, timeZone, l);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.METAZONE_SHORT;
                } else if (n == 4) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.GENERIC_LONG, timeZone, l);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.METAZONE_LONG;
                }
                stringBuffer.append(string);
                break;
            }
            case 29: {
                if (n == 1) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.ZONE_ID_SHORT, timeZone, l);
                } else if (n == 2) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.ZONE_ID, timeZone, l);
                } else if (n == 3) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.EXEMPLAR_LOCATION, timeZone, l);
                } else if (n == 4) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.GENERIC_LOCATION, timeZone, l);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.ZONE_LONG;
                }
                stringBuffer.append(string);
                break;
            }
            case 31: {
                if (n == 1) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.LOCALIZED_GMT_SHORT, timeZone, l);
                } else if (n == 4) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.LOCALIZED_GMT, timeZone, l);
                }
                stringBuffer.append(string);
                break;
            }
            case 32: {
                if (n == 1) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_SHORT, timeZone, l);
                } else if (n == 2) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_FIXED, timeZone, l);
                } else if (n == 3) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.ISO_EXTENDED_FIXED, timeZone, l);
                } else if (n == 4) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_FULL, timeZone, l);
                } else if (n == 5) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.ISO_EXTENDED_FULL, timeZone, l);
                }
                stringBuffer.append(string);
                break;
            }
            case 33: {
                if (n == 1) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_LOCAL_SHORT, timeZone, l);
                } else if (n == 2) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_LOCAL_FIXED, timeZone, l);
                } else if (n == 3) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.ISO_EXTENDED_LOCAL_FIXED, timeZone, l);
                } else if (n == 4) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.ISO_BASIC_LOCAL_FULL, timeZone, l);
                } else if (n == 5) {
                    string = this.tzFormat().format(TimeZoneFormat.Style.ISO_EXTENDED_LOCAL_FULL, timeZone, l);
                }
                stringBuffer.append(string);
                break;
            }
            case 25: {
                if (n < 3) {
                    this.zeroPaddingNumber(numberFormat, stringBuffer, n8, 1, Integer.MAX_VALUE);
                    break;
                }
                n8 = calendar.get(7);
                if (n == 5) {
                    SimpleDateFormat.safeAppend(this.formatData.standaloneNarrowWeekdays, n8, stringBuffer);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.DAY_NARROW;
                    break;
                }
                if (n == 4) {
                    SimpleDateFormat.safeAppend(this.formatData.standaloneWeekdays, n8, stringBuffer);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.DAY_STANDALONE;
                    break;
                }
                if (n == 6 && this.formatData.standaloneShorterWeekdays != null) {
                    SimpleDateFormat.safeAppend(this.formatData.standaloneShorterWeekdays, n8, stringBuffer);
                    capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.DAY_STANDALONE;
                    break;
                }
                SimpleDateFormat.safeAppend(this.formatData.standaloneShortWeekdays, n8, stringBuffer);
                capitalizationContextUsage = DateFormatSymbols.CapitalizationContextUsage.DAY_STANDALONE;
                break;
            }
            case 27: {
                if (n >= 4) {
                    SimpleDateFormat.safeAppend(this.formatData.quarters, n8 / 3, stringBuffer);
                    break;
                }
                if (n == 3) {
                    SimpleDateFormat.safeAppend(this.formatData.shortQuarters, n8 / 3, stringBuffer);
                    break;
                }
                this.zeroPaddingNumber(numberFormat, stringBuffer, n8 / 3 + 1, n, Integer.MAX_VALUE);
                break;
            }
            case 28: {
                if (n >= 4) {
                    SimpleDateFormat.safeAppend(this.formatData.standaloneQuarters, n8 / 3, stringBuffer);
                    break;
                }
                if (n == 3) {
                    SimpleDateFormat.safeAppend(this.formatData.standaloneShortQuarters, n8 / 3, stringBuffer);
                    break;
                }
                this.zeroPaddingNumber(numberFormat, stringBuffer, n8 / 3 + 1, n, Integer.MAX_VALUE);
                break;
            }
            default: {
                this.zeroPaddingNumber(numberFormat, stringBuffer, n8, n, Integer.MAX_VALUE);
            }
        }
        if (n3 == 0) {
            object2 = 0;
            if (displayContext != null) {
                switch (displayContext) {
                    case CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE: {
                        object2 = 1;
                        break;
                    }
                    case CAPITALIZATION_FOR_UI_LIST_OR_MENU: 
                    case CAPITALIZATION_FOR_STANDALONE: {
                        if (this.formatData.capitalization == null) break;
                        object = this.formatData.capitalization.get((Object)capitalizationContextUsage);
                        object2 = displayContext == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU ? object[0] : object[1];
                        break;
                    }
                }
            }
            if (object2 != 0) {
                object = stringBuffer.substring(n5);
                stringArray = UCharacter.toTitleCase(this.locale, (String)object, null, 768);
                stringBuffer.replace(n5, stringBuffer.length(), (String)stringArray);
            }
        }
        if (fieldPosition.getBeginIndex() == fieldPosition.getEndIndex()) {
            if (fieldPosition.getField() == PATTERN_INDEX_TO_DATE_FORMAT_FIELD[n6]) {
                fieldPosition.setBeginIndex(n2);
                fieldPosition.setEndIndex(n2 + stringBuffer.length() - n5);
            } else if (fieldPosition.getFieldAttribute() == PATTERN_INDEX_TO_DATE_FORMAT_ATTRIBUTE[n6]) {
                fieldPosition.setBeginIndex(n2);
                fieldPosition.setEndIndex(n2 + stringBuffer.length() - n5);
            }
        }
    }

    private static void safeAppend(String[] stringArray, int n, StringBuffer stringBuffer) {
        if (stringArray != null && n >= 0 && n < stringArray.length) {
            stringBuffer.append(stringArray[n]);
        }
    }

    private static void safeAppendWithMonthPattern(String[] stringArray, int n, StringBuffer stringBuffer, String string) {
        if (stringArray != null && n >= 0 && n < stringArray.length) {
            if (string == null) {
                stringBuffer.append(stringArray[n]);
            } else {
                stringBuffer.append(MessageFormat.format(string, stringArray[n]));
            }
        }
    }

    private Object[] getPatternItems() {
        if (this.patternItems != null) {
            return this.patternItems;
        }
        this.patternItems = PARSED_PATTERN_CACHE.get(this.pattern);
        if (this.patternItems != null) {
            return this.patternItems;
        }
        boolean bl = false;
        boolean bl2 = false;
        StringBuilder stringBuilder = new StringBuilder();
        char c = '\u0000';
        int n = 1;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i = 0; i < this.pattern.length(); ++i) {
            char c2 = this.pattern.charAt(i);
            if (c2 == '\'') {
                if (bl) {
                    stringBuilder.append('\'');
                    bl = false;
                } else {
                    bl = true;
                    if (c != '\u0000') {
                        arrayList.add(new PatternItem(c, n));
                        c = '\u0000';
                    }
                }
                bl2 = !bl2;
                continue;
            }
            bl = false;
            if (bl2) {
                stringBuilder.append(c2);
                continue;
            }
            if (c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z') {
                if (c2 == c) {
                    ++n;
                    continue;
                }
                if (c == '\u0000') {
                    if (stringBuilder.length() > 0) {
                        arrayList.add(stringBuilder.toString());
                        stringBuilder.setLength(0);
                    }
                } else {
                    arrayList.add(new PatternItem(c, n));
                }
                c = c2;
                n = 1;
                continue;
            }
            if (c != '\u0000') {
                arrayList.add(new PatternItem(c, n));
                c = '\u0000';
            }
            stringBuilder.append(c2);
        }
        if (c == '\u0000') {
            if (stringBuilder.length() > 0) {
                arrayList.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        } else {
            arrayList.add(new PatternItem(c, n));
        }
        this.patternItems = arrayList.toArray(new Object[arrayList.size()]);
        PARSED_PATTERN_CACHE.put(this.pattern, this.patternItems);
        return this.patternItems;
    }

    protected void zeroPaddingNumber(NumberFormat numberFormat, StringBuffer stringBuffer, int n, int n2, int n3) {
        if (this.useLocalZeroPaddingNumberFormat && n >= 0) {
            this.fastZeroPaddingNumber(stringBuffer, n, n2, n3);
        } else {
            numberFormat.setMinimumIntegerDigits(n2);
            numberFormat.setMaximumIntegerDigits(n3);
            numberFormat.format(n, stringBuffer, new FieldPosition(-1));
        }
    }

    @Override
    public void setNumberFormat(NumberFormat numberFormat) {
        super.setNumberFormat(numberFormat);
        this.initLocalZeroPaddingNumberFormat();
        this.initializeTimeZoneFormat(true);
    }

    private void initLocalZeroPaddingNumberFormat() {
        if (this.numberFormat instanceof DecimalFormat) {
            this.decDigits = ((DecimalFormat)this.numberFormat).getDecimalFormatSymbols().getDigits();
            this.useLocalZeroPaddingNumberFormat = true;
        } else if (this.numberFormat instanceof DateNumberFormat) {
            this.decDigits = ((DateNumberFormat)this.numberFormat).getDigits();
            this.useLocalZeroPaddingNumberFormat = true;
        } else {
            this.useLocalZeroPaddingNumberFormat = false;
        }
        if (this.useLocalZeroPaddingNumberFormat) {
            this.decimalBuf = new char[10];
        }
    }

    private void fastZeroPaddingNumber(StringBuffer stringBuffer, int n, int n2, int n3) {
        int n4;
        int n5 = this.decimalBuf.length < n3 ? this.decimalBuf.length : n3;
        int n6 = n5 - 1;
        while (true) {
            this.decimalBuf[n6] = this.decDigits[n % 10];
            if (n6 == 0 || (n /= 10) == 0) break;
            --n6;
        }
        for (n4 = n2 - (n5 - n6); n4 > 0 && n6 > 0; --n4) {
            this.decimalBuf[--n6] = this.decDigits[0];
        }
        while (n4 > 0) {
            stringBuffer.append(this.decDigits[0]);
            --n4;
        }
        stringBuffer.append(this.decimalBuf, n6, n5 - n6);
    }

    protected String zeroPaddingNumber(long l, int n, int n2) {
        this.numberFormat.setMinimumIntegerDigits(n);
        this.numberFormat.setMaximumIntegerDigits(n2);
        return this.numberFormat.format(l);
    }

    private static final boolean isNumeric(char c, int n) {
        int n2 = NUMERIC_FORMAT_CHARS.indexOf(c);
        return n2 > 0 || n2 == 0 && n < 3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void parse(String string, Calendar calendar, ParsePosition parsePosition) {
        Calendar calendar2;
        TimeZone timeZone;
        block40: {
            Object object;
            char c;
            Object object2;
            int n;
            timeZone = null;
            calendar2 = null;
            if (calendar != this.calendar && !calendar.getType().equals(this.calendar.getType())) {
                this.calendar.setTimeInMillis(calendar.getTimeInMillis());
                timeZone = this.calendar.getTimeZone();
                this.calendar.setTimeZone(calendar.getTimeZone());
                calendar2 = calendar;
                calendar = this.calendar;
            }
            int n2 = n = parsePosition.getIndex();
            this.tztype = TimeZoneFormat.TimeType.UNKNOWN;
            boolean[] blArray = new boolean[]{false};
            int n3 = -1;
            int n4 = 0;
            int n5 = 0;
            MessageFormat messageFormat = null;
            if (this.formatData.leapMonthPatterns != null && this.formatData.leapMonthPatterns.length >= 7) {
                messageFormat = new MessageFormat(this.formatData.leapMonthPatterns[6], this.locale);
            }
            Object[] objectArray = this.getPatternItems();
            int n6 = 0;
            while (n6 < objectArray.length) {
                block44: {
                    Object object3;
                    block42: {
                        int n7;
                        block45: {
                            block43: {
                                if (!(objectArray[n6] instanceof PatternItem)) break block42;
                                object3 = (PatternItem)objectArray[n6];
                                if (((PatternItem)object3).isNumeric && n3 == -1 && n6 + 1 < objectArray.length && objectArray[n6 + 1] instanceof PatternItem && ((PatternItem)objectArray[n6 + 1]).isNumeric) {
                                    n3 = n6;
                                    n4 = ((PatternItem)object3).length;
                                    n5 = n;
                                }
                                if (n3 == -1) break block43;
                                n7 = ((PatternItem)object3).length;
                                if (n3 == n6) {
                                    n7 = n4;
                                }
                                if ((n = this.subParse(string, n, ((PatternItem)object3).type, n7, true, false, blArray, calendar, messageFormat)) < 0) {
                                    if (--n4 == 0) {
                                        parsePosition.setIndex(n2);
                                        parsePosition.setErrorIndex(n);
                                        if (timeZone != null) {
                                            this.calendar.setTimeZone(timeZone);
                                        }
                                        return;
                                    }
                                    n6 = n3;
                                    n = n5;
                                    continue;
                                }
                                break block44;
                            }
                            if (((PatternItem)object3).type == 'l') break block44;
                            n3 = -1;
                            n7 = n;
                            if ((n = this.subParse(string, n, ((PatternItem)object3).type, ((PatternItem)object3).length, false, true, blArray, calendar, messageFormat)) >= 0) break block44;
                            if (n != -32000) break block45;
                            n = n7;
                            if (n6 + 1 < objectArray.length) {
                                char c2;
                                int n8;
                                object2 = null;
                                try {
                                    object2 = (String)objectArray[n6 + 1];
                                }
                                catch (ClassCastException classCastException) {
                                    parsePosition.setIndex(n2);
                                    parsePosition.setErrorIndex(n7);
                                    if (timeZone != null) {
                                        this.calendar.setTimeZone(timeZone);
                                    }
                                    return;
                                }
                                if (object2 == null) {
                                    object2 = (String)objectArray[n6 + 1];
                                }
                                int n9 = ((String)object2).length();
                                for (n8 = 0; n8 < n9 && PatternProps.isWhiteSpace(c2 = ((String)object2).charAt(n8)); ++n8) {
                                }
                                if (n8 == n9) {
                                    ++n6;
                                }
                            }
                            break block44;
                        }
                        parsePosition.setIndex(n2);
                        parsePosition.setErrorIndex(n7);
                        if (timeZone != null) {
                            this.calendar.setTimeZone(timeZone);
                        }
                        return;
                    }
                    n3 = -1;
                    object3 = new boolean[1];
                    n = this.matchLiteral(string, n, objectArray, n6, (boolean[])object3);
                    if (object3[0] == false) {
                        parsePosition.setIndex(n2);
                        parsePosition.setErrorIndex(n);
                        if (timeZone != null) {
                            this.calendar.setTimeZone(timeZone);
                        }
                        return;
                    }
                }
                ++n6;
            }
            if (n < string.length() && (c = string.charAt(n)) == '.' && this.isLenient() && objectArray.length != 0 && (object = objectArray[objectArray.length - 1]) instanceof PatternItem && !((PatternItem)object).isNumeric) {
                ++n;
            }
            parsePosition.setIndex(n);
            try {
                Calendar calendar3;
                Date date;
                if (!blArray[0] && this.tztype == TimeZoneFormat.TimeType.UNKNOWN) break block40;
                if (blArray[0] && (date = (calendar3 = (Calendar)calendar.clone()).getTime()).before(this.getDefaultCenturyStart())) {
                    calendar.set(1, this.getDefaultCenturyStartYear() + 100);
                }
                if (this.tztype == TimeZoneFormat.TimeType.UNKNOWN) break block40;
                Calendar calendar4 = (Calendar)calendar.clone();
                TimeZone timeZone2 = calendar4.getTimeZone();
                object2 = null;
                if (timeZone2 instanceof BasicTimeZone) {
                    object2 = (BasicTimeZone)timeZone2;
                }
                calendar4.set(15, 0);
                calendar4.set(16, 0);
                long l = calendar4.getTimeInMillis();
                int[] nArray = new int[2];
                if (object2 != null) {
                    if (this.tztype == TimeZoneFormat.TimeType.STANDARD) {
                        ((BasicTimeZone)object2).getOffsetFromLocal(l, 1, 1, nArray);
                    } else {
                        ((BasicTimeZone)object2).getOffsetFromLocal(l, 3, 3, nArray);
                    }
                } else {
                    timeZone2.getOffset(l, true, nArray);
                    if (this.tztype == TimeZoneFormat.TimeType.STANDARD && nArray[1] != 0 || this.tztype == TimeZoneFormat.TimeType.DAYLIGHT && nArray[1] == 0) {
                        timeZone2.getOffset(l - 86400000L, true, nArray);
                    }
                }
                int n10 = nArray[1];
                if (this.tztype == TimeZoneFormat.TimeType.STANDARD) {
                    if (nArray[1] != 0) {
                        n10 = 0;
                    }
                } else if (nArray[1] == 0) {
                    if (object2 == null) {
                        n10 = timeZone2.getDSTSavings();
                    } else {
                        TimeZoneTransition timeZoneTransition;
                        TimeZoneTransition timeZoneTransition2;
                        long l2;
                        long l3 = l2 = l + (long)nArray[0];
                        long l4 = l2;
                        int n11 = 0;
                        int n12 = 0;
                        while ((timeZoneTransition2 = ((BasicTimeZone)object2).getPreviousTransition(l3, true)) != null) {
                            l3 = timeZoneTransition2.getTime() - 1L;
                            n11 = timeZoneTransition2.getFrom().getDSTSavings();
                            if (n11 == 0) continue;
                        }
                        while ((timeZoneTransition = ((BasicTimeZone)object2).getNextTransition(l4, false)) != null) {
                            l4 = timeZoneTransition.getTime();
                            n12 = timeZoneTransition.getTo().getDSTSavings();
                            if (n12 == 0) continue;
                        }
                        n10 = timeZoneTransition2 != null && timeZoneTransition != null ? (l2 - l3 > l4 - l2 ? n12 : n11) : (timeZoneTransition2 != null && n11 != 0 ? n11 : (timeZoneTransition != null && n12 != 0 ? n12 : ((TimeZone)object2).getDSTSavings()));
                    }
                    if (n10 == 0) {
                        n10 = 3600000;
                    }
                }
                calendar.set(15, nArray[0]);
                calendar.set(16, n10);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                parsePosition.setErrorIndex(n);
                parsePosition.setIndex(n2);
                if (timeZone != null) {
                    this.calendar.setTimeZone(timeZone);
                }
                return;
            }
        }
        if (calendar2 != null) {
            calendar2.setTimeZone(calendar.getTimeZone());
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        if (timeZone != null) {
            this.calendar.setTimeZone(timeZone);
        }
    }

    private int matchLiteral(String string, int n, Object[] objectArray, int n2, boolean[] blArray) {
        char c;
        int n3 = n;
        String string2 = (String)objectArray[n2];
        int n4 = string2.length();
        int n5 = string.length();
        int n6 = 0;
        while (n6 < n4 && n < n5) {
            char c2 = string2.charAt(n6);
            char c3 = string.charAt(n);
            if (PatternProps.isWhiteSpace(c2) && PatternProps.isWhiteSpace(c3)) {
                while (n6 + 1 < n4 && PatternProps.isWhiteSpace(string2.charAt(n6 + 1))) {
                    ++n6;
                }
                while (n + 1 < n5 && PatternProps.isWhiteSpace(string.charAt(n + 1))) {
                    ++n;
                }
            } else if (c2 != c3) {
                Object object;
                if (c3 != '.' || n != n3 || 0 >= n2 || !this.isLenient() || !((object = objectArray[n2 - 1]) instanceof PatternItem) || (c = ((PatternItem)object).isNumeric) != '\u0000') break;
                ++n;
                continue;
            }
            ++n6;
            ++n;
        }
        boolean bl = blArray[0] = n6 == n4;
        if (!blArray[0] && this.isLenient() && 0 < n2 && n2 < objectArray.length - 1 && n3 < n5) {
            Object object = objectArray[n2 - 1];
            Object object2 = objectArray[n2 + 1];
            if (object instanceof PatternItem && object2 instanceof PatternItem) {
                char c4 = ((PatternItem)object).type;
                c = ((PatternItem)object2).type;
                if (DATE_PATTERN_TYPE.contains(c4) != DATE_PATTERN_TYPE.contains(c)) {
                    char c5;
                    int n7 = n3;
                    while (PatternProps.isWhiteSpace(c5 = string.charAt(n7))) {
                        ++n7;
                    }
                    blArray[0] = n7 > n3;
                    n = n7;
                }
            }
        }
        return n;
    }

    protected int matchString(String string, int n, int n2, String[] stringArray, Calendar calendar) {
        return this.matchString(string, n, n2, stringArray, null, calendar);
    }

    protected int matchString(String string, int n, int n2, String[] stringArray, String string2, Calendar calendar) {
        int n3 = 0;
        int n4 = stringArray.length;
        if (n2 == 7) {
            n3 = 1;
        }
        int n5 = 0;
        int n6 = -1;
        int n7 = 0;
        int n8 = 0;
        while (n3 < n4) {
            String string3;
            int n9 = stringArray[n3].length();
            if (n9 > n5 && (n8 = this.regionMatchesWithOptionalDot(string, n, stringArray[n3], n9)) >= 0) {
                n6 = n3;
                n5 = n8;
                n7 = 0;
            }
            if (string2 != null && (n9 = (string3 = MessageFormat.format(string2, stringArray[n3])).length()) > n5 && (n8 = this.regionMatchesWithOptionalDot(string, n, string3, n9)) >= 0) {
                n6 = n3;
                n5 = n8;
                n7 = 1;
            }
            ++n3;
        }
        if (n6 >= 0) {
            if (n2 == 1) {
                ++n6;
            }
            calendar.set(n2, n6);
            if (string2 != null) {
                calendar.set(22, n7);
            }
            return n + n5;
        }
        return -n;
    }

    private int regionMatchesWithOptionalDot(String string, int n, String string2, int n2) {
        boolean bl = string.regionMatches(true, n, string2, 0, n2);
        if (bl) {
            return n2;
        }
        if (string2.length() > 0 && string2.charAt(string2.length() - 1) == '.' && string.regionMatches(true, n, string2, 0, n2 - 1)) {
            return n2 - 1;
        }
        return -1;
    }

    protected int matchQuarterString(String string, int n, int n2, String[] stringArray, Calendar calendar) {
        int n3 = stringArray.length;
        int n4 = 0;
        int n5 = -1;
        int n6 = 0;
        for (int i = 0; i < n3; ++i) {
            int n7 = stringArray[i].length();
            if (n7 <= n4 || (n6 = this.regionMatchesWithOptionalDot(string, n, stringArray[i], n7)) < 0) continue;
            n5 = i;
            n4 = n6;
        }
        if (n5 >= 0) {
            calendar.set(n2, n5 * 3);
            return n + n4;
        }
        return -n;
    }

    protected int subParse(String string, int n, char c, int n2, boolean bl, boolean bl2, boolean[] blArray, Calendar calendar) {
        return this.subParse(string, n, c, n2, bl, bl2, blArray, calendar, null);
    }

    protected int subParse(String string, int n, char c, int n2, boolean bl, boolean bl2, boolean[] blArray, Calendar calendar, MessageFormat messageFormat) {
        Object object;
        int n3;
        Number number = null;
        NumberFormat numberFormat = null;
        int n4 = 0;
        ParsePosition parsePosition = new ParsePosition(0);
        boolean bl3 = this.isLenient();
        int n5 = -1;
        if ('A' <= c && c <= 'z') {
            n5 = PATTERN_CHAR_TO_INDEX[c - 64];
        }
        if (n5 == -1) {
            return -n;
        }
        numberFormat = this.getNumberFormat(c);
        int n6 = PATTERN_INDEX_TO_CALENDAR_FIELD[n5];
        if (messageFormat != null) {
            messageFormat.setFormatByArgumentIndex(0, numberFormat);
        }
        while (true) {
            if (n >= string.length()) {
                return -n;
            }
            n3 = UTF16.charAt(string, n);
            if (!UCharacter.isUWhiteSpace(n3) || !PatternProps.isWhiteSpace(n3)) break;
            n += UTF16.getCharCount(n3);
        }
        parsePosition.setIndex(n);
        if (n5 == 4 || n5 == 15 || n5 == 2 && n2 <= 2 || n5 == 26 && n2 <= 2 || n5 == 1 || n5 == 18 || n5 == 30 || n5 == 0 && calendar.getType().equals("chinese") || n5 == 8) {
            n3 = 0;
            if (messageFormat != null && (n5 == 2 || n5 == 26)) {
                object = messageFormat.parse(string, parsePosition);
                if (object != null && parsePosition.getIndex() > n && object[0] instanceof Number) {
                    n3 = 1;
                    number = (Number)object[0];
                    calendar.set(22, 1);
                } else {
                    parsePosition.setIndex(n);
                    calendar.set(22, 0);
                }
            }
            if (n3 == 0) {
                if (bl) {
                    if (n + n2 > string.length()) {
                        return -n;
                    }
                    number = this.parseInt(string, n2, parsePosition, bl2, numberFormat);
                } else {
                    number = this.parseInt(string, parsePosition, bl2, numberFormat);
                }
                if (number == null && n5 != 30) {
                    return -n;
                }
            }
            if (number != null) {
                n4 = number.intValue();
            }
        }
        switch (n5) {
            case 0: {
                if (calendar.getType().equals("chinese")) {
                    calendar.set(0, n4);
                    return parsePosition.getIndex();
                }
                n3 = 0;
                n3 = n2 == 5 ? this.matchString(string, n, 0, this.formatData.narrowEras, null, calendar) : (n2 == 4 ? this.matchString(string, n, 0, this.formatData.eraNames, null, calendar) : this.matchString(string, n, 0, this.formatData.eras, null, calendar));
                if (n3 == -n) {
                    n3 = -32000;
                }
                return n3;
            }
            case 1: 
            case 18: {
                if (this.override != null && (this.override.compareTo("hebr") == 0 || this.override.indexOf("y=hebr") >= 0) && n4 < 1000) {
                    n4 += 5000;
                } else if (n2 == 2 && parsePosition.getIndex() - n == 2 && !calendar.getType().equals("chinese") && UCharacter.isDigit(string.charAt(n)) && UCharacter.isDigit(string.charAt(n + 1))) {
                    int n7 = this.getDefaultCenturyStartYear() % 100;
                    blArray[0] = n4 == n7;
                    n4 += this.getDefaultCenturyStartYear() / 100 * 100 + (n4 < n7 ? 100 : 0);
                }
                calendar.set(n6, n4);
                if (DelayedHebrewMonthCheck) {
                    if (!HebrewCalendar.isLeapYear(n4)) {
                        calendar.add(2, 1);
                    }
                    DelayedHebrewMonthCheck = false;
                }
                return parsePosition.getIndex();
            }
            case 30: {
                int n8;
                if (this.formatData.shortYearNames != null && (n8 = this.matchString(string, n, 1, this.formatData.shortYearNames, null, calendar)) > 0) {
                    return n8;
                }
                if (number != null && (bl3 || this.formatData.shortYearNames == null || n4 > this.formatData.shortYearNames.length)) {
                    calendar.set(1, n4);
                    return parsePosition.getIndex();
                }
                return -n;
            }
            case 2: 
            case 26: {
                int n9;
                boolean bl4;
                if (n2 <= 2) {
                    calendar.set(2, n4 - 1);
                    if (calendar.getType().equals("hebrew") && n4 >= 6) {
                        if (calendar.isSet(1)) {
                            if (!HebrewCalendar.isLeapYear(calendar.get(1))) {
                                calendar.set(2, n4);
                            }
                        } else {
                            DelayedHebrewMonthCheck = true;
                        }
                    }
                    return parsePosition.getIndex();
                }
                boolean bl5 = bl4 = this.formatData.leapMonthPatterns != null && this.formatData.leapMonthPatterns.length >= 7;
                int n10 = n5 == 2 ? this.matchString(string, n, 2, this.formatData.months, bl4 ? this.formatData.leapMonthPatterns[0] : null, calendar) : (n9 = this.matchString(string, n, 2, this.formatData.standaloneMonths, bl4 ? this.formatData.leapMonthPatterns[3] : null, calendar));
                if (n9 > 0) {
                    return n9;
                }
                return n5 == 2 ? this.matchString(string, n, 2, this.formatData.shortMonths, bl4 ? this.formatData.leapMonthPatterns[1] : null, calendar) : this.matchString(string, n, 2, this.formatData.standaloneShortMonths, bl4 ? this.formatData.leapMonthPatterns[4] : null, calendar);
            }
            case 4: {
                if (n4 == calendar.getMaximum(11) + 1) {
                    n4 = 0;
                }
                calendar.set(11, n4);
                return parsePosition.getIndex();
            }
            case 8: {
                int n11;
                if (n11 < 3) {
                    for (n11 = parsePosition.getIndex() - n; n11 < 3; ++n11) {
                        n4 *= 10;
                    }
                } else {
                    int n12 = 1;
                    while (n11 > 3) {
                        n12 *= 10;
                        --n11;
                    }
                    n4 /= n12;
                }
                calendar.set(14, n4);
                return parsePosition.getIndex();
            }
            case 9: {
                int n13 = this.matchString(string, n, 7, this.formatData.weekdays, null, calendar);
                if (n13 > 0) {
                    return n13;
                }
                n13 = this.matchString(string, n, 7, this.formatData.shortWeekdays, null, calendar);
                if (n13 > 0) {
                    return n13;
                }
                if (this.formatData.shorterWeekdays != null) {
                    return this.matchString(string, n, 7, this.formatData.shorterWeekdays, null, calendar);
                }
                return n13;
            }
            case 25: {
                int n14 = this.matchString(string, n, 7, this.formatData.standaloneWeekdays, null, calendar);
                if (n14 > 0) {
                    return n14;
                }
                n14 = this.matchString(string, n, 7, this.formatData.standaloneShortWeekdays, null, calendar);
                if (n14 > 0) {
                    return n14;
                }
                if (this.formatData.standaloneShorterWeekdays != null) {
                    return this.matchString(string, n, 7, this.formatData.standaloneShorterWeekdays, null, calendar);
                }
                return n14;
            }
            case 14: {
                return this.matchString(string, n, 9, this.formatData.ampms, null, calendar);
            }
            case 15: {
                if (n4 == calendar.getLeastMaximum(10) + 1) {
                    n4 = 0;
                }
                calendar.set(10, n4);
                return parsePosition.getIndex();
            }
            case 17: {
                object = new Output();
                TimeZoneFormat.Style style = n2 < 4 ? TimeZoneFormat.Style.SPECIFIC_SHORT : TimeZoneFormat.Style.SPECIFIC_LONG;
                TimeZone timeZone = this.tzFormat().parse(style, string, parsePosition, (Output<TimeZoneFormat.TimeType>)object);
                if (timeZone != null) {
                    this.tztype = (TimeZoneFormat.TimeType)((Object)object.value);
                    calendar.setTimeZone(timeZone);
                    return parsePosition.getIndex();
                }
                return -n;
            }
            case 23: {
                object = new Output();
                TimeZoneFormat.Style style = n2 < 4 ? TimeZoneFormat.Style.ISO_BASIC_LOCAL_FULL : (n2 == 5 ? TimeZoneFormat.Style.ISO_EXTENDED_FULL : TimeZoneFormat.Style.LOCALIZED_GMT);
                TimeZone timeZone = this.tzFormat().parse(style, string, parsePosition, (Output<TimeZoneFormat.TimeType>)object);
                if (timeZone != null) {
                    this.tztype = (TimeZoneFormat.TimeType)((Object)object.value);
                    calendar.setTimeZone(timeZone);
                    return parsePosition.getIndex();
                }
                return -n;
            }
            case 24: {
                object = new Output();
                TimeZoneFormat.Style style = n2 < 4 ? TimeZoneFormat.Style.GENERIC_SHORT : TimeZoneFormat.Style.GENERIC_LONG;
                TimeZone timeZone = this.tzFormat().parse(style, string, parsePosition, (Output<TimeZoneFormat.TimeType>)object);
                if (timeZone != null) {
                    this.tztype = (TimeZoneFormat.TimeType)((Object)object.value);
                    calendar.setTimeZone(timeZone);
                    return parsePosition.getIndex();
                }
                return -n;
            }
            case 29: {
                object = new Output();
                TimeZoneFormat.Style style = null;
                switch (n2) {
                    case 1: {
                        style = TimeZoneFormat.Style.ZONE_ID_SHORT;
                        break;
                    }
                    case 2: {
                        style = TimeZoneFormat.Style.ZONE_ID;
                        break;
                    }
                    case 3: {
                        style = TimeZoneFormat.Style.EXEMPLAR_LOCATION;
                        break;
                    }
                    default: {
                        style = TimeZoneFormat.Style.GENERIC_LOCATION;
                    }
                }
                TimeZone timeZone = this.tzFormat().parse(style, string, parsePosition, (Output<TimeZoneFormat.TimeType>)object);
                if (timeZone != null) {
                    this.tztype = (TimeZoneFormat.TimeType)((Object)object.value);
                    calendar.setTimeZone(timeZone);
                    return parsePosition.getIndex();
                }
                return -n;
            }
            case 31: {
                object = new Output();
                TimeZoneFormat.Style style = n2 < 4 ? TimeZoneFormat.Style.LOCALIZED_GMT_SHORT : TimeZoneFormat.Style.LOCALIZED_GMT;
                TimeZone timeZone = this.tzFormat().parse(style, string, parsePosition, (Output<TimeZoneFormat.TimeType>)object);
                if (timeZone != null) {
                    this.tztype = (TimeZoneFormat.TimeType)((Object)object.value);
                    calendar.setTimeZone(timeZone);
                    return parsePosition.getIndex();
                }
                return -n;
            }
            case 32: {
                TimeZoneFormat.Style style;
                object = new Output();
                switch (n2) {
                    case 1: {
                        style = TimeZoneFormat.Style.ISO_BASIC_SHORT;
                        break;
                    }
                    case 2: {
                        style = TimeZoneFormat.Style.ISO_BASIC_FIXED;
                        break;
                    }
                    case 3: {
                        style = TimeZoneFormat.Style.ISO_EXTENDED_FIXED;
                        break;
                    }
                    case 4: {
                        style = TimeZoneFormat.Style.ISO_BASIC_FULL;
                        break;
                    }
                    default: {
                        style = TimeZoneFormat.Style.ISO_EXTENDED_FULL;
                    }
                }
                TimeZone timeZone = this.tzFormat().parse(style, string, parsePosition, (Output<TimeZoneFormat.TimeType>)object);
                if (timeZone != null) {
                    this.tztype = (TimeZoneFormat.TimeType)((Object)object.value);
                    calendar.setTimeZone(timeZone);
                    return parsePosition.getIndex();
                }
                return -n;
            }
            case 33: {
                TimeZoneFormat.Style style;
                object = new Output();
                switch (n2) {
                    case 1: {
                        style = TimeZoneFormat.Style.ISO_BASIC_LOCAL_SHORT;
                        break;
                    }
                    case 2: {
                        style = TimeZoneFormat.Style.ISO_BASIC_LOCAL_FIXED;
                        break;
                    }
                    case 3: {
                        style = TimeZoneFormat.Style.ISO_EXTENDED_LOCAL_FIXED;
                        break;
                    }
                    case 4: {
                        style = TimeZoneFormat.Style.ISO_BASIC_LOCAL_FULL;
                        break;
                    }
                    default: {
                        style = TimeZoneFormat.Style.ISO_EXTENDED_LOCAL_FULL;
                    }
                }
                TimeZone timeZone = this.tzFormat().parse(style, string, parsePosition, (Output<TimeZoneFormat.TimeType>)object);
                if (timeZone != null) {
                    this.tztype = (TimeZoneFormat.TimeType)((Object)object.value);
                    calendar.setTimeZone(timeZone);
                    return parsePosition.getIndex();
                }
                return -n;
            }
            case 27: {
                if (n2 <= 2) {
                    calendar.set(2, (n4 - 1) * 3);
                    return parsePosition.getIndex();
                }
                int n15 = this.matchQuarterString(string, n, 2, this.formatData.quarters, calendar);
                if (n15 > 0) {
                    return n15;
                }
                return this.matchQuarterString(string, n, 2, this.formatData.shortQuarters, calendar);
            }
            case 28: {
                if (n2 <= 2) {
                    calendar.set(2, (n4 - 1) * 3);
                    return parsePosition.getIndex();
                }
                int n16 = this.matchQuarterString(string, n, 2, this.formatData.standaloneQuarters, calendar);
                if (n16 > 0) {
                    return n16;
                }
                return this.matchQuarterString(string, n, 2, this.formatData.standaloneShortQuarters, calendar);
            }
        }
        if (bl) {
            if (n + n2 > string.length()) {
                return -n;
            }
            number = this.parseInt(string, n2, parsePosition, bl2, numberFormat);
        } else {
            number = this.parseInt(string, parsePosition, bl2, numberFormat);
        }
        if (number != null) {
            calendar.set(n6, number.intValue());
            return parsePosition.getIndex();
        }
        return -n;
    }

    private Number parseInt(String string, ParsePosition parsePosition, boolean bl, NumberFormat numberFormat) {
        return this.parseInt(string, -1, parsePosition, bl, numberFormat);
    }

    private Number parseInt(String string, int n, ParsePosition parsePosition, boolean bl, NumberFormat numberFormat) {
        int n2;
        Number number;
        int n3 = parsePosition.getIndex();
        if (bl) {
            number = numberFormat.parse(string, parsePosition);
        } else if (numberFormat instanceof DecimalFormat) {
            String string2 = ((DecimalFormat)numberFormat).getNegativePrefix();
            ((DecimalFormat)numberFormat).setNegativePrefix(SUPPRESS_NEGATIVE_PREFIX);
            number = numberFormat.parse(string, parsePosition);
            ((DecimalFormat)numberFormat).setNegativePrefix(string2);
        } else {
            boolean bl2 = numberFormat instanceof DateNumberFormat;
            if (bl2) {
                ((DateNumberFormat)numberFormat).setParsePositiveOnly(true);
            }
            number = numberFormat.parse(string, parsePosition);
            if (bl2) {
                ((DateNumberFormat)numberFormat).setParsePositiveOnly(false);
            }
        }
        if (n > 0 && (n2 = parsePosition.getIndex() - n3) > n) {
            double d = number.doubleValue();
            n2 -= n;
            while (n2 > 0) {
                d /= 10.0;
                --n2;
            }
            parsePosition.setIndex(n3 + n);
            number = (int)d;
        }
        return number;
    }

    private String translatePattern(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = false;
        for (int i = 0; i < string.length(); ++i) {
            int n;
            char c = string.charAt(i);
            if (bl) {
                if (c == '\'') {
                    bl = false;
                }
            } else if (c == '\'') {
                bl = true;
            } else if ((c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') && (n = string2.indexOf(c)) != -1) {
                c = string3.charAt(n);
            }
            stringBuilder.append(c);
        }
        if (bl) {
            throw new IllegalArgumentException("Unfinished quote in pattern");
        }
        return stringBuilder.toString();
    }

    public String toPattern() {
        return this.pattern;
    }

    public String toLocalizedPattern() {
        return this.translatePattern(this.pattern, "GyMdkHmsSEDFwWahKzYeugAZvcLQqVUOXx", this.formatData.localPatternChars);
    }

    public void applyPattern(String string) {
        this.pattern = string;
        this.setLocale(null, null);
        this.patternItems = null;
    }

    public void applyLocalizedPattern(String string) {
        this.pattern = this.translatePattern(string, this.formatData.localPatternChars, "GyMdkHmsSEDFwWahKzYeugAZvcLQqVUOXx");
        this.setLocale(null, null);
    }

    public DateFormatSymbols getDateFormatSymbols() {
        return (DateFormatSymbols)this.formatData.clone();
    }

    public void setDateFormatSymbols(DateFormatSymbols dateFormatSymbols) {
        this.formatData = (DateFormatSymbols)dateFormatSymbols.clone();
    }

    protected DateFormatSymbols getSymbols() {
        return this.formatData;
    }

    public TimeZoneFormat getTimeZoneFormat() {
        return this.tzFormat().freeze();
    }

    public void setTimeZoneFormat(TimeZoneFormat timeZoneFormat) {
        this.tzFormat = timeZoneFormat.isFrozen() ? timeZoneFormat : timeZoneFormat.cloneAsThawed().freeze();
    }

    public void setContext(DisplayContext displayContext) {
        if (displayContext.type() == DisplayContext.Type.CAPITALIZATION) {
            this.capitalizationSetting = displayContext;
        }
    }

    public DisplayContext getContext(DisplayContext.Type type) {
        return type == DisplayContext.Type.CAPITALIZATION && this.capitalizationSetting != null ? this.capitalizationSetting : DisplayContext.CAPITALIZATION_NONE;
    }

    @Override
    public Object clone() {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat)super.clone();
        simpleDateFormat.formatData = (DateFormatSymbols)this.formatData.clone();
        return simpleDateFormat;
    }

    @Override
    public int hashCode() {
        return this.pattern.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat)object;
        return this.pattern.equals(simpleDateFormat.pattern) && this.formatData.equals(simpleDateFormat.formatData);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (this.defaultCenturyStart == null) {
            this.initializeDefaultCenturyStart(this.defaultCenturyBase);
        }
        this.initializeTimeZoneFormat(false);
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.capitalizationSetting.value());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int n;
        objectInputStream.defaultReadObject();
        int n2 = n = this.serialVersionOnStream > 1 ? objectInputStream.readInt() : -1;
        if (this.serialVersionOnStream < 1) {
            this.defaultCenturyBase = System.currentTimeMillis();
        } else {
            this.parseAmbiguousDatesAsAfter(this.defaultCenturyStart);
        }
        this.serialVersionOnStream = 2;
        this.locale = this.getLocale(ULocale.VALID_LOCALE);
        if (this.locale == null) {
            this.locale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        this.initLocalZeroPaddingNumberFormat();
        this.capitalizationSetting = DisplayContext.CAPITALIZATION_NONE;
        if (n >= 0) {
            for (DisplayContext displayContext : DisplayContext.values()) {
                if (displayContext.value() != n) continue;
                this.capitalizationSetting = displayContext;
                break;
            }
        }
    }

    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        Calendar calendar = this.calendar;
        if (object instanceof Calendar) {
            calendar = (Calendar)object;
        } else if (object instanceof Date) {
            this.calendar.setTime((Date)object);
        } else if (object instanceof Number) {
            this.calendar.setTimeInMillis(((Number)object).longValue());
        } else {
            throw new IllegalArgumentException("Cannot format given Object as a Date");
        }
        StringBuffer stringBuffer = new StringBuffer();
        FieldPosition fieldPosition = new FieldPosition(0);
        ArrayList<FieldPosition> arrayList = new ArrayList<FieldPosition>();
        this.format(calendar, this.capitalizationSetting, stringBuffer, fieldPosition, arrayList);
        AttributedString attributedString = new AttributedString(stringBuffer.toString());
        for (int i = 0; i < arrayList.size(); ++i) {
            FieldPosition fieldPosition2 = (FieldPosition)arrayList.get(i);
            Format.Field field = fieldPosition2.getFieldAttribute();
            attributedString.addAttribute(field, field, fieldPosition2.getBeginIndex(), fieldPosition2.getEndIndex());
        }
        return attributedString.getIterator();
    }

    ULocale getLocale() {
        return this.locale;
    }

    boolean isFieldUnitIgnored(int n) {
        return SimpleDateFormat.isFieldUnitIgnored(this.pattern, n);
    }

    static boolean isFieldUnitIgnored(String string, int n) {
        int n2;
        int n3 = CALENDAR_FIELD_TO_LEVEL[n];
        boolean bl = false;
        char c = '\u0000';
        int n4 = 0;
        for (int i = 0; i < string.length(); ++i) {
            char c2 = string.charAt(i);
            if (c2 != c && n4 > 0) {
                n2 = PATTERN_CHAR_TO_LEVEL[c - 64];
                if (n3 <= n2) {
                    return false;
                }
                n4 = 0;
            }
            if (c2 == '\'') {
                if (i + 1 < string.length() && string.charAt(i + 1) == '\'') {
                    ++i;
                    continue;
                }
                bl = !bl;
                continue;
            }
            if (bl || (c2 < 'a' || c2 > 'z') && (c2 < 'A' || c2 > 'Z')) continue;
            c = c2;
            ++n4;
        }
        return n4 <= 0 || n3 > (n2 = PATTERN_CHAR_TO_LEVEL[c - 64]);
    }

    public final StringBuffer intervalFormatByAlgorithm(Calendar calendar, Calendar calendar2, StringBuffer stringBuffer, FieldPosition fieldPosition) throws IllegalArgumentException {
        PatternItem patternItem;
        int n;
        int n2;
        if (!calendar.isEquivalentTo(calendar2)) {
            throw new IllegalArgumentException("can not format on two different calendars");
        }
        Object[] objectArray = this.getPatternItems();
        int n3 = -1;
        int n4 = -1;
        try {
            for (n2 = 0; n2 < objectArray.length; ++n2) {
                if (!this.diffCalFieldValue(calendar, calendar2, objectArray, n2)) continue;
                n3 = n2;
                break;
            }
            if (n3 == -1) {
                return this.format(calendar, stringBuffer, fieldPosition);
            }
            for (n2 = objectArray.length - 1; n2 >= n3; --n2) {
                if (!this.diffCalFieldValue(calendar, calendar2, objectArray, n2)) continue;
                n4 = n2;
                break;
            }
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(illegalArgumentException.toString());
        }
        if (n3 == 0 && n4 == objectArray.length - 1) {
            this.format(calendar, stringBuffer, fieldPosition);
            stringBuffer.append(" \u2013 ");
            this.format(calendar2, stringBuffer, fieldPosition);
            return stringBuffer;
        }
        n2 = 1000;
        for (n = n3; n <= n4; ++n) {
            if (objectArray[n] instanceof String) continue;
            patternItem = (PatternItem)objectArray[n];
            char c = patternItem.type;
            int n5 = -1;
            if ('A' <= c && c <= 'z') {
                n5 = PATTERN_CHAR_TO_LEVEL[c - 64];
            }
            if (n5 == -1) {
                throw new IllegalArgumentException("Illegal pattern character '" + c + "' in \"" + this.pattern + '\"');
            }
            if (n5 >= n2) continue;
            n2 = n5;
        }
        try {
            for (n = 0; n < n3; ++n) {
                if (!this.lowerLevel(objectArray, n, n2)) continue;
                n3 = n;
                break;
            }
            for (n = objectArray.length - 1; n > n4; --n) {
                if (!this.lowerLevel(objectArray, n, n2)) continue;
                n4 = n;
                break;
            }
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(illegalArgumentException.toString());
        }
        if (n3 == 0 && n4 == objectArray.length - 1) {
            this.format(calendar, stringBuffer, fieldPosition);
            stringBuffer.append(" \u2013 ");
            this.format(calendar2, stringBuffer, fieldPosition);
            return stringBuffer;
        }
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        for (n = 0; n <= n4; ++n) {
            if (objectArray[n] instanceof String) {
                stringBuffer.append((String)objectArray[n]);
                continue;
            }
            patternItem = (PatternItem)objectArray[n];
            if (this.useFastFormat) {
                this.subFormat(stringBuffer, patternItem.type, patternItem.length, stringBuffer.length(), n, this.capitalizationSetting, fieldPosition, calendar);
                continue;
            }
            stringBuffer.append(this.subFormat(patternItem.type, patternItem.length, stringBuffer.length(), n, this.capitalizationSetting, fieldPosition, calendar));
        }
        stringBuffer.append(" \u2013 ");
        for (n = n3; n < objectArray.length; ++n) {
            if (objectArray[n] instanceof String) {
                stringBuffer.append((String)objectArray[n]);
                continue;
            }
            patternItem = (PatternItem)objectArray[n];
            if (this.useFastFormat) {
                this.subFormat(stringBuffer, patternItem.type, patternItem.length, stringBuffer.length(), n, this.capitalizationSetting, fieldPosition, calendar2);
                continue;
            }
            stringBuffer.append(this.subFormat(patternItem.type, patternItem.length, stringBuffer.length(), n, this.capitalizationSetting, fieldPosition, calendar2));
        }
        return stringBuffer;
    }

    private boolean diffCalFieldValue(Calendar calendar, Calendar calendar2, Object[] objectArray, int n) throws IllegalArgumentException {
        int n2;
        if (objectArray[n] instanceof String) {
            return false;
        }
        PatternItem patternItem = (PatternItem)objectArray[n];
        char c = patternItem.type;
        int n3 = -1;
        if ('A' <= c && c <= 'z') {
            n3 = PATTERN_CHAR_TO_INDEX[c - 64];
        }
        if (n3 == -1) {
            throw new IllegalArgumentException("Illegal pattern character '" + c + "' in \"" + this.pattern + '\"');
        }
        int n4 = PATTERN_INDEX_TO_CALENDAR_FIELD[n3];
        int n5 = calendar.get(n4);
        return n5 != (n2 = calendar2.get(n4));
    }

    private boolean lowerLevel(Object[] objectArray, int n, int n2) throws IllegalArgumentException {
        if (objectArray[n] instanceof String) {
            return false;
        }
        PatternItem patternItem = (PatternItem)objectArray[n];
        char c = patternItem.type;
        int n3 = -1;
        if ('A' <= c && c <= 'z') {
            n3 = PATTERN_CHAR_TO_LEVEL[c - 64];
        }
        if (n3 == -1) {
            throw new IllegalArgumentException("Illegal pattern character '" + c + "' in \"" + this.pattern + '\"');
        }
        return n3 >= n2;
    }

    protected NumberFormat getNumberFormat(char c) {
        Character c2 = Character.valueOf(c);
        if (this.overrideMap != null && this.overrideMap.containsKey(c2)) {
            String string = this.overrideMap.get(c2).toString();
            NumberFormat numberFormat = this.numberFormatters.get(string);
            return numberFormat;
        }
        return this.numberFormat;
    }

    private void initNumberFormatters(ULocale uLocale) {
        this.numberFormatters = new HashMap();
        this.overrideMap = new HashMap();
        this.processOverrideString(uLocale, this.override);
    }

    private void processOverrideString(ULocale uLocale, String string) {
        if (string == null || string.length() == 0) {
            return;
        }
        int n = 0;
        boolean bl = true;
        while (bl) {
            boolean bl2;
            String string2;
            int n2;
            int n3 = string.indexOf(";", n);
            if (n3 == -1) {
                bl = false;
                n2 = string.length();
            } else {
                n2 = n3;
            }
            String string3 = string.substring(n, n2);
            int n4 = string3.indexOf("=");
            if (n4 == -1) {
                string2 = string3;
                bl2 = true;
            } else {
                string2 = string3.substring(n4 + 1);
                Character c = Character.valueOf(string3.charAt(0));
                this.overrideMap.put(c, string2);
                bl2 = false;
            }
            ULocale uLocale2 = new ULocale(uLocale.getBaseName() + "@numbers=" + string2);
            NumberFormat numberFormat = NumberFormat.createInstance(uLocale2, 0);
            numberFormat.setGroupingUsed(false);
            if (bl2) {
                this.setNumberFormat(numberFormat);
            } else {
                this.useLocalZeroPaddingNumberFormat = false;
            }
            if (!this.numberFormatters.containsKey(string2)) {
                this.numberFormatters.put(string2, numberFormat);
            }
            n = n3 + 1;
        }
    }

    private static class PatternItem {
        final char type;
        final int length;
        final boolean isNumeric;

        PatternItem(char c, int n) {
            this.type = c;
            this.length = n;
            this.isNumeric = SimpleDateFormat.isNumeric(c, n);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static enum ContextValue {
        UNKNOWN,
        CAPITALIZATION_FOR_MIDDLE_OF_SENTENCE,
        CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE,
        CAPITALIZATION_FOR_UI_LIST_OR_MENU,
        CAPITALIZATION_FOR_STANDALONE;

    }
}

