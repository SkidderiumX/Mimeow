/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceLongPair;
import java.io.Serializable;
import java.util.Objects;

public class ReferenceLongImmutablePair<K>
implements ReferenceLongPair<K>,
Serializable {
    private static final long serialVersionUID = 0L;
    protected final K left;
    protected final long right;

    public ReferenceLongImmutablePair(K k, long l) {
        this.left = k;
        this.right = l;
    }

    public static <K> ReferenceLongImmutablePair<K> of(K k, long l) {
        return new ReferenceLongImmutablePair<K>(k, l);
    }

    @Override
    public K left() {
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

