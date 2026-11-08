/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.execchain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import org.apache.http.HttpEntity;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.EofSensorInputStream;
import org.apache.http.conn.EofSensorWatcher;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.execchain.ConnectionHolder;

@NotThreadSafe
public class ResponseEntityWrapper
extends HttpEntityWrapper
implements EofSensorWatcher {
    private final ConnectionHolder connReleaseTrigger;

    public ResponseEntityWrapper(HttpEntity httpEntity, ConnectionHolder connectionHolder) {
        super(httpEntity);
        this.connReleaseTrigger = connectionHolder;
    }

    private void cleanup() {
        if (this.connReleaseTrigger != null) {
            this.connReleaseTrigger.abortConnection();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void releaseConnection() throws IOException {
        if (this.connReleaseTrigger != null) {
            try {
                if (this.connReleaseTrigger.isReusable()) {
                    this.connReleaseTrigger.releaseConnection();
                }
            }
            finally {
                this.cleanup();
            }
        }
    }

    public boolean isRepeatable() {
        return false;
    }

    public InputStream getContent() throws IOException {
        return new EofSensorInputStream(this.wrappedEntity.getContent(), this);
    }

    @Deprecated
    public void consumeContent() throws IOException {
        this.releaseConnection();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeTo(OutputStream outputStream2) throws IOException {
        try {
            this.wrappedEntity.writeTo(outputStream2);
            this.releaseConnection();
        }
        finally {
            this.cleanup();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean eofDetected(InputStream inputStream2) throws IOException {
        try {
            inputStream2.close();
            this.releaseConnection();
        }
        finally {
            this.cleanup();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean streamClosed(InputStream inputStream2) throws IOException {
        try {
            boolean bl = this.connReleaseTrigger != null && !this.connReleaseTrigger.isReleased();
            try {
                inputStream2.close();
                this.releaseConnection();
            }
            catch (SocketException socketException) {
                if (bl) {
                    throw socketException;
                }
            }
        }
        finally {
            this.cleanup();
        }
        return false;
    }

    public boolean streamAbort(InputStream inputStream2) throws IOException {
        this.cleanup();
        return false;
    }
}

