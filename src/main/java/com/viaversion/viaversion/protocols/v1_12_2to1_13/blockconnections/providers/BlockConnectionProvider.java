/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.providers;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.platform.providers.Provider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.providers.UserBlockData;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class BlockConnectionProvider
implements Provider {
    public int getBlockData(UserConnection userConnection, int n, int n2, int n3) {
        int n4 = this.getWorldBlockData(userConnection, n, n2, n3);
        return Protocol1_12_2To1_13.MAPPINGS.getBlockMappings().getNewId(n4);
    }

    public int getWorldBlockData(UserConnection userConnection, int n, int n2, int n3) {
        return -1;
    }

    public void storeBlock(UserConnection userConnection, int n, int n2, int n3, int n4) {
    }

    public void removeBlock(UserConnection userConnection, int n, int n2, int n3) {
    }

    public void clearStorage(UserConnection userConnection) {
    }

    public void modifiedBlock(UserConnection userConnection, BlockPosition blockPosition) {
    }

    public void unloadChunk(UserConnection userConnection, int n, int n2) {
    }

    public void unloadChunkSection(UserConnection userConnection, int n, int n2, int n3) {
    }

    public boolean storesBlocks(UserConnection userConnection, @Nullable BlockPosition blockPosition) {
        return false;
    }

    public UserBlockData forUser(UserConnection userConnection) {
        return (n, n2, n3) -> this.getBlockData(userConnection, n, n2, n3);
    }
}

