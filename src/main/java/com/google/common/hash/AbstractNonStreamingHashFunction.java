/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractHasher;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class AbstractNonStreamingHashFunction
implements HashFunction {
    AbstractNonStreamingHashFunction() {
    }

    @Override
    public Hasher newHasher() {
        return new BufferingHasher(32);
    }

    @Override
    public Hasher newHasher(int n) {
        Preconditions.checkArgument(n >= 0);
        return new BufferingHasher(n);
    }

    @Override
    public <T> HashCode hashObject(T t, Funnel<? super T> funnel) {
        return this.newHasher().putObject(t, funnel).hash();
    }

    @Override
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int n = charSequence.length();
        Hasher hasher = this.newHasher(n * 2);
        for (int i = 0; i < n; ++i) {
            hasher.putChar(charSequence.charAt(i));
        }
        return hasher.hash();
    }

    @Override
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return this.hashBytes(charSequence.toString().getBytes(charset));
    }

    @Override
    public HashCode hashInt(int n) {
        return this.newHasher(4).putInt(n).hash();
    }

    @Override
    public HashCode hashLong(long l) {
        return this.newHasher(8).putLong(l).hash();
    }

    @Override
    public HashCode hashBytes(byte[] byArray) {
        return this.hashBytes(byArray, 0, byArray.length);
    }

    private static final class ExposedByteArrayOutputStream
    extends ByteArrayOutputStream {
        ExposedByteArrayOutputStream(int n) {
            super(n);
        }

        byte[] byteArray() {
            return this.buf;
        }

        int length() {
            return this.count;
        }
    }

    private final class BufferingHasher
    extends AbstractHasher {
        final ExposedByteArrayOutputStream stream;
        static final int BOTTOM_BYTE = 255;

        BufferingHasher(int n) {
            this.stream = new ExposedByteArrayOutputStream(n);
        }

        @Override
        public Hasher putByte(byte by) {
            this.stream.write(by);
            return this;
        }

        @Override
        public Hasher putBytes(byte[] byArray) {
            try {
                this.stream.write(byArray);
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
            return this;
        }

        @Override
        public Hasher putBytes(byte[] byArray, int n, int n2) {
            this.stream.write(byArray, n, n2);
            return this;
        }

        @Override
        public Hasher putShort(short s) {
            this.stream.write(s & 0xFF);
            this.stream.write(s >>> 8 & 0xFF);
            return this;
        }

        @Override
        public Hasher putInt(int n) {
            this.stream.write(n & 0xFF);
            this.stream.write(n >>> 8 & 0xFF);
            this.stream.write(n >>> 16 & 0xFF);
            this.stream.write(n >>> 24 & 0xFF);
            return this;
        }

        @Override
        public Hasher putLong(long l) {
            for (int i = 0; i < 64; i += 8) {
                this.stream.write((byte)(l >>> i & 0xFFL));
            }
            return this;
        }

        @Override
        public Hasher putChar(char c) {
            this.stream.write(c & 0xFF);
            this.stream.write(c >>> 8 & 0xFF);
            return this;
        }

        @Override
        public <T> Hasher putObject(T t, Funnel<? super T> funnel) {
            funnel.funnel(t, this);
            return this;
        }

        @Override
        public HashCode hash() {
            return AbstractNonStreamingHashFunction.this.hashBytes(this.stream.byteArray(), 0, this.stream.length());
        }
    }
}

