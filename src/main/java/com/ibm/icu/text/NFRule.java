/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.text.NFRuleSet;
import com.ibm.icu.text.NFSubstitution;
import com.ibm.icu.text.RbnfLenientScanner;
import com.ibm.icu.text.RuleBasedNumberFormat;
import java.text.ParsePosition;

public class NFRule {
    public static final int NEGATIVE_NUMBER_RULE = -1;
    public static final int IMPROPER_FRACTION_RULE = -2;
    public static final int PROPER_FRACTION_RULE = -3;
    public static final int MASTER_RULE = -4;
    private long baseValue;
    private int radix = 10;
    private short exponent = 0;
    private String ruleText = null;
    private NFSubstitution sub1 = null;
    private NFSubstitution sub2 = null;
    private RuleBasedNumberFormat formatter = null;

    public static Object makeRules(String string, NFRuleSet nFRuleSet, NFRule nFRule, RuleBasedNumberFormat ruleBasedNumberFormat) {
        NFRule nFRule2 = new NFRule(ruleBasedNumberFormat);
        string = nFRule2.parseRuleDescriptor(string);
        int n = string.indexOf("[");
        int n2 = string.indexOf("]");
        if (n == -1 || n2 == -1 || n > n2 || nFRule2.getBaseValue() == -3L || nFRule2.getBaseValue() == -1L) {
            nFRule2.ruleText = string;
            nFRule2.extractSubstitutions(nFRuleSet, nFRule, ruleBasedNumberFormat);
            return nFRule2;
        }
        NFRule nFRule3 = null;
        StringBuilder stringBuilder = new StringBuilder();
        if (nFRule2.baseValue > 0L && (double)nFRule2.baseValue % Math.pow(nFRule2.radix, nFRule2.exponent) == 0.0 || nFRule2.baseValue == -2L || nFRule2.baseValue == -4L) {
            nFRule3 = new NFRule(ruleBasedNumberFormat);
            if (nFRule2.baseValue >= 0L) {
                nFRule3.baseValue = nFRule2.baseValue++;
                if (!nFRuleSet.isFractionSet()) {
                    // empty if block
                }
            } else if (nFRule2.baseValue == -2L) {
                nFRule3.baseValue = -3L;
            } else if (nFRule2.baseValue == -4L) {
                nFRule3.baseValue = nFRule2.baseValue;
                nFRule2.baseValue = -2L;
            }
            nFRule3.radix = nFRule2.radix;
            nFRule3.exponent = nFRule2.exponent;
            stringBuilder.append(string.substring(0, n));
            if (n2 + 1 < string.length()) {
                stringBuilder.append(string.substring(n2 + 1));
            }
            nFRule3.ruleText = stringBuilder.toString();
            nFRule3.extractSubstitutions(nFRuleSet, nFRule, ruleBasedNumberFormat);
        }
        stringBuilder.setLength(0);
        stringBuilder.append(string.substring(0, n));
        stringBuilder.append(string.substring(n + 1, n2));
        if (n2 + 1 < string.length()) {
            stringBuilder.append(string.substring(n2 + 1));
        }
        nFRule2.ruleText = stringBuilder.toString();
        nFRule2.extractSubstitutions(nFRuleSet, nFRule, ruleBasedNumberFormat);
        if (nFRule3 == null) {
            return nFRule2;
        }
        return new NFRule[]{nFRule3, nFRule2};
    }

    public NFRule(RuleBasedNumberFormat ruleBasedNumberFormat) {
        this.formatter = ruleBasedNumberFormat;
    }

