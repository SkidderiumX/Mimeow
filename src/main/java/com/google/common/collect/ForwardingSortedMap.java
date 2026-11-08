/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedMap<K, V>
extends ForwardingMap<K, V>
implements SortedMap<K, V> {
    protected ForwardingSortedMap() {
    }

    @Override
    protected abstract SortedMap<K, V> delegate();

    @Override
    public Comparator<? super K> comparator() {
        return this.delegate().comparator();
    }

    @Override
    public K firstKey() {
        return this.delegate().firstKey();
    }

    @Override
    public SortedMap<K, V> headMap(K k) {
        return this.delegate().headMap(k);
    }

    @Override
    public K lastKey() {
        return this.delegate().lastKey();
    }

    @Override
    public SortedMap<K, V> subMap(K k, K k2) {
        return this.delegate().subMap(k, k2);
    }

    @Override
    public SortedMap<K, V> tailMap(K k) {
        return this.delegate().tailMap(k);
    }

    private int unsafeCompare(Object object, Object object2) {
        Comparator<K> comparator = this.comparator();
        if (comparator == null) {
            return ((Comparable)object).compareTo(object2);
        }
        return comparator.compare(object, object2);
    }

    @Override
    @Beta
    protected boolean standardContainsKey(@Nullable Object object) {
        try {
            ForwardingSortedMap forwardingSortedMap = this;
            Object object2 = forwardingSortedMap.tailMap(object).firstKey();
            return this.unsafeCompare(object2, object) == 0;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        catch (NoSuchElementException noSuchElementException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    @Beta
    protected SortedMap<K, V> standardSubMap(K k, K k2) {
        Preconditions.checkArgument(this.unsafeCompare(k, k2) <= 0, "fromKey must be <= toKey");
        return this.tailMap(k).headMap(k2);
    }

    @Beta
    protected class StandardKeySet
    extends Maps.SortedKeySet<K, V> {
        public StandardKeySet() {
            super(ForwardingSortedMap.this);
        }
    }
}

