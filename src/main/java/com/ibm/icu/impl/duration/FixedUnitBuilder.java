/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl.duration;

import com.ibm.icu.impl.duration.BasicPeriodBuilderFactory;
import com.ibm.icu.impl.duration.Period;
import com.ibm.icu.impl.duration.PeriodBuilder;
import com.ibm.icu.impl.duration.PeriodBuilderImpl;
import com.ibm.icu.impl.duration.TimeUnit;

public class FixedUnitBuilder
extends PeriodBuilderImpl {
    private TimeUnit unit;

    public static FixedUnitBuilder get(TimeUnit timeUnit, BasicPeriodBuilderFactory.Settings settings) {
        if (settings != null && (settings.effectiveSet() & 1 << timeUnit.ordinal) != 0) {
            return new FixedUnitBuilder(timeUnit, settings);
        }
        return null;
    }

    FixedUnitBuilder(TimeUnit timeUnit, BasicPeriodBuilderFactory.Settings settings) {
        super(settings);
        this.unit = timeUnit;
    }

    protected PeriodBuilder withSettings(BasicPeriodBuilderFactory.Settings settings) {
        return FixedUnitBuilder.get(this.unit, settings);
    }

    protected Period handleCreate(long l, long l2, boolean bl) {
        if (this.unit == null) {
            return null;
        }
        long l3 = this.approximateDurationOf(this.unit);
        return Period.at((float)((double)l / (double)l3), this.unit).inPast(bl);
    }
}

