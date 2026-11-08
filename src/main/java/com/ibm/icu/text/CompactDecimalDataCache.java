/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.text.DecimalFormat;
import com.ibm.icu.text.NumberingSystem;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CompactDecimalDataCache {
    private static final String SHORT_STYLE = "short";
    private static final String LONG_STYLE = "long";
    private static final String NUMBER_ELEMENTS = "NumberElements";
    private static final String PATTERN_LONG_PATH = "patternsLong/decimalFormat";
    private static final String PATTERNS_SHORT_PATH = "patternsShort/decimalFormat";
    static final String OTHER = "other";
    static final int MAX_DIGITS = 15;
    private static final String LATIN_NUMBERING_SYSTEM = "latn";
    private final ICUCache<ULocale, DataBundle> cache = new SimpleCache<ULocale, DataBundle>();

    CompactDecimalDataCache() {
    }

    DataBundle get(ULocale uLocale) {
        DataBundle dataBundle = this.cache.get(uLocale);
        if (dataBundle == null) {
            dataBundle = CompactDecimalDataCache.load(uLocale);
            this.cache.put(uLocale, dataBundle);
        }
        return dataBundle;
    }

    private static DataBundle load(ULocale uLocale) {
        Object object;
        NumberingSystem numberingSystem = NumberingSystem.getInstance(uLocale);
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale);
        iCUResourceBundle = iCUResourceBundle.getWithFallback(NUMBER_ELEMENTS);
        String string = numberingSystem.getName();
        ICUResourceBundle iCUResourceBundle2 = null;
        ICUResourceBundle iCUResourceBundle3 = null;
        if (!LATIN_NUMBERING_SYSTEM.equals(string)) {
            object = CompactDecimalDataCache.findWithFallback(iCUResourceBundle, string, UResFlags.NOT_ROOT);
            iCUResourceBundle2 = CompactDecimalDataCache.findWithFallback((ICUResourceBundle)object, PATTERNS_SHORT_PATH, UResFlags.NOT_ROOT);
            iCUResourceBundle3 = CompactDecimalDataCache.findWithFallback((ICUResourceBundle)object, PATTERN_LONG_PATH, UResFlags.NOT_ROOT);
        }
        if (iCUResourceBundle2 == null) {
            object = CompactDecimalDataCache.getWithFallback(iCUResourceBundle, LATIN_NUMBERING_SYSTEM, UResFlags.ANY);
            iCUResourceBundle2 = CompactDecimalDataCache.getWithFallback((ICUResourceBundle)object, PATTERNS_SHORT_PATH, UResFlags.ANY);
            if (iCUResourceBundle3 == null && (iCUResourceBundle3 = CompactDecimalDataCache.findWithFallback((ICUResourceBundle)object, PATTERN_LONG_PATH, UResFlags.ANY)) != null && CompactDecimalDataCache.isRoot(iCUResourceBundle3) && !CompactDecimalDataCache.isRoot(iCUResourceBundle2)) {
                iCUResourceBundle3 = null;
            }
        }
        object = CompactDecimalDataCache.loadStyle(iCUResourceBundle2, uLocale, SHORT_STYLE);
        Object object2 = iCUResourceBundle3 == null ? object : CompactDecimalDataCache.loadStyle(iCUResourceBundle3, uLocale, LONG_STYLE);
        return new DataBundle((Data)object, (Data)object2);
    }

    private static ICUResourceBundle findWithFallback(ICUResourceBundle iCUResourceBundle, String string, UResFlags uResFlags) {
        if (iCUResourceBundle == null) {
            return null;
        }
        ICUResourceBundle iCUResourceBundle2 = iCUResourceBundle.findWithFallback(string);
        if (iCUResourceBundle2 == null) {
            return null;
        }
        switch (uResFlags) {
            case NOT_ROOT: {
                return CompactDecimalDataCache.isRoot(iCUResourceBundle2) ? null : iCUResourceBundle2;
            }
            case ANY: {
                return iCUResourceBundle2;
            }
        }
        throw new IllegalArgumentException();
    }

    private static ICUResourceBundle getWithFallback(ICUResourceBundle iCUResourceBundle, String string, UResFlags uResFlags) {
        ICUResourceBundle iCUResourceBundle2 = CompactDecimalDataCache.findWithFallback(iCUResourceBundle, string, uResFlags);
        if (iCUResourceBundle2 == null) {
            throw new MissingResourceException("Cannot find " + string, ICUResourceBundle.class.getName(), string);
        }
        return iCUResourceBundle2;
    }

    private static boolean isRoot(ICUResourceBundle iCUResourceBundle) {
        ULocale uLocale = iCUResourceBundle.getULocale();
        return uLocale.equals(ULocale.ROOT) || uLocale.toString().equals("root");
    }

    private static Data loadStyle(ICUResourceBundle iCUResourceBundle, ULocale uLocale, String string) {
        int n = iCUResourceBundle.getSize();
        Data data = new Data(new long[15], new HashMap<String, DecimalFormat.Unit[]>());
        for (int i = 0; i < n; ++i) {
            CompactDecimalDataCache.populateData(iCUResourceBundle.get(i), uLocale, string, data);
        }
        CompactDecimalDataCache.fillInMissing(data);
        return data;
    }

    private static void populateData(UResourceBundle uResourceBundle, ULocale uLocale, String string, Data data) {
        long l = Long.parseLong(uResourceBundle.getKey());
        int n = (int)Math.log10(l);
        if (n >= 15) {
            return;
        }
        int n2 = uResourceBundle.getSize();
        int n3 = 0;
        boolean bl = false;
        for (int i = 0; i < n2; ++i) {
            int n4;
            UResourceBundle uResourceBundle2 = uResourceBundle.get(i);
            String string2 = uResourceBundle2.getKey();
            String string3 = uResourceBundle2.getString();
            if (string2.equals(OTHER)) {
                bl = true;
            }
            if ((n4 = CompactDecimalDataCache.populatePrefixSuffix(string2, n, string3, uLocale, string, data)) == n3) continue;
            if (n3 != 0) {
                throw new IllegalArgumentException("Plural variant '" + string2 + "' template '" + string3 + "' for 10^" + n + " has wrong number of zeros in " + CompactDecimalDataCache.localeAndStyle(uLocale, string));
            }
            n3 = n4;
        }
        if (!bl) {
            throw new IllegalArgumentException("No 'other' plural variant defined for 10^" + n + "in " + CompactDecimalDataCache.localeAndStyle(uLocale, string));
        }
        long l2 = l;
        for (int i = 1; i < n3; ++i) {
            l2 /= 10L;
        }
        data.divisors[n] = l2;
    }

    private static int populatePrefixSuffix(String string, int n, String string2, ULocale uLocale, String string3, Data data) {
        int n2;
        int n3 = string2.indexOf("0");
        int n4 = string2.lastIndexOf("0");
        if (n3 == -1) {
            throw new IllegalArgumentException("Expect at least one zero in template '" + string2 + "' for variant '" + string + "' for 10^" + n + " in " + CompactDecimalDataCache.localeAndStyle(uLocale, string3));
        }
        String string4 = CompactDecimalDataCache.fixQuotes(string2.substring(0, n3));
        String string5 = CompactDecimalDataCache.fixQuotes(string2.substring(n4 + 1));
        CompactDecimalDataCache.saveUnit(new DecimalFormat.Unit(string4, string5), string, n, data.units);
        if (string4.trim().length() == 0 && string5.trim().length() == 0) {
            return n + 1;
        }
        for (n2 = n3 + 1; n2 <= n4 && string2.charAt(n2) == '0'; ++n2) {
        }
        return n2 - n3;
    }

    private static String fixQuotes(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = string.length();
        QuoteState quoteState = QuoteState.OUTSIDE;
        block4: for (int i = 0; i < n; ++i) {
            char c = string.charAt(i);
            if (c == '\'') {
                if (quoteState == QuoteState.INSIDE_EMPTY) {
                    stringBuilder.append('\'');
                }
            } else {
                stringBuilder.append(c);
            }
            switch (quoteState) {
                case OUTSIDE: {
                    quoteState = c == '\'' ? QuoteState.INSIDE_EMPTY : QuoteState.OUTSIDE;
                    continue block4;
                }
                case INSIDE_EMPTY: 
                case INSIDE_FULL: {
                    quoteState = c == '\'' ? QuoteState.OUTSIDE : QuoteState.INSIDE_FULL;
                    continue block4;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
        return stringBuilder.toString();
    }

    private static String localeAndStyle(ULocale uLocale, String string) {
        return "locale '" + uLocale + "' style '" + string + "'";
    }

    private static void fillInMissing(Data data) {
        long l = 1L;
        for (int i = 0; i < data.divisors.length; ++i) {
            if (data.units.get(OTHER)[i] == null) {
                data.divisors[i] = l;
                CompactDecimalDataCache.copyFromPreviousIndex(i, data.units);
                continue;
            }
            l = data.divisors[i];
            CompactDecimalDataCache.propagateOtherToMissing(i, data.units);
        }
    }

    private static void propagateOtherToMissing(int n, Map<String, DecimalFormat.Unit[]> map) {
        DecimalFormat.Unit unit = map.get(OTHER)[n];
        for (DecimalFormat.Unit[] unitArray : map.values()) {
            if (unitArray[n] != null) continue;
            unitArray[n] = unit;
        }
    }

    private static void copyFromPreviousIndex(int n, Map<String, DecimalFormat.Unit[]> map) {
        for (DecimalFormat.Unit[] unitArray : map.values()) {
            if (n == 0) {
                unitArray[n] = DecimalFormat.NULL_UNIT;
                continue;
            }
            unitArray[n] = unitArray[n - 1];
        }
    }

    private static void saveUnit(DecimalFormat.Unit unit, String string, int n, Map<String, DecimalFormat.Unit[]> map) {
        DecimalFormat.Unit[] unitArray = map.get(string);
        if (unitArray == null) {
            unitArray = new DecimalFormat.Unit[15];
            map.put(string, unitArray);
        }
        unitArray[n] = unit;
    }

    static DecimalFormat.Unit getUnit(Map<String, DecimalFormat.Unit[]> map, String string, int n) {
        DecimalFormat.Unit[] unitArray = map.get(string);
        if (unitArray == null) {
            unitArray = map.get(OTHER);
        }
        return unitArray[n];
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static enum UResFlags {
        ANY,
        NOT_ROOT;

    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static enum QuoteState {
        OUTSIDE,
        INSIDE_EMPTY,
        INSIDE_FULL;

    }

    public static class DataBundle {
        Data shortData;
        Data longData;

        DataBundle(Data data, Data data2) {
            this.shortData = data;
            this.longData = data2;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class Data {
        long[] divisors;
        Map<String, DecimalFormat.Unit[]> units;

        Data(long[] lArray, Map<String, DecimalFormat.Unit[]> map) {
            this.divisors = lArray;
            this.units = map;
        }
    }
}

