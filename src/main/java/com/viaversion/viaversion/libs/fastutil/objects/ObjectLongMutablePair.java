/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectLongPair;
import java.io.Serializable;
import java.util.Objects;

public class ObjectLongMutablePair<K>
implements ObjectLongPair<K>,
Serializable {
    private static final long serialVersionUID = 0L;
    protected K left;
    protected long right;

    public ObjectLongMutablePair(K k, long l) {
        this.left = k;
        this.right = l;
    }

    public static <K> ObjectLongMutablePair<K> of(K k, long l) {
        return new ObjectLongMutablePair<K>(k, l);
    }

    @Override
    public K left() {
        return this.left;
    }

    public ObjectLongMutablePair<K> left(K k) {
        this.left = k;
        return this;
    }

    @Override
    public long rightLong() {
        return this.right;
    }

    @Override
    public ObjectLongMutablePair<K> right(long l) {
        this.right = l;
        return this;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof ObjectLongPair) {
            return Objects.equals(this.left, ((ObjectLongPair)object).left()) && this.right == ((ObjectLongPair)object).rightLong();
        }
        if (object instanceof Pair) {
            return Objects.equals(this.left, ((Pair)object).left()) && Objects.equals(this.right, ((Pair)object).right());
        }
        return false;
    }

    public int hashCode() {
        return (this.left == null ? 0 : this.left.hashCode()) * 19 + HashCommon.long2int(this.right);
    }

    public String toString() {
        return "<" + this.left() + "," + this.rightLong() + ">";
    }
}

