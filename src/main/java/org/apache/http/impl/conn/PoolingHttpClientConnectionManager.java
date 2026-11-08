/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionPoolTimeoutException;
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
import org.apache.http.impl.conn.CPool;
import org.apache.http.impl.conn.CPoolEntry;
import org.apache.http.impl.conn.CPoolProxy;
import org.apache.http.impl.conn.HttpClientConnectionOperator;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.pool.ConnFactory;
import org.apache.http.pool.ConnPoolControl;
import org.apache.http.pool.PoolEntry;
import org.apache.http.pool.PoolStats;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@ThreadSafe
public class PoolingHttpClientConnectionManager
implements HttpClientConnectionManager,
ConnPoolControl<HttpRoute>,
Closeable {
    private final Log log = LogFactory.getLog(this.getClass());
    private final ConfigData configData = new ConfigData();
    private final CPool pool;
    private final HttpClientConnectionOperator connectionOperator;

    private static Registry<ConnectionSocketFactory> getDefaultRegistry() {
        return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", (PlainConnectionSocketFactory)((Object)SSLConnectionSocketFactory.getSocketFactory())).build();
    }

    public PoolingHttpClientConnectionManager() {
        this(PoolingHttpClientConnectionManager.getDefaultRegistry());
    }

    public PoolingHttpClientConnectionManager(long l, TimeUnit timeUnit) {
        this(PoolingHttpClientConnectionManager.getDefaultRegistry(), null, null, null, l, timeUnit);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry) {
        this(registry, null, null);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry, DnsResolver dnsResolver) {
        this(registry, null, dnsResolver);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory) {
        this(registry, httpConnectionFactory, null);
    }

    public PoolingHttpClientConnectionManager(HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory) {
        this(PoolingHttpClientConnectionManager.getDefaultRegistry(), httpConnectionFactory, null);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, DnsResolver dnsResolver) {
        this(registry, httpConnectionFactory, null, dnsResolver, -1L, TimeUnit.MILLISECONDS);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, SchemePortResolver schemePortResolver, DnsResolver dnsResolver, long l, TimeUnit timeUnit) {
        this.pool = new CPool(new InternalConnectionFactory(this.configData, httpConnectionFactory), 2, 20, l, timeUnit);
        this.connectionOperator = new HttpClientConnectionOperator(registry, schemePortResolver, dnsResolver);
    }

    PoolingHttpClientConnectionManager(CPool cPool, Lookup<ConnectionSocketFactory> lookup, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        this.pool = cPool;
        this.connectionOperator = new HttpClientConnectionOperator(lookup, schemePortResolver, dnsResolver);
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

    private String format(HttpRoute httpRoute, Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[route: ").append(httpRoute).append("]");
        if (object != null) {
            stringBuilder.append("[state: ").append(object).append("]");
        }
        return stringBuilder.toString();
    }

    private String formatStats(HttpRoute httpRoute) {
        StringBuilder stringBuilder = new StringBuilder();
        PoolStats poolStats = this.pool.getTotalStats();
        PoolStats poolStats2 = this.pool.getStats(httpRoute);
        stringBuilder.append("[total kept alive: ").append(poolStats.getAvailable()).append("; ");
        stringBuilder.append("route allocated: ").append(poolStats2.getLeased() + poolStats2.getAvailable());
        stringBuilder.append(" of ").append(poolStats2.getMax()).append("; ");
        stringBuilder.append("total allocated: ").append(poolStats.getLeased() + poolStats.getAvailable());
        stringBuilder.append(" of ").append(poolStats.getMax()).append("]");
        return stringBuilder.toString();
    }

    private String format(CPoolEntry cPoolEntry) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[id: ").append(cPoolEntry.getId()).append("]");
        stringBuilder.append("[route: ").append(cPoolEntry.getRoute()).append("]");
        Object object = cPoolEntry.getState();
        if (object != null) {
            stringBuilder.append("[state: ").append(object).append("]");
        }
        return stringBuilder.toString();
    }

    @Override
    public ConnectionRequest requestConnection(HttpRoute httpRoute, Object object) {
        Args.notNull(httpRoute, "HTTP route");
        if (this.log.isDebugEnabled()) {
            this.log.debug("Connection request: " + this.format(httpRoute, object) + this.formatStats(httpRoute));
        }
        final Future future = this.pool.lease(httpRoute, object, null);
        return new ConnectionRequest(){

            public boolean cancel() {
                return future.cancel(true);
            }

            public HttpClientConnection get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException {
                return PoolingHttpClientConnectionManager.this.leaseConnection(future, l, timeUnit);
            }
        };
    }

    protected HttpClientConnection leaseConnection(Future<CPoolEntry> future, long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException {
        try {
            CPoolEntry cPoolEntry = future.get(l, timeUnit);
            if (cPoolEntry == null || future.isCancelled()) {
                throw new InterruptedException();
            }
            Asserts.check(cPoolEntry.getConnection() != null, "Pool entry with no connection");
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connection leased: " + this.format(cPoolEntry) + this.formatStats((HttpRoute)cPoolEntry.getRoute()));
            }
            return CPoolProxy.newProxy(cPoolEntry);
        }
        catch (TimeoutException timeoutException) {
            throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releaseConnection(HttpClientConnection httpClientConnection, Object object, long l, TimeUnit timeUnit) {
        Args.notNull(httpClientConnection, "Managed connection");
        HttpClientConnection httpClientConnection2 = httpClientConnection;
        synchronized (httpClientConnection2) {
            ManagedHttpClientConnection managedHttpClientConnection;
            CPoolEntry cPoolEntry;
            block8: {
                cPoolEntry = CPoolProxy.detach(httpClientConnection);
                if (cPoolEntry == null) {
                    return;
                }
                managedHttpClientConnection = (ManagedHttpClientConnection)cPoolEntry.getConnection();
                try {
                    if (!managedHttpClientConnection.isOpen()) break block8;
                    cPoolEntry.setState(object);
                    cPoolEntry.updateExpiry(l, timeUnit != null ? timeUnit : TimeUnit.MILLISECONDS);
                    if (!this.log.isDebugEnabled()) break block8;
                    String string = l > 0L ? "for " + (double)l / 1000.0 + " seconds" : "indefinitely";
                    this.log.debug("Connection " + this.format(cPoolEntry) + " can be kept alive " + string);
                }
                catch (Throwable throwable) {
                    this.pool.release(cPoolEntry, managedHttpClientConnection.isOpen() && cPoolEntry.isRouteComplete());
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Connection released: " + this.format(cPoolEntry) + this.formatStats((HttpRoute)cPoolEntry.getRoute()));
                    }
                    throw throwable;
                }
            }
            this.pool.release(cPoolEntry, managedHttpClientConnection.isOpen() && cPoolEntry.isRouteComplete());
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connection released: " + this.format(cPoolEntry) + this.formatStats((HttpRoute)cPoolEntry.getRoute()));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void connect(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int n, HttpContext httpContext) throws IOException {
        ManagedHttpClientConnection managedHttpClientConnection;
        Object object;
        Args.notNull(httpClientConnection, "Managed Connection");
        Args.notNull(httpRoute, "HTTP route");
        Object object2 = httpClientConnection;
        synchronized (object2) {
            object = CPoolProxy.getPoolEntry(httpClientConnection);
            managedHttpClientConnection = (ManagedHttpClientConnection)((PoolEntry)object).getConnection();
        }
        object2 = httpRoute.getProxyHost() != null ? httpRoute.getProxyHost() : httpRoute.getTargetHost();
        object = httpRoute.getLocalSocketAddress();
        SocketConfig socketConfig = this.configData.getSocketConfig((HttpHost)object2);
        if (socketConfig == null) {
            socketConfig = this.configData.getDefaultSocketConfig();
        }
        if (socketConfig == null) {
            socketConfig = SocketConfig.DEFAULT;
        }
        this.connectionOperator.connect(managedHttpClientConnection, (HttpHost)object2, (InetSocketAddress)object, n, socketConfig, httpContext);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void upgrade(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
        ManagedHttpClientConnection managedHttpClientConnection;
        Args.notNull(httpClientConnection, "Managed Connection");
        Args.notNull(httpRoute, "HTTP route");
        HttpClientConnection httpClientConnection2 = httpClientConnection;
        synchronized (httpClientConnection2) {
            CPoolEntry cPoolEntry = CPoolProxy.getPoolEntry(httpClientConnection);
            managedHttpClientConnection = (ManagedHttpClientConnection)cPoolEntry.getConnection();
        }
        this.connectionOperator.upgrade(managedHttpClientConnection, httpRoute.getTargetHost(), httpContext);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void routeComplete(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
        Args.notNull(httpClientConnection, "Managed Connection");
        Args.notNull(httpRoute, "HTTP route");
        HttpClientConnection httpClientConnection2 = httpClientConnection;
        synchronized (httpClientConnection2) {
            CPoolEntry cPoolEntry = CPoolProxy.getPoolEntry(httpClientConnection);
            cPoolEntry.markRouteComplete();
        }
    }

    @Override
    public void shutdown() {
        this.log.debug("Connection manager is shutting down");
        try {
            this.pool.shutdown();
        }
        catch (IOException iOException) {
            this.log.debug("I/O exception shutting down connection manager", iOException);
        }
        this.log.debug("Connection manager shut down");
    }

    @Override
    public void closeIdleConnections(long l, TimeUnit timeUnit) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Closing connections idle longer than " + l + " " + (Object)((Object)timeUnit));
        }
        this.pool.closeIdle(l, timeUnit);
    }

    @Override
    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpired();
    }

    @Override
    public int getMaxTotal() {
        return this.pool.getMaxTotal();
    }

    @Override
    public void setMaxTotal(int n) {
        this.pool.setMaxTotal(n);
    }

    @Override
    public int getDefaultMaxPerRoute() {
        return this.pool.getDefaultMaxPerRoute();
    }

    @Override
    public void setDefaultMaxPerRoute(int n) {
        this.pool.setDefaultMaxPerRoute(n);
    }

    @Override
    public int getMaxPerRoute(HttpRoute httpRoute) {
        return this.pool.getMaxPerRoute(httpRoute);
    }

    @Override
    public void setMaxPerRoute(HttpRoute httpRoute, int n) {
        this.pool.setMaxPerRoute(httpRoute, n);
    }

    @Override
    public PoolStats getTotalStats() {
        return this.pool.getTotalStats();
    }

    @Override
    public PoolStats getStats(HttpRoute httpRoute) {
        return this.pool.getStats(httpRoute);
    }

    public SocketConfig getDefaultSocketConfig() {
        return this.configData.getDefaultSocketConfig();
    }

    public void setDefaultSocketConfig(SocketConfig socketConfig) {
        this.configData.setDefaultSocketConfig(socketConfig);
    }

    public ConnectionConfig getDefaultConnectionConfig() {
        return this.configData.getDefaultConnectionConfig();
    }

    public void setDefaultConnectionConfig(ConnectionConfig connectionConfig) {
        this.configData.setDefaultConnectionConfig(connectionConfig);
    }

    public SocketConfig getSocketConfig(HttpHost httpHost) {
        return this.configData.getSocketConfig(httpHost);
    }

    public void setSocketConfig(HttpHost httpHost, SocketConfig socketConfig) {
        this.configData.setSocketConfig(httpHost, socketConfig);
    }

    public ConnectionConfig getConnectionConfig(HttpHost httpHost) {
        return this.configData.getConnectionConfig(httpHost);
    }

    public void setConnectionConfig(HttpHost httpHost, ConnectionConfig connectionConfig) {
        this.configData.setConnectionConfig(httpHost, connectionConfig);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class InternalConnectionFactory
    implements ConnFactory<HttpRoute, ManagedHttpClientConnection> {
        private final ConfigData configData;
        private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;

        InternalConnectionFactory(ConfigData configData, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> managedHttpClientConnectionFactory) {
            this.configData = configData != null ? configData : new ConfigData();
            this.connFactory = managedHttpClientConnectionFactory != null ? managedHttpClientConnectionFactory : ManagedHttpClientConnectionFactory.INSTANCE;
        }

        @Override
        public ManagedHttpClientConnection create(HttpRoute httpRoute) throws IOException {
            ConnectionConfig connectionConfig = null;
            if (httpRoute.getProxyHost() != null) {
                connectionConfig = this.configData.getConnectionConfig(httpRoute.getProxyHost());
            }
            if (connectionConfig == null) {
                connectionConfig = this.configData.getConnectionConfig(httpRoute.getTargetHost());
            }
            if (connectionConfig == null) {
                connectionConfig = this.configData.getDefaultConnectionConfig();
            }
            if (connectionConfig == null) {
                connectionConfig = ConnectionConfig.DEFAULT;
            }
            return this.connFactory.create(httpRoute, connectionConfig);
        }
    }

    public static class ConfigData {
        private final Map<HttpHost, SocketConfig> socketConfigMap = new ConcurrentHashMap<HttpHost, SocketConfig>();
        private final Map<HttpHost, ConnectionConfig> connectionConfigMap = new ConcurrentHashMap<HttpHost, ConnectionConfig>();
        private volatile SocketConfig defaultSocketConfig;
        private volatile ConnectionConfig defaultConnectionConfig;

        ConfigData() {
        }

        public SocketConfig getDefaultSocketConfig() {
            return this.defaultSocketConfig;
        }

        public void setDefaultSocketConfig(SocketConfig socketConfig) {
            this.defaultSocketConfig = socketConfig;
        }

        public ConnectionConfig getDefaultConnectionConfig() {
            return this.defaultConnectionConfig;
        }

        public void setDefaultConnectionConfig(ConnectionConfig connectionConfig) {
            this.defaultConnectionConfig = connectionConfig;
        }

        public SocketConfig getSocketConfig(HttpHost httpHost) {
            return this.socketConfigMap.get(httpHost);
        }

        public void setSocketConfig(HttpHost httpHost, SocketConfig socketConfig) {
            this.socketConfigMap.put(httpHost, socketConfig);
        }

        public ConnectionConfig getConnectionConfig(HttpHost httpHost) {
            return this.connectionConfigMap.get(httpHost);
        }

        public void setConnectionConfig(HttpHost httpHost, ConnectionConfig connectionConfig) {
            this.connectionConfigMap.put(httpHost, connectionConfig);
        }
    }
}

