/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.CalendarData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.MessageFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Comparator;
import java.util.Date;
import java.util.MissingResourceException;
import java.util.TreeSet;

public class RelativeDateFormat
extends DateFormat {
    private static final long serialVersionUID = 1131984966440549435L;
    private DateFormat fDateFormat;
    private DateFormat fTimeFormat;
    private MessageFormat fCombinedFormat;
    private SimpleDateFormat fDateTimeFormat = null;
    private String fDatePattern = null;
    private String fTimePattern = null;
    int fDateStyle;
    int fTimeStyle;
    ULocale fLocale;
    private transient URelativeString[] fDates = null;

    public RelativeDateFormat(int n, int n2, ULocale uLocale) {
        this.fLocale = uLocale;
        this.fTimeStyle = n;
        this.fDateStyle = n2;
        if (this.fDateStyle != -1) {
            int n3 = this.fDateStyle & 0xFFFFFF7F;
            DateFormat dateFormat = DateFormat.getDateInstance(n3, uLocale);
            if (!(dateFormat instanceof SimpleDateFormat)) {
                throw new IllegalArgumentException("Can't create SimpleDateFormat for date style");
            }
            this.fDateTimeFormat = (SimpleDateFormat)dateFormat;
            this.fDatePattern = this.fDateTimeFormat.toPattern();
            if (this.fTimeStyle != -1 && (dateFormat = DateFormat.getTimeInstance(n3 = this.fTimeStyle & 0xFFFFFF7F, uLocale)) instanceof SimpleDateFormat) {
                this.fTimePattern = ((SimpleDateFormat)dateFormat).toPattern();
            }
        } else {
            int n4 = this.fTimeStyle & 0xFFFFFF7F;
            DateFormat dateFormat = DateFormat.getTimeInstance(n4, uLocale);
            if (!(dateFormat instanceof SimpleDateFormat)) {
                throw new IllegalArgumentException("Can't create SimpleDateFormat for time style");
            }
            this.fDateTimeFormat = (SimpleDateFormat)dateFormat;
            this.fTimePattern = this.fDateTimeFormat.toPattern();
        }
        this.initializeCalendar(null, this.fLocale);
        this.loadDates();
        this.initializeCombinedFormat(this.calendar, this.fLocale);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        String string = null;
        if (this.fDateStyle != -1) {
            int n = RelativeDateFormat.dayDifference(calendar);
            string = this.getStringForDay(n);
        }
        if (this.fDateTimeFormat != null && (this.fDatePattern != null || this.fTimePattern != null)) {
            if (this.fDatePattern == null) {
                this.fDateTimeFormat.applyPattern(this.fTimePattern);
                this.fDateTimeFormat.format(calendar, stringBuffer, fieldPosition);
            } else if (this.fTimePattern == null) {
                if (string != null) {
                    stringBuffer.append(string);
                } else {
                    this.fDateTimeFormat.applyPattern(this.fDatePattern);
                    this.fDateTimeFormat.format(calendar, stringBuffer, fieldPosition);
                }
            } else {
                String string2 = this.fDatePattern;
                if (string != null) {
                    string2 = "'" + string.replace("'", "''") + "'";
                }
                StringBuffer stringBuffer2 = new StringBuffer("");
                this.fCombinedFormat.format(new Object[]{this.fTimePattern, string2}, stringBuffer2, new FieldPosition(0));
                this.fDateTimeFormat.applyPattern(stringBuffer2.toString());
                this.fDateTimeFormat.format(calendar, stringBuffer, fieldPosition);
            }
        } else if (this.fDateFormat != null) {
            if (string != null) {
                stringBuffer.append(string);
            } else {
                this.fDateFormat.format(calendar, stringBuffer, fieldPosition);
            }
        }
        return stringBuffer;
    }

    public void parse(String string, Calendar calendar, ParsePosition parsePosition) {
        throw new UnsupportedOperationException("Relative Date parse is not implemented yet");
    }

    private String getStringForDay(int n) {
        if (this.fDates == null) {
            this.loadDates();
        }
        for (int i = 0; i < this.fDates.length; ++i) {
            if (this.fDates[i].offset != n) continue;
            return this.fDates[i].string;
        }
        return null;
    }

    private synchronized void loadDates() {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle)UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt51b", this.fLocale);
        ICUResourceBundle iCUResourceBundle2 = iCUResourceBundle.getWithFallback("fields/day/relative");
        TreeSet<URelativeString> treeSet = new TreeSet<URelativeString>(new Comparator<URelativeString>(){

            @Override
            public int compare(URelativeString uRelativeString, URelativeString uRelativeString2) {
                if (uRelativeString.offset == uRelativeString2.offset) {
                    return 0;
                }
                if (uRelativeString.offset < uRelativeString2.offset) {
                    return -1;
                }
                return 1;
            }
        });
        UResourceBundleIterator uResourceBundleIterator = iCUResourceBundle2.getIterator();
        while (uResourceBundleIterator.hasNext()) {
            UResourceBundle uResourceBundle = uResourceBundleIterator.next();
            String string = uResourceBundle.getKey();
            String string2 = uResourceBundle.getString();
            URelativeString uRelativeString = new URelativeString(string, string2);
            treeSet.add(uRelativeString);
        }
        this.fDates = treeSet.toArray(new URelativeString[0]);
    }

    private static int dayDifference(Calendar calendar) {
        Calendar calendar2 = (Calendar)calendar.clone();
        Date date = new Date(System.currentTimeMillis());
        calendar2.clear();
        calendar2.setTime(date);
        int n = calendar.get(20) - calendar2.get(20);
        return n;
    }

    private Calendar initializeCalendar(TimeZone timeZone, ULocale uLocale) {
        if (this.calendar == null) {
            this.calendar = timeZone == null ? Calendar.getInstance(uLocale) : Calendar.getInstance(timeZone, uLocale);
        }
        return this.calendar;
    }

    private MessageFormat initializeCombinedFormat(Calendar calendar, ULocale uLocale) {
        String string = "{1} {0}";
        try {
            CalendarData calendarData = new CalendarData(uLocale, calendar.getType());
            String[] stringArray = calendarData.getDateTimePatterns();
            if (stringArray != null && stringArray.length >= 9) {
                int n = 8;
                if (stringArray.length >= 13) {
                    switch (this.fDateStyle) {
                        case 0: 
                        case 128: {
                            ++n;
                            break;
                        }
                        case 1: 
                        case 129: {
                            n += 2;
                            break;
                        }
                        case 2: 
                        case 130: {
                            n += 3;
                            break;
                        }
                        case 3: 
                        case 131: {
                            n += 4;
                            break;
                        }
                    }
                }
                string = stringArray[n];
            }
        }
        catch (MissingResourceException missingResourceException) {
            // empty catch block
        }
        this.fCombinedFormat = new MessageFormat(string, uLocale);
        return this.fCombinedFormat;
    }

    public static class URelativeString {
        public int offset;
        public String string;

        URelativeString(int n, String string) {
            this.offset = n;
            this.string = string;
        }

        URelativeString(String string, String string2) {
            this.offset = Integer.parseInt(string);
            this.string = string2;
        }
    }
}

