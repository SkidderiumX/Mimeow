/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.ints.IntObjectImmutablePair;
import java.util.Comparator;

public interface IntObjectPair<V>
extends Pair<Integer, V> {
    public int leftInt();

    @Override
    @Deprecated
    default public Integer left() {
        return this.leftInt();
    }

    default public IntObjectPair<V> left(int n) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public IntObjectPair<V> left(Integer n) {
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

    default public IntObjectPair<V> first(int n) {
        return this.left(n);
    }

    @Deprecated
    default public IntObjectPair<V> first(Integer n) {
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

    default public IntObjectPair<V> key(int n) {
        return this.left(n);
    }

    @Deprecated
    default public IntObjectPair<V> key(Integer n) {
        return this.key((int)n);
    }

    public static <V> IntObjectPair<V> of(int n, V v) {
        return new IntObjectImmutablePair<V>(n, v);
    }

    public static <V> Comparator<IntObjectPair<V>> lexComparator() {
        return (intObjectPair, intObjectPair2) -> {
            int n = Integer.compare(intObjectPair.leftInt(), intObjectPair2.leftInt());
            if (n != 0) {
                return n;
            }
            return ((Comparable)intObjectPair.right()).compareTo(intObjectPair2.right());
        };
    }
}

