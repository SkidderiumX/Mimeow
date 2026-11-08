/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractSortedKeySortedSetMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import com.google.common.collect.Serialization;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public class TreeMultimap<K, V>
extends AbstractSortedKeySortedSetMultimap<K, V> {
    private transient Comparator<? super K> keyComparator;
    private transient Comparator<? super V> valueComparator;
    @GwtIncompatible(value="not needed in emulated source")
    private static final long serialVersionUID = 0L;

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create() {
        return new TreeMultimap(Ordering.natural(), Ordering.natural());
    }

    public static <K, V> TreeMultimap<K, V> create(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        return new TreeMultimap<K, V>(Preconditions.checkNotNull(comparator), Preconditions.checkNotNull(comparator2));
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new TreeMultimap<K, V>(Ordering.natural(), Ordering.natural(), multimap);
    }

    TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        super(new TreeMap(comparator));
        this.keyComparator = comparator;
        this.valueComparator = comparator2;
    }

    private TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2, Multimap<? extends K, ? extends V> multimap) {
        this(comparator, comparator2);
        this.putAll((Multimap)multimap);
    }

    @Override
    SortedSet<V> createCollection() {
        return new TreeSet<V>(this.valueComparator);
    }

    @Override
    Collection<V> createCollection(@Nullable K k) {
        if (k == null) {
            this.keyComparator().compare(k, k);
        }
        return super.createCollection(k);
    }

    public Comparator<? super K> keyComparator() {
        return this.keyComparator;
    }

    @Override
    public Comparator<? super V> valueComparator() {
        return this.valueComparator;
    }

    @Override
    @GwtIncompatible(value="NavigableMap")
    NavigableMap<K, Collection<V>> backingMap() {
        return (NavigableMap)super.backingMap();
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    public NavigableSet<V> get(@Nullable K k) {
        return (NavigableSet)super.get((Object)k);
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    Collection<V> unmodifiableCollectionSubclass(Collection<V> collection) {
        return Sets.unmodifiableNavigableSet((NavigableSet)collection);
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    Collection<V> wrapCollection(K k, Collection<V> collection) {
        return new AbstractMapBasedMultimap.WrappedNavigableSet((AbstractMapBasedMultimap)this, k, (NavigableSet)collection, null);
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    public NavigableSet<K> keySet() {
        return (NavigableSet)super.keySet();
    }

    @Override
    @GwtIncompatible(value="NavigableSet")
    NavigableSet<K> createKeySet() {
        return new AbstractMapBasedMultimap.NavigableKeySet((AbstractMapBasedMultimap)this, this.backingMap());
    }

    @Override
    @GwtIncompatible(value="NavigableMap")
    public NavigableMap<K, Collection<V>> asMap() {
        return (NavigableMap)super.asMap();
    }

    @Override
    @GwtIncompatible(value="NavigableMap")
    NavigableMap<K, Collection<V>> createAsMap() {
        return new AbstractMapBasedMultimap.NavigableAsMap((AbstractMapBasedMultimap)this, this.backingMap());
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyComparator());
        objectOutputStream.writeObject(this.valueComparator());
        Serialization.writeMultimap(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyComparator = Preconditions.checkNotNull((Comparator)objectInputStream.readObject());
        this.valueComparator = Preconditions.checkNotNull((Comparator)objectInputStream.readObject());
        this.setMap(new TreeMap(this.keyComparator));
        Serialization.populateMultimap(this, objectInputStream);
    }
}

