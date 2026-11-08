/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.Trie2;
import com.ibm.icu.impl.Trie2_16;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ULocale;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UCaseProps {
    private static final byte[] flagsOffset = new byte[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 4, 5, 5, 6, 5, 6, 6, 7, 5, 6, 6, 7, 6, 7, 7, 8};
    public static final int MAX_STRING_LENGTH = 31;
    private static final int LOC_UNKNOWN = 0;
    private static final int LOC_ROOT = 1;
    private static final int LOC_TURKISH = 2;
    private static final int LOC_LITHUANIAN = 3;
    private static final String iDot = "i\u0307";
    private static final String jDot = "j\u0307";
    private static final String iOgonekDot = "\u012f\u0307";
    private static final String iDotGrave = "i\u0307\u0300";
    private static final String iDotAcute = "i\u0307\u0301";
    private static final String iDotTilde = "i\u0307\u0303";
    private static final int FOLD_CASE_OPTIONS_MASK = 255;
    private static final int[] rootLocCache = new int[]{1};
    public static final StringBuilder dummyStringBuilder = new StringBuilder();
    private int[] indexes;
    private char[] exceptions;
    private char[] unfold;
    private Trie2_16 trie;
    private static final String DATA_NAME = "ucase";
    private static final String DATA_TYPE = "icu";
    private static final String DATA_FILE_NAME = "ucase.icu";
    private static final byte[] FMT = new byte[]{99, 65, 83, 69};
    private static final int IX_TRIE_SIZE = 2;
    private static final int IX_EXC_LENGTH = 3;
    private static final int IX_UNFOLD_LENGTH = 4;
    private static final int IX_TOP = 16;
    public static final int TYPE_MASK = 3;
    public static final int NONE = 0;
    public static final int LOWER = 1;
    public static final int UPPER = 2;
    public static final int TITLE = 3;
    private static final int SENSITIVE = 8;
    private static final int EXCEPTION = 16;
    private static final int DOT_MASK = 96;
    private static final int SOFT_DOTTED = 32;
    private static final int ABOVE = 64;
    private static final int OTHER_ACCENT = 96;
    private static final int DELTA_SHIFT = 7;
    private static final int EXC_SHIFT = 5;
    private static final int EXC_LOWER = 0;
    private static final int EXC_FOLD = 1;
    private static final int EXC_UPPER = 2;
    private static final int EXC_TITLE = 3;
    private static final int EXC_CLOSURE = 6;
    private static final int EXC_FULL_MAPPINGS = 7;
    private static final int EXC_DOUBLE_SLOTS = 256;
    private static final int EXC_DOT_SHIFT = 7;
    private static final int EXC_CONDITIONAL_SPECIAL = 16384;
    private static final int EXC_CONDITIONAL_FOLD = 32768;
    private static final int FULL_LOWER = 15;
    private static final int CLOSURE_MAX_LENGTH = 15;
    private static final int UNFOLD_ROWS = 0;
    private static final int UNFOLD_ROW_WIDTH = 1;
    private static final int UNFOLD_STRING_WIDTH = 2;
    public static final UCaseProps INSTANCE;

    private UCaseProps() throws IOException {
        InputStream inputStream2 = ICUData.getRequiredStream("data/icudt51b/ucase.icu");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream2, 4096);
        this.readData(bufferedInputStream);
        bufferedInputStream.close();
        inputStream2.close();
    }

    private final void readData(InputStream inputStream2) throws IOException {
        int n;
        DataInputStream dataInputStream = new DataInputStream(inputStream2);
        ICUBinary.readHeader(dataInputStream, FMT, new IsAcceptable());
        int n2 = dataInputStream.readInt();
        if (n2 < 16) {
            throw new IOException("indexes[0] too small in ucase.icu");
        }
        this.indexes = new int[n2];
        this.indexes[0] = n2;
        for (n = 1; n < n2; ++n) {
            this.indexes[n] = dataInputStream.readInt();
        }
        this.trie = Trie2_16.createFromSerialized(dataInputStream);
        int n3 = this.indexes[2];
        int n4 = this.trie.getSerializedLength();
        if (n4 > n3) {
            throw new IOException("ucase.icu: not enough bytes for the trie");
        }
        dataInputStream.skipBytes(n3 - n4);
        n2 = this.indexes[3];
        if (n2 > 0) {
            this.exceptions = new char[n2];
            for (n = 0; n < n2; ++n) {
                this.exceptions[n] = dataInputStream.readChar();
            }
        }
        if ((n2 = this.indexes[4]) > 0) {
            this.unfold = new char[n2];
            for (n = 0; n < n2; ++n) {
                this.unfold[n] = dataInputStream.readChar();
            }
        }
    }

    public final void addPropertyStarts(UnicodeSet unicodeSet) {
        for (Trie2.Range range : this.trie) {
            if (range.leadSurrogate) break;
            unicodeSet.add(range.startCodePoint);
        }
    }

    private static final int getExceptionsOffset(int n) {
        return n >> 5;
    }

    private static final boolean propsHasException(int n) {
        return (n & 0x10) != 0;
    }

    private static final boolean hasSlot(int n, int n2) {
        return (n & 1 << n2) != 0;
    }

    private static final byte slotOffset(int n, int n2) {
        return flagsOffset[n & (1 << n2) - 1];
    }

    private final long getSlotValueAndOffset(int n, int n2, int n3) {
        long l;
        if ((n & 0x100) == 0) {
            l = this.exceptions[n3 += UCaseProps.slotOffset(n, n2)];
        } else {
            n3 += 2 * UCaseProps.slotOffset(n, n2);
            l = this.exceptions[n3++];
            l = l << 16 | (long)this.exceptions[n3];
        }
        return l | (long)n3 << 32;
    }

    private final int getSlotValue(int n, int n2, int n3) {
        int n4;
        if ((n & 0x100) == 0) {
            n4 = this.exceptions[n3 += UCaseProps.slotOffset(n, n2)];
        } else {
            n3 += 2 * UCaseProps.slotOffset(n, n2);
            n4 = this.exceptions[n3++];
            n4 = n4 << 16 | this.exceptions[n3];
        }
        return n4;
    }

    public final int tolower(int n) {
        int n2 = this.trie.get(n);
        if (!UCaseProps.propsHasException(n2)) {
            if (UCaseProps.getTypeFromProps(n2) >= 2) {
                n += UCaseProps.getDelta(n2);
            }
        } else {
            char c;
            int n3 = UCaseProps.getExceptionsOffset(n2);
            if (UCaseProps.hasSlot(c = this.exceptions[n3++], 0)) {
                n = this.getSlotValue(c, 0, n3);
            }
        }
        return n;
    }

    public final int toupper(int n) {
        int n2 = this.trie.get(n);
        if (!UCaseProps.propsHasException(n2)) {
            if (UCaseProps.getTypeFromProps(n2) == 1) {
                n += UCaseProps.getDelta(n2);
            }
        } else {
            char c;
            int n3 = UCaseProps.getExceptionsOffset(n2);
            if (UCaseProps.hasSlot(c = this.exceptions[n3++], 2)) {
                n = this.getSlotValue(c, 2, n3);
            }
        }
        return n;
    }

    public final int totitle(int n) {
        int n2 = this.trie.get(n);
        if (!UCaseProps.propsHasException(n2)) {
            if (UCaseProps.getTypeFromProps(n2) == 1) {
                n += UCaseProps.getDelta(n2);
            }
        } else {
            int n3;
            char c;
            int n4 = UCaseProps.getExceptionsOffset(n2);
            if (UCaseProps.hasSlot(c = this.exceptions[n4++], 3)) {
                n3 = 3;
            } else if (UCaseProps.hasSlot(c, 2)) {
                n3 = 2;
            } else {
                return n;
            }
            n = this.getSlotValue(c, n3, n4);
        }
        return n;
    }

    public final void addCaseClosure(int n, UnicodeSet unicodeSet) {
        switch (n) {
            case 73: {
                unicodeSet.add(105);
                return;
            }
            case 105: {
                unicodeSet.add(73);
                return;
            }
            case 304: {
                unicodeSet.add(iDot);
                return;
            }
            case 305: {
                return;
            }
        }
        int n2 = this.trie.get(n);
        if (!UCaseProps.propsHasException(n2)) {
            int n3;
            if (UCaseProps.getTypeFromProps(n2) != 0 && (n3 = UCaseProps.getDelta(n2)) != 0) {
                unicodeSet.add(n + n3);
            }
        } else {
            int n4;
            int n5;
            long l;
            int n6;
            int n7 = UCaseProps.getExceptionsOffset(n2);
            char c = this.exceptions[n7++];
            int n8 = n7;
            for (n6 = 0; n6 <= 3; ++n6) {
                if (!UCaseProps.hasSlot(c, n6)) continue;
                n7 = n8;
                n = this.getSlotValue(c, n6, n7);
                unicodeSet.add(n);
            }
            if (UCaseProps.hasSlot(c, 6)) {
                n7 = n8;
                l = this.getSlotValueAndOffset(c, 6, n7);
                n5 = (int)l & 0xF;
                n4 = (int)(l >> 32) + 1;
            } else {
                n5 = 0;
                n4 = 0;
            }
            if (UCaseProps.hasSlot(c, 7)) {
                n7 = n8;
                l = this.getSlotValueAndOffset(c, 7, n7);
                int n9 = (int)l;
                n7 = (int)(l >> 32) + 1;
                n7 += (n9 &= 0xFFFF) & 0xF;
                int n10 = (n9 >>= 4) & 0xF;
                if (n10 != 0) {
                    unicodeSet.add(new String(this.exceptions, n7, n10));
                    n7 += n10;
                }
                n7 += (n9 >>= 4) & 0xF;
                n4 = n7 += (n9 >>= 4);
            }
            for (n6 = 0; n6 < n5; n6 += UTF16.getCharCount(n)) {
                n = UTF16.charAt(this.exceptions, n4, this.exceptions.length, n6);
                unicodeSet.add(n);
            }
        }
    }

    private final int strcmpMax(String string, int n, int n2) {
        int n3 = string.length();
        n2 -= n3;
        int n4 = 0;
        do {
            char c;
            int n5 = string.charAt(n4++);
            if ((c = this.unfold[n++]) == '\u0000') {
                return 1;
            }
            if ((n5 -= c) == 0) continue;
            return n5;
        } while (--n3 > 0);
        if (n2 == 0 || this.unfold[n] == '\u0000') {
            return 0;
        }
        return -n2;
    }

    public final boolean addStringCaseClosure(String string, UnicodeSet unicodeSet) {
        if (this.unfold == null || string == null) {
            return false;
        }
        int n = string.length();
        if (n <= 1) {
            return false;
        }
        int n2 = this.unfold[0];
        char c = this.unfold[1];
        int n3 = this.unfold[2];
        if (n > n3) {
            return false;
        }
        int n4 = 0;
        int n5 = n2;
        while (n4 < n5) {
            int n6 = (n4 + n5) / 2;
            int n7 = (n6 + 1) * c;
            int n8 = this.strcmpMax(string, n7, n3);
            if (n8 == 0) {
                int n9;
                for (n6 = n3; n6 < c && this.unfold[n7 + n6] != '\u0000'; n6 += UTF16.getCharCount(n9)) {
                    n9 = UTF16.charAt(this.unfold, n7, this.unfold.length, n6);
                    unicodeSet.add(n9);
                    this.addCaseClosure(n9, unicodeSet);
                }
                return true;
            }
            if (n8 < 0) {
                n5 = n6;
                continue;
            }
            n4 = n6 + 1;
        }
        return false;
    }

    public final int getType(int n) {
        return UCaseProps.getTypeFromProps(this.trie.get(n));
    }

    public final int getTypeOrIgnorable(int n) {
        return UCaseProps.getTypeAndIgnorableFromProps(this.trie.get(n));
    }

    public final int getDotType(int n) {
        int n2 = this.trie.get(n);
        if (!UCaseProps.propsHasException(n2)) {
            return n2 & 0x60;
        }
        return this.exceptions[UCaseProps.getExceptionsOffset(n2)] >> 7 & 0x60;
    }

    public final boolean isSoftDotted(int n) {
        return this.getDotType(n) == 32;
    }

    public final boolean isCaseSensitive(int n) {
        return (this.trie.get(n) & 8) != 0;
    }

    private static final int getCaseLocale(ULocale uLocale, int[] nArray) {
        int n;
        if (nArray != null && (n = nArray[0]) != 0) {
            return n;
        }
        n = 1;
        String string = uLocale.getLanguage();
        if (string.equals("tr") || string.equals("tur") || string.equals("az") || string.equals("aze")) {
            n = 2;
        } else if (string.equals("lt") || string.equals("lit")) {
            n = 3;
        }
        if (nArray != null) {
            nArray[0] = n;
        }
        return n;
    }

    private final boolean isFollowedByCasedLetter(ContextIterator contextIterator, int n) {
        int n2;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(n);
        while ((n2 = contextIterator.next()) >= 0) {
            int n3 = this.getTypeOrIgnorable(n2);
            if ((n3 & 4) != 0) continue;
            return n3 != 0;
        }
        return false;
    }

    private final boolean isPrecededBySoftDotted(ContextIterator contextIterator) {
        int n;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(-1);
        while ((n = contextIterator.next()) >= 0) {
            int n2 = this.getDotType(n);
            if (n2 == 32) {
                return true;
            }
            if (n2 == 96) continue;
            return false;
        }
        return false;
    }

    private final boolean isPrecededBy_I(ContextIterator contextIterator) {
        int n;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(-1);
        while ((n = contextIterator.next()) >= 0) {
            if (n == 73) {
                return true;
            }
            int n2 = this.getDotType(n);
            if (n2 == 96) continue;
            return false;
        }
        return false;
    }

    private final boolean isFollowedByMoreAbove(ContextIterator contextIterator) {
        int n;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(1);
        while ((n = contextIterator.next()) >= 0) {
            int n2 = this.getDotType(n);
            if (n2 == 64) {
                return true;
            }
            if (n2 == 96) continue;
            return false;
        }
        return false;
    }

    private final boolean isFollowedByDotAbove(ContextIterator contextIterator) {
        int n;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(1);
        while ((n = contextIterator.next()) >= 0) {
            if (n == 775) {
                return true;
            }
            int n2 = this.getDotType(n);
            if (n2 == 96) continue;
            return false;
        }
        return false;
    }

    public final int toFullLower(int n, ContextIterator contextIterator, StringBuilder stringBuilder, ULocale uLocale, int[] nArray) {
        int n2 = n;
        int n3 = this.trie.get(n);
        if (!UCaseProps.propsHasException(n3)) {
            if (UCaseProps.getTypeFromProps(n3) >= 2) {
                n2 = n + UCaseProps.getDelta(n3);
            }
        } else {
            long l;
            int n4;
            int n5 = UCaseProps.getExceptionsOffset(n3);
            char c = this.exceptions[n5++];
            int n6 = n5;
            if ((c & 0x4000) != 0) {
                int n7 = UCaseProps.getCaseLocale(uLocale, nArray);
                if (n7 == 3 && ((n == 73 || n == 74 || n == 302) && this.isFollowedByMoreAbove(contextIterator) || n == 204 || n == 205 || n == 296)) {
                    switch (n) {
                        case 73: {
                            stringBuilder.append(iDot);
                            return 2;
                        }
                        case 74: {
                            stringBuilder.append(jDot);
                            return 2;
                        }
                        case 302: {
                            stringBuilder.append(iOgonekDot);
                            return 2;
                        }
                        case 204: {
                            stringBuilder.append(iDotGrave);
                            return 3;
                        }
                        case 205: {
                            stringBuilder.append(iDotAcute);
                            return 3;
                        }
                        case 296: {
                            stringBuilder.append(iDotTilde);
                            return 3;
                        }
                    }
                    return 0;
                }
                if (n7 == 2 && n == 304) {
                    return 105;
                }
                if (n7 == 2 && n == 775 && this.isPrecededBy_I(contextIterator)) {
                    return 0;
                }
                if (n7 == 2 && n == 73 && !this.isFollowedByDotAbove(contextIterator)) {
                    return 305;
                }
                if (n == 304) {
                    stringBuilder.append(iDot);
                    return 2;
                }
                if (n == 931 && !this.isFollowedByCasedLetter(contextIterator, 1) && this.isFollowedByCasedLetter(contextIterator, -1)) {
                    return 962;
                }
            } else if (UCaseProps.hasSlot(c, 7) && (n4 = (int)(l = this.getSlotValueAndOffset(c, 7, n5)) & 0xF) != 0) {
                n5 = (int)(l >> 32) + 1;
                stringBuilder.append(this.exceptions, n5, n4);
                return n4;
            }
            if (UCaseProps.hasSlot(c, 0)) {
                n2 = this.getSlotValue(c, 0, n6);
            }
        }
        return n2 == n ? ~n2 : n2;
    }

    private final int toUpperOrTitle(int n, ContextIterator contextIterator, StringBuilder stringBuilder, ULocale uLocale, int[] nArray, boolean bl) {
        int n2 = n;
        int n3 = this.trie.get(n);
        if (!UCaseProps.propsHasException(n3)) {
            if (UCaseProps.getTypeFromProps(n3) == 1) {
                n2 = n + UCaseProps.getDelta(n3);
            }
        } else {
            int n4;
            int n5 = UCaseProps.getExceptionsOffset(n3);
            char c = this.exceptions[n5++];
            int n6 = n5;
            if ((c & 0x4000) != 0) {
                int n7 = UCaseProps.getCaseLocale(uLocale, nArray);
                if (n7 == 2 && n == 105) {
                    return 304;
                }
                if (n7 == 3 && n == 775 && this.isPrecededBySoftDotted(contextIterator)) {
                    return 0;
                }
            } else if (UCaseProps.hasSlot(c, 7)) {
                long l = this.getSlotValueAndOffset(c, 7, n5);
                int n8 = (int)l & 0xFFFF;
                n5 = (int)(l >> 32) + 1;
                n5 += n8 & 0xF;
                n5 += (n8 >>= 4) & 0xF;
                n8 >>= 4;
                if (bl) {
                    n8 &= 0xF;
                } else {
                    n5 += n8 & 0xF;
                    n8 = n8 >> 4 & 0xF;
                }
                if (n8 != 0) {
                    stringBuilder.append(this.exceptions, n5, n8);
                    return n8;
                }
            }
            if (!bl && UCaseProps.hasSlot(c, 3)) {
                n4 = 3;
            } else if (UCaseProps.hasSlot(c, 2)) {
                n4 = 2;
            } else {
                return ~n;
            }
            n2 = this.getSlotValue(c, n4, n6);
        }
        return n2 == n ? ~n2 : n2;
    }

    public final int toFullUpper(int n, ContextIterator contextIterator, StringBuilder stringBuilder, ULocale uLocale, int[] nArray) {
        return this.toUpperOrTitle(n, contextIterator, stringBuilder, uLocale, nArray, true);
    }

    public final int toFullTitle(int n, ContextIterator contextIterator, StringBuilder stringBuilder, ULocale uLocale, int[] nArray) {
        return this.toUpperOrTitle(n, contextIterator, stringBuilder, uLocale, nArray, false);
    }

    public final int fold(int n, int n2) {
        int n3 = this.trie.get(n);
        if (!UCaseProps.propsHasException(n3)) {
            if (UCaseProps.getTypeFromProps(n3) >= 2) {
                n += UCaseProps.getDelta(n3);
            }
        } else {
            int n4;
            char c;
            int n5 = UCaseProps.getExceptionsOffset(n3);
            if (((c = this.exceptions[n5++]) & 0x8000) != 0) {
                if ((n2 & 0xFF) == 0) {
                    if (n == 73) {
                        return 105;
                    }
                    if (n == 304) {
                        return n;
                    }
                } else {
                    if (n == 73) {
                        return 305;
                    }
                    if (n == 304) {
                        return 105;
                    }
                }
            }
            if (UCaseProps.hasSlot(c, 1)) {
                n4 = 1;
            } else if (UCaseProps.hasSlot(c, 0)) {
                n4 = 0;
            } else {
                return n;
            }
            n = this.getSlotValue(c, n4, n5);
        }
        return n;
    }

    public final int toFullFolding(int n, StringBuilder stringBuilder, int n2) {
        int n3 = n;
        int n4 = this.trie.get(n);
        if (!UCaseProps.propsHasException(n4)) {
            if (UCaseProps.getTypeFromProps(n4) >= 2) {
                n3 = n + UCaseProps.getDelta(n4);
            }
        } else {
            int n5;
            int n6 = UCaseProps.getExceptionsOffset(n4);
            char c = this.exceptions[n6++];
            int n7 = n6;
            if ((c & 0x8000) != 0) {
                if ((n2 & 0xFF) == 0) {
                    if (n == 73) {
                        return 105;
                    }
                    if (n == 304) {
                        stringBuilder.append(iDot);
                        return 2;
                    }
                } else {
                    if (n == 73) {
                        return 305;
                    }
                    if (n == 304) {
                        return 105;
                    }
                }
            } else if (UCaseProps.hasSlot(c, 7)) {
                long l = this.getSlotValueAndOffset(c, 7, n6);
                int n8 = (int)l & 0xFFFF;
                n6 = (int)(l >> 32) + 1;
                n6 += n8 & 0xF;
                if ((n8 = n8 >> 4 & 0xF) != 0) {
                    stringBuilder.append(this.exceptions, n6, n8);
                    return n8;
                }
            }
            if (UCaseProps.hasSlot(c, 1)) {
                n5 = 1;
            } else if (UCaseProps.hasSlot(c, 0)) {
                n5 = 0;
            } else {
                return ~n;
            }
            n3 = this.getSlotValue(c, n5, n7);
        }
        return n3 == n ? ~n3 : n3;
    }

    public final boolean hasBinaryProperty(int n, int n2) {
        switch (n2) {
            case 22: {
                return 1 == this.getType(n);
            }
            case 30: {
                return 2 == this.getType(n);
            }
            case 27: {
                return this.isSoftDotted(n);
            }
            case 34: {
                return this.isCaseSensitive(n);
            }
            case 49: {
                return 0 != this.getType(n);
            }
            case 50: {
                return this.getTypeOrIgnorable(n) >> 2 != 0;
            }
            case 51: {
                dummyStringBuilder.setLength(0);
                return this.toFullLower(n, null, dummyStringBuilder, ULocale.ROOT, rootLocCache) >= 0;
            }
            case 52: {
                dummyStringBuilder.setLength(0);
                return this.toFullUpper(n, null, dummyStringBuilder, ULocale.ROOT, rootLocCache) >= 0;
            }
            case 53: {
                dummyStringBuilder.setLength(0);
                return this.toFullTitle(n, null, dummyStringBuilder, ULocale.ROOT, rootLocCache) >= 0;
            }
            case 55: {
                dummyStringBuilder.setLength(0);
                return this.toFullLower(n, null, dummyStringBuilder, ULocale.ROOT, rootLocCache) >= 0 || this.toFullUpper(n, null, dummyStringBuilder, ULocale.ROOT, rootLocCache) >= 0 || this.toFullTitle(n, null, dummyStringBuilder, ULocale.ROOT, rootLocCache) >= 0;
            }
        }
        return false;
    }

    private static final int getTypeFromProps(int n) {
        return n & 3;
    }

    private static final int getTypeAndIgnorableFromProps(int n) {
        return n & 7;
    }

    private static final int getDelta(int n) {
        return (short)n >> 7;
    }

    static {
        try {
            INSTANCE = new UCaseProps();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    public static interface ContextIterator {
        public void reset(int var1);

        public int next();
    }

    private static final class IsAcceptable
    implements ICUBinary.Authenticate {
        private IsAcceptable() {
        }

        public boolean isDataVersionAcceptable(byte[] byArray) {
            return byArray[0] == 3;
        }
    }
}

