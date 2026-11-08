/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

@Beta
public class CountingInputStream
extends FilterInputStream {
    private long count;
    private long mark = -1L;

    public CountingInputStream(@Nullable InputStream inputStream2) {
        super(inputStream2);
    }

    public long getCount() {
        return this.count;
    }

    @Override
    public int read() throws IOException {
        int n = this.in.read();
        if (n != -1) {
            ++this.count;
        }
        return n;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3 = this.in.read(byArray, n, n2);
        if (n3 != -1) {
            this.count += (long)n3;
        }
        return n3;
    }

    @Override
    public long skip(long l) throws IOException {
        long l2 = this.in.skip(l);
        this.count += l2;
        return l2;
    }

    @Override
    public synchronized void mark(int n) {
        this.in.mark(n);
        this.mark = this.count;
    }

    @Override
    public synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.mark == -1L) {
            throw new IOException("Mark not set");
        }
        this.in.reset();
        this.count = this.mark;
    }
}

