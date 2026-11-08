/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.CalendarData;
import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.DateIntervalInfo;
import com.ibm.icu.text.DateTimePatternGenerator;
import com.ibm.icu.text.MessageFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.text.UFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.DateInterval;
import com.ibm.icu.util.ULocale;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DateIntervalFormat
extends UFormat {
    private static final long serialVersionUID = 1L;
    private static ICUCache<String, Map<String, DateIntervalInfo.PatternInfo>> LOCAL_PATTERN_CACHE = new SimpleCache<String, Map<String, DateIntervalInfo.PatternInfo>>();
    private DateIntervalInfo fInfo;
    private SimpleDateFormat fDateFormat;
    private Calendar fFromCalendar;
    private Calendar fToCalendar;
    private String fSkeleton = null;
    private boolean isDateIntervalInfoDefault;
    private transient Map<String, DateIntervalInfo.PatternInfo> fIntervalPatterns = null;

    private DateIntervalFormat() {
    }

    public DateIntervalFormat(String string, DateIntervalInfo dateIntervalInfo, SimpleDateFormat simpleDateFormat) {
        this.fDateFormat = simpleDateFormat;
        dateIntervalInfo.freeze();
        this.fSkeleton = string;
        this.fInfo = dateIntervalInfo;
        this.isDateIntervalInfoDefault = false;
        this.fFromCalendar = (Calendar)this.fDateFormat.getCalendar().clone();
        this.fToCalendar = (Calendar)this.fDateFormat.getCalendar().clone();
        this.initializePattern(null);
    }

    private DateIntervalFormat(String string, ULocale uLocale, SimpleDateFormat simpleDateFormat) {
        this.fDateFormat = simpleDateFormat;
        this.fSkeleton = string;
        this.fInfo = new DateIntervalInfo(uLocale).freeze();
        this.isDateIntervalInfoDefault = true;
        this.fFromCalendar = (Calendar)this.fDateFormat.getCalendar().clone();
        this.fToCalendar = (Calendar)this.fDateFormat.getCalendar().clone();
        this.initializePattern(LOCAL_PATTERN_CACHE);
    }

    public static final DateIntervalFormat getInstance(String string) {
        return DateIntervalFormat.getInstance(string, ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public static final DateIntervalFormat getInstance(String string, Locale locale) {
        return DateIntervalFormat.getInstance(string, ULocale.forLocale(locale));
    }

    public static final DateIntervalFormat getInstance(String string, ULocale uLocale) {
        DateTimePatternGenerator dateTimePatternGenerator = DateTimePatternGenerator.getInstance(uLocale);
        return new DateIntervalFormat(string, uLocale, new SimpleDateFormat(dateTimePatternGenerator.getBestPattern(string), uLocale));
    }

    public static final DateIntervalFormat getInstance(String string, DateIntervalInfo dateIntervalInfo) {
        return DateIntervalFormat.getInstance(string, ULocale.getDefault(ULocale.Category.FORMAT), dateIntervalInfo);
    }

    public static final DateIntervalFormat getInstance(String string, Locale locale, DateIntervalInfo dateIntervalInfo) {
        return DateIntervalFormat.getInstance(string, ULocale.forLocale(locale), dateIntervalInfo);
    }

    public static final DateIntervalFormat getInstance(String string, ULocale uLocale, DateIntervalInfo dateIntervalInfo) {
        dateIntervalInfo = (DateIntervalInfo)dateIntervalInfo.clone();
        DateTimePatternGenerator dateTimePatternGenerator = DateTimePatternGenerator.getInstance(uLocale);
        return new DateIntervalFormat(string, dateIntervalInfo, new SimpleDateFormat(dateTimePatternGenerator.getBestPattern(string), uLocale));
    }

    @Override
    public Object clone() {
        DateIntervalFormat dateIntervalFormat = (DateIntervalFormat)super.clone();
        dateIntervalFormat.fDateFormat = (SimpleDateFormat)this.fDateFormat.clone();
        dateIntervalFormat.fInfo = (DateIntervalInfo)this.fInfo.clone();
        dateIntervalFormat.fFromCalendar = (Calendar)this.fFromCalendar.clone();
        dateIntervalFormat.fToCalendar = (Calendar)this.fToCalendar.clone();
        return dateIntervalFormat;
    }

    @Override
    public final StringBuffer format(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (object instanceof DateInterval) {
            return this.format((DateInterval)object, stringBuffer, fieldPosition);
        }
        throw new IllegalArgumentException("Cannot format given Object (" + object.getClass().getName() + ") as a DateInterval");
    }

    public final StringBuffer format(DateInterval dateInterval, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.fFromCalendar.setTimeInMillis(dateInterval.getFromDate());
        this.fToCalendar.setTimeInMillis(dateInterval.getToDate());
        return this.format(this.fFromCalendar, this.fToCalendar, stringBuffer, fieldPosition);
    }

    public final StringBuffer format(Calendar calendar, Calendar calendar2, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        Calendar calendar3;
        Calendar calendar4;
        if (!calendar.isEquivalentTo(calendar2)) {
            throw new IllegalArgumentException("can not format on two different calendars");
        }
        int n = -1;
        if (calendar.get(0) != calendar2.get(0)) {
            n = 0;
        } else if (calendar.get(1) != calendar2.get(1)) {
            n = 1;
        } else if (calendar.get(2) != calendar2.get(2)) {
            n = 2;
        } else if (calendar.get(5) != calendar2.get(5)) {
            n = 5;
        } else if (calendar.get(9) != calendar2.get(9)) {
            n = 9;
        } else if (calendar.get(10) != calendar2.get(10)) {
            n = 10;
        } else if (calendar.get(12) != calendar2.get(12)) {
            n = 12;
        } else {
            return this.fDateFormat.format(calendar, stringBuffer, fieldPosition);
        }
        DateIntervalInfo.PatternInfo patternInfo = this.fIntervalPatterns.get(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[n]);
        if (patternInfo == null) {
            if (this.fDateFormat.isFieldUnitIgnored(n)) {
                return this.fDateFormat.format(calendar, stringBuffer, fieldPosition);
            }
            return this.fallbackFormat(calendar, calendar2, stringBuffer, fieldPosition);
        }
        if (patternInfo.getFirstPart() == null) {
            return this.fallbackFormat(calendar, calendar2, stringBuffer, fieldPosition, patternInfo.getSecondPart());
        }
        if (patternInfo.firstDateInPtnIsLaterDate()) {
            calendar4 = calendar2;
            calendar3 = calendar;
        } else {
            calendar4 = calendar;
            calendar3 = calendar2;
        }
        String string = this.fDateFormat.toPattern();
        this.fDateFormat.applyPattern(patternInfo.getFirstPart());
        this.fDateFormat.format(calendar4, stringBuffer, fieldPosition);
        if (patternInfo.getSecondPart() != null) {
            this.fDateFormat.applyPattern(patternInfo.getSecondPart());
            this.fDateFormat.format(calendar3, stringBuffer, fieldPosition);
        }
        this.fDateFormat.applyPattern(string);
        return stringBuffer;
    }

    private final StringBuffer fallbackFormat(Calendar calendar, Calendar calendar2, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        StringBuffer stringBuffer2 = new StringBuffer(64);
        stringBuffer2 = this.fDateFormat.format(calendar, stringBuffer2, fieldPosition);
        StringBuffer stringBuffer3 = new StringBuffer(64);
        stringBuffer3 = this.fDateFormat.format(calendar2, stringBuffer3, fieldPosition);
        String string = this.fInfo.getFallbackIntervalPattern();
        String string2 = MessageFormat.format(string, stringBuffer2.toString(), stringBuffer3.toString());
        stringBuffer.append(string2);
        return stringBuffer;
    }

    private final StringBuffer fallbackFormat(Calendar calendar, Calendar calendar2, StringBuffer stringBuffer, FieldPosition fieldPosition, String string) {
        String string2 = this.fDateFormat.toPattern();
        this.fDateFormat.applyPattern(string);
        this.fallbackFormat(calendar, calendar2, stringBuffer, fieldPosition);
        this.fDateFormat.applyPattern(string2);
        return stringBuffer;
    }

    @Override
    public Object parseObject(String string, ParsePosition parsePosition) {
        throw new UnsupportedOperationException("parsing is not supported");
    }

    public DateIntervalInfo getDateIntervalInfo() {
        return (DateIntervalInfo)this.fInfo.clone();
    }

    public void setDateIntervalInfo(DateIntervalInfo dateIntervalInfo) {
        this.fInfo = (DateIntervalInfo)dateIntervalInfo.clone();
        this.isDateIntervalInfoDefault = false;
        this.fInfo.freeze();
        if (this.fDateFormat != null) {
            this.initializePattern(null);
        }
    }

    public DateFormat getDateFormat() {
        return (DateFormat)this.fDateFormat.clone();
    }

    private void initializePattern(ICUCache<String, Map<String, DateIntervalInfo.PatternInfo>> iCUCache) {
        String string = this.fDateFormat.toPattern();
        ULocale uLocale = this.fDateFormat.getLocale();
        String string2 = null;
        Map<String, DateIntervalInfo.PatternInfo> map = null;
        if (iCUCache != null) {
            string2 = this.fSkeleton != null ? uLocale.toString() + "+" + string + "+" + this.fSkeleton : uLocale.toString() + "+" + string;
            map = iCUCache.get(string2);
        }
        if (map == null) {
            Map<String, DateIntervalInfo.PatternInfo> map2 = this.initializeIntervalPattern(string, uLocale);
            map = Collections.unmodifiableMap(map2);
            if (iCUCache != null) {
                iCUCache.put(string2, map);
            }
        }
        this.fIntervalPatterns = map;
    }

    private Map<String, DateIntervalInfo.PatternInfo> initializeIntervalPattern(String string, ULocale uLocale) {
        DateTimePatternGenerator dateTimePatternGenerator = DateTimePatternGenerator.getInstance(uLocale);
        if (this.fSkeleton == null) {
            this.fSkeleton = dateTimePatternGenerator.getSkeleton(string);
        }
        String string2 = this.fSkeleton;
        HashMap<String, DateIntervalInfo.PatternInfo> hashMap = new HashMap<String, DateIntervalInfo.PatternInfo>();
        StringBuilder stringBuilder = new StringBuilder(string2.length());
        StringBuilder stringBuilder2 = new StringBuilder(string2.length());
        StringBuilder stringBuilder3 = new StringBuilder(string2.length());
        StringBuilder stringBuilder4 = new StringBuilder(string2.length());
        DateIntervalFormat.getDateTimeSkeleton(string2, stringBuilder, stringBuilder2, stringBuilder3, stringBuilder4);
        String string3 = stringBuilder.toString();
        String string4 = stringBuilder3.toString();
        String string5 = stringBuilder2.toString();
        String string6 = stringBuilder4.toString();
        boolean bl = this.genSeparateDateTimePtn(string5, string6, hashMap);
        if (!bl) {
            if (stringBuilder3.length() != 0 && stringBuilder.length() == 0) {
                string4 = "yMd" + string4;
                String string7 = dateTimePatternGenerator.getBestPattern(string4);
                DateIntervalInfo.PatternInfo patternInfo = new DateIntervalInfo.PatternInfo(null, string7, this.fInfo.getDefaultOrder());
                hashMap.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[5], patternInfo);
                hashMap.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[2], patternInfo);
                hashMap.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[1], patternInfo);
            }
            return hashMap;
        }
        if (stringBuilder3.length() != 0) {
            if (stringBuilder.length() == 0) {
                string4 = "yMd" + string4;
                String string8 = dateTimePatternGenerator.getBestPattern(string4);
                DateIntervalInfo.PatternInfo patternInfo = new DateIntervalInfo.PatternInfo(null, string8, this.fInfo.getDefaultOrder());
                hashMap.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[5], patternInfo);
                hashMap.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[2], patternInfo);
                hashMap.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[1], patternInfo);
            } else {
                if (!DateIntervalFormat.fieldExistsInSkeleton(5, string3)) {
                    string2 = DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[5] + string2;
                    this.genFallbackPattern(5, string2, hashMap, dateTimePatternGenerator);
                }
                if (!DateIntervalFormat.fieldExistsInSkeleton(2, string3)) {
                    string2 = DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[2] + string2;
                    this.genFallbackPattern(2, string2, hashMap, dateTimePatternGenerator);
                }
                if (!DateIntervalFormat.fieldExistsInSkeleton(1, string3)) {
                    string2 = DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[1] + string2;
                    this.genFallbackPattern(1, string2, hashMap, dateTimePatternGenerator);
                }
                CalendarData calendarData = new CalendarData(uLocale, null);
                String[] stringArray = calendarData.getDateTimePatterns();
                String string9 = dateTimePatternGenerator.getBestPattern(string3);
                this.concatSingleDate2TimeInterval(stringArray[8], string9, 9, hashMap);
                this.concatSingleDate2TimeInterval(stringArray[8], string9, 10, hashMap);
                this.concatSingleDate2TimeInterval(stringArray[8], string9, 12, hashMap);
            }
        }
        return hashMap;
    }

    private void genFallbackPattern(int n, String string, Map<String, DateIntervalInfo.PatternInfo> map, DateTimePatternGenerator dateTimePatternGenerator) {
        String string2 = dateTimePatternGenerator.getBestPattern(string);
        DateIntervalInfo.PatternInfo patternInfo = new DateIntervalInfo.PatternInfo(null, string2, this.fInfo.getDefaultOrder());
        map.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[n], patternInfo);
    }

    private static void getDateTimeSkeleton(String string, StringBuilder stringBuilder, StringBuilder stringBuilder2, StringBuilder stringBuilder3, StringBuilder stringBuilder4) {
        int n;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        block14: for (n = 0; n < string.length(); ++n) {
            char c = string.charAt(n);
            switch (c) {
                case 'E': {
                    stringBuilder.append(c);
                    ++n2;
                    continue block14;
                }
                case 'd': {
                    stringBuilder.append(c);
                    ++n3;
                    continue block14;
                }
                case 'M': {
                    stringBuilder.append(c);
                    ++n4;
                    continue block14;
                }
                case 'y': {
                    stringBuilder.append(c);
                    ++n5;
                    continue block14;
                }
                case 'D': 
                case 'F': 
                case 'G': 
                case 'L': 
                case 'Q': 
                case 'W': 
                case 'Y': 
                case 'c': 
                case 'e': 
                case 'g': 
                case 'l': 
                case 'q': 
                case 'u': 
                case 'w': {
                    stringBuilder2.append(c);
                    stringBuilder.append(c);
                    continue block14;
                }
                case 'a': {
                    stringBuilder3.append(c);
                    continue block14;
                }
                case 'h': {
                    stringBuilder3.append(c);
                    ++n6;
                    continue block14;
                }
                case 'H': {
                    stringBuilder3.append(c);
                    ++n7;
                    continue block14;
                }
                case 'm': {
                    stringBuilder3.append(c);
                    ++n8;
                    continue block14;
                }
                case 'z': {
                    ++n10;
                    stringBuilder3.append(c);
                    continue block14;
                }
                case 'v': {
                    ++n9;
                    stringBuilder3.append(c);
                    continue block14;
                }
                case 'A': 
                case 'K': 
                case 'S': 
                case 'V': 
                case 'Z': 
                case 'j': 
                case 'k': 
                case 's': {
                    stringBuilder3.append(c);
                    stringBuilder4.append(c);
                }
            }
        }
        if (n5 != 0) {
            stringBuilder2.append('y');
        }
        if (n4 != 0) {
            if (n4 < 3) {
                stringBuilder2.append('M');
            } else {
                for (n = 0; n < n4 && n < 5; ++n) {
                    stringBuilder2.append('M');
                }
            }
        }
        if (n2 != 0) {
            if (n2 <= 3) {
                stringBuilder2.append('E');
            } else {
                for (n = 0; n < n2 && n < 5; ++n) {
                    stringBuilder2.append('E');
                }
            }
        }
        if (n3 != 0) {
            stringBuilder2.append('d');
        }
        if (n7 != 0) {
            stringBuilder4.append('H');
        } else if (n6 != 0) {
            stringBuilder4.append('h');
        }
        if (n8 != 0) {
            stringBuilder4.append('m');
        }
        if (n10 != 0) {
            stringBuilder4.append('z');
        }
        if (n9 != 0) {
            stringBuilder4.append('v');
        }
    }

    private boolean genSeparateDateTimePtn(String string, String string2, Map<String, DateIntervalInfo.PatternInfo> map) {
        String string3 = string2.length() != 0 ? string2 : string;
        BestMatchInfo bestMatchInfo = this.fInfo.getBestSkeleton(string3);
        String string4 = bestMatchInfo.bestMatchSkeleton;
        int n = bestMatchInfo.bestMatchDistanceInfo;
        if (n == -1) {
            return false;
        }
        if (string2.length() == 0) {
            this.genIntervalPattern(5, string3, string4, n, map);
            SkeletonAndItsBestMatch skeletonAndItsBestMatch = this.genIntervalPattern(2, string3, string4, n, map);
            if (skeletonAndItsBestMatch != null) {
                string4 = skeletonAndItsBestMatch.skeleton;
                string3 = skeletonAndItsBestMatch.bestMatchSkeleton;
            }
            this.genIntervalPattern(1, string3, string4, n, map);
        } else {
            this.genIntervalPattern(12, string3, string4, n, map);
            this.genIntervalPattern(10, string3, string4, n, map);
            this.genIntervalPattern(9, string3, string4, n, map);
        }
        return true;
    }

    private SkeletonAndItsBestMatch genIntervalPattern(int n, String string, String string2, int n2, Map<String, DateIntervalInfo.PatternInfo> map) {
        Object object;
        String string3;
        SkeletonAndItsBestMatch skeletonAndItsBestMatch = null;
        DateIntervalInfo.PatternInfo patternInfo = this.fInfo.getIntervalPattern(string2, n);
        if (patternInfo == null) {
            if (SimpleDateFormat.isFieldUnitIgnored(string2, n)) {
                DateIntervalInfo.PatternInfo patternInfo2 = new DateIntervalInfo.PatternInfo(this.fDateFormat.toPattern(), null, this.fInfo.getDefaultOrder());
                map.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[n], patternInfo2);
                return null;
            }
            if (n == 9) {
                patternInfo = this.fInfo.getIntervalPattern(string2, 10);
                if (patternInfo != null) {
                    map.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[n], patternInfo);
                }
                return null;
            }
            string3 = DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[n];
            string2 = string3 + string2;
            string = string3 + string;
            patternInfo = this.fInfo.getIntervalPattern(string2, n);
            if (patternInfo == null && n2 == 0) {
                object = this.fInfo.getBestSkeleton(string);
                String string4 = ((BestMatchInfo)object).bestMatchSkeleton;
                n2 = ((BestMatchInfo)object).bestMatchDistanceInfo;
                if (string4.length() != 0 && n2 != -1) {
                    patternInfo = this.fInfo.getIntervalPattern(string4, n);
                    string2 = string4;
                }
            }
            if (patternInfo != null) {
                skeletonAndItsBestMatch = new SkeletonAndItsBestMatch(string, string2);
            }
        }
        if (patternInfo != null) {
            if (n2 != 0) {
                string3 = DateIntervalFormat.adjustFieldWidth(string, string2, patternInfo.getFirstPart(), n2);
                object = DateIntervalFormat.adjustFieldWidth(string, string2, patternInfo.getSecondPart(), n2);
                patternInfo = new DateIntervalInfo.PatternInfo(string3, (String)object, patternInfo.firstDateInPtnIsLaterDate());
            }
            map.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[n], patternInfo);
        }
        return skeletonAndItsBestMatch;
    }

    private static String adjustFieldWidth(String string, String string2, String string3, int n) {
        int n2;
        int n3;
        int n4;
        int n5;
        if (string3 == null) {
            return null;
        }
        int[] nArray = new int[58];
        int[] nArray2 = new int[58];
        DateIntervalInfo.parseSkeleton(string, nArray);
        DateIntervalInfo.parseSkeleton(string2, nArray2);
        if (n == 2) {
            string3 = string3.replace('v', 'z');
        }
        StringBuilder stringBuilder = new StringBuilder(string3);
        boolean bl = false;
        int n6 = 0;
        int n7 = 0;
        int n8 = 65;
        int n9 = stringBuilder.length();
        for (n5 = 0; n5 < n9; ++n5) {
            n4 = stringBuilder.charAt(n5);
            if (n4 != n6 && n7 > 0) {
                n3 = n6;
                if (n3 == 76) {
                    n3 = 77;
                }
                n2 = nArray2[n3 - n8];
                int n10 = nArray[n3 - n8];
                if (n2 == n7 && n10 > n2) {
                    n7 = n10 - n2;
                    for (int i = 0; i < n7; ++i) {
                        stringBuilder.insert(n5, (char)n6);
                    }
                    n5 += n7;
                    n9 += n7;
                }
                n7 = 0;
            }
            if (n4 == 39) {
                if (n5 + 1 < stringBuilder.length() && stringBuilder.charAt(n5 + 1) == '\'') {
                    ++n5;
                    continue;
                }
                bl = !bl;
                continue;
            }
            if (bl || (n4 < 97 || n4 > 122) && (n4 < 65 || n4 > 90)) continue;
            n6 = n4;
            ++n7;
        }
        if (n7 > 0) {
            n5 = n6;
            if (n5 == 76) {
                n5 = 77;
            }
            n4 = nArray2[n5 - n8];
            n3 = nArray[n5 - n8];
            if (n4 == n7 && n3 > n4) {
                n7 = n3 - n4;
                for (n2 = 0; n2 < n7; ++n2) {
                    stringBuilder.append((char)n6);
                }
            }
        }
        return stringBuilder.toString();
    }

    private void concatSingleDate2TimeInterval(String string, String string2, int n, Map<String, DateIntervalInfo.PatternInfo> map) {
        DateIntervalInfo.PatternInfo patternInfo = map.get(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[n]);
        if (patternInfo != null) {
            String string3 = patternInfo.getFirstPart() + patternInfo.getSecondPart();
            String string4 = MessageFormat.format(string, string3, string2);
            patternInfo = DateIntervalInfo.genPatternInfo(string4, patternInfo.firstDateInPtnIsLaterDate());
            map.put(DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[n], patternInfo);
        }
    }

    private static boolean fieldExistsInSkeleton(int n, String string) {
        String string2 = DateIntervalInfo.CALENDAR_FIELD_TO_PATTERN_LETTER[n];
        return string.indexOf(string2) != -1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.initializePattern(this.isDateIntervalInfoDefault ? LOCAL_PATTERN_CACHE : null);
    }

    private static final class SkeletonAndItsBestMatch {
        final String skeleton;
        final String bestMatchSkeleton;

        SkeletonAndItsBestMatch(String string, String string2) {
            this.skeleton = string;
            this.bestMatchSkeleton = string2;
        }
    }

    public static final class BestMatchInfo {
        final String bestMatchSkeleton;
        final int bestMatchDistanceInfo;

        BestMatchInfo(String string, int n) {
            this.bestMatchSkeleton = string;
            this.bestMatchDistanceInfo = n;
        }
    }
}

