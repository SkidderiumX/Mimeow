/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.text.NFRule;
import com.ibm.icu.text.RuleBasedNumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;

public class NFRuleSet {
    private String name;
    private NFRule[] rules;
    private NFRule negativeNumberRule = null;
    private NFRule[] fractionRules = new NFRule[3];
    private boolean isFractionRuleSet = false;
    private boolean isParseable = true;
    private int recursionCount = 0;
    private static final int RECURSION_LIMIT = 50;

    public NFRuleSet(String[] stringArray, int n) throws IllegalArgumentException {
        String string = stringArray[n];
        if (string.length() == 0) {
            throw new IllegalArgumentException("Empty rule set description");
        }
        if (string.charAt(0) == '%') {
            int n2 = string.indexOf(58);
            if (n2 == -1) {
                throw new IllegalArgumentException("Rule set name doesn't end in colon");
            }
            this.name = string.substring(0, n2);
            while (n2 < string.length() && PatternProps.isWhiteSpace(string.charAt(++n2))) {
            }
            stringArray[n] = string = string.substring(n2);
        } else {
            this.name = "%default";
        }
        if (string.length() == 0) {
            throw new IllegalArgumentException("Empty rule set description");
        }
        if (this.name.endsWith("@noparse")) {
            this.name = this.name.substring(0, this.name.length() - 8);
            this.isParseable = false;
        }
    }

    public void parseRules(String string, RuleBasedNumberFormat ruleBasedNumberFormat) {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n = 0;
        int n2 = string.indexOf(59);
        while (n != -1) {
            if (n2 != -1) {
                arrayList.add(string.substring(n, n2));
                n = n2 + 1;
            } else {
                if (n < string.length()) {
                    arrayList.add(string.substring(n));
                }
                n = n2;
            }
            n2 = string.indexOf(59, n2 + 1);
        }
        ArrayList<NFRule> arrayList2 = new ArrayList<NFRule>();
        NFRule nFRule = null;
        for (int i = 0; i < arrayList.size(); ++i) {
            Object object = NFRule.makeRules((String)arrayList.get(i), this, nFRule, ruleBasedNumberFormat);
            if (object instanceof NFRule) {
                arrayList2.add((NFRule)object);
                nFRule = (NFRule)object;
                continue;
            }
            if (!(object instanceof NFRule[])) continue;
            NFRule[] nFRuleArray = (NFRule[])object;
            for (int j = 0; j < nFRuleArray.length; ++j) {
                arrayList2.add(nFRuleArray[j]);
                nFRule = nFRuleArray[j];
            }
        }
        arrayList = null;
        long l = 0L;
        int n3 = 0;
        block10: while (n3 < arrayList2.size()) {
            NFRule nFRule2 = (NFRule)arrayList2.get(n3);
            switch ((int)nFRule2.getBaseValue()) {
                case 0: {
                    nFRule2.setBaseValue(l);
                    if (!this.isFractionRuleSet) {
                        ++l;
                    }
                    ++n3;
                    continue block10;
                }
                case -1: {
                    this.negativeNumberRule = nFRule2;
                    arrayList2.remove(n3);
                    continue block10;
                }
                case -2: {
                    this.fractionRules[0] = nFRule2;
                    arrayList2.remove(n3);
                    continue block10;
                }
                case -3: {
                    this.fractionRules[1] = nFRule2;
                    arrayList2.remove(n3);
                    continue block10;
                }
                case -4: {
                    this.fractionRules[2] = nFRule2;
                    arrayList2.remove(n3);
                    continue block10;
                }
            }
            if (nFRule2.getBaseValue() < l) {
                throw new IllegalArgumentException("Rules are not in order, base: " + nFRule2.getBaseValue() + " < " + l);
            }
            l = nFRule2.getBaseValue();
            if (!this.isFractionRuleSet) {
                ++l;
            }
            ++n3;
        }
        this.rules = new NFRule[arrayList2.size()];
        arrayList2.toArray(this.rules);
    }

