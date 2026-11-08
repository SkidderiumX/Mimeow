/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.UBiDiProps;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.BidiClassifier;
import com.ibm.icu.text.BidiLine;
import com.ibm.icu.text.BidiRun;
import com.ibm.icu.text.BidiWriter;
import com.ibm.icu.text.UTF16;
import java.awt.font.NumericShaper;
import java.awt.font.TextAttribute;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.AttributedCharacterIterator;
import java.util.Arrays;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Bidi {
    public static final byte LEVEL_DEFAULT_LTR = 126;
    public static final byte LEVEL_DEFAULT_RTL = 127;
    public static final byte MAX_EXPLICIT_LEVEL = 61;
    public static final byte LEVEL_OVERRIDE = -128;
    public static final int MAP_NOWHERE = -1;
    public static final byte LTR = 0;
    public static final byte RTL = 1;
    public static final byte MIXED = 2;
    public static final byte NEUTRAL = 3;
    public static final short KEEP_BASE_COMBINING = 1;
    public static final short DO_MIRRORING = 2;
    public static final short INSERT_LRM_FOR_NUMERIC = 4;
    public static final short REMOVE_BIDI_CONTROLS = 8;
    public static final short OUTPUT_REVERSE = 16;
    public static final short REORDER_DEFAULT = 0;
    public static final short REORDER_NUMBERS_SPECIAL = 1;
    public static final short REORDER_GROUP_NUMBERS_WITH_R = 2;
    public static final short REORDER_RUNS_ONLY = 3;
    public static final short REORDER_INVERSE_NUMBERS_AS_L = 4;
    public static final short REORDER_INVERSE_LIKE_DIRECT = 5;
    public static final short REORDER_INVERSE_FOR_NUMBERS_SPECIAL = 6;
    static final short REORDER_COUNT = 7;
    static final short REORDER_LAST_LOGICAL_TO_VISUAL = 1;
    public static final int OPTION_DEFAULT = 0;
    public static final int OPTION_INSERT_MARKS = 1;
    public static final int OPTION_REMOVE_CONTROLS = 2;
    public static final int OPTION_STREAMING = 4;
    static final byte L = 0;
    static final byte R = 1;
    static final byte EN = 2;
    static final byte ES = 3;
    static final byte ET = 4;
    static final byte AN = 5;
    static final byte CS = 6;
    static final byte B = 7;
    static final byte S = 8;
    static final byte WS = 9;
    static final byte ON = 10;
    static final byte LRE = 11;
    static final byte LRO = 12;
    static final byte AL = 13;
    static final byte RLE = 14;
    static final byte RLO = 15;
    static final byte PDF = 16;
    static final byte NSM = 17;
    static final byte BN = 18;
    static final int MASK_R_AL = 8194;
    public static final int CLASS_DEFAULT = 19;
    private static final char CR = '\r';
    private static final char LF = '\n';
    static final int LRM_BEFORE = 1;
    static final int LRM_AFTER = 2;
    static final int RLM_BEFORE = 4;
    static final int RLM_AFTER = 8;
    Bidi paraBidi;
    final UBiDiProps bdp;
    char[] text;
    int originalLength;
    int length;
    int resultLength;
    boolean mayAllocateText;
    boolean mayAllocateRuns;
    byte[] dirPropsMemory = new byte[1];
    byte[] levelsMemory = new byte[1];
    byte[] dirProps;
    byte[] levels;
    boolean isInverse;
    int reorderingMode;
    int reorderingOptions;
    boolean orderParagraphsLTR;
    byte paraLevel;
    byte defaultParaLevel;
    String prologue;
    String epilogue;
    ImpTabPair impTabPair;
    byte direction;
    int flags;
    int lastArabicPos;
    int trailingWSStart;
    int paraCount;
    int[] parasMemory = new int[1];
    int[] paras;
    int[] simpleParas = new int[]{0};
    int runCount;
    BidiRun[] runsMemory = new BidiRun[0];
    BidiRun[] runs;
    BidiRun[] simpleRuns = new BidiRun[]{new BidiRun()};
    int[] logicalToVisualRunsMap;
    boolean isGoodLogicalToVisualRunsMap;
    BidiClassifier customClassifier = null;
    InsertPoints insertPoints = new InsertPoints();
    int controlCount;
    static final byte CONTEXT_RTL_SHIFT = 6;
    static final byte CONTEXT_RTL = 64;
    static final int DirPropFlagMultiRuns = Bidi.DirPropFlag((byte)31);
    static final int[] DirPropFlagLR = new int[]{Bidi.DirPropFlag((byte)0), Bidi.DirPropFlag((byte)1)};
    static final int[] DirPropFlagE = new int[]{Bidi.DirPropFlag((byte)11), Bidi.DirPropFlag((byte)14)};
    static final int[] DirPropFlagO = new int[]{Bidi.DirPropFlag((byte)12), Bidi.DirPropFlag((byte)15)};
    static final int MASK_LTR = Bidi.DirPropFlag((byte)0) | Bidi.DirPropFlag((byte)2) | Bidi.DirPropFlag((byte)5) | Bidi.DirPropFlag((byte)11) | Bidi.DirPropFlag((byte)12);
    static final int MASK_RTL = Bidi.DirPropFlag((byte)1) | Bidi.DirPropFlag((byte)13) | Bidi.DirPropFlag((byte)14) | Bidi.DirPropFlag((byte)15);
    static final int MASK_LRX = Bidi.DirPropFlag((byte)11) | Bidi.DirPropFlag((byte)12);
    static final int MASK_RLX = Bidi.DirPropFlag((byte)14) | Bidi.DirPropFlag((byte)15);
    static final int MASK_OVERRIDE = Bidi.DirPropFlag((byte)12) | Bidi.DirPropFlag((byte)15);
    static final int MASK_EXPLICIT = MASK_LRX | MASK_RLX | Bidi.DirPropFlag((byte)16);
    static final int MASK_BN_EXPLICIT = Bidi.DirPropFlag((byte)18) | MASK_EXPLICIT;
    static final int MASK_B_S = Bidi.DirPropFlag((byte)7) | Bidi.DirPropFlag((byte)8);
    static final int MASK_WS = MASK_B_S | Bidi.DirPropFlag((byte)9) | MASK_BN_EXPLICIT;
    static final int MASK_N = Bidi.DirPropFlag((byte)10) | MASK_WS;
    static final int MASK_ET_NSM_BN = Bidi.DirPropFlag((byte)4) | Bidi.DirPropFlag((byte)17) | MASK_BN_EXPLICIT;
    static final int MASK_POSSIBLE_N = Bidi.DirPropFlag((byte)6) | Bidi.DirPropFlag((byte)3) | Bidi.DirPropFlag((byte)4) | MASK_N;
    static final int MASK_EMBEDDING = Bidi.DirPropFlag((byte)17) | MASK_POSSIBLE_N;
    private static final int IMPTABPROPS_COLUMNS = 14;
    private static final int IMPTABPROPS_RES = 13;
    private static final short[] groupProp = new short[]{0, 1, 2, 7, 8, 3, 9, 6, 5, 4, 4, 10, 10, 12, 10, 10, 10, 11, 10};
    private static final short _L = 0;
    private static final short _R = 1;
    private static final short _EN = 2;
    private static final short _AN = 3;
    private static final short _ON = 4;
    private static final short _S = 5;
    private static final short _B = 6;
    private static final short[][] impTabProps = new short[][]{{1, 2, 4, 5, 7, 15, 17, 7, 9, 7, 0, 7, 3, 4}, {1, 34, 36, 37, 39, 47, 49, 39, 41, 39, 1, 1, 35, 0}, {33, 2, 36, 37, 39, 47, 49, 39, 41, 39, 2, 2, 35, 1}, {33, 34, 38, 38, 40, 48, 49, 40, 40, 40, 3, 3, 3, 1}, {33, 34, 4, 37, 39, 47, 49, 74, 11, 74, 4, 4, 35, 2}, {33, 34, 36, 5, 39, 47, 49, 39, 41, 76, 5, 5, 35, 3}, {33, 34, 6, 6, 40, 48, 49, 40, 40, 77, 6, 6, 35, 3}, {33, 34, 36, 37, 7, 47, 49, 7, 78, 7, 7, 7, 35, 4}, {33, 34, 38, 38, 8, 48, 49, 8, 8, 8, 8, 8, 35, 4}, {33, 34, 4, 37, 7, 47, 49, 7, 9, 7, 9, 9, 35, 4}, {97, 98, 4, 101, 135, 111, 113, 135, 142, 135, 10, 135, 99, 2}, {33, 34, 4, 37, 39, 47, 49, 39, 11, 39, 11, 11, 35, 2}, {97, 98, 100, 5, 135, 111, 113, 135, 142, 135, 12, 135, 99, 3}, {97, 98, 6, 6, 136, 112, 113, 136, 136, 136, 13, 136, 99, 3}, {33, 34, 132, 37, 7, 47, 49, 7, 14, 7, 14, 14, 35, 4}, {33, 34, 36, 37, 39, 15, 49, 39, 41, 39, 15, 39, 35, 5}, {33, 34, 38, 38, 40, 16, 49, 40, 40, 40, 16, 40, 35, 5}, {33, 34, 36, 37, 39, 47, 17, 39, 41, 39, 17, 39, 35, 6}};
    private static final int IMPTABLEVELS_COLUMNS = 8;
    private static final int IMPTABLEVELS_RES = 7;
    private static final byte[][] impTabL_DEFAULT = new byte[][]{{0, 1, 0, 2, 0, 0, 0, 0}, {0, 1, 3, 3, 20, 20, 0, 1}, {0, 1, 0, 2, 21, 21, 0, 2}, {0, 1, 3, 3, 20, 20, 0, 2}, {32, 1, 3, 3, 4, 4, 32, 1}, {32, 1, 32, 2, 5, 5, 32, 1}};
    private static final byte[][] impTabR_DEFAULT = new byte[][]{{1, 0, 2, 2, 0, 0, 0, 0}, {1, 0, 1, 3, 20, 20, 0, 1}, {1, 0, 2, 2, 0, 0, 0, 1}, {1, 0, 1, 3, 5, 5, 0, 1}, {33, 0, 33, 3, 4, 4, 0, 0}, {1, 0, 1, 3, 5, 5, 0, 0}};
    private static final short[] impAct0 = new short[]{0, 1, 2, 3, 4, 5, 6};
    private static final ImpTabPair impTab_DEFAULT = new ImpTabPair(impTabL_DEFAULT, impTabR_DEFAULT, impAct0, impAct0);
    private static final byte[][] impTabL_NUMBERS_SPECIAL = new byte[][]{{0, 2, 1, 1, 0, 0, 0, 0}, {0, 2, 1, 1, 0, 0, 0, 2}, {0, 2, 4, 4, 19, 0, 0, 1}, {32, 2, 4, 4, 3, 3, 32, 1}, {0, 2, 4, 4, 19, 19, 0, 2}};
    private static final ImpTabPair impTab_NUMBERS_SPECIAL = new ImpTabPair(impTabL_NUMBERS_SPECIAL, impTabR_DEFAULT, impAct0, impAct0);
    private static final byte[][] impTabL_GROUP_NUMBERS_WITH_R = new byte[][]{{0, 3, 17, 17, 0, 0, 0, 0}, {32, 3, 1, 1, 2, 32, 32, 2}, {32, 3, 1, 1, 2, 32, 32, 1}, {0, 3, 5, 5, 20, 0, 0, 1}, {32, 3, 5, 5, 4, 32, 32, 1}, {0, 3, 5, 5, 20, 0, 0, 2}};
    private static final byte[][] impTabR_GROUP_NUMBERS_WITH_R = new byte[][]{{2, 0, 1, 1, 0, 0, 0, 0}, {2, 0, 1, 1, 0, 0, 0, 1}, {2, 0, 20, 20, 19, 0, 0, 1}, {34, 0, 4, 4, 3, 0, 0, 0}, {34, 0, 4, 4, 3, 0, 0, 1}};
    private static final ImpTabPair impTab_GROUP_NUMBERS_WITH_R = new ImpTabPair(impTabL_GROUP_NUMBERS_WITH_R, impTabR_GROUP_NUMBERS_WITH_R, impAct0, impAct0);
    private static final byte[][] impTabL_INVERSE_NUMBERS_AS_L = new byte[][]{{0, 1, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 20, 20, 0, 1}, {0, 1, 0, 0, 21, 21, 0, 2}, {0, 1, 0, 0, 20, 20, 0, 2}, {32, 1, 32, 32, 4, 4, 32, 1}, {32, 1, 32, 32, 5, 5, 32, 1}};
    private static final byte[][] impTabR_INVERSE_NUMBERS_AS_L = new byte[][]{{1, 0, 1, 1, 0, 0, 0, 0}, {1, 0, 1, 1, 20, 20, 0, 1}, {1, 0, 1, 1, 0, 0, 0, 1}, {1, 0, 1, 1, 5, 5, 0, 1}, {33, 0, 33, 33, 4, 4, 0, 0}, {1, 0, 1, 1, 5, 5, 0, 0}};
    private static final ImpTabPair impTab_INVERSE_NUMBERS_AS_L = new ImpTabPair(impTabL_INVERSE_NUMBERS_AS_L, impTabR_INVERSE_NUMBERS_AS_L, impAct0, impAct0);
    private static final byte[][] impTabR_INVERSE_LIKE_DIRECT = new byte[][]{{1, 0, 2, 2, 0, 0, 0, 0}, {1, 0, 1, 2, 19, 19, 0, 1}, {1, 0, 2, 2, 0, 0, 0, 1}, {33, 48, 6, 4, 3, 3, 48, 0}, {33, 48, 6, 4, 5, 5, 48, 3}, {33, 48, 6, 4, 5, 5, 48, 2}, {33, 48, 6, 4, 3, 3, 48, 1}};
    private static final short[] impAct1 = new short[]{0, 1, 11, 12};
    private static final ImpTabPair impTab_INVERSE_LIKE_DIRECT = new ImpTabPair(impTabL_DEFAULT, impTabR_INVERSE_LIKE_DIRECT, impAct0, impAct1);
    private static final byte[][] impTabL_INVERSE_LIKE_DIRECT_WITH_MARKS = new byte[][]{{0, 99, 0, 1, 0, 0, 0, 0}, {0, 99, 0, 1, 18, 48, 0, 4}, {32, 99, 32, 1, 2, 48, 32, 3}, {0, 99, 85, 86, 20, 48, 0, 3}, {48, 67, 85, 86, 4, 48, 48, 3}, {48, 67, 5, 86, 20, 48, 48, 4}, {48, 67, 85, 6, 20, 48, 48, 4}};
    private static final byte[][] impTabR_INVERSE_LIKE_DIRECT_WITH_MARKS = new byte[][]{{19, 0, 1, 1, 0, 0, 0, 0}, {35, 0, 1, 1, 2, 64, 0, 1}, {35, 0, 1, 1, 2, 64, 0, 0}, {3, 0, 3, 54, 20, 64, 0, 1}, {83, 64, 5, 54, 4, 64, 64, 0}, {83, 64, 5, 54, 4, 64, 64, 1}, {83, 64, 6, 6, 4, 64, 64, 3}};
    private static final short[] impAct2 = new short[]{0, 1, 7, 8, 9, 10};
    private static final ImpTabPair impTab_INVERSE_LIKE_DIRECT_WITH_MARKS = new ImpTabPair(impTabL_INVERSE_LIKE_DIRECT_WITH_MARKS, impTabR_INVERSE_LIKE_DIRECT_WITH_MARKS, impAct0, impAct2);
    private static final ImpTabPair impTab_INVERSE_FOR_NUMBERS_SPECIAL = new ImpTabPair(impTabL_NUMBERS_SPECIAL, impTabR_INVERSE_LIKE_DIRECT, impAct0, impAct1);
    private static final byte[][] impTabL_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS = new byte[][]{{0, 98, 1, 1, 0, 0, 0, 0}, {0, 98, 1, 1, 0, 48, 0, 4}, {0, 98, 84, 84, 19, 48, 0, 3}, {48, 66, 84, 84, 3, 48, 48, 3}, {48, 66, 4, 4, 19, 48, 48, 4}};
    private static final ImpTabPair impTab_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS = new ImpTabPair(impTabL_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS, impTabR_INVERSE_LIKE_DIRECT_WITH_MARKS, impAct0, impAct2);
    static final int FIRSTALLOC = 10;
    public static final int DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int DIRECTION_DEFAULT_LEFT_TO_RIGHT = 126;
    public static final int DIRECTION_DEFAULT_RIGHT_TO_LEFT = 127;

    static int DirPropFlag(byte by) {
        return 1 << by;
    }

    boolean testDirPropFlagAt(int n, int n2) {
        return (Bidi.DirPropFlag((byte)(this.dirProps[n2] & 0xFFFFFFBF)) & n) != 0;
    }

    static byte NoContextRTL(byte by) {
        return (byte)(by & 0xFFFFFFBF);
    }

    static int DirPropFlagNC(byte by) {
        return 1 << (by & 0xFFFFFFBF);
    }

    static final int DirPropFlagLR(byte by) {
        return DirPropFlagLR[by & 1];
    }

    static final int DirPropFlagE(byte by) {
        return DirPropFlagE[by & 1];
    }

    static final int DirPropFlagO(byte by) {
        return DirPropFlagO[by & 1];
    }

    static byte GetLRFromLevel(byte by) {
        return (byte)(by & 1);
    }

    static boolean IsDefaultLevel(byte by) {
        return (by & 0x7E) == 126;
    }

    byte GetParaLevelAt(int n) {
        return this.defaultParaLevel != 0 ? (byte)(this.dirProps[n] >> 6) : this.paraLevel;
    }

    static boolean IsBidiControlChar(int n) {
        return (n & 0xFFFFFFFC) == 8204 || n >= 8234 && n <= 8238;
    }

    void verifyValidPara() {
        if (this != this.paraBidi) {
            throw new IllegalStateException();
        }
    }

    void verifyValidParaOrLine() {
        Bidi bidi = this.paraBidi;
        if (this == bidi) {
            return;
        }
        if (bidi == null || bidi != bidi.paraBidi) {
            throw new IllegalStateException();
        }
    }

    void verifyRange(int n, int n2, int n3) {
        if (n < n2 || n >= n3) {
            throw new IllegalArgumentException("Value " + n + " is out of range " + n2 + " to " + n3);
        }
    }

    public Bidi() {
        this(0, 0);
    }

    public Bidi(int n, int n2) {
        if (n < 0 || n2 < 0) {
            throw new IllegalArgumentException();
        }
        this.bdp = UBiDiProps.INSTANCE;
        if (n > 0) {
            this.getInitialDirPropsMemory(n);
            this.getInitialLevelsMemory(n);
        } else {
            this.mayAllocateText = true;
        }
        if (n2 > 0) {
            if (n2 > 1) {
                this.getInitialRunsMemory(n2);
            }
        } else {
            this.mayAllocateRuns = true;
        }
    }

    private Object getMemory(String string, Object object, Class<?> clazz, boolean bl, int n) {
        int n2 = Array.getLength(object);
        if (n == n2) {
            return object;
        }
        if (!bl) {
            if (n <= n2) {
                return object;
            }
            throw new OutOfMemoryError("Failed to allocate memory for " + string);
        }
        try {
            return Array.newInstance(clazz, n);
        }
        catch (Exception exception) {
            throw new OutOfMemoryError("Failed to allocate memory for " + string);
        }
    }

    private void getDirPropsMemory(boolean bl, int n) {
        Object object = this.getMemory("DirProps", this.dirPropsMemory, Byte.TYPE, bl, n);
        this.dirPropsMemory = (byte[])object;
    }

    void getDirPropsMemory(int n) {
        this.getDirPropsMemory(this.mayAllocateText, n);
    }

    private void getLevelsMemory(boolean bl, int n) {
        Object object = this.getMemory("Levels", this.levelsMemory, Byte.TYPE, bl, n);
        this.levelsMemory = (byte[])object;
    }

    void getLevelsMemory(int n) {
        this.getLevelsMemory(this.mayAllocateText, n);
    }

    private void getRunsMemory(boolean bl, int n) {
        Object object = this.getMemory("Runs", this.runsMemory, BidiRun.class, bl, n);
        this.runsMemory = (BidiRun[])object;
    }

    void getRunsMemory(int n) {
        this.getRunsMemory(this.mayAllocateRuns, n);
    }

    private void getInitialDirPropsMemory(int n) {
        this.getDirPropsMemory(true, n);
    }

    private void getInitialLevelsMemory(int n) {
        this.getLevelsMemory(true, n);
    }

    private void getInitialParasMemory(int n) {
        Object object = this.getMemory("Paras", this.parasMemory, Integer.TYPE, true, n);
        this.parasMemory = (int[])object;
    }

    private void getInitialRunsMemory(int n) {
        this.getRunsMemory(true, n);
    }

    public void setInverse(boolean bl) {
        this.isInverse = bl;
        this.reorderingMode = bl ? 4 : 0;
    }

    public boolean isInverse() {
        return this.isInverse;
    }

    public void setReorderingMode(int n) {
        if (n < 0 || n >= 7) {
            return;
        }
        this.reorderingMode = n;
        this.isInverse = n == 4;
    }

    public int getReorderingMode() {
        return this.reorderingMode;
    }

    public void setReorderingOptions(int n) {
        this.reorderingOptions = (n & 2) != 0 ? n & 0xFFFFFFFE : n;
    }

    public int getReorderingOptions() {
        return this.reorderingOptions;
    }

    private byte firstL_R_AL() {
        int n;
        int n2 = 10;
        for (int i = 0; i < this.prologue.length(); i += Character.charCount(n)) {
            n = this.prologue.codePointAt(i);
            int n3 = this.getCustomizedClass(n);
            if (n2 != 10) continue;
            if (n3 != 0 && n3 != 1 && n3 != 13) continue;
            n2 = n3;
        }
        return (byte)n2;
    }

    private void getDirProps() {
        int n;
        int n2;
        int n3;
        int n4 = 0;
        this.flags = 0;
        int n5 = 0;
        boolean bl = Bidi.IsDefaultLevel(this.paraLevel);
        boolean bl2 = bl && (this.reorderingMode == 5 || this.reorderingMode == 6);
        this.lastArabicPos = -1;
        this.controlCount = 0;
        boolean bl3 = (this.reorderingOptions & 2) != 0;
        boolean bl4 = false;
        boolean bl5 = true;
        int n6 = 2;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        if ((this.reorderingOptions & 4) > 0) {
            this.length = 0;
            n9 = 0;
        }
        if (bl) {
            byte by;
            int n10 = n5 = (this.paraLevel & 1) != 0 ? 64 : 0;
            if (this.prologue != null && (by = this.firstL_R_AL()) != 10) {
                n3 = by == 0 ? 0 : 64;
                n2 = 2;
            } else {
                n3 = n5;
                n2 = 1;
            }
            n2 = 1;
        } else {
            n2 = 0;
            n3 = 0;
        }
        n4 = 0;
        while (n4 < this.originalLength) {
            int n11 = n4;
            int n12 = UTF16.charAt(this.text, 0, this.originalLength, n4);
            n = (n4 += UTF16.getCharCount(n12)) - 1;
            byte by = (byte)this.getCustomizedClass(n12);
            this.flags |= Bidi.DirPropFlag(by);
            this.dirProps[n] = (byte)(by | n3);
            if (n > n11) {
                this.flags |= Bidi.DirPropFlag((byte)18);
                do {
                    this.dirProps[--n] = (byte)(0x12 | n3);
                } while (n > n11);
            }
            if (n2 == 1) {
                if (by == 0) {
                    n2 = 2;
                    if (n3 == 0) continue;
                    n3 = 0;
                    n = n7;
                    while (n < n4) {
                        int n13 = n++;
                        this.dirProps[n13] = (byte)(this.dirProps[n13] & 0xFFFFFFBF);
                    }
                    continue;
                }
                if (by == 1 || by == 13) {
                    n2 = 2;
                    if (n3 != 0) continue;
                    n3 = 64;
                    n = n7;
                    while (n < n4) {
                        int n14 = n++;
                        this.dirProps[n14] = (byte)(this.dirProps[n14] | 0x40);
                    }
                    continue;
                }
            }
            if (by == 0) {
                n8 = 0;
                n9 = n4;
            } else if (by == 1) {
                n8 = 64;
            } else if (by == 13) {
                n8 = 64;
                this.lastArabicPos = n4 - 1;
            } else if (by == 7) {
                if ((this.reorderingOptions & 4) != 0) {
                    this.length = n4;
                }
                if (bl2 && n8 == 64 && n3 != n8) {
                    while (n7 < n4) {
                        int n15 = n7++;
                        this.dirProps[n15] = (byte)(this.dirProps[n15] | 0x40);
                    }
                }
                if (n4 < this.originalLength) {
                    if (n12 != 13 || this.text[n4] != '\n') {
                        ++this.paraCount;
                    }
                    if (bl) {
                        n2 = 1;
                        n7 = n4;
                        n3 = n5;
                        n8 = n5;
                    }
                }
            }
            if (!bl3 || !Bidi.IsBidiControlChar(n12)) continue;
            ++this.controlCount;
        }
        if (bl2 && n8 == 64 && n3 != n8) {
            n = n7;
            while (n < this.originalLength) {
                int n16 = n++;
                this.dirProps[n16] = (byte)(this.dirProps[n16] | 0x40);
            }
        }
        if (bl) {
            this.paraLevel = this.GetParaLevelAt(0);
        }
        if ((this.reorderingOptions & 4) > 0) {
            if (n9 > this.length && this.GetParaLevelAt(n9) == 0) {
                this.length = n9;
            }
            if (this.length < this.originalLength) {
                --this.paraCount;
            }
        }
        this.flags |= Bidi.DirPropFlagLR(this.paraLevel);
        if (this.orderParagraphsLTR && (this.flags & Bidi.DirPropFlag((byte)7)) != 0) {
            this.flags |= Bidi.DirPropFlag((byte)0);
        }
    }

    private byte directionFromFlags() {
        if ((this.flags & MASK_RTL) == 0 && ((this.flags & Bidi.DirPropFlag((byte)5)) == 0 || (this.flags & MASK_POSSIBLE_N) == 0)) {
            return 0;
        }
        if ((this.flags & MASK_LTR) == 0) {
            return 1;
        }
        return 2;
    }

    private byte resolveExplicitLevels() {
        int n = 0;
        byte by = this.GetParaLevelAt(0);
        int n2 = 0;
        byte by2 = this.directionFromFlags();
        if (by2 == 2 || this.paraCount != 1) {
            if (this.paraCount == 1 && ((this.flags & MASK_EXPLICIT) == 0 || this.reorderingMode > 1)) {
                for (n = 0; n < this.length; ++n) {
                    this.levels[n] = by;
                }
            } else {
                byte by3 = by;
                int n3 = 0;
                byte[] byArray = new byte[61];
                int n4 = 0;
                int n5 = 0;
                this.flags = 0;
                for (n = 0; n < this.length; ++n) {
                    byte by4 = Bidi.NoContextRTL(this.dirProps[n]);
                    switch (by4) {
                        case 11: 
                        case 12: {
                            byte by5 = (byte)(by3 + 2 & 0x7E);
                            if (by5 <= 61) {
                                byArray[n3] = by3;
                                n3 = (byte)(n3 + 1);
                                by3 = by5;
                                if (by4 == 12) {
                                    by3 = (byte)(by3 | 0xFFFFFF80);
                                }
                            } else if ((by3 & 0x7F) == 61) {
                                ++n5;
                            } else {
                                ++n4;
                            }
                            this.flags |= Bidi.DirPropFlag((byte)18);
                            break;
                        }
                        case 14: 
                        case 15: {
                            byte by5 = (byte)((by3 & 0x7F) + 1 | 1);
                            if (by5 <= 61) {
                                byArray[n3] = by3;
                                n3 = (byte)(n3 + 1);
                                by3 = by5;
                                if (by4 == 15) {
                                    by3 = (byte)(by3 | 0xFFFFFF80);
                                }
                            } else {
                                ++n5;
                            }
                            this.flags |= Bidi.DirPropFlag((byte)18);
                            break;
                        }
                        case 16: {
                            if (n5 > 0) {
                                --n5;
                            } else if (n4 > 0 && (by3 & 0x7F) != 61) {
                                --n4;
                            } else if (n3 > 0) {
                                n3 = (byte)(n3 - 1);
                                by3 = byArray[n3];
                            }
                            this.flags |= Bidi.DirPropFlag((byte)18);
                            break;
                        }
                        case 7: {
                            n3 = 0;
                            n4 = 0;
                            n5 = 0;
                            by = this.GetParaLevelAt(n);
                            if (n + 1 < this.length) {
                                by3 = this.GetParaLevelAt(n + 1);
                                if (this.text[n] != '\r' || this.text[n + 1] != '\n') {
                                    this.paras[n2++] = n + 1;
                                }
                            }
                            this.flags |= Bidi.DirPropFlag((byte)7);
                            break;
                        }
                        case 18: {
                            this.flags |= Bidi.DirPropFlag((byte)18);
                            break;
                        }
                        default: {
                            if (by != by3) {
                                by = by3;
                                this.flags = (by & 0xFFFFFF80) != 0 ? (this.flags |= Bidi.DirPropFlagO(by) | DirPropFlagMultiRuns) : (this.flags |= Bidi.DirPropFlagE(by) | DirPropFlagMultiRuns);
                            }
                            if ((by & 0xFFFFFF80) != 0) break;
                            this.flags |= Bidi.DirPropFlag(by4);
                        }
                    }
                    this.levels[n] = by;
                }
                if ((this.flags & MASK_EMBEDDING) != 0) {
                    this.flags |= Bidi.DirPropFlagLR(this.paraLevel);
                }
                if (this.orderParagraphsLTR && (this.flags & Bidi.DirPropFlag((byte)7)) != 0) {
                    this.flags |= Bidi.DirPropFlag((byte)0);
                }
                by2 = this.directionFromFlags();
            }
        }
        return by2;
    }

    private byte checkExplicitLevels() {
        this.flags = 0;
        int n = 0;
        for (int i = 0; i < this.length; ++i) {
            byte by = this.levels[i];
            byte by2 = Bidi.NoContextRTL(this.dirProps[i]);
            if ((by & 0xFFFFFF80) != 0) {
                by = (byte)(by & 0x7F);
                this.flags |= Bidi.DirPropFlagO(by);
            } else {
                this.flags |= Bidi.DirPropFlagE(by) | Bidi.DirPropFlag(by2);
            }
            if (by < this.GetParaLevelAt(i) && (0 != by || by2 != 7) || 61 < by) {
                throw new IllegalArgumentException("level " + by + " out of bounds at " + i);
            }
            if (by2 != 7 || i + 1 >= this.length || this.text[i] == '\r' && this.text[i + 1] == '\n') continue;
            this.paras[n++] = i + 1;
        }
        if ((this.flags & MASK_EMBEDDING) != 0) {
            this.flags |= Bidi.DirPropFlagLR(this.paraLevel);
        }
        return this.directionFromFlags();
    }

    private static short GetStateProps(short s) {
        return (short)(s & 0x1F);
    }

    private static short GetActionProps(short s) {
        return (short)(s >> 5);
    }

    private static short GetState(byte by) {
        return (short)(by & 0xF);
    }

    private static short GetAction(byte by) {
        return (short)(by >> 4);
    }

    private void addPoint(int n, int n2) {
        Point point = new Point();
        int n3 = this.insertPoints.points.length;
        if (n3 == 0) {
            this.insertPoints.points = new Point[10];
            n3 = 10;
        }
        if (this.insertPoints.size >= n3) {
            Point[] pointArray = this.insertPoints.points;
            this.insertPoints.points = new Point[n3 * 2];
            System.arraycopy(pointArray, 0, this.insertPoints.points, 0, n3);
        }
        point.pos = n;
        point.flag = n2;
        this.insertPoints.points[this.insertPoints.size] = point;
        ++this.insertPoints.size;
    }

    private void processPropertySeq(LevState levState, short s, int n, int n2) {
        int n3;
        byte by;
        byte[][] byArray = levState.impTab;
        short[] sArray = levState.impAct;
        int n4 = n;
        short s2 = levState.state;
        byte by2 = byArray[s2][s];
        levState.state = Bidi.GetState(by2);
        short s3 = sArray[Bidi.GetAction(by2)];
        byte by3 = byArray[levState.state][7];
        if (s3 != 0) {
            switch (s3) {
                case 1: {
                    levState.startON = n4;
                    break;
                }
                case 2: {
                    n = levState.startON;
                    break;
                }
                case 3: {
                    if (levState.startL2EN >= 0) {
                        this.addPoint(levState.startL2EN, 1);
                    }
                    levState.startL2EN = -1;
                    if (this.insertPoints.points.length == 0 || this.insertPoints.size <= this.insertPoints.confirmed) {
                        levState.lastStrongRTL = -1;
                        by = byArray[s2][7];
                        if ((by & 1) != 0 && levState.startON > 0) {
                            n = levState.startON;
                        }
                        if (s != 5) break;
                        this.addPoint(n4, 1);
                        this.insertPoints.confirmed = this.insertPoints.size;
                        break;
                    }
                    for (n3 = levState.lastStrongRTL + 1; n3 < n4; ++n3) {
                        this.levels[n3] = (byte)(this.levels[n3] - 2 & 0xFFFFFFFE);
                    }
                    this.insertPoints.confirmed = this.insertPoints.size;
                    levState.lastStrongRTL = -1;
                    if (s != 5) break;
                    this.addPoint(n4, 1);
                    this.insertPoints.confirmed = this.insertPoints.size;
                    break;
                }
                case 4: {
                    if (this.insertPoints.points.length > 0) {
                        this.insertPoints.size = this.insertPoints.confirmed;
                    }
                    levState.startON = -1;
                    levState.startL2EN = -1;
                    levState.lastStrongRTL = n2 - 1;
                    break;
                }
                case 5: {
                    if (s == 3 && Bidi.NoContextRTL(this.dirProps[n4]) == 5 && this.reorderingMode != 6) {
                        if (levState.startL2EN == -1) {
                            levState.lastStrongRTL = n2 - 1;
                            break;
                        }
                        if (levState.startL2EN >= 0) {
                            this.addPoint(levState.startL2EN, 1);
                            levState.startL2EN = -2;
                        }
                        this.addPoint(n4, 1);
                        break;
                    }
                    if (levState.startL2EN != -1) break;
                    levState.startL2EN = n4;
                    break;
                }
                case 6: {
                    levState.lastStrongRTL = n2 - 1;
                    levState.startON = -1;
                    break;
                }
                case 7: {
                    for (n3 = n4 - 1; n3 >= 0 && (this.levels[n3] & 1) == 0; --n3) {
                    }
                    if (n3 >= 0) {
                        this.addPoint(n3, 4);
                        this.insertPoints.confirmed = this.insertPoints.size;
                    }
                    levState.startON = n4;
                    break;
                }
                case 8: {
                    this.addPoint(n4, 1);
                    this.addPoint(n4, 2);
                    break;
                }
                case 9: {
                    this.insertPoints.size = this.insertPoints.confirmed;
                    if (s != 5) break;
                    this.addPoint(n4, 4);
                    this.insertPoints.confirmed = this.insertPoints.size;
                    break;
                }
                case 10: {
                    by = (byte)(levState.runLevel + by3);
                    for (n3 = levState.startON; n3 < n4; ++n3) {
                        if (this.levels[n3] >= by) continue;
                        this.levels[n3] = by;
                    }
                    this.insertPoints.confirmed = this.insertPoints.size;
                    levState.startON = n4;
                    break;
                }
                case 11: {
                    by = levState.runLevel;
                    for (n3 = n4 - 1; n3 >= levState.startON; --n3) {
                        if (this.levels[n3] == by + 3) {
                            while (this.levels[n3] == by + 3) {
                                int n5 = n3--;
                                this.levels[n5] = (byte)(this.levels[n5] - 2);
                            }
                            while (this.levels[n3] == by) {
                                --n3;
                            }
                        }
                        this.levels[n3] = this.levels[n3] == by + 2 ? by : (byte)(by + 1);
                    }
                    break;
                }
                case 12: {
                    by = (byte)(levState.runLevel + 1);
                    for (n3 = n4 - 1; n3 >= levState.startON; --n3) {
                        if (this.levels[n3] <= by) continue;
                        int n6 = n3;
                        this.levels[n6] = (byte)(this.levels[n6] - 2);
                    }
                    break;
                }
                default: {
                    throw new IllegalStateException("Internal ICU error in processPropertySeq");
                }
            }
        }
        if (by3 != 0 || n < n4) {
            by = (byte)(levState.runLevel + by3);
            for (n3 = n; n3 < n2; ++n3) {
                this.levels[n3] = by;
            }
        }
    }

    private byte lastL_R_AL() {
        int n;
        for (int i = this.prologue.length(); i > 0; i -= Character.charCount(n)) {
            n = this.prologue.codePointBefore(i);
            byte by = (byte)this.getCustomizedClass(n);
            if (by == 0) {
                return 0;
            }
            if (by != 1 && by != 13) continue;
            return 1;
        }
        return 4;
    }

    private byte firstL_R_AL_EN_AN() {
        int n;
        for (int i = 0; i < this.epilogue.length(); i += Character.charCount(n)) {
            n = this.epilogue.codePointAt(i);
            byte by = (byte)this.getCustomizedClass(n);
            if (by == 0) {
                return 0;
            }
            if (by == 1 || by == 13) {
                return 1;
            }
            if (by != 2) continue;
            return 2;
        }
        return 4;
    }

    private void resolveImplicitLevels(int n, int n2, short s, short s2) {
        short s3;
        LevState levState = new LevState();
        int n3 = 1;
        int n4 = -1;
        boolean bl = n < this.lastArabicPos && (this.GetParaLevelAt(n) & 1) > 0 && (this.reorderingMode == 5 || this.reorderingMode == 6);
        levState.startL2EN = -1;
        levState.lastStrongRTL = -1;
        levState.state = 0;
        levState.runLevel = this.levels[n];
        levState.impTab = this.impTabPair.imptab[levState.runLevel & 1];
        levState.impAct = this.impTabPair.impact[levState.runLevel & 1];
        if (n == 0 && this.prologue != null && (s3 = this.lastL_R_AL()) != 4) {
            s = s3;
        }
        this.processPropertySeq(levState, s, n, n);
        short s4 = Bidi.NoContextRTL(this.dirProps[n]) == 17 ? (short)(1 + s) : (short)0;
        int n5 = n;
        int n6 = 0;
        block6: for (int i = n; i <= n2; ++i) {
            short s5;
            if (i >= n2) {
                s5 = s2;
            } else {
                s3 = Bidi.NoContextRTL(this.dirProps[i]);
                if (bl) {
                    if (s3 == 13) {
                        s3 = 1;
                    } else if (s3 == 2) {
                        if (n4 <= i) {
                            n3 = 1;
                            n4 = n2;
                            for (int j = i + 1; j < n2; ++j) {
                                short s6 = Bidi.NoContextRTL(this.dirProps[j]);
                                if (s6 != 0 && s6 != 1 && s6 != 13) continue;
                                n3 = s6;
                                n4 = j;
                                break;
                            }
                        }
                        if (n3 == 13) {
                            s3 = (short)5;
                        }
                    }
                }
                s5 = groupProp[s3];
            }
            short s7 = s4;
            short s8 = impTabProps[s7][s5];
            s4 = Bidi.GetStateProps(s8);
            short s9 = Bidi.GetActionProps(s8);
            if (i == n2 && s9 == 0) {
                s9 = 1;
            }
            if (s9 == 0) continue;
            short s10 = impTabProps[s7][13];
            switch (s9) {
                case 1: {
                    this.processPropertySeq(levState, s10, n5, i);
                    n5 = i;
                    continue block6;
                }
                case 2: {
                    n6 = i;
                    continue block6;
                }
                case 3: {
                    this.processPropertySeq(levState, s10, n5, n6);
                    this.processPropertySeq(levState, (short)4, n6, i);
                    n5 = i;
                    continue block6;
                }
                case 4: {
                    this.processPropertySeq(levState, s10, n5, n6);
                    n5 = n6;
                    n6 = i;
                    continue block6;
                }
                default: {
                    throw new IllegalStateException("Internal ICU error in resolveImplicitLevels");
                }
            }
        }
        if (n2 == this.length && this.epilogue != null && (s3 = (short)this.firstL_R_AL_EN_AN()) != 4) {
            s2 = s3;
        }
        this.processPropertySeq(levState, s2, n2, n2);
    }

    private void adjustWSLevels() {
        if ((this.flags & MASK_WS) != 0) {
            int n = this.trailingWSStart;
            block0: while (n > 0) {
                int n2;
                while (n > 0 && ((n2 = Bidi.DirPropFlagNC(this.dirProps[--n])) & MASK_WS) != 0) {
                    if (this.orderParagraphsLTR && (n2 & Bidi.DirPropFlag((byte)7)) != 0) {
                        this.levels[n] = 0;
                        continue;
                    }
                    this.levels[n] = this.GetParaLevelAt(n);
                }
                while (n > 0) {
                    if (((n2 = Bidi.DirPropFlagNC(this.dirProps[--n])) & MASK_BN_EXPLICIT) != 0) {
                        this.levels[n] = this.levels[n + 1];
                        continue;
                    }
                    if (this.orderParagraphsLTR && (n2 & Bidi.DirPropFlag((byte)7)) != 0) {
                        this.levels[n] = 0;
                        continue block0;
                    }
                    if ((n2 & MASK_B_S) == 0) continue;
                    this.levels[n] = this.GetParaLevelAt(n);
                    continue block0;
                }
            }
        }
    }

    int Bidi_Min(int n, int n2) {
        return n < n2 ? n : n2;
    }

    int Bidi_Abs(int n) {
        return n >= 0 ? n : -n;
    }

    void setParaRunsOnly(char[] cArray, byte by) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        this.reorderingMode = 0;
        int n6 = cArray.length;
        if (n6 == 0) {
            this.setPara(cArray, by, null);
            this.reorderingMode = 3;
            return;
        }
        int n7 = this.reorderingOptions;
        if ((n7 & 1) > 0) {
            this.reorderingOptions &= 0xFFFFFFFE;
            this.reorderingOptions |= 2;
        }
        by = (byte)(by & 1);
        this.setPara(cArray, by, null);
        byte[] byArray = new byte[this.length];
        System.arraycopy(this.getLevels(), 0, byArray, 0, this.length);
        int n8 = this.trailingWSStart;
        String string = this.writeReordered(2);
        int[] nArray = this.getVisualMap();
        this.reorderingOptions = n7;
        int n9 = this.length;
        byte by2 = this.direction;
        this.reorderingMode = 5;
        by = (byte)(by ^ 1);
        this.setPara(string, by, null);
        BidiLine.getRuns(this);
        int n10 = 0;
        int n11 = this.runCount;
        int n12 = 0;
        int n13 = 0;
        while (n13 < n11) {
            n5 = this.runs[n13].limit - n12;
            if (n5 >= 2) {
                n4 = this.runs[n13].start;
                for (n3 = n4 + 1; n3 < n4 + n5; ++n3) {
                    n2 = nArray[n3];
                    n = nArray[n3 - 1];
                    if (this.Bidi_Abs(n2 - n) == 1 && byArray[n2] == byArray[n]) continue;
                    ++n10;
                }
            }
            ++n13;
            n12 += n5;
        }
        if (n10 > 0) {
            this.getRunsMemory(n11 + n10);
            if (this.runCount == 1) {
                this.runsMemory[0] = this.runs[0];
            } else {
                System.arraycopy(this.runs, 0, this.runsMemory, 0, this.runCount);
            }
            this.runs = this.runsMemory;
            this.runCount += n10;
            for (n13 = n11; n13 < this.runCount; ++n13) {
                if (this.runs[n13] != null) continue;
                this.runs[n13] = new BidiRun(0, 0, 0);
            }
        }
        for (n13 = n11 - 1; n13 >= 0; --n13) {
            int n14;
            int n15;
            int n16;
            int n17;
            int n18 = n13 + n10;
            n5 = n13 == 0 ? this.runs[0].limit : this.runs[n13].limit - this.runs[n13 - 1].limit;
            n4 = this.runs[n13].start;
            int n19 = this.runs[n13].level & 1;
            if (n5 < 2) {
                if (n10 > 0) {
                    this.runs[n18].copyFrom(this.runs[n13]);
                }
                this.runs[n18].start = n17 = nArray[n4];
                this.runs[n18].level = (byte)(byArray[n17] ^ n19);
                continue;
            }
            if (n19 > 0) {
                n16 = n4;
                n15 = n4 + n5 - 1;
                n14 = 1;
            } else {
                n16 = n4 + n5 - 1;
                n15 = n4;
                n14 = -1;
            }
            for (n3 = n16; n3 != n15; n3 += n14) {
                int n20;
                n2 = nArray[n3];
                n = nArray[n3 + n14];
                if (this.Bidi_Abs(n2 - n) == 1 && byArray[n2] == byArray[n]) continue;
                this.runs[n18].start = n17 = this.Bidi_Min(nArray[n16], n2);
                this.runs[n18].level = (byte)(byArray[n17] ^ n19);
                this.runs[n18].limit = this.runs[n13].limit;
                this.runs[n13].limit -= this.Bidi_Abs(n3 - n16) + 1;
                this.runs[n18].insertRemove = n20 = this.runs[n13].insertRemove & 0xA;
                this.runs[n13].insertRemove &= ~n20;
                n16 = n3 + n14;
                --n10;
                --n18;
            }
            if (n10 > 0) {
                this.runs[n18].copyFrom(this.runs[n13]);
            }
            this.runs[n18].start = n17 = this.Bidi_Min(nArray[n16], nArray[n15]);
            this.runs[n18].level = (byte)(byArray[n17] ^ n19);
        }
        this.paraLevel = (byte)(this.paraLevel ^ 1);
        this.text = cArray;
        this.length = n9;
        this.originalLength = n6;
        this.direction = by2;
        this.levels = byArray;
        this.trailingWSStart = n8;
        if (this.runCount > 1) {
            this.direction = (byte)2;
        }
        this.reorderingMode = 3;
    }

    private void setParaSuccess() {
        this.prologue = null;
        this.epilogue = null;
        this.paraBidi = this;
    }

    public void setContext(String string, String string2) {
        this.prologue = string != null && string.length() > 0 ? string : null;
        this.epilogue = string2 != null && string2.length() > 0 ? string2 : null;
    }

    public void setPara(String string, byte by, byte[] byArray) {
        if (string == null) {
            this.setPara(new char[0], by, byArray);
        } else {
            this.setPara(string.toCharArray(), by, byArray);
        }
    }

    public void setPara(char[] cArray, byte by, byte[] byArray) {
        int n;
        int n2;
        byte by2;
        byte by3;
        int n3;
        if (by < 126) {
            this.verifyRange(by, 0, 62);
        }
        if (cArray == null) {
            cArray = new char[]{};
        }
        if (this.reorderingMode == 3) {
            this.setParaRunsOnly(cArray, by);
            return;
        }
        this.paraBidi = null;
        this.text = cArray;
        this.originalLength = this.resultLength = this.text.length;
        this.length = this.resultLength;
        this.paraLevel = by;
        this.direction = 0;
        this.paraCount = 1;
        this.dirProps = new byte[0];
        this.levels = new byte[0];
        this.runs = new BidiRun[0];
        this.isGoodLogicalToVisualRunsMap = false;
        this.insertPoints.size = 0;
        this.insertPoints.confirmed = 0;
        this.defaultParaLevel = Bidi.IsDefaultLevel(by) ? by : (byte)0;
        if (this.length == 0) {
            if (Bidi.IsDefaultLevel(by)) {
                this.paraLevel = (byte)(this.paraLevel & 1);
                this.defaultParaLevel = 0;
            }
            if ((this.paraLevel & 1) != 0) {
                this.flags = Bidi.DirPropFlag((byte)1);
                this.direction = 1;
            } else {
                this.flags = Bidi.DirPropFlag((byte)0);
                this.direction = 0;
            }
            this.runCount = 0;
            this.paraCount = 0;
            this.setParaSuccess();
            return;
        }
        this.runCount = -1;
        this.getDirPropsMemory(this.length);
        this.dirProps = this.dirPropsMemory;
        this.getDirProps();
        this.trailingWSStart = this.length;
        if (this.paraCount > 1) {
            this.getInitialParasMemory(this.paraCount);
            this.paras = this.parasMemory;
            this.paras[this.paraCount - 1] = this.length;
        } else {
            this.paras = this.simpleParas;
            this.simpleParas[0] = this.length;
        }
        if (byArray == null) {
            this.getLevelsMemory(this.length);
            this.levels = this.levelsMemory;
            this.direction = this.resolveExplicitLevels();
        } else {
            this.levels = byArray;
            this.direction = this.checkExplicitLevels();
        }
        switch (this.direction) {
            case 0: {
                by = (byte)(by + 1 & 0xFFFFFFFE);
                this.trailingWSStart = 0;
                break;
            }
            case 1: {
                by = (byte)(by | 1);
                this.trailingWSStart = 0;
                break;
            }
            default: {
                switch (this.reorderingMode) {
                    case 0: {
                        this.impTabPair = impTab_DEFAULT;
                        break;
                    }
                    case 1: {
                        this.impTabPair = impTab_NUMBERS_SPECIAL;
                        break;
                    }
                    case 2: {
                        this.impTabPair = impTab_GROUP_NUMBERS_WITH_R;
                        break;
                    }
                    case 3: {
                        throw new InternalError("Internal ICU error in setPara");
                    }
                    case 4: {
                        this.impTabPair = impTab_INVERSE_NUMBERS_AS_L;
                        break;
                    }
                    case 5: {
                        if ((this.reorderingOptions & 1) != 0) {
                            this.impTabPair = impTab_INVERSE_LIKE_DIRECT_WITH_MARKS;
                            break;
                        }
                        this.impTabPair = impTab_INVERSE_LIKE_DIRECT;
                        break;
                    }
                    case 6: {
                        this.impTabPair = (this.reorderingOptions & 1) != 0 ? impTab_INVERSE_FOR_NUMBERS_SPECIAL_WITH_MARKS : impTab_INVERSE_FOR_NUMBERS_SPECIAL;
                    }
                }
                if (byArray == null && this.paraCount <= 1 && (this.flags & DirPropFlagMultiRuns) == 0) {
                    this.resolveImplicitLevels(0, this.length, Bidi.GetLRFromLevel(this.GetParaLevelAt(0)), Bidi.GetLRFromLevel(this.GetParaLevelAt(this.length - 1)));
                } else {
                    n3 = 0;
                    by3 = this.GetParaLevelAt(0);
                    int n4 = by3 < (by2 = this.levels[0]) ? (int)Bidi.GetLRFromLevel(by2) : (short)Bidi.GetLRFromLevel(by3);
                    do {
                        n2 = n3;
                        by3 = by2;
                        n = n2 > 0 && Bidi.NoContextRTL(this.dirProps[n2 - 1]) == 7 ? (int)Bidi.GetLRFromLevel(this.GetParaLevelAt(n2)) : n4;
                        while (++n3 < this.length && this.levels[n3] == by3) {
                        }
                        by2 = n3 < this.length ? this.levels[n3] : (byte)this.GetParaLevelAt(this.length - 1);
                        n4 = (by3 & 0x7F) < (by2 & 0x7F) ? (int)Bidi.GetLRFromLevel(by2) : (int)Bidi.GetLRFromLevel(by3);
                        if ((by3 & 0xFFFFFF80) == 0) {
                            this.resolveImplicitLevels(n2, n3, (short)n, (short)n4);
                            continue;
                        }
                        do {
                            int n5 = n2++;
                            this.levels[n5] = (byte)(this.levels[n5] & 0x7F);
                        } while (n2 < n3);
                    } while (n3 < this.length);
                }
                this.adjustWSLevels();
            }
        }
        if (this.defaultParaLevel > 0 && (this.reorderingOptions & 1) != 0 && (this.reorderingMode == 5 || this.reorderingMode == 6)) {
            block16: for (by2 = 0; by2 < this.paraCount; ++by2) {
                n3 = this.paras[by2] - 1;
                if ((this.dirProps[n3] & 0x40) == 0) continue;
                n2 = by2 == 0 ? 0 : this.paras[by2 - 1];
                for (n = n3; n >= n2; --n) {
                    by3 = Bidi.NoContextRTL(this.dirProps[n]);
                    if (by3 == 0) {
                        if (n < n3) {
                            while (Bidi.NoContextRTL(this.dirProps[n3]) == 7) {
                                --n3;
                            }
                        }
                        this.addPoint(n3, 4);
                        continue block16;
                    }
                    if ((Bidi.DirPropFlag(by3) & 0x2002) != 0) continue block16;
                }
            }
        }
        this.resultLength = (this.reorderingOptions & 2) != 0 ? (this.resultLength -= this.controlCount) : (this.resultLength += this.insertPoints.size);
        this.setParaSuccess();
    }

    public void setPara(AttributedCharacterIterator attributedCharacterIterator) {
        Serializable serializable;
        Boolean bl = (Boolean)attributedCharacterIterator.getAttribute(TextAttribute.RUN_DIRECTION);
        byte by = bl == null ? (byte)126 : (bl.equals(TextAttribute.RUN_DIRECTION_LTR) ? (byte)0 : 1);
        byte[] byArray = null;
        int n = attributedCharacterIterator.getEndIndex() - attributedCharacterIterator.getBeginIndex();
        byte[] byArray2 = new byte[n];
        char[] cArray = new char[n];
        int n2 = 0;
        char c = attributedCharacterIterator.first();
        while (c != '\uffff') {
            byte by2;
            cArray[n2] = c;
            serializable = (Integer)attributedCharacterIterator.getAttribute(TextAttribute.BIDI_EMBEDDING);
            if (serializable != null && (by2 = ((Integer)serializable).byteValue()) != 0) {
                if (by2 < 0) {
                    byArray = byArray2;
                    byArray2[n2] = (byte)(0 - by2 | 0xFFFFFF80);
                } else {
                    byArray = byArray2;
                    byArray2[n2] = by2;
                }
            }
            c = attributedCharacterIterator.next();
            ++n2;
        }
        serializable = (NumericShaper)attributedCharacterIterator.getAttribute(TextAttribute.NUMERIC_SHAPING);
        if (serializable != null) {
            ((NumericShaper)serializable).shape(cArray, 0, n);
        }
        this.setPara(cArray, by, byArray);
    }

    public void orderParagraphsLTR(boolean bl) {
        this.orderParagraphsLTR = bl;
    }

    public boolean isOrderParagraphsLTR() {
        return this.orderParagraphsLTR;
    }

    public byte getDirection() {
        this.verifyValidParaOrLine();
        return this.direction;
    }

    public String getTextAsString() {
        this.verifyValidParaOrLine();
        return new String(this.text);
    }

    public char[] getText() {
        this.verifyValidParaOrLine();
        return this.text;
    }

    public int getLength() {
        this.verifyValidParaOrLine();
        return this.originalLength;
    }

    public int getProcessedLength() {
        this.verifyValidParaOrLine();
        return this.length;
    }

    public int getResultLength() {
        this.verifyValidParaOrLine();
        return this.resultLength;
    }

    public byte getParaLevel() {
        this.verifyValidParaOrLine();
        return this.paraLevel;
    }

    public int countParagraphs() {
        this.verifyValidParaOrLine();
        return this.paraCount;
    }

    public BidiRun getParagraphByIndex(int n) {
        this.verifyValidParaOrLine();
        this.verifyRange(n, 0, this.paraCount);
        Bidi bidi = this.paraBidi;
        int n2 = n == 0 ? 0 : bidi.paras[n - 1];
        BidiRun bidiRun = new BidiRun();
        bidiRun.start = n2;
        bidiRun.limit = bidi.paras[n];
        bidiRun.level = this.GetParaLevelAt(n2);
        return bidiRun;
    }

    public BidiRun getParagraph(int n) {
        this.verifyValidParaOrLine();
        Bidi bidi = this.paraBidi;
        this.verifyRange(n, 0, bidi.length);
        int n2 = 0;
        while (n >= bidi.paras[n2]) {
            ++n2;
        }
        return this.getParagraphByIndex(n2);
    }

    public int getParagraphIndex(int n) {
        this.verifyValidParaOrLine();
        Bidi bidi = this.paraBidi;
        this.verifyRange(n, 0, bidi.length);
        int n2 = 0;
        while (n >= bidi.paras[n2]) {
            ++n2;
        }
        return n2;
    }

    public void setCustomClassifier(BidiClassifier bidiClassifier) {
        this.customClassifier = bidiClassifier;
    }

    public BidiClassifier getCustomClassifier() {
        return this.customClassifier;
    }

    public int getCustomizedClass(int n) {
        int n2;
        if (this.customClassifier == null || (n2 = this.customClassifier.classify(n)) == 19) {
            return this.bdp.getClass(n);
        }
        return n2;
    }

    public Bidi setLine(int n, int n2) {
        this.verifyValidPara();
        this.verifyRange(n, 0, n2);
        this.verifyRange(n2, 0, this.length + 1);
        if (this.getParagraphIndex(n) != this.getParagraphIndex(n2 - 1)) {
            throw new IllegalArgumentException();
        }
        return BidiLine.setLine(this, n, n2);
    }

    public byte getLevelAt(int n) {
        this.verifyValidParaOrLine();
        this.verifyRange(n, 0, this.length);
        return BidiLine.getLevelAt(this, n);
    }

    public byte[] getLevels() {
        this.verifyValidParaOrLine();
        if (this.length <= 0) {
            return new byte[0];
        }
        return BidiLine.getLevels(this);
    }

    public BidiRun getLogicalRun(int n) {
        this.verifyValidParaOrLine();
        this.verifyRange(n, 0, this.length);
        return BidiLine.getLogicalRun(this, n);
    }

    public int countRuns() {
        this.verifyValidParaOrLine();
        BidiLine.getRuns(this);
        return this.runCount;
    }

    public BidiRun getVisualRun(int n) {
        this.verifyValidParaOrLine();
        BidiLine.getRuns(this);
        this.verifyRange(n, 0, this.runCount);
        return BidiLine.getVisualRun(this, n);
    }

    public int getVisualIndex(int n) {
        this.verifyValidParaOrLine();
        this.verifyRange(n, 0, this.length);
        return BidiLine.getVisualIndex(this, n);
    }

    public int getLogicalIndex(int n) {
        this.verifyValidParaOrLine();
        this.verifyRange(n, 0, this.resultLength);
        if (this.insertPoints.size == 0 && this.controlCount == 0) {
            if (this.direction == 0) {
                return n;
            }
            if (this.direction == 1) {
                return this.length - n - 1;
            }
        }
        BidiLine.getRuns(this);
        return BidiLine.getLogicalIndex(this, n);
    }

    public int[] getLogicalMap() {
        this.countRuns();
        if (this.length <= 0) {
            return new int[0];
        }
        return BidiLine.getLogicalMap(this);
    }

    public int[] getVisualMap() {
        this.countRuns();
        if (this.resultLength <= 0) {
            return new int[0];
        }
        return BidiLine.getVisualMap(this);
    }

    public static int[] reorderLogical(byte[] byArray) {
        return BidiLine.reorderLogical(byArray);
    }

    public static int[] reorderVisual(byte[] byArray) {
        return BidiLine.reorderVisual(byArray);
    }

    public static int[] invertMap(int[] nArray) {
        if (nArray == null) {
            return null;
        }
        return BidiLine.invertMap(nArray);
    }

    public Bidi(String string, int n) {
        this(string.toCharArray(), 0, null, 0, string.length(), n);
    }

    public Bidi(AttributedCharacterIterator attributedCharacterIterator) {
        this();
        this.setPara(attributedCharacterIterator);
    }

    public Bidi(char[] cArray, int n, byte[] byArray, int n2, int n3, int n4) {
        this();
        byte[] byArray2;
        byte by;
        switch (n4) {
            default: {
                by = 0;
                break;
            }
            case 1: {
                by = 1;
                break;
            }
            case 126: {
                by = 126;
                break;
            }
            case 127: {
                by = 127;
            }
        }
        if (byArray == null) {
            byArray2 = null;
        } else {
            byArray2 = new byte[n3];
            for (int i = 0; i < n3; ++i) {
                byte by2 = byArray[i + n2];
                if (by2 < 0) {
                    by2 = (byte)(-by2 | 0xFFFFFF80);
                } else if (by2 == 0) {
                    by2 = by;
                    if (by > 61) {
                        by2 = (byte)(by2 & 1);
                    }
                }
                byArray2[i] = by2;
            }
        }
        if (n == 0 && n2 == 0 && n3 == cArray.length) {
            this.setPara(cArray, by, byArray2);
        } else {
            char[] cArray2 = new char[n3];
            System.arraycopy(cArray, n, cArray2, 0, n3);
            this.setPara(cArray2, by, byArray2);
        }
    }

    public Bidi createLineBidi(int n, int n2) {
        return this.setLine(n, n2);
    }

    public boolean isMixed() {
        return !this.isLeftToRight() && !this.isRightToLeft();
    }

    public boolean isLeftToRight() {
        return this.getDirection() == 0 && (this.paraLevel & 1) == 0;
    }

    public boolean isRightToLeft() {
        return this.getDirection() == 1 && (this.paraLevel & 1) == 1;
    }

    public boolean baseIsLeftToRight() {
        return this.getParaLevel() == 0;
    }

    public int getBaseLevel() {
        return this.getParaLevel();
    }

    public int getRunCount() {
        return this.countRuns();
    }

    void getLogicalToVisualRunsMap() {
        int n;
        if (this.isGoodLogicalToVisualRunsMap) {
            return;
        }
        int n2 = this.countRuns();
        if (this.logicalToVisualRunsMap == null || this.logicalToVisualRunsMap.length < n2) {
            this.logicalToVisualRunsMap = new int[n2];
        }
        long[] lArray = new long[n2];
        for (n = 0; n < n2; ++n) {
            lArray[n] = ((long)this.runs[n].start << 32) + (long)n;
        }
        Arrays.sort(lArray);
        for (n = 0; n < n2; ++n) {
            this.logicalToVisualRunsMap[n] = (int)(lArray[n] & 0xFFFFFFFFFFFFFFFFL);
        }
        this.isGoodLogicalToVisualRunsMap = true;
    }

    public int getRunLevel(int n) {
        this.verifyValidParaOrLine();
        BidiLine.getRuns(this);
        this.verifyRange(n, 0, this.runCount);
        this.getLogicalToVisualRunsMap();
        return this.runs[this.logicalToVisualRunsMap[n]].level;
    }

    public int getRunStart(int n) {
        this.verifyValidParaOrLine();
        BidiLine.getRuns(this);
        this.verifyRange(n, 0, this.runCount);
        this.getLogicalToVisualRunsMap();
        return this.runs[this.logicalToVisualRunsMap[n]].start;
    }

    public int getRunLimit(int n) {
        this.verifyValidParaOrLine();
        BidiLine.getRuns(this);
        this.verifyRange(n, 0, this.runCount);
        this.getLogicalToVisualRunsMap();
        int n2 = this.logicalToVisualRunsMap[n];
        int n3 = n2 == 0 ? this.runs[n2].limit : this.runs[n2].limit - this.runs[n2 - 1].limit;
        return this.runs[n2].start + n3;
    }

    public static boolean requiresBidi(char[] cArray, int n, int n2) {
        int n3 = 57378;
        for (int i = n; i < n2; ++i) {
            if ((1 << UCharacter.getDirection(cArray[i]) & 0xE022) == 0) continue;
            return true;
        }
        return false;
    }

    public static void reorderVisually(byte[] byArray, int n, Object[] objectArray, int n2, int n3) {
        byte[] byArray2 = new byte[n3];
        System.arraycopy(byArray, n, byArray2, 0, n3);
        int[] nArray = Bidi.reorderVisual(byArray2);
        Object[] objectArray2 = new Object[n3];
        System.arraycopy(objectArray, n2, objectArray2, 0, n3);
        for (int i = 0; i < n3; ++i) {
            objectArray[n2 + i] = objectArray2[nArray[i]];
        }
    }

    public String writeReordered(int n) {
        this.verifyValidParaOrLine();
        if (this.length == 0) {
            return "";
        }
        return BidiWriter.writeReordered(this, n);
    }

    public static String writeReverse(String string, int n) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        if (string.length() > 0) {
            return BidiWriter.writeReverse(string, n);
        }
        return "";
    }

    public static byte getBaseDirection(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return 3;
        }
        int n = charSequence.length();
        int n2 = 0;
        while (n2 < n) {
            int n3 = UCharacter.codePointAt(charSequence, n2);
            byte by = UCharacter.getDirectionality(n3);
            if (by == 0) {
                return 0;
            }
            if (by == 1 || by == 13) {
                return 1;
            }
            n2 = UCharacter.offsetByCodePoints(charSequence, n2, 1);
        }
        return 3;
    }

    private static class LevState {
        byte[][] impTab;
        short[] impAct;
        int startON;
        int startL2EN;
        int lastStrongRTL;
        short state;
        byte runLevel;

        private LevState() {
        }
    }

    private static class ImpTabPair {
        byte[][][] imptab;
        short[][] impact;

        ImpTabPair(byte[][] byArray, byte[][] byArray2, short[] sArray, short[] sArray2) {
            this.imptab = new byte[][][]{byArray, byArray2};
            this.impact = new short[][]{sArray, sArray2};
        }
    }

    public static class InsertPoints {
        int size;
        int confirmed;
        Point[] points = new Point[0];

        InsertPoints() {
        }
    }

    public static class Point {
        int pos;
        int flag;

        Point() {
        }
    }
}

