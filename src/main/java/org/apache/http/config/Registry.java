/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.config;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.config.Lookup;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@ThreadSafe
public class Registry<I>
implements Lookup<I> {
    private final Map<String, I> map;

    Registry(Map<String, I> map) {
        this.map = new ConcurrentHashMap<String, I>(map);
    }

    @Override
    public I lookup(String string) {
        if (string == null) {
            return null;
        }
        return this.map.get(string.toLowerCase(Locale.US));
    }

    public String toString() {
        return this.map.toString();
    }
}

