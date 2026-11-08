/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingMap;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
public abstract class ForwardingConcurrentMap<K, V>
extends ForwardingMap<K, V>
implements ConcurrentMap<K, V> {
    protected ForwardingConcurrentMap() {
    }

    @Override
    protected abstract ConcurrentMap<K, V> delegate();

    @Override
    public V putIfAbsent(K k, V v) {
        return this.delegate().putIfAbsent(k, v);
    }

    @Override
    public boolean remove(Object object, Object object2) {
        return this.delegate().remove(object, object2);
    }

    @Override
    public V replace(K k, V v) {
        return this.delegate().replace(k, v);
    }

    @Override
    public boolean replace(K k, V v, V v2) {
        return this.delegate().replace(k, v, v2);
    }
}

