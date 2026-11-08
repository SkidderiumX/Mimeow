/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.impl.conn.ConnectionShutdownException;
import org.apache.http.impl.conn.HttpPoolEntry;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Deprecated
@NotThreadSafe
public class ManagedClientConnectionImpl
implements ManagedClientConnection {
    private final ClientConnectionManager manager;
    private final ClientConnectionOperator operator;
    private volatile HttpPoolEntry poolEntry;
    private volatile boolean reusable;
    private volatile long duration;

    ManagedClientConnectionImpl(ClientConnectionManager clientConnectionManager, ClientConnectionOperator clientConnectionOperator, HttpPoolEntry httpPoolEntry) {
        Args.notNull(clientConnectionManager, "Connection manager");
        Args.notNull(clientConnectionOperator, "Connection operator");
        Args.notNull(httpPoolEntry, "HTTP pool entry");
        this.manager = clientConnectionManager;
        this.operator = clientConnectionOperator;
        this.poolEntry = httpPoolEntry;
        this.reusable = false;
        this.duration = Long.MAX_VALUE;
    }

    public String getId() {
        return null;
    }

    HttpPoolEntry getPoolEntry() {
        return this.poolEntry;
    }

    HttpPoolEntry detach() {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        this.poolEntry = null;
        return httpPoolEntry;
    }

    public ClientConnectionManager getManager() {
        return this.manager;
    }

    private OperatedClientConnection getConnection() {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry == null) {
            return null;
        }
        return (OperatedClientConnection)httpPoolEntry.getConnection();
    }

    private OperatedClientConnection ensureConnection() {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry == null) {
            throw new ConnectionShutdownException();
        }
        return (OperatedClientConnection)httpPoolEntry.getConnection();
    }

    private HttpPoolEntry ensurePoolEntry() {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry == null) {
            throw new ConnectionShutdownException();
        }
        return httpPoolEntry;
    }

    public void close() throws IOException {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry != null) {
            OperatedClientConnection operatedClientConnection = (OperatedClientConnection)httpPoolEntry.getConnection();
            httpPoolEntry.getTracker().reset();
            operatedClientConnection.close();
        }
    }

    public void shutdown() throws IOException {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry != null) {
            OperatedClientConnection operatedClientConnection = (OperatedClientConnection)httpPoolEntry.getConnection();
            httpPoolEntry.getTracker().reset();
            operatedClientConnection.shutdown();
        }
    }

    public boolean isOpen() {
        OperatedClientConnection operatedClientConnection = this.getConnection();
        if (operatedClientConnection != null) {
            return operatedClientConnection.isOpen();
        }
        return false;
    }

    public boolean isStale() {
        OperatedClientConnection operatedClientConnection = this.getConnection();
        if (operatedClientConnection != null) {
            return operatedClientConnection.isStale();
        }
        return true;
    }

    public void setSocketTimeout(int n) {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        operatedClientConnection.setSocketTimeout(n);
    }

    public int getSocketTimeout() {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        return operatedClientConnection.getSocketTimeout();
    }

    public HttpConnectionMetrics getMetrics() {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        return operatedClientConnection.getMetrics();
    }

    public void flush() throws IOException {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        operatedClientConnection.flush();
    }

    public boolean isResponseAvailable(int n) throws IOException {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        return operatedClientConnection.isResponseAvailable(n);
    }

    public void receiveResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        operatedClientConnection.receiveResponseEntity(httpResponse);
    }

    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        return operatedClientConnection.receiveResponseHeader();
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        operatedClientConnection.sendRequestEntity(httpEntityEnclosingRequest);
    }

    public void sendRequestHeader(HttpRequest httpRequest) throws HttpException, IOException {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        operatedClientConnection.sendRequestHeader(httpRequest);
    }

    public InetAddress getLocalAddress() {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        return operatedClientConnection.getLocalAddress();
    }

    public int getLocalPort() {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        return operatedClientConnection.getLocalPort();
    }

    public InetAddress getRemoteAddress() {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        return operatedClientConnection.getRemoteAddress();
    }

    public int getRemotePort() {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        return operatedClientConnection.getRemotePort();
    }

    public boolean isSecure() {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        return operatedClientConnection.isSecure();
    }

    public void bind(Socket socket) throws IOException {
        throw new UnsupportedOperationException();
    }

    public Socket getSocket() {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        return operatedClientConnection.getSocket();
    }

    public SSLSession getSSLSession() {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        SSLSession sSLSession = null;
        Socket socket = operatedClientConnection.getSocket();
        if (socket instanceof SSLSocket) {
            sSLSession = ((SSLSocket)socket).getSession();
        }
        return sSLSession;
    }

    public Object getAttribute(String string) {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        if (operatedClientConnection instanceof HttpContext) {
            return ((HttpContext)((Object)operatedClientConnection)).getAttribute(string);
        }
        return null;
    }

    public Object removeAttribute(String string) {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        if (operatedClientConnection instanceof HttpContext) {
            return ((HttpContext)((Object)operatedClientConnection)).removeAttribute(string);
        }
        return null;
    }

    public void setAttribute(String string, Object object) {
        OperatedClientConnection operatedClientConnection = this.ensureConnection();
        if (operatedClientConnection instanceof HttpContext) {
            ((HttpContext)((Object)operatedClientConnection)).setAttribute(string, object);
        }
    }

    public HttpRoute getRoute() {
        HttpPoolEntry httpPoolEntry = this.ensurePoolEntry();
        return httpPoolEntry.getEffectiveRoute();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void open(HttpRoute httpRoute, HttpContext httpContext, HttpParams httpParams) throws IOException {
        OperatedClientConnection operatedClientConnection;
        Object object;
        Args.notNull(httpRoute, "Route");
        Args.notNull(httpParams, "HTTP parameters");
        Object object2 = this;
        synchronized (object2) {
            if (this.poolEntry == null) {
                throw new ConnectionShutdownException();
            }
            object = this.poolEntry.getTracker();
            Asserts.notNull(object, "Route tracker");
            Asserts.check(!((RouteTracker)object).isConnected(), "Connection already open");
            operatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
        }
        object2 = httpRoute.getProxyHost();
        this.operator.openConnection(operatedClientConnection, (HttpHost)(object2 != null ? object2 : httpRoute.getTargetHost()), httpRoute.getLocalAddress(), httpContext, httpParams);
        object = this;
        synchronized (object) {
            if (this.poolEntry == null) {
                throw new InterruptedIOException();
            }
            RouteTracker routeTracker = this.poolEntry.getTracker();
            if (object2 == null) {
                routeTracker.connectTarget(operatedClientConnection.isSecure());
            } else {
                routeTracker.connectProxy((HttpHost)object2, operatedClientConnection.isSecure());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void tunnelTarget(boolean bl, HttpParams httpParams) throws IOException {
        OperatedClientConnection operatedClientConnection;
        HttpHost httpHost;
        RouteTracker routeTracker;
        Args.notNull(httpParams, "HTTP parameters");
        ManagedClientConnectionImpl managedClientConnectionImpl = this;
        synchronized (managedClientConnectionImpl) {
            if (this.poolEntry == null) {
                throw new ConnectionShutdownException();
            }
            routeTracker = this.poolEntry.getTracker();
            Asserts.notNull(routeTracker, "Route tracker");
            Asserts.check(routeTracker.isConnected(), "Connection not open");
            Asserts.check(!routeTracker.isTunnelled(), "Connection is already tunnelled");
            httpHost = routeTracker.getTargetHost();
            operatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
        }
        operatedClientConnection.update(null, httpHost, bl, httpParams);
        managedClientConnectionImpl = this;
        synchronized (managedClientConnectionImpl) {
            if (this.poolEntry == null) {
                throw new InterruptedIOException();
            }
            routeTracker = this.poolEntry.getTracker();
            routeTracker.tunnelTarget(bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void tunnelProxy(HttpHost httpHost, boolean bl, HttpParams httpParams) throws IOException {
        OperatedClientConnection operatedClientConnection;
        RouteTracker routeTracker;
        Args.notNull(httpHost, "Next proxy");
        Args.notNull(httpParams, "HTTP parameters");
        ManagedClientConnectionImpl managedClientConnectionImpl = this;
        synchronized (managedClientConnectionImpl) {
            if (this.poolEntry == null) {
                throw new ConnectionShutdownException();
            }
            routeTracker = this.poolEntry.getTracker();
            Asserts.notNull(routeTracker, "Route tracker");
            Asserts.check(routeTracker.isConnected(), "Connection not open");
            operatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
        }
        operatedClientConnection.update(null, httpHost, bl, httpParams);
        managedClientConnectionImpl = this;
        synchronized (managedClientConnectionImpl) {
            if (this.poolEntry == null) {
                throw new InterruptedIOException();
            }
            routeTracker = this.poolEntry.getTracker();
            routeTracker.tunnelProxy(httpHost, bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void layerProtocol(HttpContext httpContext, HttpParams httpParams) throws IOException {
        OperatedClientConnection operatedClientConnection;
        HttpHost httpHost;
        RouteTracker routeTracker;
        Args.notNull(httpParams, "HTTP parameters");
        ManagedClientConnectionImpl managedClientConnectionImpl = this;
        synchronized (managedClientConnectionImpl) {
            if (this.poolEntry == null) {
                throw new ConnectionShutdownException();
            }
            routeTracker = this.poolEntry.getTracker();
            Asserts.notNull(routeTracker, "Route tracker");
            Asserts.check(routeTracker.isConnected(), "Connection not open");
            Asserts.check(routeTracker.isTunnelled(), "Protocol layering without a tunnel not supported");
            Asserts.check(!routeTracker.isLayered(), "Multiple protocol layering not supported");
            httpHost = routeTracker.getTargetHost();
            operatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
        }
        this.operator.updateSecureConnection(operatedClientConnection, httpHost, httpContext, httpParams);
        managedClientConnectionImpl = this;
        synchronized (managedClientConnectionImpl) {
            if (this.poolEntry == null) {
                throw new InterruptedIOException();
            }
            routeTracker = this.poolEntry.getTracker();
            routeTracker.layerProtocol(operatedClientConnection.isSecure());
        }
    }

    public Object getState() {
        HttpPoolEntry httpPoolEntry = this.ensurePoolEntry();
        return httpPoolEntry.getState();
    }

    public void setState(Object object) {
        HttpPoolEntry httpPoolEntry = this.ensurePoolEntry();
        httpPoolEntry.setState(object);
    }

    public void markReusable() {
        this.reusable = true;
    }

    public void unmarkReusable() {
        this.reusable = false;
    }

    public boolean isMarkedReusable() {
        return this.reusable;
    }

    public void setIdleDuration(long l, TimeUnit timeUnit) {
        this.duration = l > 0L ? timeUnit.toMillis(l) : -1L;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void releaseConnection() {
        ManagedClientConnectionImpl managedClientConnectionImpl = this;
        synchronized (managedClientConnectionImpl) {
            if (this.poolEntry == null) {
                return;
            }
            this.manager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
            this.poolEntry = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void abortConnection() {
        ManagedClientConnectionImpl managedClientConnectionImpl = this;
        synchronized (managedClientConnectionImpl) {
            if (this.poolEntry == null) {
                return;
            }
            this.reusable = false;
            OperatedClientConnection operatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
            try {
                operatedClientConnection.shutdown();
            }
            catch (IOException iOException) {
                // empty catch block
            }
            this.manager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
            this.poolEntry = null;
        }
    }
}

