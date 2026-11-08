/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.Norm2AllModes;
import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.Trie2;
import com.ibm.icu.impl.Trie2_16;
import com.ibm.icu.impl.UBiDiProps;
import com.ibm.icu.impl.UCaseProps;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.VersionInfo;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;

public class UCharacterProperty {
    public static final UCharacterProperty INSTANCE;
    public Trie2_16 m_trie_;
    public VersionInfo m_unicodeVersion_;
    public static final char LATIN_CAPITAL_LETTER_I_WITH_DOT_ABOVE_ = '\u0130';
    public static final char LATIN_SMALL_LETTER_DOTLESS_I_ = '\u0131';
    public static final char LATIN_SMALL_LETTER_I_ = 'i';
    public static final int TYPE_MASK = 31;
    public static final int SRC_NONE = 0;
    public static final int SRC_CHAR = 1;
    public static final int SRC_PROPSVEC = 2;
    public static final int SRC_NAMES = 3;
    public static final int SRC_CASE = 4;
    public static final int SRC_BIDI = 5;
    public static final int SRC_CHAR_AND_PROPSVEC = 6;
    public static final int SRC_CASE_AND_NORM = 7;
    public static final int SRC_NFC = 8;
    public static final int SRC_NFKC = 9;
    public static final int SRC_NFKC_CF = 10;
    public static final int SRC_NFC_CANON_ITER = 11;
    public static final int SRC_COUNT = 12;
    static final int MY_MASK = 30;
    private static final int GC_CN_MASK;
    private static final int GC_CC_MASK;
    private static final int GC_CS_MASK;
    private static final int GC_ZS_MASK;
    private static final int GC_ZL_MASK;
    private static final int GC_ZP_MASK;
    private static final int GC_Z_MASK;
    BinaryProperty[] binProps = new BinaryProperty[]{new BinaryProperty(1, 256), new BinaryProperty(1, 128), new BinaryProperty(5){

        boolean contains(int n) {
            return UBiDiProps.INSTANCE.isBidiControl(n);
        }
    }, new BinaryProperty(5){

        boolean contains(int n) {
            return UBiDiProps.INSTANCE.isMirrored(n);
        }
    }, new BinaryProperty(1, 2), new BinaryProperty(1, 524288), new BinaryProperty(1, 0x100000), new BinaryProperty(1, 1024), new BinaryProperty(1, 2048), new BinaryProperty(8){

        boolean contains(int n) {
            Normalizer2Impl normalizer2Impl = Norm2AllModes.getNFCInstance().impl;
            return normalizer2Impl.isCompNo(normalizer2Impl.getNorm16(n));
        }
    }, new BinaryProperty(1, 0x4000000), new BinaryProperty(1, 8192), new BinaryProperty(1, 16384), new BinaryProperty(1, 64), new BinaryProperty(1, 4), new BinaryProperty(1, 0x2000000), new BinaryProperty(1, 0x1000000), new BinaryProperty(1, 512), new BinaryProperty(1, 32768), new BinaryProperty(1, 65536), new BinaryProperty(5){

        boolean contains(int n) {
            return UBiDiProps.INSTANCE.isJoinControl(n);
        }
    }, new BinaryProperty(1, 0x200000), new CaseBinaryProperty(22), new BinaryProperty(1, 32), new BinaryProperty(1, 4096), new BinaryProperty(1, 8), new BinaryProperty(1, 131072), new CaseBinaryProperty(27), new BinaryProperty(1, 16), new BinaryProperty(1, 262144), new CaseBinaryProperty(30), new BinaryProperty(1, 1), new BinaryProperty(1, 0x800000), new BinaryProperty(1, 0x400000), new CaseBinaryProperty(34), new BinaryProperty(1, 0x8000000), new BinaryProperty(1, 0x10000000), new NormInertBinaryProperty(8, 37), new NormInertBinaryProperty(9, 38), new NormInertBinaryProperty(8, 39), new NormInertBinaryProperty(9, 40), new BinaryProperty(11){

        boolean contains(int n) {
            return Norm2AllModes.getNFCInstance().impl.ensureCanonIterData().isCanonSegmentStarter(n);
        }
    }, new BinaryProperty(1, 0x20000000), new BinaryProperty(1, 0x40000000), new BinaryProperty(6){

        boolean contains(int n) {
            return UCharacter.isUAlphabetic(n) || UCharacter.isDigit(n);
        }
    }, new BinaryProperty(1){

        boolean contains(int n) {
            if (n <= 159) {
                return n == 9 || n == 32;
            }
            return UCharacter.getType(n) == 12;
        }
    }, new BinaryProperty(1){

        boolean contains(int n) {
            return UCharacterProperty.isgraphPOSIX(n);
        }
    }, new BinaryProperty(1){

        boolean contains(int n) {
            return UCharacter.getType(n) == 12 || UCharacterProperty.isgraphPOSIX(n);
        }
    }, new BinaryProperty(1){

        boolean contains(int n) {
            if (n <= 102 && n >= 65 && (n <= 70 || n >= 97) || n >= 65313 && n <= 65350 && (n <= 65318 || n >= 65345)) {
                return true;
            }
            return UCharacter.getType(n) == 9;
        }
    }, new CaseBinaryProperty(49), new CaseBinaryProperty(50), new CaseBinaryProperty(51), new CaseBinaryProperty(52), new CaseBinaryProperty(53), new BinaryProperty(7){

        boolean contains(int n) {
            String string = Norm2AllModes.getNFCInstance().impl.getDecomposition(n);
            if (string != null) {
                n = string.codePointAt(0);
                if (Character.charCount(n) != string.length()) {
                    n = -1;
                }
            } else if (n < 0) {
                return false;
            }
            if (n >= 0) {
                UCaseProps uCaseProps = UCaseProps.INSTANCE;
                UCaseProps.dummyStringBuilder.setLength(0);
                return uCaseProps.toFullFolding(n, UCaseProps.dummyStringBuilder, 0) >= 0;
            }
            String string2 = UCharacter.foldCase(string, true);
            return !string2.equals(string);
        }
    }, new CaseBinaryProperty(55), new BinaryProperty(10){

        boolean contains(int n) {
            Normalizer2Impl normalizer2Impl = Norm2AllModes.getNFKC_CFInstance().impl;
            String string = UTF16.valueOf(n);
            StringBuilder stringBuilder = new StringBuilder();
            Normalizer2Impl.ReorderingBuffer reorderingBuffer = new Normalizer2Impl.ReorderingBuffer(normalizer2Impl, stringBuilder, 5);
            normalizer2Impl.compose(string, 0, string.length(), false, true, reorderingBuffer);
            return !Normalizer2Impl.UTF16Plus.equal(stringBuilder, string);
        }
    }};
    private static final int[] gcbToHst;
    IntProperty[] intProps = new IntProperty[]{new BiDiIntProperty(){

        int getValue(int n) {
            return UBiDiProps.INSTANCE.getClass(n);
        }
    }, new IntProperty(0, 130816, 8), new CombiningClassIntProperty(8){

        int getValue(int n) {
            return Norm2AllModes.getNFCInstance().decomp.getCombiningClass(n);
        }
    }, new IntProperty(2, 31, 0), new IntProperty(0, 917504, 17), new IntProperty(1){

        int getValue(int n) {
            return UCharacterProperty.this.getType(n);
        }

        int getMaxValue(int n) {
            return 29;
        }
    }, new BiDiIntProperty(){

        int getValue(int n) {
            return UBiDiProps.INSTANCE.getJoiningGroup(n);
        }
    }, new BiDiIntProperty(){

        int getValue(int n) {
            return UBiDiProps.INSTANCE.getJoiningType(n);
        }
    }, new IntProperty(2, 0x3F00000, 20), new IntProperty(1){

        int getValue(int n) {
            return UCharacterProperty.ntvGetType(UCharacterProperty.getNumericTypeValue(UCharacterProperty.this.getProperty(n)));
        }

        int getMaxValue(int n) {
            return 3;
        }
    }, new IntProperty(0, 255, 0){

        int getValue(int n) {
            return UScript.getScript(n);
        }
    }, new IntProperty(2){

        int getValue(int n) {
            int n2 = (UCharacterProperty.this.getAdditional(n, 2) & 0x3E0) >>> 5;
            if (n2 < gcbToHst.length) {
                return gcbToHst[n2];
            }
            return 0;
        }

        int getMaxValue(int n) {
            return 5;
        }
    }, new NormQuickCheckIntProperty(8, 4108, 1), new NormQuickCheckIntProperty(9, 4109, 1), new NormQuickCheckIntProperty(8, 4110, 2), new NormQuickCheckIntProperty(9, 4111, 2), new CombiningClassIntProperty(8){

        int getValue(int n) {
            return Norm2AllModes.getNFCInstance().impl.getFCD16(n) >> 8;
        }
    }, new CombiningClassIntProperty(8){

        int getValue(int n) {
            return Norm2AllModes.getNFCInstance().impl.getFCD16(n) & 0xFF;
        }
    }, new IntProperty(2, 992, 5), new IntProperty(2, 1015808, 15), new IntProperty(2, 31744, 10)};
    Trie2_16 m_additionalTrie_;
    int[] m_additionalVectors_;
    int m_additionalColumnsCount_;
    int m_maxBlockScriptValue_;
    int m_maxJTGValue_;
    public char[] m_scriptExtensions_;
    private static final String DATA_FILE_NAME_ = "data/icudt51b/uprops.icu";
    private static final int DATA_BUFFER_SIZE_ = 25000;
    private static final int LEAD_SURROGATE_SHIFT_ = 10;
    private static final int SURROGATE_OFFSET_ = -56613888;
    private static final int NUMERIC_TYPE_VALUE_SHIFT_ = 6;
    private static final int NTV_NONE_ = 0;
    private static final int NTV_DECIMAL_START_ = 1;
    private static final int NTV_DIGIT_START_ = 11;
    private static final int NTV_NUMERIC_START_ = 21;
    private static final int NTV_FRACTION_START_ = 176;
    private static final int NTV_LARGE_START_ = 480;
    private static final int NTV_BASE60_START_ = 768;
    private static final int NTV_RESERVED_START_ = 804;
    public static final int SCRIPT_X_MASK = 0xC000FF;
    private static final int EAST_ASIAN_MASK_ = 917504;
    private static final int EAST_ASIAN_SHIFT_ = 17;
    private static final int BLOCK_MASK_ = 130816;
    private static final int BLOCK_SHIFT_ = 8;
    public static final int SCRIPT_MASK_ = 255;
    public static final int SCRIPT_X_WITH_COMMON = 0x400000;
    public static final int SCRIPT_X_WITH_INHERITED = 0x800000;
    public static final int SCRIPT_X_WITH_OTHER = 0xC00000;
    private static final int WHITE_SPACE_PROPERTY_ = 0;
    private static final int DASH_PROPERTY_ = 1;
    private static final int HYPHEN_PROPERTY_ = 2;
    private static final int QUOTATION_MARK_PROPERTY_ = 3;
    private static final int TERMINAL_PUNCTUATION_PROPERTY_ = 4;
    private static final int MATH_PROPERTY_ = 5;
    private static final int HEX_DIGIT_PROPERTY_ = 6;
    private static final int ASCII_HEX_DIGIT_PROPERTY_ = 7;
    private static final int ALPHABETIC_PROPERTY_ = 8;
    private static final int IDEOGRAPHIC_PROPERTY_ = 9;
    private static final int DIACRITIC_PROPERTY_ = 10;
    private static final int EXTENDER_PROPERTY_ = 11;
    private static final int NONCHARACTER_CODE_POINT_PROPERTY_ = 12;
    private static final int GRAPHEME_EXTEND_PROPERTY_ = 13;
    private static final int GRAPHEME_LINK_PROPERTY_ = 14;
    private static final int IDS_BINARY_OPERATOR_PROPERTY_ = 15;
    private static final int IDS_TRINARY_OPERATOR_PROPERTY_ = 16;
    private static final int RADICAL_PROPERTY_ = 17;
    private static final int UNIFIED_IDEOGRAPH_PROPERTY_ = 18;
    private static final int DEFAULT_IGNORABLE_CODE_POINT_PROPERTY_ = 19;
    private static final int DEPRECATED_PROPERTY_ = 20;
    private static final int LOGICAL_ORDER_EXCEPTION_PROPERTY_ = 21;
    private static final int XID_START_PROPERTY_ = 22;
    private static final int XID_CONTINUE_PROPERTY_ = 23;
    private static final int ID_START_PROPERTY_ = 24;
    private static final int ID_CONTINUE_PROPERTY_ = 25;
    private static final int GRAPHEME_BASE_PROPERTY_ = 26;
    private static final int S_TERM_PROPERTY_ = 27;
    private static final int VARIATION_SELECTOR_PROPERTY_ = 28;
    private static final int PATTERN_SYNTAX = 29;
    private static final int PATTERN_WHITE_SPACE = 30;
    private static final int LB_MASK = 0x3F00000;
    private static final int LB_SHIFT = 20;
    private static final int SB_MASK = 1015808;
    private static final int SB_SHIFT = 15;
    private static final int WB_MASK = 31744;
    private static final int WB_SHIFT = 10;
    private static final int GCB_MASK = 992;
    private static final int GCB_SHIFT = 5;
    private static final int DECOMPOSITION_TYPE_MASK_ = 31;
    private static final int FIRST_NIBBLE_SHIFT_ = 4;
    private static final int LAST_NIBBLE_MASK_ = 15;
    private static final int AGE_SHIFT_ = 24;
    private static final byte[] DATA_FORMAT;
    private static final int TAB = 9;
    private static final int CR = 13;
    private static final int U_A = 65;
    private static final int U_F = 70;
    private static final int U_Z = 90;
    private static final int U_a = 97;
    private static final int U_f = 102;
    private static final int U_z = 122;
    private static final int DEL = 127;
    private static final int NL = 133;
    private static final int NBSP = 160;
    private static final int CGJ = 847;
    private static final int FIGURESP = 8199;
    private static final int HAIRSP = 8202;
    private static final int RLM = 8207;
    private static final int NNBSP = 8239;
    private static final int WJ = 8288;
    private static final int INHSWAP = 8298;
    private static final int NOMDIG = 8303;
    private static final int U_FW_A = 65313;
    private static final int U_FW_F = 65318;
    private static final int U_FW_Z = 65338;
    private static final int U_FW_a = 65345;
    private static final int U_FW_f = 65350;
    private static final int U_FW_z = 65370;
    private static final int ZWNBSP = 65279;

