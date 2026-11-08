/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.AbstractLongSet;
import com.viaversion.viaversion.libs.fastutil.longs.LongBidirectionalIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSortedSet;

public abstract class AbstractLongSortedSet
extends AbstractLongSet
implements LongSortedSet {
    protected AbstractLongSortedSet() {
    }

    @Override
    public abstract LongBidirectionalIterator iterator();
}

