/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.Iterator;

public interface ObjectIterator<K>
extends Iterator<K> {
    default public int skip(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument must be nonnegative: " + n);
        }
        int n2 = n;
        while (n2-- != 0 && this.hasNext()) {
            this.next();
        }
        return n - n2 - 1;
    }
}

