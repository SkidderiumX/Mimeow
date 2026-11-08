/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class DeflateInputStream
extends InputStream {
    private InputStream sourceStream;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DeflateInputStream(InputStream inputStream2) throws IOException {
        byte[] byArray = new byte[6];
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream2, byArray.length);
        int n = pushbackInputStream.read(byArray);
        if (n == -1) {
            throw new IOException("Unable to read the response");
        }
        byte[] byArray2 = new byte[1];
        Inflater inflater = new Inflater();
        try {
            int n2;
            while ((n2 = inflater.inflate(byArray2)) == 0) {
                if (inflater.finished()) {
                    throw new IOException("Unable to read the response");
                }
                if (inflater.needsDictionary()) break;
                if (!inflater.needsInput()) continue;
                inflater.setInput(byArray);
            }
            if (n2 == -1) {
                throw new IOException("Unable to read the response");
            }
            pushbackInputStream.unread(byArray, 0, n);
            this.sourceStream = new DeflateStream(pushbackInputStream, new Inflater());
        }
        catch (DataFormatException dataFormatException) {
            pushbackInputStream.unread(byArray, 0, n);
            this.sourceStream = new DeflateStream(pushbackInputStream, new Inflater(true));
        }
        finally {
            inflater.end();
        }
    }

    public int read() throws IOException {
        return this.sourceStream.read();
    }

    public int read(byte[] byArray) throws IOException {
        return this.sourceStream.read(byArray);
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        return this.sourceStream.read(byArray, n, n2);
    }

    public long skip(long l) throws IOException {
        return this.sourceStream.skip(l);
    }

    public int available() throws IOException {
        return this.sourceStream.available();
    }

    public void mark(int n) {
        this.sourceStream.mark(n);
    }

    public void reset() throws IOException {
        this.sourceStream.reset();
    }

    public boolean markSupported() {
        return this.sourceStream.markSupported();
    }

    public void close() throws IOException {
        this.sourceStream.close();
    }

    public static class DeflateStream
    extends InflaterInputStream {
        private boolean closed = false;

        public DeflateStream(InputStream inputStream2, Inflater inflater) {
            super(inputStream2, inflater);
        }

        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.inf.end();
            super.close();
        }
    }
}

