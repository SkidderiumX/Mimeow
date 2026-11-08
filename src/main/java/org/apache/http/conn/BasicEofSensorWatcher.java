/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.EofSensorWatcher;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.util.Args;

@Deprecated
@NotThreadSafe
public class BasicEofSensorWatcher
implements EofSensorWatcher {
    protected final ManagedClientConnection managedConn;
    protected final boolean attemptReuse;

    public BasicEofSensorWatcher(ManagedClientConnection managedClientConnection, boolean bl) {
        Args.notNull(managedClientConnection, "Connection");
        this.managedConn = managedClientConnection;
        this.attemptReuse = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean eofDetected(InputStream inputStream2) throws IOException {
        try {
            if (this.attemptReuse) {
                inputStream2.close();
                this.managedConn.markReusable();
            }
        }
        finally {
            this.managedConn.releaseConnection();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean streamClosed(InputStream inputStream2) throws IOException {
        try {
            if (this.attemptReuse) {
                inputStream2.close();
                this.managedConn.markReusable();
            }
        }
        finally {
            this.managedConn.releaseConnection();
        }
        return false;
    }

    public boolean streamAbort(InputStream inputStream2) throws IOException {
        this.managedConn.abortConnection();
        return false;
    }
}

