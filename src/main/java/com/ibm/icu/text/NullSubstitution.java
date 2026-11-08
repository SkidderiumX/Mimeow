/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.NFRuleSet;
import com.ibm.icu.text.NFSubstitution;
import com.ibm.icu.text.RuleBasedNumberFormat;
import java.text.ParsePosition;

public class NullSubstitution
extends NFSubstitution {
    NullSubstitution(int n, NFRuleSet nFRuleSet, RuleBasedNumberFormat ruleBasedNumberFormat, String string) {
        super(n, nFRuleSet, ruleBasedNumberFormat, string);
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public int hashCode() {
        assert (false) : "hashCode not designed";
        return 42;
    }

    public String toString() {
        return "";
    }

    public void doSubstitution(long l, StringBuffer stringBuffer, int n) {
    }

    public void doSubstitution(double d, StringBuffer stringBuffer, int n) {
    }

    public long transformNumber(long l) {
        return 0L;
    }

    public double transformNumber(double d) {
        return 0.0;
    }

    public Number doParse(String string, ParsePosition parsePosition, double d, double d2, boolean bl) {
        if (d == (double)((long)d)) {
            return (long)d;
        }
        return new Double(d);
    }

    public double composeRuleValue(double d, double d2) {
        return 0.0;
    }

    public double calcUpperBound(double d) {
        return 0.0;
    }

    public boolean isNullSubstitution() {
        return true;
    }

    char tokenChar() {
        return ' ';
    }
}

