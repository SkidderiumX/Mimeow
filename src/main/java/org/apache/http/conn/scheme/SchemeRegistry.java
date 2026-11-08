/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.scheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
@ThreadSafe
public class SchemeRegistry {
    private final ConcurrentHashMap<String, Scheme> registeredSchemes = new ConcurrentHashMap();

    public final Scheme getScheme(String string) {
        Scheme scheme = this.get(string);
        if (scheme == null) {
            throw new IllegalStateException("Scheme '" + string + "' not registered.");
        }
        return scheme;
    }

    public final Scheme getScheme(HttpHost httpHost) {
        Args.notNull(httpHost, "Host");
        return this.getScheme(httpHost.getSchemeName());
    }

    public final Scheme get(String string) {
        Args.notNull(string, "Scheme name");
        Scheme scheme = this.registeredSchemes.get(string);
        return scheme;
    }

    public final Scheme register(Scheme scheme) {
        Args.notNull(scheme, "Scheme");
        Scheme scheme2 = this.registeredSchemes.put(scheme.getName(), scheme);
        return scheme2;
    }

    public final Scheme unregister(String string) {
        Args.notNull(string, "Scheme name");
        Scheme scheme = this.registeredSchemes.remove(string);
        return scheme;
    }

    public final List<String> getSchemeNames() {
        return new ArrayList<String>(this.registeredSchemes.keySet());
    }

    public void setItems(Map<String, Scheme> map) {
        if (map == null) {
            return;
        }
        this.registeredSchemes.clear();
        this.registeredSchemes.putAll(map);
    }
}

