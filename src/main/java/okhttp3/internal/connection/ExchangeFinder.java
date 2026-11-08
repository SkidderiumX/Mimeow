package okhttp3.internal.connection;

import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import okhttp3.internal.http.*;
import java.io.*;
import kotlin.*;
import okhttp3.internal.*;
import java.util.*;
import java.net.*;
import okhttp3.internal.http2.*;
import okhttp3.*;

@Metadata(mv = { 1, 8, 0 }, k = 1, xi = 48, d1 = { "\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0002J8\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0006\u0010'\u001a\u00020$J\n\u0010(\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060" }, d2 = { "Lokhttp3/internal/connection/ExchangeFinder;", "", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "getAddress$okhttp", "()Lokhttp3/Address;", "connectionShutdownCount", "", "nextRouteToTry", "Lokhttp3/Route;", "otherFailureCount", "refusedStreamCount", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "find", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "findConnection", "Lokhttp3/internal/connection/RealConnection;", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "", "findHealthyConnection", "doExtensiveHealthChecks", "retryAfterFailure", "retryRoute", "sameHostAndPort", "url", "Lokhttp3/HttpUrl;", "trackFailure", "", "e", "Ljava/io/IOException;", "okhttp" })
public class ExchangeFinder
{
    @NotNull
    private final RealConnectionPool connectionPool;
    @NotNull
    private final Address address;
    @NotNull
    private final RealCall call;
    @NotNull
    private final EventListener eventListener;
    @Nullable
    private RouteSelector.Selection routeSelection;
    @Nullable
    private RouteSelector routeSelector;
    private int refusedStreamCount;
    private int connectionShutdownCount;
    private int otherFailureCount;
    @Nullable
    private Route nextRouteToTry;
    
