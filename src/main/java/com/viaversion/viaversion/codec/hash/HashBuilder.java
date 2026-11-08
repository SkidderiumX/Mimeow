/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.codec.hash;

import com.viaversion.viaversion.codec.hash.HashFunction;
import java.util.Arrays;

public class HashBuilder {
    private static final byte[] EMPTY_BYTES = new byte[0];
    private static final int MAX_RETAINED_CAPACITY = 4096;
    private final HashFunction hashFunction;
    private byte[] bytes = EMPTY_BYTES;
    private int index;
    private boolean direct;

    public HashBuilder(HashFunction hashFunction) {
        this.hashFunction = hashFunction;
    }

    public HashBuilder writeByte(byte by) {
        this.ensureSize(1);
        this.bytes[this.index++] = by;
        return this;
    }

    public HashBuilder writeBytes(byte[] byArray) {
        this.ensureSize(byArray.length);
        System.arraycopy(byArray, 0, this.bytes, this.index, byArray.length);
        this.index += byArray.length;
        return this;
    }

    public void writeBytesDirect(byte[] byArray) {
        if (this.bytes.length == 0) {
            this.bytes = byArray;
            this.index = byArray.length;
            this.direct = true;
        } else {
            this.writeBytes(byArray);
        }
    }

    public HashBuilder writeBoolean(boolean bl) {
        this.ensureSize(1);
        this.bytes[this.index++] = (byte)(bl ? 1 : 0);
        return this;
    }

    public HashBuilder writeShort(short s) {
        this.ensureSize(2);
        this.bytes[this.index++] = (byte)s;
        this.bytes[this.index++] = (byte)(s >> 8);
        return this;
    }

    public HashBuilder writeChar(char c) {
        this.ensureSize(2);
        this.bytes[this.index++] = (byte)c;
        this.bytes[this.index++] = (byte)(c >> 8);
        return this;
    }

    public HashBuilder writeString(CharSequence charSequence) {
        int n = charSequence.length();
        this.ensureSize(n * 2);
        for (int i = 0; i < n; ++i) {
            char c = charSequence.charAt(i);
            this.bytes[this.index++] = (byte)c;
            this.bytes[this.index++] = (byte)(c >> 8);
        }
        return this;
    }

    public HashBuilder writeInt(int n) {
        this.ensureSize(4);
        this.bytes[this.index++] = (byte)n;
        this.bytes[this.index++] = (byte)(n >> 8);
        this.bytes[this.index++] = (byte)(n >> 16);
        this.bytes[this.index++] = (byte)(n >> 24);
        return this;
    }

    public HashBuilder writeLong(long l) {
        this.ensureSize(8);
        this.bytes[this.index++] = (byte)l;
        this.bytes[this.index++] = (byte)(l >> 8);
        this.bytes[this.index++] = (byte)(l >> 16);
        this.bytes[this.index++] = (byte)(l >> 24);
        this.bytes[this.index++] = (byte)(l >> 32);
        this.bytes[this.index++] = (byte)(l >> 40);
        this.bytes[this.index++] = (byte)(l >> 48);
        this.bytes[this.index++] = (byte)(l >> 56);
        return this;
    }

    public HashBuilder writeFloat(float f) {
        this.writeInt(Float.floatToIntBits(f));
        return this;
    }

    public HashBuilder writeDouble(double d) {
        this.writeLong(Double.doubleToLongBits(d));
        return this;
    }

    public HashBuilder preSize(int n) {
        if (this.bytes.length == 0) {
            this.bytes = new byte[n];
        } else {
            this.ensureSize(n);
        }
        return this;
    }

    private void ensureSize(int n) {
        int n2 = this.index + n;
        int n3 = this.bytes.length;
        if (n2 > n3) {
            int n4 = Math.max(n3 * 2, n2);
            this.bytes = Arrays.copyOf(this.bytes, n4);
            this.direct = false;
        }
    }

    public int hash() {
        return this.hashFunction.hashBytes(this.bytes, this.index);
    }

    public void reset() {
        this.index = 0;
        if (this.direct || this.bytes.length > 4096) {
            this.bytes = EMPTY_BYTES;
            this.direct = false;
        }
    }

    public HashFunction function() {
        return this.hashFunction;
    }
}

