/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.VersionInfo;
import java.util.MissingResourceException;

public class ICUDataVersion {
    private static final String U_ICU_VERSION_BUNDLE = "icuver";
    private static final String U_ICU_DATA_KEY = "DataVersion";

    public static VersionInfo getDataVersion() {
        UResourceBundle uResourceBundle = null;
        try {
            uResourceBundle = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", U_ICU_VERSION_BUNDLE, ICUResourceBundle.ICU_DATA_CLASS_LOADER);
            uResourceBundle = uResourceBundle.get(U_ICU_DATA_KEY);
        }
        catch (MissingResourceException missingResourceException) {
            return null;
        }
        return VersionInfo.getInstance(uResourceBundle.getString());
    }
}

