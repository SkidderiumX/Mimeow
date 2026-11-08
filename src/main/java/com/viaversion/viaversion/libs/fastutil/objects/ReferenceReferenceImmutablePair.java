/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceReferencePair;
import java.io.Serializable;

public class ReferenceReferenceImmutablePair<K, V>
implements ReferenceReferencePair<K, V>,
Serializable {
    private static final long serialVersionUID = 0L;
    protected final K left;
    protected final V right;

    public ReferenceReferenceImmutablePair(K k, V v) {
        this.left = k;
        this.right = v;
    }

    public static <K, V> ReferenceReferenceImmutablePair<K, V> of(K k, V v) {
        return new ReferenceReferenceImmutablePair<K, V>(k, v);
    }

    @Override
    public K left() {
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
        if (object instanceof Pair) {
            return this.left == ((Pair)object).left() && this.right == ((Pair)object).right();
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.left) * 19 + (this.right == null ? 0 : System.identityHashCode(this.right));
    }

    public String toString() {
        return "<" + this.left() + "," + this.right() + ">";
    }
}

