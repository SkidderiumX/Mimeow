/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Size64;
import com.viaversion.viaversion.libs.fastutil.objects.AbstractObjectSet;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectArraySet;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectCollection;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSets;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterators;
import java.util.Set;

public interface ObjectSet<K>
extends ObjectCollection<K>,
Set<K> {
    @Override
    public ObjectIterator<K> iterator();

    @Override
    default public ObjectSpliterator<K> spliterator() {
        return ObjectSpliterators.asSpliterator(this.iterator(), Size64.sizeOf(this), 65);
    }

    public static <K> ObjectSet<K> of() {
        return ObjectSets.UNMODIFIABLE_EMPTY_SET;
    }

    public static <K> ObjectSet<K> of(K k) {
        return ObjectSets.singleton(k);
    }

    public static <K> ObjectSet<K> of(K k, K k2) {
        ObjectArraySet<K> objectArraySet = new ObjectArraySet<K>(2);
        objectArraySet.add(k);
        if (!objectArraySet.add(k2)) {
            throw new IllegalArgumentException("Duplicate element: " + k2);
        }
        return ObjectSets.unmodifiable(objectArraySet);
    }

    public static <K> ObjectSet<K> of(K k, K k2, K k3) {
        ObjectArraySet<K> objectArraySet = new ObjectArraySet<K>(3);
        objectArraySet.add(k);
        if (!objectArraySet.add(k2)) {
            throw new IllegalArgumentException("Duplicate element: " + k2);
        }
        if (!objectArraySet.add(k3)) {
            throw new IllegalArgumentException("Duplicate element: " + k3);
        }
        return ObjectSets.unmodifiable(objectArraySet);
    }

    @SafeVarargs
    public static <K> ObjectSet<K> of(K ... KArray) {
        switch (KArray.length) {
            case 0: {
                return ObjectSet.of();
            }
            case 1: {
                return ObjectSet.of(KArray[0]);
            }
            case 2: {
                return ObjectSet.of(KArray[0], KArray[1]);
            }
            case 3: {
                return ObjectSet.of(KArray[0], KArray[1], KArray[2]);
            }
        }
        AbstractObjectSet abstractObjectSet = KArray.length <= 4 ? new ObjectArraySet(KArray.length) : new ObjectOpenHashSet(KArray.length);
        for (K k : KArray) {
            if (abstractObjectSet.add(k)) continue;
            throw new IllegalArgumentException("Duplicate element: " + k);
        }
        return ObjectSets.unmodifiable(abstractObjectSet);
    }
}

