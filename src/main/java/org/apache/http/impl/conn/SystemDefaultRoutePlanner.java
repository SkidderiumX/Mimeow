/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.conn;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.impl.conn.DefaultRoutePlanner;
import org.apache.http.protocol.HttpContext;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Immutable
public class SystemDefaultRoutePlanner
extends DefaultRoutePlanner {
    private final ProxySelector proxySelector;

    public SystemDefaultRoutePlanner(SchemePortResolver schemePortResolver, ProxySelector proxySelector) {
        super(schemePortResolver);
        this.proxySelector = proxySelector != null ? proxySelector : ProxySelector.getDefault();
    }

    public SystemDefaultRoutePlanner(ProxySelector proxySelector) {
        this(null, proxySelector);
    }

    @Override
    protected HttpHost determineProxy(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        URI uRI;
        try {
            uRI = new URI(httpHost.toURI());
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new HttpException("Cannot convert host to URI: " + httpHost, uRISyntaxException);
        }
        List<Proxy> list = this.proxySelector.select(uRI);
        Proxy proxy = this.chooseProxy(list);
        HttpHost httpHost2 = null;
        if (proxy.type() == Proxy.Type.HTTP) {
            if (!(proxy.address() instanceof InetSocketAddress)) {
                throw new HttpException("Unable to handle non-Inet proxy address: " + proxy.address());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress)proxy.address();
            httpHost2 = new HttpHost(this.getHost(inetSocketAddress), inetSocketAddress.getPort());
        }
        return httpHost2;
    }

    private String getHost(InetSocketAddress inetSocketAddress) {
        return inetSocketAddress.isUnresolved() ? inetSocketAddress.getHostName() : inetSocketAddress.getAddress().getHostAddress();
    }

    private Proxy chooseProxy(List<Proxy> list) {
        Proxy proxy = null;
        block3: for (int i = 0; proxy == null && i < list.size(); ++i) {
            Proxy proxy2 = list.get(i);
            switch (proxy2.type()) {
                case DIRECT: 
                case HTTP: {
                    proxy = proxy2;
                    continue block3;
                }
            }
        }
        if (proxy == null) {
            proxy = Proxy.NO_PROXY;
        }
        return proxy;
    }
}

