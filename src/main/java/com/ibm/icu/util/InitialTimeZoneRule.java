/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.util.TimeZoneRule;
import java.util.Date;

public class InitialTimeZoneRule
extends TimeZoneRule {
    private static final long serialVersionUID = 1876594993064051206L;

    public InitialTimeZoneRule(String string, int n, int n2) {
        super(string, n, n2);
    }

    public boolean isEquivalentTo(TimeZoneRule timeZoneRule) {
        if (timeZoneRule instanceof InitialTimeZoneRule) {
            return super.isEquivalentTo(timeZoneRule);
        }
        return false;
    }

    public Date getFinalStart(int n, int n2) {
        return null;
    }

    public Date getFirstStart(int n, int n2) {
        return null;
    }

    public Date getNextStart(long l, int n, int n2, boolean bl) {
        return null;
    }

    public Date getPreviousStart(long l, int n, int n2, boolean bl) {
        return null;
    }

    public boolean isTransitionRule() {
        return false;
    }
}