    private String parseRuleDescriptor(String string) {
        int n = string.indexOf(":");
        if (n == -1) {
            this.setBaseValue(0L);
        } else {
            String string2 = string.substring(0, n);
            ++n;
            while (n < string.length() && PatternProps.isWhiteSpace(string.charAt(n))) {
                ++n;
            }
            string = string.substring(n);
            if (string2.equals("-x")) {
                this.setBaseValue(-1L);
            } else if (string2.equals("x.x")) {
                this.setBaseValue(-2L);
            } else if (string2.equals("0.x")) {
                this.setBaseValue(-3L);
            } else if (string2.equals("x.0")) {
                this.setBaseValue(-4L);
            } else if (string2.charAt(0) >= '0' && string2.charAt(0) <= '9') {
                StringBuilder stringBuilder = new StringBuilder();
                char c = ' ';
                for (n = 0; n < string2.length(); ++n) {
                    c = string2.charAt(n);
                    if (c >= '0' && c <= '9') {
                        stringBuilder.append(c);
                        continue;
                    }
                    if (c == 47 || c == '>') break;
                    if (PatternProps.isWhiteSpace(c) || c == ',' || c == '.') continue;
                    throw new IllegalArgumentException("Illegal character in rule descriptor");
                }
                this.setBaseValue(Long.parseLong(stringBuilder.toString()));
                if (c == '/') {
                    stringBuilder.setLength(0);
                    ++n;
                    while (n < string2.length()) {
                        c = string2.charAt(n);
                        if (c >= '0' && c <= '9') {
                            stringBuilder.append(c);
                        } else {
                            if (c == '>') break;
                            if (!PatternProps.isWhiteSpace(c) && c != ',' && c != '.') {
                                throw new IllegalArgumentException("Illegal character is rule descriptor");
                            }
                        }
                        ++n;
                    }
                    this.radix = Integer.parseInt(stringBuilder.toString());
                    if (this.radix == 0) {
                        throw new IllegalArgumentException("Rule can't have radix of 0");
                    }
                    this.exponent = this.expectedExponent();
                }
                if (c == '>') {
                    while (n < string2.length()) {
                        c = string2.charAt(n);
                        if (c != '>' || this.exponent <= 0) {
                            throw new IllegalArgumentException("Illegal character in rule descriptor");
                        }
                        this.exponent = (short)(this.exponent - 1);
                        ++n;
                    }
                }
            }
        }
        if (string.length() > 0 && string.charAt(0) == '\'') {
            string = string.substring(1);
        }
        return string;
    }

    private void extractSubstitutions(NFRuleSet nFRuleSet, NFRule nFRule, RuleBasedNumberFormat ruleBasedNumberFormat) {
        this.sub1 = this.extractSubstitution(nFRuleSet, nFRule, ruleBasedNumberFormat);
        this.sub2 = this.extractSubstitution(nFRuleSet, nFRule, ruleBasedNumberFormat);
    }

    private NFSubstitution extractSubstitution(NFRuleSet nFRuleSet, NFRule nFRule, RuleBasedNumberFormat ruleBasedNumberFormat) {
        int n;
        NFSubstitution nFSubstitution = null;
        int n2 = this.indexOfAny(new String[]{"<<", "<%", "<#", "<0", ">>", ">%", ">#", ">0", "=%", "=#", "=0"});
        if (n2 == -1) {
            return NFSubstitution.makeSubstitution(this.ruleText.length(), this, nFRule, nFRuleSet, ruleBasedNumberFormat, "");
        }
        if (this.ruleText.substring(n2).startsWith(">>>")) {
            n = n2 + 2;
        } else {
            char c = this.ruleText.charAt(n2);
            n = this.ruleText.indexOf(c, n2 + 1);
            if (c == '<' && n != -1 && n < this.ruleText.length() - 1 && this.ruleText.charAt(n + 1) == c) {
                ++n;
            }
        }
        if (n == -1) {
            return NFSubstitution.makeSubstitution(this.ruleText.length(), this, nFRule, nFRuleSet, ruleBasedNumberFormat, "");
        }
        nFSubstitution = NFSubstitution.makeSubstitution(n2, this, nFRule, nFRuleSet, ruleBasedNumberFormat, this.ruleText.substring(n2, n + 1));
        this.ruleText = this.ruleText.substring(0, n2) + this.ruleText.substring(n + 1);
        return nFSubstitution;
    }

    public final void setBaseValue(long l) {
        this.baseValue = l;
        if (this.baseValue >= 1L) {
            this.radix = 10;
            this.exponent = this.expectedExponent();
            if (this.sub1 != null) {
                this.sub1.setDivisor(this.radix, this.exponent);
            }
            if (this.sub2 != null) {
                this.sub2.setDivisor(this.radix, this.exponent);
            }
        } else {
            this.radix = 10;
            this.exponent = 0;
        }
    }

