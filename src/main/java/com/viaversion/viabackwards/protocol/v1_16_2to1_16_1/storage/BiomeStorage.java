/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_16_2to1_16_1.storage;

import com.viaversion.viabackwards.protocol.v1_16_2to1_16_1.data.BiomeMappings1_16_1;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;

public class BiomeStorage
implements StorableObject {
    private final Int2IntMap modernToLegacyBiomes = new Int2IntOpenHashMap();

    public BiomeStorage() {
        this.modernToLegacyBiomes.defaultReturnValue(-1);
    }

    public void addBiome(String string, int n) {
        this.modernToLegacyBiomes.put(n, BiomeMappings1_16_1.toLegacyBiome(string));
    }

    public int legacyBiome(int n) {
        return this.modernToLegacyBiomes.get(n);
    }

    public void clear() {
        this.modernToLegacyBiomes.clear();
    }
}

