/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import java.io.Serializable;

public class DateInterval
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final long fromDate;
    private final long toDate;

    public DateInterval(long l, long l2) {
        this.fromDate = l;
        this.toDate = l2;
    }

    public long getFromDate() {
        return this.fromDate;
    }

    public long getToDate() {
        return this.toDate;
    }

    public boolean equals(Object object) {
        if (object instanceof DateInterval) {
            DateInterval dateInterval = (DateInterval)object;
            return this.fromDate == dateInterval.fromDate && this.toDate == dateInterval.toDate;
        }
        return false;
    }

    public int hashCode() {
        return (int)(this.fromDate + this.toDate);
    }

    public String toString() {
        return String.valueOf(this.fromDate) + " " + String.valueOf(this.toDate);
    }
}

