/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.compress.compressors.xz;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZOutputStream;

public class XZCompressorOutputStream
extends CompressorOutputStream {
    private final XZOutputStream out;

    public XZCompressorOutputStream(OutputStream outputStream2) throws IOException {
        this.out = new XZOutputStream(outputStream2, (FilterOptions)new LZMA2Options());
    }

    public XZCompressorOutputStream(OutputStream outputStream2, int n) throws IOException {
        this.out = new XZOutputStream(outputStream2, (FilterOptions)new LZMA2Options(n));
    }

    public void write(int n) throws IOException {
        this.out.write(n);
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        this.out.write(byArray, n, n2);
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void finish() throws IOException {
        this.out.finish();
    }

    public void close() throws IOException {
        this.out.close();
    }
}