    public void makeIntoFractionRuleSet() {
        this.isFractionRuleSet = true;
    }

    public boolean equals(Object object) {
        if (!(object instanceof NFRuleSet)) {
            return false;
        }
        NFRuleSet nFRuleSet = (NFRuleSet)object;
        if (!(this.name.equals(nFRuleSet.name) && Utility.objectEquals(this.negativeNumberRule, nFRuleSet.negativeNumberRule) && Utility.objectEquals(this.fractionRules[0], nFRuleSet.fractionRules[0]) && Utility.objectEquals(this.fractionRules[1], nFRuleSet.fractionRules[1]) && Utility.objectEquals(this.fractionRules[2], nFRuleSet.fractionRules[2]) && this.rules.length == nFRuleSet.rules.length && this.isFractionRuleSet == nFRuleSet.isFractionRuleSet)) {
            return false;
        }
        for (int i = 0; i < this.rules.length; ++i) {
            if (this.rules[i].equals(nFRuleSet.rules[i])) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        assert (false) : "hashCode not designed";
        return 42;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name + ":\n");
        for (int i = 0; i < this.rules.length; ++i) {
            stringBuilder.append("    " + this.rules[i].toString() + "\n");
        }
        if (this.negativeNumberRule != null) {
            stringBuilder.append("    " + this.negativeNumberRule.toString() + "\n");
        }
        if (this.fractionRules[0] != null) {
            stringBuilder.append("    " + this.fractionRules[0].toString() + "\n");
        }
        if (this.fractionRules[1] != null) {
            stringBuilder.append("    " + this.fractionRules[1].toString() + "\n");
        }
        if (this.fractionRules[2] != null) {
            stringBuilder.append("    " + this.fractionRules[2].toString() + "\n");
        }
        return stringBuilder.toString();
    }

    public boolean isFractionSet() {
        return this.isFractionRuleSet;
    }

    public String getName() {
        return this.name;
    }

    public boolean isPublic() {
        return !this.name.startsWith("%%");
    }

    public boolean isParseable() {
        return this.isParseable;
    }

    public void format(long l, StringBuffer stringBuffer, int n) {
        NFRule nFRule = this.findNormalRule(l);
        if (++this.recursionCount >= 50) {
            this.recursionCount = 0;
            throw new IllegalStateException("Recursion limit exceeded when applying ruleSet " + this.name);
        }
        nFRule.doFormat(l, stringBuffer, n);
        --this.recursionCount;
    }

    public void format(double d, StringBuffer stringBuffer, int n) {
        NFRule nFRule = this.findRule(d);
        if (++this.recursionCount >= 50) {
            this.recursionCount = 0;
            throw new IllegalStateException("Recursion limit exceeded when applying ruleSet " + this.name);
        }
        nFRule.doFormat(d, stringBuffer, n);
        --this.recursionCount;
    }

    private NFRule findRule(double d) {
        if (this.isFractionRuleSet) {
            return this.findFractionRuleSetRule(d);
        }
        if (d < 0.0) {
            if (this.negativeNumberRule != null) {
                return this.negativeNumberRule;
            }
            d = -d;
        }
        if (d != Math.floor(d)) {
            if (d < 1.0 && this.fractionRules[1] != null) {
                return this.fractionRules[1];
            }
            if (this.fractionRules[0] != null) {
                return this.fractionRules[0];
            }
        }
        if (this.fractionRules[2] != null) {
            return this.fractionRules[2];
        }
        return this.findNormalRule(Math.round(d));
    }

