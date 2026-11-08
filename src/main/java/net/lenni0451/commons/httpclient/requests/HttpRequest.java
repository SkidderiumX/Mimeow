/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.requests;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.lenni0451.commons.httpclient.HeaderStore;
import net.lenni0451.commons.httpclient.HttpClient;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.handler.HttpResponseHandler;
import net.lenni0451.commons.httpclient.retry.RetryConfig;
import net.lenni0451.commons.httpclient.utils.ResettableStorage;

public class HttpRequest
extends HeaderStore<HttpRequest> {
    private final String method;
    private final URL url;
    private boolean streamedRequest;
    private boolean streamedResponse;
    private FollowRedirects followRedirects = FollowRedirects.NOT_SET;
    private final ResettableStorage<CookieManager> cookieManager = new ResettableStorage();
    private final ResettableStorage<RetryConfig> retryHandler = new ResettableStorage();
    private final ResettableStorage<Boolean> ignoreInvalidSSL = new ResettableStorage();
    private WeakReference<HttpClient> boundClient;

    public HttpRequest(String string, String string2) throws MalformedURLException {
        this(string, new URL(string2));
    }

    public HttpRequest(String string, URL uRL) {
        this.method = string;
        this.url = uRL;
    }

    public String getMethod() {
        return this.method;
    }

    public URL getURL() {
        return this.url;
    }

    public boolean isStreamedRequest() {
        return this.streamedRequest;
    }

    public HttpRequest setStreamedRequest(boolean bl) {
        this.streamedRequest = bl;
        return this;
    }

    public boolean isStreamedResponse() {
        return this.streamedResponse;
    }

    public HttpRequest setStreamedResponse(boolean bl) {
        this.streamedResponse = bl;
        return this;
    }

    public FollowRedirects getFollowRedirects() {
        return this.followRedirects;
    }

    public HttpRequest setFollowRedirects(boolean bl) {
        return this.setFollowRedirects(bl ? FollowRedirects.FOLLOW : FollowRedirects.IGNORE);
    }

    public HttpRequest setFollowRedirects(@Nonnull FollowRedirects followRedirects) {
        this.followRedirects = followRedirects;
        return this;
    }

    public boolean isCookieManagerSet() {
        return this.cookieManager.isSet();
    }

    public HttpRequest unsetCookieManager() {
        this.cookieManager.unset();
        return this;
    }

    @Nullable
    public CookieManager getCookieManager() {
        return this.cookieManager.get();
    }

    public HttpRequest setCookieManager(@Nullable CookieManager cookieManager) {
        this.cookieManager.set(cookieManager);
        return this;
    }

    public boolean isRetryHandlerSet() {
        return this.retryHandler.isSet();
    }

    public HttpRequest unsetRetryHandler() {
        this.retryHandler.unset();
        return this;
    }

    @Nonnull
    public RetryConfig getRetryHandler() {
        return this.retryHandler.get();
    }

    public HttpRequest setRetryHandler(@Nonnull RetryConfig retryConfig) {
        this.retryHandler.set(retryConfig);
        return this;
    }

    public boolean isIgnoreInvalidSSLSet() {
        return this.ignoreInvalidSSL.isSet();
    }

    public HttpRequest unsetIgnoreInvalidSSL() {
        this.ignoreInvalidSSL.unset();
        return this;
    }

    public boolean getIgnoreInvalidSSL() {
        return this.ignoreInvalidSSL.get();
    }

    public HttpRequest setIgnoreInvalidSSL(boolean bl) {
        this.ignoreInvalidSSL.set(bl);
        return this;
    }

    public HttpRequest bind(@Nullable HttpClient httpClient) {
        this.boundClient = httpClient == null ? null : new WeakReference<HttpClient>(httpClient);
        return this;
    }

    public HttpResponse execute() throws IOException {
        HttpClient httpClient = null;
        if (this.boundClient != null) {
            httpClient = (HttpClient)this.boundClient.get();
        }
        if (httpClient == null) {
            httpClient = new HttpClient();
        }
        return httpClient.execute(this);
    }

    public <R> R execute(HttpResponseHandler<R> httpResponseHandler) throws IOException {
        HttpClient httpClient = null;
        if (this.boundClient != null) {
            httpClient = (HttpClient)this.boundClient.get();
        }
        if (httpClient == null) {
            httpClient = new HttpClient();
        }
        return httpClient.execute(this, httpResponseHandler);
    }

    public static enum FollowRedirects {
        NOT_SET,
        FOLLOW,
        IGNORE;

    }
}

