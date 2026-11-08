/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.BlockData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.WrappedBlockData;

public class RedstoneConnectionHandler
implements ConnectionHandler {
    private static final IntSet REDSTONE = new IntOpenHashSet();
    private static final Int2IntMap CONNECTED_BLOCK_STATES = new Int2IntOpenHashMap(1296);
    private static final Int2IntMap POWER_MAPPINGS = new Int2IntOpenHashMap(1296);
    private static final int BLOCK_CONNECTION_TYPE_ID = BlockData.connectionTypeId("redstone");

    static ConnectionData.ConnectorInitAction init() {
        RedstoneConnectionHandler redstoneConnectionHandler = new RedstoneConnectionHandler();
        String string = "minecraft:redstone_wire";
        return wrappedBlockData -> {
            if (!"minecraft:redstone_wire".equals(wrappedBlockData.getMinecraftKey())) {
                return;
            }
            REDSTONE.add(wrappedBlockData.getSavedBlockStateId());
            ConnectionData.connectionHandlerMap.put(wrappedBlockData.getSavedBlockStateId(), (ConnectionHandler)redstoneConnectionHandler);
            CONNECTED_BLOCK_STATES.put(RedstoneConnectionHandler.getStates(wrappedBlockData), wrappedBlockData.getSavedBlockStateId());
            POWER_MAPPINGS.put(wrappedBlockData.getSavedBlockStateId(), Integer.parseInt(wrappedBlockData.getValue("power")));
        };
    }

    private static short getStates(WrappedBlockData wrappedBlockData) {
        short s = 0;
        s = (short)(s | RedstoneConnectionHandler.getState(wrappedBlockData.getValue("east")));
        s = (short)(s | RedstoneConnectionHandler.getState(wrappedBlockData.getValue("north")) << 2);
        s = (short)(s | RedstoneConnectionHandler.getState(wrappedBlockData.getValue("south")) << 4);
        s = (short)(s | RedstoneConnectionHandler.getState(wrappedBlockData.getValue("west")) << 6);
        s = (short)(s | Integer.parseInt(wrappedBlockData.getValue("power")) << 8);
        return s;
    }

    private static int getState(String string) {
        return switch (string) {
            case "side" -> 1;
            case "up" -> 2;
            default -> 0;
        };
    }

    @Override
    public int connect(UserConnection userConnection, BlockPosition blockPosition, int n) {
        int n2 = 0;
        n2 = (short)(n2 | this.connects(userConnection, blockPosition, BlockFace.EAST));
        n2 = (short)(n2 | this.connects(userConnection, blockPosition, BlockFace.NORTH) << 2);
        n2 = (short)(n2 | this.connects(userConnection, blockPosition, BlockFace.SOUTH) << 4);
        n2 = (short)(n2 | this.connects(userConnection, blockPosition, BlockFace.WEST) << 6);
        n2 = (short)(n2 | POWER_MAPPINGS.get(n) << 8);
        return CONNECTED_BLOCK_STATES.getOrDefault(n2, n);
    }

    private int connects(UserConnection userConnection, BlockPosition blockPosition, BlockFace blockFace) {
        BlockPosition blockPosition2 = blockPosition.getRelative(blockFace);
        int n = this.getBlockData(userConnection, blockPosition2);
        if (this.connects(blockFace, n)) {
            return 1;
        }
        int n2 = this.getBlockData(userConnection, blockPosition2.getRelative(BlockFace.TOP));
        if (REDSTONE.contains(n2) && !ConnectionData.OCCLUDING_STATES.contains(this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.TOP)))) {
            return 2;
        }
        int n3 = this.getBlockData(userConnection, blockPosition2.getRelative(BlockFace.BOTTOM));
        if (REDSTONE.contains(n3) && !ConnectionData.OCCLUDING_STATES.contains(this.getBlockData(userConnection, blockPosition2))) {
            return 1;
        }
        return 0;
    }

    private boolean connects(BlockFace blockFace, int n) {
        BlockData blockData = (BlockData)ConnectionData.blockConnectionData.get(n);
        return blockData != null && blockData.connectsTo(BLOCK_CONNECTION_TYPE_ID, blockFace.opposite(), false);
    }
}

