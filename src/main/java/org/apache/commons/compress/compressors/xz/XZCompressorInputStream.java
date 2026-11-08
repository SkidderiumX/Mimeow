/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.compress.compressors.xz;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZInputStream;

public class XZCompressorInputStream
extends CompressorInputStream {
    private final InputStream in;

    public static boolean matches(byte[] byArray, int n) {
        if (n < XZ.HEADER_MAGIC.length) {
            return false;
        }
        for (int i = 0; i < XZ.HEADER_MAGIC.length; ++i) {
            if (byArray[i] == XZ.HEADER_MAGIC[i]) continue;
            return false;
        }
        return true;
    }

    public XZCompressorInputStream(InputStream inputStream2) throws IOException {
        this(inputStream2, false);
    }

    public XZCompressorInputStream(InputStream inputStream2, boolean bl) throws IOException {
        this.in = bl ? new XZInputStream(inputStream2) : new SingleXZInputStream(inputStream2);
    }

    public int read() throws IOException {
        int n = this.in.read();
        this.count(n == -1 ? -1 : 1);
        return n;
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3 = this.in.read(byArray, n, n2);
        this.count(n3);
        return n3;
    }

    public long skip(long l) throws IOException {
        return this.in.skip(l);
    }

    public int available() throws IOException {
        return this.in.available();
    }

    public void close() throws IOException {
        this.in.close();
    }
}

