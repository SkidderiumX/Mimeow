/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import java.io.Serializable;
import java.security.MessageDigest;
import javax.annotation.Nullable;

@Beta
public abstract class HashCode {
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    HashCode() {
    }

    public abstract int bits();

    public abstract int asInt();

    public abstract long asLong();

    public abstract long padToLong();

    public abstract byte[] asBytes();

    public int writeBytesTo(byte[] byArray, int n, int n2) {
        n2 = Ints.min(n2, this.bits() / 8);
        Preconditions.checkPositionIndexes(n, n + n2, byArray.length);
        this.writeBytesToImpl(byArray, n, n2);
        return n2;
    }

    abstract void writeBytesToImpl(byte[] var1, int var2, int var3);

    byte[] getBytesInternal() {
        return this.asBytes();
    }

    public static HashCode fromInt(int n) {
        return new IntHashCode(n);
    }

    public static HashCode fromLong(long l) {
        return new LongHashCode(l);
    }

    public static HashCode fromBytes(byte[] byArray) {
        Preconditions.checkArgument(byArray.length >= 1, "A HashCode must contain at least 1 byte.");
        return HashCode.fromBytesNoCopy((byte[])byArray.clone());
    }

    static HashCode fromBytesNoCopy(byte[] byArray) {
        return new BytesHashCode(byArray);
    }

    public static HashCode fromString(String string) {
        Preconditions.checkArgument(string.length() >= 2, "input string (%s) must have at least 2 characters", string);
        Preconditions.checkArgument(string.length() % 2 == 0, "input string (%s) must have an even number of characters", string);
        byte[] byArray = new byte[string.length() / 2];
        for (int i = 0; i < string.length(); i += 2) {
            int n = HashCode.decode(string.charAt(i)) << 4;
            int n2 = HashCode.decode(string.charAt(i + 1));
            byArray[i / 2] = (byte)(n + n2);
        }
        return HashCode.fromBytesNoCopy(byArray);
    }

    private static int decode(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f') {
            return c - 97 + 10;
        }
        throw new IllegalArgumentException("Illegal hexadecimal character: " + c);
    }

    public final boolean equals(@Nullable Object object) {
        if (object instanceof HashCode) {
            HashCode hashCode = (HashCode)object;
            return MessageDigest.isEqual(this.asBytes(), hashCode.asBytes());
        }
        return false;
    }

    public final int hashCode() {
        if (this.bits() >= 32) {
            return this.asInt();
        }
        byte[] byArray = this.asBytes();
        int n = byArray[0] & 0xFF;
        for (int i = 1; i < byArray.length; ++i) {
            n |= (byArray[i] & 0xFF) << i * 8;
        }
        return n;
    }

    public final String toString() {
        byte[] byArray = this.asBytes();
        StringBuilder stringBuilder = new StringBuilder(2 * byArray.length);
        for (byte by : byArray) {
            stringBuilder.append(hexDigits[by >> 4 & 0xF]).append(hexDigits[by & 0xF]);
        }
        return stringBuilder.toString();
    }

    private static final class BytesHashCode
    extends HashCode
    implements Serializable {
        final byte[] bytes;
        private static final long serialVersionUID = 0L;

        BytesHashCode(byte[] byArray) {
            this.bytes = Preconditions.checkNotNull(byArray);
        }

        @Override
        public int bits() {
            return this.bytes.length * 8;
        }

        @Override
        public byte[] asBytes() {
            return (byte[])this.bytes.clone();
        }

        @Override
        public int asInt() {
            Preconditions.checkState(this.bytes.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", this.bytes.length);
            return this.bytes[0] & 0xFF | (this.bytes[1] & 0xFF) << 8 | (this.bytes[2] & 0xFF) << 16 | (this.bytes[3] & 0xFF) << 24;
        }

        @Override
        public long asLong() {
            Preconditions.checkState(this.bytes.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", this.bytes.length);
            return this.padToLong();
        }

        @Override
        public long padToLong() {
            long l = this.bytes[0] & 0xFF;
            for (int i = 1; i < Math.min(this.bytes.length, 8); ++i) {
                l |= ((long)this.bytes[i] & 0xFFL) << i * 8;
            }
            return l;
        }

        @Override
        void writeBytesToImpl(byte[] byArray, int n, int n2) {
            System.arraycopy(this.bytes, 0, byArray, n, n2);
        }

        @Override
        byte[] getBytesInternal() {
            return this.bytes;
        }
    }

    private static final class LongHashCode
    extends HashCode
    implements Serializable {
        final long hash;
        private static final long serialVersionUID = 0L;

        LongHashCode(long l) {
            this.hash = l;
        }

        @Override
        public int bits() {
            return 64;
        }

        @Override
        public byte[] asBytes() {
            return new byte[]{(byte)this.hash, (byte)(this.hash >> 8), (byte)(this.hash >> 16), (byte)(this.hash >> 24), (byte)(this.hash >> 32), (byte)(this.hash >> 40), (byte)(this.hash >> 48), (byte)(this.hash >> 56)};
        }

        @Override
        public int asInt() {
            return (int)this.hash;
        }

        @Override
        public long asLong() {
            return this.hash;
        }

        @Override
        public long padToLong() {
            return this.hash;
        }

        @Override
        void writeBytesToImpl(byte[] byArray, int n, int n2) {
            for (int i = 0; i < n2; ++i) {
                byArray[n + i] = (byte)(this.hash >> i * 8);
            }
        }
    }

    private static final class IntHashCode
    extends HashCode
    implements Serializable {
        final int hash;
        private static final long serialVersionUID = 0L;

        IntHashCode(int n) {
            this.hash = n;
        }

        @Override
        public int bits() {
            return 32;
        }

        @Override
        public byte[] asBytes() {
            return new byte[]{(byte)this.hash, (byte)(this.hash >> 8), (byte)(this.hash >> 16), (byte)(this.hash >> 24)};
        }

        @Override
        public int asInt() {
            return this.hash;
        }

        @Override
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override
        public long padToLong() {
            return UnsignedInts.toLong(this.hash);
        }

        @Override
        void writeBytesToImpl(byte[] byArray, int n, int n2) {
            for (int i = 0; i < n2; ++i) {
                byArray[n + i] = (byte)(this.hash >> i * 8);
            }
        }
    }
}

