/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.entity.DecompressingEntity;

@NotThreadSafe
public class LazyDecompressingInputStream
extends InputStream {
    private final InputStream wrappedStream;
    private final DecompressingEntity decompressingEntity;
    private InputStream wrapperStream;

    public LazyDecompressingInputStream(InputStream inputStream2, DecompressingEntity decompressingEntity) {
        this.wrappedStream = inputStream2;
        this.decompressingEntity = decompressingEntity;
    }

    private void initWrapper() throws IOException {
        if (this.wrapperStream == null) {
            this.wrapperStream = this.decompressingEntity.decorate(this.wrappedStream);
        }
    }

    public int read() throws IOException {
        this.initWrapper();
        return this.wrapperStream.read();
    }

    public int read(byte[] byArray) throws IOException {
        this.initWrapper();
        return this.wrapperStream.read(byArray);
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        this.initWrapper();
        return this.wrapperStream.read(byArray, n, n2);
    }

    public long skip(long l) throws IOException {
        this.initWrapper();
        return this.wrapperStream.skip(l);
    }

    public boolean markSupported() {
        return false;
    }

    public int available() throws IOException {
        this.initWrapper();
        return this.wrapperStream.available();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() throws IOException {
        try {
            if (this.wrapperStream != null) {
                this.wrapperStream.close();
            }
        }
        finally {
            this.wrappedStream.close();
        }
    }
}

