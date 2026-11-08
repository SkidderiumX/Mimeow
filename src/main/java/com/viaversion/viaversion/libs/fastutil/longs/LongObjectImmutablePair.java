/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.longs.LongObjectPair;
import java.io.Serializable;
import java.util.Objects;

public class LongObjectImmutablePair<V>
implements LongObjectPair<V>,
Serializable {
    private static final long serialVersionUID = 0L;
    protected final long left;
    protected final V right;

    public LongObjectImmutablePair(long l, V v) {
        this.left = l;
        this.right = v;
    }

    public static <V> LongObjectImmutablePair<V> of(long l, V v) {
        return new LongObjectImmutablePair<V>(l, v);
    }

    @Override
    public long leftLong() {
        return this.left;
    }

    @Override
    public V right() {
        return this.right;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof LongObjectPair) {
            return this.left == ((LongObjectPair)object).leftLong() && Objects.equals(this.right, ((LongObjectPair)object).right());
        }
        if (object instanceof Pair) {
            return Objects.equals(this.left, ((Pair)object).left()) && Objects.equals(this.right, ((Pair)object).right());
        }
        return false;
    }

    public int hashCode() {
        return HashCommon.long2int(this.left) * 19 + (this.right == null ? 0 : this.right.hashCode());
    }

    public String toString() {
        return "<" + this.leftLong() + "," + this.right() + ">";
    }
}

