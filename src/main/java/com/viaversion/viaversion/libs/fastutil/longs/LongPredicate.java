/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import java.util.Objects;
import java.util.function.Predicate;

@FunctionalInterface
public interface LongPredicate
extends Predicate<Long>,
java.util.function.LongPredicate {
    @Override
    @Deprecated
    default public boolean test(Long l) {
        return this.test(l.longValue());
    }

    @Override
    default public LongPredicate and(java.util.function.LongPredicate longPredicate) {
        Objects.requireNonNull(longPredicate);
        return l -> this.test(l) && longPredicate.test(l);
    }

    default public LongPredicate and(LongPredicate longPredicate) {
        return this.and((java.util.function.LongPredicate)longPredicate);
    }

    @Override
    @Deprecated
    default public Predicate<Long> and(Predicate<? super Long> predicate) {
        return Predicate.super.and(predicate);
    }

    @Override
    default public LongPredicate negate() {
        return l -> !this.test(l);
    }

    @Override
    default public LongPredicate or(java.util.function.LongPredicate longPredicate) {
        Objects.requireNonNull(longPredicate);
        return l -> this.test(l) || longPredicate.test(l);
    }

    default public LongPredicate or(LongPredicate longPredicate) {
        return this.or((java.util.function.LongPredicate)longPredicate);
    }

    @Override
    @Deprecated
    default public Predicate<Long> or(Predicate<? super Long> predicate) {
        return Predicate.super.or(predicate);
    }
}

