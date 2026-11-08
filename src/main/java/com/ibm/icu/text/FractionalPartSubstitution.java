/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.DigitList;
import com.ibm.icu.text.NFRuleSet;
import com.ibm.icu.text.NFSubstitution;
import com.ibm.icu.text.RuleBasedNumberFormat;
import java.text.ParsePosition;

public class FractionalPartSubstitution
extends NFSubstitution {
    private boolean byDigits = false;
    private boolean useSpaces = true;

    FractionalPartSubstitution(int n, NFRuleSet nFRuleSet, RuleBasedNumberFormat ruleBasedNumberFormat, String string) {
        super(n, nFRuleSet, ruleBasedNumberFormat, string);
        if (string.equals(">>") || string.equals(">>>") || nFRuleSet == this.ruleSet) {
            this.byDigits = true;
            if (string.equals(">>>")) {
                this.useSpaces = false;
            }
        } else {
            this.ruleSet.makeIntoFractionRuleSet();
        }
    }

    public void doSubstitution(double d, StringBuffer stringBuffer, int n) {
        if (!this.byDigits) {
            super.doSubstitution(d, stringBuffer, n);
        } else {
            DigitList digitList = new DigitList();
            digitList.set(d, 20, true);
            boolean bl = false;
            while (digitList.count > Math.max(0, digitList.decimalAt)) {
                if (bl && this.useSpaces) {
                    stringBuffer.insert(n + this.pos, ' ');
                } else {
                    bl = true;
                }
                this.ruleSet.format(digitList.digits[--digitList.count] - 48, stringBuffer, n + this.pos);
            }
            while (digitList.decimalAt < 0) {
                if (bl && this.useSpaces) {
                    stringBuffer.insert(n + this.pos, ' ');
                } else {
                    bl = true;
                }
                this.ruleSet.format(0L, stringBuffer, n + this.pos);
                ++digitList.decimalAt;
            }
        }
    }

    public long transformNumber(long l) {
        return 0L;
    }

    public double transformNumber(double d) {
        return d - Math.floor(d);
    }

    public Number doParse(String string, ParsePosition parsePosition, double d, double d2, boolean bl) {
        if (!this.byDigits) {
            return super.doParse(string, parsePosition, d, 0.0, bl);
        }
        String string2 = string;
        ParsePosition parsePosition2 = new ParsePosition(1);
        double d3 = 0.0;
        DigitList digitList = new DigitList();
        while (string2.length() > 0 && parsePosition2.getIndex() != 0) {
            Number number;
            parsePosition2.setIndex(0);
            int n = this.ruleSet.parse(string2, parsePosition2, 10.0).intValue();
            if (bl && parsePosition2.getIndex() == 0 && (number = this.rbnf.getDecimalFormat().parse(string2, parsePosition2)) != null) {
                n = number.intValue();
            }
            if (parsePosition2.getIndex() == 0) continue;
            digitList.append(48 + n);
            parsePosition.setIndex(parsePosition.getIndex() + parsePosition2.getIndex());
            string2 = string2.substring(parsePosition2.getIndex());
            while (string2.length() > 0 && string2.charAt(0) == ' ') {
                string2 = string2.substring(1);
                parsePosition.setIndex(parsePosition.getIndex() + 1);
            }
        }
        d3 = digitList.count == 0 ? 0.0 : digitList.getDouble();
        d3 = this.composeRuleValue(d3, d);
        return new Double(d3);
    }

    public double composeRuleValue(double d, double d2) {
        return d + d2;
    }

    public double calcUpperBound(double d) {
        return 0.0;
    }

    char tokenChar() {
        return '>';
    }
}

