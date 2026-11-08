/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceIntImmutablePair;

public interface ReferenceIntPair<K>
extends Pair<K, Integer> {
    public int rightInt();

    @Override
    @Deprecated
    default public Integer right() {
        return this.rightInt();
    }

    default public ReferenceIntPair<K> right(int n) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default public ReferenceIntPair<K> right(Integer n) {
        return this.right((int)n);
    }

    default public int secondInt() {
        return this.rightInt();
    }

    @Override
    @Deprecated
    default public Integer second() {
        return this.secondInt();
    }

    default public ReferenceIntPair<K> second(int n) {
        return this.right(n);
    }

    @Deprecated
    default public ReferenceIntPair<K> second(Integer n) {
        return this.second((int)n);
    }

    default public int valueInt() {
        return this.rightInt();
    }

    @Override
    @Deprecated
    default public Integer value() {
        return this.valueInt();
    }

    default public ReferenceIntPair<K> value(int n) {
        return this.right(n);
    }

    @Deprecated
    default public ReferenceIntPair<K> value(Integer n) {
        return this.value((int)n);
    }

    public static <K> ReferenceIntPair<K> of(K k, int n) {
        return new ReferenceIntImmutablePair<K>(k, n);
    }
}

