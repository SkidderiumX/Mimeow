/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.entity;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.BasicHeader;

@NotThreadSafe
public abstract class AbstractHttpEntity
implements HttpEntity {
    protected static final int OUTPUT_BUFFER_SIZE = 4096;
    protected Header contentType;
    protected Header contentEncoding;
    protected boolean chunked;

    protected AbstractHttpEntity() {
    }

    public Header getContentType() {
        return this.contentType;
    }

    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public void setContentType(Header header) {
        this.contentType = header;
    }

    public void setContentType(String string) {
        BasicHeader basicHeader = null;
        if (string != null) {
            basicHeader = new BasicHeader("Content-Type", string);
        }
        this.setContentType(basicHeader);
    }

    public void setContentEncoding(Header header) {
        this.contentEncoding = header;
    }

    public void setContentEncoding(String string) {
        BasicHeader basicHeader = null;
        if (string != null) {
            basicHeader = new BasicHeader("Content-Encoding", string);
        }
        this.setContentEncoding(basicHeader);
    }

    public void setChunked(boolean bl) {
        this.chunked = bl;
    }

    @Deprecated
    public void consumeContent() throws IOException {
    }
}