    public final int getProperty(int n) {
        return this.m_trie_.get(n);
    }

    public int getAdditional(int n, int n2) {
        assert (n2 >= 0);
        if (n2 >= this.m_additionalColumnsCount_) {
            return 0;
        }
        return this.m_additionalVectors_[this.m_additionalTrie_.get(n) + n2];
    }

    public VersionInfo getAge(int n) {
        int n2 = this.getAdditional(n, 0) >> 24;
        return VersionInfo.getInstance(n2 >> 4 & 0xF, n2 & 0xF, 0, 0);
    }

    private static final boolean isgraphPOSIX(int n) {
        return (UCharacterProperty.getMask(UCharacter.getType(n)) & (GC_CC_MASK | GC_CS_MASK | GC_CN_MASK | GC_Z_MASK)) == 0;
    }

    public boolean hasBinaryProperty(int n, int n2) {
        if (n2 < 0 || 57 <= n2) {
            return false;
        }
        return this.binProps[n2].contains(n);
    }

    public int getType(int n) {
        return this.getProperty(n) & 0x1F;
    }

    public int getIntPropertyValue(int n, int n2) {
        if (n2 < 4096) {
            if (0 <= n2 && n2 < 57) {
                return this.binProps[n2].contains(n) ? 1 : 0;
            }
        } else {
            if (n2 < 4117) {
                return this.intProps[n2 - 4096].getValue(n);
            }
            if (n2 == 8192) {
                return UCharacterProperty.getMask(this.getType(n));
            }
        }
        return 0;
    }

