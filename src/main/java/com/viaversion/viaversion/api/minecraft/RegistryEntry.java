/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.util.Copyable;
import org.checkerframework.checker.nullness.qual.Nullable;

public record RegistryEntry(String key, @Nullable Tag tag) implements Copyable
{
    public RegistryEntry withKey(String string) {
        return new RegistryEntry(string, this.tag != null ? this.tag.copy() : null);
    }

    @Override
    public RegistryEntry copy() {
        return new RegistryEntry(this.key, this.tag != null ? this.tag.copy() : null);
    }
}

