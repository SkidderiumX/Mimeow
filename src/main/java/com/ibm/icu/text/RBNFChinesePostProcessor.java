/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.NFRuleSet;
import com.ibm.icu.text.RBNFPostProcessor;
import com.ibm.icu.text.RuleBasedNumberFormat;

public class RBNFChinesePostProcessor
implements RBNFPostProcessor {
    private boolean longForm;
    private int format;
    private static final String[] rulesetNames = new String[]{"%traditional", "%simplified", "%accounting", "%time"};

    RBNFChinesePostProcessor() {
    }

    public void init(RuleBasedNumberFormat ruleBasedNumberFormat, String string) {
    }

    public void process(StringBuffer stringBuffer, NFRuleSet nFRuleSet) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        String string = nFRuleSet.getName();
        for (n5 = 0; n5 < rulesetNames.length; ++n5) {
            if (!rulesetNames[n5].equals(string)) continue;
            this.format = n5;
            this.longForm = n5 == 1 || n5 == 3;
            break;
        }
        if (this.longForm) {
            n5 = stringBuffer.indexOf("*");
            while (n5 != -1) {
                stringBuffer.delete(n5, n5 + 1);
                n5 = stringBuffer.indexOf("*", n5);
            }
            return;
        }
        String string2 = "\u9ede";
        String[][] stringArrayArray = new String[][]{{"\u842c", "\u5104", "\u5146", "\u3007"}, {"\u4e07", "\u4ebf", "\u5146", "\u3007"}, {"\u842c", "\u5104", "\u5146", "\u96f6"}};
        String[] stringArray = stringArrayArray[this.format];
        for (n4 = 0; n4 < stringArray.length - 1; ++n4) {
            n3 = stringBuffer.indexOf(stringArray[n4]);
            if (n3 == -1) continue;
            stringBuffer.insert(n3 + stringArray[n4].length(), '|');
        }
        int n6 = stringBuffer.indexOf("\u9ede");
        if (n6 == -1) {
            n6 = stringBuffer.length();
        }
        n4 = 0;
        n3 = -1;
        String string3 = stringArrayArray[this.format][3];
        block14: while (n6 >= 0) {
            n2 = stringBuffer.lastIndexOf("|", n6);
            n = stringBuffer.lastIndexOf(string3, n6);
            int n7 = 0;
            if (n > n2) {
                n7 = n > 0 && stringBuffer.charAt(n - 1) != '*' ? 2 : 1;
            }
            n6 = n2 - 1;
            switch (n4 * 3 + n7) {
                case 0: {
                    n4 = n7;
                    n3 = -1;
                    continue block14;
                }
                case 1: {
                    n4 = n7;
                    n3 = n;
                    continue block14;
                }
                case 2: {
                    n4 = n7;
                    n3 = -1;
                    continue block14;
                }
                case 3: {
                    n4 = n7;
                    n3 = -1;
                    continue block14;
                }
                case 4: {
                    stringBuffer.delete(n - 1, n + string3.length());
                    n4 = 0;
                    n3 = -1;
                    continue block14;
                }
                case 5: {
                    stringBuffer.delete(n3 - 1, n3 + string3.length());
                    n4 = n7;
                    n3 = -1;
                    continue block14;
                }
                case 6: {
                    n4 = n7;
                    n3 = -1;
                    continue block14;
                }
                case 7: {
                    stringBuffer.delete(n - 1, n + string3.length());
                    n4 = 0;
                    n3 = -1;
                    continue block14;
                }
                case 8: {
                    n4 = n7;
                    n3 = -1;
                    continue block14;
                }
            }
            throw new IllegalStateException();
        }
        n2 = stringBuffer.length();
        while (--n2 >= 0) {
            n = stringBuffer.charAt(n2);
            if (n != 42 && n != 124) continue;
            stringBuffer.delete(n2, n2 + 1);
        }
    }
}

