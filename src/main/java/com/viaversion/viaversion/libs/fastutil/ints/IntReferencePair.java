/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.ints.IntReferenceImmutablePair;

public interface IntReferencePair<V>
extends Pair<Integer, V> {
    public int leftInt();

    @Override
    @Deprecated
    default public Integer left() {
        return this.leftInt();
    }

    default public IntReferencePair<V> left(int n) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public IntReferencePair<V> left(Integer n) {
        return this.left((int)n);
    }

    default public int firstInt() {
        return this.leftInt();
    }

    @Override
    @Deprecated
    default public Integer first() {
        return this.firstInt();
    }

    default public IntReferencePair<V> first(int n) {
        return this.left(n);
    }

    @Deprecated
    default public IntReferencePair<V> first(Integer n) {
        return this.first((int)n);
    }

    default public int keyInt() {
        return this.firstInt();
    }

    @Override
    @Deprecated
    default public Integer key() {
        return this.keyInt();
    }

    default public IntReferencePair<V> key(int n) {
        return this.left(n);
    }

    @Deprecated
    default public IntReferencePair<V> key(Integer n) {
        return this.key((int)n);
    }

    public static <V> IntReferencePair<V> of(int n, V v) {
        return new IntReferenceImmutablePair<V>(n, v);
    }
}

