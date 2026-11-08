/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.longs.LongLongPair;
import java.io.Serializable;
import java.util.Objects;

public class LongLongImmutablePair
implements LongLongPair,
Serializable {
    private static final long serialVersionUID = 0L;
    protected final long left;
    protected final long right;

    public LongLongImmutablePair(long l, long l2) {
        this.left = l;
        this.right = l2;
    }

    public static LongLongImmutablePair of(long l, long l2) {
        return new LongLongImmutablePair(l, l2);
    }

    @Override
    public long leftLong() {
        return this.left;
    }

    @Override
    public long rightLong() {
        return this.right;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof LongLongPair) {
            return this.left == ((LongLongPair)object).leftLong() && this.right == ((LongLongPair)object).rightLong();
        }
        if (object instanceof Pair) {
            return Objects.equals(this.left, ((Pair)object).left()) && Objects.equals(this.right, ((Pair)object).right());
        }
        return false;
    }

    public int hashCode() {
        return HashCommon.long2int(this.left) * 19 + HashCommon.long2int(this.right);
    }

    public String toString() {
        return "<" + this.leftLong() + "," + this.rightLong() + ">";
    }
}

