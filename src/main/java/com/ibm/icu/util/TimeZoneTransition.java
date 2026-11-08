/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.util.TimeZoneRule;

public class TimeZoneTransition {
    private final TimeZoneRule from;
    private final TimeZoneRule f94e27d8b13;
    private final long time;

    public TimeZoneTransition(long l, TimeZoneRule timeZoneRule, TimeZoneRule timeZoneRule2) {
        this.time = l;
        this.from = timeZoneRule;
        this.f94e27d8b13 = timeZoneRule2;
    }

    public long getTime() {
        return this.time;
    }

    public TimeZoneRule getTo() {
        return this.f94e27d8b13;
    }

    public TimeZoneRule getFrom() {
        return this.from;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("time=" + this.time);
        stringBuilder.append(", from={" + this.from + "}");
        stringBuilder.append(", to={" + this.f94e27d8b13 + "}");
        return stringBuilder.toString();
    }
}

