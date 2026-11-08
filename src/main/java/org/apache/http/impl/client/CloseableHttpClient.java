/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@ThreadSafe
public abstract class CloseableHttpClient
implements HttpClient,
Closeable {
    private final Log log = LogFactory.getLog(this.getClass());

    protected abstract CloseableHttpResponse doExecute(HttpHost var1, HttpRequest var2, HttpContext var3) throws IOException, ClientProtocolException;

    @Override
    public CloseableHttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        return this.doExecute(httpHost, httpRequest, httpContext);
    }

    @Override
    public CloseableHttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        Args.notNull(httpUriRequest, "HTTP request");
        return this.doExecute(CloseableHttpClient.determineTarget(httpUriRequest), httpUriRequest, httpContext);
    }

    private static HttpHost determineTarget(HttpUriRequest httpUriRequest) throws ClientProtocolException {
        HttpHost httpHost = null;
        URI uRI = httpUriRequest.getURI();
        if (uRI.isAbsolute() && (httpHost = URIUtils.extractHost(uRI)) == null) {
            throw new ClientProtocolException("URI does not specify a valid host name: " + uRI);
        }
        return httpHost;
    }

    @Override
    public CloseableHttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException {
        return this.execute(httpUriRequest, (HttpContext)null);
    }

    @Override
    public CloseableHttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException {
        return this.doExecute(httpHost, httpRequest, null);
    }

    @Override
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return this.execute(httpUriRequest, responseHandler, null);
    }

    @Override
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        HttpHost httpHost = CloseableHttpClient.determineTarget(httpUriRequest);
        return this.execute(httpHost, httpUriRequest, responseHandler, httpContext);
    }

    @Override
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return this.execute(httpHost, httpRequest, responseHandler, null);
    }

    @Override
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        T t;
        Args.notNull(responseHandler, "Response handler");
        CloseableHttpResponse closeableHttpResponse = this.execute(httpHost, httpRequest, httpContext);
        try {
            t = responseHandler.handleResponse(closeableHttpResponse);
        }
        catch (Exception exception) {
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            try {
                EntityUtils.consume(httpEntity);
            }
            catch (Exception exception2) {
                this.log.warn("Error consuming content after an exception.", exception2);
            }
            if (exception instanceof RuntimeException) {
                throw (RuntimeException)exception;
            }
            if (exception instanceof IOException) {
                throw (IOException)exception;
            }
            throw new UndeclaredThrowableException(exception);
        }
        HttpEntity httpEntity = closeableHttpResponse.getEntity();
        EntityUtils.consume(httpEntity);
        return t;
    }
}

