/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.routing;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Immutable
public class HttpRoute
implements RouteInfo,
Cloneable {
    private final HttpHost targetHost;
    private final InetAddress localAddress;
    private final List<HttpHost> proxyChain;
    private final RouteInfo.TunnelType tunnelled;
    private final RouteInfo.LayerType layered;
    private final boolean secure;

    private HttpRoute(HttpHost httpHost, InetAddress inetAddress, List<HttpHost> list, boolean bl, RouteInfo.TunnelType tunnelType, RouteInfo.LayerType layerType) {
        Args.notNull(httpHost, "Target host");
        this.targetHost = httpHost;
        this.localAddress = inetAddress;
        this.proxyChain = list != null && !list.isEmpty() ? new ArrayList<HttpHost>(list) : null;
        if (tunnelType == RouteInfo.TunnelType.TUNNELLED) {
            Args.check(this.proxyChain != null, "Proxy required if tunnelled");
        }
        this.secure = bl;
        this.tunnelled = tunnelType != null ? tunnelType : RouteInfo.TunnelType.PLAIN;
        this.layered = layerType != null ? layerType : RouteInfo.LayerType.PLAIN;
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, HttpHost[] httpHostArray, boolean bl, RouteInfo.TunnelType tunnelType, RouteInfo.LayerType layerType) {
        this(httpHost, inetAddress, httpHostArray != null ? Arrays.asList(httpHostArray) : null, bl, tunnelType, layerType);
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, HttpHost httpHost2, boolean bl, RouteInfo.TunnelType tunnelType, RouteInfo.LayerType layerType) {
        this(httpHost, inetAddress, httpHost2 != null ? Collections.singletonList(httpHost2) : null, bl, tunnelType, layerType);
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, boolean bl) {
        this(httpHost, inetAddress, Collections.emptyList(), bl, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
    }

    public HttpRoute(HttpHost httpHost) {
        this(httpHost, null, Collections.emptyList(), false, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, HttpHost httpHost2, boolean bl) {
        this(httpHost, inetAddress, Collections.singletonList(Args.notNull(httpHost2, "Proxy host")), bl, bl ? RouteInfo.TunnelType.TUNNELLED : RouteInfo.TunnelType.PLAIN, bl ? RouteInfo.LayerType.LAYERED : RouteInfo.LayerType.PLAIN);
    }

    public HttpRoute(HttpHost httpHost, HttpHost httpHost2) {
        this(httpHost, null, httpHost2, false);
    }

    @Override
    public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    @Override
    public final InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public final InetSocketAddress getLocalSocketAddress() {
        return this.localAddress != null ? new InetSocketAddress(this.localAddress, 0) : null;
    }

    @Override
    public final int getHopCount() {
        return this.proxyChain != null ? this.proxyChain.size() + 1 : 1;
    }

    @Override
    public final HttpHost getHopTarget(int n) {
        Args.notNegative(n, "Hop index");
        int n2 = this.getHopCount();
        Args.check(n < n2, "Hop index exceeds tracked route length");
        if (n < n2 - 1) {
            return this.proxyChain.get(n);
        }
        return this.targetHost;
    }

    @Override
    public final HttpHost getProxyHost() {
        return this.proxyChain != null && !this.proxyChain.isEmpty() ? this.proxyChain.get(0) : null;
    }

    @Override
    public final RouteInfo.TunnelType getTunnelType() {
        return this.tunnelled;
    }

    @Override
    public final boolean isTunnelled() {
        return this.tunnelled == RouteInfo.TunnelType.TUNNELLED;
    }

    @Override
    public final RouteInfo.LayerType getLayerType() {
        return this.layered;
    }

    @Override
    public final boolean isLayered() {
        return this.layered == RouteInfo.LayerType.LAYERED;
    }

    @Override
    public final boolean isSecure() {
        return this.secure;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof HttpRoute) {
            HttpRoute httpRoute = (HttpRoute)object;
            return this.secure == httpRoute.secure && this.tunnelled == httpRoute.tunnelled && this.layered == httpRoute.layered && LangUtils.equals(this.targetHost, httpRoute.targetHost) && LangUtils.equals(this.localAddress, httpRoute.localAddress) && LangUtils.equals(this.proxyChain, httpRoute.proxyChain);
        }
        return false;
    }

    public final int hashCode() {
        int n = 17;
        n = LangUtils.hashCode(n, this.targetHost);
        n = LangUtils.hashCode(n, this.localAddress);
        if (this.proxyChain != null) {
            for (HttpHost httpHost : this.proxyChain) {
                n = LangUtils.hashCode(n, httpHost);
            }
        }
        n = LangUtils.hashCode(n, this.secure);
        n = LangUtils.hashCode(n, (Object)this.tunnelled);
        n = LangUtils.hashCode(n, (Object)this.layered);
        return n;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(50 + this.getHopCount() * 30);
        if (this.localAddress != null) {
            stringBuilder.append(this.localAddress);
            stringBuilder.append("->");
        }
        stringBuilder.append('{');
        if (this.tunnelled == RouteInfo.TunnelType.TUNNELLED) {
            stringBuilder.append('t');
        }
        if (this.layered == RouteInfo.LayerType.LAYERED) {
            stringBuilder.append('l');
        }
        if (this.secure) {
            stringBuilder.append('s');
        }
        stringBuilder.append("}->");
        if (this.proxyChain != null) {
            for (HttpHost httpHost : this.proxyChain) {
                stringBuilder.append(httpHost);
                stringBuilder.append("->");
            }
        }
        stringBuilder.append(this.targetHost);
        return stringBuilder.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

