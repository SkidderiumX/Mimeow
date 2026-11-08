/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.impl.CalendarAstronomer;
import com.ibm.icu.impl.CalendarCache;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import java.util.Date;
import java.util.Locale;

public class IslamicCalendar
extends Calendar {
    private static final long serialVersionUID = -6253365474073869325L;
    public static final int MUHARRAM = 0;
    public static final int SAFAR = 1;
    public static final int RABI_1 = 2;
    public static final int RABI_2 = 3;
    public static final int JUMADA_1 = 4;
    public static final int JUMADA_2 = 5;
    public static final int RAJAB = 6;
    public static final int SHABAN = 7;
    public static final int RAMADAN = 8;
    public static final int SHAWWAL = 9;
    public static final int DHU_AL_QIDAH = 10;
    public static final int DHU_AL_HIJJAH = 11;
    private static final long HIJRA_MILLIS = -42521587200000L;
    private static final int[][] LIMITS = new int[][]{{0, 0, 0, 0}, {1, 1, 5000000, 5000000}, {0, 0, 11, 11}, {1, 1, 50, 51}, new int[0], {1, 1, 29, 30}, {1, 1, 354, 355}, new int[0], {-1, -1, 5, 5}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], {1, 1, 5000000, 5000000}, new int[0], {1, 1, 5000000, 5000000}, new int[0], new int[0]};
    private static CalendarAstronomer astro = new CalendarAstronomer();
    private static CalendarCache cache = new CalendarCache();
    private boolean civil = true;

    public IslamicCalendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public IslamicCalendar(TimeZone timeZone) {
        this(timeZone, ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public IslamicCalendar(Locale locale) {
        this(TimeZone.getDefault(), locale);
    }

    public IslamicCalendar(ULocale uLocale) {
        this(TimeZone.getDefault(), uLocale);
    }

    public IslamicCalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
        this.setTimeInMillis(System.currentTimeMillis());
    }

    public IslamicCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
        this.setTimeInMillis(System.currentTimeMillis());
    }

    public IslamicCalendar(Date date) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        this.setTime(date);
    }

    public IslamicCalendar(int n, int n2, int n3) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        this.set(1, n);
        this.set(2, n2);
        this.set(5, n3);
    }

    public IslamicCalendar(int n, int n2, int n3, int n4, int n5, int n6) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        this.set(1, n);
        this.set(2, n2);
        this.set(5, n3);
        this.set(11, n4);
        this.set(12, n5);
        this.set(13, n6);
    }

    public void setCivil(boolean bl) {
        if (this.civil != bl) {
            long l = this.getTimeInMillis();
            this.civil = bl;
            this.clear();
            this.setTimeInMillis(l);
        }
    }

    public boolean isCivil() {
        return this.civil;
    }

    protected int handleGetLimit(int n, int n2) {
        return LIMITS[n][n2];
    }

    private static final boolean civilLeapYear(int n) {
        return (14 + 11 * n) % 30 < 11;
    }

    private long yearStart(int n) {
        if (this.civil) {
            return (long)((n - 1) * 354) + (long)Math.floor((double)(3 + 11 * n) / 30.0);
        }
        return IslamicCalendar.trueMonthStart(12 * (n - 1));
    }

    private long monthStart(int n, int n2) {
        int n3 = n + n2 / 12;
        int n4 = n2 % 12;
        if (this.civil) {
            return (long)Math.ceil(29.5 * (double)n4) + (long)((n3 - 1) * 354) + (long)Math.floor((double)(3 + 11 * n3) / 30.0);
        }
        return IslamicCalendar.trueMonthStart(12 * (n3 - 1) + n4);
    }

    private static final long trueMonthStart(long l) {
        long l2 = cache.get(l);
        if (l2 == CalendarCache.EMPTY) {
            long l3 = -42521587200000L + (long)Math.floor((double)l * 29.530588853) * 86400000L;
            double d = IslamicCalendar.moonAge(l3);
            if (IslamicCalendar.moonAge(l3) >= 0.0) {
                while ((d = IslamicCalendar.moonAge(l3 -= 86400000L)) >= 0.0) {
                }
            } else {
                while ((d = IslamicCalendar.moonAge(l3 += 86400000L)) < 0.0) {
                }
            }
            l2 = (l3 - -42521587200000L) / 86400000L + 1L;
            cache.put(l, l2);
        }
        return l2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static final double moonAge(long l) {
        double d = 0.0;
        CalendarAstronomer calendarAstronomer = astro;
        synchronized (calendarAstronomer) {
            astro.setTime(l);
            d = astro.getMoonAge();
        }
        d = d * 180.0 / Math.PI;
        if (d > 180.0) {
            d -= 360.0;
        }
        return d;
    }

    protected int handleGetMonthLength(int n, int n2) {
        int n3 = 0;
        if (this.civil) {
            n3 = 29 + (n2 + 1) % 2;
            if (n2 == 11 && IslamicCalendar.civilLeapYear(n)) {
                ++n3;
            }
        } else {
            n2 = 12 * (n - 1) + n2;
            n3 = (int)(IslamicCalendar.trueMonthStart(n2 + 1) - IslamicCalendar.trueMonthStart(n2));
        }
        return n3;
    }

    protected int handleGetYearLength(int n) {
        if (this.civil) {
            return 354 + (IslamicCalendar.civilLeapYear(n) ? 1 : 0);
        }
        int n2 = 12 * (n - 1);
        return (int)(IslamicCalendar.trueMonthStart(n2 + 12) - IslamicCalendar.trueMonthStart(n2));
    }

    protected int handleComputeMonthStart(int n, int n2, boolean bl) {
        return (int)this.monthStart(n, n2) + 1948439;
    }

    protected int handleGetExtendedYear() {
        int n = this.newerField(19, 1) == 19 ? this.internalGet(19, 1) : this.internalGet(1, 1);
        return n;
    }

    protected void handleComputeFields(int n) {
        int n2;
        int n3;
        long l = n - 1948440;
        if (this.civil) {
            n3 = (int)Math.floor((double)(30L * l + 10646L) / 10631.0);
            n2 = (int)Math.ceil((double)(l - 29L - this.yearStart(n3)) / 29.5);
            n2 = Math.min(n2, 11);
        } else {
            int n4 = (int)Math.floor((double)l / 29.530588853);
            long l2 = (long)Math.floor((double)n4 * 29.530588853 - 1.0);
            if (l - l2 >= 25L && IslamicCalendar.moonAge(this.internalGetTimeInMillis()) > 0.0) {
                ++n4;
            }
            while ((l2 = IslamicCalendar.trueMonthStart(n4)) > l) {
                --n4;
            }
            n3 = n4 / 12 + 1;
            n2 = n4 % 12;
        }
        int n5 = (int)(l - this.monthStart(n3, n2)) + 1;
        int n6 = (int)(l - this.monthStart(n3, 0) + 1L);
        this.internalSet(0, 0);
        this.internalSet(1, n3);
        this.internalSet(19, n3);
        this.internalSet(2, n2);
        this.internalSet(5, n5);
        this.internalSet(6, n6);
    }

    public String getType() {
        if (this.civil) {
            return "islamic-civil";
        }
        return "islamic";
    }
}

