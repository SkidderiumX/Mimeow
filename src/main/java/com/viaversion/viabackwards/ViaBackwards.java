/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards;

import com.google.common.base.Preconditions;
import com.viaversion.viabackwards.api.ViaBackwardsConfig;
import com.viaversion.viabackwards.api.ViaBackwardsPlatform;

public class ViaBackwards {
    private static ViaBackwardsPlatform platform;
    private static ViaBackwardsConfig config;

    public static void init(ViaBackwardsPlatform viaBackwardsPlatform, ViaBackwardsConfig viaBackwardsConfig) {
        Preconditions.checkArgument(platform == null, "ViaBackwards is already initialized");
        platform = viaBackwardsPlatform;
        config = viaBackwardsConfig;
    }

    public static ViaBackwardsPlatform getPlatform() {
        return platform;
    }

    public static ViaBackwardsConfig getConfig() {
        return config;
    }
}

