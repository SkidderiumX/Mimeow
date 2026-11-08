/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.executor;

import java.io.IOException;
import java.net.CookieManager;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.lenni0451.commons.httpclient.HttpClient;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.content.HttpContent;
import net.lenni0451.commons.httpclient.requests.HttpContentRequest;
import net.lenni0451.commons.httpclient.requests.HttpRequest;

public abstract class RequestExecutor {
    @Nonnull
    protected final HttpClient client;

    public RequestExecutor(@Nonnull HttpClient httpClient) {
        this.client = httpClient;
    }

    @Nonnull
    public abstract HttpResponse execute(@Nonnull HttpRequest var1) throws IOException, InterruptedException;

    protected final boolean isFollowRedirects(@Nonnull HttpRequest httpRequest) {
        switch (httpRequest.getFollowRedirects()) {
            case NOT_SET: {
                return this.client.isFollowRedirects();
            }
            case FOLLOW: {
                return true;
            }
            case IGNORE: {
                return false;
            }
        }
        throw new IllegalStateException("Unexpected value: " + (Object)((Object)httpRequest.getFollowRedirects()));
    }

    @Nullable
    protected final CookieManager getCookieManager(@Nonnull HttpRequest httpRequest) {
        return httpRequest.isCookieManagerSet() ? httpRequest.getCookieManager() : this.client.getCookieManager();
    }

    protected final boolean isIgnoreInvalidSSL(@Nonnull HttpRequest httpRequest) {
        return httpRequest.isIgnoreInvalidSSLSet() ? httpRequest.getIgnoreInvalidSSL() : this.client.isIgnoreInvalidSSL();
    }

    protected final Map<String, List<String>> getHeaders(@Nonnull HttpRequest httpRequest, @Nullable CookieManager cookieManager) throws IOException {
        return this.getHeaders(httpRequest, cookieManager, true);
    }

    protected final Map<String, List<String>> getHeaders(@Nonnull HttpRequest httpRequest, @Nullable CookieManager cookieManager, boolean bl) throws IOException {
        Iterator<Map.Entry<String, List<String>>> iterator2;
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        if (cookieManager != null) {
            try {
                iterator2 = cookieManager.get(httpRequest.getURL().toURI(), Collections.emptyMap());
                for (Map.Entry<String, List<String>> entry : iterator2.entrySet()) {
                    if (entry.getValue().isEmpty()) continue;
                    hashMap.put(entry.getKey().toLowerCase(), entry.getValue());
                }
            }
            catch (URISyntaxException uRISyntaxException) {
                throw new IOException("Failed to parse URL as URI", uRISyntaxException);
            }
        }
        if (httpRequest instanceof HttpContentRequest && bl && (iterator2 = ((HttpContentRequest)httpRequest).getContent()) != null) {
            hashMap.put("Content-Type".toLowerCase(), Collections.singletonList(((HttpContent)((Object)iterator2)).getType().toString()));
            if (((HttpContent)((Object)iterator2)).getLength() < 0) {
                hashMap.put("Content-Length".toLowerCase(), Collections.singletonList(String.valueOf(((HttpContent)((Object)iterator2)).getLength())));
            }
        }
        for (Map.Entry<String, List<String>> entry : this.client.getHeaders().entrySet()) {
            if (((List)entry.getValue()).isEmpty()) continue;
            hashMap.put(((String)entry.getKey()).toLowerCase(), entry.getValue());
        }
        for (Map.Entry<String, List<String>> entry : httpRequest.getHeaders().entrySet()) {
            if (entry.getValue().isEmpty()) continue;
            hashMap.put(entry.getKey().toLowerCase(), entry.getValue());
        }
        return hashMap;
    }

    protected final void updateCookies(@Nullable CookieManager cookieManager, URL uRL, Map<String, List<String>> map) throws IOException {
        if (cookieManager == null) {
            return;
        }
        try {
            cookieManager.put(uRL.toURI(), map);
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new IOException("Failed to parse URL as URI", uRISyntaxException);
        }
    }

    protected final void setHeaders(Map<String, List<String>> map, BiConsumer<String, String> biConsumer, BiConsumer<String, String> biConsumer2) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if ("Cookie".equalsIgnoreCase(entry.getKey())) {
                biConsumer.accept(entry.getKey(), String.join((CharSequence)"; ", (Iterable<? extends CharSequence>)entry.getValue()));
                continue;
            }
            boolean bl = true;
            for (String string : entry.getValue()) {
                if (bl) {
                    bl = false;
                    biConsumer.accept(entry.getKey(), string);
                    continue;
                }
                biConsumer2.accept(entry.getKey(), string);
            }
        }
    }
}

