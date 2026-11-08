/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@GwtCompatible
public class WellBehavedMap<K, V>
extends ForwardingMap<K, V> {
    private final Map<K, V> delegate;
    private Set<Map.Entry<K, V>> entrySet;

    private WellBehavedMap(Map<K, V> map) {
        this.delegate = map;
    }

    static <K, V> WellBehavedMap<K, V> wrap(Map<K, V> map) {
        return new WellBehavedMap<K, V>(map);
    }

    @Override
    protected Map<K, V> delegate() {
        return this.delegate;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        this.entrySet = new EntrySet();
        return this.entrySet;
    }

    private final class EntrySet
    extends Maps.EntrySet<K, V> {
        private EntrySet() {
        }

        @Override
        Map<K, V> map() {
            return WellBehavedMap.this;
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new TransformedIterator<K, Map.Entry<K, V>>(WellBehavedMap.this.keySet().iterator()){

                @Override
                Map.Entry<K, V> transform(final K k) {
                    return new AbstractMapEntry<K, V>(){

                        @Override
                        public K getKey() {
                            return k;
                        }

                        @Override
                        public V getValue() {
                            return WellBehavedMap.this.get(k);
                        }

                        @Override
                        public V setValue(V v) {
                            return WellBehavedMap.this.put(k, v);
                        }
                    };
                }
            };
        }
    }
}