    public int getIntPropertyMaxValue(int n) {
        if (n < 4096) {
            if (0 <= n && n < 57) {
                return 1;
            }
        } else if (n < 4117) {
            return this.intProps[n - 4096].getMaxValue(n);
        }
        return -1;
    }

    public final int getSource(int n) {
        if (n < 0) {
            return 0;
        }
        if (n < 57) {
            return this.binProps[n].getSource();
        }
        if (n < 4096) {
            return 0;
        }
        if (n < 4117) {
            return this.intProps[n - 4096].getSource();
        }
        if (n < 16384) {
            switch (n) {
                case 8192: 
                case 12288: {
                    return 1;
                }
            }
            return 0;
        }
        if (n < 16397) {
            switch (n) {
                case 16384: {
                    return 2;
                }
                case 16385: {
                    return 5;
                }
                case 16386: 
                case 16388: 
                case 16390: 
                case 16391: 
                case 16392: 
                case 16393: 
                case 16394: 
                case 16396: {
                    return 4;
                }
                case 16387: 
                case 16389: 
                case 16395: {
                    return 3;
                }
            }
            return 0;
        }
        switch (n) {
            case 28672: {
                return 2;
            }
        }
        return 0;
    }

    public static int getRawSupplementary(char c, char c2) {
        return (c << 10) + c2 + -56613888;
    }

