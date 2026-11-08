/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceObjectImmutablePair;

public interface ReferenceObjectPair<K, V>
extends Pair<K, V> {
    public static <K, V> ReferenceObjectPair<K, V> of(K k, V v) {
        return new ReferenceObjectImmutablePair<K, V>(k, v);
    }
}

