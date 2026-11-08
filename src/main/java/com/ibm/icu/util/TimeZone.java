/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.impl.Grego;
import com.ibm.icu.impl.ICUConfig;
import com.ibm.icu.impl.JavaTimeZone;
import com.ibm.icu.impl.OlsonTimeZone;
import com.ibm.icu.impl.TimeZoneAdapter;
import com.ibm.icu.impl.ZoneMeta;
import com.ibm.icu.text.TimeZoneFormat;
import com.ibm.icu.text.TimeZoneNames;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.SimpleTimeZone;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Logger;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class TimeZone
implements Serializable,
Cloneable,
Freezable<TimeZone> {
    private static final Logger LOGGER = Logger.getLogger("com.ibm.icu.util.TimeZone");
    private static final long serialVersionUID = -744942128318337471L;
    public static final int TIMEZONE_ICU = 0;
    public static final int TIMEZONE_JDK = 1;
    public static final int SHORT = 0;
    public static final int LONG = 1;
    public static final int SHORT_GENERIC = 2;
    public static final int LONG_GENERIC = 3;
    public static final int SHORT_GMT = 4;
    public static final int LONG_GMT = 5;
    public static final int SHORT_COMMONLY_USED = 6;
    public static final int GENERIC_LOCATION = 7;
    public static final String UNKNOWN_ZONE_ID = "Etc/Unknown";
    static final String GMT_ZONE_ID = "Etc/GMT";
    public static final TimeZone UNKNOWN_ZONE = new SimpleTimeZone(0, "Etc/Unknown").freeze();
    public static final TimeZone GMT_ZONE = new SimpleTimeZone(0, "Etc/GMT").freeze();
    private String ID;
    private static TimeZone defaultZone = null;
    private static String TZDATA_VERSION = null;
    private static int TZ_IMPL = 0;
    private static final String TZIMPL_CONFIG_KEY = "com.ibm.icu.util.TimeZone.DefaultTimeZoneType";
    private static final String TZIMPL_CONFIG_ICU = "ICU";
    private static final String TZIMPL_CONFIG_JDK = "JDK";

    public TimeZone() {
    }

    protected TimeZone(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.ID = string;
    }

    public abstract int getOffset(int var1, int var2, int var3, int var4, int var5, int var6);

    public int getOffset(long l) {
        int[] nArray = new int[2];
        this.getOffset(l, false, nArray);
        return nArray[0] + nArray[1];
    }

    public void getOffset(long l, boolean bl, int[] nArray) {
        nArray[0] = this.getRawOffset();
        if (!bl) {
            l += (long)nArray[0];
        }
        int[] nArray2 = new int[6];
        int n = 0;
        while (true) {
            Grego.timeToFields(l, nArray2);
            nArray[1] = this.getOffset(1, nArray2[0], nArray2[1], nArray2[2], nArray2[3], nArray2[5]) - nArray[0];
            if (n != 0 || !bl || nArray[1] == 0) break;
            l -= (long)nArray[1];
            ++n;
        }
    }

    public abstract void setRawOffset(int var1);

    public abstract int getRawOffset();

    public String getID() {
        return this.ID;
    }

    public void setID(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (this.isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify a frozen TimeZone instance.");
        }
        this.ID = string;
    }

    public final String getDisplayName() {
        return this._getDisplayName(3, false, ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public final String getDisplayName(Locale locale) {
        return this._getDisplayName(3, false, ULocale.forLocale(locale));
    }

    public final String getDisplayName(ULocale uLocale) {
        return this._getDisplayName(3, false, uLocale);
    }

    public final String getDisplayName(boolean bl, int n) {
        return this.getDisplayName(bl, n, ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public String getDisplayName(boolean bl, int n, Locale locale) {
        return this.getDisplayName(bl, n, ULocale.forLocale(locale));
    }

    public String getDisplayName(boolean bl, int n, ULocale uLocale) {
        if (n < 0 || n > 7) {
            throw new IllegalArgumentException("Illegal style: " + n);
        }
        return this._getDisplayName(n, bl, uLocale);
    }

    private String _getDisplayName(int n, boolean bl, ULocale uLocale) {
        if (uLocale == null) {
            throw new NullPointerException("locale is null");
        }
        String string = null;
        if (n == 7 || n == 3 || n == 2) {
            TimeZoneFormat timeZoneFormat = TimeZoneFormat.getInstance(uLocale);
            long l = System.currentTimeMillis();
            Output<TimeZoneFormat.TimeType> output = new Output<TimeZoneFormat.TimeType>(TimeZoneFormat.TimeType.UNKNOWN);
            switch (n) {
                case 7: {
                    string = timeZoneFormat.format(TimeZoneFormat.Style.GENERIC_LOCATION, this, l, output);
                    break;
                }
                case 3: {
                    string = timeZoneFormat.format(TimeZoneFormat.Style.GENERIC_LONG, this, l, output);
                    break;
                }
                case 2: {
                    string = timeZoneFormat.format(TimeZoneFormat.Style.GENERIC_SHORT, this, l, output);
                }
            }
            if (bl && output.value == TimeZoneFormat.TimeType.STANDARD || !bl && output.value == TimeZoneFormat.TimeType.DAYLIGHT) {
                int n2 = bl ? this.getRawOffset() + this.getDSTSavings() : this.getRawOffset();
                string = n == 2 ? timeZoneFormat.formatOffsetShortLocalizedGMT(n2) : timeZoneFormat.formatOffsetLocalizedGMT(n2);
            }
        } else if (n == 5 || n == 4) {
            TimeZoneFormat timeZoneFormat = TimeZoneFormat.getInstance(uLocale);
            int n3 = bl && this.useDaylightTime() ? this.getRawOffset() + this.getDSTSavings() : this.getRawOffset();
            switch (n) {
                case 5: {
                    string = timeZoneFormat.formatOffsetLocalizedGMT(n3);
                    break;
                }
                case 4: {
                    string = timeZoneFormat.formatOffsetISO8601Basic(n3, false, false, false);
                }
            }
        } else {
            assert (n == 1 || n == 0 || n == 6);
            long l = System.currentTimeMillis();
            TimeZoneNames timeZoneNames = TimeZoneNames.getInstance(uLocale);
            TimeZoneNames.NameType nameType = null;
            switch (n) {
                case 1: {
                    nameType = bl ? TimeZoneNames.NameType.LONG_DAYLIGHT : TimeZoneNames.NameType.LONG_STANDARD;
                    break;
                }
                case 0: 
                case 6: {
                    nameType = bl ? TimeZoneNames.NameType.SHORT_DAYLIGHT : TimeZoneNames.NameType.SHORT_STANDARD;
                }
            }
            string = timeZoneNames.getDisplayName(ZoneMeta.getCanonicalCLDRID(this), nameType, l);
            if (string == null) {
                TimeZoneFormat timeZoneFormat = TimeZoneFormat.getInstance(uLocale);
                int n4 = bl && this.useDaylightTime() ? this.getRawOffset() + this.getDSTSavings() : this.getRawOffset();
                String string2 = string = n == 1 ? timeZoneFormat.formatOffsetLocalizedGMT(n4) : timeZoneFormat.formatOffsetShortLocalizedGMT(n4);
            }
        }
        assert (string != null);
        return string;
    }

    public int getDSTSavings() {
        if (this.useDaylightTime()) {
            return 3600000;
        }
        return 0;
    }

    public abstract boolean useDaylightTime();

    public boolean observesDaylightTime() {
        return this.useDaylightTime() || this.inDaylightTime(new Date());
    }

    public abstract boolean inDaylightTime(Date var1);

    public static TimeZone getTimeZone(String string) {
        return TimeZone.getTimeZone(string, TZ_IMPL, false);
    }

    public static TimeZone getFrozenTimeZone(String string) {
        return TimeZone.getTimeZone(string, TZ_IMPL, true);
    }

    public static TimeZone getTimeZone(String string, int n) {
        return TimeZone.getTimeZone(string, n, false);
    }

    private static synchronized TimeZone getTimeZone(String string, int n, boolean bl) {
        TimeZone timeZone;
        if (n == 1) {
            timeZone = JavaTimeZone.createTimeZone(string);
            if (timeZone != null) {
                return bl ? timeZone.freeze() : timeZone;
            }
        } else {
            if (string == null) {
                throw new NullPointerException();
            }
            timeZone = ZoneMeta.getSystemTimeZone(string);
        }
        if (timeZone == null) {
            timeZone = ZoneMeta.getCustomTimeZone(string);
        }
        if (timeZone == null) {
            LOGGER.fine("\"" + string + "\" is a bogus id so timezone is falling back to Etc/Unknown(GMT).");
            timeZone = UNKNOWN_ZONE;
        }
        return bl ? timeZone : timeZone.cloneAsThawed();
    }

    public static synchronized void setDefaultTimeZoneType(int n) {
        if (n != 0 && n != 1) {
            throw new IllegalArgumentException("Invalid timezone type");
        }
        TZ_IMPL = n;
    }

    public static int getDefaultTimeZoneType() {
        return TZ_IMPL;
    }

    public static Set<String> getAvailableIDs(SystemTimeZoneType systemTimeZoneType, String string, Integer n) {
        return ZoneMeta.getAvailableIDs(systemTimeZoneType, string, n);
    }

    public static String[] getAvailableIDs(int n) {
        Set<String> set = TimeZone.getAvailableIDs(SystemTimeZoneType.ANY, null, n);
        return set.toArray(new String[0]);
    }

    public static String[] getAvailableIDs(String string) {
        Set<String> set = TimeZone.getAvailableIDs(SystemTimeZoneType.ANY, string, null);
        return set.toArray(new String[0]);
    }

    public static String[] getAvailableIDs() {
        Set<String> set = TimeZone.getAvailableIDs(SystemTimeZoneType.ANY, null, null);
        return set.toArray(new String[0]);
    }

    public static int countEquivalentIDs(String string) {
        return ZoneMeta.countEquivalentIDs(string);
    }

    public static String getEquivalentID(String string, int n) {
        return ZoneMeta.getEquivalentID(string, n);
    }

    public static synchronized TimeZone getDefault() {
        if (defaultZone == null) {
            if (TZ_IMPL == 1) {
                defaultZone = new JavaTimeZone();
            } else {
                java.util.TimeZone timeZone = java.util.TimeZone.getDefault();
                defaultZone = TimeZone.getFrozenTimeZone(timeZone.getID());
            }
        }
        return defaultZone.cloneAsThawed();
    }

    public static synchronized void setDefault(TimeZone timeZone) {
        defaultZone = timeZone;
        java.util.TimeZone timeZone2 = null;
        if (defaultZone instanceof JavaTimeZone) {
            timeZone2 = ((JavaTimeZone)defaultZone).unwrap();
        } else if (timeZone != null) {
            String string;
            if (timeZone instanceof OlsonTimeZone && !(string = timeZone.getID()).equals((timeZone2 = java.util.TimeZone.getTimeZone(string)).getID())) {
                timeZone2 = null;
            }
            if (timeZone2 == null) {
                timeZone2 = TimeZoneAdapter.wrap(timeZone);
            }
        }
        java.util.TimeZone.setDefault(timeZone2);
    }

    public boolean hasSameRules(TimeZone timeZone) {
        return timeZone != null && this.getRawOffset() == timeZone.getRawOffset() && this.useDaylightTime() == timeZone.useDaylightTime();
    }

    public Object clone() {
        if (this.isFrozen()) {
            return this;
        }
        return this.cloneAsThawed();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        return this.ID.equals(((TimeZone)object).ID);
    }

    public int hashCode() {
        return this.ID.hashCode();
    }

    public static synchronized String getTZDataVersion() {
        if (TZDATA_VERSION == null) {
            UResourceBundle uResourceBundle = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", "zoneinfo64");
            TZDATA_VERSION = uResourceBundle.getString("TZVersion");
        }
        return TZDATA_VERSION;
    }

    public static String getCanonicalID(String string) {
        return TimeZone.getCanonicalID(string, null);
    }

    public static String getCanonicalID(String string, boolean[] blArray) {
        String string2 = null;
        boolean bl = false;
        if (string != null && string.length() != 0) {
            if (string.equals(UNKNOWN_ZONE_ID)) {
                string2 = UNKNOWN_ZONE_ID;
                bl = false;
            } else {
                string2 = ZoneMeta.getCanonicalCLDRID(string);
                if (string2 != null) {
                    bl = true;
                } else {
                    string2 = ZoneMeta.getCustomID(string);
                }
            }
        }
        if (blArray != null) {
            blArray[0] = bl;
        }
        return string2;
    }

    public static String getRegion(String string) {
        String string2 = null;
        if (!string.equals(UNKNOWN_ZONE_ID)) {
            string2 = ZoneMeta.getRegion(string);
        }
        if (string2 == null) {
            throw new IllegalArgumentException("Unknown system zone id: " + string);
        }
        return string2;
    }

    @Override
    public boolean isFrozen() {
        return false;
    }

    @Override
    public TimeZone freeze() {
        throw new UnsupportedOperationException("Needs to be implemented by the subclass.");
    }

    @Override
    public TimeZone cloneAsThawed() {
        try {
            TimeZone timeZone = (TimeZone)super.clone();
            return timeZone;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    static {
        String string = ICUConfig.get(TZIMPL_CONFIG_KEY, TZIMPL_CONFIG_ICU);
        if (string.equalsIgnoreCase(TZIMPL_CONFIG_JDK)) {
            TZ_IMPL = 1;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum SystemTimeZoneType {
        ANY,
        CANONICAL,
        CANONICAL_LOCATION;

    }
}

