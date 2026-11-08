/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.AbsoluteValueSubstitution;
import com.ibm.icu.text.DecimalFormat;
import com.ibm.icu.text.FractionalPartSubstitution;
import com.ibm.icu.text.IntegralPartSubstitution;
import com.ibm.icu.text.ModulusSubstitution;
import com.ibm.icu.text.MultiplierSubstitution;
import com.ibm.icu.text.NFRule;
import com.ibm.icu.text.NFRuleSet;
import com.ibm.icu.text.NullSubstitution;
import com.ibm.icu.text.NumeratorSubstitution;
import com.ibm.icu.text.RuleBasedNumberFormat;
import com.ibm.icu.text.SameValueSubstitution;
import java.text.ParsePosition;

public abstract class NFSubstitution {
    int pos;
    NFRuleSet ruleSet = null;
    DecimalFormat numberFormat = null;
    RuleBasedNumberFormat rbnf = null;

    public static NFSubstitution makeSubstitution(int n, NFRule nFRule, NFRule nFRule2, NFRuleSet nFRuleSet, RuleBasedNumberFormat ruleBasedNumberFormat, String string) {
        if (string.length() == 0) {
            return new NullSubstitution(n, nFRuleSet, ruleBasedNumberFormat, string);
        }
        switch (string.charAt(0)) {
            case '<': {
                if (nFRule.getBaseValue() == -1L) {
                    throw new IllegalArgumentException("<< not allowed in negative-number rule");
                }
                if (nFRule.getBaseValue() == -2L || nFRule.getBaseValue() == -3L || nFRule.getBaseValue() == -4L) {
                    return new IntegralPartSubstitution(n, nFRuleSet, ruleBasedNumberFormat, string);
                }
                if (nFRuleSet.isFractionSet()) {
                    return new NumeratorSubstitution(n, nFRule.getBaseValue(), ruleBasedNumberFormat.getDefaultRuleSet(), ruleBasedNumberFormat, string);
                }
                return new MultiplierSubstitution(n, nFRule.getDivisor(), nFRuleSet, ruleBasedNumberFormat, string);
            }
            case '>': {
                if (nFRule.getBaseValue() == -1L) {
                    return new AbsoluteValueSubstitution(n, nFRuleSet, ruleBasedNumberFormat, string);
                }
                if (nFRule.getBaseValue() == -2L || nFRule.getBaseValue() == -3L || nFRule.getBaseValue() == -4L) {
                    return new FractionalPartSubstitution(n, nFRuleSet, ruleBasedNumberFormat, string);
                }
                if (nFRuleSet.isFractionSet()) {
                    throw new IllegalArgumentException(">> not allowed in fraction rule set");
                }
                return new ModulusSubstitution(n, nFRule.getDivisor(), nFRule2, nFRuleSet, ruleBasedNumberFormat, string);
            }
            case '=': {
                return new SameValueSubstitution(n, nFRuleSet, ruleBasedNumberFormat, string);
            }
        }
        throw new IllegalArgumentException("Illegal substitution character");
    }

    NFSubstitution(int n, NFRuleSet nFRuleSet, RuleBasedNumberFormat ruleBasedNumberFormat, String string) {
        this.pos = n;
        this.rbnf = ruleBasedNumberFormat;
        if (string.length() >= 2 && string.charAt(0) == string.charAt(string.length() - 1)) {
            string = string.substring(1, string.length() - 1);
        } else if (string.length() != 0) {
            throw new IllegalArgumentException("Illegal substitution syntax");
        }
        if (string.length() == 0) {
            this.ruleSet = nFRuleSet;
        } else if (string.charAt(0) == '%') {
            this.ruleSet = ruleBasedNumberFormat.findRuleSet(string);
        } else if (string.charAt(0) == '#' || string.charAt(0) == '0') {
            this.numberFormat = new DecimalFormat(string);
            this.numberFormat.setDecimalFormatSymbols(ruleBasedNumberFormat.getDecimalFormatSymbols());
        } else if (string.charAt(0) == '>') {
            this.ruleSet = nFRuleSet;
            this.numberFormat = null;
        } else {
            throw new IllegalArgumentException("Illegal substitution syntax");
        }
    }

    public void setDivisor(int n, int n2) {
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (this.getClass() == object.getClass()) {
            NFSubstitution nFSubstitution = (NFSubstitution)object;
            return this.pos == nFSubstitution.pos && (this.ruleSet != null || nFSubstitution.ruleSet == null) && (this.numberFormat == null ? nFSubstitution.numberFormat == null : this.numberFormat.equals(nFSubstitution.numberFormat));
        }
        return false;
    }

    public int hashCode() {
        assert (false) : "hashCode not designed";
        return 42;
    }

    public String toString() {
        if (this.ruleSet != null) {
            return this.tokenChar() + this.ruleSet.getName() + this.tokenChar();
        }
        return this.tokenChar() + this.numberFormat.toPattern() + this.tokenChar();
    }

    public void doSubstitution(long l, StringBuffer stringBuffer, int n) {
        if (this.ruleSet != null) {
            long l2 = this.transformNumber(l);
            this.ruleSet.format(l2, stringBuffer, n + this.pos);
        } else {
            double d = this.transformNumber((double)l);
            if (this.numberFormat.getMaximumFractionDigits() == 0) {
                d = Math.floor(d);
            }
            stringBuffer.insert(n + this.pos, this.numberFormat.format(d));
        }
    }

    public void doSubstitution(double d, StringBuffer stringBuffer, int n) {
        double d2 = this.transformNumber(d);
        if (d2 == Math.floor(d2) && this.ruleSet != null) {
            this.ruleSet.format((long)d2, stringBuffer, n + this.pos);
        } else if (this.ruleSet != null) {
            this.ruleSet.format(d2, stringBuffer, n + this.pos);
        } else {
            stringBuffer.insert(n + this.pos, this.numberFormat.format(d2));
        }
    }

    public abstract long transformNumber(long var1);

    public abstract double transformNumber(double var1);

    public Number doParse(String string, ParsePosition parsePosition, double d, double d2, boolean bl) {
        Number number;
        d2 = this.calcUpperBound(d2);
        if (this.ruleSet != null) {
            number = this.ruleSet.parse(string, parsePosition, d2);
            if (bl && !this.ruleSet.isFractionSet() && parsePosition.getIndex() == 0) {
                number = this.rbnf.getDecimalFormat().parse(string, parsePosition);
            }
        } else {
            number = this.numberFormat.parse(string, parsePosition);
        }
        if (parsePosition.getIndex() != 0) {
            double d3 = number.doubleValue();
            if ((d3 = this.composeRuleValue(d3, d)) == (double)((long)d3)) {
                return (long)d3;
            }
            return new Double(d3);
        }
        return number;
    }

    public abstract double composeRuleValue(double var1, double var3);

    public abstract double calcUpperBound(double var1);

    public final int getPos() {
        return this.pos;
    }

    abstract char tokenChar();

    public boolean isNullSubstitution() {
        return false;
    }

    public boolean isModulusSubstitution() {
        return false;
    }
}

