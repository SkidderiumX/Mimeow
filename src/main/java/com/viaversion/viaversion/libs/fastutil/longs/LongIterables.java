/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.LongIterable;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;

public class LongIterables {
    private LongIterables() {
    }

    public static long size(LongIterable longIterable) {
        long l = 0L;
        LongIterator longIterator = longIterable.iterator();
        while (longIterator.hasNext()) {
            long l2 = (Long)longIterator.next();
            ++l;
        }
        return l;
    }
}

