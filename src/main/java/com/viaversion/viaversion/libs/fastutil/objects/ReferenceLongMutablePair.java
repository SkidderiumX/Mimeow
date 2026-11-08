/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceLongPair;
import java.io.Serializable;
import java.util.Objects;

public class ReferenceLongMutablePair<K>
implements ReferenceLongPair<K>,
Serializable {
    private static final long serialVersionUID = 0L;
    protected K left;
    protected long right;

    public ReferenceLongMutablePair(K k, long l) {
        this.left = k;
        this.right = l;
    }

    public static <K> ReferenceLongMutablePair<K> of(K k, long l) {
        return new ReferenceLongMutablePair<K>(k, l);
    }

    @Override
    public K left() {
        return this.left;
    }

    public ReferenceLongMutablePair<K> left(K k) {
        this.left = k;
        return this;
    }

    @Override
    public long rightLong() {
        return this.right;
    }

    @Override
    public ReferenceLongMutablePair<K> right(long l) {
        this.right = l;
        return this;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof ReferenceLongPair) {
            return this.left == ((ReferenceLongPair)object).left() && this.right == ((ReferenceLongPair)object).rightLong();
        }
        if (object instanceof Pair) {
            return this.left == ((Pair)object).left() && Objects.equals(this.right, ((Pair)object).right());
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.left) * 19 + HashCommon.long2int(this.right);
    }

    public String toString() {
        return "<" + this.left() + "," + this.rightLong() + ">";
    }
}

