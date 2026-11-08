/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.text.RBBINode;
import com.ibm.icu.text.RBBIRuleScanner;
import com.ibm.icu.text.RBBISetBuilder;
import com.ibm.icu.text.RBBITableBuilder;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RBBIRuleBuilder {
    String fDebugEnv;
    String fRules;
    RBBIRuleScanner fScanner;
    RBBINode[] fTreeRoots = new RBBINode[4];
    static final int fForwardTree = 0;
    static final int fReverseTree = 1;
    static final int fSafeFwdTree = 2;
    static final int fSafeRevTree = 3;
    int fDefaultTree = 0;
    boolean fChainRules;
    boolean fLBCMNoChain;
    boolean fLookAheadHardBreak;
    RBBISetBuilder fSetBuilder;
    List<RBBINode> fUSetNodes;
    RBBITableBuilder fForwardTables;
    RBBITableBuilder fReverseTables;
    RBBITableBuilder fSafeFwdTables;
    RBBITableBuilder fSafeRevTables;
    Map<Set<Integer>, Integer> fStatusSets = new HashMap<Set<Integer>, Integer>();
    List<Integer> fRuleStatusVals;
    static final int U_BRK_ERROR_START = 66048;
    static final int U_BRK_INTERNAL_ERROR = 66049;
    static final int U_BRK_HEX_DIGITS_EXPECTED = 66050;
    static final int U_BRK_SEMICOLON_EXPECTED = 66051;
    static final int U_BRK_RULE_SYNTAX = 66052;
    static final int U_BRK_UNCLOSED_SET = 66053;
    static final int U_BRK_ASSIGN_ERROR = 66054;
    static final int U_BRK_VARIABLE_REDFINITION = 66055;
    static final int U_BRK_MISMATCHED_PAREN = 66056;
    static final int U_BRK_NEW_LINE_IN_QUOTED_STRING = 66057;
    static final int U_BRK_UNDEFINED_VARIABLE = 66058;
    static final int U_BRK_INIT_ERROR = 66059;
    static final int U_BRK_RULE_EMPTY_SET = 66060;
    static final int U_BRK_UNRECOGNIZED_OPTION = 66061;
    static final int U_BRK_MALFORMED_RULE_TAG = 66062;
    static final int U_BRK_MALFORMED_SET = 66063;
    static final int U_BRK_ERROR_LIMIT = 66064;

    RBBIRuleBuilder(String string) {
        this.fDebugEnv = ICUDebug.enabled("rbbi") ? ICUDebug.value("rbbi") : null;
        this.fRules = string;
        this.fUSetNodes = new ArrayList<RBBINode>();
        this.fRuleStatusVals = new ArrayList<Integer>();
        this.fScanner = new RBBIRuleScanner(this);
        this.fSetBuilder = new RBBISetBuilder(this);
    }

    static final int align8(int n) {
        return n + 7 & 0xFFFFFFF8;
    }

    void flattenData(OutputStream outputStream2) throws IOException {
        int n;
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream2);
        String string = RBBIRuleScanner.stripRules(this.fRules);
        int n2 = 96;
        int n3 = RBBIRuleBuilder.align8(this.fForwardTables.getTableSize());
        int n4 = RBBIRuleBuilder.align8(this.fReverseTables.getTableSize());
        int n5 = RBBIRuleBuilder.align8(this.fSafeFwdTables.getTableSize());
        int n6 = RBBIRuleBuilder.align8(this.fSafeRevTables.getTableSize());
        int n7 = RBBIRuleBuilder.align8(this.fSetBuilder.getTrieSize());
        int n8 = RBBIRuleBuilder.align8(this.fRuleStatusVals.size() * 4);
        int n9 = RBBIRuleBuilder.align8(string.length() * 2);
        int n10 = n2 + n3 + n4 + n5 + n6 + n8 + n7 + n9;
        int n11 = 0;
        byte[] byArray = new byte[128];
        dataOutputStream.write(byArray);
        int[] nArray = new int[24];
        nArray[0] = 45472;
        nArray[1] = 0x3010000;
        nArray[2] = n10;
        nArray[3] = this.fSetBuilder.getNumCharCategories();
        nArray[4] = n2;
        nArray[5] = n3;
        nArray[6] = nArray[4] + n3;
        nArray[7] = n4;
        nArray[8] = nArray[6] + n4;
        nArray[9] = n5;
        nArray[10] = nArray[8] + n5;
        nArray[11] = n6;
        nArray[12] = nArray[10] + n6;
        nArray[13] = this.fSetBuilder.getTrieSize();
        nArray[16] = nArray[12] + nArray[13];
        nArray[17] = n8;
        nArray[14] = nArray[16] + n8;
        nArray[15] = string.length() * 2;
        for (n = 0; n < nArray.length; ++n) {
            dataOutputStream.writeInt(nArray[n]);
            n11 += 4;
        }
        short[] sArray = this.fForwardTables.exportTable();
        Assert.assrt(n11 == nArray[4]);
        for (n = 0; n < sArray.length; ++n) {
            dataOutputStream.writeShort(sArray[n]);
            n11 += 2;
        }
        sArray = this.fReverseTables.exportTable();
        Assert.assrt(n11 == nArray[6]);
        for (n = 0; n < sArray.length; ++n) {
            dataOutputStream.writeShort(sArray[n]);
            n11 += 2;
        }
        Assert.assrt(n11 == nArray[8]);
        sArray = this.fSafeFwdTables.exportTable();
        for (n = 0; n < sArray.length; ++n) {
            dataOutputStream.writeShort(sArray[n]);
            n11 += 2;
        }
        Assert.assrt(n11 == nArray[10]);
        sArray = this.fSafeRevTables.exportTable();
        for (n = 0; n < sArray.length; ++n) {
            dataOutputStream.writeShort(sArray[n]);
            n11 += 2;
        }
        Assert.assrt(n11 == nArray[12]);
        this.fSetBuilder.serializeTrie(outputStream2);
        n11 += nArray[13];
        while (n11 % 8 != 0) {
            dataOutputStream.write(0);
            ++n11;
        }
        Assert.assrt(n11 == nArray[16]);
        for (Integer n12 : this.fRuleStatusVals) {
            dataOutputStream.writeInt(n12);
            n11 += 4;
        }
        while (n11 % 8 != 0) {
            dataOutputStream.write(0);
            ++n11;
        }
        Assert.assrt(n11 == nArray[14]);
        dataOutputStream.writeChars(string);
        n11 += string.length() * 2;
        while (n11 % 8 != 0) {
            dataOutputStream.write(0);
            ++n11;
        }
    }

    static void compileRules(String string, OutputStream outputStream2) throws IOException {
        RBBIRuleBuilder rBBIRuleBuilder = new RBBIRuleBuilder(string);
        rBBIRuleBuilder.fScanner.parse();
        rBBIRuleBuilder.fSetBuilder.build();
        rBBIRuleBuilder.fForwardTables = new RBBITableBuilder(rBBIRuleBuilder, 0);
        rBBIRuleBuilder.fReverseTables = new RBBITableBuilder(rBBIRuleBuilder, 1);
        rBBIRuleBuilder.fSafeFwdTables = new RBBITableBuilder(rBBIRuleBuilder, 2);
        rBBIRuleBuilder.fSafeRevTables = new RBBITableBuilder(rBBIRuleBuilder, 3);
        rBBIRuleBuilder.fForwardTables.build();
        rBBIRuleBuilder.fReverseTables.build();
        rBBIRuleBuilder.fSafeFwdTables.build();
        rBBIRuleBuilder.fSafeRevTables.build();
        if (rBBIRuleBuilder.fDebugEnv != null && rBBIRuleBuilder.fDebugEnv.indexOf("states") >= 0) {
            rBBIRuleBuilder.fForwardTables.printRuleStatusTable();
        }
        rBBIRuleBuilder.flattenData(outputStream2);
    }
}

