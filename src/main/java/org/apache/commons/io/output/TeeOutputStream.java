/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.output.ProxyOutputStream;

public class TeeOutputStream
extends ProxyOutputStream {
    protected OutputStream branch;

    public TeeOutputStream(OutputStream outputStream2, OutputStream outputStream3) {
        super(outputStream2);
        this.branch = outputStream3;
    }

    @Override
    public synchronized void write(byte[] byArray) throws IOException {
        super.write(byArray);
        this.branch.write(byArray);
    }

    @Override
    public synchronized void write(byte[] byArray, int n, int n2) throws IOException {
        super.write(byArray, n, n2);
        this.branch.write(byArray, n, n2);
    }

    @Override
    public synchronized void write(int n) throws IOException {
        super.write(n);
        this.branch.write(n);
    }

    @Override
    public void flush() throws IOException {
        super.flush();
        this.branch.flush();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() throws IOException {
        try {
            super.close();
        }
        finally {
            this.branch.close();
        }
    }
}

