/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectReferencePair;
import java.io.Serializable;
import java.util.Objects;

public class ObjectReferenceMutablePair<K, V>
implements ObjectReferencePair<K, V>,
Serializable {
    private static final long serialVersionUID = 0L;
    protected K left;
    protected V right;

    public ObjectReferenceMutablePair(K k, V v) {
        this.left = k;
        this.right = v;
    }

    public static <K, V> ObjectReferenceMutablePair<K, V> of(K k, V v) {
        return new ObjectReferenceMutablePair<K, V>(k, v);
    }

    @Override
    public K left() {
        return this.left;
    }

    @Override
    public ObjectReferenceMutablePair<K, V> left(K k) {
        this.left = k;
        return this;
    }

    @Override
    public V right() {
        return this.right;
    }

    @Override
    public ObjectReferenceMutablePair<K, V> right(V v) {
        this.right = v;
        return this;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof Pair) {
            return Objects.equals(this.left, ((Pair)object).left()) && this.right == ((Pair)object).right();
        }
        return false;
    }

    public int hashCode() {
        return (this.left == null ? 0 : this.left.hashCode()) * 19 + (this.right == null ? 0 : System.identityHashCode(this.right));
    }

    public String toString() {
        return "<" + this.left() + "," + this.right() + ">";
    }
}

