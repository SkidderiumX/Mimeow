/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.util.DateRule;
import java.util.Date;

public class Range {
    public Date start;
    public DateRule rule;

    public Range(Date date, DateRule dateRule) {
        this.start = date;
        this.rule = dateRule;
    }
}

