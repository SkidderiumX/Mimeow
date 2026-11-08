/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.NFRuleSet;
import com.ibm.icu.text.NFSubstitution;
import com.ibm.icu.text.RuleBasedNumberFormat;

public class SameValueSubstitution
extends NFSubstitution {
    SameValueSubstitution(int n, NFRuleSet nFRuleSet, RuleBasedNumberFormat ruleBasedNumberFormat, String string) {
        super(n, nFRuleSet, ruleBasedNumberFormat, string);
        if (string.equals("==")) {
            throw new IllegalArgumentException("== is not a legal token");
        }
    }

    public long transformNumber(long l) {
        return l;
    }

    public double transformNumber(double d) {
        return d;
    }

    public double composeRuleValue(double d, double d2) {
        return d;
    }

    public double calcUpperBound(double d) {
        return d;
    }

    char tokenChar() {
        return '=';
    }
}

