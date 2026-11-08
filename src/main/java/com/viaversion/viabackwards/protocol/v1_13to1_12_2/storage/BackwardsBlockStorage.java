/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BackwardsBlockStorage
implements StorableObject {
    private static final IntSet WHITELIST;
    private final Map<BlockPosition, Integer> blocks = new ConcurrentHashMap<BlockPosition, Integer>();

    public void checkAndStore(BlockPosition blockPosition, int n) {
        if (!WHITELIST.contains(n)) {
            this.blocks.remove(blockPosition);
            return;
        }
        this.blocks.put(blockPosition, n);
    }

    public @Nullable Integer get(BlockPosition blockPosition) {
        return this.blocks.get(blockPosition);
    }

    public int remove(BlockPosition blockPosition) {
        return this.blocks.remove(blockPosition);
    }

    public void clear() {
        this.blocks.clear();
    }

    public Map<BlockPosition, Integer> getBlocks() {
        return this.blocks;
    }

    static {
        int n;
        WHITELIST = new IntOpenHashSet(779);
        for (n = 5265; n <= 5286; ++n) {
            WHITELIST.add(n);
        }
        for (n = 0; n < 256; ++n) {
            WHITELIST.add(748 + n);
        }
        for (n = 6854; n <= 7173; ++n) {
            WHITELIST.add(n);
        }
        WHITELIST.add(1647);
        for (n = 5447; n <= 5566; ++n) {
            WHITELIST.add(n);
        }
        for (n = 1028; n <= 1039; ++n) {
            WHITELIST.add(n);
        }
        for (n = 1047; n <= 1082; ++n) {
            WHITELIST.add(n);
        }
        for (n = 1099; n <= 1110; ++n) {
            WHITELIST.add(n);
        }
    }
}

