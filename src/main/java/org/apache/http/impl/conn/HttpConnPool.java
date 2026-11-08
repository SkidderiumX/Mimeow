/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.logging.Log;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.HttpPoolEntry;
import org.apache.http.pool.AbstractConnPool;
import org.apache.http.pool.ConnFactory;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public class HttpConnPool
extends AbstractConnPool<HttpRoute, OperatedClientConnection, HttpPoolEntry> {
    private static final AtomicLong COUNTER = new AtomicLong();
    private final Log log;
    private final long timeToLive;
    private final TimeUnit tunit;

    public HttpConnPool(Log log, ClientConnectionOperator clientConnectionOperator, int n, int n2, long l, TimeUnit timeUnit) {
        super(new InternalConnFactory(clientConnectionOperator), n, n2);
        this.log = log;
        this.timeToLive = l;
        this.tunit = timeUnit;
    }

    @Override
    protected HttpPoolEntry createEntry(HttpRoute httpRoute, OperatedClientConnection operatedClientConnection) {
        String string = Long.toString(COUNTER.getAndIncrement());
        return new HttpPoolEntry(this.log, string, httpRoute, operatedClientConnection, this.timeToLive, this.tunit);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class InternalConnFactory
    implements ConnFactory<HttpRoute, OperatedClientConnection> {
        private final ClientConnectionOperator connOperator;

        InternalConnFactory(ClientConnectionOperator clientConnectionOperator) {
            this.connOperator = clientConnectionOperator;
        }

        @Override
        public OperatedClientConnection create(HttpRoute httpRoute) throws IOException {
            return this.connOperator.createConnection();
        }
    }
}

