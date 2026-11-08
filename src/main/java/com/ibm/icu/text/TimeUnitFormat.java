/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.text.MeasureFormat;
import com.ibm.icu.text.MessageFormat;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.TimeUnit;
import com.ibm.icu.util.TimeUnitAmount;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TimeUnitFormat
extends MeasureFormat {
    public static final int FULL_NAME = 0;
    public static final int ABBREVIATED_NAME = 1;
    private static final int TOTAL_STYLES = 2;
    private static final long serialVersionUID = -3707773153184971529L;
    private static final String DEFAULT_PATTERN_FOR_SECOND = "{0} s";
    private static final String DEFAULT_PATTERN_FOR_MINUTE = "{0} min";
    private static final String DEFAULT_PATTERN_FOR_HOUR = "{0} h";
    private static final String DEFAULT_PATTERN_FOR_DAY = "{0} d";
    private static final String DEFAULT_PATTERN_FOR_WEEK = "{0} w";
    private static final String DEFAULT_PATTERN_FOR_MONTH = "{0} m";
    private static final String DEFAULT_PATTERN_FOR_YEAR = "{0} y";
    private NumberFormat format;
    private ULocale locale;
    private transient Map<TimeUnit, Map<String, Object[]>> timeUnitToCountToPatterns;
    private transient PluralRules pluralRules;
    private transient boolean isReady;
    private int style;

    public TimeUnitFormat() {
        this.isReady = false;
        this.style = 0;
    }

    public TimeUnitFormat(ULocale uLocale) {
        this(uLocale, 0);
    }

    public TimeUnitFormat(Locale locale) {
        this(locale, 0);
    }

    public TimeUnitFormat(ULocale uLocale, int n) {
        if (n < 0 || n >= 2) {
            throw new IllegalArgumentException("style should be either FULL_NAME or ABBREVIATED_NAME style");
        }
        this.style = n;
        this.locale = uLocale;
        this.isReady = false;
    }

    public TimeUnitFormat(Locale locale, int n) {
        this(ULocale.forLocale(locale), n);
    }

    public TimeUnitFormat setLocale(ULocale uLocale) {
        if (uLocale != this.locale) {
            this.locale = uLocale;
            this.isReady = false;
        }
        return this;
    }

    public TimeUnitFormat setLocale(Locale locale) {
        return this.setLocale(ULocale.forLocale(locale));
    }

    public TimeUnitFormat setNumberFormat(NumberFormat numberFormat) {
        if (numberFormat == this.format) {
            return this;
        }
        if (numberFormat == null) {
            if (this.locale == null) {
                this.isReady = false;
                return this;
            }
            this.format = NumberFormat.getNumberInstance(this.locale);
        } else {
            this.format = numberFormat;
        }
        if (!this.isReady) {
            return this;
        }
        for (Map<String, Object[]> map : this.timeUnitToCountToPatterns.values()) {
            for (Object[] objectArray : map.values()) {
                MessageFormat messageFormat = (MessageFormat)objectArray[0];
                messageFormat.setFormatByArgumentIndex(0, numberFormat);
                messageFormat = (MessageFormat)objectArray[1];
                messageFormat.setFormatByArgumentIndex(0, numberFormat);
            }
        }
        return this;
    }

    @Override
    public StringBuffer format(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (!(object instanceof TimeUnitAmount)) {
            throw new IllegalArgumentException("can not format non TimeUnitAmount object");
        }
        if (!this.isReady) {
            this.setup();
        }
        TimeUnitAmount timeUnitAmount = (TimeUnitAmount)object;
        Map<String, Object[]> map = this.timeUnitToCountToPatterns.get(timeUnitAmount.getTimeUnit());
        double d = timeUnitAmount.getNumber().doubleValue();
        String string = this.pluralRules.select(d);
        MessageFormat messageFormat = (MessageFormat)map.get(string)[this.style];
        return messageFormat.format(new Object[]{timeUnitAmount.getNumber()}, stringBuffer, fieldPosition);
    }

    @Override
    public Object parseObject(String string, ParsePosition parsePosition) {
        if (!this.isReady) {
            this.setup();
        }
        Number number = null;
        TimeUnit timeUnit = null;
        int n = parsePosition.getIndex();
        int n2 = -1;
        int n3 = 0;
        String string2 = null;
        for (TimeUnit timeUnit2 : this.timeUnitToCountToPatterns.keySet()) {
            Map<String, Object[]> map = this.timeUnitToCountToPatterns.get(timeUnit2);
            for (Map.Entry<String, Object[]> entry : map.entrySet()) {
                String string3 = entry.getKey();
                for (int i = 0; i < 2; ++i) {
                    int n4;
                    String string4;
                    MessageFormat messageFormat = (MessageFormat)entry.getValue()[i];
                    parsePosition.setErrorIndex(-1);
                    parsePosition.setIndex(n);
                    Object object = messageFormat.parseObject(string, parsePosition);
                    if (parsePosition.getErrorIndex() != -1 || parsePosition.getIndex() == n) continue;
                    Number number2 = null;
                    if (((Object[])object).length != 0 && !string3.equals(string4 = this.pluralRules.select((number2 = (Number)((Object[])object)[0]).doubleValue())) || (n4 = parsePosition.getIndex() - n) <= n3) continue;
                    number = number2;
                    timeUnit = timeUnit2;
                    n2 = parsePosition.getIndex();
                    n3 = n4;
                    string2 = string3;
                }
            }
        }
        if (number == null && n3 != 0) {
            number = string2.equals("zero") ? Integer.valueOf(0) : (string2.equals("one") ? Integer.valueOf(1) : (string2.equals("two") ? Integer.valueOf(2) : Integer.valueOf(3)));
        }
        if (n3 == 0) {
            parsePosition.setIndex(n);
            parsePosition.setErrorIndex(0);
            return null;
        }
        parsePosition.setIndex(n2);
        parsePosition.setErrorIndex(-1);
        return new TimeUnitAmount(number, timeUnit);
    }

    private void setup() {
        if (this.locale == null) {
            this.locale = this.format != null ? this.format.getLocale(null) : ULocale.getDefault(ULocale.Category.FORMAT);
        }
        if (this.format == null) {
            this.format = NumberFormat.getNumberInstance(this.locale);
        }
        this.pluralRules = PluralRules.forLocale(this.locale);
        this.timeUnitToCountToPatterns = new HashMap<TimeUnit, Map<String, Object[]>>();
        Set<String> set = this.pluralRules.getKeywords();
        this.setup("units", this.timeUnitToCountToPatterns, 0, set);
        this.setup("unitsShort", this.timeUnitToCountToPatterns, 1, set);
        this.isReady = true;
    }

    private void setup(String string, Map<TimeUnit, Map<String, Object[]>> map, int n, Set<String> set) {
        Object object;
        Object object2;
        Map<String, Object[]> map2;
        int n2;
        Object object3;
        Object object4;
        try {
            object4 = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", this.locale);
            object3 = ((ICUResourceBundle)object4).getWithFallback(string);
            n2 = ((UResourceBundle)object3).getSize();
            for (int i = 0; i < n2; ++i) {
                map2 = ((UResourceBundle)object3).get(i).getKey();
                object2 = null;
                if (((String)((Object)map2)).equals("year")) {
                    object2 = TimeUnit.YEAR;
                } else if (((String)((Object)map2)).equals("month")) {
                    object2 = TimeUnit.MONTH;
                } else if (((String)((Object)map2)).equals("day")) {
                    object2 = TimeUnit.DAY;
                } else if (((String)((Object)map2)).equals("hour")) {
                    object2 = TimeUnit.HOUR;
                } else if (((String)((Object)map2)).equals("minute")) {
                    object2 = TimeUnit.MINUTE;
                } else if (((String)((Object)map2)).equals("second")) {
                    object2 = TimeUnit.SECOND;
                } else {
                    if (!((String)((Object)map2)).equals("week")) continue;
                    object2 = TimeUnit.WEEK;
                }
                object = ((ICUResourceBundle)object3).getWithFallback((String)((Object)map2));
                int n3 = ((UResourceBundle)object).getSize();
                Map<String, Object[]> map3 = map.get(object2);
                if (map3 == null) {
                    map3 = new TreeMap<String, Object[]>();
                    map.put((TimeUnit)object2, map3);
                }
                for (int j = 0; j < n3; ++j) {
                    Object[] objectArray;
                    String string2 = ((UResourceBundle)object).get(j).getKey();
                    if (!set.contains(string2)) continue;
                    String string3 = ((UResourceBundle)object).get(j).getString();
                    MessageFormat messageFormat = new MessageFormat(string3, this.locale);
                    if (this.format != null) {
                        messageFormat.setFormatByArgumentIndex(0, this.format);
                    }
                    if ((objectArray = map3.get(string2)) == null) {
                        objectArray = new Object[2];
                        map3.put(string2, objectArray);
                    }
                    objectArray[n] = messageFormat;
                }
            }
        }
        catch (MissingResourceException missingResourceException) {
            // empty catch block
        }
        object4 = TimeUnit.values();
        object3 = this.pluralRules.getKeywords();
        for (n2 = 0; n2 < ((Object)object4).length; ++n2) {
            Object object5 = object4[n2];
            map2 = map.get(object5);
            if (map2 == null) {
                map2 = new TreeMap<String, Object[]>();
                map.put((TimeUnit)object5, map2);
            }
            object2 = object3.iterator();
            while (object2.hasNext()) {
                object = (String)object2.next();
                if (map2.get(object) != null && ((Object[])map2.get(object))[n] != null) continue;
                this.searchInTree(string, n, (TimeUnit)object5, (String)object, (String)object, map2);
            }
        }
    }

    private void searchInTree(String string, int n, TimeUnit timeUnit, String string2, String string3, Map<String, Object[]> map) {
        ULocale uLocale;
        String string4 = timeUnit.toString();
        for (uLocale = this.locale; uLocale != null; uLocale = uLocale.getFallback()) {
            try {
                Object[] objectArray;
                ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", uLocale);
                iCUResourceBundle = iCUResourceBundle.getWithFallback(string);
                ICUResourceBundle iCUResourceBundle2 = iCUResourceBundle.getWithFallback(string4);
                String string5 = iCUResourceBundle2.getStringWithFallback(string3);
                MessageFormat messageFormat = new MessageFormat(string5, this.locale);
                if (this.format != null) {
                    messageFormat.setFormatByArgumentIndex(0, this.format);
                }
                if ((objectArray = map.get(string2)) == null) {
                    objectArray = new Object[2];
                    map.put(string2, objectArray);
                }
                objectArray[n] = messageFormat;
                return;
            }
            catch (MissingResourceException missingResourceException) {
                continue;
            }
        }
        if (uLocale == null && string.equals("unitsShort")) {
            this.searchInTree("units", n, timeUnit, string2, string3, map);
            if (map != null && map.get(string2) != null && map.get(string2)[n] != null) {
                return;
            }
        }
        if (string3.equals("other")) {
            Object[] objectArray;
            MessageFormat messageFormat = null;
            if (timeUnit == TimeUnit.SECOND) {
                messageFormat = new MessageFormat(DEFAULT_PATTERN_FOR_SECOND, this.locale);
            } else if (timeUnit == TimeUnit.MINUTE) {
                messageFormat = new MessageFormat(DEFAULT_PATTERN_FOR_MINUTE, this.locale);
            } else if (timeUnit == TimeUnit.HOUR) {
                messageFormat = new MessageFormat(DEFAULT_PATTERN_FOR_HOUR, this.locale);
            } else if (timeUnit == TimeUnit.WEEK) {
                messageFormat = new MessageFormat(DEFAULT_PATTERN_FOR_WEEK, this.locale);
            } else if (timeUnit == TimeUnit.DAY) {
                messageFormat = new MessageFormat(DEFAULT_PATTERN_FOR_DAY, this.locale);
            } else if (timeUnit == TimeUnit.MONTH) {
                messageFormat = new MessageFormat(DEFAULT_PATTERN_FOR_MONTH, this.locale);
            } else if (timeUnit == TimeUnit.YEAR) {
                messageFormat = new MessageFormat(DEFAULT_PATTERN_FOR_YEAR, this.locale);
            }
            if (this.format != null && messageFormat != null) {
                messageFormat.setFormatByArgumentIndex(0, this.format);
            }
            if ((objectArray = map.get(string2)) == null) {
                objectArray = new Object[2];
                map.put(string2, objectArray);
            }
            objectArray[n] = messageFormat;
        } else {
            this.searchInTree(string, n, timeUnit, string2, "other", map);
        }
    }
}

