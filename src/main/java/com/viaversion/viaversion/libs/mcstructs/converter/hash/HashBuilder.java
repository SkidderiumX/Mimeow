/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.hash;

import com.viaversion.viaversion.libs.mcstructs.converter.hash.HashCode;
import com.viaversion.viaversion.libs.mcstructs.converter.hash.HashFunction;
import java.util.Arrays;

public class HashBuilder {
    private final HashFunction hashFunction;
    private byte[] bytes;
    private int index = 0;

    public HashBuilder(HashFunction hashFunction) {
        this(hashFunction, 16);
    }

    public HashBuilder(HashFunction hashFunction, int n) {
        this.hashFunction = hashFunction;
        this.bytes = new byte[n];
    }

    public HashBuilder addByte(byte by) {
        this.ensureSize(1);
        this.bytes[this.index++] = by;
        return this;
    }

    public HashBuilder addBytes(byte[] byArray) {
        this.ensureSize(byArray.length);
        System.arraycopy(byArray, 0, this.bytes, this.index, byArray.length);
        this.index += byArray.length;
        return this;
    }

    public HashBuilder addShort(short s) {
        this.ensureSize(2);
        this.bytes[this.index++] = (byte)s;
        this.bytes[this.index++] = (byte)(s >> 8);
        return this;
    }

    public HashBuilder addChar(char c) {
        this.ensureSize(2);
        this.bytes[this.index++] = (byte)c;
        this.bytes[this.index++] = (byte)(c >> 8);
        return this;
    }

    public HashBuilder addCharSequence(CharSequence charSequence) {
        this.ensureSize(charSequence.length());
        for (int i = 0; i < charSequence.length(); ++i) {
            this.addChar(charSequence.charAt(i));
        }
        return this;
    }

    public HashBuilder addInt(int n) {
        this.ensureSize(4);
        this.bytes[this.index++] = (byte)n;
        this.bytes[this.index++] = (byte)(n >> 8);
        this.bytes[this.index++] = (byte)(n >> 16);
        this.bytes[this.index++] = (byte)(n >> 24);
        return this;
    }

    public HashBuilder addLong(long l) {
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

    public HashBuilder addFloat(float f) {
        return this.addInt(Float.floatToIntBits(f));
    }

    public HashBuilder addDouble(double d) {
        return this.addLong(Double.doubleToLongBits(d));
    }

    public HashCode hash() {
        return this.hashFunction.hash(Arrays.copyOf(this.bytes, this.index));
    }

    private void ensureSize(int n) {
        if (this.index + n > this.bytes.length) {
            this.bytes = Arrays.copyOf(this.bytes, this.bytes.length * 2 + n);
        }
    }
}

