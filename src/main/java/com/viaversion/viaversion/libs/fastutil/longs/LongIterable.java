/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.LongConsumer;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterators;
import java.util.Objects;
import java.util.function.Consumer;

public interface LongIterable
extends Iterable<Long> {
    public LongIterator iterator();

    default public LongIterator longIterator() {
        return this.iterator();
    }

    default public LongSpliterator spliterator() {
        return LongSpliterators.asSpliteratorUnknownSize(this.iterator(), 0);
    }

    default public LongSpliterator longSpliterator() {
        return this.spliterator();
    }

    default public void forEach(java.util.function.LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        this.iterator().forEachRemaining(longConsumer);
    }

    default public void forEach(LongConsumer longConsumer) {
        this.forEach((java.util.function.LongConsumer)longConsumer);
    }

    @Override
    @Deprecated
    default public void forEach(Consumer<? super Long> consumer) {
        Objects.requireNonNull(consumer);
        this.forEach(consumer instanceof java.util.function.LongConsumer ? (java.util.function.LongConsumer)((Object)consumer) : consumer::accept);
    }
}

