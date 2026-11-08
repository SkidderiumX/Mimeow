/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.VersionInfo;
import java.util.MissingResourceException;

public class LocaleData {
    private static final String MEASUREMENT_SYSTEM = "MeasurementSystem";
    private static final String PAPER_SIZE = "PaperSize";
    private static final String LOCALE_DISPLAY_PATTERN = "localeDisplayPattern";
    private static final String PATTERN = "pattern";
    private static final String SEPARATOR = "separator";
    private boolean noSubstitute;
    private ICUResourceBundle bundle;
    private ICUResourceBundle langBundle;
    public static final int ES_STANDARD = 0;
    public static final int ES_AUXILIARY = 1;
    public static final int ES_INDEX = 2;
    public static final int ES_CURRENCY = 3;
    public static final int ES_PUNCTUATION = 4;
    public static final int ES_COUNT = 5;
    public static final int QUOTATION_START = 0;
    public static final int QUOTATION_END = 1;
    public static final int ALT_QUOTATION_START = 2;
    public static final int ALT_QUOTATION_END = 3;
    public static final int DELIMITER_COUNT = 4;
    private static final String[] DELIMITER_TYPES = new String[]{"quotationStart", "quotationEnd", "alternateQuotationStart", "alternateQuotationEnd"};
    private static VersionInfo gCLDRVersion = null;

    private LocaleData() {
    }

    public static UnicodeSet getExemplarSet(ULocale uLocale, int n) {
        return LocaleData.getInstance(uLocale).getExemplarSet(n, 0);
    }

    public static UnicodeSet getExemplarSet(ULocale uLocale, int n, int n2) {
        return LocaleData.getInstance(uLocale).getExemplarSet(n, n2);
    }

    public UnicodeSet getExemplarSet(int n, int n2) {
        String[] stringArray = new String[]{"ExemplarCharacters", "AuxExemplarCharacters", "ExemplarCharactersIndex", "ExemplarCharactersCurrency", "ExemplarCharactersPunctuation"};
        if (n2 == 3) {
            return new UnicodeSet();
        }
        try {
            ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)this.bundle.get(stringArray[n2]);
            if (this.noSubstitute && iCUResourceBundle.getLoadingStatus() == 2) {
                return null;
            }
            String string = iCUResourceBundle.getString();
            if (n2 == 4) {
                try {
                    return new UnicodeSet(string, 1 | n);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    throw new IllegalArgumentException("Can't create exemplars for " + stringArray[n2] + " in " + this.bundle.getLocale(), illegalArgumentException);
                }
            }
            return new UnicodeSet(string, 1 | n);
        }
        catch (MissingResourceException missingResourceException) {
            if (n2 == 1) {
                return new UnicodeSet();
            }
            if (n2 == 2) {
                return null;
            }
            throw missingResourceException;
        }
    }

    public static final LocaleData getInstance(ULocale uLocale) {
        LocaleData localeData = new LocaleData();
        localeData.bundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale);
        localeData.langBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b/lang", uLocale);
        localeData.noSubstitute = false;
        return localeData;
    }

    public static final LocaleData getInstance() {
        return LocaleData.getInstance(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public void setNoSubstitute(boolean bl) {
        this.noSubstitute = bl;
    }

    public boolean getNoSubstitute() {
        return this.noSubstitute;
    }

    public String getDelimiter(int n) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)this.bundle.get("delimiters");
        ICUResourceBundle iCUResourceBundle2 = iCUResourceBundle.getWithFallback(DELIMITER_TYPES[n]);
        if (this.noSubstitute && iCUResourceBundle2.getLoadingStatus() == 2) {
            return null;
        }
        return iCUResourceBundle2.getString();
    }

    public static final MeasurementSystem getMeasurementSystem(ULocale uLocale) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale);
        UResourceBundle uResourceBundle = iCUResourceBundle.get(MEASUREMENT_SYSTEM);
        int n = uResourceBundle.getInt();
        if (MeasurementSystem.US.equals(n)) {
            return MeasurementSystem.US;
        }
        if (MeasurementSystem.SI.equals(n)) {
            return MeasurementSystem.SI;
        }
        return null;
    }

    public static final PaperSize getPaperSize(ULocale uLocale) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale);
        UResourceBundle uResourceBundle = iCUResourceBundle.get(PAPER_SIZE);
        int[] nArray = uResourceBundle.getIntVector();
        return new PaperSize(nArray[0], nArray[1]);
    }

    public String getLocaleDisplayPattern() {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)this.langBundle.get(LOCALE_DISPLAY_PATTERN);
        String string = iCUResourceBundle.getStringWithFallback(PATTERN);
        return string;
    }

    public String getLocaleSeparator() {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)this.langBundle.get(LOCALE_DISPLAY_PATTERN);
        String string = iCUResourceBundle.getStringWithFallback(SEPARATOR);
        return string;
    }

    public static VersionInfo getCLDRVersion() {
        if (gCLDRVersion == null) {
            UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "supplementalData", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
            UResourceBundle uResourceBundle2 = uResourceBundle.get("cldrVersion");
            gCLDRVersion = VersionInfo.getInstance(uResourceBundle2.getString());
        }
        return gCLDRVersion;
    }

    public static final class PaperSize {
        private int height;
        private int width;

        private PaperSize(int n, int n2) {
            this.height = n;
            this.width = n2;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }
    }

    public static final class MeasurementSystem {
        public static final MeasurementSystem SI = new MeasurementSystem(0);
        public static final MeasurementSystem US = new MeasurementSystem(1);
        private int systemID;

        private MeasurementSystem(int n) {
            this.systemID = n;
        }

        private boolean equals(int n) {
            return this.systemID == n;
        }
    }
}

