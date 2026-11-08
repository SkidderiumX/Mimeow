/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.Trie2_16;
import com.ibm.icu.impl.Trie2_32;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class Trie2
implements Iterable<Range> {
    private static ValueMapper defaultValueMapper = new ValueMapper(){

        public int map(int n) {
            return n;
        }
    };
    UTrie2Header header;
    char[] index;
    int data16;
    int[] data32;
    int indexLength;
    int dataLength;
    int index2NullOffset;
    int initialValue;
    int errorValue;
    int highStart;
    int highValueIndex;
    int dataNullOffset;
    int fHash;
    static final int UTRIE2_OPTIONS_VALUE_BITS_MASK = 15;
    static final int UTRIE2_SHIFT_1 = 11;
    static final int UTRIE2_SHIFT_2 = 5;
    static final int UTRIE2_SHIFT_1_2 = 6;
    static final int UTRIE2_OMITTED_BMP_INDEX_1_LENGTH = 32;
    static final int UTRIE2_CP_PER_INDEX_1_ENTRY = 2048;
    static final int UTRIE2_INDEX_2_BLOCK_LENGTH = 64;
    static final int UTRIE2_INDEX_2_MASK = 63;
    static final int UTRIE2_DATA_BLOCK_LENGTH = 32;
    static final int UTRIE2_DATA_MASK = 31;
    static final int UTRIE2_INDEX_SHIFT = 2;
    static final int UTRIE2_DATA_GRANULARITY = 4;
    static final int UTRIE2_INDEX_2_OFFSET = 0;
    static final int UTRIE2_LSCP_INDEX_2_OFFSET = 2048;
    static final int UTRIE2_LSCP_INDEX_2_LENGTH = 32;
    static final int UTRIE2_INDEX_2_BMP_LENGTH = 2080;
    static final int UTRIE2_UTF8_2B_INDEX_2_OFFSET = 2080;
    static final int UTRIE2_UTF8_2B_INDEX_2_LENGTH = 32;
    static final int UTRIE2_INDEX_1_OFFSET = 2112;
    static final int UTRIE2_MAX_INDEX_1_LENGTH = 512;
    static final int UTRIE2_BAD_UTF8_DATA_OFFSET = 128;
    static final int UTRIE2_DATA_START_OFFSET = 192;
    static final int UNEWTRIE2_INDEX_GAP_OFFSET = 2080;
    static final int UNEWTRIE2_INDEX_GAP_LENGTH = 576;
    static final int UNEWTRIE2_MAX_INDEX_2_LENGTH = 35488;
    static final int UNEWTRIE2_INDEX_1_LENGTH = 544;
    static final int UNEWTRIE2_MAX_DATA_LENGTH = 1115264;

    public static Trie2 createFromSerialized(InputStream inputStream2) throws IOException {
        int n;
        Trie2 trie2;
        ValueWidth valueWidth;
        DataInputStream dataInputStream = new DataInputStream(inputStream2);
        boolean bl = false;
        UTrie2Header uTrie2Header = new UTrie2Header();
        uTrie2Header.signature = dataInputStream.readInt();
        switch (uTrie2Header.signature) {
            case 1416784178: {
                bl = false;
                break;
            }
            case 845771348: {
                bl = true;
                uTrie2Header.signature = Integer.reverseBytes(uTrie2Header.signature);
                break;
            }
            default: {
                throw new IllegalArgumentException("Stream does not contain a serialized UTrie2");
            }
        }
        uTrie2Header.options = Trie2.swapShort(bl, dataInputStream.readUnsignedShort());
        uTrie2Header.indexLength = Trie2.swapShort(bl, dataInputStream.readUnsignedShort());
        uTrie2Header.shiftedDataLength = Trie2.swapShort(bl, dataInputStream.readUnsignedShort());
        uTrie2Header.index2NullOffset = Trie2.swapShort(bl, dataInputStream.readUnsignedShort());
        uTrie2Header.dataNullOffset = Trie2.swapShort(bl, dataInputStream.readUnsignedShort());
        uTrie2Header.shiftedHighStart = Trie2.swapShort(bl, dataInputStream.readUnsignedShort());
        if ((uTrie2Header.options & 0xF) > 1) {
            throw new IllegalArgumentException("UTrie2 serialized format error.");
        }
        if ((uTrie2Header.options & 0xF) == 0) {
            valueWidth = ValueWidth.BITS_16;
            trie2 = new Trie2_16();
        } else {
            valueWidth = ValueWidth.BITS_32;
            trie2 = new Trie2_32();
        }
        trie2.header = uTrie2Header;
        trie2.indexLength = uTrie2Header.indexLength;
        trie2.dataLength = uTrie2Header.shiftedDataLength << 2;
        trie2.index2NullOffset = uTrie2Header.index2NullOffset;
        trie2.dataNullOffset = uTrie2Header.dataNullOffset;
        trie2.highStart = uTrie2Header.shiftedHighStart << 11;
        trie2.highValueIndex = trie2.dataLength - 4;
        if (valueWidth == ValueWidth.BITS_16) {
            trie2.highValueIndex += trie2.indexLength;
        }
        int n2 = trie2.indexLength;
        if (valueWidth == ValueWidth.BITS_16) {
            n2 += trie2.dataLength;
        }
        trie2.index = new char[n2];
        for (n = 0; n < trie2.indexLength; ++n) {
            trie2.index[n] = Trie2.swapChar(bl, dataInputStream.readChar());
        }
        if (valueWidth == ValueWidth.BITS_16) {
            trie2.data16 = trie2.indexLength;
            for (n = 0; n < trie2.dataLength; ++n) {
                trie2.index[trie2.data16 + n] = Trie2.swapChar(bl, dataInputStream.readChar());
            }
        } else {
            trie2.data32 = new int[trie2.dataLength];
            for (n = 0; n < trie2.dataLength; ++n) {
                trie2.data32[n] = Trie2.swapInt(bl, dataInputStream.readInt());
            }
        }
        switch (valueWidth) {
            case BITS_16: {
                trie2.data32 = null;
                trie2.initialValue = trie2.index[trie2.dataNullOffset];
                trie2.errorValue = trie2.index[trie2.data16 + 128];
                break;
            }
            case BITS_32: {
                trie2.data16 = 0;
                trie2.initialValue = trie2.data32[trie2.dataNullOffset];
                trie2.errorValue = trie2.data32[128];
                break;
            }
            default: {
                throw new IllegalArgumentException("UTrie2 serialized format error.");
            }
        }
        return trie2;
    }

    private static int swapShort(boolean bl, int n) {
        return bl ? Short.reverseBytes((short)n) & 0xFFFF : n;
    }

    private static char swapChar(boolean bl, char c) {
        return bl ? (char)Short.reverseBytes((short)c) : c;
    }

    private static int swapInt(boolean bl, int n) {
        return bl ? Integer.reverseBytes(n) : n;
    }

    public static int getVersion(InputStream inputStream2, boolean bl) throws IOException {
        if (!inputStream2.markSupported()) {
            throw new IllegalArgumentException("Input stream must support mark().");
        }
        inputStream2.mark(4);
        byte[] byArray = new byte[4];
        int n = inputStream2.read(byArray);
        inputStream2.reset();
        if (n != byArray.length) {
            return 0;
        }
        if (byArray[0] == 84 && byArray[1] == 114 && byArray[2] == 105 && byArray[3] == 101) {
            return 1;
        }
        if (byArray[0] == 84 && byArray[1] == 114 && byArray[2] == 105 && byArray[3] == 50) {
            return 2;
        }
        if (bl) {
            if (byArray[0] == 101 && byArray[1] == 105 && byArray[2] == 114 && byArray[3] == 84) {
                return 1;
            }
            if (byArray[0] == 50 && byArray[1] == 105 && byArray[2] == 114 && byArray[3] == 84) {
                return 2;
            }
        }
        return 0;
    }

    public abstract int get(int var1);

    public abstract int getFromU16SingleLead(char var1);

    public final boolean equals(Object object) {
        if (!(object instanceof Trie2)) {
            return false;
        }
        Trie2 trie2 = (Trie2)object;
        Iterator<Range> iterator2 = trie2.iterator();
        for (Range range : this) {
            if (!iterator2.hasNext()) {
                return false;
            }
            Range range2 = iterator2.next();
            if (range.equals(range2)) continue;
            return false;
        }
        if (iterator2.hasNext()) {
            return false;
        }
        return this.errorValue == trie2.errorValue && this.initialValue == trie2.initialValue;
    }

    public int hashCode() {
        if (this.fHash == 0) {
            int n = Trie2.initHash();
            for (Range range : this) {
                n = Trie2.hashInt(n, range.hashCode());
            }
            if (n == 0) {
                n = 1;
            }
            this.fHash = n;
        }
        return this.fHash;
    }

    @Override
    public Iterator<Range> iterator() {
        return this.iterator(defaultValueMapper);
    }

    public Iterator<Range> iterator(ValueMapper valueMapper) {
        return new Trie2Iterator(valueMapper);
    }

    public Iterator<Range> iteratorForLeadSurrogate(char c, ValueMapper valueMapper) {
        return new Trie2Iterator(c, valueMapper);
    }

    public Iterator<Range> iteratorForLeadSurrogate(char c) {
        return new Trie2Iterator(c, defaultValueMapper);
    }

    protected int serializeHeader(DataOutputStream dataOutputStream) throws IOException {
        int n = 0;
        dataOutputStream.writeInt(this.header.signature);
        dataOutputStream.writeShort(this.header.options);
        dataOutputStream.writeShort(this.header.indexLength);
        dataOutputStream.writeShort(this.header.shiftedDataLength);
        dataOutputStream.writeShort(this.header.index2NullOffset);
        dataOutputStream.writeShort(this.header.dataNullOffset);
        dataOutputStream.writeShort(this.header.shiftedHighStart);
        n += 16;
        for (int i = 0; i < this.header.indexLength; ++i) {
            dataOutputStream.writeChar(this.index[i]);
        }
        return n += this.header.indexLength;
    }

    public CharSequenceIterator charSequenceIterator(CharSequence charSequence, int n) {
        return new CharSequenceIterator(charSequence, n);
    }

    int rangeEnd(int n, int n2, int n3) {
        int n4;
        int n5 = Math.min(this.highStart, n2);
        for (n4 = n + 1; n4 < n5 && this.get(n4) == n3; ++n4) {
        }
        if (n4 >= this.highStart) {
            n4 = n2;
        }
        return n4 - 1;
    }

    private static int initHash() {
        return -2128831035;
    }

    private static int hashByte(int n, int n2) {
        n *= 16777619;
        return n ^= n2;
    }

    private static int hashUChar32(int n, int n2) {
        n = Trie2.hashByte(n, n2 & 0xFF);
        n = Trie2.hashByte(n, n2 >> 8 & 0xFF);
        n = Trie2.hashByte(n, n2 >> 16);
        return n;
    }

    private static int hashInt(int n, int n2) {
        n = Trie2.hashByte(n, n2 & 0xFF);
        n = Trie2.hashByte(n, n2 >> 8 & 0xFF);
        n = Trie2.hashByte(n, n2 >> 16 & 0xFF);
        n = Trie2.hashByte(n, n2 >> 24 & 0xFF);
        return n;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public class Trie2Iterator
    implements Iterator<Range> {
        private ValueMapper mapper;
        private Range returnValue = new Range();
        private int nextStart;
        private int limitCP;
        private boolean doingCodePoints = true;
        private boolean doLeadSurrogates = true;

        Trie2Iterator(ValueMapper valueMapper) {
            this.mapper = valueMapper;
            this.nextStart = 0;
            this.limitCP = 0x110000;
            this.doLeadSurrogates = true;
        }

        Trie2Iterator(char c, ValueMapper valueMapper) {
            if (c < '\ud800' || c > '\udbff') {
                throw new IllegalArgumentException("Bad lead surrogate value.");
            }
            this.mapper = valueMapper;
            this.nextStart = c - 55232 << 10;
            this.limitCP = this.nextStart + 1024;
            this.doLeadSurrogates = false;
        }

        @Override
        public Range next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.nextStart >= this.limitCP) {
                this.doingCodePoints = false;
                this.nextStart = 55296;
            }
            int n = 0;
            int n2 = 0;
            int n3 = 0;
            if (this.doingCodePoints) {
                n2 = Trie2.this.get(this.nextStart);
                n3 = this.mapper.map(n2);
                n = Trie2.this.rangeEnd(this.nextStart, this.limitCP, n2);
                while (n < this.limitCP - 1 && this.mapper.map(n2 = Trie2.this.get(n + 1)) == n3) {
                    n = Trie2.this.rangeEnd(n + 1, this.limitCP, n2);
                }
            } else {
                n2 = Trie2.this.getFromU16SingleLead((char)this.nextStart);
                n3 = this.mapper.map(n2);
                n = this.rangeEndLS((char)this.nextStart);
                while (n < 56319 && this.mapper.map(n2 = Trie2.this.getFromU16SingleLead((char)(n + 1))) == n3) {
                    n = this.rangeEndLS((char)(n + 1));
                }
            }
            this.returnValue.startCodePoint = this.nextStart;
            this.returnValue.endCodePoint = n;
            this.returnValue.value = n3;
            this.returnValue.leadSurrogate = !this.doingCodePoints;
            this.nextStart = n + 1;
            return this.returnValue;
        }

        @Override
        public boolean hasNext() {
            return this.doingCodePoints && (this.doLeadSurrogates || this.nextStart < this.limitCP) || this.nextStart < 56320;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private int rangeEndLS(char c) {
            int n;
            if (c >= '\udbff') {
                return 56319;
            }
            int n2 = Trie2.this.getFromU16SingleLead(c);
            for (n = c + '\u0001'; n <= 56319 && Trie2.this.getFromU16SingleLead((char)n) == n2; ++n) {
            }
            return n - 1;
        }
    }

    public static class UTrie2Header {
        int signature;
        int options;
        int indexLength;
        int shiftedDataLength;
        int index2NullOffset;
        int dataNullOffset;
        int shiftedHighStart;

        UTrie2Header() {
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum ValueWidth {
        BITS_16,
        BITS_32;

    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public class CharSequenceIterator
    implements Iterator<CharSequenceValues> {
        private CharSequence text;
        private int textLength;
        private int index;
        private CharSequenceValues fResults = new CharSequenceValues();

        CharSequenceIterator(CharSequence charSequence, int n) {
            this.text = charSequence;
            this.textLength = this.text.length();
            this.set(n);
        }

        public void set(int n) {
            if (n < 0 || n > this.textLength) {
                throw new IndexOutOfBoundsException();
            }
            this.index = n;
        }

        @Override
        public final boolean hasNext() {
            return this.index < this.textLength;
        }

        public final boolean hasPrevious() {
            return this.index > 0;
        }

        @Override
        public CharSequenceValues next() {
            int n = Character.codePointAt(this.text, this.index);
            int n2 = Trie2.this.get(n);
            this.fResults.index = this.index++;
            this.fResults.codePoint = n;
            this.fResults.value = n2;
            if (n >= 65536) {
                ++this.index;
            }
            return this.fResults;
        }

        public CharSequenceValues previous() {
            int n = Character.codePointBefore(this.text, this.index);
            int n2 = Trie2.this.get(n);
            --this.index;
            if (n >= 65536) {
                --this.index;
            }
            this.fResults.index = this.index;
            this.fResults.codePoint = n;
            this.fResults.value = n2;
            return this.fResults;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Trie2.CharSequenceIterator does not support remove().");
        }
    }

    public static class CharSequenceValues {
        public int index;
        public int codePoint;
        public int value;
    }

    public static interface ValueMapper {
        public int map(int var1);
    }

    public static class Range {
        public int startCodePoint;
        public int endCodePoint;
        public int value;
        public boolean leadSurrogate;

        public boolean equals(Object object) {
            if (object == null || !object.getClass().equals(this.getClass())) {
                return false;
            }
            Range range = (Range)object;
            return this.startCodePoint == range.startCodePoint && this.endCodePoint == range.endCodePoint && this.value == range.value && this.leadSurrogate == range.leadSurrogate;
        }

        public int hashCode() {
            int n = Trie2.initHash();
            n = Trie2.hashUChar32(n, this.startCodePoint);
            n = Trie2.hashUChar32(n, this.endCodePoint);
            n = Trie2.hashInt(n, this.value);
            n = Trie2.hashByte(n, this.leadSurrogate ? 1 : 0);
            return n;
        }
    }
}

