/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUCache;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.util.MissingResourceException;

public class CalendarUtil {
    private static ICUCache<String, String> CALTYPE_CACHE = new SimpleCache<String, String>();
    private static final String CALKEY = "calendar";
    private static final String DEFCAL = "gregorian";

    public static String getCalendarType(ULocale uLocale) {
        String string = null;
        string = uLocale.getKeywordValue(CALKEY);
        if (string != null) {
            return string;
        }
        String string2 = uLocale.getBaseName();
        string = CALTYPE_CACHE.get(string2);
        if (string != null) {
            return string;
        }
        ULocale uLocale2 = ULocale.createCanonical(uLocale.toString());
        string = uLocale2.getKeywordValue(CALKEY);
        if (string == null) {
            Object object;
            String string3 = uLocale2.getCountry();
            if (string3.length() == 0) {
                object = ULocale.addLikelySubtags(uLocale2);
                string3 = ((ULocale)object).getCountry();
            }
            try {
                object = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "supplementalData", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
                UResourceBundle uResourceBundle = ((UResourceBundle)object).get("calendarPreferenceData");
                UResourceBundle uResourceBundle2 = null;
                try {
                    uResourceBundle2 = uResourceBundle.get(string3);
                }
                catch (MissingResourceException missingResourceException) {
                    uResourceBundle2 = uResourceBundle.get("001");
                }
                string = uResourceBundle2.getString(0);
            }
            catch (MissingResourceException missingResourceException) {
                // empty catch block
            }
            if (string == null) {
                string = DEFCAL;
            }
        }
        CALTYPE_CACHE.put(string2, string);
        return string;
    }
}

