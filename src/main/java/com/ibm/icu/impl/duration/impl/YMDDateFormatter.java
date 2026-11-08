/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl.duration.impl;

import com.ibm.icu.impl.duration.DateFormatter;
import com.ibm.icu.impl.duration.impl.Utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class YMDDateFormatter
implements DateFormatter {
    private String requestedFields;
    private String localeName;
    private TimeZone timeZone;
    private SimpleDateFormat df;

    public YMDDateFormatter(String string) {
        this(string, Locale.getDefault().toString(), TimeZone.getDefault());
    }

    public YMDDateFormatter(String string, String string2, TimeZone timeZone) {
        this.requestedFields = string;
        this.localeName = string2;
        this.timeZone = timeZone;
        Locale locale = Utils.localeFromString(string2);
        this.df = new SimpleDateFormat("yyyy/mm/dd", locale);
        this.df.setTimeZone(timeZone);
    }

    public String format(long l) {
        return this.format(new Date(l));
    }

    public String format(Date date) {
        return this.df.format(date);
    }

    public DateFormatter withLocale(String string) {
        if (!string.equals(this.localeName)) {
            return new YMDDateFormatter(this.requestedFields, string, this.timeZone);
        }
        return this;
    }

    public DateFormatter withTimeZone(TimeZone timeZone) {
        if (!timeZone.equals(this.timeZone)) {
            return new YMDDateFormatter(this.requestedFields, this.localeName, timeZone);
        }
        return this;
    }
}

