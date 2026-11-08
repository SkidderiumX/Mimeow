/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.http.HttpClientConnection;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.pool.PoolEntry;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@ThreadSafe
public class CPoolEntry
extends PoolEntry<HttpRoute, ManagedHttpClientConnection> {
    private final Log log;
    private volatile boolean routeComplete;

    public CPoolEntry(Log log, String string, HttpRoute httpRoute, ManagedHttpClientConnection managedHttpClientConnection, long l, TimeUnit timeUnit) {
        super(string, httpRoute, managedHttpClientConnection, l, timeUnit);
        this.log = log;
    }

    public void markRouteComplete() {
        this.routeComplete = true;
    }

    public boolean isRouteComplete() {
        return this.routeComplete;
    }

    public void closeConnection() throws IOException {
        HttpClientConnection httpClientConnection = (HttpClientConnection)this.getConnection();
        httpClientConnection.close();
    }

    public void shutdownConnection() throws IOException {
        HttpClientConnection httpClientConnection = (HttpClientConnection)this.getConnection();
        httpClientConnection.shutdown();
    }

    @Override
    public boolean isExpired(long l) {
        boolean bl = super.isExpired(l);
        if (bl && this.log.isDebugEnabled()) {
            this.log.debug("Connection " + this + " expired @ " + new Date(this.getExpiry()));
        }
        return bl;
    }

    @Override
    public boolean isClosed() {
        HttpClientConnection httpClientConnection = (HttpClientConnection)this.getConnection();
        return !httpClientConnection.isOpen();
    }

    @Override
    public void close() {
        try {
            this.closeConnection();
        }
        catch (IOException iOException) {
            this.log.debug("I/O error closing connection", iOException);
        }
    }
}

