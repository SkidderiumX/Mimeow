/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.EnumBiMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Serialization;
import com.google.common.collect.WellBehavedMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public class EnumHashBiMap<K extends Enum<K>, V>
extends AbstractBiMap<K, V> {
    private transient Class<K> keyType;
    @GwtIncompatible(value="only needed in emulated source.")
    private static final long serialVersionUID = 0L;

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> clazz) {
        return new EnumHashBiMap<K, V>(clazz);
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> map) {
        EnumHashBiMap<K, V> enumHashBiMap = EnumHashBiMap.create(EnumBiMap.inferKeyType(map));
        enumHashBiMap.putAll((Map)map);
        return enumHashBiMap;
    }

    private EnumHashBiMap(Class<K> clazz) {
        super(WellBehavedMap.wrap(new EnumMap(clazz)), Maps.newHashMapWithExpectedSize(((Enum[])clazz.getEnumConstants()).length));
        this.keyType = clazz;
    }

    @Override
    K checkKey(K k) {
        return (K)((Enum)Preconditions.checkNotNull(k));
    }

    @Override
    public V put(K k, @Nullable V v) {
        return super.put(k, v);
    }

    @Override
    public V forcePut(K k, @Nullable V v) {
        return super.forcePut(k, v);
    }

    public Class<K> keyType() {
        return this.keyType;
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        Serialization.writeMap(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyType = (Class)objectInputStream.readObject();
        this.setDelegates(WellBehavedMap.wrap(new EnumMap(this.keyType)), new HashMap(((Enum[])this.keyType.getEnumConstants()).length * 3 / 2));
        Serialization.populateMap(this, objectInputStream);
    }
}

