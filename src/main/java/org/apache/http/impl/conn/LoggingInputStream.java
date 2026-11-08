/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.conn.Wire;

@NotThreadSafe
public class LoggingInputStream
extends InputStream {
    private final InputStream in;
    private final Wire wire;

    public LoggingInputStream(InputStream inputStream2, Wire wire) {
        this.in = inputStream2;
        this.wire = wire;
    }

    public int read() throws IOException {
        try {
            int n = this.in.read();
            if (n == -1) {
                this.wire.input("end of stream");
            } else {
                this.wire.input(n);
            }
            return n;
        }
        catch (IOException iOException) {
            this.wire.input("[read] I/O error: " + iOException.getMessage());
            throw iOException;
        }
    }

    public int read(byte[] byArray) throws IOException {
        try {
            int n = this.in.read(byArray);
            if (n == -1) {
                this.wire.input("end of stream");
            } else if (n > 0) {
                this.wire.input(byArray, 0, n);
            }
            return n;
        }
        catch (IOException iOException) {
            this.wire.input("[read] I/O error: " + iOException.getMessage());
            throw iOException;
        }
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        try {
            int n3 = this.in.read(byArray, n, n2);
            if (n3 == -1) {
                this.wire.input("end of stream");
            } else if (n3 > 0) {
                this.wire.input(byArray, n, n3);
            }
            return n3;
        }
        catch (IOException iOException) {
            this.wire.input("[read] I/O error: " + iOException.getMessage());
            throw iOException;
        }
    }

    public long skip(long l) throws IOException {
        try {
            return super.skip(l);
        }
        catch (IOException iOException) {
            this.wire.input("[skip] I/O error: " + iOException.getMessage());
            throw iOException;
        }
    }

    public int available() throws IOException {
        try {
            return this.in.available();
        }
        catch (IOException iOException) {
            this.wire.input("[available] I/O error : " + iOException.getMessage());
            throw iOException;
        }
    }

    public void mark(int n) {
        super.mark(n);
    }

    public void reset() throws IOException {
        super.reset();
    }

    public boolean markSupported() {
        return false;
    }

    public void close() throws IOException {
        try {
            this.in.close();
        }
        catch (IOException iOException) {
            this.wire.input("[close] I/O error: " + iOException.getMessage());
            throw iOException;
        }
    }
}

