/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.util.Measure;
import com.ibm.icu.util.TimeUnit;

public class TimeUnitAmount
extends Measure {
    public TimeUnitAmount(Number number, TimeUnit timeUnit) {
        super(number, timeUnit);
    }

    public TimeUnitAmount(double d, TimeUnit timeUnit) {
        super(new Double(d), timeUnit);
    }

    public TimeUnit getTimeUnit() {
        return (TimeUnit)this.getUnit();
    }
}

