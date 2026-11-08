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
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public abstract class AbstractStreamingHashFunction
implements HashFunction {
    AbstractStreamingHashFunction() {
    }

    @Override
    public <T> HashCode hashObject(T t, Funnel<? super T> funnel) {
        return this.newHasher().putObject(t, funnel).hash();
    }

    @Override
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        return this.newHasher().putUnencodedChars(charSequence).hash();
    }

    @Override
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return this.newHasher().putString(charSequence, charset).hash();
    }

    @Override
    public HashCode hashInt(int n) {
        return this.newHasher().putInt(n).hash();
    }

    @Override
    public HashCode hashLong(long l) {
        return this.newHasher().putLong(l).hash();
    }

    @Override
    public HashCode hashBytes(byte[] byArray) {
        return this.newHasher().putBytes(byArray).hash();
    }

    @Override
    public HashCode hashBytes(byte[] byArray, int n, int n2) {
        return this.newHasher().putBytes(byArray, n, n2).hash();
    }

    @Override
    public Hasher newHasher(int n) {
        Preconditions.checkArgument(n >= 0);
        return this.newHasher();
    }

    protected static abstract class AbstractStreamingHasher
    extends AbstractHasher {
        private final ByteBuffer buffer;
        private final int bufferSize;
        private final int chunkSize;

        protected AbstractStreamingHasher(int n) {
            this(n, n);
        }

        protected AbstractStreamingHasher(int n, int n2) {
            Preconditions.checkArgument(n2 % n == 0);
            this.buffer = ByteBuffer.allocate(n2 + 7).order(ByteOrder.LITTLE_ENDIAN);
            this.bufferSize = n2;
            this.chunkSize = n;
        }

        protected abstract void process(ByteBuffer var1);

        protected void processRemaining(ByteBuffer byteBuffer) {
            byteBuffer.position(byteBuffer.limit());
            byteBuffer.limit(this.chunkSize + 7);
            while (byteBuffer.position() < this.chunkSize) {
                byteBuffer.putLong(0L);
            }
            byteBuffer.limit(this.chunkSize);
            byteBuffer.flip();
            this.process(byteBuffer);
        }

        @Override
        public final Hasher putBytes(byte[] byArray) {
            return this.putBytes(byArray, 0, byArray.length);
        }

        @Override
        public final Hasher putBytes(byte[] byArray, int n, int n2) {
            return this.putBytes(ByteBuffer.wrap(byArray, n, n2).order(ByteOrder.LITTLE_ENDIAN));
        }

        private Hasher putBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() <= this.buffer.remaining()) {
                this.buffer.put(byteBuffer);
                this.munchIfFull();
                return this;
            }
            int n = this.bufferSize - this.buffer.position();
            for (int i = 0; i < n; ++i) {
                this.buffer.put(byteBuffer.get());
            }
            this.munch();
            while (byteBuffer.remaining() >= this.chunkSize) {
                this.process(byteBuffer);
            }
            this.buffer.put(byteBuffer);
            return this;
        }

        @Override
        public final Hasher putUnencodedChars(CharSequence charSequence) {
            for (int i = 0; i < charSequence.length(); ++i) {
                this.putChar(charSequence.charAt(i));
            }
            return this;
        }

        @Override
        public final Hasher putByte(byte by) {
            this.buffer.put(by);
            this.munchIfFull();
            return this;
        }

        @Override
        public final Hasher putShort(short s) {
            this.buffer.putShort(s);
            this.munchIfFull();
            return this;
        }

        @Override
        public final Hasher putChar(char c) {
            this.buffer.putChar(c);
            this.munchIfFull();
            return this;
        }

        @Override
        public final Hasher putInt(int n) {
            this.buffer.putInt(n);
            this.munchIfFull();
            return this;
        }

        @Override
        public final Hasher putLong(long l) {
            this.buffer.putLong(l);
            this.munchIfFull();
            return this;
        }

        @Override
        public final <T> Hasher putObject(T t, Funnel<? super T> funnel) {
            funnel.funnel(t, this);
            return this;
        }

        @Override
        public final HashCode hash() {
            this.munch();
            this.buffer.flip();
            if (this.buffer.remaining() > 0) {
                this.processRemaining(this.buffer);
            }
            return this.makeHash();
        }

        abstract HashCode makeHash();

        private void munchIfFull() {
            if (this.buffer.remaining() < 8) {
                this.munch();
            }
        }

        private void munch() {
            this.buffer.flip();
            while (this.buffer.remaining() >= this.chunkSize) {
                this.process(this.buffer);
            }
            this.buffer.compact();
        }
    }
}

