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
import java.util.LinkedHashMap;

@GwtCompatible(serializable=true, emulated=true)
public class LinkedHashMultiset<E>
extends AbstractMapBasedMultiset<E> {
    @GwtIncompatible(value="not needed in emulated source")
    private static final long serialVersionUID = 0L;

    public static <E> LinkedHashMultiset<E> create() {
        return new LinkedHashMultiset<E>();
    }

    public static <E> LinkedHashMultiset<E> create(int n) {
        return new LinkedHashMultiset<E>(n);
    }

    public static <E> LinkedHashMultiset<E> create(Iterable<? extends E> iterable) {
        LinkedHashMultiset<E> linkedHashMultiset = LinkedHashMultiset.create(Multisets.inferDistinctElements(iterable));
        Iterables.addAll(linkedHashMultiset, iterable);
        return linkedHashMultiset;
    }

    private LinkedHashMultiset() {
        super(new LinkedHashMap());
    }

    private LinkedHashMultiset(int n) {
        super(new LinkedHashMap(Maps.capacity(n)));
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
        this.setBackingMap(new LinkedHashMap(Maps.capacity(n)));
        Serialization.populateMultiset(this, objectInputStream, n);
    }
}

