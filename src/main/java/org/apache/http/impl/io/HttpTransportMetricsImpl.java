/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.io;

import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.HttpTransportMetrics;

@NotThreadSafe
public class HttpTransportMetricsImpl
implements HttpTransportMetrics {
    private long bytesTransferred = 0L;

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void setBytesTransferred(long l) {
        this.bytesTransferred = l;
    }

    public void incrementBytesTransferred(long l) {
        this.bytesTransferred += l;
    }

    public void reset() {
        this.bytesTransferred = 0L;
    }
}

