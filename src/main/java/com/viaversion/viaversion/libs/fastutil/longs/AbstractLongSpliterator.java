/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.LongConsumer;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterator;

public abstract class AbstractLongSpliterator
implements LongSpliterator {
    protected AbstractLongSpliterator() {
    }

    @Override
    public final boolean tryAdvance(LongConsumer longConsumer) {
        return this.tryAdvance((java.util.function.LongConsumer)longConsumer);
    }

    @Override
    public final void forEachRemaining(LongConsumer longConsumer) {
        this.forEachRemaining((java.util.function.LongConsumer)longConsumer);
    }
}

