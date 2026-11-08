/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.NFRule;
import com.ibm.icu.text.NFRuleSet;
import com.ibm.icu.text.NFSubstitution;
import com.ibm.icu.text.RuleBasedNumberFormat;
import java.text.ParsePosition;

public class ModulusSubstitution
extends NFSubstitution {
    double divisor;
    NFRule ruleToUse;

    ModulusSubstitution(int n, double d, NFRule nFRule, NFRuleSet nFRuleSet, RuleBasedNumberFormat ruleBasedNumberFormat, String string) {
        super(n, nFRuleSet, ruleBasedNumberFormat, string);
        this.divisor = d;
        if (d == 0.0) {
            throw new IllegalStateException("Substitution with bad divisor (" + d + ") " + string.substring(0, n) + " | " + string.substring(n));
        }
        this.ruleToUse = string.equals(">>>") ? nFRule : null;
    }

    public void setDivisor(int n, int n2) {
        this.divisor = Math.pow(n, n2);
        if (this.divisor == 0.0) {
            throw new IllegalStateException("Substitution with bad divisor");
        }
    }

    public boolean equals(Object object) {
        if (super.equals(object)) {
            ModulusSubstitution modulusSubstitution = (ModulusSubstitution)object;
            return this.divisor == modulusSubstitution.divisor;
        }
        return false;
    }

    public int hashCode() {
        assert (false) : "hashCode not designed";
        return 42;
    }

    public void doSubstitution(long l, StringBuffer stringBuffer, int n) {
        if (this.ruleToUse == null) {
            super.doSubstitution(l, stringBuffer, n);
        } else {
            long l2 = this.transformNumber(l);
            this.ruleToUse.doFormat(l2, stringBuffer, n + this.pos);
        }
    }

    public void doSubstitution(double d, StringBuffer stringBuffer, int n) {
        if (this.ruleToUse == null) {
            super.doSubstitution(d, stringBuffer, n);
        } else {
            double d2 = this.transformNumber(d);
            this.ruleToUse.doFormat(d2, stringBuffer, n + this.pos);
        }
    }

    public long transformNumber(long l) {
        return (long)Math.floor((double)l % this.divisor);
    }

    public double transformNumber(double d) {
        return Math.floor(d % this.divisor);
    }

    public Number doParse(String string, ParsePosition parsePosition, double d, double d2, boolean bl) {
        if (this.ruleToUse == null) {
            return super.doParse(string, parsePosition, d, d2, bl);
        }
        Number number = this.ruleToUse.doParse(string, parsePosition, false, d2);
        if (parsePosition.getIndex() != 0) {
            double d3 = number.doubleValue();
            if ((d3 = this.composeRuleValue(d3, d)) == (double)((long)d3)) {
                return (long)d3;
            }
            return new Double(d3);
        }
        return number;
    }

    public double composeRuleValue(double d, double d2) {
        return d2 - d2 % this.divisor + d;
    }

    public double calcUpperBound(double d) {
        return this.divisor;
    }

    public boolean isModulusSubstitution() {
        return true;
    }

    char tokenChar() {
        return '>';
    }
}

