/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.longs.LongReferencePair;
import java.io.Serializable;
import java.util.Objects;

public class LongReferenceImmutablePair<V>
implements LongReferencePair<V>,
Serializable {
    private static final long serialVersionUID = 0L;
    protected final long left;
    protected final V right;

    public LongReferenceImmutablePair(long l, V v) {
        this.left = l;
        this.right = v;
    }

    public static <V> LongReferenceImmutablePair<V> of(long l, V v) {
        return new LongReferenceImmutablePair<V>(l, v);
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
        if (object instanceof LongReferencePair) {
            return this.left == ((LongReferencePair)object).leftLong() && this.right == ((LongReferencePair)object).right();
        }
        if (object instanceof Pair) {
            return Objects.equals(this.left, ((Pair)object).left()) && this.right == ((Pair)object).right();
        }
        return false;
    }

    public int hashCode() {
        return HashCommon.long2int(this.left) * 19 + (this.right == null ? 0 : System.identityHashCode(this.right));
    }

    public String toString() {
        return "<" + this.leftLong() + "," + this.right() + ">";
    }
}

