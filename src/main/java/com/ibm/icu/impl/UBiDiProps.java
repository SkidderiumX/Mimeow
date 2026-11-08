/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.Trie2;
import com.ibm.icu.impl.Trie2_16;
import com.ibm.icu.text.UnicodeSet;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UBiDiProps {
    private int[] indexes;
    private int[] mirrors;
    private byte[] jgArray;
    private Trie2_16 trie;
    private static final String DATA_NAME = "ubidi";
    private static final String DATA_TYPE = "icu";
    private static final String DATA_FILE_NAME = "ubidi.icu";
    private static final byte[] FMT = new byte[]{66, 105, 68, 105};
    private static final int IX_TRIE_SIZE = 2;
    private static final int IX_MIRROR_LENGTH = 3;
    private static final int IX_JG_START = 4;
    private static final int IX_JG_LIMIT = 5;
    private static final int IX_MAX_VALUES = 15;
    private static final int IX_TOP = 16;
    private static final int JT_SHIFT = 5;
    private static final int JOIN_CONTROL_SHIFT = 10;
    private static final int BIDI_CONTROL_SHIFT = 11;
    private static final int IS_MIRRORED_SHIFT = 12;
    private static final int MIRROR_DELTA_SHIFT = 13;
    private static final int MAX_JG_SHIFT = 16;
    private static final int CLASS_MASK = 31;
    private static final int JT_MASK = 224;
    private static final int MAX_JG_MASK = 0xFF0000;
    private static final int ESC_MIRROR_DELTA = -4;
    private static final int MIRROR_INDEX_SHIFT = 21;
    public static final UBiDiProps INSTANCE;

    private UBiDiProps() throws IOException {
        InputStream inputStream2 = ICUData.getStream("data/icudt51b/ubidi.icu");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream2, 4096);
        this.readData(bufferedInputStream);
        bufferedInputStream.close();
        inputStream2.close();
    }

    private void readData(InputStream inputStream2) throws IOException {
        int n;
        DataInputStream dataInputStream = new DataInputStream(inputStream2);
        ICUBinary.readHeader(dataInputStream, FMT, new IsAcceptable());
        int n2 = dataInputStream.readInt();
        if (n2 < 16) {
            throw new IOException("indexes[0] too small in ubidi.icu");
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
            throw new IOException("ubidi.icu: not enough bytes for the trie");
        }
        dataInputStream.skipBytes(n3 - n4);
        n2 = this.indexes[3];
        if (n2 > 0) {
            this.mirrors = new int[n2];
            for (n = 0; n < n2; ++n) {
                this.mirrors[n] = dataInputStream.readInt();
            }
        }
        n2 = this.indexes[5] - this.indexes[4];
        this.jgArray = new byte[n2];
        for (n = 0; n < n2; ++n) {
            this.jgArray[n] = dataInputStream.readByte();
        }
    }

    public final void addPropertyStarts(UnicodeSet unicodeSet) {
        int n;
        for (Trie2.Range range : this.trie) {
            if (range.leadSurrogate) break;
            unicodeSet.add(range.startCodePoint);
        }
        int n2 = this.indexes[3];
        for (n = 0; n < n2; ++n) {
            int n3 = UBiDiProps.getMirrorCodePoint(this.mirrors[n]);
            unicodeSet.add(n3, n3 + 1);
        }
        int n4 = this.indexes[4];
        int n5 = this.indexes[5];
        n2 = n5 - n4;
        byte by = 0;
        for (n = 0; n < n2; ++n) {
            byte by2 = this.jgArray[n];
            if (by2 != by) {
                unicodeSet.add(n4);
                by = by2;
            }
            ++n4;
        }
        if (by != 0) {
            unicodeSet.add(n5);
        }
    }

    public final int getMaxValue(int n) {
        int n2 = this.indexes[15];
        switch (n) {
            case 4096: {
                return n2 & 0x1F;
            }
            case 4102: {
                return (n2 & 0xFF0000) >> 16;
            }
            case 4103: {
                return (n2 & 0xE0) >> 5;
            }
        }
        return -1;
    }

    public final int getClass(int n) {
        return UBiDiProps.getClassFromProps(this.trie.get(n));
    }

    public final boolean isMirrored(int n) {
        return UBiDiProps.getFlagFromProps(this.trie.get(n), 12);
    }

    public final int getMirror(int n) {
        int n2 = this.trie.get(n);
        int n3 = (short)n2 >> 13;
        if (n3 != -4) {
            return n + n3;
        }
        int n4 = this.indexes[3];
        for (int i = 0; i < n4; ++i) {
            int n5 = this.mirrors[i];
            int n6 = UBiDiProps.getMirrorCodePoint(n5);
            if (n == n6) {
                return UBiDiProps.getMirrorCodePoint(this.mirrors[UBiDiProps.getMirrorIndex(n5)]);
            }
            if (n < n6) break;
        }
        return n;
    }

    public final boolean isBidiControl(int n) {
        return UBiDiProps.getFlagFromProps(this.trie.get(n), 11);
    }

    public final boolean isJoinControl(int n) {
        return UBiDiProps.getFlagFromProps(this.trie.get(n), 10);
    }

    public final int getJoiningType(int n) {
        return (this.trie.get(n) & 0xE0) >> 5;
    }

    public final int getJoiningGroup(int n) {
        int n2 = this.indexes[4];
        int n3 = this.indexes[5];
        if (n2 <= n && n < n3) {
            return this.jgArray[n - n2] & 0xFF;
        }
        return 0;
    }

    private static final int getClassFromProps(int n) {
        return n & 0x1F;
    }

    private static final boolean getFlagFromProps(int n, int n2) {
        return (n >> n2 & 1) != 0;
    }

    private static final int getMirrorCodePoint(int n) {
        return n & 0x1FFFFF;
    }

    private static final int getMirrorIndex(int n) {
        return n >>> 21;
    }

    static {
        try {
            INSTANCE = new UBiDiProps();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
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
}

