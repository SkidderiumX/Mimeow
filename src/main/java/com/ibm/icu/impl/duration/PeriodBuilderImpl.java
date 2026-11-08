/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl.duration;

import com.ibm.icu.impl.duration.BasicPeriodBuilderFactory;
import com.ibm.icu.impl.duration.Period;
import com.ibm.icu.impl.duration.PeriodBuilder;
import com.ibm.icu.impl.duration.TimeUnit;
import java.util.TimeZone;

public abstract class PeriodBuilderImpl
implements PeriodBuilder {
    protected BasicPeriodBuilderFactory.Settings settings;

    public Period create(long l) {
        return this.createWithReferenceDate(l, System.currentTimeMillis());
    }

    public long approximateDurationOf(TimeUnit timeUnit) {
        return BasicPeriodBuilderFactory.approximateDurationOf(timeUnit);
    }

    public Period createWithReferenceDate(long l, long l2) {
        Period period;
        boolean bl;
        boolean bl2 = bl = l < 0L;
        if (bl) {
            l = -l;
        }
        if ((period = this.settings.createLimited(l, bl)) == null && (period = this.handleCreate(l, l2, bl)) == null) {
            period = Period.lessThan(1.0f, this.settings.effectiveMinUnit()).inPast(bl);
        }
        return period;
    }

    public PeriodBuilder withTimeZone(TimeZone timeZone) {
        return this;
    }

    public PeriodBuilder withLocale(String string) {
        BasicPeriodBuilderFactory.Settings settings = this.settings.setLocale(string);
        if (settings != this.settings) {
            return this.withSettings(settings);
        }
        return this;
    }

    protected abstract PeriodBuilder withSettings(BasicPeriodBuilderFactory.Settings var1);

    protected abstract Period handleCreate(long var1, long var3, boolean var5);

    protected PeriodBuilderImpl(BasicPeriodBuilderFactory.Settings settings) {
        this.settings = settings;
    }
}

