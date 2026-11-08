/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.SimpleRegistryKey;
import com.viaversion.viaversion.util.Key;

public interface RegistryKey {
    public Key registry();

    public static RegistryKey of(String string) {
        return new SimpleRegistryKey(Key.of(string));
    }
}

