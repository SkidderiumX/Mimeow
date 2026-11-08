/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.SortedPair;
import com.viaversion.viaversion.libs.fastutil.longs.LongLongImmutablePair;
import com.viaversion.viaversion.libs.fastutil.longs.LongLongSortedPair;
import java.io.Serializable;
import java.util.Objects;

public class LongLongImmutableSortedPair
extends LongLongImmutablePair
implements LongLongSortedPair,
Serializable {
    private static final long serialVersionUID = 0L;

    private LongLongImmutableSortedPair(long l, long l2) {
        super(l, l2);
    }

    public static LongLongImmutableSortedPair of(long l, long l2) {
        if (l <= l2) {
            return new LongLongImmutableSortedPair(l, l2);
        }
        return new LongLongImmutableSortedPair(l2, l);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof LongLongSortedPair) {
            return this.left == ((LongLongSortedPair)object).leftLong() && this.right == ((LongLongSortedPair)object).rightLong();
        }
        if (object instanceof SortedPair) {
            return Objects.equals(this.left, ((SortedPair)object).left()) && Objects.equals(this.right, ((SortedPair)object).right());
        }
        return false;
    }

    @Override
    public String toString() {
        return "{" + this.leftLong() + "," + this.rightLong() + "}";
    }
}

