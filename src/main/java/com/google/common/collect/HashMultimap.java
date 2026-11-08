/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractSetMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Serialization;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

@GwtCompatible(serializable=true, emulated=true)
public class HashMultimap<K, V>
extends AbstractSetMultimap<K, V> {
    private static final int DEFAULT_VALUES_PER_KEY = 2;
    @VisibleForTesting
    transient int expectedValuesPerKey = 2;
    @GwtIncompatible(value="Not needed in emulated source")
    private static final long serialVersionUID = 0L;

    public static <K, V> HashMultimap<K, V> create() {
        return new HashMultimap<K, V>();
    }

    public static <K, V> HashMultimap<K, V> create(int n, int n2) {
        return new HashMultimap<K, V>(n, n2);
    }

    public static <K, V> HashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new HashMultimap<K, V>(multimap);
    }

    private HashMultimap() {
        super(new HashMap());
    }

    private HashMultimap(int n, int n2) {
        super(Maps.newHashMapWithExpectedSize(n));
        Preconditions.checkArgument(n2 >= 0);
        this.expectedValuesPerKey = n2;
    }

    private HashMultimap(Multimap<? extends K, ? extends V> multimap) {
        super(Maps.newHashMapWithExpectedSize(multimap.keySet().size()));
        this.putAll(multimap);
    }

    @Override
    Set<V> createCollection() {
        return Sets.newHashSetWithExpectedSize(this.expectedValuesPerKey);
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.expectedValuesPerKey);
        Serialization.writeMultimap(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = objectInputStream.readInt();
        int n = Serialization.readCount(objectInputStream);
        HashMap hashMap = Maps.newHashMapWithExpectedSize(n);
        this.setMap(hashMap);
        Serialization.populateMultimap(this, objectInputStream, n);
    }
}

