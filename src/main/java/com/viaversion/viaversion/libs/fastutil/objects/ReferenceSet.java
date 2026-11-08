/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Size64;
import com.viaversion.viaversion.libs.fastutil.objects.AbstractReferenceSet;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterators;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceArraySet;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceCollection;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceSets;
import java.util.Set;

public interface ReferenceSet<K>
extends ReferenceCollection<K>,
Set<K> {
    @Override
    public ObjectIterator<K> iterator();

    @Override
    default public ObjectSpliterator<K> spliterator() {
        return ObjectSpliterators.asSpliterator(this.iterator(), Size64.sizeOf(this), 65);
    }

    public static <K> ReferenceSet<K> of() {
        return ReferenceSets.UNMODIFIABLE_EMPTY_SET;
    }

    public static <K> ReferenceSet<K> of(K k) {
        return ReferenceSets.singleton(k);
    }

    public static <K> ReferenceSet<K> of(K k, K k2) {
        ReferenceArraySet<K> referenceArraySet = new ReferenceArraySet<K>(2);
        referenceArraySet.add(k);
        if (!referenceArraySet.add(k2)) {
            throw new IllegalArgumentException("Duplicate element: " + k2);
        }
        return ReferenceSets.unmodifiable(referenceArraySet);
    }

    public static <K> ReferenceSet<K> of(K k, K k2, K k3) {
        ReferenceArraySet<K> referenceArraySet = new ReferenceArraySet<K>(3);
        referenceArraySet.add(k);
        if (!referenceArraySet.add(k2)) {
            throw new IllegalArgumentException("Duplicate element: " + k2);
        }
        if (!referenceArraySet.add(k3)) {
            throw new IllegalArgumentException("Duplicate element: " + k3);
        }
        return ReferenceSets.unmodifiable(referenceArraySet);
    }

    @SafeVarargs
    public static <K> ReferenceSet<K> of(K ... KArray) {
        switch (KArray.length) {
            case 0: {
                return ReferenceSet.of();
            }
            case 1: {
                return ReferenceSet.of(KArray[0]);
            }
            case 2: {
                return ReferenceSet.of(KArray[0], KArray[1]);
            }
            case 3: {
                return ReferenceSet.of(KArray[0], KArray[1], KArray[2]);
            }
        }
        AbstractReferenceSet abstractReferenceSet = KArray.length <= 4 ? new ReferenceArraySet(KArray.length) : new ReferenceOpenHashSet(KArray.length);
        for (K k : KArray) {
            if (abstractReferenceSet.add(k)) continue;
            throw new IllegalArgumentException("Duplicate element: " + k);
        }
        return ReferenceSets.unmodifiable(abstractReferenceSet);
    }
}

