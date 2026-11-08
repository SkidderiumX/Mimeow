/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.ints.IntIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectBidirectionalIterator;

public interface IntBidirectionalIterator
extends IntIterator,
ObjectBidirectionalIterator<Integer> {
    public int previousInt();

    @Override
    @Deprecated
    default public Integer previous() {
        return this.previousInt();
    }

    @Override
    default public int back(int n) {
        int n2 = n;
        while (n2-- != 0 && this.hasPrevious()) {
            this.previousInt();
        }
        return n - n2 - 1;
    }

    @Override
    default public int skip(int n) {
        return IntIterator.super.skip(n);
    }
}

