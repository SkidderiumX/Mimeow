/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.AbstractPoolEntry;
import org.apache.http.impl.conn.AbstractPooledConnAdapter;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Deprecated
@ThreadSafe
public class SingleClientConnManager
implements ClientConnectionManager {
    private final Log log = LogFactory.getLog(this.getClass());
    public static final String MISUSE_MESSAGE = "Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
    protected final SchemeRegistry schemeRegistry;
    protected final ClientConnectionOperator connOperator;
    protected final boolean alwaysShutDown;
    @GuardedBy(value="this")
    protected volatile PoolEntry uniquePoolEntry;
    @GuardedBy(value="this")
    protected volatile ConnAdapter managedConn;
    @GuardedBy(value="this")
    protected volatile long lastReleaseTime;
    @GuardedBy(value="this")
    protected volatile long connectionExpiresTime;
    protected volatile boolean isShutDown;

    @Deprecated
    public SingleClientConnManager(HttpParams httpParams, SchemeRegistry schemeRegistry) {
        this(schemeRegistry);
    }

    public SingleClientConnManager(SchemeRegistry schemeRegistry) {
        Args.notNull(schemeRegistry, "Scheme registry");
        this.schemeRegistry = schemeRegistry;
        this.connOperator = this.createConnectionOperator(schemeRegistry);
        this.uniquePoolEntry = new PoolEntry();
        this.managedConn = null;
        this.lastReleaseTime = -1L;
        this.alwaysShutDown = false;
        this.isShutDown = false;
    }

    public SingleClientConnManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void finalize() throws Throwable {
        try {
            this.shutdown();
        }
        finally {
            super.finalize();
        }
    }

    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry) {
        return new DefaultClientConnectionOperator(schemeRegistry);
    }

    protected final void assertStillUp() throws IllegalStateException {
        Asserts.check(!this.isShutDown, "Manager is shut down");
    }

    public final ClientConnectionRequest requestConnection(final HttpRoute httpRoute, final Object object) {
        return new ClientConnectionRequest(){

            public void abortRequest() {
            }

            public ManagedClientConnection getConnection(long l, TimeUnit timeUnit) {
                return SingleClientConnManager.this.getConnection(httpRoute, object);
            }
        };
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ManagedClientConnection getConnection(HttpRoute httpRoute, Object object) {
        Args.notNull(httpRoute, "Route");
        this.assertStillUp();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Get connection for route " + httpRoute);
        }
        SingleClientConnManager singleClientConnManager = this;
        synchronized (singleClientConnManager) {
            Asserts.check(this.managedConn == null, MISUSE_MESSAGE);
            boolean bl = false;
            boolean bl2 = false;
            this.closeExpiredConnections();
            if (this.uniquePoolEntry.connection.isOpen()) {
                RouteTracker routeTracker = this.uniquePoolEntry.tracker;
                bl2 = routeTracker == null || !routeTracker.toRoute().equals(httpRoute);
            } else {
                bl = true;
            }
            if (bl2) {
                bl = true;
                try {
                    this.uniquePoolEntry.shutdown();
                }
                catch (IOException iOException) {
                    this.log.debug("Problem shutting down connection.", iOException);
                }
            }
            if (bl) {
                this.uniquePoolEntry = new PoolEntry();
            }
            this.managedConn = new ConnAdapter(this.uniquePoolEntry, httpRoute);
            return this.managedConn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void releaseConnection(ManagedClientConnection managedClientConnection, long l, TimeUnit timeUnit) {
        ConnAdapter connAdapter;
        Args.check(managedClientConnection instanceof ConnAdapter, "Connection class mismatch, connection not obtained from this manager");
        this.assertStillUp();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Releasing connection " + managedClientConnection);
        }
        ConnAdapter connAdapter2 = connAdapter = (ConnAdapter)managedClientConnection;
        synchronized (connAdapter2) {
            if (connAdapter.poolEntry == null) {
                return;
            }
            ClientConnectionManager clientConnectionManager = connAdapter.getManager();
            Asserts.check(clientConnectionManager == this, "Connection not obtained from this manager");
            try {
                if (connAdapter.isOpen() && (this.alwaysShutDown || !connAdapter.isMarkedReusable())) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Released connection open but not reusable.");
                    }
                    connAdapter.shutdown();
                }
            }
            catch (IOException iOException) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Exception shutting down released connection.", iOException);
                }
            }
            finally {
                connAdapter.detach();
                SingleClientConnManager singleClientConnManager = this;
                synchronized (singleClientConnManager) {
                    this.managedConn = null;
                    this.lastReleaseTime = System.currentTimeMillis();
                    this.connectionExpiresTime = l > 0L ? timeUnit.toMillis(l) + this.lastReleaseTime : Long.MAX_VALUE;
                }
            }
        }
    }

    public void closeExpiredConnections() {
        long l = this.connectionExpiresTime;
        if (System.currentTimeMillis() >= l) {
            this.closeIdleConnections(0L, TimeUnit.MILLISECONDS);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void closeIdleConnections(long l, TimeUnit timeUnit) {
        this.assertStillUp();
        Args.notNull(timeUnit, "Time unit");
        SingleClientConnManager singleClientConnManager = this;
        synchronized (singleClientConnManager) {
            long l2;
            if (this.managedConn == null && this.uniquePoolEntry.connection.isOpen() && this.lastReleaseTime <= (l2 = System.currentTimeMillis() - timeUnit.toMillis(l))) {
                try {
                    this.uniquePoolEntry.close();
                }
                catch (IOException iOException) {
                    this.log.debug("Problem closing idle connection.", iOException);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void shutdown() {
        this.isShutDown = true;
        SingleClientConnManager singleClientConnManager = this;
        synchronized (singleClientConnManager) {
            try {
                if (this.uniquePoolEntry != null) {
                    this.uniquePoolEntry.shutdown();
                }
            }
            catch (IOException iOException) {
                this.log.debug("Problem while shutting down manager.", iOException);
            }
            finally {
                this.uniquePoolEntry = null;
                this.managedConn = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void revokeConnection() {
        ConnAdapter connAdapter = this.managedConn;
        if (connAdapter == null) {
            return;
        }
        connAdapter.detach();
        SingleClientConnManager singleClientConnManager = this;
        synchronized (singleClientConnManager) {
            try {
                this.uniquePoolEntry.shutdown();
            }
            catch (IOException iOException) {
                this.log.debug("Problem while shutting down connection.", iOException);
            }
        }
    }

    protected class ConnAdapter
    extends AbstractPooledConnAdapter {
        protected ConnAdapter(PoolEntry poolEntry, HttpRoute httpRoute) {
            super((ClientConnectionManager)SingleClientConnManager.this, poolEntry);
            this.markReusable();
            poolEntry.route = httpRoute;
        }
    }

    protected class PoolEntry
    extends AbstractPoolEntry {
        protected PoolEntry() {
            super(SingleClientConnManager.this.connOperator, null);
        }

        protected void close() throws IOException {
            this.shutdownEntry();
            if (this.connection.isOpen()) {
                this.connection.close();
            }
        }

        protected void shutdown() throws IOException {
            this.shutdownEntry();
            if (this.connection.isOpen()) {
                this.connection.shutdown();
            }
        }
    }
}

