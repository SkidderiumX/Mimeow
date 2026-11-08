/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.BannerPatterns1_20_5;
import com.viaversion.viaversion.util.KeyMappings;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BannerPatternStorage
implements StorableObject {
    private KeyMappings bannerPatterns = BannerPatterns1_20_5.PATTERNS;

    public KeyMappings bannerPatterns() {
        return this.bannerPatterns;
    }

    public void setBannerPatterns(KeyMappings keyMappings) {
        this.bannerPatterns = keyMappings;
    }

    public @Nullable String pattern(int n) {
        return this.bannerPatterns.idToKey(n);
    }
}

