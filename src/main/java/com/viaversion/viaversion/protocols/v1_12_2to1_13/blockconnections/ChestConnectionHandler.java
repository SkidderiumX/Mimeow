/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.WrappedBlockData;
import java.util.Arrays;
import java.util.Locale;

public class ChestConnectionHandler
implements ConnectionHandler {
    private static final Int2ObjectMap<BlockFace> CHEST_FACINGS = new Int2ObjectOpenHashMap<BlockFace>();
    private static final int[] CONNECTED_STATES = new int[32];
    private static final IntSet TRAPPED_CHESTS = new IntOpenHashSet();

    ChestConnectionHandler() {
    }

    static ConnectionData.ConnectorInitAction init() {
        Arrays.fill(CONNECTED_STATES, -1);
        ChestConnectionHandler chestConnectionHandler = new ChestConnectionHandler();
        return wrappedBlockData -> {
            if (!wrappedBlockData.getMinecraftKey().equals("minecraft:chest") && !wrappedBlockData.getMinecraftKey().equals("minecraft:trapped_chest")) {
                return;
            }
            if (wrappedBlockData.getValue("waterlogged").equals("true")) {
                return;
            }
            CHEST_FACINGS.put(wrappedBlockData.getSavedBlockStateId(), BlockFace.valueOf(wrappedBlockData.getValue("facing").toUpperCase(Locale.ROOT)));
            if (wrappedBlockData.getMinecraftKey().equalsIgnoreCase("minecraft:trapped_chest")) {
                TRAPPED_CHESTS.add(wrappedBlockData.getSavedBlockStateId());
            }
            ChestConnectionHandler.CONNECTED_STATES[ChestConnectionHandler.getStates((WrappedBlockData)wrappedBlockData).byteValue()] = wrappedBlockData.getSavedBlockStateId();
            ConnectionData.connectionHandlerMap.put(wrappedBlockData.getSavedBlockStateId(), (ConnectionHandler)chestConnectionHandler);
        };
    }

    private static Byte getStates(WrappedBlockData wrappedBlockData) {
        byte by = 0;
        String string = wrappedBlockData.getValue("type");
        if (string.equals("left")) {
            by = (byte)(by | 1);
        }
        if (string.equals("right")) {
            by = (byte)(by | 2);
        }
        by = (byte)(by | BlockFace.valueOf(wrappedBlockData.getValue("facing").toUpperCase(Locale.ROOT)).ordinal() << 2);
        if (wrappedBlockData.getMinecraftKey().equals("minecraft:trapped_chest")) {
            by = (byte)(by | 0x10);
        }
        return by;
    }

    @Override
    public int connect(UserConnection userConnection, BlockPosition blockPosition, int n) {
        int n2;
        BlockFace blockFace = (BlockFace)((Object)CHEST_FACINGS.get(n));
        int n3 = 0;
        n3 = (byte)(n3 | blockFace.ordinal() << 2);
        boolean bl = TRAPPED_CHESTS.contains(n);
        if (bl) {
            n3 = (byte)(n3 | 0x10);
        }
        if (CHEST_FACINGS.containsKey(n2 = this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.NORTH))) && bl == TRAPPED_CHESTS.contains(n2)) {
            n3 = (byte)(n3 | (blockFace == BlockFace.WEST ? 1 : 2));
        } else {
            n2 = this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.SOUTH));
            if (CHEST_FACINGS.containsKey(n2) && bl == TRAPPED_CHESTS.contains(n2)) {
                n3 = (byte)(n3 | (blockFace == BlockFace.EAST ? 1 : 2));
            } else {
                n2 = this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.WEST));
                if (CHEST_FACINGS.containsKey(n2) && bl == TRAPPED_CHESTS.contains(n2)) {
                    n3 = (byte)(n3 | (blockFace == BlockFace.NORTH ? 2 : 1));
                } else {
                    n2 = this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.EAST));
                    if (CHEST_FACINGS.containsKey(n2) && bl == TRAPPED_CHESTS.contains(n2)) {
                        n3 = (byte)(n3 | (blockFace == BlockFace.SOUTH ? 2 : 1));
                    }
                }
            }
        }
        int n4 = CONNECTED_STATES[n3];
        return n4 == -1 ? n : n4;
    }
}

