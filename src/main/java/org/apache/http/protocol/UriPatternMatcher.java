/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.protocol;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@ThreadSafe
public class UriPatternMatcher<T> {
    @GuardedBy(value="this")
    private final Map<String, T> map = new HashMap<String, T>();

    public synchronized void register(String string, T t) {
        Args.notNull(string, "URI request pattern");
        this.map.put(string, t);
    }

    public synchronized void unregister(String string) {
        if (string == null) {
            return;
        }
        this.map.remove(string);
    }

    @Deprecated
    public synchronized void setHandlers(Map<String, T> map) {
        Args.notNull(map, "Map of handlers");
        this.map.clear();
        this.map.putAll(map);
    }

    @Deprecated
    public synchronized void setObjects(Map<String, T> map) {
        Args.notNull(map, "Map of handlers");
        this.map.clear();
        this.map.putAll(map);
    }

    @Deprecated
    public synchronized Map<String, T> getObjects() {
        return this.map;
    }

    public synchronized T lookup(String string) {
        Args.notNull(string, "Request path");
        T t = this.map.get(string);
        if (t == null) {
            String string2 = null;
            for (String string3 : this.map.keySet()) {
                if (!this.matchUriRequestPattern(string3, string) || string2 != null && string2.length() >= string3.length() && (string2.length() != string3.length() || !string3.endsWith("*"))) continue;
                t = this.map.get(string3);
                string2 = string3;
            }
        }
        return t;
    }

    protected boolean matchUriRequestPattern(String string, String string2) {
        if (string.equals("*")) {
            return true;
        }
        return string.endsWith("*") && string2.startsWith(string.substring(0, string.length() - 1)) || string.startsWith("*") && string2.endsWith(string.substring(1, string.length()));
    }

    public String toString() {
        return this.map.toString();
    }
}

