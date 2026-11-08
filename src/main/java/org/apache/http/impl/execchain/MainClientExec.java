/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.execchain;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthState;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.BasicRouteDirector;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRouteDirector;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.auth.HttpAuthenticator;
import org.apache.http.impl.conn.ConnectionShutdownException;
import org.apache.http.impl.execchain.ClientExecChain;
import org.apache.http.impl.execchain.ConnectionHolder;
import org.apache.http.impl.execchain.Proxies;
import org.apache.http.impl.execchain.RequestAbortedException;
import org.apache.http.impl.execchain.TunnelRefusedException;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

@Immutable
public class MainClientExec
implements ClientExecChain {
    private final Log log = LogFactory.getLog(this.getClass());
    private final HttpRequestExecutor requestExecutor;
    private final HttpClientConnectionManager connManager;
    private final ConnectionReuseStrategy reuseStrategy;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final HttpProcessor proxyHttpProcessor;
    private final AuthenticationStrategy targetAuthStrategy;
    private final AuthenticationStrategy proxyAuthStrategy;
    private final HttpAuthenticator authenticator;
    private final UserTokenHandler userTokenHandler;
    private final HttpRouteDirector routeDirector;

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        Args.notNull(httpRequestExecutor, "HTTP request executor");
        Args.notNull(httpClientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        Args.notNull(authenticationStrategy, "Target authentication strategy");
        Args.notNull(authenticationStrategy2, "Proxy authentication strategy");
        Args.notNull(userTokenHandler, "User token handler");
        this.authenticator = new HttpAuthenticator();
        this.proxyHttpProcessor = new ImmutableHttpProcessor(new RequestTargetHost(), new RequestClientConnControl());
        this.routeDirector = new BasicRouteDirector();
        this.requestExecutor = httpRequestExecutor;
        this.connManager = httpClientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
        this.targetAuthStrategy = authenticationStrategy;
        this.proxyAuthStrategy = authenticationStrategy2;
        this.userTokenHandler = userTokenHandler;
    }

    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        HttpClientConnection httpClientConnection;
        AuthState authState;
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        AuthState authState2 = httpClientContext.getTargetAuthState();
        if (authState2 == null) {
            authState2 = new AuthState();
            httpClientContext.setAttribute("http.auth.target-scope", authState2);
        }
        if ((authState = httpClientContext.getProxyAuthState()) == null) {
            authState = new AuthState();
            httpClientContext.setAttribute("http.auth.proxy-scope", authState);
        }
        if (httpRequestWrapper instanceof HttpEntityEnclosingRequest) {
            Proxies.enhanceEntity((HttpEntityEnclosingRequest)((Object)httpRequestWrapper));
        }
        Object object = httpClientContext.getUserToken();
        ConnectionRequest connectionRequest = this.connManager.requestConnection(httpRoute, object);
        if (httpExecutionAware != null) {
            if (httpExecutionAware.isAborted()) {
                connectionRequest.cancel();
                throw new RequestAbortedException("Request aborted");
            }
            httpExecutionAware.setCancellable(connectionRequest);
        }
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        try {
            int n = requestConfig.getConnectionRequestTimeout();
            httpClientConnection = connectionRequest.get(n > 0 ? (long)n : 0L, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw new RequestAbortedException("Request aborted", interruptedException);
        }
        catch (ExecutionException executionException) {
            Throwable throwable = executionException.getCause();
            if (throwable == null) {
                throwable = executionException;
            }
            throw new RequestAbortedException("Request execution failed", throwable);
        }
        httpClientContext.setAttribute("http.connection", httpClientConnection);
        if (requestConfig.isStaleConnectionCheckEnabled() && httpClientConnection.isOpen()) {
            this.log.debug("Stale connection check");
            if (httpClientConnection.isStale()) {
                this.log.debug("Stale connection detected");
                httpClientConnection.close();
            }
        }
        ConnectionHolder connectionHolder = new ConnectionHolder(this.log, this.connManager, httpClientConnection);
        try {
            HttpEntity httpEntity;
            HttpResponse httpResponse;
            if (httpExecutionAware != null) {
                httpExecutionAware.setCancellable(connectionHolder);
            }
            int n = 1;
            while (true) {
                int n2;
                if (n > 1 && !Proxies.isRepeatable(httpRequestWrapper)) {
                    throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
                }
                if (httpExecutionAware != null && httpExecutionAware.isAborted()) {
                    throw new RequestAbortedException("Request aborted");
                }
                if (!httpClientConnection.isOpen()) {
                    this.log.debug("Opening connection " + httpRoute);
                    try {
                        this.establishRoute(authState, httpClientConnection, httpRoute, httpRequestWrapper, httpClientContext);
                    }
                    catch (TunnelRefusedException tunnelRefusedException) {
                        if (this.log.isDebugEnabled()) {
                            this.log.debug(tunnelRefusedException.getMessage());
                        }
                        httpResponse = tunnelRefusedException.getResponse();
                        break;
                    }
                }
                if ((n2 = requestConfig.getSocketTimeout()) >= 0) {
                    httpClientConnection.setSocketTimeout(n2);
                }
                if (httpExecutionAware != null && httpExecutionAware.isAborted()) {
                    throw new RequestAbortedException("Request aborted");
                }
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Executing request " + httpRequestWrapper.getRequestLine());
                }
                if (!httpRequestWrapper.containsHeader("Authorization")) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Target auth state: " + (Object)((Object)authState2.getState()));
                    }
                    this.authenticator.generateAuthResponse(httpRequestWrapper, authState2, httpClientContext);
                }
                if (!httpRequestWrapper.containsHeader("Proxy-Authorization") && !httpRoute.isTunnelled()) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Proxy auth state: " + (Object)((Object)authState.getState()));
                    }
                    this.authenticator.generateAuthResponse(httpRequestWrapper, authState, httpClientContext);
                }
                if (this.reuseStrategy.keepAlive(httpResponse = this.requestExecutor.execute(httpRequestWrapper, httpClientConnection, httpClientContext), httpClientContext)) {
                    long l = this.keepAliveStrategy.getKeepAliveDuration(httpResponse, httpClientContext);
                    if (this.log.isDebugEnabled()) {
                        String string = l > 0L ? "for " + l + " " + (Object)((Object)TimeUnit.MILLISECONDS) : "indefinitely";
                        this.log.debug("Connection can be kept alive " + string);
                    }
                    connectionHolder.setValidFor(l, TimeUnit.MILLISECONDS);
                    connectionHolder.markReusable();
                } else {
                    connectionHolder.markNonReusable();
                }
                if (!this.needAuthentication(authState2, authState, httpRoute, httpResponse, httpClientContext)) break;
                HttpEntity httpEntity2 = httpResponse.getEntity();
                if (connectionHolder.isReusable()) {
                    EntityUtils.consume(httpEntity2);
                } else {
                    httpClientConnection.close();
                    if (authState.getState() == AuthProtocolState.SUCCESS && authState.getAuthScheme() != null && authState.getAuthScheme().isConnectionBased()) {
                        this.log.debug("Resetting proxy auth state");
                        authState.reset();
                    }
                    if (authState2.getState() == AuthProtocolState.SUCCESS && authState2.getAuthScheme() != null && authState2.getAuthScheme().isConnectionBased()) {
                        this.log.debug("Resetting target auth state");
                        authState2.reset();
                    }
                }
                HttpRequest httpRequest = httpRequestWrapper.getOriginal();
                if (!httpRequest.containsHeader("Authorization")) {
                    httpRequestWrapper.removeHeaders("Authorization");
                }
                if (!httpRequest.containsHeader("Proxy-Authorization")) {
                    httpRequestWrapper.removeHeaders("Proxy-Authorization");
                }
                ++n;
            }
            if (object == null) {
                object = this.userTokenHandler.getUserToken(httpClientContext);
                httpClientContext.setAttribute("http.user-token", object);
            }
            if (object != null) {
                connectionHolder.setState(object);
            }
            if ((httpEntity = httpResponse.getEntity()) == null || !httpEntity.isStreaming()) {
                connectionHolder.releaseConnection();
                return Proxies.enhanceResponse(httpResponse, null);
            }
            return Proxies.enhanceResponse(httpResponse, connectionHolder);
        }
        catch (ConnectionShutdownException connectionShutdownException) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
            interruptedIOException.initCause(connectionShutdownException);
            throw interruptedIOException;
        }
        catch (HttpException httpException) {
            connectionHolder.abortConnection();
            throw httpException;
        }
        catch (IOException iOException) {
            connectionHolder.abortConnection();
            throw iOException;
        }
        catch (RuntimeException runtimeException) {
            connectionHolder.abortConnection();
            throw runtimeException;
        }
    }

    void establishRoute(AuthState authState, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        int n;
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        int n2 = requestConfig.getConnectTimeout();
        RouteTracker routeTracker = new RouteTracker(httpRoute);
        do {
            HttpRoute httpRoute2 = routeTracker.toRoute();
            n = this.routeDirector.nextStep(httpRoute, httpRoute2);
            switch (n) {
                case 1: {
                    this.connManager.connect(httpClientConnection, httpRoute, n2 > 0 ? n2 : 0, httpClientContext);
                    routeTracker.connectTarget(httpRoute.isSecure());
                    break;
                }
                case 2: {
                    this.connManager.connect(httpClientConnection, httpRoute, n2 > 0 ? n2 : 0, httpClientContext);
                    HttpHost httpHost = httpRoute.getProxyHost();
                    routeTracker.connectProxy(httpHost, false);
                    break;
                }
                case 3: {
                    int n3 = this.createTunnelToTarget(authState, httpClientConnection, httpRoute, httpRequest, httpClientContext) ? 1 : 0;
                    this.log.debug("Tunnel to target created.");
                    routeTracker.tunnelTarget(n3 != 0);
                    break;
                }
                case 4: {
                    int n3 = httpRoute2.getHopCount() - 1;
                    boolean bl = this.createTunnelToProxy(httpRoute, n3, httpClientContext);
                    this.log.debug("Tunnel to proxy created.");
                    routeTracker.tunnelProxy(httpRoute.getHopTarget(n3), bl);
                    break;
                }
                case 5: {
                    this.connManager.upgrade(httpClientConnection, httpRoute, httpClientContext);
                    routeTracker.layerProtocol(httpRoute.isSecure());
                    break;
                }
                case -1: {
                    throw new HttpException("Unable to establish route: planned = " + httpRoute + "; current = " + httpRoute2);
                }
                case 0: {
                    this.connManager.routeComplete(httpClientConnection, httpRoute, httpClientContext);
                    break;
                }
                default: {
                    throw new IllegalStateException("Unknown step indicator " + n + " from RouteDirector.");
                }
            }
        } while (n > 0);
    }

    private boolean createTunnelToTarget(AuthState authState, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        HttpEntity httpEntity;
        int n;
        HttpResponse httpResponse;
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        int n2 = requestConfig.getConnectTimeout();
        HttpHost httpHost = httpRoute.getTargetHost();
        HttpHost httpHost2 = httpRoute.getProxyHost();
        String string = httpHost.toHostString();
        BasicHttpRequest basicHttpRequest = new BasicHttpRequest("CONNECT", string, httpRequest.getProtocolVersion());
        this.requestExecutor.preProcess(basicHttpRequest, this.proxyHttpProcessor, httpClientContext);
        while (true) {
            if (!httpClientConnection.isOpen()) {
                this.connManager.connect(httpClientConnection, httpRoute, n2 > 0 ? n2 : 0, httpClientContext);
            }
            basicHttpRequest.removeHeaders("Proxy-Authorization");
            this.authenticator.generateAuthResponse(basicHttpRequest, authState, httpClientContext);
            httpResponse = this.requestExecutor.execute(basicHttpRequest, httpClientConnection, httpClientContext);
            n = httpResponse.getStatusLine().getStatusCode();
            if (n < 200) {
                throw new HttpException("Unexpected response to CONNECT request: " + httpResponse.getStatusLine());
            }
            if (!requestConfig.isAuthenticationEnabled()) continue;
            if (!this.authenticator.isAuthenticationRequested(httpHost2, httpResponse, this.proxyAuthStrategy, authState, httpClientContext) || !this.authenticator.handleAuthChallenge(httpHost2, httpResponse, this.proxyAuthStrategy, authState, httpClientContext)) break;
            if (this.reuseStrategy.keepAlive(httpResponse, httpClientContext)) {
                this.log.debug("Connection kept alive");
                httpEntity = httpResponse.getEntity();
                EntityUtils.consume(httpEntity);
                continue;
            }
            httpClientConnection.close();
        }
        n = httpResponse.getStatusLine().getStatusCode();
        if (n > 299) {
            httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                httpResponse.setEntity(new BufferedHttpEntity(httpEntity));
            }
            httpClientConnection.close();
            throw new TunnelRefusedException("CONNECT refused by proxy: " + httpResponse.getStatusLine(), httpResponse);
        }
        return false;
    }

    private boolean createTunnelToProxy(HttpRoute httpRoute, int n, HttpClientContext httpClientContext) throws HttpException {
        throw new HttpException("Proxy chains are not supported.");
    }

    private boolean needAuthentication(AuthState authState, AuthState authState2, HttpRoute httpRoute, HttpResponse httpResponse, HttpClientContext httpClientContext) {
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        if (requestConfig.isAuthenticationEnabled()) {
            HttpHost httpHost = httpClientContext.getTargetHost();
            if (httpHost == null) {
                httpHost = httpRoute.getTargetHost();
            }
            if (httpHost.getPort() < 0) {
                httpHost = new HttpHost(httpHost.getHostName(), httpRoute.getTargetHost().getPort(), httpHost.getSchemeName());
            }
            boolean bl = this.authenticator.isAuthenticationRequested(httpHost, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
            HttpHost httpHost2 = httpRoute.getProxyHost();
            if (httpHost2 == null) {
                httpHost2 = httpRoute.getTargetHost();
            }
            boolean bl2 = this.authenticator.isAuthenticationRequested(httpHost2, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
            if (bl) {
                return this.authenticator.handleAuthChallenge(httpHost, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
            }
            if (bl2) {
                return this.authenticator.handleAuthChallenge(httpHost2, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
            }
        }
        return false;
    }
}

