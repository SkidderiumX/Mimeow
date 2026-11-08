/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

public class ObjectIterables {
    private ObjectIterables() {
    }

    public static <K> long size(Iterable<K> iterable) {
        long l = 0L;
        for (K k : iterable) {
            ++l;
        }
        return l;
    }
}

