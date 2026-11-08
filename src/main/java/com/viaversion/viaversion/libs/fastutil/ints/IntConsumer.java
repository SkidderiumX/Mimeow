/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.Objects;
import java.util.function.Consumer;

@FunctionalInterface
public interface IntConsumer
extends Consumer<Integer>,
java.util.function.IntConsumer {
    @Override
    @Deprecated
    default public void accept(Integer n) {
        this.accept(n.intValue());
    }

    @Override
    default public IntConsumer andThen(java.util.function.IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return n -> {
            this.accept(n);
            intConsumer.accept(n);
        };
    }

    default public IntConsumer andThen(IntConsumer intConsumer) {
        return this.andThen((java.util.function.IntConsumer)intConsumer);
    }

    @Override
    @Deprecated
    default public Consumer<Integer> andThen(Consumer<? super Integer> consumer) {
        return Consumer.super.andThen(consumer);
    }
}