    public int getMaxValues(int n) {
        switch (n) {
            case 0: {
                return this.m_maxBlockScriptValue_;
            }
            case 2: {
                return this.m_maxJTGValue_;
            }
        }
        return 0;
    }

    public static final int getMask(int n) {
        return 1 << n;
    }

    public static int getEuropeanDigit(int n) {
        if (n > 122 && n < 65313 || n < 65 || n > 90 && n < 97 || n > 65370 || n > 65338 && n < 65345) {
            return -1;
        }
        if (n <= 122) {
            return n + 10 - (n <= 90 ? 65 : 97);
        }
        if (n <= 65338) {
            return n + 10 - 65313;
        }
        return n + 10 - 65345;
    }

    public int digit(int n) {
        int n2 = UCharacterProperty.getNumericTypeValue(this.getProperty(n)) - 1;
        if (n2 <= 9) {
            return n2;
        }
        return -1;
    }

    public int getNumericValue(int n) {
        int n2 = UCharacterProperty.getNumericTypeValue(this.getProperty(n));
        if (n2 == 0) {
            return UCharacterProperty.getEuropeanDigit(n);
        }
        if (n2 < 11) {
            return n2 - 1;
        }
        if (n2 < 21) {
            return n2 - 11;
        }
        if (n2 < 176) {
            return n2 - 21;
        }
        if (n2 < 480) {
            return -2;
        }
        if (n2 < 768) {
            int n3 = (n2 >> 5) - 14;
            int n4 = (n2 & 0x1F) + 2;
            if (n4 < 9 || n4 == 9 && n3 <= 2) {
                int n5 = n3;
                do {
                    n5 *= 10;
                } while (--n4 > 0);
                return n5;
            }
            return -2;
        }
        if (n2 < 804) {
            int n6 = (n2 >> 2) - 191;
            int n7 = (n2 & 3) + 1;
            switch (n7) {
                case 4: {
                    n6 *= 12960000;
                    break;
                }
                case 3: {
                    n6 *= 216000;
                    break;
                }
                case 2: {
                    n6 *= 3600;
                    break;
                }
                case 1: {
                    n6 *= 60;
                    break;
                }
            }
            return n6;
        }
        return -2;
    }

