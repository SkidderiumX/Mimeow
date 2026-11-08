/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.longs.LongObjectPair;
import java.io.Serializable;
import java.util.Objects;

public class LongObjectMutablePair<V>
implements LongObjectPair<V>,
Serializable {
    private static final long serialVersionUID = 0L;
    protected long left;
    protected V right;

    public LongObjectMutablePair(long l, V v) {
        this.left = l;
        this.right = v;
    }

    public static <V> LongObjectMutablePair<V> of(long l, V v) {
        return new LongObjectMutablePair<V>(l, v);
    }

    @Override
    public long leftLong() {
        return this.left;
    }

    @Override
    public LongObjectMutablePair<V> left(long l) {
        this.left = l;
        return this;
    }

    @Override
    public V right() {
        return this.right;
    }

    public LongObjectMutablePair<V> right(V v) {
        this.right = v;
        return this;
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

