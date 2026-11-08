/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.util;

public class Tuple<T, K> {
    private final T _1;
    private final K _2;

    public Tuple(T t, K k) {
        this._1 = t;
        this._2 = k;
    }

    public K _2() {
        return this._2;
    }

    public T _1() {
        return this._1;
    }
}

