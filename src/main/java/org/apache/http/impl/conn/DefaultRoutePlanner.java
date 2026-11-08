/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.net.InetAddress;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class DefaultRoutePlanner
implements HttpRoutePlanner {
    private final SchemePortResolver schemePortResolver;

    public DefaultRoutePlanner(SchemePortResolver schemePortResolver) {
        this.schemePortResolver = schemePortResolver != null ? schemePortResolver : DefaultSchemePortResolver.INSTANCE;
    }

    public HttpRoute determineRoute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        HttpHost httpHost2;
        Args.notNull(httpHost, "Target host");
        Args.notNull(httpRequest, "Request");
        HttpClientContext httpClientContext = HttpClientContext.adapt(httpContext);
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        InetAddress inetAddress = requestConfig.getLocalAddress();
        HttpHost httpHost3 = requestConfig.getProxy();
        if (httpHost3 == null) {
            httpHost3 = this.determineProxy(httpHost, httpRequest, httpContext);
        }
        if (httpHost.getPort() <= 0) {
            try {
                httpHost2 = new HttpHost(httpHost.getHostName(), this.schemePortResolver.resolve(httpHost), httpHost.getSchemeName());
            }
            catch (UnsupportedSchemeException unsupportedSchemeException) {
                throw new HttpException(unsupportedSchemeException.getMessage());
            }
        } else {
            httpHost2 = httpHost;
        }
        boolean bl = httpHost2.getSchemeName().equalsIgnoreCase("https");
        if (httpHost3 == null) {
            return new HttpRoute(httpHost2, inetAddress, bl);
        }
        return new HttpRoute(httpHost2, inetAddress, httpHost3, bl);
    }

    protected HttpHost determineProxy(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        return null;
    }
}

