/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;

@Beta
public class CountingOutputStream
extends FilterOutputStream {
    private long count;

    public CountingOutputStream(@Nullable OutputStream outputStream2) {
        super(outputStream2);
    }

    public long getCount() {
        return this.count;
    }

    @Override
    public void write(byte[] byArray, int n, int n2) throws IOException {
        this.out.write(byArray, n, n2);
        this.count += (long)n2;
    }

    @Override
    public void write(int n) throws IOException {
        this.out.write(n);
        ++this.count;
    }

    @Override
    public void close() throws IOException {
        this.out.close();
    }
}