    private NFRule findNormalRule(long l) {
        if (this.isFractionRuleSet) {
            return this.findFractionRuleSetRule(l);
        }
        if (l < 0L) {
            if (this.negativeNumberRule != null) {
                return this.negativeNumberRule;
            }
            l = -l;
        }
        int n = 0;
        int n2 = this.rules.length;
        if (n2 > 0) {
            while (n < n2) {
                int n3 = n + n2 >>> 1;
                if (this.rules[n3].getBaseValue() == l) {
                    return this.rules[n3];
                }
                if (this.rules[n3].getBaseValue() > l) {
                    n2 = n3;
                    continue;
                }
                n = n3 + 1;
            }
            if (n2 == 0) {
                throw new IllegalStateException("The rule set " + this.name + " cannot format the value " + l);
            }
            NFRule nFRule = this.rules[n2 - 1];
            if (nFRule.shouldRollBack(l)) {
                if (n2 == 1) {
                    throw new IllegalStateException("The rule set " + this.name + " cannot roll back from the rule '" + nFRule + "'");
                }
                nFRule = this.rules[n2 - 2];
            }
            return nFRule;
        }
        return this.fractionRules[2];
    }

    private NFRule findFractionRuleSetRule(double d) {
        long l = this.rules[0].getBaseValue();
        for (int i = 1; i < this.rules.length; ++i) {
            l = NFRuleSet.lcm(l, this.rules[i].getBaseValue());
        }
        long l2 = Math.round(d * (double)l);
        long l3 = Long.MAX_VALUE;
        int n = 0;
        for (int i = 0; i < this.rules.length; ++i) {
            long l4 = l2 * this.rules[i].getBaseValue() % l;
            if (l - l4 < l4) {
                l4 = l - l4;
            }
            if (l4 >= l3) continue;
            l3 = l4;
            n = i;
            if (l3 == 0L) break;
        }
        if (n + 1 < this.rules.length && this.rules[n + 1].getBaseValue() == this.rules[n].getBaseValue() && (Math.round(d * (double)this.rules[n].getBaseValue()) < 1L || Math.round(d * (double)this.rules[n].getBaseValue()) >= 2L)) {
            ++n;
        }
        return this.rules[n];
    }

    private static long lcm(long l, long l2) {
        long l3 = l;
        long l4 = l2;
        int n = 0;
        while ((l3 & 1L) == 0L && (l4 & 1L) == 0L) {
            ++n;
            l3 >>= 1;
            l4 >>= 1;
        }
        long l5 = (l3 & 1L) == 1L ? -l4 : l3;
        while (l5 != 0L) {
            while ((l5 & 1L) == 0L) {
                l5 >>= 1;
            }
            if (l5 > 0L) {
                l3 = l5;
            } else {
                l4 = -l5;
            }
            l5 = l3 - l4;
        }
        long l6 = l3 << n;
        return l / l6 * l2;
    }

    public Number parse(String string, ParsePosition parsePosition, double d) {
        int n;
        ParsePosition parsePosition2 = new ParsePosition(0);
        Number number = 0L;
        Number number2 = null;
        if (string.length() == 0) {
            return number;
        }
        if (this.negativeNumberRule != null) {
            number2 = this.negativeNumberRule.doParse(string, parsePosition, false, d);
            if (parsePosition.getIndex() > parsePosition2.getIndex()) {
                number = number2;
                parsePosition2.setIndex(parsePosition.getIndex());
            }
            parsePosition.setIndex(0);
        }
        for (n = 0; n < 3; ++n) {
            if (this.fractionRules[n] == null) continue;
            number2 = this.fractionRules[n].doParse(string, parsePosition, false, d);
            if (parsePosition.getIndex() > parsePosition2.getIndex()) {
                number = number2;
                parsePosition2.setIndex(parsePosition.getIndex());
            }
            parsePosition.setIndex(0);
        }
        for (n = this.rules.length - 1; n >= 0 && parsePosition2.getIndex() < string.length(); --n) {
            if (!this.isFractionRuleSet && (double)this.rules[n].getBaseValue() >= d) continue;
            number2 = this.rules[n].doParse(string, parsePosition, this.isFractionRuleSet, d);
            if (parsePosition.getIndex() > parsePosition2.getIndex()) {
                number = number2;
                parsePosition2.setIndex(parsePosition.getIndex());
            }
            parsePosition.setIndex(0);
        }
        parsePosition.setIndex(parsePosition2.getIndex());
        return number;
    }
}

