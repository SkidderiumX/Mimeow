/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.util.IObjectIntIterable;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.util.RegistrySimple;

public class RegistryNamespaced<K, V>
extends RegistrySimple<K, V>
implements IObjectIntIterable<V> {
    protected final ObjectIntIdentityMap<V> underlyingIntegerMap = new ObjectIntIdentityMap();
    protected final Map<V, K> inverseObjectRegistry = ((BiMap)this.registryObjects).inverse();

    public void register(int n, K k, V v) {
        this.underlyingIntegerMap.put(v, n);
        this.putObject(k, v);
    }

    @Override
    protected Map<K, V> createUnderlyingMap() {
        return HashBiMap.create();
    }

    @Override
    public V getObject(K k) {
        return super.getObject(k);
    }

    public K getNameForObject(V v) {
        return this.inverseObjectRegistry.get(v);
    }

    @Override
    public boolean containsKey(K k) {
        return super.containsKey(k);
    }

    public int getIDForObject(V v) {
        return this.underlyingIntegerMap.get(v);
    }

    public V getObjectById(int n) {
        return this.underlyingIntegerMap.getByValue(n);
    }

    @Override
    public Iterator<V> iterator() {
        return this.underlyingIntegerMap.iterator();
    }
}

