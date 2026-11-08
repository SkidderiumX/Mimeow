/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.RegistryNamespaced;
import org.apache.commons.lang3.Validate;

public class RegistryNamespacedDefaultedByKey<K, V>
extends RegistryNamespaced<K, V> {
    private final K defaultValueKey;
    private V defaultValue;

    public RegistryNamespacedDefaultedByKey(K k) {
        this.defaultValueKey = k;
    }

    @Override
    public void register(int n, K k, V v) {
        if (this.defaultValueKey.equals(k)) {
            this.defaultValue = v;
        }
        super.register(n, k, v);
    }

    public void validateKey() {
        Validate.notNull(this.defaultValueKey);
    }

    @Override
    public V getObject(K k) {
        Object v = super.getObject(k);
        return v == null ? this.defaultValue : v;
    }

    @Override
    public V getObjectById(int n) {
        Object v = super.getObjectById(n);
        return v == null ? this.defaultValue : v;
    }
}