    public ExchangeFinder(@NotNull final RealConnectionPool connectionPool, @NotNull final Address address, @NotNull final RealCall call, @NotNull final EventListener eventListener) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
    }
    
    @NotNull
    public final Address getAddress$okhttp() {
        return this.address;
    }
    
    @NotNull
    public final ExchangeCodec find(@NotNull final OkHttpClient okHttpClient, @NotNull final RealInterceptorChain realInterceptorChain) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        Intrinsics.checkNotNullParameter(realInterceptorChain, "chain");
        try {
            return this.findHealthyConnection(realInterceptorChain.getConnectTimeoutMillis$okhttp(), realInterceptorChain.getReadTimeoutMillis$okhttp(), realInterceptorChain.getWriteTimeoutMillis$okhttp(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), !Intrinsics.areEqual(realInterceptorChain.getRequest$okhttp().method(), "GET")).newCodec$okhttp(okHttpClient, realInterceptorChain);
        }
        catch (final RouteException ex) {
            this.trackFailure(ex.getLastConnectException());
            throw ex;
        }
        catch (final IOException ex2) {
            this.trackFailure(ex2);
            throw new RouteException(ex2);
        }
    }
    
    private final RealConnection findHealthyConnection(final int n, final int n2, final int n3, final int n4, final boolean b, final boolean b2) throws IOException {
        while (true) {
            final RealConnection connection = this.findConnection(n, n2, n3, n4, b);
            if (connection.isHealthy(b2)) {
                return connection;
            }
            connection.noNewExchanges$okhttp();
            if (this.nextRouteToTry != null) {
                continue;
            }
            final RouteSelector.Selection routeSelection = this.routeSelection;
            if (routeSelection == null || routeSelection.hasNext()) {
                continue;
            }
            final RouteSelector routeSelector = this.routeSelector;
            if (routeSelector != null && !routeSelector.hasNext()) {
                throw new IOException("exhausted all routes");
            }
        }
    }
    
    private final RealConnection findConnection(final int n, final int n2, final int n3, final int n4, final boolean b) throws IOException {
        if (this.call.isCanceled()) {
            throw new IOException("Canceled");
        }
        final RealConnection connection = this.call.getConnection();
        if (connection != null) {
            Socket releaseConnectionNoEvents$okhttp = null;
            synchronized (connection) {
                if (connection.getNoNewExchanges() || !this.sameHostAndPort(connection.route().address().url())) {
                    releaseConnectionNoEvents$okhttp = this.call.releaseConnectionNoEvents$okhttp();
                }
                final Unit instance = Unit.INSTANCE;
            }
            if (this.call.getConnection() != null) {
                if (releaseConnectionNoEvents$okhttp != null) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                return connection;
            }
            else {
                final Socket socket = releaseConnectionNoEvents$okhttp;
                if (socket != null) {
                    Util.closeQuietly(socket);
                }
                this.eventListener.connectionReleased(this.call, connection);
            }
        }
        this.refusedStreamCount = 0;
        this.connectionShutdownCount = 0;
        this.otherFailureCount = 0;
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
            final RealConnection connection2 = this.call.getConnection();
            Intrinsics.checkNotNull(connection2);
            final RealConnection realConnection = connection2;
            this.eventListener.connectionAcquired(this.call, realConnection);
            return realConnection;
        }
        List<Route> routes = null;
        Route nextRouteToTry2 = null;
        Label_0476: {
            if (this.nextRouteToTry != null) {
                routes = null;
                final Route nextRouteToTry = this.nextRouteToTry;
                Intrinsics.checkNotNull(nextRouteToTry);
                nextRouteToTry2 = nextRouteToTry;
                this.nextRouteToTry = null;
            }
            else {
                if (this.routeSelection != null) {
                    final RouteSelector.Selection routeSelection = this.routeSelection;
                    Intrinsics.checkNotNull(routeSelection);
                    if (routeSelection.hasNext()) {
                        routes = null;
                        final RouteSelector.Selection routeSelection2 = this.routeSelection;
                        Intrinsics.checkNotNull(routeSelection2);
                        nextRouteToTry2 = routeSelection2.next();
                        break Label_0476;
                    }
                }
                RouteSelector routeSelector = this.routeSelector;
                if (routeSelector == null) {
                    routeSelector = new RouteSelector(this.address, this.call.getClient().getRouteDatabase(), this.call, this.eventListener);
                    this.routeSelector = routeSelector;
                }
                final RouteSelector.Selection next = routeSelector.next();
                this.routeSelection = next;
                routes = next.getRoutes();
                if (this.call.isCanceled()) {
                    throw new IOException("Canceled");
                }
                if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, false)) {
                    final RealConnection connection3 = this.call.getConnection();
                    Intrinsics.checkNotNull(connection3);
                    final RealConnection realConnection2 = connection3;
                    this.eventListener.connectionAcquired(this.call, realConnection2);
                    return realConnection2;
                }
                nextRouteToTry2 = next.next();
            }
        }
        final RealConnection connectionToCancel = new RealConnection(this.connectionPool, nextRouteToTry2);
        this.call.setConnectionToCancel(connectionToCancel);
        try {
            connectionToCancel.connect(n, n2, n3, n4, b, this.call, this.eventListener);
        }
        finally {
            this.call.setConnectionToCancel(null);
        }
        this.call.getClient().getRouteDatabase().connected(connectionToCancel.route());
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, true)) {
            final RealConnection connection4 = this.call.getConnection();
            Intrinsics.checkNotNull(connection4);
            final RealConnection realConnection3 = connection4;
            this.nextRouteToTry = nextRouteToTry2;
            Util.closeQuietly(connectionToCancel.socket());
            this.eventListener.connectionAcquired(this.call, realConnection3);
            return realConnection3;
        }
        synchronized (connectionToCancel) {
            this.connectionPool.put(connectionToCancel);
            this.call.acquireConnectionNoEvents(connectionToCancel);
            final Unit instance2 = Unit.INSTANCE;
        }
        this.eventListener.connectionAcquired(this.call, connectionToCancel);
        return connectionToCancel;
    }
    
    public final void trackFailure(@NotNull final IOException ex) {
        Intrinsics.checkNotNullParameter(ex, "e");
        this.nextRouteToTry = null;
        if (ex instanceof StreamResetException && ((StreamResetException)ex).errorCode == ErrorCode.REFUSED_STREAM) {
            ++this.refusedStreamCount;
        }
        else if (ex instanceof ConnectionShutdownException) {
            ++this.connectionShutdownCount;
        }
        else {
            ++this.otherFailureCount;
        }
    }
    
    public final boolean retryAfterFailure() {
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        final Route retryRoute = this.retryRoute();
        if (retryRoute != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        final RouteSelector.Selection routeSelection = this.routeSelection;
        if (routeSelection != null && routeSelection.hasNext()) {
            return true;
        }
        final RouteSelector routeSelector = this.routeSelector;
        return routeSelector == null || routeSelector.hasNext();
    }
    
    private final Route retryRoute() {
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0) {
            return null;
        }
        final RealConnection connection = this.call.getConnection();
        if (connection == null) {
            return null;
        }
        final RealConnection realConnection = connection;
        synchronized (realConnection) {
            if (realConnection.getRouteFailureCount$okhttp() != 0) {
                return null;
            }
            if (!Util.canReuseConnectionFor(realConnection.route().address().url(), this.address.url())) {
                return null;
            }
            return realConnection.route();
        }
    }
    
    public final boolean sameHostAndPort(@NotNull final HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter(httpUrl, "url");
        final HttpUrl url = this.address.url();
        return httpUrl.port() == url.port() && Intrinsics.areEqual(httpUrl.host(), url.host());
    }
}
