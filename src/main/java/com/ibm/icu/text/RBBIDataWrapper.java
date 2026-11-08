/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.CharTrie;
import com.ibm.icu.impl.Trie;
import com.ibm.icu.text.RuleBasedBreakIterator;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RBBIDataWrapper {
    RBBIDataHeader fHeader;
    short[] fFTable;
    short[] fRTable;
    short[] fSFTable;
    short[] fSRTable;
    CharTrie fTrie;
    String fRuleSource;
    int[] fStatusTable;
    static final int DH_SIZE = 24;
    static final int DH_MAGIC = 0;
    static final int DH_FORMATVERSION = 1;
    static final int DH_LENGTH = 2;
    static final int DH_CATCOUNT = 3;
    static final int DH_FTABLE = 4;
    static final int DH_FTABLELEN = 5;
    static final int DH_RTABLE = 6;
    static final int DH_RTABLELEN = 7;
    static final int DH_SFTABLE = 8;
    static final int DH_SFTABLELEN = 9;
    static final int DH_SRTABLE = 10;
    static final int DH_SRTABLELEN = 11;
    static final int DH_TRIE = 12;
    static final int DH_TRIELEN = 13;
    static final int DH_RULESOURCE = 14;
    static final int DH_RULESOURCELEN = 15;
    static final int DH_STATUSTABLE = 16;
    static final int DH_STATUSTABLELEN = 17;
    static final int ACCEPTING = 0;
    static final int LOOKAHEAD = 1;
    static final int TAGIDX = 2;
    static final int RESERVED = 3;
    static final int NEXTSTATES = 4;
    static final int NUMSTATES = 0;
    static final int ROWLEN = 2;
    static final int FLAGS = 4;
    static final int RESERVED_2 = 6;
    static final int ROW_DATA = 8;
    static final int RBBI_LOOKAHEAD_HARD_BREAK = 1;
    static final int RBBI_BOF_REQUIRED = 2;
    static TrieFoldingFunc fTrieFoldingFunc = new TrieFoldingFunc();

    int getRowIndex(int n) {
        return 8 + n * (this.fHeader.fCatCount + 4);
    }

    RBBIDataWrapper() {
    }

    static RBBIDataWrapper get(InputStream inputStream2) throws IOException {
        int n;
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream2));
        RBBIDataWrapper rBBIDataWrapper = new RBBIDataWrapper();
        dataInputStream.skip(128L);
        rBBIDataWrapper.fHeader = new RBBIDataHeader();
        rBBIDataWrapper.fHeader.fMagic = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fVersion = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fFormatVersion[0] = (byte)(rBBIDataWrapper.fHeader.fVersion >> 24);
        rBBIDataWrapper.fHeader.fFormatVersion[1] = (byte)(rBBIDataWrapper.fHeader.fVersion >> 16);
        rBBIDataWrapper.fHeader.fFormatVersion[2] = (byte)(rBBIDataWrapper.fHeader.fVersion >> 8);
        rBBIDataWrapper.fHeader.fFormatVersion[3] = (byte)rBBIDataWrapper.fHeader.fVersion;
        rBBIDataWrapper.fHeader.fLength = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fCatCount = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fFTable = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fFTableLen = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fRTable = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fRTableLen = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fSFTable = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fSFTableLen = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fSRTable = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fSRTableLen = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fTrie = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fTrieLen = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fRuleSource = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fRuleSourceLen = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fStatusTable = dataInputStream.readInt();
        rBBIDataWrapper.fHeader.fStatusTableLen = dataInputStream.readInt();
        dataInputStream.skip(24L);
        if (rBBIDataWrapper.fHeader.fMagic != 45472 || rBBIDataWrapper.fHeader.fVersion != 1 && rBBIDataWrapper.fHeader.fFormatVersion[0] != 3) {
            throw new IOException("Break Iterator Rule Data Magic Number Incorrect, or unsupported data version.");
        }
        int n2 = 96;
        if (rBBIDataWrapper.fHeader.fFTable < n2 || rBBIDataWrapper.fHeader.fFTable > rBBIDataWrapper.fHeader.fLength) {
            throw new IOException("Break iterator Rule data corrupt");
        }
        dataInputStream.skip(rBBIDataWrapper.fHeader.fFTable - n2);
        n2 = rBBIDataWrapper.fHeader.fFTable;
        rBBIDataWrapper.fFTable = new short[rBBIDataWrapper.fHeader.fFTableLen / 2];
        for (n = 0; n < rBBIDataWrapper.fFTable.length; ++n) {
            rBBIDataWrapper.fFTable[n] = dataInputStream.readShort();
            n2 += 2;
        }
        dataInputStream.skip(rBBIDataWrapper.fHeader.fRTable - n2);
        n2 = rBBIDataWrapper.fHeader.fRTable;
        rBBIDataWrapper.fRTable = new short[rBBIDataWrapper.fHeader.fRTableLen / 2];
        for (n = 0; n < rBBIDataWrapper.fRTable.length; ++n) {
            rBBIDataWrapper.fRTable[n] = dataInputStream.readShort();
            n2 += 2;
        }
        if (rBBIDataWrapper.fHeader.fSFTableLen > 0) {
            dataInputStream.skip(rBBIDataWrapper.fHeader.fSFTable - n2);
            n2 = rBBIDataWrapper.fHeader.fSFTable;
            rBBIDataWrapper.fSFTable = new short[rBBIDataWrapper.fHeader.fSFTableLen / 2];
            for (n = 0; n < rBBIDataWrapper.fSFTable.length; ++n) {
                rBBIDataWrapper.fSFTable[n] = dataInputStream.readShort();
                n2 += 2;
            }
        }
        if (rBBIDataWrapper.fHeader.fSRTableLen > 0) {
            dataInputStream.skip(rBBIDataWrapper.fHeader.fSRTable - n2);
            n2 = rBBIDataWrapper.fHeader.fSRTable;
            rBBIDataWrapper.fSRTable = new short[rBBIDataWrapper.fHeader.fSRTableLen / 2];
            for (n = 0; n < rBBIDataWrapper.fSRTable.length; ++n) {
                rBBIDataWrapper.fSRTable[n] = dataInputStream.readShort();
                n2 += 2;
            }
        }
        dataInputStream.skip(rBBIDataWrapper.fHeader.fTrie - n2);
        n2 = rBBIDataWrapper.fHeader.fTrie;
        dataInputStream.mark(rBBIDataWrapper.fHeader.fTrieLen + 100);
        rBBIDataWrapper.fTrie = new CharTrie(dataInputStream, fTrieFoldingFunc);
        dataInputStream.reset();
        if (n2 > rBBIDataWrapper.fHeader.fStatusTable) {
            throw new IOException("Break iterator Rule data corrupt");
        }
        dataInputStream.skip(rBBIDataWrapper.fHeader.fStatusTable - n2);
        n2 = rBBIDataWrapper.fHeader.fStatusTable;
        rBBIDataWrapper.fStatusTable = new int[rBBIDataWrapper.fHeader.fStatusTableLen / 4];
        for (n = 0; n < rBBIDataWrapper.fStatusTable.length; ++n) {
            rBBIDataWrapper.fStatusTable[n] = dataInputStream.readInt();
            n2 += 4;
        }
        if (n2 > rBBIDataWrapper.fHeader.fRuleSource) {
            throw new IOException("Break iterator Rule data corrupt");
        }
        dataInputStream.skip(rBBIDataWrapper.fHeader.fRuleSource - n2);
        n2 = rBBIDataWrapper.fHeader.fRuleSource;
        StringBuilder stringBuilder = new StringBuilder(rBBIDataWrapper.fHeader.fRuleSourceLen / 2);
        for (n = 0; n < rBBIDataWrapper.fHeader.fRuleSourceLen; n += 2) {
            stringBuilder.append(dataInputStream.readChar());
            n2 += 2;
        }
        rBBIDataWrapper.fRuleSource = stringBuilder.toString();
        if (RuleBasedBreakIterator.fDebugEnv != null && RuleBasedBreakIterator.fDebugEnv.indexOf("data") >= 0) {
            rBBIDataWrapper.dump();
        }
        return rBBIDataWrapper;
    }

    static final int getNumStates(short[] sArray) {
        short s = sArray[0];
        short s2 = sArray[1];
        int n = (s << 16) + (s2 & 0xFFFF);
        return n;
    }

    void dump() {
        if (this.fFTable.length == 0) {
            throw new NullPointerException();
        }
        System.out.println("RBBI Data Wrapper dump ...");
        System.out.println();
        System.out.println("Forward State Table");
        this.dumpTable(this.fFTable);
        System.out.println("Reverse State Table");
        this.dumpTable(this.fRTable);
        System.out.println("Forward Safe Points Table");
        this.dumpTable(this.fSFTable);
        System.out.println("Reverse Safe Points Table");
        this.dumpTable(this.fSRTable);
        this.dumpCharCategories();
        System.out.println("Source Rules: " + this.fRuleSource);
    }

    public static String intToString(int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder(n2);
        stringBuilder.append(n);
        while (stringBuilder.length() < n2) {
            stringBuilder.insert(0, ' ');
        }
        return stringBuilder.toString();
    }

    public static String intToHexString(int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder(n2);
        stringBuilder.append(Integer.toHexString(n));
        while (stringBuilder.length() < n2) {
            stringBuilder.insert(0, ' ');
        }
        return stringBuilder.toString();
    }

    private void dumpTable(short[] sArray) {
        if (sArray == null) {
            System.out.println("  -- null -- ");
        } else {
            int n;
            StringBuilder stringBuilder = new StringBuilder(" Row  Acc Look  Tag");
            for (n = 0; n < this.fHeader.fCatCount; ++n) {
                stringBuilder.append(RBBIDataWrapper.intToString(n, 5));
            }
            System.out.println(stringBuilder.toString());
            for (n = 0; n < stringBuilder.length(); ++n) {
                System.out.print("-");
            }
            System.out.println();
            for (int i = 0; i < RBBIDataWrapper.getNumStates(sArray); ++i) {
                this.dumpRow(sArray, i);
            }
            System.out.println();
        }
    }

    private void dumpRow(short[] sArray, int n) {
        StringBuilder stringBuilder = new StringBuilder(this.fHeader.fCatCount * 5 + 20);
        stringBuilder.append(RBBIDataWrapper.intToString(n, 4));
        int n2 = this.getRowIndex(n);
        if (sArray[n2 + 0] != 0) {
            stringBuilder.append(RBBIDataWrapper.intToString(sArray[n2 + 0], 5));
        } else {
            stringBuilder.append("     ");
        }
        if (sArray[n2 + 1] != 0) {
            stringBuilder.append(RBBIDataWrapper.intToString(sArray[n2 + 1], 5));
        } else {
            stringBuilder.append("     ");
        }
        stringBuilder.append(RBBIDataWrapper.intToString(sArray[n2 + 2], 5));
        for (int i = 0; i < this.fHeader.fCatCount; ++i) {
            stringBuilder.append(RBBIDataWrapper.intToString(sArray[n2 + 4 + i], 5));
        }
        System.out.println(stringBuilder);
    }

    private void dumpCharCategories() {
        int n;
        int n2 = this.fHeader.fCatCount;
        String[] stringArray = new String[n2 + 1];
        int n3 = 0;
        int n4 = 0;
        int n5 = -1;
        int[] nArray = new int[n2 + 1];
        for (n = 0; n <= this.fHeader.fCatCount; ++n) {
            stringArray[n] = "";
        }
        System.out.println("\nCharacter Categories");
        System.out.println("--------------------");
        for (int i = 0; i <= 0x10FFFF; ++i) {
            n = this.fTrie.getCodePointValue(i);
            if ((n &= 0xFFFFBFFF) < 0 || n > this.fHeader.fCatCount) {
                System.out.println("Error, bad category " + Integer.toHexString(n) + " for char " + Integer.toHexString(i));
                break;
            }
            if (n == n5) {
                n4 = i;
                continue;
            }
            if (n5 >= 0) {
                if (stringArray[n5].length() > nArray[n5] + 70) {
                    nArray[n5] = stringArray[n5].length() + 10;
                    int n6 = n5;
                    stringArray[n6] = stringArray[n6] + "\n       ";
                }
                int n7 = n5;
                stringArray[n7] = stringArray[n7] + " " + Integer.toHexString(n3);
                if (n4 != n3) {
                    int n8 = n5;
                    stringArray[n8] = stringArray[n8] + "-" + Integer.toHexString(n4);
                }
            }
            n5 = n;
            n3 = n4 = i;
        }
        int n9 = n5;
        stringArray[n9] = stringArray[n9] + " " + Integer.toHexString(n3);
        if (n4 != n3) {
            int n10 = n5;
            stringArray[n10] = stringArray[n10] + "-" + Integer.toHexString(n4);
        }
        for (n = 0; n <= this.fHeader.fCatCount; ++n) {
            System.out.println(RBBIDataWrapper.intToString(n, 5) + "  " + stringArray[n]);
        }
        System.out.println();
    }

    public static class TrieFoldingFunc
    implements Trie.DataManipulate {
        TrieFoldingFunc() {
        }

        public int getFoldingOffset(int n) {
            if ((n & 0x8000) != 0) {
                return n & Short.MAX_VALUE;
            }
            return 0;
        }
    }

    public static final class RBBIDataHeader {
        int fMagic = 0;
        int fVersion;
        byte[] fFormatVersion = new byte[4];
        int fLength;
        int fCatCount;
        int fFTable;
        int fFTableLen;
        int fRTable;
        int fRTableLen;
        int fSFTable;
        int fSFTableLen;
        int fSRTable;
        int fSRTableLen;
        int fTrie;
        int fTrieLen;
        int fRuleSource;
        int fRuleSourceLen;
        int fStatusTable;
        int fStatusTableLen;
    }
}

