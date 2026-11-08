/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import java.util.ArrayList;
import java.util.MissingResourceException;

public class CalendarData {
    private ICUResourceBundle fBundle;
    private String fMainType;
    private String fFallbackType;

    public CalendarData(ULocale uLocale, String string) {
        this((ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale), string);
    }

    public CalendarData(ICUResourceBundle iCUResourceBundle, String string) {
        this.fBundle = iCUResourceBundle;
        if (string == null || string.equals("") || string.equals("gregorian")) {
            this.fMainType = "gregorian";
            this.fFallbackType = null;
        } else {
            this.fMainType = string;
            this.fFallbackType = "gregorian";
        }
    }

    public ICUResourceBundle get(String string) {
        try {
            return this.fBundle.getWithFallback("calendar/" + this.fMainType + "/" + string);
        }
        catch (MissingResourceException missingResourceException) {
            if (this.fFallbackType != null) {
                return this.fBundle.getWithFallback("calendar/" + this.fFallbackType + "/" + string);
            }
            throw missingResourceException;
        }
    }

    public ICUResourceBundle get(String string, String string2) {
        try {
            return this.fBundle.getWithFallback("calendar/" + this.fMainType + "/" + string + "/format/" + string2);
        }
        catch (MissingResourceException missingResourceException) {
            if (this.fFallbackType != null) {
                return this.fBundle.getWithFallback("calendar/" + this.fFallbackType + "/" + string + "/format/" + string2);
            }
            throw missingResourceException;
        }
    }

    public ICUResourceBundle get(String string, String string2, String string3) {
        try {
            return this.fBundle.getWithFallback("calendar/" + this.fMainType + "/" + string + "/" + string2 + "/" + string3);
        }
        catch (MissingResourceException missingResourceException) {
            if (this.fFallbackType != null) {
                return this.fBundle.getWithFallback("calendar/" + this.fFallbackType + "/" + string + "/" + string2 + "/" + string3);
            }
            throw missingResourceException;
        }
    }

    public ICUResourceBundle get(String string, String string2, String string3, String string4) {
        try {
            return this.fBundle.getWithFallback("calendar/" + this.fMainType + "/" + string + "/" + string2 + "/" + string3 + "/" + string4);
        }
        catch (MissingResourceException missingResourceException) {
            if (this.fFallbackType != null) {
                return this.fBundle.getWithFallback("calendar/" + this.fFallbackType + "/" + string + "/" + string2 + "/" + string3 + "/" + string4);
            }
            throw missingResourceException;
        }
    }

    public String[] getStringArray(String string) {
        return this.get(string).getStringArray();
    }

    public String[] getStringArray(String string, String string2) {
        return this.get(string, string2).getStringArray();
    }

    public String[] getStringArray(String string, String string2, String string3) {
        return this.get(string, string2, string3).getStringArray();
    }

    public String[] getEras(String string) {
        ICUResourceBundle iCUResourceBundle = this.get("eras/" + string);
        return iCUResourceBundle.getStringArray();
    }

    public String[] getDateTimePatterns() {
        ICUResourceBundle iCUResourceBundle = this.get("DateTimePatterns");
        ArrayList<String> arrayList = new ArrayList<String>();
        UResourceBundleIterator uResourceBundleIterator = iCUResourceBundle.getIterator();
        while (uResourceBundleIterator.hasNext()) {
            UResourceBundle uResourceBundle = uResourceBundleIterator.next();
            int n = uResourceBundle.getType();
            switch (n) {
                case 0: {
                    arrayList.add(uResourceBundle.getString());
                    break;
                }
                case 8: {
                    String[] stringArray = uResourceBundle.getStringArray();
                    arrayList.add(stringArray[0]);
                }
            }
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public String[] getOverrides() {
        ICUResourceBundle iCUResourceBundle = this.get("DateTimePatterns");
        ArrayList<String> arrayList = new ArrayList<String>();
        UResourceBundleIterator uResourceBundleIterator = iCUResourceBundle.getIterator();
        while (uResourceBundleIterator.hasNext()) {
            UResourceBundle uResourceBundle = uResourceBundleIterator.next();
            int n = uResourceBundle.getType();
            switch (n) {
                case 0: {
                    arrayList.add(null);
                    break;
                }
                case 8: {
                    String[] stringArray = uResourceBundle.getStringArray();
                    arrayList.add(stringArray[1]);
                }
            }
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public ULocale getULocale() {
        return this.fBundle.getULocale();
    }
}

