/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;

@NotThreadSafe
public class ContentLengthOutputStream
extends OutputStream {
    private final SessionOutputBuffer out;
    private final long contentLength;
    private long total = 0L;
    private boolean closed = false;

    public ContentLengthOutputStream(SessionOutputBuffer sessionOutputBuffer, long l) {
        this.out = Args.notNull(sessionOutputBuffer, "Session output buffer");
        this.contentLength = Args.notNegative(l, "Content length");
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.out.flush();
        }
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        if (this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        if (this.total < this.contentLength) {
            int n3 = n2;
            long l = this.contentLength - this.total;
            if ((long)n3 > l) {
                n3 = (int)l;
            }
            this.out.write(byArray, n, n3);
            this.total += (long)n3;
        }
    }

    public void write(byte[] byArray) throws IOException {
        this.write(byArray, 0, byArray.length);
    }

    public void write(int n) throws IOException {
        if (this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        if (this.total < this.contentLength) {
            this.out.write(n);
            ++this.total;
        }
    }
}

