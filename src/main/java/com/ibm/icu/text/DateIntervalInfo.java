/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.text.DateIntervalFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DateIntervalInfo
implements Cloneable,
Freezable<DateIntervalInfo>,
Serializable {
    static final int currentSerialVersion = 1;
    static final String[] CALENDAR_FIELD_TO_PATTERN_LETTER = new String[]{"G", "y", "M", "w", "W", "d", "D", "E", "F", "a", "h", "H", "m"};
    private static final long serialVersionUID = 1L;
    private static final int MINIMUM_SUPPORTED_CALENDAR_FIELD = 12;
    private static String FALLBACK_STRING = "fallback";
    private static String LATEST_FIRST_PREFIX = "latestFirst:";
    private static String EARLIEST_FIRST_PREFIX = "earliestFirst:";
    private static final ICUCache<String, DateIntervalInfo> DIICACHE = new SimpleCache<String, DateIntervalInfo>();
    private String fFallbackIntervalPattern;
    private boolean fFirstDateInPtnIsLaterDate = false;
    private Map<String, Map<String, PatternInfo>> fIntervalPatterns = null;
    private transient boolean frozen = false;
    private transient boolean fIntervalPatternsReadOnly = false;

    public DateIntervalInfo() {
        this.fIntervalPatterns = new HashMap<String, Map<String, PatternInfo>>();
        this.fFallbackIntervalPattern = "{0} \u2013 {1}";
    }

    public DateIntervalInfo(ULocale uLocale) {
        this.initializeData(uLocale);
    }

    private void initializeData(ULocale uLocale) {
        String string = uLocale.toString();
        DateIntervalInfo dateIntervalInfo = DIICACHE.get(string);
        if (dateIntervalInfo == null) {
            this.setup(uLocale);
            this.fIntervalPatternsReadOnly = true;
            DIICACHE.put(string, ((DateIntervalInfo)this.clone()).freeze());
        } else {
            this.initializeFromReadOnlyPatterns(dateIntervalInfo);
        }
    }

    private void initializeFromReadOnlyPatterns(DateIntervalInfo dateIntervalInfo) {
        this.fFallbackIntervalPattern = dateIntervalInfo.fFallbackIntervalPattern;
        this.fFirstDateInPtnIsLaterDate = dateIntervalInfo.fFirstDateInPtnIsLaterDate;
        this.fIntervalPatterns = dateIntervalInfo.fIntervalPatterns;
        this.fIntervalPatternsReadOnly = true;
    }

    private void setup(ULocale uLocale) {
        int n = 19;
        this.fIntervalPatterns = new HashMap<String, Map<String, PatternInfo>>(n);
        this.fFallbackIntervalPattern = "{0} \u2013 {1}";
        HashSet<String> hashSet = new HashSet<String>();
        try {
            Object object;
            ULocale uLocale2 = uLocale;
            Object object2 = uLocale.getKeywordValue("calendar");
            if (object2 == null) {
                object = Calendar.getKeywordValuesForLocale("calendar", uLocale, true);
                object2 = object[0];
            }
            if (object2 == null) {
                object2 = "gregorian";
            }
            while (((String)(object = uLocale2.getName())).length() != 0) {
                ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale2);
                ICUResourceBundle iCUResourceBundle2 = iCUResourceBundle.getWithFallback("calendar/" + (String)object2 + "/intervalFormats");
                String string = iCUResourceBundle2.getStringWithFallback(FALLBACK_STRING);
                this.setFallbackIntervalPattern(string);
                int n2 = iCUResourceBundle2.getSize();
                for (int i = 0; i < n2; ++i) {
                    String string2 = iCUResourceBundle2.get(i).getKey();
                    if (hashSet.contains(string2)) continue;
                    hashSet.add(string2);
                    if (string2.compareTo(FALLBACK_STRING) == 0) continue;
                    ICUResourceBundle iCUResourceBundle3 = (ICUResourceBundle)iCUResourceBundle2.get(string2);
                    int n3 = iCUResourceBundle3.getSize();
                    for (int j = 0; j < n3; ++j) {
                        String string3 = iCUResourceBundle3.get(j).getKey();
                        String string4 = iCUResourceBundle3.get(j).getString();
                        int n4 = -1;
                        if (string3.compareTo(CALENDAR_FIELD_TO_PATTERN_LETTER[1]) == 0) {
                            n4 = 1;
                        } else if (string3.compareTo(CALENDAR_FIELD_TO_PATTERN_LETTER[2]) == 0) {
                            n4 = 2;
                        } else if (string3.compareTo(CALENDAR_FIELD_TO_PATTERN_LETTER[5]) == 0) {
                            n4 = 5;
                        } else if (string3.compareTo(CALENDAR_FIELD_TO_PATTERN_LETTER[9]) == 0) {
                            n4 = 9;
                        } else if (string3.compareTo(CALENDAR_FIELD_TO_PATTERN_LETTER[10]) == 0) {
                            n4 = 10;
                        } else if (string3.compareTo(CALENDAR_FIELD_TO_PATTERN_LETTER[12]) == 0) {
                            n4 = 12;
                        }
                        if (n4 == -1) continue;
                        this.setIntervalPatternInternally(string2, string3, string4);
                    }
                }
                try {
                    UResourceBundle uResourceBundle = iCUResourceBundle.get("%%Parent");
                    uLocale2 = new ULocale(uResourceBundle.getString());
                }
                catch (MissingResourceException missingResourceException) {
                    uLocale2 = uLocale2.getFallback();
                }
                if (uLocale2 != null && !uLocale2.getBaseName().equals("root")) continue;
                break;
            }
        }
        catch (MissingResourceException missingResourceException) {
            // empty catch block
        }
    }

    private static int splitPatternInto2Part(String string) {
        int n;
        boolean bl = false;
        char c = '\u0000';
        int n2 = 0;
        int[] nArray = new int[58];
        int n3 = 65;
        boolean bl2 = false;
        for (n = 0; n < string.length(); ++n) {
            char c2 = string.charAt(n);
            if (c2 != c && n2 > 0) {
                int n4 = nArray[c - n3];
                if (n4 != 0) {
                    bl2 = true;
                    break;
                }
                nArray[c - n3] = 1;
                n2 = 0;
            }
            if (c2 == '\'') {
                if (n + 1 < string.length() && string.charAt(n + 1) == '\'') {
                    ++n;
                    continue;
                }
                bl = !bl;
                continue;
            }
            if (bl || (c2 < 'a' || c2 > 'z') && (c2 < 'A' || c2 > 'Z')) continue;
            c = c2;
            ++n2;
        }
        if (n2 > 0 && !bl2 && nArray[c - n3] == 0) {
            n2 = 0;
        }
        return n - n2;
    }

    public void setIntervalPattern(String string, int n, String string2) {
        if (this.frozen) {
            throw new UnsupportedOperationException("no modification is allowed after DII is frozen");
        }
        if (n > 12) {
            throw new IllegalArgumentException("calendar field is larger than MINIMUM_SUPPORTED_CALENDAR_FIELD");
        }
        if (this.fIntervalPatternsReadOnly) {
            this.fIntervalPatterns = DateIntervalInfo.cloneIntervalPatterns(this.fIntervalPatterns);
            this.fIntervalPatternsReadOnly = false;
        }
        PatternInfo patternInfo = this.setIntervalPatternInternally(string, CALENDAR_FIELD_TO_PATTERN_LETTER[n], string2);
        if (n == 11) {
            this.setIntervalPattern(string, CALENDAR_FIELD_TO_PATTERN_LETTER[9], patternInfo);
            this.setIntervalPattern(string, CALENDAR_FIELD_TO_PATTERN_LETTER[10], patternInfo);
        } else if (n == 5 || n == 7) {
            this.setIntervalPattern(string, CALENDAR_FIELD_TO_PATTERN_LETTER[5], patternInfo);
        }
    }

    private PatternInfo setIntervalPatternInternally(String string, String string2, String string3) {
        int n;
        Map<String, PatternInfo> map = this.fIntervalPatterns.get(string);
        boolean bl = false;
        if (map == null) {
            map = new HashMap<String, PatternInfo>();
            bl = true;
        }
        boolean bl2 = this.fFirstDateInPtnIsLaterDate;
        if (string3.startsWith(LATEST_FIRST_PREFIX)) {
            bl2 = true;
            n = LATEST_FIRST_PREFIX.length();
            string3 = string3.substring(n, string3.length());
        } else if (string3.startsWith(EARLIEST_FIRST_PREFIX)) {
            bl2 = false;
            n = EARLIEST_FIRST_PREFIX.length();
            string3 = string3.substring(n, string3.length());
        }
        PatternInfo patternInfo = DateIntervalInfo.genPatternInfo(string3, bl2);
        map.put(string2, patternInfo);
        if (bl) {
            this.fIntervalPatterns.put(string, map);
        }
        return patternInfo;
    }

    private void setIntervalPattern(String string, String string2, PatternInfo patternInfo) {
        Map<String, PatternInfo> map = this.fIntervalPatterns.get(string);
        map.put(string2, patternInfo);
    }

    static PatternInfo genPatternInfo(String string, boolean bl) {
        int n = DateIntervalInfo.splitPatternInto2Part(string);
        String string2 = string.substring(0, n);
        String string3 = null;
        if (n < string.length()) {
            string3 = string.substring(n, string.length());
        }
        return new PatternInfo(string2, string3, bl);
    }

    public PatternInfo getIntervalPattern(String string, int n) {
        PatternInfo patternInfo;
        if (n > 12) {
            throw new IllegalArgumentException("no support for field less than MINUTE");
        }
        Map<String, PatternInfo> map = this.fIntervalPatterns.get(string);
        if (map != null && (patternInfo = map.get(CALENDAR_FIELD_TO_PATTERN_LETTER[n])) != null) {
            return patternInfo;
        }
        return null;
    }

    public String getFallbackIntervalPattern() {
        return this.fFallbackIntervalPattern;
    }

    public void setFallbackIntervalPattern(String string) {
        if (this.frozen) {
            throw new UnsupportedOperationException("no modification is allowed after DII is frozen");
        }
        int n = string.indexOf("{0}");
        int n2 = string.indexOf("{1}");
        if (n == -1 || n2 == -1) {
            throw new IllegalArgumentException("no pattern {0} or pattern {1} in fallbackPattern");
        }
        if (n > n2) {
            this.fFirstDateInPtnIsLaterDate = true;
        }
        this.fFallbackIntervalPattern = string;
    }

    public boolean getDefaultOrder() {
        return this.fFirstDateInPtnIsLaterDate;
    }

    public Object clone() {
        if (this.frozen) {
            return this;
        }
        return this.cloneUnfrozenDII();
    }

    private Object cloneUnfrozenDII() {
        try {
            DateIntervalInfo dateIntervalInfo = (DateIntervalInfo)super.clone();
            dateIntervalInfo.fFallbackIntervalPattern = this.fFallbackIntervalPattern;
            dateIntervalInfo.fFirstDateInPtnIsLaterDate = this.fFirstDateInPtnIsLaterDate;
            if (this.fIntervalPatternsReadOnly) {
                dateIntervalInfo.fIntervalPatterns = this.fIntervalPatterns;
                dateIntervalInfo.fIntervalPatternsReadOnly = true;
            } else {
                dateIntervalInfo.fIntervalPatterns = DateIntervalInfo.cloneIntervalPatterns(this.fIntervalPatterns);
                dateIntervalInfo.fIntervalPatternsReadOnly = false;
            }
            dateIntervalInfo.frozen = false;
            return dateIntervalInfo;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new IllegalStateException("clone is not supported");
        }
    }

    private static Map<String, Map<String, PatternInfo>> cloneIntervalPatterns(Map<String, Map<String, PatternInfo>> map) {
        HashMap<String, Map<String, PatternInfo>> hashMap = new HashMap<String, Map<String, PatternInfo>>();
        for (Map.Entry<String, Map<String, PatternInfo>> entry : map.entrySet()) {
            String string = entry.getKey();
            Map<String, PatternInfo> map2 = entry.getValue();
            HashMap<String, PatternInfo> hashMap2 = new HashMap<String, PatternInfo>();
            for (Map.Entry<String, PatternInfo> entry2 : map2.entrySet()) {
                String string2 = entry2.getKey();
                PatternInfo patternInfo = entry2.getValue();
                hashMap2.put(string2, patternInfo);
            }
            hashMap.put(string, hashMap2);
        }
        return hashMap;
    }

    @Override
    public boolean isFrozen() {
        return this.frozen;
    }

    @Override
    public DateIntervalInfo freeze() {
        this.frozen = true;
        this.fIntervalPatternsReadOnly = true;
        return this;
    }

    @Override
    public DateIntervalInfo cloneAsThawed() {
        DateIntervalInfo dateIntervalInfo = (DateIntervalInfo)this.cloneUnfrozenDII();
        return dateIntervalInfo;
    }

    static void parseSkeleton(String string, int[] nArray) {
        int n = 65;
        for (int i = 0; i < string.length(); ++i) {
            int n2 = string.charAt(i) - n;
            nArray[n2] = nArray[n2] + 1;
        }
    }

    private static boolean stringNumeric(int n, int n2, char c) {
        return c == 'M' && (n <= 2 && n2 > 2 || n > 2 && n2 <= 2);
    }

    DateIntervalFormat.BestMatchInfo getBestSkeleton(String string) {
        String string2 = string;
        int[] nArray = new int[58];
        int[] nArray2 = new int[58];
        int n = 4096;
        int n2 = 256;
        int n3 = 65;
        boolean bl = false;
        if (string.indexOf(122) != -1) {
            string = string.replace('z', 'v');
            bl = true;
        }
        DateIntervalInfo.parseSkeleton(string, nArray);
        int n4 = Integer.MAX_VALUE;
        int n5 = 0;
        for (String string3 : this.fIntervalPatterns.keySet()) {
            int n6;
            for (n6 = 0; n6 < nArray2.length; ++n6) {
                nArray2[n6] = 0;
            }
            DateIntervalInfo.parseSkeleton(string3, nArray2);
            n6 = 0;
            int n7 = 1;
            for (int i = 0; i < nArray.length; ++i) {
                int n8 = nArray[i];
                int n9 = nArray2[i];
                if (n8 == n9) continue;
                if (n8 == 0) {
                    n7 = -1;
                    n6 += 4096;
                    continue;
                }
                if (n9 == 0) {
                    n7 = -1;
                    n6 += 4096;
                    continue;
                }
                if (DateIntervalInfo.stringNumeric(n8, n9, (char)(i + 65))) {
                    n6 += 256;
                    continue;
                }
                n6 += Math.abs(n8 - n9);
            }
            if (n6 < n4) {
                string2 = string3;
                n4 = n6;
                n5 = n7;
            }
            if (n6 != 0) continue;
            n5 = 0;
            break;
        }
        if (bl && n5 != -1) {
            n5 = 2;
        }
        return new DateIntervalFormat.BestMatchInfo(string2, n5);
    }

    public boolean equals(Object object) {
        if (object instanceof DateIntervalInfo) {
            DateIntervalInfo dateIntervalInfo = (DateIntervalInfo)object;
            return ((Object)this.fIntervalPatterns).equals(dateIntervalInfo.fIntervalPatterns);
        }
        return false;
    }

    public int hashCode() {
        return ((Object)this.fIntervalPatterns).hashCode();
    }

    public Map<String, Set<String>> getPatterns() {
        LinkedHashMap<String, Set<String>> linkedHashMap = new LinkedHashMap<String, Set<String>>();
        for (Map.Entry<String, Map<String, PatternInfo>> entry : this.fIntervalPatterns.entrySet()) {
            linkedHashMap.put(entry.getKey(), new LinkedHashSet<String>(entry.getValue().keySet()));
        }
        return linkedHashMap;
    }

    public static final class PatternInfo
    implements Cloneable,
    Serializable {
        static final int currentSerialVersion = 1;
        private static final long serialVersionUID = 1L;
        private final String fIntervalPatternFirstPart;
        private final String fIntervalPatternSecondPart;
        private final boolean fFirstDateInPtnIsLaterDate;

        public PatternInfo(String string, String string2, boolean bl) {
            this.fIntervalPatternFirstPart = string;
            this.fIntervalPatternSecondPart = string2;
            this.fFirstDateInPtnIsLaterDate = bl;
        }

        public String getFirstPart() {
            return this.fIntervalPatternFirstPart;
        }

        public String getSecondPart() {
            return this.fIntervalPatternSecondPart;
        }

        public boolean firstDateInPtnIsLaterDate() {
            return this.fFirstDateInPtnIsLaterDate;
        }

        public boolean equals(Object object) {
            if (object instanceof PatternInfo) {
                PatternInfo patternInfo = (PatternInfo)object;
                return Utility.objectEquals(this.fIntervalPatternFirstPart, patternInfo.fIntervalPatternFirstPart) && Utility.objectEquals(this.fIntervalPatternSecondPart, this.fIntervalPatternSecondPart) && this.fFirstDateInPtnIsLaterDate == patternInfo.fFirstDateInPtnIsLaterDate;
            }
            return false;
        }

        public int hashCode() {
            int n;
            int n2 = n = this.fIntervalPatternFirstPart != null ? this.fIntervalPatternFirstPart.hashCode() : 0;
            if (this.fIntervalPatternSecondPart != null) {
                n ^= this.fIntervalPatternSecondPart.hashCode();
            }
            if (this.fFirstDateInPtnIsLaterDate) {
                n ^= 0xFFFFFFFF;
            }
            return n;
        }
    }
}

