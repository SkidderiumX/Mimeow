/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.ints.IntConsumer;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntSpliterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntSpliterators;
import java.util.Objects;
import java.util.function.Consumer;

public interface IntIterable
extends Iterable<Integer> {
    public IntIterator iterator();

    default public IntIterator intIterator() {
        return this.iterator();
    }

    default public IntSpliterator spliterator() {
        return IntSpliterators.asSpliteratorUnknownSize(this.iterator(), 0);
    }

    default public IntSpliterator intSpliterator() {
        return this.spliterator();
    }

    default public void forEach(java.util.function.IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        this.iterator().forEachRemaining(intConsumer);
    }

    default public void forEach(IntConsumer intConsumer) {
        this.forEach((java.util.function.IntConsumer)intConsumer);
    }

    @Override
    @Deprecated
    default public void forEach(Consumer<? super Integer> consumer) {
        Objects.requireNonNull(consumer);
        this.forEach(consumer instanceof java.util.function.IntConsumer ? (java.util.function.IntConsumer)((Object)consumer) : consumer::accept);
    }
}

