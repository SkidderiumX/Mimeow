/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient;

import java.io.IOException;
import java.net.CookieManager;
import java.net.ProtocolException;
import java.net.UnknownHostException;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.net.ssl.SSLException;
import net.lenni0451.commons.httpclient.HeaderStore;
import net.lenni0451.commons.httpclient.HttpRequestBuilder;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.exceptions.RetryExceededException;
import net.lenni0451.commons.httpclient.executor.ExecutorType;
import net.lenni0451.commons.httpclient.executor.RequestExecutor;
import net.lenni0451.commons.httpclient.handler.HttpResponseHandler;
import net.lenni0451.commons.httpclient.proxy.ProxyHandler;
import net.lenni0451.commons.httpclient.requests.HttpRequest;
import net.lenni0451.commons.httpclient.retry.RetryAction;
import net.lenni0451.commons.httpclient.retry.RetryConfig;
import org.jetbrains.annotations.ApiStatus;

public class HttpClient
extends HeaderStore<HttpClient>
implements HttpRequestBuilder {
    private RequestExecutor executor;
    @Nullable
    private CookieManager cookieManager = new CookieManager();
    private boolean followRedirects = true;
    private int connectTimeout = 10000;
    private int readTimeout = 10000;
    private RetryConfig retryConfig = new RetryConfig();
    private ProxyHandler proxyHandler = new ProxyHandler();
    private boolean ignoreInvalidSSL = false;

    public HttpClient() {
        this(ExecutorType.AUTO);
    }

    public HttpClient(@Nonnull ExecutorType executorType) {
        this(executorType::makeExecutor);
    }

    public HttpClient(@Nonnull Function<HttpClient, RequestExecutor> function) {
        this.setExecutor(function);
    }

    public HttpClient setExecutor(@Nonnull Function<HttpClient, RequestExecutor> function) {
        RequestExecutor requestExecutor = function.apply(this);
        if (requestExecutor == null) {
            throw new NullPointerException("The executor supplier returned null");
        }
        this.executor = requestExecutor;
        return this;
    }

    @Nullable
    public CookieManager getCookieManager() {
        return this.cookieManager;
    }

    public HttpClient setCookieManager(@Nullable CookieManager cookieManager) {
        this.cookieManager = cookieManager;
        return this;
    }

    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    public HttpClient setFollowRedirects(boolean bl) {
        this.followRedirects = bl;
        return this;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public HttpClient setConnectTimeout(int n) {
        this.connectTimeout = n;
        return this;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public HttpClient setReadTimeout(int n) {
        this.readTimeout = n;
        return this;
    }

    @Nonnull
    public RetryConfig getRetryHandler() {
        return this.retryConfig;
    }

    public HttpClient setRetryConfig(@Nonnull RetryConfig retryConfig) {
        this.retryConfig = retryConfig;
        return this;
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public HttpClient setRetryHandler(@Nonnull RetryConfig retryConfig) {
        this.retryConfig = retryConfig;
        return this;
    }

    @Nonnull
    public ProxyHandler getProxyHandler() {
        return this.proxyHandler;
    }

    public HttpClient setProxyHandler(@Nonnull ProxyHandler proxyHandler) {
        this.proxyHandler = proxyHandler;
        return this;
    }

    public boolean isIgnoreInvalidSSL() {
        return this.ignoreInvalidSSL;
    }

    public HttpClient setIgnoreInvalidSSL(boolean bl) {
        this.ignoreInvalidSSL = bl;
        return this;
    }

    public <T extends HttpRequest, R> R executeAndHandle(T t) throws IOException {
        return this.execute(t, (HttpResponseHandler)((Object)t));
    }

    public <R> R execute(HttpRequest httpRequest, HttpResponseHandler<R> httpResponseHandler) throws IOException {
        return httpResponseHandler.handle(this.execute(httpRequest));
    }

    public HttpResponse execute(HttpRequest httpRequest) throws IOException {
        RetryConfig retryConfig = httpRequest.isRetryHandlerSet() ? httpRequest.getRetryHandler() : this.retryConfig;
        for (int i = 0; i <= retryConfig.getMaxConnectRetries(); ++i) {
            try {
                HttpResponse httpResponse = null;
                for (int j = 0; j <= retryConfig.getMaxResponseRetries(); ++j) {
                    httpResponse = this.executor.execute(httpRequest);
                    RetryAction retryAction = retryConfig.getRetryHandler().shouldRetry(httpResponse);
                    if (!retryAction.shouldRetry()) {
                        return httpResponse;
                    }
                    retryAction.sleep();
                }
                if (httpResponse == null) {
                    throw new IllegalStateException("Response not received but no exception was thrown");
                }
                if (retryConfig.getMaxResponseRetries() == 0) {
                    return httpResponse;
                }
                throw new RetryExceededException(httpResponse);
            }
            catch (InterruptedException interruptedException) {
                throw new IOException(interruptedException);
            }
            catch (ProtocolException | UnknownHostException | SSLException iOException) {
                throw iOException;
            }
            catch (IOException iOException) {
                if (i < retryConfig.getMaxConnectRetries()) continue;
                throw iOException;
            }
        }
        throw new IllegalStateException("Connect retry failed but no exception was thrown");
    }

    @Override
    public <T extends HttpRequest> T bind(T t) {
        t.bind(this);
        return t;
    }

    public String toString() {
        return "HttpClient#" + this.executor.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(this));
    }
}

