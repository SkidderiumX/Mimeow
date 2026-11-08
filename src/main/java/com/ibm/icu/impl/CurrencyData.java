/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.text.CurrencyDisplayNames;
import com.ibm.icu.util.ULocale;
import java.util.Collections;
import java.util.Map;

public class CurrencyData {
    public static final CurrencyDisplayInfoProvider provider;

    static {
        CurrencyDisplayInfoProvider currencyDisplayInfoProvider = null;
        try {
            Class<?> clazz = Class.forName("com.ibm.icu.impl.ICUCurrencyDisplayInfoProvider");
            currencyDisplayInfoProvider = (CurrencyDisplayInfoProvider)clazz.newInstance();
        }
        catch (Throwable throwable) {
            currencyDisplayInfoProvider = new CurrencyDisplayInfoProvider(){

                public CurrencyDisplayInfo getInstance(ULocale uLocale, boolean bl) {
                    return DefaultInfo.getWithFallback(bl);
                }

                public boolean hasData() {
                    return false;
                }
            };
        }
        provider = currencyDisplayInfoProvider;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class DefaultInfo
    extends CurrencyDisplayInfo {
        private final boolean fallback;
        private static final CurrencyDisplayInfo FALLBACK_INSTANCE = new DefaultInfo(true);
        private static final CurrencyDisplayInfo NO_FALLBACK_INSTANCE = new DefaultInfo(false);

        private DefaultInfo(boolean bl) {
            this.fallback = bl;
        }

        public static final CurrencyDisplayInfo getWithFallback(boolean bl) {
            return bl ? FALLBACK_INSTANCE : NO_FALLBACK_INSTANCE;
        }

        @Override
        public String getName(String string) {
            return this.fallback ? string : null;
        }

        @Override
        public String getPluralName(String string, String string2) {
            return this.fallback ? string : null;
        }

        @Override
        public String getSymbol(String string) {
            return this.fallback ? string : null;
        }

        @Override
        public Map<String, String> symbolMap() {
            return Collections.emptyMap();
        }

        @Override
        public Map<String, String> nameMap() {
            return Collections.emptyMap();
        }

        @Override
        public ULocale getULocale() {
            return ULocale.ROOT;
        }

        @Override
        public Map<String, String> getUnitPatterns() {
            if (this.fallback) {
                return Collections.emptyMap();
            }
            return null;
        }

        @Override
        public CurrencyFormatInfo getFormatInfo(String string) {
            return null;
        }

        @Override
        public CurrencySpacingInfo getSpacingInfo() {
            return this.fallback ? CurrencySpacingInfo.DEFAULT : null;
        }
    }

    public static final class CurrencySpacingInfo {
        public final String beforeCurrencyMatch;
        public final String beforeContextMatch;
        public final String beforeInsert;
        public final String afterCurrencyMatch;
        public final String afterContextMatch;
        public final String afterInsert;
        private static final String DEFAULT_CUR_MATCH = "[:letter:]";
        private static final String DEFAULT_CTX_MATCH = "[:digit:]";
        private static final String DEFAULT_INSERT = " ";
        public static final CurrencySpacingInfo DEFAULT = new CurrencySpacingInfo("[:letter:]", "[:digit:]", " ", "[:letter:]", "[:digit:]", " ");

        public CurrencySpacingInfo(String string, String string2, String string3, String string4, String string5, String string6) {
            this.beforeCurrencyMatch = string;
            this.beforeContextMatch = string2;
            this.beforeInsert = string3;
            this.afterCurrencyMatch = string4;
            this.afterContextMatch = string5;
            this.afterInsert = string6;
        }
    }

    public static final class CurrencyFormatInfo {
        public final String currencyPattern;
        public final char monetarySeparator;
        public final char monetaryGroupingSeparator;

        public CurrencyFormatInfo(String string, char c, char c2) {
            this.currencyPattern = string;
            this.monetarySeparator = c;
            this.monetaryGroupingSeparator = c2;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static abstract class CurrencyDisplayInfo
    extends CurrencyDisplayNames {
        public abstract Map<String, String> getUnitPatterns();

        public abstract CurrencyFormatInfo getFormatInfo(String var1);

        public abstract CurrencySpacingInfo getSpacingInfo();
    }

    public static interface CurrencyDisplayInfoProvider {
        public CurrencyDisplayInfo getInstance(ULocale var1, boolean var2);

        public boolean hasData();
    }
}

