/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.executor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.net.ssl.HttpsURLConnection;
import net.lenni0451.commons.httpclient.HttpClient;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.content.HttpContent;
import net.lenni0451.commons.httpclient.executor.RequestExecutor;
import net.lenni0451.commons.httpclient.proxy.ProxyHandler;
import net.lenni0451.commons.httpclient.proxy.SingleProxySelector;
import net.lenni0451.commons.httpclient.requests.HttpContentRequest;
import net.lenni0451.commons.httpclient.requests.HttpRequest;
import net.lenni0451.commons.httpclient.utils.IgnoringTrustManager;

public class URLConnectionExecutor
extends RequestExecutor {
    public URLConnectionExecutor(HttpClient httpClient) {
        super(httpClient);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @Nonnull
    public HttpResponse execute(@Nonnull HttpRequest httpRequest) throws IOException {
        CookieManager cookieManager = this.getCookieManager(httpRequest);
        ProxyHandler proxyHandler = this.client.getProxyHandler();
        SingleProxySelector singleProxySelector = null;
        if (proxyHandler.isProxySet()) {
            singleProxySelector = proxyHandler.getProxySelector();
        }
        try {
            if (singleProxySelector != null) {
                singleProxySelector.set(false);
            }
            HttpURLConnection httpURLConnection = this.openConnection(httpRequest, cookieManager, singleProxySelector == null ? null : proxyHandler);
            HttpResponse httpResponse = this.executeRequest(httpURLConnection, cookieManager, httpRequest);
            return httpResponse;
        }
        finally {
            if (singleProxySelector != null) {
                singleProxySelector.reset(false);
            }
        }
    }

    private HttpURLConnection openConnection(HttpRequest httpRequest, CookieManager cookieManager, ProxyHandler proxyHandler) throws IOException {
        URL uRL = httpRequest.getURL();
        HttpURLConnection httpURLConnection = proxyHandler == null ? (HttpURLConnection)uRL.openConnection() : (HttpURLConnection)uRL.openConnection(proxyHandler.toJavaProxy());
        if (this.isIgnoreInvalidSSL(httpRequest) && httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection)httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(IgnoringTrustManager.makeIgnoringSSLContext().getSocketFactory());
        }
        this.setupConnection(httpURLConnection, cookieManager, httpRequest);
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private void setupConnection(HttpURLConnection httpURLConnection, @Nullable CookieManager cookieManager, HttpRequest httpRequest) throws IOException {
        this.setHeaders(this.getHeaders(httpRequest, cookieManager), httpURLConnection::setRequestProperty, httpURLConnection::addRequestProperty);
        HttpContentRequest httpContentRequest = httpRequest instanceof HttpContentRequest ? (HttpContentRequest)httpRequest : null;
        HttpContent httpContent = httpContentRequest != null ? httpContentRequest.getContent() : null;
        httpURLConnection.setConnectTimeout(this.client.getConnectTimeout());
        httpURLConnection.setReadTimeout(this.client.getReadTimeout());
        httpURLConnection.setRequestMethod(httpRequest.getMethod());
        httpURLConnection.setDoInput(true);
        if (httpContentRequest != null && httpContent != null) {
            httpURLConnection.setDoOutput(true);
            if (httpRequest.isStreamedRequest()) {
                if (httpContent.getLength() >= 0) {
                    httpURLConnection.setFixedLengthStreamingMode(httpContent.getLength());
                } else {
                    httpURLConnection.setChunkedStreamingMode(0);
                }
            }
        } else {
            httpURLConnection.setDoOutput(false);
        }
        switch (httpRequest.getFollowRedirects()) {
            case NOT_SET: {
                httpURLConnection.setInstanceFollowRedirects(this.client.isFollowRedirects());
                break;
            }
            case FOLLOW: {
                httpURLConnection.setInstanceFollowRedirects(true);
                break;
            }
            case IGNORE: {
                httpURLConnection.setInstanceFollowRedirects(false);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private HttpResponse executeRequest(HttpURLConnection httpURLConnection, @Nullable CookieManager cookieManager, HttpRequest httpRequest) throws IOException {
        boolean bl = true;
        try {
            Object object;
            Object object2;
            Object object3;
            if (httpURLConnection.getDoOutput()) {
                object3 = ((HttpContentRequest)httpRequest).getContent();
                object2 = httpURLConnection.getOutputStream();
                try {
                    ((HttpContent)object3).transferTo((OutputStream)object2);
                }
                finally {
                    if (object2 != null) {
                        ((OutputStream)object2).close();
                    }
                }
            }
            object3 = new HashMap<String, List<String>>(httpURLConnection.getHeaderFields());
            object3.remove(null);
            InputStream inputStream2 = this.getInputStream(httpURLConnection);
            if (httpRequest.isStreamedResponse()) {
                object2 = new HttpResponse(httpRequest.getURL(), httpURLConnection.getResponseCode(), inputStream2, (Map<String, List<String>>)object3);
                bl = false;
            } else {
                object = this.readAllBytes(inputStream2, httpURLConnection.getContentLength());
                object2 = new HttpResponse(httpRequest.getURL(), httpURLConnection.getResponseCode(), (byte[])object, (Map<String, List<String>>)object3);
            }
            this.updateCookies(cookieManager, httpRequest.getURL(), httpURLConnection.getHeaderFields());
            object = object2;
            return object;
        }
        finally {
            if (bl) {
                httpURLConnection.disconnect();
            }
        }
    }

    private InputStream getInputStream(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream2 = httpURLConnection.getResponseCode() >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
        if (inputStream2 == null) {
            inputStream2 = new ByteArrayInputStream(new byte[0]);
        }
        return inputStream2;
    }

    private byte[] readAllBytes(InputStream inputStream2, int n) throws IOException {
        int n2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n >= 0 ? n : 1024);
        byte[] byArray = new byte[1024];
        while ((n2 = inputStream2.read(byArray)) >= 0) {
            byteArrayOutputStream.write(byArray, 0, n2);
        }
        return byteArrayOutputStream.toByteArray();
    }
}

