/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import java.util.HashMap;
import org.apache.http.HttpHost;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthScheme;
import org.apache.http.client.AuthCache;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.apache.http.util.Args;

@NotThreadSafe
public class BasicAuthCache
implements AuthCache {
    private final HashMap<HttpHost, AuthScheme> map = new HashMap();
    private final SchemePortResolver schemePortResolver;

    public BasicAuthCache(SchemePortResolver schemePortResolver) {
        this.schemePortResolver = schemePortResolver != null ? schemePortResolver : DefaultSchemePortResolver.INSTANCE;
    }

    public BasicAuthCache() {
        this(null);
    }

    protected HttpHost getKey(HttpHost httpHost) {
        if (httpHost.getPort() <= 0) {
            int n;
            try {
                n = this.schemePortResolver.resolve(httpHost);
            }
            catch (UnsupportedSchemeException unsupportedSchemeException) {
                return httpHost;
            }
            return new HttpHost(httpHost.getHostName(), n, httpHost.getSchemeName());
        }
        return httpHost;
    }

    public void put(HttpHost httpHost, AuthScheme authScheme) {
        Args.notNull(httpHost, "HTTP host");
        this.map.put(this.getKey(httpHost), authScheme);
    }

    public AuthScheme get(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        return this.map.get(this.getKey(httpHost));
    }

    public void remove(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        this.map.remove(this.getKey(httpHost));
    }

    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }
}

