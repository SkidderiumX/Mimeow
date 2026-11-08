/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectBidirectionalIterator;

public interface LongBidirectionalIterator
extends LongIterator,
ObjectBidirectionalIterator<Long> {
    public long previousLong();

    @Override
    @Deprecated
    default public Long previous() {
        return this.previousLong();
    }

    @Override
    default public int back(int n) {
        int n2 = n;
        while (n2-- != 0 && this.hasPrevious()) {
            this.previousLong();
        }
        return n - n2 - 1;
    }

    @Override
    default public int skip(int n) {
        return LongIterator.super.skip(n);
    }
}

