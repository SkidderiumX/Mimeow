/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.cookie;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.config.Lookup;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
@ThreadSafe
public class CookieSpecRegistry
implements Lookup<CookieSpecProvider> {
    private final ConcurrentHashMap<String, CookieSpecFactory> registeredSpecs = new ConcurrentHashMap();

    public void register(String string, CookieSpecFactory cookieSpecFactory) {
        Args.notNull(string, "Name");
        Args.notNull(cookieSpecFactory, "Cookie spec factory");
        this.registeredSpecs.put(string.toLowerCase(Locale.ENGLISH), cookieSpecFactory);
    }

    public void unregister(String string) {
        Args.notNull(string, "Id");
        this.registeredSpecs.remove(string.toLowerCase(Locale.ENGLISH));
    }

    public CookieSpec getCookieSpec(String string, HttpParams httpParams) throws IllegalStateException {
        Args.notNull(string, "Name");
        CookieSpecFactory cookieSpecFactory = this.registeredSpecs.get(string.toLowerCase(Locale.ENGLISH));
        if (cookieSpecFactory != null) {
            return cookieSpecFactory.newInstance(httpParams);
        }
        throw new IllegalStateException("Unsupported cookie spec: " + string);
    }

    public CookieSpec getCookieSpec(String string) throws IllegalStateException {
        return this.getCookieSpec(string, null);
    }

    public List<String> getSpecNames() {
        return new ArrayList<String>(this.registeredSpecs.keySet());
    }

    public void setItems(Map<String, CookieSpecFactory> map) {
        if (map == null) {
            return;
        }
        this.registeredSpecs.clear();
        this.registeredSpecs.putAll(map);
    }

    @Override
    public CookieSpecProvider lookup(final String string) {
        return new CookieSpecProvider(){

            public CookieSpec create(HttpContext httpContext) {
                HttpRequest httpRequest = (HttpRequest)httpContext.getAttribute("http.request");
                return CookieSpecRegistry.this.getCookieSpec(string, httpRequest.getParams());
            }
        };
    }
}

