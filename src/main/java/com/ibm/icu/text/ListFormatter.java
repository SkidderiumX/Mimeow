/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ListFormatter {
    private final String two;
    private final String start;
    private final String middle;
    private final String end;
    static Map<ULocale, ListFormatter> localeToData = new HashMap<ULocale, ListFormatter>();
    static Cache cache = new Cache();

    public ListFormatter(String string, String string2, String string3, String string4) {
        this.two = string;
        this.start = string2;
        this.middle = string3;
        this.end = string4;
    }

    public static ListFormatter getInstance(ULocale uLocale) {
        return cache.get(uLocale);
    }

    public static ListFormatter getInstance(Locale locale) {
        return ListFormatter.getInstance(ULocale.forLocale(locale));
    }

    public static ListFormatter getInstance() {
        return ListFormatter.getInstance(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public String format(Object ... objectArray) {
        return this.format(Arrays.asList(objectArray));
    }

    public String format(Collection<?> collection) {
        Iterator<?> iterator2 = collection.iterator();
        int n = collection.size();
        switch (n) {
            case 0: {
                return "";
            }
            case 1: {
                return iterator2.next().toString();
            }
            case 2: {
                return this.format2(this.two, iterator2.next(), iterator2.next());
            }
        }
        String string = iterator2.next().toString();
        string = this.format2(this.start, string, iterator2.next());
        n -= 3;
        while (n > 0) {
            string = this.format2(this.middle, string, iterator2.next());
            --n;
        }
        return this.format2(this.end, string, iterator2.next());
    }

    private String format2(String string, Object object, Object object2) {
        int n = string.indexOf("{0}");
        int n2 = string.indexOf("{1}");
        if (n < 0 || n2 < 0) {
            throw new IllegalArgumentException("Missing {0} or {1} in pattern " + string);
        }
        if (n < n2) {
            return string.substring(0, n) + object + string.substring(n + 3, n2) + object2 + string.substring(n2 + 3);
        }
        return string.substring(0, n2) + object2 + string.substring(n2 + 3, n) + object + string.substring(n + 3);
    }

    static void add(String string, String ... stringArray) {
        localeToData.put(new ULocale(string), new ListFormatter(stringArray[0], stringArray[1], stringArray[2], stringArray[3]));
    }

    private static class Cache {
        private final ICUCache<ULocale, ListFormatter> cache = new SimpleCache<ULocale, ListFormatter>();

        private Cache() {
        }

        public ListFormatter get(ULocale uLocale) {
            ListFormatter listFormatter = this.cache.get(uLocale);
            if (listFormatter == null) {
                listFormatter = Cache.load(uLocale);
                this.cache.put(uLocale, listFormatter);
            }
            return listFormatter;
        }

        private static ListFormatter load(ULocale uLocale) {
            ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale);
            iCUResourceBundle = iCUResourceBundle.getWithFallback("listPattern/standard");
            return new ListFormatter(iCUResourceBundle.getWithFallback("2").getString(), iCUResourceBundle.getWithFallback("start").getString(), iCUResourceBundle.getWithFallback("middle").getString(), iCUResourceBundle.getWithFallback("end").getString());
        }
    }
}

