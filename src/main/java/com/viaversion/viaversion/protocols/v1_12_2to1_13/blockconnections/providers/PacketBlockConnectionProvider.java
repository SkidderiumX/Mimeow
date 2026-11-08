/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.providers;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.providers.BlockConnectionProvider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.providers.UserBlockData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.storage.BlockConnectionStorage;
import org.checkerframework.checker.nullness.qual.Nullable;

public class PacketBlockConnectionProvider
extends BlockConnectionProvider {
    @Override
    public void storeBlock(UserConnection userConnection, int n, int n2, int n3, int n4) {
        userConnection.get(BlockConnectionStorage.class).store(n, n2, n3, n4);
    }

    @Override
    public void removeBlock(UserConnection userConnection, int n, int n2, int n3) {
        userConnection.get(BlockConnectionStorage.class).remove(n, n2, n3);
    }

    @Override
    public int getBlockData(UserConnection userConnection, int n, int n2, int n3) {
        return userConnection.get(BlockConnectionStorage.class).get(n, n2, n3);
    }

    @Override
    public void clearStorage(UserConnection userConnection) {
        userConnection.get(BlockConnectionStorage.class).clear();
    }

    @Override
    public void modifiedBlock(UserConnection userConnection, BlockPosition blockPosition) {
        userConnection.get(BlockConnectionStorage.class).markModified(blockPosition);
    }

    @Override
    public void unloadChunk(UserConnection userConnection, int n, int n2) {
        userConnection.get(BlockConnectionStorage.class).unloadChunk(n, n2);
    }

    @Override
    public void unloadChunkSection(UserConnection userConnection, int n, int n2, int n3) {
        userConnection.get(BlockConnectionStorage.class).unloadSection(n, n2, n3);
    }

    @Override
    public boolean storesBlocks(UserConnection userConnection, @Nullable BlockPosition blockPosition) {
        if (blockPosition == null || userConnection == null) {
            return true;
        }
        return !userConnection.get(BlockConnectionStorage.class).recentlyModified(blockPosition);
    }

    @Override
    public UserBlockData forUser(UserConnection userConnection) {
        BlockConnectionStorage blockConnectionStorage = userConnection.get(BlockConnectionStorage.class);
        return (n, n2, n3) -> blockConnectionStorage.get(n, n2, n3);
    }
}

