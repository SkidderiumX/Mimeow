/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.CalendarData;
import com.ibm.icu.impl.CalendarUtil;
import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.text.TimeZoneNames;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DateFormatSymbols
implements Serializable,
Cloneable {
    public static final int FORMAT = 0;
    public static final int STANDALONE = 1;
    public static final int DT_CONTEXT_COUNT = 2;
    public static final int ABBREVIATED = 0;
    public static final int WIDE = 1;
    public static final int NARROW = 2;
    public static final int SHORT = 3;
    public static final int DT_WIDTH_COUNT = 4;
    static final int DT_LEAP_MONTH_PATTERN_FORMAT_WIDE = 0;
    static final int DT_LEAP_MONTH_PATTERN_FORMAT_ABBREV = 1;
    static final int DT_LEAP_MONTH_PATTERN_FORMAT_NARROW = 2;
    static final int DT_LEAP_MONTH_PATTERN_STANDALONE_WIDE = 3;
    static final int DT_LEAP_MONTH_PATTERN_STANDALONE_ABBREV = 4;
    static final int DT_LEAP_MONTH_PATTERN_STANDALONE_NARROW = 5;
    static final int DT_LEAP_MONTH_PATTERN_NUMERIC = 6;
    static final int DT_MONTH_PATTERN_COUNT = 7;
    String[] eras = null;
    String[] eraNames = null;
    String[] narrowEras = null;
    String[] months = null;
    String[] shortMonths = null;
    String[] narrowMonths = null;
    String[] standaloneMonths = null;
    String[] standaloneShortMonths = null;
    String[] standaloneNarrowMonths = null;
    String[] weekdays = null;
    String[] shortWeekdays = null;
    String[] shorterWeekdays = null;
    String[] narrowWeekdays = null;
    String[] standaloneWeekdays = null;
    String[] standaloneShortWeekdays = null;
    String[] standaloneShorterWeekdays = null;
    String[] standaloneNarrowWeekdays = null;
    String[] ampms = null;
    String[] shortQuarters = null;
    String[] quarters = null;
    String[] standaloneShortQuarters = null;
    String[] standaloneQuarters = null;
    String[] leapMonthPatterns = null;
    String[] shortYearNames = null;
    private String[][] zoneStrings = null;
    static final String patternChars = "GyMdkHmsSEDFwWahKzYeugAZvcLQqVUOXx";
    String localPatternChars = null;
    private static final long serialVersionUID = -5987973545549424702L;
    private static final String[][] CALENDAR_CLASSES = new String[][]{{"GregorianCalendar", "gregorian"}, {"JapaneseCalendar", "japanese"}, {"BuddhistCalendar", "buddhist"}, {"TaiwanCalendar", "roc"}, {"PersianCalendar", "persian"}, {"IslamicCalendar", "islamic"}, {"HebrewCalendar", "hebrew"}, {"ChineseCalendar", "chinese"}, {"IndianCalendar", "indian"}, {"CopticCalendar", "coptic"}, {"EthiopicCalendar", "ethiopic"}};
    private static final Map<String, CapitalizationContextUsage> contextUsageTypeMap = new HashMap<String, CapitalizationContextUsage>();
    Map<CapitalizationContextUsage, boolean[]> capitalization = null;
    static final int millisPerHour = 3600000;
    private static ICUCache<String, DateFormatSymbols> DFSCACHE;
    private ULocale requestedLocale;
    private ULocale validLocale;
    private ULocale actualLocale;

    public DateFormatSymbols() {
        this(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public DateFormatSymbols(Locale locale) {
        this(ULocale.forLocale(locale));
    }

    public DateFormatSymbols(ULocale uLocale) {
        this.initializeData(uLocale, CalendarUtil.getCalendarType(uLocale));
    }

    public static DateFormatSymbols getInstance() {
        return new DateFormatSymbols();
    }

    public static DateFormatSymbols getInstance(Locale locale) {
        return new DateFormatSymbols(locale);
    }

    public static DateFormatSymbols getInstance(ULocale uLocale) {
        return new DateFormatSymbols(uLocale);
    }

    public static Locale[] getAvailableLocales() {
        return ICUResourceBundle.getAvailableLocales();
    }

    public static ULocale[] getAvailableULocales() {
        return ICUResourceBundle.getAvailableULocales();
    }

    public String[] getEras() {
        return this.duplicate(this.eras);
    }

    public void setEras(String[] stringArray) {
        this.eras = this.duplicate(stringArray);
    }

    public String[] getEraNames() {
        return this.duplicate(this.eraNames);
    }

    public void setEraNames(String[] stringArray) {
        this.eraNames = this.duplicate(stringArray);
    }

    public String[] getMonths() {
        return this.duplicate(this.months);
    }

    public String[] getMonths(int n, int n2) {
        String[] stringArray = null;
        block0 : switch (n) {
            case 0: {
                switch (n2) {
                    case 1: {
                        stringArray = this.months;
                        break;
                    }
                    case 0: 
                    case 3: {
                        stringArray = this.shortMonths;
                        break;
                    }
                    case 2: {
                        stringArray = this.narrowMonths;
                    }
                }
                break;
            }
            case 1: {
                switch (n2) {
                    case 1: {
                        stringArray = this.standaloneMonths;
                        break block0;
                    }
                    case 0: 
                    case 3: {
                        stringArray = this.standaloneShortMonths;
                        break block0;
                    }
                    case 2: {
                        stringArray = this.standaloneNarrowMonths;
                    }
                }
            }
        }
        return this.duplicate(stringArray);
    }

    public void setMonths(String[] stringArray) {
        this.months = this.duplicate(stringArray);
    }

    public void setMonths(String[] stringArray, int n, int n2) {
        block0 : switch (n) {
            case 0: {
                switch (n2) {
                    case 1: {
                        this.months = this.duplicate(stringArray);
                        break block0;
                    }
                    case 0: {
                        this.shortMonths = this.duplicate(stringArray);
                        break block0;
                    }
                    case 2: {
                        this.narrowMonths = this.duplicate(stringArray);
                        break block0;
                    }
                }
                break;
            }
            case 1: {
                switch (n2) {
                    case 1: {
                        this.standaloneMonths = this.duplicate(stringArray);
                        break block0;
                    }
                    case 0: {
                        this.standaloneShortMonths = this.duplicate(stringArray);
                        break block0;
                    }
                    case 2: {
                        this.standaloneNarrowMonths = this.duplicate(stringArray);
                        break block0;
                    }
                }
            }
        }
    }

    public String[] getShortMonths() {
        return this.duplicate(this.shortMonths);
    }

    public void setShortMonths(String[] stringArray) {
        this.shortMonths = this.duplicate(stringArray);
    }

    public String[] getWeekdays() {
        return this.duplicate(this.weekdays);
    }

    public String[] getWeekdays(int n, int n2) {
        String[] stringArray = null;
        block0 : switch (n) {
            case 0: {
                switch (n2) {
                    case 1: {
                        stringArray = this.weekdays;
                        break;
                    }
                    case 0: {
                        stringArray = this.shortWeekdays;
                        break;
                    }
                    case 3: {
                        stringArray = this.shorterWeekdays != null ? this.shorterWeekdays : this.shortWeekdays;
                        break;
                    }
                    case 2: {
                        stringArray = this.narrowWeekdays;
                    }
                }
                break;
            }
            case 1: {
                switch (n2) {
                    case 1: {
                        stringArray = this.standaloneWeekdays;
                        break block0;
                    }
                    case 0: {
                        stringArray = this.standaloneShortWeekdays;
                        break block0;
                    }
                    case 3: {
                        stringArray = this.standaloneShorterWeekdays != null ? this.standaloneShorterWeekdays : this.standaloneShortWeekdays;
                        break block0;
                    }
                    case 2: {
                        stringArray = this.standaloneNarrowWeekdays;
                    }
                }
            }
        }
        return this.duplicate(stringArray);
    }

    public void setWeekdays(String[] stringArray, int n, int n2) {
        block0 : switch (n) {
            case 0: {
                switch (n2) {
                    case 1: {
                        this.weekdays = this.duplicate(stringArray);
                        break;
                    }
                    case 0: {
                        this.shortWeekdays = this.duplicate(stringArray);
                        break;
                    }
                    case 3: {
                        this.shorterWeekdays = this.duplicate(stringArray);
                        break;
                    }
                    case 2: {
                        this.narrowWeekdays = this.duplicate(stringArray);
                    }
                }
                break;
            }
            case 1: {
                switch (n2) {
                    case 1: {
                        this.standaloneWeekdays = this.duplicate(stringArray);
                        break block0;
                    }
                    case 0: {
                        this.standaloneShortWeekdays = this.duplicate(stringArray);
                        break block0;
                    }
                    case 3: {
                        this.standaloneShorterWeekdays = this.duplicate(stringArray);
                        break block0;
                    }
                    case 2: {
                        this.standaloneNarrowWeekdays = this.duplicate(stringArray);
                    }
                }
            }
        }
    }

    public void setWeekdays(String[] stringArray) {
        this.weekdays = this.duplicate(stringArray);
    }

    public String[] getShortWeekdays() {
        return this.duplicate(this.shortWeekdays);
    }

    public void setShortWeekdays(String[] stringArray) {
        this.shortWeekdays = this.duplicate(stringArray);
    }

    public String[] getQuarters(int n, int n2) {
        String[] stringArray = null;
        block0 : switch (n) {
            case 0: {
                switch (n2) {
                    case 1: {
                        stringArray = this.quarters;
                        break;
                    }
                    case 0: 
                    case 3: {
                        stringArray = this.shortQuarters;
                        break;
                    }
                    case 2: {
                        stringArray = null;
                    }
                }
                break;
            }
            case 1: {
                switch (n2) {
                    case 1: {
                        stringArray = this.standaloneQuarters;
                        break block0;
                    }
                    case 0: 
                    case 3: {
                        stringArray = this.standaloneShortQuarters;
                        break block0;
                    }
                    case 2: {
                        stringArray = null;
                    }
                }
            }
        }
        return this.duplicate(stringArray);
    }

    public void setQuarters(String[] stringArray, int n, int n2) {
        block0 : switch (n) {
            case 0: {
                switch (n2) {
                    case 1: {
                        this.quarters = this.duplicate(stringArray);
                        break block0;
                    }
                    case 0: {
                        this.shortQuarters = this.duplicate(stringArray);
                        break block0;
                    }
                    case 2: {
                        break block0;
                    }
                }
                break;
            }
            case 1: {
                switch (n2) {
                    case 1: {
                        this.standaloneQuarters = this.duplicate(stringArray);
                        break block0;
                    }
                    case 0: {
                        this.standaloneShortQuarters = this.duplicate(stringArray);
                        break block0;
                    }
                    case 2: {
                        break block0;
                    }
                }
            }
        }
    }

    public String[] getAmPmStrings() {
        return this.duplicate(this.ampms);
    }

    public void setAmPmStrings(String[] stringArray) {
        this.ampms = this.duplicate(stringArray);
    }

    public String[][] getZoneStrings() {
        if (this.zoneStrings != null) {
            return this.duplicate(this.zoneStrings);
        }
        String[] stringArray = TimeZone.getAvailableIDs();
        TimeZoneNames timeZoneNames = TimeZoneNames.getInstance(this.validLocale);
        long l = System.currentTimeMillis();
        String[][] stringArray2 = new String[stringArray.length][5];
        for (int i = 0; i < stringArray.length; ++i) {
            String string = TimeZone.getCanonicalID(stringArray[i]);
            if (string == null) {
                string = stringArray[i];
            }
            stringArray2[i][0] = stringArray[i];
            stringArray2[i][1] = timeZoneNames.getDisplayName(string, TimeZoneNames.NameType.LONG_STANDARD, l);
            stringArray2[i][2] = timeZoneNames.getDisplayName(string, TimeZoneNames.NameType.SHORT_STANDARD, l);
            stringArray2[i][3] = timeZoneNames.getDisplayName(string, TimeZoneNames.NameType.LONG_DAYLIGHT, l);
            stringArray2[i][4] = timeZoneNames.getDisplayName(string, TimeZoneNames.NameType.SHORT_DAYLIGHT, l);
        }
        this.zoneStrings = stringArray2;
        return this.zoneStrings;
    }

    public void setZoneStrings(String[][] stringArray) {
        this.zoneStrings = this.duplicate(stringArray);
    }

    public String getLocalPatternChars() {
        return this.localPatternChars;
    }

    public void setLocalPatternChars(String string) {
        this.localPatternChars = string;
    }

    public Object clone() {
        try {
            DateFormatSymbols dateFormatSymbols = (DateFormatSymbols)super.clone();
            return dateFormatSymbols;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new IllegalStateException();
        }
    }

    public int hashCode() {
        return this.requestedLocale.toString().hashCode();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        DateFormatSymbols dateFormatSymbols = (DateFormatSymbols)object;
        return Utility.arrayEquals(this.eras, (Object)dateFormatSymbols.eras) && Utility.arrayEquals(this.eraNames, (Object)dateFormatSymbols.eraNames) && Utility.arrayEquals(this.months, (Object)dateFormatSymbols.months) && Utility.arrayEquals(this.shortMonths, (Object)dateFormatSymbols.shortMonths) && Utility.arrayEquals(this.narrowMonths, (Object)dateFormatSymbols.narrowMonths) && Utility.arrayEquals(this.standaloneMonths, (Object)dateFormatSymbols.standaloneMonths) && Utility.arrayEquals(this.standaloneShortMonths, (Object)dateFormatSymbols.standaloneShortMonths) && Utility.arrayEquals(this.standaloneNarrowMonths, (Object)dateFormatSymbols.standaloneNarrowMonths) && Utility.arrayEquals(this.weekdays, (Object)dateFormatSymbols.weekdays) && Utility.arrayEquals(this.shortWeekdays, (Object)dateFormatSymbols.shortWeekdays) && Utility.arrayEquals(this.shorterWeekdays, (Object)dateFormatSymbols.shorterWeekdays) && Utility.arrayEquals(this.narrowWeekdays, (Object)dateFormatSymbols.narrowWeekdays) && Utility.arrayEquals(this.standaloneWeekdays, (Object)dateFormatSymbols.standaloneWeekdays) && Utility.arrayEquals(this.standaloneShortWeekdays, (Object)dateFormatSymbols.standaloneShortWeekdays) && Utility.arrayEquals(this.standaloneShorterWeekdays, (Object)dateFormatSymbols.standaloneShorterWeekdays) && Utility.arrayEquals(this.standaloneNarrowWeekdays, (Object)dateFormatSymbols.standaloneNarrowWeekdays) && Utility.arrayEquals(this.ampms, (Object)dateFormatSymbols.ampms) && DateFormatSymbols.arrayOfArrayEquals(this.zoneStrings, dateFormatSymbols.zoneStrings) && this.requestedLocale.getDisplayName().equals(dateFormatSymbols.requestedLocale.getDisplayName()) && Utility.arrayEquals(this.localPatternChars, (Object)dateFormatSymbols.localPatternChars);
    }

    protected void initializeData(ULocale uLocale, String string) {
        String string2 = uLocale.getBaseName() + "+" + string;
        DateFormatSymbols dateFormatSymbols = DFSCACHE.get(string2);
        if (dateFormatSymbols == null) {
            CalendarData calendarData = new CalendarData(uLocale, string);
            this.initializeData(uLocale, calendarData);
            if (this.getClass().getName().equals("com.ibm.icu.text.DateFormatSymbols")) {
                dateFormatSymbols = (DateFormatSymbols)this.clone();
                DFSCACHE.put(string2, dateFormatSymbols);
            }
        } else {
            this.initializeData(dateFormatSymbols);
        }
    }

    void initializeData(DateFormatSymbols dateFormatSymbols) {
        this.eras = dateFormatSymbols.eras;
        this.eraNames = dateFormatSymbols.eraNames;
        this.narrowEras = dateFormatSymbols.narrowEras;
        this.months = dateFormatSymbols.months;
        this.shortMonths = dateFormatSymbols.shortMonths;
        this.narrowMonths = dateFormatSymbols.narrowMonths;
        this.standaloneMonths = dateFormatSymbols.standaloneMonths;
        this.standaloneShortMonths = dateFormatSymbols.standaloneShortMonths;
        this.standaloneNarrowMonths = dateFormatSymbols.standaloneNarrowMonths;
        this.weekdays = dateFormatSymbols.weekdays;
        this.shortWeekdays = dateFormatSymbols.shortWeekdays;
        this.shorterWeekdays = dateFormatSymbols.shorterWeekdays;
        this.narrowWeekdays = dateFormatSymbols.narrowWeekdays;
        this.standaloneWeekdays = dateFormatSymbols.standaloneWeekdays;
        this.standaloneShortWeekdays = dateFormatSymbols.standaloneShortWeekdays;
        this.standaloneShorterWeekdays = dateFormatSymbols.standaloneShorterWeekdays;
        this.standaloneNarrowWeekdays = dateFormatSymbols.standaloneNarrowWeekdays;
        this.ampms = dateFormatSymbols.ampms;
        this.shortQuarters = dateFormatSymbols.shortQuarters;
        this.quarters = dateFormatSymbols.quarters;
        this.standaloneShortQuarters = dateFormatSymbols.standaloneShortQuarters;
        this.standaloneQuarters = dateFormatSymbols.standaloneQuarters;
        this.leapMonthPatterns = dateFormatSymbols.leapMonthPatterns;
        this.shortYearNames = dateFormatSymbols.shortYearNames;
        this.zoneStrings = dateFormatSymbols.zoneStrings;
        this.localPatternChars = dateFormatSymbols.localPatternChars;
        this.capitalization = dateFormatSymbols.capitalization;
        this.actualLocale = dateFormatSymbols.actualLocale;
        this.validLocale = dateFormatSymbols.validLocale;
        this.requestedLocale = dateFormatSymbols.requestedLocale;
    }

    protected void initializeData(ULocale uLocale, CalendarData calendarData) {
        this.eras = calendarData.getEras("abbreviated");
        this.eraNames = calendarData.getEras("wide");
        this.narrowEras = calendarData.getEras("narrow");
        this.months = calendarData.getStringArray("monthNames", "wide");
        this.shortMonths = calendarData.getStringArray("monthNames", "abbreviated");
        this.narrowMonths = calendarData.getStringArray("monthNames", "narrow");
        this.standaloneMonths = calendarData.getStringArray("monthNames", "stand-alone", "wide");
        this.standaloneShortMonths = calendarData.getStringArray("monthNames", "stand-alone", "abbreviated");
        this.standaloneNarrowMonths = calendarData.getStringArray("monthNames", "stand-alone", "narrow");
        String[] stringArray = calendarData.getStringArray("dayNames", "wide");
        this.weekdays = new String[8];
        this.weekdays[0] = "";
        System.arraycopy(stringArray, 0, this.weekdays, 1, stringArray.length);
        String[] stringArray2 = calendarData.getStringArray("dayNames", "abbreviated");
        this.shortWeekdays = new String[8];
        this.shortWeekdays[0] = "";
        System.arraycopy(stringArray2, 0, this.shortWeekdays, 1, stringArray2.length);
        String[] stringArray3 = calendarData.getStringArray("dayNames", "short");
        this.shorterWeekdays = new String[8];
        this.shorterWeekdays[0] = "";
        System.arraycopy(stringArray3, 0, this.shorterWeekdays, 1, stringArray3.length);
        String[] stringArray4 = null;
        try {
            stringArray4 = calendarData.getStringArray("dayNames", "narrow");
        }
        catch (MissingResourceException missingResourceException) {
            try {
                stringArray4 = calendarData.getStringArray("dayNames", "stand-alone", "narrow");
            }
            catch (MissingResourceException missingResourceException2) {
                stringArray4 = calendarData.getStringArray("dayNames", "abbreviated");
            }
        }
        this.narrowWeekdays = new String[8];
        this.narrowWeekdays[0] = "";
        System.arraycopy(stringArray4, 0, this.narrowWeekdays, 1, stringArray4.length);
        String[] stringArray5 = null;
        stringArray5 = calendarData.getStringArray("dayNames", "stand-alone", "wide");
        this.standaloneWeekdays = new String[8];
        this.standaloneWeekdays[0] = "";
        System.arraycopy(stringArray5, 0, this.standaloneWeekdays, 1, stringArray5.length);
        String[] stringArray6 = null;
        stringArray6 = calendarData.getStringArray("dayNames", "stand-alone", "abbreviated");
        this.standaloneShortWeekdays = new String[8];
        this.standaloneShortWeekdays[0] = "";
        System.arraycopy(stringArray6, 0, this.standaloneShortWeekdays, 1, stringArray6.length);
        String[] stringArray7 = null;
        stringArray7 = calendarData.getStringArray("dayNames", "stand-alone", "short");
        this.standaloneShorterWeekdays = new String[8];
        this.standaloneShorterWeekdays[0] = "";
        System.arraycopy(stringArray7, 0, this.standaloneShorterWeekdays, 1, stringArray7.length);
        String[] stringArray8 = null;
        stringArray8 = calendarData.getStringArray("dayNames", "stand-alone", "narrow");
        this.standaloneNarrowWeekdays = new String[8];
        this.standaloneNarrowWeekdays[0] = "";
        System.arraycopy(stringArray8, 0, this.standaloneNarrowWeekdays, 1, stringArray8.length);
        this.ampms = calendarData.getStringArray("AmPmMarkers");
        this.quarters = calendarData.getStringArray("quarters", "wide");
        this.shortQuarters = calendarData.getStringArray("quarters", "abbreviated");
        this.standaloneQuarters = calendarData.getStringArray("quarters", "stand-alone", "wide");
        this.standaloneShortQuarters = calendarData.getStringArray("quarters", "stand-alone", "abbreviated");
        ICUResourceBundle iCUResourceBundle = null;
        try {
            iCUResourceBundle = calendarData.get("monthPatterns");
        }
        catch (MissingResourceException missingResourceException) {
            iCUResourceBundle = null;
        }
        if (iCUResourceBundle != null) {
            this.leapMonthPatterns = new String[7];
            this.leapMonthPatterns[0] = calendarData.get("monthPatterns", "wide").get("leap").getString();
            this.leapMonthPatterns[1] = calendarData.get("monthPatterns", "abbreviated").get("leap").getString();
            this.leapMonthPatterns[2] = calendarData.get("monthPatterns", "narrow").get("leap").getString();
            this.leapMonthPatterns[3] = calendarData.get("monthPatterns", "stand-alone", "wide").get("leap").getString();
            this.leapMonthPatterns[4] = calendarData.get("monthPatterns", "stand-alone", "abbreviated").get("leap").getString();
            this.leapMonthPatterns[5] = calendarData.get("monthPatterns", "stand-alone", "narrow").get("leap").getString();
            this.leapMonthPatterns[6] = calendarData.get("monthPatterns", "numeric", "all").get("leap").getString();
        }
        ICUResourceBundle iCUResourceBundle2 = null;
        try {
            iCUResourceBundle2 = calendarData.get("cyclicNameSets");
        }
        catch (MissingResourceException missingResourceException) {
            iCUResourceBundle2 = null;
        }
        if (iCUResourceBundle2 != null) {
            this.shortYearNames = calendarData.get("cyclicNameSets", "years", "format", "abbreviated").getStringArray();
        }
        this.requestedLocale = uLocale;
        ICUResourceBundle iCUResourceBundle3 = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale);
        this.localPatternChars = patternChars;
        ULocale uLocale2 = iCUResourceBundle3.getULocale();
        this.setLocale(uLocale2, uLocale2);
        this.capitalization = new HashMap<CapitalizationContextUsage, boolean[]>();
        boolean[] blArray = new boolean[]{false, false};
        CapitalizationContextUsage[] capitalizationContextUsageArray = CapitalizationContextUsage.values();
        for (Object object2 : capitalizationContextUsageArray) {
            this.capitalization.put((CapitalizationContextUsage)((Object)object2), blArray);
        }
        Object object = null;
        try {
            object = iCUResourceBundle3.getWithFallback("contextTransforms");
        }
        catch (MissingResourceException missingResourceException) {
            object = null;
        }
        if (object != null) {
            UResourceBundleIterator uResourceBundleIterator = ((UResourceBundle)object).getIterator();
            while (uResourceBundleIterator.hasNext()) {
                String string;
                CapitalizationContextUsage capitalizationContextUsage;
                Object object2;
                UResourceBundle uResourceBundle = uResourceBundleIterator.next();
                object2 = uResourceBundle.getIntVector();
                if (((CapitalizationContextUsage)object2).length < 2 || (capitalizationContextUsage = contextUsageTypeMap.get(string = uResourceBundle.getKey())) == null) continue;
                boolean[] blArray2 = new boolean[]{object2[0] != false, object2[1] != false};
                this.capitalization.put(capitalizationContextUsage, blArray2);
            }
        }
    }

    private static final boolean arrayOfArrayEquals(Object[][] objectArray, Object[][] objectArray2) {
        if (objectArray == objectArray2) {
            return true;
        }
        if (objectArray == null || objectArray2 == null) {
            return false;
        }
        if (objectArray.length != objectArray2.length) {
            return false;
        }
        boolean bl = true;
        for (int i = 0; i < objectArray.length && (bl = Utility.arrayEquals(objectArray[i], (Object)objectArray2[i])); ++i) {
        }
        return bl;
    }

    private final String[] duplicate(String[] stringArray) {
        return (String[])stringArray.clone();
    }

    private final String[][] duplicate(String[][] stringArray) {
        String[][] stringArray2 = new String[stringArray.length][];
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray2[i] = this.duplicate(stringArray[i]);
        }
        return stringArray2;
    }

    public DateFormatSymbols(Calendar calendar, Locale locale) {
        this.initializeData(ULocale.forLocale(locale), calendar.getType());
    }

    public DateFormatSymbols(Calendar calendar, ULocale uLocale) {
        this.initializeData(uLocale, calendar.getType());
    }

    public DateFormatSymbols(Class<? extends Calendar> clazz, Locale locale) {
        this(clazz, ULocale.forLocale(locale));
    }

    public DateFormatSymbols(Class<? extends Calendar> clazz, ULocale uLocale) {
        String string = clazz.getName();
        int n = string.lastIndexOf(46);
        String string2 = string.substring(n + 1);
        String string3 = null;
        for (String[] stringArray : CALENDAR_CLASSES) {
            if (!stringArray[0].equals(string2)) continue;
            string3 = stringArray[1];
            break;
        }
        if (string3 == null) {
            string3 = string2.replaceAll("Calendar", "").toLowerCase(Locale.ENGLISH);
        }
        this.initializeData(uLocale, string3);
    }

    public DateFormatSymbols(ResourceBundle resourceBundle, Locale locale) {
        this(resourceBundle, ULocale.forLocale(locale));
    }

    public DateFormatSymbols(ResourceBundle resourceBundle, ULocale uLocale) {
        this.initializeData(uLocale, new CalendarData((ICUResourceBundle)resourceBundle, CalendarUtil.getCalendarType(uLocale)));
    }

    public static ResourceBundle getDateFormatBundle(Class<? extends Calendar> clazz, Locale locale) throws MissingResourceException {
        return null;
    }

    public static ResourceBundle getDateFormatBundle(Class<? extends Calendar> clazz, ULocale uLocale) throws MissingResourceException {
        return null;
    }

    public static ResourceBundle getDateFormatBundle(Calendar calendar, Locale locale) throws MissingResourceException {
        return null;
    }

    public static ResourceBundle getDateFormatBundle(Calendar calendar, ULocale uLocale) throws MissingResourceException {
        return null;
    }

    public final ULocale getLocale(ULocale.Type type) {
        return type == ULocale.ACTUAL_LOCALE ? this.actualLocale : this.validLocale;
    }

    final void setLocale(ULocale uLocale, ULocale uLocale2) {
        if (uLocale == null != (uLocale2 == null)) {
            throw new IllegalArgumentException();
        }
        this.validLocale = uLocale;
        this.actualLocale = uLocale2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
    }

    static {
        contextUsageTypeMap.put("month-format-except-narrow", CapitalizationContextUsage.MONTH_FORMAT);
        contextUsageTypeMap.put("month-standalone-except-narrow", CapitalizationContextUsage.MONTH_STANDALONE);
        contextUsageTypeMap.put("month-narrow", CapitalizationContextUsage.MONTH_NARROW);
        contextUsageTypeMap.put("day-format-except-narrow", CapitalizationContextUsage.DAY_FORMAT);
        contextUsageTypeMap.put("day-standalone-except-narrow", CapitalizationContextUsage.DAY_STANDALONE);
        contextUsageTypeMap.put("day-narrow", CapitalizationContextUsage.DAY_NARROW);
        contextUsageTypeMap.put("era-name", CapitalizationContextUsage.ERA_WIDE);
        contextUsageTypeMap.put("era-abbr", CapitalizationContextUsage.ERA_ABBREV);
        contextUsageTypeMap.put("era-narrow", CapitalizationContextUsage.ERA_NARROW);
        contextUsageTypeMap.put("zone-long", CapitalizationContextUsage.ZONE_LONG);
        contextUsageTypeMap.put("zone-short", CapitalizationContextUsage.ZONE_SHORT);
        contextUsageTypeMap.put("metazone-long", CapitalizationContextUsage.METAZONE_LONG);
        contextUsageTypeMap.put("metazone-short", CapitalizationContextUsage.METAZONE_SHORT);
        DFSCACHE = new SimpleCache<String, DateFormatSymbols>();
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum CapitalizationContextUsage {
        OTHER,
        MONTH_FORMAT,
        MONTH_STANDALONE,
        MONTH_NARROW,
        DAY_FORMAT,
        DAY_STANDALONE,
        DAY_NARROW,
        ERA_WIDE,
        ERA_ABBREV,
        ERA_NARROW,
        ZONE_LONG,
        ZONE_SHORT,
        METAZONE_LONG,
        METAZONE_SHORT;

    }
}

