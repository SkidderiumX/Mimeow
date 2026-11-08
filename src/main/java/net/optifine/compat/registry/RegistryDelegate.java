/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.compat.registry;

import net.minecraft.util.ResourceLocation;

public interface RegistryDelegate<T> {
    public T get();

    public ResourceLocation name();

    public Class<T> type();
}

