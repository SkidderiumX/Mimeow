/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceIntPair;
import java.io.Serializable;
import java.util.Objects;

public class ReferenceIntImmutablePair<K>
implements ReferenceIntPair<K>,
Serializable {
    private static final long serialVersionUID = 0L;
    protected final K left;
    protected final int right;

    public ReferenceIntImmutablePair(K k, int n) {
        this.left = k;
        this.right = n;
    }

    public static <K> ReferenceIntImmutablePair<K> of(K k, int n) {
        return new ReferenceIntImmutablePair<K>(k, n);
    }

    @Override
    public K left() {
        return this.left;
    }

    @Override
    public int rightInt() {
        return this.right;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof ReferenceIntPair) {
            return this.left == ((ReferenceIntPair)object).left() && this.right == ((ReferenceIntPair)object).rightInt();
        }
        if (object instanceof Pair) {
            return this.left == ((Pair)object).left() && Objects.equals(this.right, ((Pair)object).right());
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.left) * 19 + this.right;
    }

    public String toString() {
        return "<" + this.left() + "," + this.rightInt() + ">";
    }
}

