/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

public class IntegerCache {
    private static final Integer[] CACHE = new Integer[65535];

    public static Integer getInteger(int n) {
        return n >= 0 && n < CACHE.length ? CACHE[n] : new Integer(n);
    }

    static {
        int n = CACHE.length;
        for (int i = 0; i < n; ++i) {
            IntegerCache.CACHE[i] = i;
        }
    }
}

