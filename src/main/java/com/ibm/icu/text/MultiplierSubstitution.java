/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.NFRuleSet;
import com.ibm.icu.text.NFSubstitution;
import com.ibm.icu.text.RuleBasedNumberFormat;

public class MultiplierSubstitution
extends NFSubstitution {
    double divisor;

    MultiplierSubstitution(int n, double d, NFRuleSet nFRuleSet, RuleBasedNumberFormat ruleBasedNumberFormat, String string) {
        super(n, nFRuleSet, ruleBasedNumberFormat, string);
        this.divisor = d;
        if (d == 0.0) {
            throw new IllegalStateException("Substitution with bad divisor (" + d + ") " + string.substring(0, n) + " | " + string.substring(n));
        }
    }

    public void setDivisor(int n, int n2) {
        this.divisor = Math.pow(n, n2);
        if (this.divisor == 0.0) {
            throw new IllegalStateException("Substitution with divisor 0");
        }
    }

    public boolean equals(Object object) {
        if (super.equals(object)) {
            MultiplierSubstitution multiplierSubstitution = (MultiplierSubstitution)object;
            return this.divisor == multiplierSubstitution.divisor;
        }
        return false;
    }

    public int hashCode() {
        assert (false) : "hashCode not designed";
        return 42;
    }

    public long transformNumber(long l) {
        return (long)Math.floor((double)l / this.divisor);
    }

    public double transformNumber(double d) {
        if (this.ruleSet == null) {
            return d / this.divisor;
        }
        return Math.floor(d / this.divisor);
    }

    public double composeRuleValue(double d, double d2) {
        return d * this.divisor;
    }

    public double calcUpperBound(double d) {
        return this.divisor;
    }

    char tokenChar() {
        return '<';
    }
}

