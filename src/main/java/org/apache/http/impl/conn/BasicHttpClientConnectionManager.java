/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.conn.HttpClientConnectionOperator;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.LangUtils;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@ThreadSafe
public class BasicHttpClientConnectionManager
implements HttpClientConnectionManager,
Closeable {
    private final Log log = LogFactory.getLog(this.getClass());
    private final HttpClientConnectionOperator connectionOperator;
    private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
    @GuardedBy(value="this")
    private ManagedHttpClientConnection conn;
    @GuardedBy(value="this")
    private HttpRoute route;
    @GuardedBy(value="this")
    private Object state;
    @GuardedBy(value="this")
    private long updated;
    @GuardedBy(value="this")
    private long expiry;
    @GuardedBy(value="this")
    private boolean leased;
    @GuardedBy(value="this")
    private SocketConfig socketConfig;
    @GuardedBy(value="this")
    private ConnectionConfig connConfig;
    @GuardedBy(value="this")
    private volatile boolean shutdown;

    private static Registry<ConnectionSocketFactory> getDefaultRegistry() {
        return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", (PlainConnectionSocketFactory)((Object)SSLConnectionSocketFactory.getSocketFactory())).build();
    }

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> lookup, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> managedHttpClientConnectionFactory, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        this.connectionOperator = new HttpClientConnectionOperator(lookup, schemePortResolver, dnsResolver);
        this.connFactory = managedHttpClientConnectionFactory != null ? managedHttpClientConnectionFactory : ManagedHttpClientConnectionFactory.INSTANCE;
        this.expiry = Long.MAX_VALUE;
        this.socketConfig = SocketConfig.DEFAULT;
        this.connConfig = ConnectionConfig.DEFAULT;
    }

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> lookup, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory) {
        this(lookup, httpConnectionFactory, null, null);
    }

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> lookup) {
        this(lookup, null, null, null);
    }

    public BasicHttpClientConnectionManager() {
        this(BasicHttpClientConnectionManager.getDefaultRegistry(), null, null, null);
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

    @Override
    public void close() {
        this.shutdown();
    }

    HttpRoute getRoute() {
        return this.route;
    }

    Object getState() {
        return this.state;
    }

    public synchronized SocketConfig getSocketConfig() {
        return this.socketConfig;
    }

    public synchronized void setSocketConfig(SocketConfig socketConfig) {
        this.socketConfig = socketConfig != null ? socketConfig : SocketConfig.DEFAULT;
    }

    public synchronized ConnectionConfig getConnectionConfig() {
        return this.connConfig;
    }

    public synchronized void setConnectionConfig(ConnectionConfig connectionConfig) {
        this.connConfig = connectionConfig != null ? connectionConfig : ConnectionConfig.DEFAULT;
    }

    @Override
    public final ConnectionRequest requestConnection(final HttpRoute httpRoute, final Object object) {
        Args.notNull(httpRoute, "Route");
        return new ConnectionRequest(){

            public boolean cancel() {
                return false;
            }

            public HttpClientConnection get(long l, TimeUnit timeUnit) {
                return BasicHttpClientConnectionManager.this.getConnection(httpRoute, object);
            }
        };
    }

    private void closeConnection() {
        if (this.conn != null) {
            block3: {
                this.log.debug("Closing connection");
                try {
                    this.conn.close();
                }
                catch (IOException iOException) {
                    if (!this.log.isDebugEnabled()) break block3;
                    this.log.debug("I/O exception closing connection", iOException);
                }
            }
            this.conn = null;
        }
    }

    private void shutdownConnection() {
        if (this.conn != null) {
            block3: {
                this.log.debug("Shutting down connection");
                try {
                    this.conn.shutdown();
                }
                catch (IOException iOException) {
                    if (!this.log.isDebugEnabled()) break block3;
                    this.log.debug("I/O exception shutting down connection", iOException);
                }
            }
            this.conn = null;
        }
    }

    private void checkExpiry() {
        if (this.conn != null && System.currentTimeMillis() >= this.expiry) {
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connection expired @ " + new Date(this.expiry));
            }
            this.closeConnection();
        }
    }

    synchronized HttpClientConnection getConnection(HttpRoute httpRoute, Object object) {
        Asserts.check(!this.shutdown, "Connection manager has been shut down");
        if (this.log.isDebugEnabled()) {
            this.log.debug("Get connection for route " + httpRoute);
        }
        Asserts.check(!this.leased, "Connection is still allocated");
        if (!LangUtils.equals(this.route, httpRoute) || !LangUtils.equals(this.state, object)) {
            this.closeConnection();
        }
        this.route = httpRoute;
        this.state = object;
        this.checkExpiry();
        if (this.conn == null) {
            this.conn = this.connFactory.create(httpRoute, this.connConfig);
        }
        this.leased = true;
        return this.conn;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized void releaseConnection(HttpClientConnection httpClientConnection, Object object, long l, TimeUnit timeUnit) {
        Args.notNull(httpClientConnection, "Connection");
        Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
        if (this.log.isDebugEnabled()) {
            this.log.debug("Releasing connection " + httpClientConnection);
        }
        if (this.shutdown) {
            this.shutdownConnection();
            return;
        }
        try {
            this.updated = System.currentTimeMillis();
            if (!this.conn.isOpen()) {
                this.conn = null;
                this.route = null;
                this.conn = null;
                this.expiry = Long.MAX_VALUE;
            } else {
                this.state = object;
                if (this.log.isDebugEnabled()) {
                    String string = l > 0L ? "for " + l + " " + (Object)((Object)timeUnit) : "indefinitely";
                    this.log.debug("Connection can be kept alive " + string);
                }
                this.expiry = l > 0L ? this.updated + timeUnit.toMillis(l) : Long.MAX_VALUE;
            }
        }
        finally {
            this.leased = false;
        }
    }

    @Override
    public void connect(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int n, HttpContext httpContext) throws IOException {
        Args.notNull(httpClientConnection, "Connection");
        Args.notNull(httpRoute, "HTTP route");
        Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
        HttpHost httpHost = httpRoute.getProxyHost() != null ? httpRoute.getProxyHost() : httpRoute.getTargetHost();
        InetSocketAddress inetSocketAddress = httpRoute.getLocalSocketAddress();
        this.connectionOperator.connect(this.conn, httpHost, inetSocketAddress, n, this.socketConfig, httpContext);
    }

    @Override
    public void upgrade(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
        Args.notNull(httpClientConnection, "Connection");
        Args.notNull(httpRoute, "HTTP route");
        Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
        this.connectionOperator.upgrade(this.conn, httpRoute.getTargetHost(), httpContext);
    }

    @Override
    public void routeComplete(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
    }

    @Override
    public synchronized void closeExpiredConnections() {
        if (this.shutdown) {
            return;
        }
        if (!this.leased) {
            this.checkExpiry();
        }
    }

    @Override
    public synchronized void closeIdleConnections(long l, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        if (this.shutdown) {
            return;
        }
        if (!this.leased) {
            long l2;
            long l3 = timeUnit.toMillis(l);
            if (l3 < 0L) {
                l3 = 0L;
            }
            if (this.updated <= (l2 = System.currentTimeMillis() - l3)) {
                this.closeConnection();
            }
        }
    }

    @Override
    public synchronized void shutdown() {
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        this.shutdownConnection();
    }
}

