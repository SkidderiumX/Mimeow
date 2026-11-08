/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import java.util.HashSet;
import java.util.Set;

public class SignStorage
implements StorableObject {
    private final Set<BlockPosition> signs = new HashSet<BlockPosition>();

    public void addSign(BlockPosition blockPosition) {
        this.signs.add(blockPosition);
    }

    public boolean isSign(BlockPosition blockPosition) {
        return this.signs.contains(blockPosition);
    }

    public void removeSign(BlockPosition blockPosition) {
        this.signs.remove(blockPosition);
    }

    public void removeSigns(int n, int n2) {
        this.signs.removeIf(blockPosition -> blockPosition.x() >> 4 == n && blockPosition.z() >> 4 == n2);
    }
}

