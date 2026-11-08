/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.Trie2;
import com.ibm.icu.impl.Trie2Writable;
import com.ibm.icu.impl.Trie2_16;
import com.ibm.icu.impl.Trie2_32;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.VersionInfo;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Normalizer2Impl {
    private static final IsAcceptable IS_ACCEPTABLE = new IsAcceptable();
    private static final byte[] DATA_FORMAT = new byte[]{78, 114, 109, 50};
    private static final Trie2.ValueMapper segmentStarterMapper = new Trie2.ValueMapper(){

        public int map(int n) {
            return n & Integer.MIN_VALUE;
        }
    };
    public static final int MIN_CCC_LCCC_CP = 768;
    public static final int MIN_YES_YES_WITH_CC = 65281;
    public static final int JAMO_VT = 65280;
    public static final int MIN_NORMAL_MAYBE_YES = 65024;
    public static final int JAMO_L = 1;
    public static final int MAX_DELTA = 64;
    public static final int IX_NORM_TRIE_OFFSET = 0;
    public static final int IX_EXTRA_DATA_OFFSET = 1;
    public static final int IX_SMALL_FCD_OFFSET = 2;
    public static final int IX_RESERVED3_OFFSET = 3;
    public static final int IX_TOTAL_SIZE = 7;
    public static final int IX_MIN_DECOMP_NO_CP = 8;
    public static final int IX_MIN_COMP_NO_MAYBE_CP = 9;
    public static final int IX_MIN_YES_NO = 10;
    public static final int IX_MIN_NO_NO = 11;
    public static final int IX_LIMIT_NO_NO = 12;
    public static final int IX_MIN_MAYBE_YES = 13;
    public static final int IX_MIN_YES_NO_MAPPINGS_ONLY = 14;
    public static final int IX_COUNT = 16;
    public static final int MAPPING_HAS_CCC_LCCC_WORD = 128;
    public static final int MAPPING_HAS_RAW_MAPPING = 64;
    public static final int MAPPING_NO_COMP_BOUNDARY_AFTER = 32;
    public static final int MAPPING_LENGTH_MASK = 31;
    public static final int COMP_1_LAST_TUPLE = 32768;
    public static final int COMP_1_TRIPLE = 1;
    public static final int COMP_1_TRAIL_LIMIT = 13312;
    public static final int COMP_1_TRAIL_MASK = 32766;
    public static final int COMP_1_TRAIL_SHIFT = 9;
    public static final int COMP_2_TRAIL_SHIFT = 6;
    public static final int COMP_2_TRAIL_MASK = 65472;
    private VersionInfo dataVersion;
    private int minDecompNoCP;
    private int minCompNoMaybeCP;
    private int minYesNo;
    private int minYesNoMappingsOnly;
    private int minNoNo;
    private int limitNoNo;
    private int minMaybeYes;
    private Trie2_16 normTrie;
    private String maybeYesCompositions;
    private String extraData;
    private byte[] smallFCD;
    private int[] tccc180;
    private Trie2_32 canonIterData;
    private ArrayList<UnicodeSet> canonStartSets;
    private static final int CANON_NOT_SEGMENT_STARTER = Integer.MIN_VALUE;
    private static final int CANON_HAS_COMPOSITIONS = 0x40000000;
    private static final int CANON_HAS_SET = 0x200000;
    private static final int CANON_VALUE_MASK = 0x1FFFFF;

    public Normalizer2Impl load(InputStream inputStream2) {
        try {
            int n;
            int n2;
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream2);
            this.dataVersion = ICUBinary.readHeaderAndDataVersion(bufferedInputStream, DATA_FORMAT, IS_ACCEPTABLE);
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
            int n3 = dataInputStream.readInt() / 4;
            if (n3 <= 13) {
                throw new IOException("Normalizer2 data: not enough indexes");
            }
            int[] nArray = new int[n3];
            nArray[0] = n3 * 4;
            for (n2 = 1; n2 < n3; ++n2) {
                nArray[n2] = dataInputStream.readInt();
            }
            this.minDecompNoCP = nArray[8];
            this.minCompNoMaybeCP = nArray[9];
            this.minYesNo = nArray[10];
            this.minYesNoMappingsOnly = nArray[14];
            this.minNoNo = nArray[11];
            this.limitNoNo = nArray[12];
            this.minMaybeYes = nArray[13];
            n2 = nArray[0];
            int n4 = nArray[1];
            this.normTrie = Trie2_16.createFromSerialized(dataInputStream);
            int n5 = this.normTrie.getSerializedLength();
            if (n5 > n4 - n2) {
                throw new IOException("Normalizer2 data: not enough bytes for normTrie");
            }
            dataInputStream.skipBytes(n4 - n2 - n5);
            n2 = n4;
            n4 = nArray[2];
            int n6 = (n4 - n2) / 2;
            if (n6 != 0) {
                char[] cArray = new char[n6];
                for (n = 0; n < n6; ++n) {
                    cArray[n] = dataInputStream.readChar();
                }
                this.maybeYesCompositions = new String(cArray);
                this.extraData = this.maybeYesCompositions.substring(65024 - this.minMaybeYes);
            }
            n2 = n4;
            this.smallFCD = new byte[256];
            for (n = 0; n < 256; ++n) {
                this.smallFCD[n] = dataInputStream.readByte();
            }
            this.tccc180 = new int[384];
            n = 0;
            int n7 = 0;
            while (n7 < 384) {
                if ((n7 & 0xFF) == 0) {
                    n = this.smallFCD[n7 >> 8];
                }
                if ((n & 1) != 0) {
                    int n8 = 0;
                    while (n8 < 32) {
                        this.tccc180[n7] = this.getFCD16FromNormData(n7) & 0xFF;
                        ++n8;
                        ++n7;
                    }
                } else {
                    n7 += 32;
                }
                n >>= 1;
            }
            inputStream2.close();
            return this;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    public Normalizer2Impl load(String string) {
        return this.load(ICUData.getRequiredStream(string));
    }

    public void addPropertyStarts(UnicodeSet unicodeSet) {
        for (Trie2.Range range : this.normTrie) {
            if (range.leadSurrogate) break;
            unicodeSet.add(range.startCodePoint);
        }
        for (int i = 44032; i < 55204; i += 28) {
            unicodeSet.add(i);
            unicodeSet.add(i + 1);
        }
        unicodeSet.add(55204);
    }

    public void addCanonIterPropertyStarts(UnicodeSet unicodeSet) {
        this.ensureCanonIterData();
        Iterator<Trie2.Range> iterator2 = this.canonIterData.iterator(segmentStarterMapper);
        while (iterator2.hasNext()) {
            Trie2.Range range = iterator2.next();
            if (range.leadSurrogate) break;
            unicodeSet.add(range.startCodePoint);
        }
    }

    public Trie2_16 getNormTrie() {
        return this.normTrie;
    }

    public synchronized Normalizer2Impl ensureCanonIterData() {
        if (this.canonIterData == null) {
            Trie2Writable trie2Writable = new Trie2Writable(0, 0);
            this.canonStartSets = new ArrayList();
            for (Trie2.Range range : this.normTrie) {
                if (range.leadSurrogate) break;
                int n = range.value;
                if (n == 0 || this.minYesNo <= n && n < this.minNoNo) continue;
                for (int i = range.startCodePoint; i <= range.endCodePoint; ++i) {
                    int n2;
                    int n3 = n2 = trie2Writable.get(i);
                    if (n >= this.minMaybeYes) {
                        n3 |= Integer.MIN_VALUE;
                        if (n < 65024) {
                            n3 |= 0x40000000;
                        }
                    } else if (n < this.minYesNo) {
                        n3 |= 0x40000000;
                    } else {
                        int n4 = i;
                        int n5 = n;
                        while (this.limitNoNo <= n5 && n5 < this.minMaybeYes) {
                            n4 = this.mapAlgorithmic(n4, n5);
                            n5 = this.getNorm16(n4);
                        }
                        if (this.minYesNo <= n5 && n5 < this.limitNoNo) {
                            char c = this.extraData.charAt(n5);
                            int n6 = c & 0x1F;
                            if ((c & 0x80) != 0 && i == n4 && (this.extraData.charAt(n5 - 1) & 0xFF) != 0) {
                                n3 |= Integer.MIN_VALUE;
                            }
                            if (n6 != 0) {
                                int n7 = ++n5 + n6;
                                n4 = this.extraData.codePointAt(n5);
                                this.addToStartSet(trie2Writable, i, n4);
                                if (n5 >= this.minNoNo) {
                                    while ((n5 += Character.charCount(n4)) < n7) {
                                        n4 = this.extraData.codePointAt(n5);
                                        int n8 = trie2Writable.get(n4);
                                        if ((n8 & Integer.MIN_VALUE) != 0) continue;
                                        trie2Writable.set(n4, n8 | Integer.MIN_VALUE);
                                    }
                                }
                            }
                        } else {
                            this.addToStartSet(trie2Writable, i, n4);
                        }
                    }
                    if (n3 == n2) continue;
                    trie2Writable.set(i, n3);
                }
            }
            this.canonIterData = trie2Writable.toTrie2_32();
        }
        return this;
    }

    public int getNorm16(int n) {
        return this.normTrie.get(n);
    }

    public int getCompQuickCheck(int n) {
        if (n < this.minNoNo || 65281 <= n) {
            return 1;
        }
        if (this.minMaybeYes <= n) {
            return 2;
        }
        return 0;
    }

    public boolean isCompNo(int n) {
        return this.minNoNo <= n && n < this.minMaybeYes;
    }

    public boolean isDecompYes(int n) {
        return n < this.minYesNo || this.minMaybeYes <= n;
    }

    public int getCC(int n) {
        if (n >= 65024) {
            return n & 0xFF;
        }
        if (n < this.minNoNo || this.limitNoNo <= n) {
            return 0;
        }
        return this.getCCFromNoNo(n);
    }

    public static int getCCFromYesOrMaybe(int n) {
        return n >= 65024 ? n & 0xFF : 0;
    }

    public int getFCD16(int n) {
        if (n < 0) {
            return 0;
        }
        if (n < 384) {
            return this.tccc180[n];
        }
        if (n <= 65535 && !this.singleLeadMightHaveNonZeroFCD16(n)) {
            return 0;
        }
        return this.getFCD16FromNormData(n);
    }

    public int getFCD16FromBelow180(int n) {
        return this.tccc180[n];
    }

    public boolean singleLeadMightHaveNonZeroFCD16(int n) {
        byte by = this.smallFCD[n >> 8];
        if (by == 0) {
            return false;
        }
        return (by >> (n >> 5 & 7) & 1) != 0;
    }

    public int getFCD16FromNormData(int n) {
        int n2;
        while (true) {
            if ((n2 = this.getNorm16(n)) <= this.minYesNo) {
                return 0;
            }
            if (n2 >= 65024) {
                return (n2 &= 0xFF) | n2 << 8;
            }
            if (n2 >= this.minMaybeYes) {
                return 0;
            }
            if (!this.isDecompNoAlgorithmic(n2)) break;
            n = this.mapAlgorithmic(n, n2);
        }
        char c = this.extraData.charAt(n2);
        if ((c & 0x1F) == 0) {
            return 511;
        }
        int n3 = c >> 8;
        if ((c & 0x80) != 0) {
            n3 |= this.extraData.charAt(n2 - 1) & 0xFF00;
        }
        return n3;
    }

    public String getDecomposition(int n) {
        int n2;
        int n3 = -1;
        while (n >= this.minDecompNoCP && !this.isDecompYes(n2 = this.getNorm16(n))) {
            if (this.isHangul(n2)) {
                StringBuilder stringBuilder = new StringBuilder();
                Hangul.decompose(n, stringBuilder);
                return stringBuilder.toString();
            }
            if (this.isDecompNoAlgorithmic(n2)) {
                n3 = n = this.mapAlgorithmic(n, n2);
                continue;
            }
            int n4 = this.extraData.charAt(n2++) & 0x1F;
            return this.extraData.substring(n2, n2 + n4);
        }
        if (n3 < 0) {
            return null;
        }
        return UTF16.valueOf(n3);
    }

    public String getRawDecomposition(int n) {
        int n2;
        if (n < this.minDecompNoCP || this.isDecompYes(n2 = this.getNorm16(n))) {
            return null;
        }
        if (this.isHangul(n2)) {
            StringBuilder stringBuilder = new StringBuilder();
            Hangul.getRawDecomposition(n, stringBuilder);
            return stringBuilder.toString();
        }
        if (this.isDecompNoAlgorithmic(n2)) {
            return UTF16.valueOf(this.mapAlgorithmic(n, n2));
        }
        char c = this.extraData.charAt(n2);
        int n3 = c & 0x1F;
        if ((c & 0x40) != 0) {
            int n4 = n2 - (c >> 7 & 1) - 1;
            char c2 = this.extraData.charAt(n4);
            if (c2 <= '\u001f') {
                return this.extraData.substring(n4 - c2, n4);
            }
            StringBuilder stringBuilder = new StringBuilder(n3 - 1).append(c2);
            return stringBuilder.append(this.extraData, n2 += 3, n2 + n3 - 2).toString();
        }
        return this.extraData.substring(++n2, n2 + n3);
    }

    public boolean isCanonSegmentStarter(int n) {
        return this.canonIterData.get(n) >= 0;
    }

    public boolean getCanonStartSet(int n, UnicodeSet unicodeSet) {
        int n2 = this.canonIterData.get(n) & Integer.MAX_VALUE;
        if (n2 == 0) {
            return false;
        }
        unicodeSet.clear();
        int n3 = n2 & 0x1FFFFF;
        if ((n2 & 0x200000) != 0) {
            unicodeSet.addAll(this.canonStartSets.get(n3));
        } else if (n3 != 0) {
            unicodeSet.add(n3);
        }
        if ((n2 & 0x40000000) != 0) {
            int n4 = this.getNorm16(n);
            if (n4 == 1) {
                int n5 = 44032 + (n - 4352) * 588;
                unicodeSet.add(n5, n5 + 588 - 1);
            } else {
                this.addComposites(this.getCompositionsList(n4), unicodeSet);
            }
        }
        return true;
    }

    public int decompose(CharSequence charSequence, int n, int n2, ReorderingBuffer reorderingBuffer) {
        block13: {
            int n3 = this.minDecompNoCP;
            int n4 = 0;
            int n5 = 0;
            int n6 = n;
            char c = '\u0000';
            while (true) {
                char c2;
                int n7 = n;
                while (n != n2) {
                    n4 = charSequence.charAt(n);
                    if (n4 < n3 || this.isMostDecompYesAndZeroCC(n5 = this.normTrie.getFromU16SingleLead((char)n4))) {
                        ++n;
                        continue;
                    }
                    if (!UTF16.isSurrogate((char)n4)) break;
                    if (UTF16Plus.isSurrogateLead(n4)) {
                        if (n + 1 != n2) {
                            char c3 = charSequence.charAt(n + 1);
                            c2 = c3;
                            if (Character.isLowSurrogate(c3)) {
                                n4 = Character.toCodePoint((char)n4, c2);
                            }
                        }
                    } else if (n7 < n) {
                        char c4 = charSequence.charAt(n - 1);
                        c2 = c4;
                        if (Character.isHighSurrogate(c4)) {
                            --n;
                            n4 = Character.toCodePoint(c2, (char)n4);
                        }
                    }
                    if (!this.isMostDecompYesAndZeroCC(n5 = this.getNorm16(n4))) break;
                    n += Character.charCount(n4);
                }
                if (n != n7) {
                    if (reorderingBuffer != null) {
                        reorderingBuffer.flushAndAppendZeroCC(charSequence, n7, n);
                    } else {
                        c = '\u0000';
                        n6 = n;
                    }
                }
                if (n == n2) break block13;
                n += Character.charCount(n4);
                if (reorderingBuffer != null) {
                    this.decompose(n4, n5, reorderingBuffer);
                    continue;
                }
                if (!this.isDecompYes(n5) || c > (c2 = Normalizer2Impl.getCCFromYesOrMaybe(n5)) && c2 != '\u0000') break;
                c = c2;
                if (c2 > '\u0001') continue;
                n6 = n;
            }
            return n6;
        }
        return n;
    }

    public void decomposeAndAppend(CharSequence charSequence, boolean bl, ReorderingBuffer reorderingBuffer) {
        int n;
        int n2 = charSequence.length();
        if (n2 == 0) {
            return;
        }
        if (bl) {
            this.decompose(charSequence, 0, n2, reorderingBuffer);
            return;
        }
        int n3 = Character.codePointAt(charSequence, 0);
        int n4 = 0;
        int n5 = n = this.getCC(this.getNorm16(n3));
        int n6 = n;
        while (n != 0) {
            n5 = n;
            if ((n4 += Character.charCount(n3)) >= n2) break;
            n3 = Character.codePointAt(charSequence, n4);
            n = this.getCC(this.getNorm16(n3));
        }
        reorderingBuffer.append(charSequence, 0, n4, n6, n5);
        reorderingBuffer.append(charSequence, n4, n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean compose(CharSequence charSequence, int n, int n2, boolean bl, boolean bl2, ReorderingBuffer reorderingBuffer) {
        int n3 = this.minCompNoMaybeCP;
        int n4 = n;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        while (true) {
            int n8;
            int n9;
            block35: {
                n9 = n;
                while (n != n2) {
                    block37: {
                        block36: {
                            n5 = charSequence.charAt(n);
                            if (n5 < n3 || this.isCompYesAndZeroCC(n6 = this.normTrie.getFromU16SingleLead((char)n5))) {
                                ++n;
                                continue;
                            }
                            if (!UTF16.isSurrogate((char)n5)) break;
                            if (!UTF16Plus.isSurrogateLead(n5)) break block36;
                            if (n + 1 != n2) {
                                char c = charSequence.charAt(n + 1);
                                n8 = c;
                                if (Character.isLowSurrogate(c)) {
                                    n5 = Character.toCodePoint((char)n5, (char)n8);
                                }
                            }
                            break block37;
                        }
                        if (n9 < n) {
                            char c = charSequence.charAt(n - 1);
                            n8 = c;
                            if (Character.isHighSurrogate(c)) {
                                --n;
                                n5 = Character.toCodePoint((char)n8, (char)n5);
                            }
                        }
                    }
                    if (!this.isCompYesAndZeroCC(n6 = this.getNorm16(n5))) break;
                    n += Character.charCount(n5);
                }
                if (n != n9) {
                    if (n == n2) {
                        if (!bl2) return true;
                        reorderingBuffer.flushAndAppendZeroCC(charSequence, n9, n);
                        return true;
                    }
                    n4 = n - 1;
                    if (Character.isLowSurrogate(charSequence.charAt(n4)) && n9 < n4 && Character.isHighSurrogate(charSequence.charAt(n4 - 1))) {
                        --n4;
                    }
                    if (bl2) {
                        reorderingBuffer.flushAndAppendZeroCC(charSequence, n9, n4);
                        reorderingBuffer.append(charSequence, n4, n);
                    } else {
                        n7 = 0;
                    }
                    n9 = n;
                } else if (n == n2) {
                    return true;
                }
                n += Character.charCount(n5);
                if (Normalizer2Impl.isJamoVT(n6) && n4 != n9) {
                    n8 = charSequence.charAt(n9 - 1);
                    boolean bl3 = false;
                    if (n5 < 4519) {
                        if ((n8 = (int)((char)(n8 - 4352))) < 19) {
                            char c;
                            if (!bl2) {
                                return false;
                            }
                            char c2 = (char)(44032 + (n8 * 21 + (n5 - 4449)) * 28);
                            if (n != n2 && (c = (char)(charSequence.charAt(n) - 4519)) < '\u001c') {
                                c2 = (char)(c2 + c);
                                n4 = ++n;
                                reorderingBuffer.setLastChar(c2);
                                continue;
                            }
                            bl3 = true;
                        }
                    } else if (Hangul.isHangulWithoutJamoT((char)n8)) {
                        if (!bl2) {
                            return false;
                        }
                        reorderingBuffer.setLastChar((char)(n8 + n5 - 4519));
                        n4 = n;
                        continue;
                    }
                    if (!bl3) {
                        if (bl2) {
                            reorderingBuffer.append((char)n5);
                            continue;
                        }
                        n7 = 0;
                        continue;
                    }
                }
                if (n6 >= 65281) {
                    n8 = n6 & 0xFF;
                    if (bl && (bl2 ? reorderingBuffer.getLastCC() : n7) == 0 && n4 < n9 && this.getTrailCCFromCompYesAndZeroCC(charSequence, n4, n9) > n8) {
                        if (!bl2) {
                            return false;
                        }
                        break block35;
                    } else {
                        if (bl2) {
                            reorderingBuffer.append(n5, n8);
                            continue;
                        }
                        if (n7 > n8) return false;
                        n7 = n8;
                        continue;
                    }
                }
                if (!bl2 && !this.isMaybeOrNonZeroCC(n6)) {
                    return false;
                }
            }
            if (this.hasCompBoundaryBefore(n5, n6)) {
                n4 = n9;
            } else if (bl2) {
                reorderingBuffer.removeSuffix(n9 - n4);
            }
            n = this.findNextCompBoundary(charSequence, n, n2);
            n8 = reorderingBuffer.length();
            this.decomposeShort(charSequence, n4, n, reorderingBuffer);
            this.recompose(reorderingBuffer, n8, bl);
            if (!bl2) {
                if (!reorderingBuffer.equals(charSequence, n4, n)) {
                    return false;
                }
                reorderingBuffer.remove();
                n7 = 0;
            }
            n4 = n;
        }
    }

    public int composeQuickCheck(CharSequence charSequence, int n, int n2, boolean bl, boolean bl2) {
        int n3;
        block10: {
            int n4 = 0;
            int n5 = this.minCompNoMaybeCP;
            n3 = n;
            int n6 = 0;
            int n7 = 0;
            char c = '\u0000';
            while (true) {
                char c2;
                int n8 = n;
                while (true) {
                    if (n == n2) {
                        return n << 1 | n4;
                    }
                    n6 = charSequence.charAt(n);
                    if (n6 < n5 || this.isCompYesAndZeroCC(n7 = this.normTrie.getFromU16SingleLead((char)n6))) {
                        ++n;
                        continue;
                    }
                    if (!UTF16.isSurrogate((char)n6)) break;
                    if (UTF16Plus.isSurrogateLead(n6)) {
                        if (n + 1 != n2 && Character.isLowSurrogate(c2 = charSequence.charAt(n + 1))) {
                            n6 = Character.toCodePoint((char)n6, c2);
                        }
                    } else if (n8 < n && Character.isHighSurrogate(c2 = charSequence.charAt(n - 1))) {
                        --n;
                        n6 = Character.toCodePoint(c2, (char)n6);
                    }
                    if (!this.isCompYesAndZeroCC(n7 = this.getNorm16(n6))) break;
                    n += Character.charCount(n6);
                }
                if (n != n8) {
                    n3 = n - 1;
                    if (Character.isLowSurrogate(charSequence.charAt(n3)) && n8 < n3 && Character.isHighSurrogate(charSequence.charAt(n3 - 1))) {
                        --n3;
                    }
                    c = '\u0000';
                    n8 = n;
                }
                n += Character.charCount(n6);
                if (!this.isMaybeOrNonZeroCC(n7)) break block10;
                c2 = Normalizer2Impl.getCCFromYesOrMaybe(n7);
                if (bl && c2 != '\u0000' && c == '\u0000' && n3 < n8 && this.getTrailCCFromCompYesAndZeroCC(charSequence, n3, n8) > c2 || c > c2 && c2 != '\u0000') break block10;
                c = c2;
                if (n7 >= 65281) continue;
                if (bl2) break;
                n4 = 1;
            }
            return n3 << 1;
        }
        return n3 << 1;
    }

    public void composeAndAppend(CharSequence charSequence, boolean bl, boolean bl2, ReorderingBuffer reorderingBuffer) {
        int n;
        int n2 = 0;
        int n3 = charSequence.length();
        if (!reorderingBuffer.isEmpty() && 0 != (n = this.findNextCompBoundary(charSequence, 0, n3))) {
            int n4 = this.findPreviousCompBoundary(reorderingBuffer.getStringBuilder(), reorderingBuffer.length());
            StringBuilder stringBuilder = new StringBuilder(reorderingBuffer.length() - n4 + n + 16);
            stringBuilder.append(reorderingBuffer.getStringBuilder(), n4, reorderingBuffer.length());
            reorderingBuffer.removeSuffix(reorderingBuffer.length() - n4);
            stringBuilder.append(charSequence, 0, n);
            this.compose(stringBuilder, 0, stringBuilder.length(), bl2, true, reorderingBuffer);
            n2 = n;
        }
        if (bl) {
            this.compose(charSequence, n2, n3, bl2, true, reorderingBuffer);
        } else {
            reorderingBuffer.append(charSequence, n2, n3);
        }
    }

    public int makeFCD(CharSequence charSequence, int n, int n2, ReorderingBuffer reorderingBuffer) {
        int n3 = n;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        while (true) {
            int n7;
            int n8 = n;
            while (n != n2) {
                n4 = charSequence.charAt(n);
                if (n4 < 768) {
                    n5 = ~n4;
                    ++n;
                    continue;
                }
                if (!this.singleLeadMightHaveNonZeroFCD16(n4)) {
                    n5 = 0;
                    ++n;
                    continue;
                }
                if (UTF16.isSurrogate((char)n4)) {
                    if (UTF16Plus.isSurrogateLead(n4)) {
                        if (n + 1 != n2) {
                            char c = charSequence.charAt(n + 1);
                            n7 = c;
                            if (Character.isLowSurrogate(c)) {
                                n4 = Character.toCodePoint((char)n4, (char)n7);
                            }
                        }
                    } else if (n8 < n) {
                        char c = charSequence.charAt(n - 1);
                        n7 = c;
                        if (Character.isHighSurrogate(c)) {
                            --n;
                            n4 = Character.toCodePoint((char)n7, (char)n4);
                        }
                    }
                }
                if ((n6 = this.getFCD16FromNormData(n4)) > 255) break;
                n5 = n6;
                n += Character.charCount(n4);
            }
            if (n != n8) {
                if (n == n2) {
                    if (reorderingBuffer == null) break;
                    reorderingBuffer.flushAndAppendZeroCC(charSequence, n8, n);
                    break;
                }
                n3 = n;
                if (n5 < 0) {
                    n7 = ~n5;
                    int n9 = n5 = n7 < 384 ? this.tccc180[n7] : this.getFCD16FromNormData(n7);
                    if (n5 > 1) {
                        --n3;
                    }
                } else {
                    n7 = n - 1;
                    if (Character.isLowSurrogate(charSequence.charAt(n7)) && n8 < n7 && Character.isHighSurrogate(charSequence.charAt(n7 - 1))) {
                        n5 = this.getFCD16FromNormData(Character.toCodePoint(charSequence.charAt(--n7), charSequence.charAt(n7 + '\u0001')));
                    }
                    if (n5 > 1) {
                        n3 = n7;
                    }
                }
                if (reorderingBuffer != null) {
                    reorderingBuffer.flushAndAppendZeroCC(charSequence, n8, n3);
                    reorderingBuffer.append(charSequence, n3, n);
                }
                n8 = n;
            } else if (n == n2) break;
            n += Character.charCount(n4);
            if ((n5 & 0xFF) <= n6 >> 8) {
                if ((n6 & 0xFF) <= 1) {
                    n3 = n;
                }
                if (reorderingBuffer != null) {
                    reorderingBuffer.appendZeroCC(n4);
                }
                n5 = n6;
                continue;
            }
            if (reorderingBuffer == null) {
                return n3;
            }
            reorderingBuffer.removeSuffix(n8 - n3);
            n = this.findNextFCDBoundary(charSequence, n, n2);
            this.decomposeShort(charSequence, n3, n, reorderingBuffer);
            n3 = n;
            n5 = 0;
        }
        return n;
    }

    public void makeFCDAndAppend(CharSequence charSequence, boolean bl, ReorderingBuffer reorderingBuffer) {
        int n;
        int n2 = 0;
        int n3 = charSequence.length();
        if (!reorderingBuffer.isEmpty() && 0 != (n = this.findNextFCDBoundary(charSequence, 0, n3))) {
            int n4 = this.findPreviousFCDBoundary(reorderingBuffer.getStringBuilder(), reorderingBuffer.length());
            StringBuilder stringBuilder = new StringBuilder(reorderingBuffer.length() - n4 + n + 16);
            stringBuilder.append(reorderingBuffer.getStringBuilder(), n4, reorderingBuffer.length());
            reorderingBuffer.removeSuffix(reorderingBuffer.length() - n4);
            stringBuilder.append(charSequence, 0, n);
            this.makeFCD(stringBuilder, 0, stringBuilder.length(), reorderingBuffer);
            n2 = n;
        }
        if (bl) {
            this.makeFCD(charSequence, n2, n3, reorderingBuffer);
        } else {
            reorderingBuffer.append(charSequence, n2, n3);
        }
    }

    public boolean hasDecompBoundary(int n, boolean bl) {
        int n2;
        while (true) {
            if (n < this.minDecompNoCP) {
                return true;
            }
            n2 = this.getNorm16(n);
            if (this.isHangul(n2) || this.isDecompYesAndZeroCC(n2)) {
                return true;
            }
            if (n2 > 65024) {
                return false;
            }
            if (!this.isDecompNoAlgorithmic(n2)) break;
            n = this.mapAlgorithmic(n, n2);
        }
        char c = this.extraData.charAt(n2);
        if ((c & 0x1F) == 0) {
            return false;
        }
        if (!bl) {
            if (c > '\u01ff') {
                return false;
            }
            if (c <= '\u00ff') {
                return true;
            }
        }
        return (c & 0x80) == 0 || (this.extraData.charAt(n2 - 1) & 0xFF00) == 0;
    }

    public boolean isDecompInert(int n) {
        return this.isDecompYesAndZeroCC(this.getNorm16(n));
    }

    public boolean hasCompBoundaryBefore(int n) {
        return n < this.minCompNoMaybeCP || this.hasCompBoundaryBefore(n, this.getNorm16(n));
    }

    public boolean hasCompBoundaryAfter(int n, boolean bl, boolean bl2) {
        int n2;
        while (true) {
            if (Normalizer2Impl.isInert(n2 = this.getNorm16(n))) {
                return true;
            }
            if (n2 <= this.minYesNo) {
                return this.isHangul(n2) && !Hangul.isHangulWithoutJamoT((char)n);
            }
            if (n2 >= (bl2 ? this.minNoNo : this.minMaybeYes)) {
                return false;
            }
            if (!this.isDecompNoAlgorithmic(n2)) break;
            n = this.mapAlgorithmic(n, n2);
        }
        char c = this.extraData.charAt(n2);
        return (c & 0x20) == 0 && (!bl || c <= '\u01ff');
    }

    public boolean hasFCDBoundaryBefore(int n) {
        return n < 768 || this.getFCD16(n) <= 255;
    }

    public boolean hasFCDBoundaryAfter(int n) {
        int n2 = this.getFCD16(n);
        return n2 <= 1 || (n2 & 0xFF) == 0;
    }

    public boolean isFCDInert(int n) {
        return this.getFCD16(n) <= 1;
    }

    private boolean isMaybe(int n) {
        return this.minMaybeYes <= n && n <= 65280;
    }

    private boolean isMaybeOrNonZeroCC(int n) {
        return n >= this.minMaybeYes;
    }

    private static boolean isInert(int n) {
        return n == 0;
    }

    private static boolean isJamoL(int n) {
        return n == 1;
    }

    private static boolean isJamoVT(int n) {
        return n == 65280;
    }

    private boolean isHangul(int n) {
        return n == this.minYesNo;
    }

    private boolean isCompYesAndZeroCC(int n) {
        return n < this.minNoNo;
    }

    private boolean isDecompYesAndZeroCC(int n) {
        return n < this.minYesNo || n == 65280 || this.minMaybeYes <= n && n <= 65024;
    }

    private boolean isMostDecompYesAndZeroCC(int n) {
        return n < this.minYesNo || n == 65024 || n == 65280;
    }

    private boolean isDecompNoAlgorithmic(int n) {
        return n >= this.limitNoNo;
    }

    private int getCCFromNoNo(int n) {
        if ((this.extraData.charAt(n) & 0x80) != 0) {
            return this.extraData.charAt(n - 1) & 0xFF;
        }
        return 0;
    }

    int getTrailCCFromCompYesAndZeroCC(CharSequence charSequence, int n, int n2) {
        int n3 = n == n2 - 1 ? charSequence.charAt(n) : Character.codePointAt(charSequence, n);
        int n4 = this.getNorm16(n3);
        if (n4 <= this.minYesNo) {
            return 0;
        }
        return this.extraData.charAt(n4) >> 8;
    }

    private int mapAlgorithmic(int n, int n2) {
        return n + n2 - (this.minMaybeYes - 64 - 1);
    }

    private int getCompositionsListForDecompYes(int n) {
        if (n == 0 || 65024 <= n) {
            return -1;
        }
        if ((n -= this.minMaybeYes) < 0) {
            n += 65024;
        }
        return n;
    }

    private int getCompositionsListForComposite(int n) {
        char c = this.extraData.charAt(n);
        return 65024 - this.minMaybeYes + n + 1 + (c & 0x1F);
    }

    private int getCompositionsList(int n) {
        return this.isDecompYes(n) ? this.getCompositionsListForDecompYes(n) : this.getCompositionsListForComposite(n);
    }

    public void decomposeShort(CharSequence charSequence, int n, int n2, ReorderingBuffer reorderingBuffer) {
        while (n < n2) {
            int n3 = Character.codePointAt(charSequence, n);
            n += Character.charCount(n3);
            this.decompose(n3, this.getNorm16(n3), reorderingBuffer);
        }
    }

    private void decompose(int n, int n2, ReorderingBuffer reorderingBuffer) {
        block3: {
            while (true) {
                if (this.isDecompYes(n2)) {
                    reorderingBuffer.append(n, Normalizer2Impl.getCCFromYesOrMaybe(n2));
                    break block3;
                }
                if (this.isHangul(n2)) {
                    Hangul.decompose(n, reorderingBuffer);
                    break block3;
                }
                if (!this.isDecompNoAlgorithmic(n2)) break;
                n = this.mapAlgorithmic(n, n2);
                n2 = this.getNorm16(n);
            }
            char c = this.extraData.charAt(n2);
            int n3 = c & 0x1F;
            int n4 = c >> 8;
            int n5 = (c & 0x80) != 0 ? this.extraData.charAt(n2 - 1) >> 8 : 0;
            reorderingBuffer.append(this.extraData, ++n2, n2 + n3, n5, n4);
        }
    }

    private static int combine(String string, int n, int n2) {
        block9: {
            if (n2 < 13312) {
                char c;
                int n3 = n2 << 1;
                while (n3 > (c = string.charAt(n))) {
                    n += 2 + (c & '\u0001');
                }
                if (n3 == (c & 0x7FFE)) {
                    if ((c & '\u0001') != 0) {
                        return string.charAt(n + 1) << 16 | string.charAt(n + 2);
                    }
                    return string.charAt(n + 1);
                }
            } else {
                char c;
                int n4 = 13312 + (n2 >> 9 & 0xFFFFFFFE);
                int n5 = n2 << 6 & 0xFFFF;
                while (true) {
                    char c2;
                    if (n4 > (c2 = string.charAt(n))) {
                        n += 2 + (c2 & '\u0001');
                        continue;
                    }
                    if (n4 != (c2 & 0x7FFE)) break block9;
                    c = string.charAt(n + 1);
                    if (n5 <= c) break;
                    if ((c2 & 0x8000) == 0) {
                        n += 3;
                        continue;
                    }
                    break block9;
                    break;
                }
                if (n5 == (c & 0xFFC0)) {
                    return (c & 0xFFFF003F) << 16 | string.charAt(n + 2);
                }
            }
        }
        return -1;
    }

    private void addComposites(int n, UnicodeSet unicodeSet) {
        char c;
        do {
            int n2;
            if (((c = this.maybeYesCompositions.charAt(n)) & '\u0001') == 0) {
                n2 = this.maybeYesCompositions.charAt(n + 1);
                n += 2;
            } else {
                n2 = (this.maybeYesCompositions.charAt(n + 1) & 0xFFFF003F) << 16 | this.maybeYesCompositions.charAt(n + 2);
                n += 3;
            }
            int n3 = n2 >> 1;
            if ((n2 & '\u0001') != 0) {
                this.addComposites(this.getCompositionsListForComposite(this.getNorm16(n3)), unicodeSet);
            }
            unicodeSet.add(n3);
        } while ((c & 0x8000) == 0);
    }

    private void recompose(ReorderingBuffer reorderingBuffer, int n, boolean bl) {
        int n2 = n;
        StringBuilder stringBuilder = reorderingBuffer.getStringBuilder();
        if (n2 == stringBuilder.length()) {
            return;
        }
        int n3 = -1;
        int n4 = -1;
        boolean bl2 = false;
        int n5 = 0;
        while (true) {
            int n6 = stringBuilder.codePointAt(n2);
            n2 += Character.charCount(n6);
            int n7 = this.getNorm16(n6);
            int n8 = Normalizer2Impl.getCCFromYesOrMaybe(n7);
            if (this.isMaybe(n7) && n3 >= 0 && (n5 < n8 || n5 == 0)) {
                int n9;
                int n10;
                if (Normalizer2Impl.isJamoVT(n7)) {
                    if (n6 < 4519 && (n10 = (int)(stringBuilder.charAt(n4) - 4352)) < 19) {
                        char c;
                        n9 = n2 - 1;
                        char c2 = (char)(44032 + (n10 * 21 + (n6 - 4449)) * 28);
                        if (n2 != stringBuilder.length() && (c = (char)(stringBuilder.charAt(n2) - 4519)) < '\u001c') {
                            ++n2;
                            c2 = (char)(c2 + c);
                        }
                        stringBuilder.setCharAt(n4, c2);
                        stringBuilder.delete(n9, n2);
                        n2 = n9;
                    }
                    if (n2 == stringBuilder.length()) break;
                    n3 = -1;
                    continue;
                }
                int n11 = Normalizer2Impl.combine(this.maybeYesCompositions, n3, n6);
                if (n11 >= 0) {
                    n10 = n11 >> 1;
                    n9 = n2 - Character.charCount(n6);
                    stringBuilder.delete(n9, n2);
                    n2 = n9;
                    if (bl2) {
                        if (n10 > 65535) {
                            stringBuilder.setCharAt(n4, UTF16.getLeadSurrogate(n10));
                            stringBuilder.setCharAt(n4 + 1, UTF16.getTrailSurrogate(n10));
                        } else {
                            stringBuilder.setCharAt(n4, (char)n6);
                            stringBuilder.deleteCharAt(n4 + 1);
                            bl2 = false;
                            --n2;
                        }
                    } else if (n10 > 65535) {
                        bl2 = true;
                        stringBuilder.setCharAt(n4, UTF16.getLeadSurrogate(n10));
                        stringBuilder.insert(n4 + 1, UTF16.getTrailSurrogate(n10));
                        ++n2;
                    } else {
                        stringBuilder.setCharAt(n4, (char)n10);
                    }
                    if (n2 == stringBuilder.length()) break;
                    if ((n11 & 1) != 0) {
                        n3 = this.getCompositionsListForComposite(this.getNorm16(n10));
                        continue;
                    }
                    n3 = -1;
                    continue;
                }
            }
            n5 = n8;
            if (n2 == stringBuilder.length()) break;
            if (n8 == 0) {
                n3 = this.getCompositionsListForDecompYes(n7);
                if (n3 < 0) continue;
                if (n6 <= 65535) {
                    bl2 = false;
                    n4 = n2 - 1;
                    continue;
                }
                bl2 = true;
                n4 = n2 - 2;
                continue;
            }
            if (!bl) continue;
            n3 = -1;
        }
        reorderingBuffer.flush();
    }

    public int composePair(int n, int n2) {
        int n3;
        int n4 = this.getNorm16(n);
        if (Normalizer2Impl.isInert(n4)) {
            return -1;
        }
        if (n4 < this.minYesNoMappingsOnly) {
            if (Normalizer2Impl.isJamoL(n4)) {
                if (0 <= (n2 -= 4449) && n2 < 21) {
                    return 44032 + ((n - 4352) * 21 + n2) * 28;
                }
                return -1;
            }
            if (this.isHangul(n4)) {
                if (Hangul.isHangulWithoutJamoT((char)n) && 0 < (n2 -= 4519) && n2 < 28) {
                    return n + n2;
                }
                return -1;
            }
            n3 = n4;
            if (n4 > this.minYesNo) {
                n3 += 1 + (this.extraData.charAt(n3) & 0x1F);
            }
            n3 += 65024 - this.minMaybeYes;
        } else {
            if (n4 < this.minMaybeYes || 65024 <= n4) {
                return -1;
            }
            n3 = n4 - this.minMaybeYes;
        }
        if (n2 < 0 || 0x10FFFF < n2) {
            return -1;
        }
        return Normalizer2Impl.combine(this.maybeYesCompositions, n3, n2) >> 1;
    }

    private boolean hasCompBoundaryBefore(int n, int n2) {
        while (true) {
            if (this.isCompYesAndZeroCC(n2)) {
                return true;
            }
            if (this.isMaybeOrNonZeroCC(n2)) {
                return false;
            }
            if (!this.isDecompNoAlgorithmic(n2)) break;
            n = this.mapAlgorithmic(n, n2);
            n2 = this.getNorm16(n);
        }
        char c = this.extraData.charAt(n2);
        if ((c & 0x1F) == 0) {
            return false;
        }
        if ((c & 0x80) != 0 && (this.extraData.charAt(n2 - 1) & 0xFF00) != 0) {
            return false;
        }
        return this.isCompYesAndZeroCC(this.getNorm16(Character.codePointAt(this.extraData, n2 + 1)));
    }

    private int findPreviousCompBoundary(CharSequence charSequence, int n) {
        while (n > 0) {
            int n2 = Character.codePointBefore(charSequence, n);
            n -= Character.charCount(n2);
            if (!this.hasCompBoundaryBefore(n2)) continue;
            break;
        }
        return n;
    }

    private int findNextCompBoundary(CharSequence charSequence, int n, int n2) {
        int n3;
        int n4;
        while (n < n2 && !this.hasCompBoundaryBefore(n4 = Character.codePointAt(charSequence, n), n3 = this.normTrie.get(n4))) {
            n += Character.charCount(n4);
        }
        return n;
    }

    private int findPreviousFCDBoundary(CharSequence charSequence, int n) {
        while (n > 0) {
            int n2 = Character.codePointBefore(charSequence, n);
            n -= Character.charCount(n2);
            if (n2 >= 768 && this.getFCD16(n2) > 255) continue;
            break;
        }
        return n;
    }

    private int findNextFCDBoundary(CharSequence charSequence, int n, int n2) {
        int n3;
        while (n < n2 && (n3 = Character.codePointAt(charSequence, n)) >= 768 && this.getFCD16(n3) > 255) {
            n += Character.charCount(n3);
        }
        return n;
    }

    private void addToStartSet(Trie2Writable trie2Writable, int n, int n2) {
        int n3 = trie2Writable.get(n2);
        if ((n3 & 0x3FFFFF) == 0 && n != 0) {
            trie2Writable.set(n2, n3 | n);
        } else {
            UnicodeSet unicodeSet;
            if ((n3 & 0x200000) == 0) {
                int n4 = n3 & 0x1FFFFF;
                n3 = n3 & 0xFFE00000 | 0x200000 | this.canonStartSets.size();
                trie2Writable.set(n2, n3);
                unicodeSet = new UnicodeSet();
                this.canonStartSets.add(unicodeSet);
                if (n4 != 0) {
                    unicodeSet.add(n4);
                }
            } else {
                unicodeSet = this.canonStartSets.get(n3 & 0x1FFFFF);
            }
            unicodeSet.add(n);
        }
    }

    private static final class IsAcceptable
    implements ICUBinary.Authenticate {
        private IsAcceptable() {
        }

        public boolean isDataVersionAcceptable(byte[] byArray) {
            return byArray[0] == 2;
        }
    }

    public static final class UTF16Plus {
        public static boolean isSurrogateLead(int n) {
            return (n & 0x400) == 0;
        }

        public static boolean equal(CharSequence charSequence, CharSequence charSequence2) {
            if (charSequence == charSequence2) {
                return true;
            }
            int n = charSequence.length();
            if (n != charSequence2.length()) {
                return false;
            }
            for (int i = 0; i < n; ++i) {
                if (charSequence.charAt(i) == charSequence2.charAt(i)) continue;
                return false;
            }
            return true;
        }

        public static boolean equal(CharSequence charSequence, int n, int n2, CharSequence charSequence2, int n3, int n4) {
            if (n2 - n != n4 - n3) {
                return false;
            }
            if (charSequence == charSequence2 && n == n3) {
                return true;
            }
            while (n < n2) {
                if (charSequence.charAt(n++) == charSequence2.charAt(n3++)) continue;
                return false;
            }
            return true;
        }
    }

    public static final class ReorderingBuffer
    implements Appendable {
        private final Normalizer2Impl impl;
        private final Appendable app;
        private final StringBuilder str;
        private final boolean appIsStringBuilder;
        private int reorderStart;
        private int lastCC;
        private int codePointStart;
        private int codePointLimit;

        public ReorderingBuffer(Normalizer2Impl normalizer2Impl, Appendable appendable, int n) {
            this.impl = normalizer2Impl;
            this.app = appendable;
            if (this.app instanceof StringBuilder) {
                this.appIsStringBuilder = true;
                this.str = (StringBuilder)appendable;
                this.str.ensureCapacity(n);
                this.reorderStart = 0;
                if (this.str.length() == 0) {
                    this.lastCC = 0;
                } else {
                    this.setIterator();
                    this.lastCC = this.previousCC();
                    if (this.lastCC > 1) {
                        while (this.previousCC() > 1) {
                        }
                    }
                    this.reorderStart = this.codePointLimit;
                }
            } else {
                this.appIsStringBuilder = false;
                this.str = new StringBuilder();
                this.reorderStart = 0;
                this.lastCC = 0;
            }
        }

        public boolean isEmpty() {
            return this.str.length() == 0;
        }

        public int length() {
            return this.str.length();
        }

        public int getLastCC() {
            return this.lastCC;
        }

        public StringBuilder getStringBuilder() {
            return this.str;
        }

        public boolean equals(CharSequence charSequence, int n, int n2) {
            return UTF16Plus.equal(this.str, 0, this.str.length(), charSequence, n, n2);
        }

        public void setLastChar(char c) {
            this.str.setCharAt(this.str.length() - 1, c);
        }

        public void append(int n, int n2) {
            if (this.lastCC <= n2 || n2 == 0) {
                this.str.appendCodePoint(n);
                this.lastCC = n2;
                if (n2 <= 1) {
                    this.reorderStart = this.str.length();
                }
            } else {
                this.insert(n, n2);
            }
        }

        public void append(CharSequence charSequence, int n, int n2, int n3, int n4) {
            if (n == n2) {
                return;
            }
            if (this.lastCC <= n3 || n3 == 0) {
                if (n4 <= 1) {
                    this.reorderStart = this.str.length() + (n2 - n);
                } else if (n3 <= 1) {
                    this.reorderStart = this.str.length() + 1;
                }
                this.str.append(charSequence, n, n2);
                this.lastCC = n4;
            } else {
                int n5 = Character.codePointAt(charSequence, n);
                n += Character.charCount(n5);
                this.insert(n5, n3);
                while (n < n2) {
                    n3 = (n += Character.charCount(n5 = Character.codePointAt(charSequence, n))) < n2 ? Normalizer2Impl.getCCFromYesOrMaybe(this.impl.getNorm16(n5)) : n4;
                    this.append(n5, n3);
                }
            }
        }

        public ReorderingBuffer append(char c) {
            this.str.append(c);
            this.lastCC = 0;
            this.reorderStart = this.str.length();
            return this;
        }

        public void appendZeroCC(int n) {
            this.str.appendCodePoint(n);
            this.lastCC = 0;
            this.reorderStart = this.str.length();
        }

        public ReorderingBuffer append(CharSequence charSequence) {
            if (charSequence.length() != 0) {
                this.str.append(charSequence);
                this.lastCC = 0;
                this.reorderStart = this.str.length();
            }
            return this;
        }

        public ReorderingBuffer append(CharSequence charSequence, int n, int n2) {
            if (n != n2) {
                this.str.append(charSequence, n, n2);
                this.lastCC = 0;
                this.reorderStart = this.str.length();
            }
            return this;
        }

        public void flush() {
            if (this.appIsStringBuilder) {
                this.reorderStart = this.str.length();
            } else {
                try {
                    this.app.append(this.str);
                    this.str.setLength(0);
                    this.reorderStart = 0;
                }
                catch (IOException iOException) {
                    throw new RuntimeException(iOException);
                }
            }
            this.lastCC = 0;
        }

        public ReorderingBuffer flushAndAppendZeroCC(CharSequence charSequence, int n, int n2) {
            if (this.appIsStringBuilder) {
                this.str.append(charSequence, n, n2);
                this.reorderStart = this.str.length();
            } else {
                try {
                    this.app.append(this.str).append(charSequence, n, n2);
                    this.str.setLength(0);
                    this.reorderStart = 0;
                }
                catch (IOException iOException) {
                    throw new RuntimeException(iOException);
                }
            }
            this.lastCC = 0;
            return this;
        }

        public void remove() {
            this.str.setLength(0);
            this.lastCC = 0;
            this.reorderStart = 0;
        }

        public void removeSuffix(int n) {
            int n2 = this.str.length();
            this.str.delete(n2 - n, n2);
            this.lastCC = 0;
            this.reorderStart = this.str.length();
        }

        private void insert(int n, int n2) {
            this.setIterator();
            this.skipPrevious();
            while (this.previousCC() > n2) {
            }
            if (n <= 65535) {
                this.str.insert(this.codePointLimit, (char)n);
                if (n2 <= 1) {
                    this.reorderStart = this.codePointLimit + 1;
                }
            } else {
                this.str.insert(this.codePointLimit, Character.toChars(n));
                if (n2 <= 1) {
                    this.reorderStart = this.codePointLimit + 2;
                }
            }
        }

        private void setIterator() {
            this.codePointStart = this.str.length();
        }

        private void skipPrevious() {
            this.codePointLimit = this.codePointStart;
            this.codePointStart = this.str.offsetByCodePoints(this.codePointStart, -1);
        }

        private int previousCC() {
            this.codePointLimit = this.codePointStart;
            if (this.reorderStart >= this.codePointStart) {
                return 0;
            }
            int n = this.str.codePointBefore(this.codePointStart);
            this.codePointStart -= Character.charCount(n);
            if (n < 768) {
                return 0;
            }
            return Normalizer2Impl.getCCFromYesOrMaybe(this.impl.getNorm16(n));
        }
    }

    public static final class Hangul {
        public static final int JAMO_L_BASE = 4352;
        public static final int JAMO_V_BASE = 4449;
        public static final int JAMO_T_BASE = 4519;
        public static final int HANGUL_BASE = 44032;
        public static final int JAMO_L_COUNT = 19;
        public static final int JAMO_V_COUNT = 21;
        public static final int JAMO_T_COUNT = 28;
        public static final int JAMO_L_LIMIT = 4371;
        public static final int JAMO_V_LIMIT = 4470;
        public static final int JAMO_VT_COUNT = 588;
        public static final int HANGUL_COUNT = 11172;
        public static final int HANGUL_LIMIT = 55204;

        public static boolean isHangul(int n) {
            return 44032 <= n && n < 55204;
        }

        public static boolean isHangulWithoutJamoT(char c) {
            return (c = (char)(c - 44032)) < '\u2ba4' && c % 28 == 0;
        }

        public static boolean isJamoL(int n) {
            return 4352 <= n && n < 4371;
        }

        public static boolean isJamoV(int n) {
            return 4449 <= n && n < 4470;
        }

        public static int decompose(int n, Appendable appendable) {
            try {
                int n2 = (n -= 44032) % 28;
                appendable.append((char)(4352 + (n /= 28) / 21));
                appendable.append((char)(4449 + n % 21));
                if (n2 == 0) {
                    return 2;
                }
                appendable.append((char)(4519 + n2));
                return 3;
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }

        public static void getRawDecomposition(int n, Appendable appendable) {
            try {
                int n2 = n;
                int n3 = (n -= 44032) % 28;
                if (n3 == 0) {
                    appendable.append((char)(4352 + (n /= 28) / 21));
                    appendable.append((char)(4449 + n % 21));
                } else {
                    appendable.append((char)(n2 - n3));
                    appendable.append((char)(4519 + n3));
                }
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }
    }
}

