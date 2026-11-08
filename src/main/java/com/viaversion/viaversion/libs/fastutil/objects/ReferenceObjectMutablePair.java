/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceObjectPair;
import java.io.Serializable;
import java.util.Objects;

public class ReferenceObjectMutablePair<K, V>
implements ReferenceObjectPair<K, V>,
Serializable {
    private static final long serialVersionUID = 0L;
    protected K left;
    protected V right;

    public ReferenceObjectMutablePair(K k, V v) {
        this.left = k;
        this.right = v;
    }

    public static <K, V> ReferenceObjectMutablePair<K, V> of(K k, V v) {
        return new ReferenceObjectMutablePair<K, V>(k, v);
    }

    @Override
    public K left() {
        return this.left;
    }

    @Override
    public ReferenceObjectMutablePair<K, V> left(K k) {
        this.left = k;
        return this;
    }

    @Override
    public V right() {
        return this.right;
    }

    @Override
    public ReferenceObjectMutablePair<K, V> right(V v) {
        this.right = v;
        return this;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof Pair) {
            return this.left == ((Pair)object).left() && Objects.equals(this.right, ((Pair)object).right());
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.left) * 19 + (this.right == null ? 0 : this.right.hashCode());
    }

    public String toString() {
        return "<" + this.left() + "," + this.right() + ">";
    }
}

