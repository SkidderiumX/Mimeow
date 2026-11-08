/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionHandler;

public class VineConnectionHandler
implements ConnectionHandler {
    private static final IntSet VINES = new IntOpenHashSet();

    VineConnectionHandler() {
    }

    static ConnectionData.ConnectorInitAction init() {
        VineConnectionHandler vineConnectionHandler = new VineConnectionHandler();
        return wrappedBlockData -> {
            if (!wrappedBlockData.getMinecraftKey().equals("minecraft:vine")) {
                return;
            }
            VINES.add(wrappedBlockData.getSavedBlockStateId());
            ConnectionData.connectionHandlerMap.put(wrappedBlockData.getSavedBlockStateId(), (ConnectionHandler)vineConnectionHandler);
        };
    }

    @Override
    public int connect(UserConnection userConnection, BlockPosition blockPosition, int n) {
        if (this.isAttachedToBlock(userConnection, blockPosition)) {
            return n;
        }
        BlockPosition blockPosition2 = blockPosition.getRelative(BlockFace.TOP);
        int n2 = this.getBlockData(userConnection, blockPosition2);
        if (VINES.contains(n2) && this.isAttachedToBlock(userConnection, blockPosition2)) {
            return n;
        }
        return 0;
    }

    private boolean isAttachedToBlock(UserConnection userConnection, BlockPosition blockPosition) {
        return this.isAttachedToBlock(userConnection, blockPosition, BlockFace.EAST) || this.isAttachedToBlock(userConnection, blockPosition, BlockFace.WEST) || this.isAttachedToBlock(userConnection, blockPosition, BlockFace.NORTH) || this.isAttachedToBlock(userConnection, blockPosition, BlockFace.SOUTH);
    }

    private boolean isAttachedToBlock(UserConnection userConnection, BlockPosition blockPosition, BlockFace blockFace) {
        return ConnectionData.OCCLUDING_STATES.contains(this.getBlockData(userConnection, blockPosition.getRelative(blockFace)));
    }
}

