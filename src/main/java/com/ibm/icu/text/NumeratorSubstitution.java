/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.NFRuleSet;
import com.ibm.icu.text.NFSubstitution;
import com.ibm.icu.text.RuleBasedNumberFormat;
import java.text.ParsePosition;

public class NumeratorSubstitution
extends NFSubstitution {
    double denominator;
    boolean withZeros;

    NumeratorSubstitution(int n, double d, NFRuleSet nFRuleSet, RuleBasedNumberFormat ruleBasedNumberFormat, String string) {
        super(n, nFRuleSet, ruleBasedNumberFormat, NumeratorSubstitution.fixdesc(string));
        this.denominator = d;
        this.withZeros = string.endsWith("<<");
    }

    static String fixdesc(String string) {
        return string.endsWith("<<") ? string.substring(0, string.length() - 1) : string;
    }

    public boolean equals(Object object) {
        if (super.equals(object)) {
            NumeratorSubstitution numeratorSubstitution = (NumeratorSubstitution)object;
            return this.denominator == numeratorSubstitution.denominator;
        }
        return false;
    }

    public int hashCode() {
        assert (false) : "hashCode not designed";
        return 42;
    }

    public void doSubstitution(double d, StringBuffer stringBuffer, int n) {
        double d2 = this.transformNumber(d);
        if (this.withZeros && this.ruleSet != null) {
            long l = (long)d2;
            int n2 = stringBuffer.length();
            while (true) {
                long l2;
                l *= 10L;
                if (!((double)l2 < this.denominator)) break;
                stringBuffer.insert(n + this.pos, ' ');
                this.ruleSet.format(0L, stringBuffer, n + this.pos);
            }
            n += stringBuffer.length() - n2;
        }
        if (d2 == Math.floor(d2) && this.ruleSet != null) {
            this.ruleSet.format((long)d2, stringBuffer, n + this.pos);
        } else if (this.ruleSet != null) {
            this.ruleSet.format(d2, stringBuffer, n + this.pos);
        } else {
            stringBuffer.insert(n + this.pos, this.numberFormat.format(d2));
        }
    }

    public long transformNumber(long l) {
        return Math.round((double)l * this.denominator);
    }

    public double transformNumber(double d) {
        return Math.round(d * this.denominator);
    }

    public Number doParse(String string, ParsePosition parsePosition, double d, double d2, boolean bl) {
        Object object;
        int n = 0;
        if (this.withZeros) {
            object = string;
            ParsePosition parsePosition2 = new ParsePosition(1);
            while (((String)object).length() > 0 && parsePosition2.getIndex() != 0) {
                parsePosition2.setIndex(0);
                this.ruleSet.parse((String)object, parsePosition2, 1.0).intValue();
                if (parsePosition2.getIndex() == 0) break;
                ++n;
                parsePosition.setIndex(parsePosition.getIndex() + parsePosition2.getIndex());
                object = ((String)object).substring(parsePosition2.getIndex());
                while (((String)object).length() > 0 && ((String)object).charAt(0) == ' ') {
                    object = ((String)object).substring(1);
                    parsePosition.setIndex(parsePosition.getIndex() + 1);
                }
            }
            string = string.substring(parsePosition.getIndex());
            parsePosition.setIndex(0);
        }
        object = super.doParse(string, parsePosition, this.withZeros ? 1.0 : d, d2, false);
        if (this.withZeros) {
            long l;
            long l2 = ((Number)object).longValue();
            for (l = 1L; l <= l2; l *= 10L) {
            }
            while (n > 0) {
                l *= 10L;
                --n;
            }
            object = new Double((double)l2 / (double)l);
        }
        return object;
    }

    public double composeRuleValue(double d, double d2) {
        return d / d2;
    }

    public double calcUpperBound(double d) {
        return this.denominator;
    }

    char tokenChar() {
        return '<';
    }
}

