/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.LazyDecompressingInputStream;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.util.Args;

public abstract class DecompressingEntity
extends HttpEntityWrapper {
    private static final int BUFFER_SIZE = 2048;
    private InputStream content;

    public DecompressingEntity(HttpEntity httpEntity) {
        super(httpEntity);
    }

    abstract InputStream decorate(InputStream var1) throws IOException;

    private InputStream getDecompressingStream() throws IOException {
        InputStream inputStream2 = this.wrappedEntity.getContent();
        return new LazyDecompressingInputStream(inputStream2, this);
    }

    public InputStream getContent() throws IOException {
        if (this.wrappedEntity.isStreaming()) {
            if (this.content == null) {
                this.content = this.getDecompressingStream();
            }
            return this.content;
        }
        return this.getDecompressingStream();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeTo(OutputStream outputStream2) throws IOException {
        Args.notNull(outputStream2, "Output stream");
        InputStream inputStream2 = this.getContent();
        try {
            int n;
            byte[] byArray = new byte[2048];
            while ((n = inputStream2.read(byArray)) != -1) {
                outputStream2.write(byArray, 0, n);
            }
        }
        finally {
            inputStream2.close();
        }
    }
}

