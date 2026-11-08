/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Multisets;
import com.google.common.collect.Serialization;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

@GwtCompatible(serializable=true, emulated=true)
public class HashMultiset<E>
extends AbstractMapBasedMultiset<E> {
    @GwtIncompatible(value="Not needed in emulated source.")
    private static final long serialVersionUID = 0L;

    public static <E> HashMultiset<E> create() {
        return new HashMultiset<E>();
    }

    public static <E> HashMultiset<E> create(int n) {
        return new HashMultiset<E>(n);
    }

    public static <E> HashMultiset<E> create(Iterable<? extends E> iterable) {
        HashMultiset<E> hashMultiset = HashMultiset.create(Multisets.inferDistinctElements(iterable));
        Iterables.addAll(hashMultiset, iterable);
        return hashMultiset;
    }

    private HashMultiset() {
        super(new HashMap());
    }

    private HashMultiset(int n) {
        super(Maps.newHashMapWithExpectedSize(n));
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int n = Serialization.readCount(objectInputStream);
        this.setBackingMap(Maps.newHashMapWithExpectedSize(n));
        Serialization.populateMultiset(this, objectInputStream, n);
    }
}