    private short expectedExponent() {
        if (this.radix == 0 || this.baseValue < 1L) {
            return 0;
        }
        short s = (short)(Math.log(this.baseValue) / Math.log(this.radix));
        if (Math.pow(this.radix, s + 1) <= (double)this.baseValue) {
            return (short)(s + 1);
        }
        return s;
    }

    private int indexOfAny(String[] stringArray) {
        int n = -1;
        for (int i = 0; i < stringArray.length; ++i) {
            int n2 = this.ruleText.indexOf(stringArray[i]);
            if (n2 == -1 || n != -1 && n2 >= n) continue;
            n = n2;
        }
        return n;
    }

    public boolean equals(Object object) {
        if (object instanceof NFRule) {
            NFRule nFRule = (NFRule)object;
            return this.baseValue == nFRule.baseValue && this.radix == nFRule.radix && this.exponent == nFRule.exponent && this.ruleText.equals(nFRule.ruleText) && this.sub1.equals(nFRule.sub1) && this.sub2.equals(nFRule.sub2);
        }
        return false;
    }

    public int hashCode() {
        assert (false) : "hashCode not designed";
        return 42;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.baseValue == -1L) {
            stringBuilder.append("-x: ");
        } else if (this.baseValue == -2L) {
            stringBuilder.append("x.x: ");
        } else if (this.baseValue == -3L) {
            stringBuilder.append("0.x: ");
        } else if (this.baseValue == -4L) {
            stringBuilder.append("x.0: ");
        } else {
            stringBuilder.append(String.valueOf(this.baseValue));
            if (this.radix != 10) {
                stringBuilder.append('/');
                stringBuilder.append(String.valueOf(this.radix));
            }
            int n = this.expectedExponent() - this.exponent;
            for (int i = 0; i < n; ++i) {
                stringBuilder.append('>');
            }
            stringBuilder.append(": ");
        }
        if (this.ruleText.startsWith(" ") && (this.sub1 == null || this.sub1.getPos() != 0)) {
            stringBuilder.append("'");
        }
        StringBuilder stringBuilder2 = new StringBuilder(this.ruleText);
        stringBuilder2.insert(this.sub2.getPos(), this.sub2.toString());
        stringBuilder2.insert(this.sub1.getPos(), this.sub1.toString());
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append(';');
        return stringBuilder.toString();
    }

    public final long getBaseValue() {
        return this.baseValue;
    }

    public double getDivisor() {
        return Math.pow(this.radix, this.exponent);
    }

    public void doFormat(long l, StringBuffer stringBuffer, int n) {
        stringBuffer.insert(n, this.ruleText);
        this.sub2.doSubstitution(l, stringBuffer, n);
        this.sub1.doSubstitution(l, stringBuffer, n);
    }

    public void doFormat(double d, StringBuffer stringBuffer, int n) {
        stringBuffer.insert(n, this.ruleText);
        this.sub2.doSubstitution(d, stringBuffer, n);
        this.sub1.doSubstitution(d, stringBuffer, n);
    }

    public boolean shouldRollBack(double d) {
        if (this.sub1.isModulusSubstitution() || this.sub2.isModulusSubstitution()) {
            return d % Math.pow(this.radix, this.exponent) == 0.0 && (double)this.baseValue % Math.pow(this.radix, this.exponent) != 0.0;
        }
        return false;
    }

    public Number doParse(String string, ParsePosition parsePosition, boolean bl, double d) {
        ParsePosition parsePosition2 = new ParsePosition(0);
        String string2 = this.stripPrefix(string, this.ruleText.substring(0, this.sub1.getPos()), parsePosition2);
        int n = string.length() - string2.length();
        if (parsePosition2.getIndex() == 0 && this.sub1.getPos() != 0) {
            return 0L;
        }
        int n2 = 0;
        double d2 = 0.0;
        int n3 = 0;
        double d3 = Math.max(0L, this.baseValue);
        do {
            parsePosition2.setIndex(0);
            double d4 = this.matchToDelimiter(string2, n3, d3, this.ruleText.substring(this.sub1.getPos(), this.sub2.getPos()), parsePosition2, this.sub1, d).doubleValue();
            if (parsePosition2.getIndex() == 0 && !this.sub1.isNullSubstitution()) continue;
            n3 = parsePosition2.getIndex();
            String string3 = string2.substring(parsePosition2.getIndex());
            ParsePosition parsePosition3 = new ParsePosition(0);
            d4 = this.matchToDelimiter(string3, 0, d4, this.ruleText.substring(this.sub2.getPos()), parsePosition3, this.sub2, d).doubleValue();
            if (parsePosition3.getIndex() == 0 && !this.sub2.isNullSubstitution() || n + parsePosition2.getIndex() + parsePosition3.getIndex() <= n2) continue;
            n2 = n + parsePosition2.getIndex() + parsePosition3.getIndex();
            d2 = d4;
        } while (this.sub1.getPos() != this.sub2.getPos() && parsePosition2.getIndex() > 0 && parsePosition2.getIndex() < string2.length() && parsePosition2.getIndex() != n3);
        parsePosition.setIndex(n2);
        if (bl && n2 > 0 && this.sub1.isNullSubstitution()) {
            d2 = 1.0 / d2;
        }
        if (d2 == (double)((long)d2)) {
            return (long)d2;
        }
        return new Double(d2);
    }

    private String stripPrefix(String string, String string2, ParsePosition parsePosition) {
        if (string2.length() == 0) {
            return string;
        }
        int n = this.prefixLength(string, string2);
        if (n != 0) {
            parsePosition.setIndex(parsePosition.getIndex() + n);
            return string.substring(n);
        }
        return string;
    }

    private Number matchToDelimiter(String string, int n, double d, String string2, ParsePosition parsePosition, NFSubstitution nFSubstitution, double d2) {
        if (!this.allIgnorable(string2)) {
            ParsePosition parsePosition2 = new ParsePosition(0);
            int[] nArray = this.findText(string, string2, n);
            int n2 = nArray[0];
            int n3 = nArray[1];
            while (n2 >= 0) {
                String string3 = string.substring(0, n2);
                if (string3.length() > 0) {
                    Number number = nFSubstitution.doParse(string3, parsePosition2, d, d2, this.formatter.lenientParseEnabled());
                    if (parsePosition2.getIndex() == n2) {
                        parsePosition.setIndex(n2 + n3);
                        return number;
                    }
                }
                parsePosition2.setIndex(0);
                nArray = this.findText(string, string2, n2 + n3);
                n2 = nArray[0];
                n3 = nArray[1];
            }
            parsePosition.setIndex(0);
            return 0L;
        }
        ParsePosition parsePosition3 = new ParsePosition(0);
        Number number = 0L;
        Number number2 = nFSubstitution.doParse(string, parsePosition3, d, d2, this.formatter.lenientParseEnabled());
        if (parsePosition3.getIndex() != 0 || nFSubstitution.isNullSubstitution()) {
            parsePosition.setIndex(parsePosition3.getIndex());
            if (number2 != null) {
                number = number2;
            }
        }
        return number;
    }

    private int prefixLength(String string, String string2) {
        if (string2.length() == 0) {
            return 0;
        }
        RbnfLenientScanner rbnfLenientScanner = this.formatter.getLenientScanner();
        if (rbnfLenientScanner != null) {
            return rbnfLenientScanner.prefixLength(string, string2);
        }
        if (string.startsWith(string2)) {
            return string2.length();
        }
        return 0;
    }

    private int[] findText(String string, String string2, int n) {
        RbnfLenientScanner rbnfLenientScanner = this.formatter.getLenientScanner();
        if (rbnfLenientScanner == null) {
            return new int[]{string.indexOf(string2, n), string2.length()};
        }
        return rbnfLenientScanner.findText(string, string2, n);
    }

    private boolean allIgnorable(String string) {
        if (string.length() == 0) {
            return true;
        }
        RbnfLenientScanner rbnfLenientScanner = this.formatter.getLenientScanner();
        if (rbnfLenientScanner != null) {
            return rbnfLenientScanner.allIgnorable(string);
        }
        return false;
    }
}

