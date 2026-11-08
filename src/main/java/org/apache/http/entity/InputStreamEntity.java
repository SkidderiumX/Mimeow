/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

@NotThreadSafe
public class InputStreamEntity
extends AbstractHttpEntity {
    private final InputStream content;
    private final long length;

    public InputStreamEntity(InputStream inputStream2) {
        this(inputStream2, -1L);
    }

    public InputStreamEntity(InputStream inputStream2, long l) {
        this(inputStream2, l, null);
    }

    public InputStreamEntity(InputStream inputStream2, ContentType contentType) {
        this(inputStream2, -1L, contentType);
    }

    public InputStreamEntity(InputStream inputStream2, long l, ContentType contentType) {
        this.content = Args.notNull(inputStream2, "Source input stream");
        this.length = l;
        if (contentType != null) {
            this.setContentType(contentType.toString());
        }
    }

    public boolean isRepeatable() {
        return false;
    }

    public long getContentLength() {
        return this.length;
    }

    public InputStream getContent() throws IOException {
        return this.content;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeTo(OutputStream outputStream2) throws IOException {
        block7: {
            Args.notNull(outputStream2, "Output stream");
            InputStream inputStream2 = this.content;
            try {
                int n;
                byte[] byArray = new byte[4096];
                if (this.length < 0L) {
                    int n2;
                    while ((n2 = inputStream2.read(byArray)) != -1) {
                        outputStream2.write(byArray, 0, n2);
                    }
                    break block7;
                }
                for (long i = this.length; i > 0L; i -= (long)n) {
                    n = inputStream2.read(byArray, 0, (int)Math.min(4096L, i));
                    if (n == -1) {
                        break;
                    }
                    outputStream2.write(byArray, 0, n);
                }
            }
            finally {
                inputStream2.close();
            }
        }
    }

    public boolean isStreaming() {
        return true;
    }
}

