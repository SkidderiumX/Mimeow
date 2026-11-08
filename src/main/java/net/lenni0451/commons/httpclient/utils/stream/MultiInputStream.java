/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.utils.stream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import javax.annotation.Nonnull;
import lombok.Generated;

public class MultiInputStream
extends InputStream {
    private final Queue<InputStream> streams;

    @Override
    public int read() throws IOException {
        if (this.streams.isEmpty()) {
            return -1;
        }
        int n = this.streams.peek().read();
        if (n == -1) {
            this.streams.poll().close();
            return this.read();
        }
        return n;
    }

    @Override
    public int read(@Nonnull byte[] byArray, int n, int n2) throws IOException {
        if (this.streams.isEmpty()) {
            return -1;
        }
        int n3 = this.streams.peek().read(byArray, n, n2);
        if (n3 == -1) {
            this.streams.poll().close();
            return this.read(byArray, n, n2);
        }
        return n3;
    }

    @Override
    public void close() throws IOException {
        while (!this.streams.isEmpty()) {
            this.streams.poll().close();
        }
    }

    @Generated
    public MultiInputStream(Queue<InputStream> queue) {
        this.streams = queue;
    }
}

