/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.LocaleIDs;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;

public class ICUResourceTableAccess {
    public static String getTableString(String string, ULocale uLocale, String string2, String string3) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance(string, uLocale.getBaseName());
        return ICUResourceTableAccess.getTableString(iCUResourceBundle, string2, null, string3);
    }

    public static String getTableString(ICUResourceBundle iCUResourceBundle, String string, String string2, String string3) {
        String string4 = null;
        try {
            while (true) {
                Object object;
                Object object2;
                ICUResourceBundle iCUResourceBundle2;
                if ("currency".equals(string2)) {
                    iCUResourceBundle2 = iCUResourceBundle.getWithFallback("Currencies");
                    iCUResourceBundle2 = iCUResourceBundle2.getWithFallback(string3);
                    return iCUResourceBundle2.getString(1);
                }
                iCUResourceBundle2 = ICUResourceTableAccess.lookup(iCUResourceBundle, string);
                if (iCUResourceBundle2 == null) {
                    return string3;
                }
                ICUResourceBundle iCUResourceBundle3 = iCUResourceBundle2;
                if (string2 != null) {
                    iCUResourceBundle3 = ICUResourceTableAccess.lookup(iCUResourceBundle2, string2);
                }
                if (iCUResourceBundle3 != null && (object2 = ICUResourceTableAccess.lookup(iCUResourceBundle3, string3)) != null) {
                    string4 = ((UResourceBundle)object2).getString();
                    break;
                }
                if (string2 == null) {
                    object2 = null;
                    if (string.equals("Countries")) {
                        object2 = LocaleIDs.getCurrentCountryID(string3);
                    } else if (string.equals("Languages")) {
                        object2 = LocaleIDs.getCurrentLanguageID(string3);
                    }
                    object = ICUResourceTableAccess.lookup(iCUResourceBundle2, (String)object2);
                    if (object != null) {
                        string4 = ((UResourceBundle)object).getString();
                        break;
                    }
                }
                if ((object2 = ICUResourceTableAccess.lookup(iCUResourceBundle2, "Fallback")) == null) {
                    return string3;
                }
                object = ((UResourceBundle)object2).getString();
                if (((String)object).length() == 0) {
                    object = "root";
                }
                if (((String)object).equals(iCUResourceBundle2.getULocale().getName())) {
                    return string3;
                }
                iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance(iCUResourceBundle.getBaseName(), (String)object);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return string4 != null && string4.length() > 0 ? string4 : string3;
    }

    private static ICUResourceBundle lookup(ICUResourceBundle iCUResourceBundle, String string) {
        return ICUResourceBundle.findResourceWithFallback(string, iCUResourceBundle, null);
    }
}

