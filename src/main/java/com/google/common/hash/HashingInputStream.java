/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
public class HashingInputStream
extends FilterInputStream {
    private final Hasher hasher;

    public HashingInputStream(HashFunction hashFunction, InputStream inputStream2) {
        super(Preconditions.checkNotNull(inputStream2));
        this.hasher = Preconditions.checkNotNull(hashFunction.newHasher());
    }

    @Override
    public int read() throws IOException {
        int n = this.in.read();
        if (n != -1) {
            this.hasher.putByte((byte)n);
        }
        return n;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3 = this.in.read(byArray, n, n2);
        if (n3 != -1) {
            this.hasher.putBytes(byArray, n, n3);
        }
        return n3;
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public void mark(int n) {
    }

    @Override
    public void reset() throws IOException {
        throw new IOException("reset not supported");
    }

    public HashCode hash() {
        return this.hasher.hash();
    }
}