    public double getUnicodeNumericValue(int n) {
        int n2 = UCharacterProperty.getNumericTypeValue(this.getProperty(n));
        if (n2 == 0) {
            return -1.23456789E8;
        }
        if (n2 < 11) {
            return n2 - 1;
        }
        if (n2 < 21) {
            return n2 - 11;
        }
        if (n2 < 176) {
            return n2 - 21;
        }
        if (n2 < 480) {
            int n3 = (n2 >> 4) - 12;
            int n4 = (n2 & 0xF) + 1;
            return (double)n3 / (double)n4;
        }
        if (n2 < 768) {
            int n5;
            int n6 = (n2 >> 5) - 14;
            double d = n6;
            for (n5 = (n2 & 0x1F) + 2; n5 >= 4; n5 -= 4) {
                d *= 10000.0;
            }
            switch (n5) {
                case 3: {
                    d *= 1000.0;
                    break;
                }
                case 2: {
                    d *= 100.0;
                    break;
                }
                case 1: {
                    d *= 10.0;
                    break;
                }
            }
            return d;
        }
        if (n2 < 804) {
            int n7 = (n2 >> 2) - 191;
            int n8 = (n2 & 3) + 1;
            switch (n8) {
                case 4: {
                    n7 *= 12960000;
                    break;
                }
                case 3: {
                    n7 *= 216000;
                    break;
                }
                case 2: {
                    n7 *= 3600;
                    break;
                }
                case 1: {
                    n7 *= 60;
                    break;
                }
            }
            return n7;
        }
        return -1.23456789E8;
    }

    private static final int getNumericTypeValue(int n) {
        return n >> 6;
    }

    private static final int ntvGetType(int n) {
        return n == 0 ? 0 : (n < 11 ? 1 : (n < 21 ? 2 : 3));
    }

