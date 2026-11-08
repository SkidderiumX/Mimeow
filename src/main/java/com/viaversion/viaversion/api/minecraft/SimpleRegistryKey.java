/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.RegistryKey;
import com.viaversion.viaversion.util.Key;

public record SimpleRegistryKey(Key registry) implements RegistryKey
{
    @Override
    public String toString() {
        return this.registry.toString();
    }
}

