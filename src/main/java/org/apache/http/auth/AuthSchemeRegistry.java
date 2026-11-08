/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.config.Lookup;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
@ThreadSafe
public class AuthSchemeRegistry
implements Lookup<AuthSchemeProvider> {
    private final ConcurrentHashMap<String, AuthSchemeFactory> registeredSchemes = new ConcurrentHashMap();

    public void register(String string, AuthSchemeFactory authSchemeFactory) {
        Args.notNull(string, "Name");
        Args.notNull(authSchemeFactory, "Authentication scheme factory");
        this.registeredSchemes.put(string.toLowerCase(Locale.ENGLISH), authSchemeFactory);
    }

    public void unregister(String string) {
        Args.notNull(string, "Name");
        this.registeredSchemes.remove(string.toLowerCase(Locale.ENGLISH));
    }

    public AuthScheme getAuthScheme(String string, HttpParams httpParams) throws IllegalStateException {
        Args.notNull(string, "Name");
        AuthSchemeFactory authSchemeFactory = this.registeredSchemes.get(string.toLowerCase(Locale.ENGLISH));
        if (authSchemeFactory != null) {
            return authSchemeFactory.newInstance(httpParams);
        }
        throw new IllegalStateException("Unsupported authentication scheme: " + string);
    }

    public List<String> getSchemeNames() {
        return new ArrayList<String>(this.registeredSchemes.keySet());
    }

    public void setItems(Map<String, AuthSchemeFactory> map) {
        if (map == null) {
            return;
        }
        this.registeredSchemes.clear();
        this.registeredSchemes.putAll(map);
    }

    @Override
    public AuthSchemeProvider lookup(final String string) {
        return new AuthSchemeProvider(){

            public AuthScheme create(HttpContext httpContext) {
                HttpRequest httpRequest = (HttpRequest)httpContext.getAttribute("http.request");
                return AuthSchemeRegistry.this.getAuthScheme(string, httpRequest.getParams());
            }
        };
    }
}

