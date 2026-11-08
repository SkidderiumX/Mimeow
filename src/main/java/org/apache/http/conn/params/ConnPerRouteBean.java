/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.params;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
@ThreadSafe
public class ConnPerRouteBean
implements ConnPerRoute {
    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 2;
    private final ConcurrentHashMap<HttpRoute, Integer> maxPerHostMap = new ConcurrentHashMap();
    private volatile int defaultMax;

    public ConnPerRouteBean(int n) {
        this.setDefaultMaxPerRoute(n);
    }

    public ConnPerRouteBean() {
        this(2);
    }

    public int getDefaultMax() {
        return this.defaultMax;
    }

    public int getDefaultMaxPerRoute() {
        return this.defaultMax;
    }

    public void setDefaultMaxPerRoute(int n) {
        Args.positive(n, "Defautl max per route");
        this.defaultMax = n;
    }

    public void setMaxForRoute(HttpRoute httpRoute, int n) {
        Args.notNull(httpRoute, "HTTP route");
        Args.positive(n, "Max per route");
        this.maxPerHostMap.put(httpRoute, n);
    }

    @Override
    public int getMaxForRoute(HttpRoute httpRoute) {
        Args.notNull(httpRoute, "HTTP route");
        Integer n = this.maxPerHostMap.get(httpRoute);
        if (n != null) {
            return n;
        }
        return this.defaultMax;
    }

    public void setMaxForRoutes(Map<HttpRoute, Integer> map) {
        if (map == null) {
            return;
        }
        this.maxPerHostMap.clear();
        this.maxPerHostMap.putAll(map);
    }

    public String toString() {
        return this.maxPerHostMap.toString();
    }
}

