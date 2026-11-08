/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.spi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.spi.ThreadContextMap;

public class DefaultThreadContextMap
implements ThreadContextMap {
    private final boolean useMap;
    private final ThreadLocal<Map<String, String>> localMap = new InheritableThreadLocal<Map<String, String>>(){

        @Override
        protected Map<String, String> childValue(Map<String, String> map) {
            return map == null || !DefaultThreadContextMap.this.useMap ? null : Collections.unmodifiableMap(new HashMap<String, String>(map));
        }
    };

    public DefaultThreadContextMap(boolean bl) {
        this.useMap = bl;
    }

    @Override
    public void put(String string, String string2) {
        if (!this.useMap) {
            return;
        }
        Map<String, String> map = this.localMap.get();
        map = map == null ? new HashMap<String, String>() : new HashMap<String, String>(map);
        map.put(string, string2);
        this.localMap.set(Collections.unmodifiableMap(map));
    }

    @Override
    public String get(String string) {
        Map<String, String> map = this.localMap.get();
        return map == null ? null : map.get(string);
    }

    @Override
    public void remove(String string) {
        Map<String, String> map = this.localMap.get();
        if (map != null) {
            HashMap<String, String> hashMap = new HashMap<String, String>(map);
            hashMap.remove(string);
            this.localMap.set(Collections.unmodifiableMap(hashMap));
        }
    }

    @Override
    public void clear() {
        this.localMap.remove();
    }

    @Override
    public boolean containsKey(String string) {
        Map<String, String> map = this.localMap.get();
        return map != null && map.containsKey(string);
    }

    @Override
    public Map<String, String> getCopy() {
        Map<String, String> map = this.localMap.get();
        return map == null ? new HashMap<String, String>() : new HashMap<String, String>(map);
    }

    @Override
    public Map<String, String> getImmutableMapOrNull() {
        return this.localMap.get();
    }

    @Override
    public boolean isEmpty() {
        Map<String, String> map = this.localMap.get();
        return map == null || map.size() == 0;
    }

    public String toString() {
        Map<String, String> map = this.localMap.get();
        return map == null ? "{}" : map.toString();
    }
}

