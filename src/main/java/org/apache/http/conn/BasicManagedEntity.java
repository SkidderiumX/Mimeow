/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import org.apache.http.HttpEntity;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.conn.EofSensorInputStream;
import org.apache.http.conn.EofSensorWatcher;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

@Deprecated
@NotThreadSafe
public class BasicManagedEntity
extends HttpEntityWrapper
implements ConnectionReleaseTrigger,
EofSensorWatcher {
    protected ManagedClientConnection managedConn;
    protected final boolean attemptReuse;

    public BasicManagedEntity(HttpEntity httpEntity, ManagedClientConnection managedClientConnection, boolean bl) {
        super(httpEntity);
        Args.notNull(managedClientConnection, "Connection");
        this.managedConn = managedClientConnection;
        this.attemptReuse = bl;
    }

    public boolean isRepeatable() {
        return false;
    }

    public InputStream getContent() throws IOException {
        return new EofSensorInputStream(this.wrappedEntity.getContent(), this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void ensureConsumed() throws IOException {
        if (this.managedConn == null) {
            return;
        }
        try {
            if (this.attemptReuse) {
                EntityUtils.consume(this.wrappedEntity);
                this.managedConn.markReusable();
            } else {
                this.managedConn.unmarkReusable();
            }
        }
        finally {
            this.releaseManagedConnection();
        }
    }

    @Deprecated
    public void consumeContent() throws IOException {
        this.ensureConsumed();
    }

    public void writeTo(OutputStream outputStream2) throws IOException {
        super.writeTo(outputStream2);
        this.ensureConsumed();
    }

    public void releaseConnection() throws IOException {
        this.ensureConsumed();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void abortConnection() throws IOException {
        if (this.managedConn != null) {
            try {
                this.managedConn.abortConnection();
            }
            finally {
                this.managedConn = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean eofDetected(InputStream inputStream2) throws IOException {
        try {
            if (this.managedConn != null) {
                if (this.attemptReuse) {
                    inputStream2.close();
                    this.managedConn.markReusable();
                } else {
                    this.managedConn.unmarkReusable();
                }
            }
        }
        finally {
            this.releaseManagedConnection();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean streamClosed(InputStream inputStream2) throws IOException {
        block7: {
            try {
                if (this.managedConn == null) break block7;
                if (this.attemptReuse) {
                    boolean bl = this.managedConn.isOpen();
                    try {
                        inputStream2.close();
                        this.managedConn.markReusable();
                        break block7;
                    }
                    catch (SocketException socketException) {
                        if (bl) {
                            throw socketException;
                        }
                        break block7;
                    }
                }
                this.managedConn.unmarkReusable();
            }
            finally {
                this.releaseManagedConnection();
            }
        }
        return false;
    }

    public boolean streamAbort(InputStream inputStream2) throws IOException {
        if (this.managedConn != null) {
            this.managedConn.abortConnection();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void releaseManagedConnection() throws IOException {
        if (this.managedConn != null) {
            try {
                this.managedConn.releaseConnection();
            }
            finally {
                this.managedConn = null;
            }
        }
    }
}

