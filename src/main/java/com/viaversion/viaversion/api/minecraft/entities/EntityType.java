/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.entities;

import org.checkerframework.checker.nullness.qual.Nullable;

public interface EntityType {
    public int getId();

    public @Nullable EntityType getParent();

    public String name();

    public String identifier();

    public boolean isAbstractType();

    default public boolean is(EntityType entityType) {
        return this == entityType;
    }

    default public boolean isOrHasParent(EntityType entityType) {
        EntityType entityType2 = this;
        do {
            if (entityType2 != entityType) continue;
            return true;
        } while ((entityType2 = entityType2.getParent()) != null);
        return false;
    }
}

