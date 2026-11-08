/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Serialization;
import com.google.common.collect.WellBehavedMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.Iterator;

@GwtCompatible(emulated=true)
public class EnumMultiset<E extends Enum<E>>
extends AbstractMapBasedMultiset<E> {
    private transient Class<E> type;
    @GwtIncompatible(value="Not needed in emulated source")
    private static final long serialVersionUID = 0L;

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> clazz) {
        return new EnumMultiset<E>(clazz);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> iterator2 = iterable.iterator();
        Preconditions.checkArgument(iterator2.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset enumMultiset = new EnumMultiset(((Enum)iterator2.next()).getDeclaringClass());
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> clazz) {
        EnumMultiset<E> enumMultiset = EnumMultiset.create(clazz);
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    private EnumMultiset(Class<E> clazz) {
        super(WellBehavedMap.wrap(new EnumMap(clazz)));
        this.type = clazz;
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Class clazz;
        objectInputStream.defaultReadObject();
        this.type = clazz = (Class)objectInputStream.readObject();
        this.setBackingMap(WellBehavedMap.wrap(new EnumMap(this.type)));
        Serialization.populateMultiset(this, objectInputStream);
    }
}

