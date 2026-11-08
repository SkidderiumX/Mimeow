/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.optifine.util.IteratorCache;

public class ClassInheritanceMultiMap<T>
extends AbstractSet<T> {
    private static final Set<Class<?>> field_181158_a = Collections.newSetFromMap(new ConcurrentHashMap());
    private final Map<Class<?>, List<T>> map = Maps.newHashMap();
    private final Set<Class<?>> knownKeys = Sets.newIdentityHashSet();
    private final Class<T> baseClass;
    private final List<T> values = Lists.newArrayList();
    public boolean empty;

    public ClassInheritanceMultiMap(Class<T> clazz) {
        this.baseClass = clazz;
        this.knownKeys.add(clazz);
        this.map.put(clazz, this.values);
        for (Class<?> clazz2 : field_181158_a) {
            this.createLookup(clazz2);
        }
        this.empty = this.values.size() == 0;
    }

    protected void createLookup(Class<?> clazz) {
        field_181158_a.add(clazz);
        int n = this.values.size();
        for (int i = 0; i < n; ++i) {
            T t = this.values.get(i);
            if (!clazz.isAssignableFrom(t.getClass())) continue;
            this.addForClass(t, clazz);
        }
        this.knownKeys.add(clazz);
    }

    protected Class<?> initializeClassLookup(Class<?> clazz) {
        if (this.baseClass.isAssignableFrom(clazz)) {
            if (!this.knownKeys.contains(clazz)) {
                this.createLookup(clazz);
            }
            return clazz;
        }
        throw new IllegalArgumentException("Don't know how to search for " + String.valueOf(clazz));
    }

    @Override
    public boolean add(T t) {
        for (Class<?> clazz : this.knownKeys) {
            if (!clazz.isAssignableFrom(t.getClass())) continue;
            this.addForClass(t, clazz);
        }
        this.empty = this.values.size() == 0;
        return true;
    }

    private void addForClass(T t, Class<?> clazz) {
        List<T> list = this.map.get(clazz);
        if (list == null) {
            this.map.put(clazz, Lists.newArrayList(t));
        } else {
            list.add(t);
        }
        this.empty = this.values.size() == 0;
    }

    @Override
    public boolean remove(Object object) {
        Object object2 = object;
        boolean bl = false;
        for (Class<?> clazz : this.knownKeys) {
            List<T> list;
            if (!clazz.isAssignableFrom(object2.getClass()) || (list = this.map.get(clazz)) == null || !list.remove(object2)) continue;
            bl = true;
        }
        this.empty = this.values.size() == 0;
        return bl;
    }

    @Override
    public boolean contains(Object object) {
        return Iterators.contains(this.getByClass(object.getClass()).iterator(), object);
    }

    public <S> Iterable<S> getByClass(final Class<S> clazz) {
        return new Iterable<S>(){

            @Override
            public Iterator<S> iterator() {
                List list = ClassInheritanceMultiMap.this.map.get(ClassInheritanceMultiMap.this.initializeClassLookup(clazz));
                if (list == null) {
                    return Iterators.emptyIterator();
                }
                Iterator iterator2 = list.iterator();
                return Iterators.filter(iterator2, clazz);
            }
        };
    }

    @Override
    public Iterator<T> iterator() {
        return this.values.isEmpty() ? Iterators.emptyIterator() : IteratorCache.getReadOnly(this.values);
    }

    @Override
    public int size() {
        return this.values.size();
    }

    @Override
    public boolean isEmpty() {
        return this.empty;
    }
}

