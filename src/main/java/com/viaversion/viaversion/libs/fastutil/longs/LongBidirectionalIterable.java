/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.LongBidirectionalIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterable;

public interface LongBidirectionalIterable
extends LongIterable {
    @Override
    public LongBidirectionalIterator iterator();
}

