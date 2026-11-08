/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.util.TimeZone;
import java.util.Date;

public class TimeZoneAdapter
extends java.util.TimeZone {
    static final long serialVersionUID = -2040072218820018557L;
    private TimeZone zone;

    public static java.util.TimeZone wrap(TimeZone timeZone) {
        return new TimeZoneAdapter(timeZone);
    }

    public TimeZone unwrap() {
        return this.zone;
    }

    public TimeZoneAdapter(TimeZone timeZone) {
        this.zone = timeZone;
        super.setID(timeZone.getID());
    }

    public void setID(String string) {
        super.setID(string);
        this.zone.setID(string);
    }

    public boolean hasSameRules(java.util.TimeZone timeZone) {
        return timeZone instanceof TimeZoneAdapter && this.zone.hasSameRules(((TimeZoneAdapter)timeZone).zone);
    }

    public int getOffset(int n, int n2, int n3, int n4, int n5, int n6) {
        return this.zone.getOffset(n, n2, n3, n4, n5, n6);
    }

    public int getRawOffset() {
        return this.zone.getRawOffset();
    }

    public void setRawOffset(int n) {
        this.zone.setRawOffset(n);
    }

    public boolean useDaylightTime() {
        return this.zone.useDaylightTime();
    }

    public boolean inDaylightTime(Date date) {
        return this.zone.inDaylightTime(date);
    }

    public Object clone() {
        return new TimeZoneAdapter((TimeZone)this.zone.clone());
    }

    public synchronized int hashCode() {
        return this.zone.hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof TimeZoneAdapter) {
            object = ((TimeZoneAdapter)object).zone;
        }
        return this.zone.equals(object);
    }

    public String toString() {
        return "TimeZoneAdapter: " + this.zone.toString();
    }
}

