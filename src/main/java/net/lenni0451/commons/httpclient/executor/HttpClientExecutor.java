/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.executor;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nonnull;
import net.lenni0451.commons.httpclient.HttpClient;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.content.HttpContent;
import net.lenni0451.commons.httpclient.executor.RequestExecutor;
import net.lenni0451.commons.httpclient.proxy.ProxyType;
import net.lenni0451.commons.httpclient.requests.HttpContentRequest;
import net.lenni0451.commons.httpclient.utils.IgnoringTrustManager;
import net.lenni0451.commons.httpclient.utils.URLWrapper;
import net.lenni0451.commons.httpclient.utils.stream.CloseListenerInputStream;

public class HttpClientExecutor
extends RequestExecutor {
    public HttpClientExecutor(HttpClient httpClient) {
        super(httpClient);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @Nonnull
    public HttpResponse execute(@Nonnull net.lenni0451.commons.httpclient.requests.HttpRequest httpRequest) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        java.net.http.HttpClient httpClient = null;
        boolean bl = true;
        try {
            httpClient = this.buildClient(httpRequest, executorService);
            HttpRequest httpRequest2 = this.buildRequest(httpRequest);
            if (httpRequest.isStreamedResponse()) {
                java.net.http.HttpResponse<InputStream> httpResponse = this.executeRequest(httpClient, httpRequest2, HttpResponse.BodyHandlers.ofInputStream());
                CloseListenerInputStream closeListenerInputStream = new CloseListenerInputStream(httpResponse.body(), this.closeListener(executorService, httpClient));
                bl = false;
                HttpResponse httpResponse2 = new HttpResponse(new URLWrapper(httpResponse.uri()).toURL(), httpResponse.statusCode(), closeListenerInputStream, httpResponse.headers().map());
                return httpResponse2;
            }
            java.net.http.HttpResponse<byte[]> httpResponse = this.executeRequest(httpClient, httpRequest2, HttpResponse.BodyHandlers.ofByteArray());
            HttpResponse httpResponse3 = new HttpResponse(new URLWrapper(httpResponse.uri()).toURL(), httpResponse.statusCode(), httpResponse.body(), httpResponse.headers().map());
            return httpResponse3;
        }
        finally {
            if (bl) {
                this.closeListener(executorService, httpClient).close();
            }
        }
    }

    private java.net.http.HttpClient buildClient(net.lenni0451.commons.httpclient.requests.HttpRequest httpRequest, Executor executor) throws IOException {
        HttpClient.Builder builder = java.net.http.HttpClient.newBuilder().executor(executor);
        CookieManager cookieManager = this.getCookieManager(httpRequest);
        if (cookieManager != null) {
            builder.cookieHandler(cookieManager);
        }
        if (this.isIgnoreInvalidSSL(httpRequest)) {
            builder.sslContext(IgnoringTrustManager.makeIgnoringSSLContext());
        }
        builder.connectTimeout(Duration.ofMillis(this.client.getConnectTimeout()));
        switch (httpRequest.getFollowRedirects()) {
            case NOT_SET: {
                builder.followRedirects(this.client.isFollowRedirects() ? HttpClient.Redirect.NORMAL : HttpClient.Redirect.NEVER);
                break;
            }
            case FOLLOW: {
                builder.followRedirects(HttpClient.Redirect.NORMAL);
                break;
            }
            case IGNORE: {
                builder.followRedirects(HttpClient.Redirect.NEVER);
            }
        }
        if (this.client.getProxyHandler().isProxySet()) {
            if (!ProxyType.HTTP.equals((Object)this.client.getProxyHandler().getProxyType())) {
                throw new UnsupportedOperationException("The Java 11 HttpClient only supports HTTP proxies");
            }
            builder.proxy(this.client.getProxyHandler().getProxySelector());
            if (this.client.getProxyHandler().getUsername() != null && this.client.getProxyHandler().getPassword() != null) {
                builder.authenticator(this.client.getProxyHandler().getProxyAuthenticator());
            }
        }
        return builder.build();
    }

    private HttpRequest buildRequest(net.lenni0451.commons.httpclient.requests.HttpRequest httpRequest) throws IOException {
        HttpRequest.BodyPublisher bodyPublisher;
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        builder.uri(new URLWrapper(httpRequest.getURL()).toURI());
        builder.timeout(Duration.ofMillis(this.client.getReadTimeout()));
        if (httpRequest instanceof HttpContentRequest && ((HttpContentRequest)httpRequest).hasContent()) {
            HttpContent httpContent = ((HttpContentRequest)httpRequest).getContent();
            if (httpRequest.isStreamedRequest()) {
                InputStream object = httpContent.getAsStream();
                bodyPublisher = HttpRequest.BodyPublishers.ofInputStream(() -> object);
            } else {
                bodyPublisher = HttpRequest.BodyPublishers.ofByteArray(httpContent.getAsBytes());
            }
        } else {
            bodyPublisher = HttpRequest.BodyPublishers.noBody();
        }
        builder.method(httpRequest.getMethod(), bodyPublisher);
        for (Map.Entry entry : this.getHeaders(httpRequest, null).entrySet()) {
            if (((String)entry.getKey()).equalsIgnoreCase("Content-Length")) continue;
            for (String string : (List)entry.getValue()) {
                builder.header((String)entry.getKey(), string);
            }
        }
        return builder.build();
    }

    private <T> java.net.http.HttpResponse<T> executeRequest(java.net.http.HttpClient httpClient, HttpRequest httpRequest, HttpResponse.BodyHandler<T> bodyHandler) throws IOException {
        try {
            return httpClient.send(httpRequest, bodyHandler);
        }
        catch (InterruptedException interruptedException) {
            throw new IOException("Request interrupted", interruptedException);
        }
    }

    private CloseListenerInputStream.CloseListener closeListener(ExecutorService executorService, java.net.http.HttpClient httpClient) {
        return () -> {
            executorService.shutdownNow();
            if (httpClient instanceof Closeable) {
                ((Closeable)((Object)httpClient)).close();
            }
        };
    }
}

