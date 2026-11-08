/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.util;

public class Pair<A, B> {
    private final A first;
    private final B second;

    protected Pair(A a, B b) {
        this.first = a;
        this.second = b;
    }

    public static <A, B> Pair<A, B> of(A a, B b) {
        return new Pair<A, B>(a, b);
    }

    public A first() {
        return this.first;
    }

    public B second() {
        return this.second;
    }

    public String mkString(String string) {
        return String.format("%s%s%s", this.first, string, this.second);
    }
}

