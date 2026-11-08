/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.TextTrieMap;
import com.ibm.icu.text.CurrencyDisplayNames;
import com.ibm.icu.text.CurrencyMetaInfo;
import com.ibm.icu.util.MeasureUnit;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Currency
extends MeasureUnit
implements Serializable {
    private static final long serialVersionUID = -5839973855554750484L;
    private static final boolean DEBUG = ICUDebug.enabled("currency");
    private static ICUCache<ULocale, List<TextTrieMap<CurrencyStringInfo>>> CURRENCY_NAME_CACHE = new SimpleCache<ULocale, List<TextTrieMap<CurrencyStringInfo>>>();
    private String isoCode;
    public static final int SYMBOL_NAME = 0;
    public static final int LONG_NAME = 1;
    public static final int PLURAL_LONG_NAME = 2;
    private static ServiceShim shim;
    private static final String EUR_STR = "EUR";
    private static final ICUCache<ULocale, String> currencyCodeCache;
    private static final ULocale UND;
    private static final String[] EMPTY_STRING_ARRAY;
    private static final int[] POW10;
    private static SoftReference<List<String>> ALL_TENDER_CODES;
    private static SoftReference<Set<String>> ALL_CODES_AS_SET;

    private static ServiceShim getShim() {
        if (shim == null) {
            try {
                Class<?> clazz = Class.forName("com.ibm.icu.util.CurrencyServiceShim");
                shim = (ServiceShim)clazz.newInstance();
            }
            catch (Exception exception) {
                if (DEBUG) {
                    exception.printStackTrace();
                }
                throw new RuntimeException(exception.getMessage());
            }
        }
        return shim;
    }

    public static Currency getInstance(Locale locale) {
        return Currency.getInstance(ULocale.forLocale(locale));
    }

    public static Currency getInstance(ULocale uLocale) {
        String string = uLocale.getKeywordValue("currency");
        if (string != null) {
            return Currency.getInstance(string);
        }
        if (shim == null) {
            return Currency.createCurrency(uLocale);
        }
        return shim.createInstance(uLocale);
    }

    public static String[] getAvailableCurrencyCodes(ULocale uLocale, Date date) {
        CurrencyMetaInfo.CurrencyFilter currencyFilter = CurrencyMetaInfo.CurrencyFilter.onDate(date).withRegion(uLocale.getCountry());
        List<String> list = Currency.getTenderCurrencies(currencyFilter);
        if (list.isEmpty()) {
            return null;
        }
        return list.toArray(new String[list.size()]);
    }

    public static Set<Currency> getAvailableCurrencies() {
        CurrencyMetaInfo currencyMetaInfo = CurrencyMetaInfo.getInstance();
        List<String> list = currencyMetaInfo.currencies(CurrencyMetaInfo.CurrencyFilter.all());
        HashSet<Currency> hashSet = new HashSet<Currency>(list.size());
        for (String string : list) {
            hashSet.add(new Currency(string));
        }
        return hashSet;
    }

    static Currency createCurrency(ULocale uLocale) {
        String string = uLocale.getVariant();
        if ("EURO".equals(string)) {
            return new Currency(EUR_STR);
        }
        String string2 = currencyCodeCache.get(uLocale);
        if (string2 == null) {
            String string3 = uLocale.getCountry();
            CurrencyMetaInfo currencyMetaInfo = CurrencyMetaInfo.getInstance();
            List<String> list = currencyMetaInfo.currencies(CurrencyMetaInfo.CurrencyFilter.onRegion(string3));
            if (list.size() > 0) {
                string2 = list.get(0);
                boolean bl = "PREEURO".equals(string);
                if (bl && EUR_STR.equals(string2)) {
                    if (list.size() < 2) {
                        return null;
                    }
                    string2 = list.get(1);
                }
            } else {
                return null;
            }
            currencyCodeCache.put(uLocale, string2);
        }
        return new Currency(string2);
    }

    public static Currency getInstance(String string) {
        if (string == null) {
            throw new NullPointerException("The input currency code is null.");
        }
        if (!Currency.isAlpha3Code(string)) {
            throw new IllegalArgumentException("The input currency code is not 3-letter alphabetic code.");
        }
        return new Currency(string.toUpperCase(Locale.ENGLISH));
    }

    private static boolean isAlpha3Code(String string) {
        if (string.length() != 3) {
            return false;
        }
        for (int i = 0; i < 3; ++i) {
            char c = string.charAt(i);
            if (c >= 'A' && (c <= 'Z' || c >= 'a') && c <= 'z') continue;
            return false;
        }
        return true;
    }

    public static Object registerInstance(Currency currency, ULocale uLocale) {
        return Currency.getShim().registerInstance(currency, uLocale);
    }

    public static boolean unregister(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("registryKey must not be null");
        }
        if (shim == null) {
            return false;
        }
        return shim.unregister(object);
    }

    public static Locale[] getAvailableLocales() {
        if (shim == null) {
            return ICUResourceBundle.getAvailableLocales();
        }
        return shim.getAvailableLocales();
    }

    public static ULocale[] getAvailableULocales() {
        if (shim == null) {
            return ICUResourceBundle.getAvailableULocales();
        }
        return shim.getAvailableULocales();
    }

    public static final String[] getKeywordValuesForLocale(String string, ULocale uLocale, boolean bl) {
        List<String> list;
        Object object;
        if (!"currency".equals(string)) {
            return EMPTY_STRING_ARRAY;
        }
        if (!bl) {
            return Currency.getAllTenderCurrencies().toArray(new String[0]);
        }
        String string2 = uLocale.getCountry();
        if (string2.length() == 0) {
            if (UND.equals(uLocale)) {
                return EMPTY_STRING_ARRAY;
            }
            object = ULocale.addLikelySubtags(uLocale);
            string2 = ((ULocale)object).getCountry();
        }
        if ((list = Currency.getTenderCurrencies((CurrencyMetaInfo.CurrencyFilter)(object = CurrencyMetaInfo.CurrencyFilter.now().withRegion(string2)))).size() == 0) {
            return EMPTY_STRING_ARRAY;
        }
        return list.toArray(new String[list.size()]);
    }

    public int hashCode() {
        return this.isoCode.hashCode();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        try {
            Currency currency = (Currency)object;
            return this.isoCode.equals(currency.isoCode);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public String getCurrencyCode() {
        return this.isoCode;
    }

    public int getNumericCode() {
        int n = 0;
        try {
            UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "currencyNumericCodes", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
            UResourceBundle uResourceBundle2 = uResourceBundle.get("codeMap");
            UResourceBundle uResourceBundle3 = uResourceBundle2.get(this.isoCode);
            n = uResourceBundle3.getInt();
        }
        catch (MissingResourceException missingResourceException) {
            // empty catch block
        }
        return n;
    }

    public String getSymbol() {
        return this.getSymbol(ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public String getSymbol(Locale locale) {
        return this.getSymbol(ULocale.forLocale(locale));
    }

    public String getSymbol(ULocale uLocale) {
        return this.getName(uLocale, 0, new boolean[1]);
    }

    public String getName(Locale locale, int n, boolean[] blArray) {
        return this.getName(ULocale.forLocale(locale), n, blArray);
    }

    public String getName(ULocale uLocale, int n, boolean[] blArray) {
        if (n != 0 && n != 1) {
            throw new IllegalArgumentException("bad name style: " + n);
        }
        if (blArray != null) {
            blArray[0] = false;
        }
        CurrencyDisplayNames currencyDisplayNames = CurrencyDisplayNames.getInstance(uLocale);
        return n == 0 ? currencyDisplayNames.getSymbol(this.isoCode) : currencyDisplayNames.getName(this.isoCode);
    }

    public String getName(Locale locale, int n, String string, boolean[] blArray) {
        return this.getName(ULocale.forLocale(locale), n, string, blArray);
    }

    public String getName(ULocale uLocale, int n, String string, boolean[] blArray) {
        if (n != 2) {
            return this.getName(uLocale, n, blArray);
        }
        if (blArray != null) {
            blArray[0] = false;
        }
        CurrencyDisplayNames currencyDisplayNames = CurrencyDisplayNames.getInstance(uLocale);
        return currencyDisplayNames.getPluralName(this.isoCode, string);
    }

    public String getDisplayName() {
        return this.getName(Locale.getDefault(), 1, null);
    }

    public String getDisplayName(Locale locale) {
        return this.getName(locale, 1, null);
    }

    public static String parse(ULocale uLocale, String string, int n, ParsePosition parsePosition) {
        String string2;
        Object object;
        List<TextTrieMap<CurrencyStringInfo>> list = CURRENCY_NAME_CACHE.get(uLocale);
        if (list == null) {
            TextTrieMap textTrieMap = new TextTrieMap(true);
            object = new TextTrieMap(false);
            list = new ArrayList<TextTrieMap<CurrencyStringInfo>>();
            list.add((TextTrieMap<CurrencyStringInfo>)object);
            list.add(textTrieMap);
            Currency.setupCurrencyTrieVec(uLocale, list);
            CURRENCY_NAME_CACHE.put(uLocale, list);
        }
        int n2 = 0;
        object = null;
        TextTrieMap<CurrencyStringInfo> textTrieMap = list.get(1);
        CurrencyNameResultHandler currencyNameResultHandler = new CurrencyNameResultHandler();
        textTrieMap.find(string, parsePosition.getIndex(), (TextTrieMap.ResultHandler<CurrencyStringInfo>)currencyNameResultHandler);
        List<CurrencyStringInfo> list2 = currencyNameResultHandler.getMatchedCurrencyNames();
        if (list2 != null && list2.size() != 0) {
            for (CurrencyStringInfo object2 : list2) {
                String string3 = object2.getISOCode();
                string2 = object2.getCurrencyString();
                if (string2.length() <= n2) continue;
                n2 = string2.length();
                object = string3;
            }
        }
        if (n != 1) {
            TextTrieMap<CurrencyStringInfo> textTrieMap2 = list.get(0);
            currencyNameResultHandler = new CurrencyNameResultHandler();
            textTrieMap2.find(string, parsePosition.getIndex(), currencyNameResultHandler);
            list2 = currencyNameResultHandler.getMatchedCurrencyNames();
            if (list2 != null && list2.size() != 0) {
                for (CurrencyStringInfo currencyStringInfo : list2) {
                    string2 = currencyStringInfo.getISOCode();
                    String string4 = currencyStringInfo.getCurrencyString();
                    if (string4.length() <= n2) continue;
                    n2 = string4.length();
                    object = string2;
                }
            }
        }
        int n3 = parsePosition.getIndex();
        parsePosition.setIndex(n3 + n2);
        return object;
    }

    private static void setupCurrencyTrieVec(ULocale uLocale, List<TextTrieMap<CurrencyStringInfo>> list) {
        String string;
        String string2;
        TextTrieMap<CurrencyStringInfo> textTrieMap = list.get(0);
        TextTrieMap<CurrencyStringInfo> textTrieMap2 = list.get(1);
        CurrencyDisplayNames currencyDisplayNames = CurrencyDisplayNames.getInstance(uLocale);
        for (Map.Entry<String, String> entry : currencyDisplayNames.symbolMap().entrySet()) {
            string2 = entry.getKey();
            string = entry.getValue();
            textTrieMap.put(string2, new CurrencyStringInfo(string, string2));
        }
        for (Map.Entry<String, String> entry : currencyDisplayNames.nameMap().entrySet()) {
            string2 = entry.getKey();
            string = entry.getValue();
            textTrieMap2.put(string2, new CurrencyStringInfo(string, string2));
        }
    }

    public int getDefaultFractionDigits() {
        CurrencyMetaInfo currencyMetaInfo = CurrencyMetaInfo.getInstance();
        CurrencyMetaInfo.CurrencyDigits currencyDigits = currencyMetaInfo.currencyDigits(this.isoCode);
        return currencyDigits.fractionDigits;
    }

    public double getRoundingIncrement() {
        CurrencyMetaInfo currencyMetaInfo = CurrencyMetaInfo.getInstance();
        CurrencyMetaInfo.CurrencyDigits currencyDigits = currencyMetaInfo.currencyDigits(this.isoCode);
        int n = currencyDigits.roundingIncrement;
        if (n == 0) {
            return 0.0;
        }
        int n2 = currencyDigits.fractionDigits;
        if (n2 < 0 || n2 >= POW10.length) {
            return 0.0;
        }
        return (double)n / (double)POW10[n2];
    }

    public String toString() {
        return this.isoCode;
    }

    protected Currency(String string) {
        this.isoCode = string;
    }

    private static synchronized List<String> getAllTenderCurrencies() {
        List<String> list;
        List<String> list2 = list = ALL_TENDER_CODES == null ? null : ALL_TENDER_CODES.get();
        if (list == null) {
            CurrencyMetaInfo.CurrencyFilter currencyFilter = CurrencyMetaInfo.CurrencyFilter.all();
            list = Collections.unmodifiableList(Currency.getTenderCurrencies(currencyFilter));
            ALL_TENDER_CODES = new SoftReference<List<String>>(list);
        }
        return list;
    }

    private static synchronized Set<String> getAllCurrenciesAsSet() {
        Set<String> set;
        Set<String> set2 = set = ALL_CODES_AS_SET == null ? null : ALL_CODES_AS_SET.get();
        if (set == null) {
            CurrencyMetaInfo currencyMetaInfo = CurrencyMetaInfo.getInstance();
            set = Collections.unmodifiableSet(new HashSet<String>(currencyMetaInfo.currencies(CurrencyMetaInfo.CurrencyFilter.all())));
            ALL_CODES_AS_SET = new SoftReference<Set<String>>(set);
        }
        return set;
    }

    public static boolean isAvailable(String string, Date date, Date date2) {
        if (!Currency.isAlpha3Code(string)) {
            return false;
        }
        if (date != null && date2 != null && date.after(date2)) {
            throw new IllegalArgumentException("To is before from");
        }
        string = string.toUpperCase(Locale.ENGLISH);
        boolean bl = Currency.getAllCurrenciesAsSet().contains(string);
        if (!bl) {
            return false;
        }
        if (date == null && date2 == null) {
            return true;
        }
        CurrencyMetaInfo currencyMetaInfo = CurrencyMetaInfo.getInstance();
        List<String> list = currencyMetaInfo.currencies(CurrencyMetaInfo.CurrencyFilter.onDateRange(date, date2).withCurrency(string));
        return list.contains(string);
    }

    private static List<String> getTenderCurrencies(CurrencyMetaInfo.CurrencyFilter currencyFilter) {
        CurrencyMetaInfo currencyMetaInfo = CurrencyMetaInfo.getInstance();
        return currencyMetaInfo.currencies(currencyFilter.withTender());
    }

    static {
        currencyCodeCache = new SimpleCache<ULocale, String>();
        UND = new ULocale("und");
        EMPTY_STRING_ARRAY = new String[0];
        POW10 = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class CurrencyNameResultHandler
    implements TextTrieMap.ResultHandler<CurrencyStringInfo> {
        private ArrayList<CurrencyStringInfo> resultList;

        private CurrencyNameResultHandler() {
        }

        @Override
        public boolean handlePrefixMatch(int n, Iterator<CurrencyStringInfo> iterator2) {
            CurrencyStringInfo currencyStringInfo;
            if (this.resultList == null) {
                this.resultList = new ArrayList();
            }
            while (iterator2.hasNext() && (currencyStringInfo = iterator2.next()) != null) {
                int n2;
                for (n2 = 0; n2 < this.resultList.size(); ++n2) {
                    CurrencyStringInfo currencyStringInfo2 = this.resultList.get(n2);
                    if (!currencyStringInfo.getISOCode().equals(currencyStringInfo2.getISOCode())) continue;
                    if (n <= currencyStringInfo2.getCurrencyString().length()) break;
                    this.resultList.set(n2, currencyStringInfo);
                    break;
                }
                if (n2 != this.resultList.size()) continue;
                this.resultList.add(currencyStringInfo);
            }
            return true;
        }

        List<CurrencyStringInfo> getMatchedCurrencyNames() {
            if (this.resultList == null || this.resultList.size() == 0) {
                return null;
            }
            return this.resultList;
        }
    }

    private static final class CurrencyStringInfo {
        private String isoCode;
        private String currencyString;

        public CurrencyStringInfo(String string, String string2) {
            this.isoCode = string;
            this.currencyString = string2;
        }

        private String getISOCode() {
            return this.isoCode;
        }

        private String getCurrencyString() {
            return this.currencyString;
        }
    }

    public static abstract class ServiceShim {
        ServiceShim() {
        }

        abstract ULocale[] getAvailableULocales();

        abstract Locale[] getAvailableLocales();

        abstract Currency createInstance(ULocale var1);

        abstract Object registerInstance(Currency var1, ULocale var2);

        abstract boolean unregister(Object var1);
    }
}

