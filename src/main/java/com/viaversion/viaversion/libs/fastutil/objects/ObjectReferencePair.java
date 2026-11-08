/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectReferenceImmutablePair;

public interface ObjectReferencePair<K, V>
extends Pair<K, V> {
    public static <K, V> ObjectReferencePair<K, V> of(K k, V v) {
        return new ObjectReferenceImmutablePair<K, V>(k, v);
    }
}

