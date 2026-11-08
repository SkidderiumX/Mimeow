/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.ints.IntIterable;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterator;

public class IntIterables {
    private IntIterables() {
    }

    public static long size(IntIterable intIterable) {
        long l = 0L;
        IntIterator intIterator = intIterable.iterator();
        while (intIterator.hasNext()) {
            int n = (Integer)intIterator.next();
            ++l;
        }
        return l;
    }
}

