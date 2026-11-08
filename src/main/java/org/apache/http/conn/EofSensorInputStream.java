/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.conn.EofSensorWatcher;
import org.apache.http.util.Args;

@NotThreadSafe
public class EofSensorInputStream
extends InputStream
implements ConnectionReleaseTrigger {
    protected InputStream wrappedStream;
    private boolean selfClosed;
    private final EofSensorWatcher eofWatcher;

    public EofSensorInputStream(InputStream inputStream2, EofSensorWatcher eofSensorWatcher) {
        Args.notNull(inputStream2, "Wrapped stream");
        this.wrappedStream = inputStream2;
        this.selfClosed = false;
        this.eofWatcher = eofSensorWatcher;
    }

    boolean isSelfClosed() {
        return this.selfClosed;
    }

    InputStream getWrappedStream() {
        return this.wrappedStream;
    }

    protected boolean isReadAllowed() throws IOException {
        if (this.selfClosed) {
            throw new IOException("Attempted read on closed stream.");
        }
        return this.wrappedStream != null;
    }

    public int read() throws IOException {
        int n = -1;
        if (this.isReadAllowed()) {
            try {
                n = this.wrappedStream.read();
                this.checkEOF(n);
            }
            catch (IOException iOException) {
                this.checkAbort();
                throw iOException;
            }
        }
        return n;
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3 = -1;
        if (this.isReadAllowed()) {
            try {
                n3 = this.wrappedStream.read(byArray, n, n2);
                this.checkEOF(n3);
            }
            catch (IOException iOException) {
                this.checkAbort();
                throw iOException;
            }
        }
        return n3;
    }

    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    public int available() throws IOException {
        int n = 0;
        if (this.isReadAllowed()) {
            try {
                n = this.wrappedStream.available();
            }
            catch (IOException iOException) {
                this.checkAbort();
                throw iOException;
            }
        }
        return n;
    }

    public void close() throws IOException {
        this.selfClosed = true;
        this.checkClose();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void checkEOF(int n) throws IOException {
        if (this.wrappedStream != null && n < 0) {
            try {
                boolean bl = true;
                if (this.eofWatcher != null) {
                    bl = this.eofWatcher.eofDetected(this.wrappedStream);
                }
                if (bl) {
                    this.wrappedStream.close();
                }
            }
            finally {
                this.wrappedStream = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void checkClose() throws IOException {
        if (this.wrappedStream != null) {
            try {
                boolean bl = true;
                if (this.eofWatcher != null) {
                    bl = this.eofWatcher.streamClosed(this.wrappedStream);
                }
                if (bl) {
                    this.wrappedStream.close();
                }
            }
            finally {
                this.wrappedStream = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void checkAbort() throws IOException {
        if (this.wrappedStream != null) {
            try {
                boolean bl = true;
                if (this.eofWatcher != null) {
                    bl = this.eofWatcher.streamAbort(this.wrappedStream);
                }
                if (bl) {
                    this.wrappedStream.close();
                }
            }
            finally {
                this.wrappedStream = null;
            }
        }
    }

    public void releaseConnection() throws IOException {
        this.close();
    }

    public void abortConnection() throws IOException {
        this.selfClosed = true;
        this.checkAbort();
    }
}

