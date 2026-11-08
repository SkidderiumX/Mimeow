/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.util;

import java.util.HashMap;
import java.util.Map;

public class UploadTokenCache {
    private static Map<Long, String> tokenCache = new HashMap<Long, String>();

    public static String get(long l) {
        return tokenCache.get(l);
    }

    public static void invalidate(long l) {
        tokenCache.remove(l);
    }

    public static void put(long l, String string) {
        tokenCache.put(l, string);
    }
}

