/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.CalendarData;
import com.ibm.icu.text.DateFormatSymbols;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ChineseCalendar;
import com.ibm.icu.util.ULocale;
import java.util.Locale;

public class ChineseDateFormatSymbols
extends DateFormatSymbols {
    static final long serialVersionUID = 6827816119783952890L;
    String[] isLeapMonth;

    public ChineseDateFormatSymbols() {
        this(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public ChineseDateFormatSymbols(Locale locale) {
        super(ChineseCalendar.class, ULocale.forLocale(locale));
    }

    public ChineseDateFormatSymbols(ULocale uLocale) {
        super(ChineseCalendar.class, uLocale);
    }

    public ChineseDateFormatSymbols(Calendar calendar, Locale locale) {
        super(calendar == null ? null : calendar.getClass(), locale);
    }

    public ChineseDateFormatSymbols(Calendar calendar, ULocale uLocale) {
        super(calendar == null ? null : calendar.getClass(), uLocale);
    }

    public String getLeapMonth(int n) {
        return this.isLeapMonth[n];
    }

    protected void initializeData(ULocale uLocale, CalendarData calendarData) {
        super.initializeData(uLocale, calendarData);
        this.initializeIsLeapMonth();
    }

    void initializeData(DateFormatSymbols dateFormatSymbols) {
        super.initializeData(dateFormatSymbols);
        if (dateFormatSymbols instanceof ChineseDateFormatSymbols) {
            this.isLeapMonth = ((ChineseDateFormatSymbols)dateFormatSymbols).isLeapMonth;
        } else {
            this.initializeIsLeapMonth();
        }
    }

    private void initializeIsLeapMonth() {
        this.isLeapMonth = new String[2];
        this.isLeapMonth[0] = "";
        this.isLeapMonth[1] = this.leapMonthPatterns != null ? this.leapMonthPatterns[0].replace("{0}", "") : "";
    }
}

