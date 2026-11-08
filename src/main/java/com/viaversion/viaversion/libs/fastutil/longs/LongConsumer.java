/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import java.util.Objects;
import java.util.function.Consumer;

@FunctionalInterface
public interface LongConsumer
extends Consumer<Long>,
java.util.function.LongConsumer {
    @Override
    @Deprecated
    default public void accept(Long l) {
        this.accept(l.longValue());
    }

    @Override
    default public LongConsumer andThen(java.util.function.LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return l -> {
            this.accept(l);
            longConsumer.accept(l);
        };
    }

    default public LongConsumer andThen(LongConsumer longConsumer) {
        return this.andThen((java.util.function.LongConsumer)longConsumer);
    }

    @Override
    @Deprecated
    default public Consumer<Long> andThen(Consumer<? super Long> consumer) {
        return Consumer.super.andThen(consumer);
    }
}

