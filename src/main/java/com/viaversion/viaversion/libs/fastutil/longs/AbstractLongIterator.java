/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.LongConsumer;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;

public abstract class AbstractLongIterator
implements LongIterator {
    protected AbstractLongIterator() {
    }

    @Override
    public final void forEachRemaining(LongConsumer longConsumer) {
        this.forEachRemaining((java.util.function.LongConsumer)longConsumer);
    }
}

