/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text;

import java.util.Map;
import java.util.Properties;

public abstract class StrLookup<V> {
    private static final StrLookup<String> NONE_LOOKUP = new MapStrLookup<String>(null);
    private static final StrLookup<String> SYSTEM_PROPERTIES_LOOKUP;

    public static StrLookup<?> noneLookup() {
        return NONE_LOOKUP;
    }

    public static StrLookup<String> systemPropertiesLookup() {
        return SYSTEM_PROPERTIES_LOOKUP;
    }

    public static <V> StrLookup<V> mapLookup(Map<String, V> map) {
        return new MapStrLookup<V>(map);
    }

    protected StrLookup() {
    }

    public abstract String lookup(String var1);

    static {
        StrLookup<String> strLookup = null;
        try {
            Properties properties;
            Properties properties2 = properties = System.getProperties();
            strLookup = new MapStrLookup<Object>(properties2);
        }
        catch (SecurityException securityException) {
            strLookup = NONE_LOOKUP;
        }
        SYSTEM_PROPERTIES_LOOKUP = strLookup;
    }

    public static class MapStrLookup<V>
    extends StrLookup<V> {
        private final Map<String, V> map;

        MapStrLookup(Map<String, V> map) {
            this.map = map;
        }

        @Override
        public String lookup(String string) {
            if (this.map == null) {
                return null;
            }
            V v = this.map.get(string);
            if (v == null) {
                return null;
            }
            return v.toString();
        }
    }
}

