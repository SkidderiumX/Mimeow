/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.Objects;
import java.util.function.Predicate;

@FunctionalInterface
public interface IntPredicate
extends Predicate<Integer>,
java.util.function.IntPredicate {
    @Override
    @Deprecated
    default public boolean test(Integer n) {
        return this.test(n.intValue());
    }

    @Override
    default public IntPredicate and(java.util.function.IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate);
        return n -> this.test(n) && intPredicate.test(n);
    }

    default public IntPredicate and(IntPredicate intPredicate) {
        return this.and((java.util.function.IntPredicate)intPredicate);
    }

    @Override
    @Deprecated
    default public Predicate<Integer> and(Predicate<? super Integer> predicate) {
        return Predicate.super.and(predicate);
    }

    @Override
    default public IntPredicate negate() {
        return n -> !this.test(n);
    }

    @Override
    default public IntPredicate or(java.util.function.IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate);
        return n -> this.test(n) || intPredicate.test(n);
    }

    default public IntPredicate or(IntPredicate intPredicate) {
        return this.or((java.util.function.IntPredicate)intPredicate);
    }

    @Override
    @Deprecated
    default public Predicate<Integer> or(Predicate<? super Integer> predicate) {
        return Predicate.super.or(predicate);
    }
}

