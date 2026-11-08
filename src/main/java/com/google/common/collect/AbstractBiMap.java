/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public abstract class AbstractBiMap<K, V>
extends ForwardingMap<K, V>
implements BiMap<K, V>,
Serializable {
    private transient Map<K, V> delegate;
    transient AbstractBiMap<V, K> inverse;
    private transient Set<K> keySet;
    private transient Set<V> valueSet;
    private transient Set<Map.Entry<K, V>> entrySet;
    @GwtIncompatible(value="Not needed in emulated source.")
    private static final long serialVersionUID = 0L;

    AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        this.setDelegates(map, map2);
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }

    @Override
    protected Map<K, V> delegate() {
        return this.delegate;
    }

    K checkKey(@Nullable K k) {
        return k;
    }

    V checkValue(@Nullable V v) {
        return v;
    }

    void setDelegates(Map<K, V> map, Map<V, K> map2) {
        Preconditions.checkState(this.delegate == null);
        Preconditions.checkState(this.inverse == null);
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkArgument(map2.isEmpty());
        Preconditions.checkArgument(map != map2);
        this.delegate = map;
        this.inverse = new Inverse<V, K>(map2, this);
    }

    void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return this.inverse.containsKey(object);
    }

    @Override
    public V put(@Nullable K k, @Nullable V v) {
        return this.putInBothMaps(k, v, false);
    }

    @Override
    public V forcePut(@Nullable K k, @Nullable V v) {
        return this.putInBothMaps(k, v, true);
    }

    private V putInBothMaps(@Nullable K k, @Nullable V v, boolean bl) {
        this.checkKey(k);
        this.checkValue(v);
        boolean bl2 = this.containsKey(k);
        if (bl2 && Objects.equal(v, this.get(k))) {
            return v;
        }
        if (bl) {
            this.inverse().remove(v);
        } else {
            Preconditions.checkArgument(!this.containsValue(v), "value already present: %s", v);
        }
        V v2 = this.delegate.put(k, v);
        this.updateInverseMap(k, bl2, v2, v);
        return v2;
    }

    private void updateInverseMap(K k, boolean bl, V v, V v2) {
        if (bl) {
            this.removeFromInverseMap(v);
        }
        this.inverse.delegate.put(v2, k);
    }

    @Override
    public V remove(@Nullable Object object) {
        return this.containsKey(object) ? (V)this.removeFromBothMaps(object) : null;
    }

    private V removeFromBothMaps(Object object) {
        V v = this.delegate.remove(object);
        this.removeFromInverseMap(v);
        return v;
    }

    private void removeFromInverseMap(V v) {
        this.inverse.delegate.remove(v);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override
    public BiMap<V, K> inverse() {
        return this.inverse;
    }

    @Override
    public Set<K> keySet() {
        KeySet keySet = this.keySet;
        return keySet == null ? (this.keySet = new KeySet()) : keySet;
    }

    @Override
    public Set<V> values() {
        ValueSet valueSet = this.valueSet;
        return valueSet == null ? (this.valueSet = new ValueSet()) : valueSet;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySet entrySet = this.entrySet;
        return entrySet == null ? (this.entrySet = new EntrySet()) : entrySet;
    }

    private static class Inverse<K, V>
    extends AbstractBiMap<K, V> {
        @GwtIncompatible(value="Not needed in emulated source.")
        private static final long serialVersionUID = 0L;

        private Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap);
        }

        @Override
        K checkKey(K k) {
            return this.inverse.checkValue(k);
        }

        @Override
        V checkValue(V v) {
            return this.inverse.checkKey(v);
        }

        @GwtIncompatible(value="java.io.ObjectOuputStream")
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.inverse());
        }

        @GwtIncompatible(value="java.io.ObjectInputStream")
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.setInverse((AbstractBiMap)objectInputStream.readObject());
        }

        @GwtIncompatible(value="Not needed in the emulated source.")
        Object readResolve() {
            return this.inverse().inverse();
        }
    }

    private class EntrySet
    extends ForwardingSet<Map.Entry<K, V>> {
        final Set<Map.Entry<K, V>> esDelegate;

        private EntrySet() {
            this.esDelegate = AbstractBiMap.this.delegate.entrySet();
        }

        @Override
        protected Set<Map.Entry<K, V>> delegate() {
            return this.esDelegate;
        }

        @Override
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override
        public boolean remove(Object object) {
            if (!this.esDelegate.contains(object)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            AbstractBiMap.this.inverse.delegate.remove(entry.getValue());
            this.esDelegate.remove(entry);
            return true;
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            final Iterator iterator2 = this.esDelegate.iterator();
            return new Iterator<Map.Entry<K, V>>(){
                Map.Entry<K, V> entry;

                @Override
                public boolean hasNext() {
                    return iterator2.hasNext();
                }

                @Override
                public Map.Entry<K, V> next() {
                    this.entry = (Map.Entry)iterator2.next();
                    final Map.Entry entry = this.entry;
                    return new ForwardingMapEntry<K, V>(){

                        @Override
                        protected Map.Entry<K, V> delegate() {
                            return entry;
                        }

                        @Override
                        public V setValue(V v) {
                            Preconditions.checkState(EntrySet.this.contains(this), "entry no longer in map");
                            if (Objects.equal(v, this.getValue())) {
                                return v;
                            }
                            Preconditions.checkArgument(!AbstractBiMap.this.containsValue(v), "value already present: %s", v);
                            Object v2 = entry.setValue(v);
                            Preconditions.checkState(Objects.equal(v, AbstractBiMap.this.get(this.getKey())), "entry no longer in map");
                            AbstractBiMap.this.updateInverseMap(this.getKey(), true, v2, v);
                            return v2;
                        }
                    };
                }

                @Override
                public void remove() {
                    CollectPreconditions.checkRemove(this.entry != null);
                    Object v = this.entry.getValue();
                    iterator2.remove();
                    AbstractBiMap.this.removeFromInverseMap(v);
                }
            };
        }

        @Override
        public Object[] toArray() {
            return this.standardToArray();
        }

        @Override
        public <T> T[] toArray(T[] TArray) {
            return this.standardToArray(TArray);
        }

        @Override
        public boolean contains(Object object) {
            return Maps.containsEntryImpl(this.delegate(), object);
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return this.standardContainsAll(collection);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return this.standardRemoveAll(collection);
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return this.standardRetainAll(collection);
        }
    }

    private class ValueSet
    extends ForwardingSet<V> {
        final Set<V> valuesDelegate;

        private ValueSet() {
            this.valuesDelegate = AbstractBiMap.this.inverse.keySet();
        }

        @Override
        protected Set<V> delegate() {
            return this.valuesDelegate;
        }

        @Override
        public Iterator<V> iterator() {
            return Maps.valueIterator(AbstractBiMap.this.entrySet().iterator());
        }

        @Override
        public Object[] toArray() {
            return this.standardToArray();
        }

        @Override
        public <T> T[] toArray(T[] TArray) {
            return this.standardToArray(TArray);
        }

        @Override
        public String toString() {
            return this.standardToString();
        }
    }

    private class KeySet
    extends ForwardingSet<K> {
        private KeySet() {
        }

        @Override
        protected Set<K> delegate() {
            return AbstractBiMap.this.delegate.keySet();
        }

        @Override
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override
        public boolean remove(Object object) {
            if (!this.contains(object)) {
                return false;
            }
            AbstractBiMap.this.removeFromBothMaps(object);
            return true;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return this.standardRemoveAll(collection);
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return this.standardRetainAll(collection);
        }

        @Override
        public Iterator<K> iterator() {
            return Maps.keyIterator(AbstractBiMap.this.entrySet().iterator());
        }
    }
}

