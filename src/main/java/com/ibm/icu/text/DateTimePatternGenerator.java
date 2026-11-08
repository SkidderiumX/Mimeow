/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.MessageFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DateTimePatternGenerator
implements Freezable<DateTimePatternGenerator>,
Cloneable {
    private static final boolean DEBUG = false;
    public static final int ERA = 0;
    public static final int YEAR = 1;
    public static final int QUARTER = 2;
    public static final int MONTH = 3;
    public static final int WEEK_OF_YEAR = 4;
    public static final int WEEK_OF_MONTH = 5;
    public static final int WEEKDAY = 6;
    public static final int DAY = 7;
    public static final int DAY_OF_YEAR = 8;
    public static final int DAY_OF_WEEK_IN_MONTH = 9;
    public static final int DAYPERIOD = 10;
    public static final int HOUR = 11;
    public static final int MINUTE = 12;
    public static final int SECOND = 13;
    public static final int FRACTIONAL_SECOND = 14;
    public static final int ZONE = 15;
    public static final int TYPE_LIMIT = 16;
    public static final int MATCH_NO_OPTIONS = 0;
    public static final int MATCH_HOUR_FIELD_LENGTH = 2048;
    public static final int MATCH_MINUTE_FIELD_LENGTH = 4096;
    public static final int MATCH_SECOND_FIELD_LENGTH = 8192;
    public static final int MATCH_ALL_FIELDS_LENGTH = 65535;
    private TreeMap<DateTimeMatcher, PatternWithSkeletonFlag> skeleton2pattern = new TreeMap();
    private TreeMap<String, PatternWithSkeletonFlag> basePattern_pattern = new TreeMap();
    private String decimal = "?";
    private String dateTimeFormat = "{1} {0}";
    private String[] appendItemFormats = new String[16];
    private String[] appendItemNames = new String[16];
    private char defaultHourFormatChar;
    private boolean frozen;
    private transient DateTimeMatcher current;
    private transient FormatParser fp;
    private transient DistanceInfo _distanceInfo;
    private static final int FRACTIONAL_MASK = 16384;
    private static final int SECOND_AND_FRACTIONAL_MASK = 24576;
    private static ICUCache<String, DateTimePatternGenerator> DTPNG_CACHE = new SimpleCache<String, DateTimePatternGenerator>();
    private static final String[] CLDR_FIELD_APPEND = new String[]{"Era", "Year", "Quarter", "Month", "Week", "*", "Day-Of-Week", "Day", "*", "*", "*", "Hour", "Minute", "Second", "*", "Timezone"};
    private static final String[] CLDR_FIELD_NAME = new String[]{"era", "year", "*", "month", "week", "*", "weekday", "day", "*", "*", "dayperiod", "hour", "minute", "second", "*", "zone"};
    private static final String[] FIELD_NAME = new String[]{"Era", "Year", "Quarter", "Month", "Week_in_Year", "Week_in_Month", "Weekday", "Day", "Day_Of_Year", "Day_of_Week_in_Month", "Dayperiod", "Hour", "Minute", "Second", "Fractional_Second", "Zone"};
    private static final String[] CANONICAL_ITEMS = new String[]{"G", "y", "Q", "M", "w", "W", "E", "d", "D", "F", "H", "m", "s", "S", "v"};
    private static final Set<String> CANONICAL_SET = new HashSet<String>(Arrays.asList(CANONICAL_ITEMS));
    private Set<String> cldrAvailableFormatKeys;
    private static final int DATE_MASK = 1023;
    private static final int TIME_MASK = 64512;
    private static final int DELTA = 16;
    private static final int NUMERIC = 256;
    private static final int NONE = 0;
    private static final int NARROW = -257;
    private static final int SHORT = -258;
    private static final int LONG = -259;
    private static final int EXTRA_FIELD = 65536;
    private static final int MISSING_FIELD = 4096;
    private static final int[][] types = new int[][]{{71, 0, -258, 1, 3}, {71, 0, -259, 4}, {121, 1, 256, 1, 20}, {89, 1, 272, 1, 20}, {117, 1, 288, 1, 20}, {85, 1, -258, 1, 3}, {85, 1, -259, 4}, {85, 1, -257, 5}, {81, 2, 256, 1, 2}, {81, 2, -258, 3}, {81, 2, -259, 4}, {113, 2, 272, 1, 2}, {113, 2, -242, 3}, {113, 2, -243, 4}, {77, 3, 256, 1, 2}, {77, 3, -258, 3}, {77, 3, -259, 4}, {77, 3, -257, 5}, {76, 3, 272, 1, 2}, {76, 3, -274, 3}, {76, 3, -275, 4}, {76, 3, -273, 5}, {108, 3, 272, 1, 1}, {119, 4, 256, 1, 2}, {87, 5, 272, 1}, {69, 6, -258, 1, 3}, {69, 6, -259, 4}, {69, 6, -257, 5}, {99, 6, 288, 1, 2}, {99, 6, -290, 3}, {99, 6, -291, 4}, {99, 6, -289, 5}, {101, 6, 272, 1, 2}, {101, 6, -274, 3}, {101, 6, -275, 4}, {101, 6, -273, 5}, {100, 7, 256, 1, 2}, {68, 8, 272, 1, 3}, {70, 9, 288, 1}, {103, 7, 304, 1, 20}, {97, 10, -258, 1}, {72, 11, 416, 1, 2}, {107, 11, 432, 1, 2}, {104, 11, 256, 1, 2}, {75, 11, 272, 1, 2}, {109, 12, 256, 1, 2}, {115, 13, 256, 1, 2}, {83, 14, 272, 1, 1000}, {65, 13, 288, 1, 1000}, {118, 15, -290, 1}, {118, 15, -291, 4}, {122, 15, -258, 1, 3}, {122, 15, -259, 4}, {90, 15, -274, 1, 3}, {90, 15, -275, 4}, {86, 15, -274, 1, 3}, {86, 15, -275, 4}};

    public static DateTimePatternGenerator getEmptyInstance() {
        return new DateTimePatternGenerator();
    }

    protected DateTimePatternGenerator() {
        for (int i = 0; i < 16; ++i) {
            this.appendItemFormats[i] = "{0} \u251c{2}: {1}\u2524";
            this.appendItemNames[i] = "F" + i;
        }
        this.defaultHourFormatChar = (char)72;
        this.frozen = false;
        this.current = new DateTimeMatcher();
        this.fp = new FormatParser();
        this._distanceInfo = new DistanceInfo();
        this.complete();
        this.cldrAvailableFormatKeys = new HashSet<String>(20);
    }

    public static DateTimePatternGenerator getInstance() {
        return DateTimePatternGenerator.getInstance(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public static DateTimePatternGenerator getInstance(ULocale uLocale) {
        return DateTimePatternGenerator.getFrozenInstance(uLocale).cloneAsThawed();
    }

    public static DateTimePatternGenerator getFrozenInstance(ULocale uLocale) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        String string = uLocale.toString();
        DateTimePatternGenerator dateTimePatternGenerator = DTPNG_CACHE.get(string);
        if (dateTimePatternGenerator != null) {
            return dateTimePatternGenerator;
        }
        dateTimePatternGenerator = new DateTimePatternGenerator();
        PatternInfo patternInfo = new PatternInfo();
        String string2 = null;
        block8: for (int i = 0; i <= 3; ++i) {
            object4 = (SimpleDateFormat)DateFormat.getDateInstance(i, uLocale);
            dateTimePatternGenerator.addPattern(((SimpleDateFormat)object4).toPattern(), false, patternInfo);
            object4 = (SimpleDateFormat)DateFormat.getTimeInstance(i, uLocale);
            dateTimePatternGenerator.addPattern(((SimpleDateFormat)object4).toPattern(), false, patternInfo);
            if (i != 3) continue;
            string2 = ((SimpleDateFormat)object4).toPattern();
            object3 = new FormatParser();
            ((FormatParser)object3).set(string2);
            List<Object> list = ((FormatParser)object3).getItems();
            for (int j = 0; j < list.size(); ++j) {
                object2 = list.get(j);
                if (!(object2 instanceof VariableField) || ((VariableField)(object = (VariableField)object2)).getType() != 11) continue;
                dateTimePatternGenerator.defaultHourFormatChar = ((VariableField)object).toString().charAt(0);
                continue block8;
            }
        }
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale);
        object4 = uLocale.getKeywordValue("calendar");
        if (object4 == null) {
            object3 = Calendar.getKeywordValuesForLocale("calendar", uLocale, true);
            object4 = object3[0];
        }
        if (object4 == null) {
            object4 = "gregorian";
        }
        try {
            object3 = iCUResourceBundle.getWithFallback("calendar/" + (String)object4 + "/appendItems");
            for (int i = 0; i < ((UResourceBundle)object3).getSize(); ++i) {
                ICUResourceBundle iCUResourceBundle2 = (ICUResourceBundle)((UResourceBundle)object3).get(i);
                object2 = ((UResourceBundle)object3).get(i).getKey();
                object = iCUResourceBundle2.getString();
                dateTimePatternGenerator.setAppendItemFormat(DateTimePatternGenerator.getAppendFormatNumber((String)object2), (String)object);
            }
        }
        catch (MissingResourceException missingResourceException) {
            // empty catch block
        }
        try {
            object3 = iCUResourceBundle.getWithFallback("fields");
            for (int i = 0; i < 16; ++i) {
                if (!DateTimePatternGenerator.isCLDRFieldName(i)) continue;
                ICUResourceBundle iCUResourceBundle3 = ((ICUResourceBundle)object3).getWithFallback(CLDR_FIELD_NAME[i]);
                ICUResourceBundle iCUResourceBundle4 = iCUResourceBundle3.getWithFallback("dn");
                object = iCUResourceBundle4.getString();
                dateTimePatternGenerator.setAppendItemName(i, (String)object);
            }
        }
        catch (MissingResourceException missingResourceException) {
            // empty catch block
        }
        object3 = null;
        try {
            object3 = iCUResourceBundle.getWithFallback("calendar/" + (String)object4 + "/availableFormats");
        }
        catch (MissingResourceException missingResourceException) {
            // empty catch block
        }
        boolean bl = true;
        while (object3 != null) {
            for (int i = 0; i < ((UResourceBundle)object3).getSize(); ++i) {
                String string3 = ((UResourceBundle)object3).get(i).getKey();
                if (dateTimePatternGenerator.isAvailableFormatSet(string3)) continue;
                dateTimePatternGenerator.setAvailableFormat(string3);
                object = ((UResourceBundle)object3).get(i).getString();
                dateTimePatternGenerator.addPatternWithSkeleton((String)object, string3, bl, patternInfo);
            }
            ICUResourceBundle iCUResourceBundle5 = (ICUResourceBundle)((ICUResourceBundle)object3).getParent();
            if (iCUResourceBundle5 == null) break;
            try {
                object3 = iCUResourceBundle5.getWithFallback("calendar/" + (String)object4 + "/availableFormats");
            }
            catch (MissingResourceException missingResourceException) {
                object3 = null;
            }
            if (object3 == null || !iCUResourceBundle5.getULocale().getBaseName().equals("root")) continue;
            bl = false;
        }
        if (string2 != null) {
            DateTimePatternGenerator.hackTimes(dateTimePatternGenerator, patternInfo, string2);
        }
        dateTimePatternGenerator.setDateTimeFormat(Calendar.getDateTimePattern(Calendar.getInstance(uLocale), uLocale, 2));
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(uLocale);
        dateTimePatternGenerator.setDecimal(String.valueOf(decimalFormatSymbols.getDecimalSeparator()));
        dateTimePatternGenerator.freeze();
        DTPNG_CACHE.put(string, dateTimePatternGenerator);
        return dateTimePatternGenerator;
    }

    public char getDefaultHourFormatChar() {
        return this.defaultHourFormatChar;
    }

    public void setDefaultHourFormatChar(char c) {
        this.defaultHourFormatChar = c;
    }

    private static void hackTimes(DateTimePatternGenerator dateTimePatternGenerator, PatternInfo patternInfo, String string) {
        int n;
        Object object;
        dateTimePatternGenerator.fp.set(string);
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = false;
        for (int i = 0; i < dateTimePatternGenerator.fp.items.size(); ++i) {
            object = dateTimePatternGenerator.fp.items.get(i);
            if (object instanceof String) {
                if (!bl) continue;
                stringBuilder.append(dateTimePatternGenerator.fp.quoteLiteral(object.toString()));
                continue;
            }
            n = object.toString().charAt(0);
            if (n == 109) {
                bl = true;
                stringBuilder.append(object);
                continue;
            }
            if (n == 115) {
                if (!bl) break;
                stringBuilder.append(object);
                dateTimePatternGenerator.addPattern(stringBuilder.toString(), false, patternInfo);
                break;
            }
            if (bl || n == 122 || n == 90 || n == 118 || n == 86) break;
        }
        BitSet bitSet = new BitSet();
        object = new BitSet();
        for (n = 0; n < dateTimePatternGenerator.fp.items.size(); ++n) {
            Object e = dateTimePatternGenerator.fp.items.get(n);
            if (!(e instanceof VariableField)) continue;
            bitSet.set(n);
            char c = e.toString().charAt(0);
            if (c != 's' && c != 'S') continue;
            ((BitSet)object).set(n);
            for (int i = n - 1; i >= 0 && !bitSet.get(i); ++i) {
                ((BitSet)object).set(n);
            }
        }
        String string2 = DateTimePatternGenerator.getFilteredPattern(dateTimePatternGenerator.fp, (BitSet)object);
        dateTimePatternGenerator.addPattern(string2, false, patternInfo);
    }

    private static String getFilteredPattern(FormatParser formatParser, BitSet bitSet) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < formatParser.items.size(); ++i) {
            if (bitSet.get(i)) continue;
            Object e = formatParser.items.get(i);
            if (e instanceof String) {
                stringBuilder.append(formatParser.quoteLiteral(e.toString()));
                continue;
            }
            stringBuilder.append(e.toString());
        }
        return stringBuilder.toString();
    }

    public static int getAppendFormatNumber(String string) {
        for (int i = 0; i < CLDR_FIELD_APPEND.length; ++i) {
            if (!CLDR_FIELD_APPEND[i].equals(string)) continue;
            return i;
        }
        return -1;
    }

    private static boolean isCLDRFieldName(int n) {
        if (n < 0 && n >= 16) {
            return false;
        }
        return CLDR_FIELD_NAME[n].charAt(0) != '*';
    }

    public String getBestPattern(String string) {
        return this.getBestPattern(string, null, 0);
    }

    public String getBestPattern(String string, int n) {
        return this.getBestPattern(string, null, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String getBestPattern(String string, DateTimeMatcher dateTimeMatcher, int n) {
        String string2;
        String string3;
        string = string.replaceAll("j", String.valueOf(this.defaultHourFormatChar));
        DateTimePatternGenerator dateTimePatternGenerator = this;
        synchronized (dateTimePatternGenerator) {
            this.current.set(string, this.fp, false);
            PatternWithMatcher patternWithMatcher = this.getBestRaw(this.current, -1, this._distanceInfo, dateTimeMatcher);
            if (this._distanceInfo.missingFieldMask == 0 && this._distanceInfo.extraFieldMask == 0) {
                return this.adjustFieldTypes(patternWithMatcher, this.current, false, n);
            }
            int n2 = this.current.getFieldMask();
            string3 = this.getBestAppending(this.current, n2 & 0x3FF, this._distanceInfo, dateTimeMatcher, n);
            string2 = this.getBestAppending(this.current, n2 & 0xFC00, this._distanceInfo, dateTimeMatcher, n);
        }
        if (string3 == null) {
            return string2 == null ? "" : string2;
        }
        if (string2 == null) {
            return string3;
        }
        return MessageFormat.format(this.getDateTimeFormat(), string2, string3);
    }

    public DateTimePatternGenerator addPattern(String string, boolean bl, PatternInfo patternInfo) {
        return this.addPatternWithSkeleton(string, null, bl, patternInfo);
    }

    public DateTimePatternGenerator addPatternWithSkeleton(String string, String string2, boolean bl, PatternInfo patternInfo) {
        PatternWithSkeletonFlag patternWithSkeletonFlag;
        this.checkFrozen();
        DateTimeMatcher dateTimeMatcher = string2 == null ? new DateTimeMatcher().set(string, this.fp, false) : new DateTimeMatcher().set(string2, this.fp, false);
        String string3 = dateTimeMatcher.getBasePattern();
        PatternWithSkeletonFlag patternWithSkeletonFlag2 = this.basePattern_pattern.get(string3);
        if (patternWithSkeletonFlag2 != null && (!patternWithSkeletonFlag2.skeletonWasSpecified || string2 != null && !bl)) {
            patternInfo.status = 1;
            patternInfo.conflictingPattern = patternWithSkeletonFlag2.pattern;
            if (!bl) {
                return this;
            }
        }
        if ((patternWithSkeletonFlag = this.skeleton2pattern.get(dateTimeMatcher)) != null) {
            patternInfo.status = 2;
            patternInfo.conflictingPattern = patternWithSkeletonFlag.pattern;
            if (!bl || string2 != null && patternWithSkeletonFlag.skeletonWasSpecified) {
                return this;
            }
        }
        patternInfo.status = 0;
        patternInfo.conflictingPattern = "";
        PatternWithSkeletonFlag patternWithSkeletonFlag3 = new PatternWithSkeletonFlag(string, string2 != null);
        this.skeleton2pattern.put(dateTimeMatcher, patternWithSkeletonFlag3);
        this.basePattern_pattern.put(string3, patternWithSkeletonFlag3);
        return this;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getSkeleton(String string) {
        DateTimePatternGenerator dateTimePatternGenerator = this;
        synchronized (dateTimePatternGenerator) {
            this.current.set(string, this.fp, false);
            return this.current.toString();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getSkeletonAllowingDuplicates(String string) {
        DateTimePatternGenerator dateTimePatternGenerator = this;
        synchronized (dateTimePatternGenerator) {
            this.current.set(string, this.fp, true);
            return this.current.toString();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getCanonicalSkeletonAllowingDuplicates(String string) {
        DateTimePatternGenerator dateTimePatternGenerator = this;
        synchronized (dateTimePatternGenerator) {
            this.current.set(string, this.fp, true);
            return this.current.toCanonicalString();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getBaseSkeleton(String string) {
        DateTimePatternGenerator dateTimePatternGenerator = this;
        synchronized (dateTimePatternGenerator) {
            this.current.set(string, this.fp, false);
            return this.current.getBasePattern();
        }
    }

    public Map<String, String> getSkeletons(Map<String, String> map) {
        if (map == null) {
            map = new LinkedHashMap<String, String>();
        }
        for (DateTimeMatcher dateTimeMatcher : this.skeleton2pattern.keySet()) {
            PatternWithSkeletonFlag patternWithSkeletonFlag = this.skeleton2pattern.get(dateTimeMatcher);
            String string = patternWithSkeletonFlag.pattern;
            if (CANONICAL_SET.contains(string)) continue;
            map.put(dateTimeMatcher.toString(), string);
        }
        return map;
    }

    public Set<String> getBaseSkeletons(Set<String> set) {
        if (set == null) {
            set = new HashSet<String>();
        }
        set.addAll(this.basePattern_pattern.keySet());
        return set;
    }

    public String replaceFieldTypes(String string, String string2) {
        return this.replaceFieldTypes(string, string2, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String replaceFieldTypes(String string, String string2, int n) {
        DateTimePatternGenerator dateTimePatternGenerator = this;
        synchronized (dateTimePatternGenerator) {
            PatternWithMatcher patternWithMatcher = new PatternWithMatcher(string, null);
            return this.adjustFieldTypes(patternWithMatcher, this.current.set(string2, this.fp, false), false, n);
        }
    }

    public void setDateTimeFormat(String string) {
        this.checkFrozen();
        this.dateTimeFormat = string;
    }

    public String getDateTimeFormat() {
        return this.dateTimeFormat;
    }

    public void setDecimal(String string) {
        this.checkFrozen();
        this.decimal = string;
    }

    public String getDecimal() {
        return this.decimal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Collection<String> getRedundants(Collection<String> collection) {
        DateTimePatternGenerator dateTimePatternGenerator = this;
        synchronized (dateTimePatternGenerator) {
            if (collection == null) {
                collection = new LinkedHashSet<String>();
            }
            for (DateTimeMatcher dateTimeMatcher : this.skeleton2pattern.keySet()) {
                String string;
                PatternWithSkeletonFlag patternWithSkeletonFlag = this.skeleton2pattern.get(dateTimeMatcher);
                String string2 = patternWithSkeletonFlag.pattern;
                if (CANONICAL_SET.contains(string2) || !(string = this.getBestPattern(dateTimeMatcher.toString(), dateTimeMatcher, 0)).equals(string2)) continue;
                collection.add(string2);
            }
            return collection;
        }
    }

    public void setAppendItemFormat(int n, String string) {
        this.checkFrozen();
        this.appendItemFormats[n] = string;
    }

    public String getAppendItemFormat(int n) {
        return this.appendItemFormats[n];
    }

    public void setAppendItemName(int n, String string) {
        this.checkFrozen();
        this.appendItemNames[n] = string;
    }

    public String getAppendItemName(int n) {
        return this.appendItemNames[n];
    }

    public static boolean isSingleField(String string) {
        char c = string.charAt(0);
        for (int i = 1; i < string.length(); ++i) {
            if (string.charAt(i) == c) continue;
            return false;
        }
        return true;
    }

    private void setAvailableFormat(String string) {
        this.checkFrozen();
        this.cldrAvailableFormatKeys.add(string);
    }

    private boolean isAvailableFormatSet(String string) {
        return this.cldrAvailableFormatKeys.contains(string);
    }

    @Override
    public boolean isFrozen() {
        return this.frozen;
    }

    @Override
    public DateTimePatternGenerator freeze() {
        this.frozen = true;
        return this;
    }

    @Override
    public DateTimePatternGenerator cloneAsThawed() {
        DateTimePatternGenerator dateTimePatternGenerator = (DateTimePatternGenerator)this.clone();
        this.frozen = false;
        return dateTimePatternGenerator;
    }

    public Object clone() {
        try {
            DateTimePatternGenerator dateTimePatternGenerator = (DateTimePatternGenerator)super.clone();
            dateTimePatternGenerator.skeleton2pattern = (TreeMap)this.skeleton2pattern.clone();
            dateTimePatternGenerator.basePattern_pattern = (TreeMap)this.basePattern_pattern.clone();
            dateTimePatternGenerator.appendItemFormats = (String[])this.appendItemFormats.clone();
            dateTimePatternGenerator.appendItemNames = (String[])this.appendItemNames.clone();
            dateTimePatternGenerator.current = new DateTimeMatcher();
            dateTimePatternGenerator.fp = new FormatParser();
            dateTimePatternGenerator._distanceInfo = new DistanceInfo();
            dateTimePatternGenerator.frozen = false;
            return dateTimePatternGenerator;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new IllegalArgumentException("Internal Error");
        }
    }

    public boolean skeletonsAreSimilar(String string, String string2) {
        if (string.equals(string2)) {
            return true;
        }
        TreeSet<String> treeSet = this.getSet(string);
        TreeSet<String> treeSet2 = this.getSet(string2);
        if (treeSet.size() != treeSet2.size()) {
            return false;
        }
        Iterator<String> iterator2 = treeSet2.iterator();
        for (String string3 : treeSet) {
            String string4;
            int n;
            int n2 = DateTimePatternGenerator.getCanonicalIndex(string3, false);
            if (types[n2][1] == types[n = DateTimePatternGenerator.getCanonicalIndex(string4 = iterator2.next(), false)][1]) continue;
            return false;
        }
        return true;
    }

    private TreeSet<String> getSet(String string) {
        List<Object> list = this.fp.set(string).getItems();
        TreeSet<String> treeSet = new TreeSet<String>();
        for (Object object : list) {
            String string2 = object.toString();
            if (string2.startsWith("G") || string2.startsWith("a")) continue;
            treeSet.add(string2);
        }
        return treeSet;
    }

    private void checkFrozen() {
        if (this.isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify frozen object");
        }
    }

    private String getBestAppending(DateTimeMatcher dateTimeMatcher, int n, DistanceInfo distanceInfo, DateTimeMatcher dateTimeMatcher2, int n2) {
        String string = null;
        if (n != 0) {
            PatternWithMatcher patternWithMatcher = this.getBestRaw(dateTimeMatcher, n, distanceInfo, dateTimeMatcher2);
            string = this.adjustFieldTypes(patternWithMatcher, dateTimeMatcher, false, n2);
            while (distanceInfo.missingFieldMask != 0) {
                if ((distanceInfo.missingFieldMask & 0x6000) == 16384 && (n & 0x6000) == 24576) {
                    patternWithMatcher.pattern = string;
                    string = this.adjustFieldTypes(patternWithMatcher, dateTimeMatcher, true, n2);
                    distanceInfo.missingFieldMask &= 0xFFFFBFFF;
                    continue;
                }
                int n3 = distanceInfo.missingFieldMask;
                PatternWithMatcher patternWithMatcher2 = this.getBestRaw(dateTimeMatcher, distanceInfo.missingFieldMask, distanceInfo, dateTimeMatcher2);
                String string2 = this.adjustFieldTypes(patternWithMatcher2, dateTimeMatcher, false, n2);
                int n4 = n3 & ~distanceInfo.missingFieldMask;
                int n5 = this.getTopBitNumber(n4);
                string = MessageFormat.format(this.getAppendFormat(n5), string, string2, this.getAppendName(n5));
            }
        }
        return string;
    }

    private String getAppendName(int n) {
        return "'" + this.appendItemNames[n] + "'";
    }

    private String getAppendFormat(int n) {
        return this.appendItemFormats[n];
    }

    private int getTopBitNumber(int n) {
        int n2 = 0;
        while (n != 0) {
            n >>>= 1;
            ++n2;
        }
        return n2 - 1;
    }

    private void complete() {
        PatternInfo patternInfo = new PatternInfo();
        for (int i = 0; i < CANONICAL_ITEMS.length; ++i) {
            this.addPattern(String.valueOf(CANONICAL_ITEMS[i]), false, patternInfo);
        }
    }

    private PatternWithMatcher getBestRaw(DateTimeMatcher dateTimeMatcher, int n, DistanceInfo distanceInfo, DateTimeMatcher dateTimeMatcher2) {
        int n2 = Integer.MAX_VALUE;
        PatternWithMatcher patternWithMatcher = new PatternWithMatcher("", null);
        DistanceInfo distanceInfo2 = new DistanceInfo();
        for (DateTimeMatcher dateTimeMatcher3 : this.skeleton2pattern.keySet()) {
            int n3;
            if (dateTimeMatcher3.equals(dateTimeMatcher2) || (n3 = dateTimeMatcher.getDistance(dateTimeMatcher3, n, distanceInfo2)) >= n2) continue;
            n2 = n3;
            PatternWithSkeletonFlag patternWithSkeletonFlag = this.skeleton2pattern.get(dateTimeMatcher3);
            patternWithMatcher.pattern = patternWithSkeletonFlag.pattern;
            patternWithMatcher.matcherWithSkeleton = patternWithSkeletonFlag.skeletonWasSpecified ? dateTimeMatcher3 : null;
            distanceInfo.setTo(distanceInfo2);
            if (n3 != 0) continue;
            break;
        }
        return patternWithMatcher;
    }

    private String adjustFieldTypes(PatternWithMatcher patternWithMatcher, DateTimeMatcher dateTimeMatcher, boolean bl, int n) {
        this.fp.set(patternWithMatcher.pattern);
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : this.fp.getItems()) {
            String string;
            if (object instanceof String) {
                stringBuilder.append(this.fp.quoteLiteral((String)object));
                continue;
            }
            VariableField variableField = (VariableField)object;
            StringBuilder stringBuilder2 = new StringBuilder(variableField.toString());
            int n2 = variableField.getType();
            if (bl && n2 == 13) {
                string = dateTimeMatcher.original[14];
                stringBuilder2.append(this.decimal);
                stringBuilder2.append(string);
            } else if (dateTimeMatcher.type[n2] != 0) {
                int n3;
                string = dateTimeMatcher.original[n2];
                int n4 = string.length();
                if (string.charAt(0) == 'E' && n4 < 3) {
                    n4 = 3;
                }
                int n5 = n4;
                DateTimeMatcher dateTimeMatcher2 = patternWithMatcher.matcherWithSkeleton;
                if (n2 == 11 && (n & 0x800) == 0 || n2 == 12 && (n & 0x1000) == 0 || n2 == 13 && (n & 0x2000) == 0) {
                    n5 = stringBuilder2.length();
                } else if (dateTimeMatcher2 != null) {
                    String string2 = dateTimeMatcher2.origStringForField(n2);
                    n3 = string2.length();
                    boolean bl2 = variableField.isNumeric();
                    boolean bl3 = dateTimeMatcher2.fieldIsNumeric(n2);
                    if (n3 == n4 || bl2 && !bl3 || bl3 && !bl2) {
                        n5 = stringBuilder2.length();
                    }
                }
                char c = n2 != 11 && n2 != 3 && n2 != 6 && n2 != 1 ? string.charAt(0) : stringBuilder2.charAt(0);
                stringBuilder2 = new StringBuilder();
                for (n3 = n5; n3 > 0; --n3) {
                    stringBuilder2.append(c);
                }
            }
            stringBuilder.append((CharSequence)stringBuilder2);
        }
        return stringBuilder.toString();
    }

    public String getFields(String string) {
        this.fp.set(string);
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : this.fp.getItems()) {
            if (object instanceof String) {
                stringBuilder.append(this.fp.quoteLiteral((String)object));
                continue;
            }
            stringBuilder.append("{" + DateTimePatternGenerator.getName(object.toString()) + "}");
        }
        return stringBuilder.toString();
    }

    private static String showMask(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 16; ++i) {
            if ((n & 1 << i) == 0) continue;
            if (stringBuilder.length() != 0) {
                stringBuilder.append(" | ");
            }
            stringBuilder.append(FIELD_NAME[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private static String getName(String string) {
        boolean bl;
        int n = DateTimePatternGenerator.getCanonicalIndex(string, true);
        String string2 = FIELD_NAME[types[n][1]];
        int n2 = types[n][2];
        boolean bl2 = bl = n2 < 0;
        if (bl) {
            n2 = -n2;
        }
        string2 = n2 < 0 ? string2 + ":S" : string2 + ":N";
        return string2;
    }

    private static int getCanonicalIndex(String string, boolean bl) {
        int n;
        int n2 = string.length();
        if (n2 == 0) {
            return -1;
        }
        char c = string.charAt(0);
        for (n = 1; n < n2; ++n) {
            if (string.charAt(n) == c) continue;
            return -1;
        }
        n = -1;
        for (int i = 0; i < types.length; ++i) {
            int[] nArray = types[i];
            if (nArray[0] != c) continue;
            n = i;
            if (nArray[3] > n2 || nArray[nArray.length - 1] < n2) continue;
            return i;
        }
        return bl ? -1 : n;
    }

    private static class DistanceInfo {
        int missingFieldMask;
        int extraFieldMask;

        private DistanceInfo() {
        }

        void clear() {
            this.extraFieldMask = 0;
            this.missingFieldMask = 0;
        }

        void setTo(DistanceInfo distanceInfo) {
            this.missingFieldMask = distanceInfo.missingFieldMask;
            this.extraFieldMask = distanceInfo.extraFieldMask;
        }

        void addMissing(int n) {
            this.missingFieldMask |= 1 << n;
        }

        void addExtra(int n) {
            this.extraFieldMask |= 1 << n;
        }

        public String toString() {
            return "missingFieldMask: " + DateTimePatternGenerator.showMask(this.missingFieldMask) + ", extraFieldMask: " + DateTimePatternGenerator.showMask(this.extraFieldMask);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class DateTimeMatcher
    implements Comparable<DateTimeMatcher> {
        private int[] type = new int[16];
        private String[] original = new String[16];
        private String[] baseOriginal = new String[16];

        private DateTimeMatcher() {
        }

        public String origStringForField(int n) {
            return this.original[n];
        }

        public boolean fieldIsNumeric(int n) {
            return this.type[n] > 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 16; ++i) {
                if (this.original[i].length() == 0) continue;
                stringBuilder.append(this.original[i]);
            }
            return stringBuilder.toString();
        }

        public String toCanonicalString() {
            StringBuilder stringBuilder = new StringBuilder();
            block0: for (int i = 0; i < 16; ++i) {
                if (this.original[i].length() == 0) continue;
                for (int j = 0; j < types.length; ++j) {
                    int[] nArray = types[j];
                    if (nArray[1] != i) continue;
                    char c = this.original[i].charAt(0);
                    char c2 = c == 'h' || c == 'K' ? (char)'h' : (char)nArray[0];
                    stringBuilder.append(Utility.repeat(String.valueOf(c2), this.original[i].length()));
                    continue block0;
                }
            }
            return stringBuilder.toString();
        }

        String getBasePattern() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 16; ++i) {
                if (this.baseOriginal[i].length() == 0) continue;
                stringBuilder.append(this.baseOriginal[i]);
            }
            return stringBuilder.toString();
        }

        DateTimeMatcher set(String string, FormatParser formatParser, boolean bl) {
            for (int i = 0; i < 16; ++i) {
                this.type[i] = 0;
                this.original[i] = "";
                this.baseOriginal[i] = "";
            }
            formatParser.set(string);
            for (Object object : formatParser.getItems()) {
                VariableField variableField;
                String string2;
                if (!(object instanceof VariableField) || (string2 = (variableField = (VariableField)object).toString()).charAt(0) == 'a') continue;
                int n = variableField.getCanonicalIndex();
                int[] nArray = types[n];
                int n2 = nArray[1];
                if (this.original[n2].length() != 0) {
                    if (bl) continue;
                    throw new IllegalArgumentException("Conflicting fields:\t" + this.original[n2] + ", " + string2 + "\t in " + string);
                }
                this.original[n2] = string2;
                char c = (char)nArray[0];
                int n3 = nArray[3];
                if ("GEzvQ".indexOf(c) >= 0) {
                    n3 = 1;
                }
                this.baseOriginal[n2] = Utility.repeat(String.valueOf(c), n3);
                int n4 = nArray[2];
                if (n4 > 0) {
                    n4 += string2.length();
                }
                this.type[n2] = n4;
            }
            return this;
        }

        int getFieldMask() {
            int n = 0;
            for (int i = 0; i < this.type.length; ++i) {
                if (this.type[i] == 0) continue;
                n |= 1 << i;
            }
            return n;
        }

        void extractFrom(DateTimeMatcher dateTimeMatcher, int n) {
            for (int i = 0; i < this.type.length; ++i) {
                if ((n & 1 << i) != 0) {
                    this.type[i] = dateTimeMatcher.type[i];
                    this.original[i] = dateTimeMatcher.original[i];
                    continue;
                }
                this.type[i] = 0;
                this.original[i] = "";
            }
        }

        int getDistance(DateTimeMatcher dateTimeMatcher, int n, DistanceInfo distanceInfo) {
            int n2 = 0;
            distanceInfo.clear();
            for (int i = 0; i < this.type.length; ++i) {
                int n3;
                int n4 = (n & 1 << i) == 0 ? 0 : this.type[i];
                if (n4 == (n3 = dateTimeMatcher.type[i])) continue;
                if (n4 == 0) {
                    n2 += 65536;
                    distanceInfo.addExtra(i);
                    continue;
                }
                if (n3 == 0) {
                    n2 += 4096;
                    distanceInfo.addMissing(i);
                    continue;
                }
                n2 += Math.abs(n4 - n3);
            }
            return n2;
        }

        @Override
        public int compareTo(DateTimeMatcher dateTimeMatcher) {
            for (int i = 0; i < this.original.length; ++i) {
                int n = this.original[i].compareTo(dateTimeMatcher.original[i]);
                if (n == 0) continue;
                return -n;
            }
            return 0;
        }

        public boolean equals(Object object) {
            if (!(object instanceof DateTimeMatcher)) {
                return false;
            }
            DateTimeMatcher dateTimeMatcher = (DateTimeMatcher)object;
            for (int i = 0; i < this.original.length; ++i) {
                if (this.original[i].equals(dateTimeMatcher.original[i])) continue;
                return false;
            }
            return true;
        }

        public int hashCode() {
            int n = 0;
            for (int i = 0; i < this.original.length; ++i) {
                n ^= this.original[i].hashCode();
            }
            return n;
        }
    }

    private static class PatternWithSkeletonFlag {
        public String pattern;
        public boolean skeletonWasSpecified;

        public PatternWithSkeletonFlag(String string, boolean bl) {
            this.pattern = string;
            this.skeletonWasSpecified = bl;
        }

        public String toString() {
            return this.pattern + "," + this.skeletonWasSpecified;
        }
    }

    private static class PatternWithMatcher {
        public String pattern;
        public DateTimeMatcher matcherWithSkeleton;

        public PatternWithMatcher(String string, DateTimeMatcher dateTimeMatcher) {
            this.pattern = string;
            this.matcherWithSkeleton = dateTimeMatcher;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class FormatParser {
        private transient PatternTokenizer tokenizer = new PatternTokenizer().setSyntaxCharacters(new UnicodeSet("[a-zA-Z]")).setExtraQuotingCharacters(new UnicodeSet("[[[:script=Latn:][:script=Cyrl:]]&[[:L:][:M:]]]")).setUsingQuote(true);
        private List<Object> items = new ArrayList<Object>();

        public final FormatParser set(String string) {
            return this.set(string, false);
        }

        public FormatParser set(String string, boolean bl) {
            this.items.clear();
            if (string.length() == 0) {
                return this;
            }
            this.tokenizer.setPattern(string);
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            while (true) {
                stringBuffer.setLength(0);
                int n = this.tokenizer.next(stringBuffer);
                if (n == 0) break;
                if (n == 1) {
                    if (stringBuffer2.length() != 0 && stringBuffer.charAt(0) != stringBuffer2.charAt(0)) {
                        this.addVariable(stringBuffer2, false);
                    }
                    stringBuffer2.append(stringBuffer);
                    continue;
                }
                this.addVariable(stringBuffer2, false);
                this.items.add(stringBuffer.toString());
            }
            this.addVariable(stringBuffer2, false);
            return this;
        }

        private void addVariable(StringBuffer stringBuffer, boolean bl) {
            if (stringBuffer.length() != 0) {
                this.items.add(new VariableField(stringBuffer.toString(), bl));
                stringBuffer.setLength(0);
            }
        }

        public List<Object> getItems() {
            return this.items;
        }

        public String toString() {
            return this.toString(0, this.items.size());
        }

        public String toString(int n, int n2) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = n; i < n2; ++i) {
                Object object = this.items.get(i);
                if (object instanceof String) {
                    String string = (String)object;
                    stringBuilder.append(this.tokenizer.quoteLiteral(string));
                    continue;
                }
                stringBuilder.append(this.items.get(i).toString());
            }
            return stringBuilder.toString();
        }

        public boolean hasDateAndTimeFields() {
            int n = 0;
            for (Object object : this.items) {
                if (!(object instanceof VariableField)) continue;
                int n2 = ((VariableField)object).getType();
                n |= 1 << n2;
            }
            boolean bl = (n & 0x3FF) != 0;
            boolean bl2 = (n & 0xFC00) != 0;
            return bl && bl2;
        }

        public Object quoteLiteral(String string) {
            return this.tokenizer.quoteLiteral(string);
        }
    }

    public static class VariableField {
        private final String string;
        private final int canonicalIndex;

        public VariableField(String string) {
            this(string, false);
        }

        public VariableField(String string, boolean bl) {
            this.canonicalIndex = DateTimePatternGenerator.getCanonicalIndex(string, bl);
            if (this.canonicalIndex < 0) {
                throw new IllegalArgumentException("Illegal datetime field:\t" + string);
            }
            this.string = string;
        }

        public int getType() {
            return types[this.canonicalIndex][1];
        }

        public static String getCanonicalCode(int n) {
            try {
                return CANONICAL_ITEMS[n];
            }
            catch (Exception exception) {
                return String.valueOf(n);
            }
        }

        public boolean isNumeric() {
            return types[this.canonicalIndex][2] > 0;
        }

        private int getCanonicalIndex() {
            return this.canonicalIndex;
        }

        public String toString() {
            return this.string;
        }
    }

    public static final class PatternInfo {
        public static final int OK = 0;
        public static final int BASE_CONFLICT = 1;
        public static final int CONFLICT = 2;
        public int status;
        public String conflictingPattern;
    }
}