    private UCharacterProperty() throws IOException {
        int n;
        int n2;
        if (this.binProps.length != 57) {
            throw new RuntimeException("binProps.length!=UProperty.BINARY_LIMIT");
        }
        if (this.intProps.length != 21) {
            throw new RuntimeException("intProps.length!=(UProperty.INT_LIMIT-UProperty.INT_START)");
        }
        InputStream inputStream2 = ICUData.getRequiredStream(DATA_FILE_NAME_);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream2, 25000);
        this.m_unicodeVersion_ = ICUBinary.readHeaderAndDataVersion(bufferedInputStream, DATA_FORMAT, new IsAcceptable());
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        int n3 = dataInputStream.readInt();
        dataInputStream.readInt();
        dataInputStream.readInt();
        int n4 = dataInputStream.readInt();
        int n5 = dataInputStream.readInt();
        this.m_additionalColumnsCount_ = dataInputStream.readInt();
        int n6 = dataInputStream.readInt();
        int n7 = dataInputStream.readInt();
        dataInputStream.readInt();
        dataInputStream.readInt();
        this.m_maxBlockScriptValue_ = dataInputStream.readInt();
        this.m_maxJTGValue_ = dataInputStream.readInt();
        dataInputStream.skipBytes(16);
        this.m_trie_ = Trie2_16.createFromSerialized(dataInputStream);
        int n8 = (n3 - 16) * 4;
        int n9 = this.m_trie_.getSerializedLength();
        if (n9 > n8) {
            throw new IOException("uprops.icu: not enough bytes for main trie");
        }
        dataInputStream.skipBytes(n8 - n9);
        dataInputStream.skipBytes((n4 - n3) * 4);
        if (this.m_additionalColumnsCount_ > 0) {
            this.m_additionalTrie_ = Trie2_16.createFromSerialized(dataInputStream);
            n8 = (n5 - n4) * 4;
            n9 = this.m_additionalTrie_.getSerializedLength();
            if (n9 > n8) {
                throw new IOException("uprops.icu: not enough bytes for additional-properties trie");
            }
            dataInputStream.skipBytes(n8 - n9);
            n2 = n6 - n5;
            this.m_additionalVectors_ = new int[n2];
            for (n = 0; n < n2; ++n) {
                this.m_additionalVectors_[n] = dataInputStream.readInt();
            }
        }
        if ((n2 = (n7 - n6) * 2) > 0) {
            this.m_scriptExtensions_ = new char[n2];
            for (n = 0; n < n2; ++n) {
                this.m_scriptExtensions_[n] = dataInputStream.readChar();
            }
        }
        inputStream2.close();
    }

    public UnicodeSet addPropertyStarts(UnicodeSet unicodeSet) {
        for (Trie2.Range range : this.m_trie_) {
            if (range.leadSurrogate) break;
            unicodeSet.add(range.startCodePoint);
        }
        unicodeSet.add(9);
        unicodeSet.add(10);
        unicodeSet.add(14);
        unicodeSet.add(28);
        unicodeSet.add(32);
        unicodeSet.add(133);
        unicodeSet.add(134);
        unicodeSet.add(127);
        unicodeSet.add(8202);
        unicodeSet.add(8208);
        unicodeSet.add(8298);
        unicodeSet.add(8304);
        unicodeSet.add(65279);
        unicodeSet.add(65280);
        unicodeSet.add(160);
        unicodeSet.add(161);
        unicodeSet.add(8199);
        unicodeSet.add(8200);
        unicodeSet.add(8239);
        unicodeSet.add(8240);
        unicodeSet.add(12295);
        unicodeSet.add(12296);
        unicodeSet.add(19968);
        unicodeSet.add(19969);
        unicodeSet.add(20108);
        unicodeSet.add(20109);
        unicodeSet.add(19977);
        unicodeSet.add(19978);
        unicodeSet.add(22235);
        unicodeSet.add(22236);
        unicodeSet.add(20116);
        unicodeSet.add(20117);
        unicodeSet.add(20845);
        unicodeSet.add(20846);
        unicodeSet.add(19971);
        unicodeSet.add(19972);
        unicodeSet.add(20843);
        unicodeSet.add(20844);
        unicodeSet.add(20061);
        unicodeSet.add(20062);
        unicodeSet.add(97);
        unicodeSet.add(123);
        unicodeSet.add(65);
        unicodeSet.add(91);
        unicodeSet.add(65345);
        unicodeSet.add(65371);
        unicodeSet.add(65313);
        unicodeSet.add(65339);
        unicodeSet.add(103);
        unicodeSet.add(71);
        unicodeSet.add(65351);
        unicodeSet.add(65319);
        unicodeSet.add(8288);
        unicodeSet.add(65520);
        unicodeSet.add(65532);
        unicodeSet.add(917504);
        unicodeSet.add(921600);
        unicodeSet.add(847);
        unicodeSet.add(848);
        return unicodeSet;
    }

    public void upropsvec_addPropertyStarts(UnicodeSet unicodeSet) {
        if (this.m_additionalColumnsCount_ > 0) {
            for (Trie2.Range range : this.m_additionalTrie_) {
                if (range.leadSurrogate) break;
                unicodeSet.add(range.startCodePoint);
            }
        }
    }

    static {
        GC_CN_MASK = UCharacterProperty.getMask(0);
        GC_CC_MASK = UCharacterProperty.getMask(15);
        GC_CS_MASK = UCharacterProperty.getMask(18);
        GC_ZS_MASK = UCharacterProperty.getMask(12);
        GC_ZL_MASK = UCharacterProperty.getMask(13);
        GC_ZP_MASK = UCharacterProperty.getMask(14);
        GC_Z_MASK = GC_ZS_MASK | GC_ZL_MASK | GC_ZP_MASK;
        gcbToHst = new int[]{0, 0, 0, 0, 1, 0, 4, 5, 3, 2};
        DATA_FORMAT = new byte[]{85, 80, 114, 111};
        try {
            INSTANCE = new UCharacterProperty();
        }
        catch (IOException iOException) {
            throw new MissingResourceException(iOException.getMessage(), "", "");
        }
    }

    private static final class IsAcceptable
    implements ICUBinary.Authenticate {
        private IsAcceptable() {
        }

        public boolean isDataVersionAcceptable(byte[] byArray) {
            return byArray[0] == 7;
        }
    }

    private class NormQuickCheckIntProperty
    extends IntProperty {
        int which;
        int max;

        NormQuickCheckIntProperty(int n, int n2, int n3) {
            super(n);
            this.which = n2;
            this.max = n3;
        }

        int getValue(int n) {
            return Norm2AllModes.getN2WithImpl(this.which - 4108).getQuickCheck(n);
        }

        int getMaxValue(int n) {
            return this.max;
        }
    }

    private class CombiningClassIntProperty
    extends IntProperty {
        CombiningClassIntProperty(int n) {
            super(n);
        }

        int getMaxValue(int n) {
            return 255;
        }
    }

    private class BiDiIntProperty
    extends IntProperty {
        BiDiIntProperty() {
            super(5);
        }

        int getMaxValue(int n) {
            return UBiDiProps.INSTANCE.getMaxValue(n);
        }
    }

    private class IntProperty {
        int column;
        int mask;
        int shift;

        IntProperty(int n, int n2, int n3) {
            this.column = n;
            this.mask = n2;
            this.shift = n3;
        }

        IntProperty(int n) {
            this.column = n;
            this.mask = 0;
        }

        final int getSource() {
            return this.mask == 0 ? this.column : 2;
        }

        int getValue(int n) {
            return (UCharacterProperty.this.getAdditional(n, this.column) & this.mask) >>> this.shift;
        }

        int getMaxValue(int n) {
            return (UCharacterProperty.this.getMaxValues(this.column) & this.mask) >>> this.shift;
        }
    }

    private class NormInertBinaryProperty
    extends BinaryProperty {
        int which;

        NormInertBinaryProperty(int n, int n2) {
            super(n);
            this.which = n2;
        }

        boolean contains(int n) {
            return Norm2AllModes.getN2WithImpl(this.which - 37).isInert(n);
        }
    }

    private class CaseBinaryProperty
    extends BinaryProperty {
        int which;

        CaseBinaryProperty(int n) {
            super(4);
            this.which = n;
        }

        boolean contains(int n) {
            return UCaseProps.INSTANCE.hasBinaryProperty(n, this.which);
        }
    }

    private class BinaryProperty {
        int column;
        int mask;

        BinaryProperty(int n, int n2) {
            this.column = n;
            this.mask = n2;
        }

        BinaryProperty(int n) {
            this.column = n;
            this.mask = 0;
        }

        final int getSource() {
            return this.mask == 0 ? this.column : 2;
        }

        boolean contains(int n) {
            return (UCharacterProperty.this.getAdditional(n, this.column) & this.mask) != 0;
        }
    }
}

