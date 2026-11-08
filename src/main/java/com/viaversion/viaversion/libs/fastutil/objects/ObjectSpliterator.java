/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.Spliterator;

public interface ObjectSpliterator<K>
extends Spliterator<K> {
    default public long skip(long l) {
        if (l < 0L) {
            throw new IllegalArgumentException("Argument must be nonnegative: " + l);
        }
        long l2 = l;
        while (l2-- != 0L && this.tryAdvance(object -> {})) {
        }
        return l - l2 - 1L;
    }

    @Override
    public ObjectSpliterator<K> trySplit();
}

