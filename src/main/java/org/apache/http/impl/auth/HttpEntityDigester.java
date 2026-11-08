/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.auth;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

public class HttpEntityDigester
extends OutputStream {
    private final MessageDigest digester;
    private boolean closed;
    private byte[] digest;

    HttpEntityDigester(MessageDigest messageDigest) {
        this.digester = messageDigest;
        this.digester.reset();
    }

    public void write(int n) throws IOException {
        if (this.closed) {
            throw new IOException("Stream has been already closed");
        }
        this.digester.update((byte)n);
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        if (this.closed) {
            throw new IOException("Stream has been already closed");
        }
        this.digester.update(byArray, n, n2);
    }

    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.digest = this.digester.digest();
        super.close();
    }

    public byte[] getDigest() {
        return this.digest;
    }
}

