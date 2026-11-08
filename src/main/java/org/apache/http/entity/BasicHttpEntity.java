/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@NotThreadSafe
public class BasicHttpEntity
extends AbstractHttpEntity {
    private InputStream content;
    private long length = -1L;

    public long getContentLength() {
        return this.length;
    }

    public InputStream getContent() throws IllegalStateException {
        Asserts.check(this.content != null, "Content has not been provided");
        return this.content;
    }

    public boolean isRepeatable() {
        return false;
    }

    public void setContentLength(long l) {
        this.length = l;
    }

    public void setContent(InputStream inputStream2) {
        this.content = inputStream2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeTo(OutputStream outputStream2) throws IOException {
        Args.notNull(outputStream2, "Output stream");
        InputStream inputStream2 = this.getContent();
        try {
            int n;
            byte[] byArray = new byte[4096];
            while ((n = inputStream2.read(byArray)) != -1) {
                outputStream2.write(byArray, 0, n);
            }
        }
        finally {
            inputStream2.close();
        }
    }

    public boolean isStreaming() {
        return this.content != null;
    }
}

