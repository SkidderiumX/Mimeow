/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.GameProfile;
import org.checkerframework.checker.nullness.qual.Nullable;

public record ResolvableProfile(GameProfile profile, @Nullable String bodyTexture, @Nullable String capeTexture, @Nullable String elytraTexture, @Nullable Integer modelType) {
    public ResolvableProfile(GameProfile gameProfile) {
        this(gameProfile, null, null, null, null);
    }
}

