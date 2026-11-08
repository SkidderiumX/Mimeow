/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.NFRuleSet;
import com.ibm.icu.text.NFSubstitution;
import com.ibm.icu.text.RuleBasedNumberFormat;

public class AbsoluteValueSubstitution
extends NFSubstitution {
    AbsoluteValueSubstitution(int n, NFRuleSet nFRuleSet, RuleBasedNumberFormat ruleBasedNumberFormat, String string) {
        super(n, nFRuleSet, ruleBasedNumberFormat, string);
    }

    public long transformNumber(long l) {
        return Math.abs(l);
    }

    public double transformNumber(double d) {
        return Math.abs(d);
    }

    public double composeRuleValue(double d, double d2) {
        return -d;
    }

    public double calcUpperBound(double d) {
        return Double.MAX_VALUE;
    }

    char tokenChar() {
        return '>';
    }
}

