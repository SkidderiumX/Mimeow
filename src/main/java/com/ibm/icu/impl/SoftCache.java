/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.CacheBase;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class SoftCache<K, V, D>
extends CacheBase<K, V, D> {
    private ConcurrentHashMap<K, SettableSoftReference<V>> map = new ConcurrentHashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final V getInstance(K k, D d) {
        SettableSoftReference<V> settableSoftReference = this.map.get(k);
        if (settableSoftReference != null) {
            SettableSoftReference<V> settableSoftReference2 = settableSoftReference;
            synchronized (settableSoftReference2) {
                Object object = ((SettableSoftReference)settableSoftReference).ref.get();
                if (object != null) {
                    return (V)object;
                }
                object = this.createInstance(k, d);
                if (object != null) {
                    ((SettableSoftReference)settableSoftReference).ref = new SoftReference(object);
                }
                return (V)object;
            }
        }
        Object v = this.createInstance(k, d);
        if (v == null) {
            return null;
        }
        settableSoftReference = this.map.putIfAbsent(k, new SettableSoftReference(v));
        if (settableSoftReference == null) {
            return v;
        }
        return (V)((SettableSoftReference)settableSoftReference).setIfAbsent(v);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static final class SettableSoftReference<V> {
        private SoftReference<V> ref;

        private SettableSoftReference(V v) {
            this.ref = new SoftReference<V>(v);
        }

        private synchronized V setIfAbsent(V v) {
            V v2 = this.ref.get();
            if (v2 == null) {
                this.ref = new SoftReference<V>(v);
                return v;
            }
            return v2;
        }
    }
}

