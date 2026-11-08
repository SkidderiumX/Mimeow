/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.utils.stream;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nonnull;

public class CloseListenerInputStream
extends InputStream {
    private final InputStream inputStream;
    private final CloseListener closeListener;

    public CloseListenerInputStream(InputStream inputStream2, CloseListener closeListener) {
        this.inputStream = inputStream2;
        this.closeListener = closeListener;
    }

    @Override
    public int read() throws IOException {
        return this.inputStream.read();
    }

    @Override
    public int read(@Nonnull byte[] byArray) throws IOException {
        return this.inputStream.read(byArray);
    }

    @Override
    public int read(@Nonnull byte[] byArray, int n, int n2) throws IOException {
        return this.inputStream.read(byArray, n, n2);
    }

    @Override
    public long skip(long l) throws IOException {
        return this.inputStream.skip(l);
    }

    @Override
    public int available() throws IOException {
        return this.inputStream.available();
    }

    @Override
    public void close() throws IOException {
        this.inputStream.close();
        this.closeListener.close();
    }

    @FunctionalInterface
    public static interface CloseListener {
        public void close() throws IOException;
    }
}

