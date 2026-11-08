/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectArrayMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.WrappedBlockData;
import java.util.Arrays;
import java.util.Locale;

public class TripwireConnectionHandler
implements ConnectionHandler {
    private static final Int2ObjectMap<TripwireData> TRIPWIRE_DATA_MAP = new Int2ObjectOpenHashMap<TripwireData>();
    private static final Int2ObjectMap<BlockFace> TRIPWIRE_HOOKS = new Int2ObjectArrayMap<BlockFace>();
    private static final int[] CONNECTED_BLOCKS = new int[128];

    static ConnectionData.ConnectorInitAction init() {
        Arrays.fill(CONNECTED_BLOCKS, -1);
        TripwireConnectionHandler tripwireConnectionHandler = new TripwireConnectionHandler();
        return wrappedBlockData -> {
            if (wrappedBlockData.getMinecraftKey().equals("minecraft:tripwire_hook")) {
                TRIPWIRE_HOOKS.put(wrappedBlockData.getSavedBlockStateId(), BlockFace.valueOf(wrappedBlockData.getValue("facing").toUpperCase(Locale.ROOT)));
            } else if (wrappedBlockData.getMinecraftKey().equals("minecraft:tripwire")) {
                TripwireData tripwireData = new TripwireData(wrappedBlockData.getValue("attached").equals("true"), wrappedBlockData.getValue("disarmed").equals("true"), wrappedBlockData.getValue("powered").equals("true"));
                TRIPWIRE_DATA_MAP.put(wrappedBlockData.getSavedBlockStateId(), tripwireData);
                TripwireConnectionHandler.CONNECTED_BLOCKS[TripwireConnectionHandler.getStates((WrappedBlockData)wrappedBlockData)] = wrappedBlockData.getSavedBlockStateId();
                ConnectionData.connectionHandlerMap.put(wrappedBlockData.getSavedBlockStateId(), (ConnectionHandler)tripwireConnectionHandler);
            }
        };
    }

    private static byte getStates(WrappedBlockData wrappedBlockData) {
        byte by = 0;
        if (wrappedBlockData.getValue("attached").equals("true")) {
            by = (byte)(by | 1);
        }
        if (wrappedBlockData.getValue("disarmed").equals("true")) {
            by = (byte)(by | 2);
        }
        if (wrappedBlockData.getValue("powered").equals("true")) {
            by = (byte)(by | 4);
        }
        if (wrappedBlockData.getValue("east").equals("true")) {
            by = (byte)(by | 8);
        }
        if (wrappedBlockData.getValue("north").equals("true")) {
            by = (byte)(by | 0x10);
        }
        if (wrappedBlockData.getValue("south").equals("true")) {
            by = (byte)(by | 0x20);
        }
        if (wrappedBlockData.getValue("west").equals("true")) {
            by = (byte)(by | 0x40);
        }
        return by;
    }

    @Override
    public int connect(UserConnection userConnection, BlockPosition blockPosition, int n) {
        int n2;
        TripwireData tripwireData = (TripwireData)TRIPWIRE_DATA_MAP.get(n);
        if (tripwireData == null) {
            return n;
        }
        byte by = 0;
        if (tripwireData.attached()) {
            by = (byte)(by | 1);
        }
        if (tripwireData.disarmed()) {
            by = (byte)(by | 2);
        }
        if (tripwireData.powered()) {
            by = (byte)(by | 4);
        }
        int n3 = this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.EAST));
        int n4 = this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.NORTH));
        int n5 = this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.SOUTH));
        int n6 = this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.WEST));
        if (TRIPWIRE_DATA_MAP.containsKey(n3) || TRIPWIRE_HOOKS.get(n3) == BlockFace.WEST) {
            by = (byte)(by | 8);
        }
        if (TRIPWIRE_DATA_MAP.containsKey(n4) || TRIPWIRE_HOOKS.get(n4) == BlockFace.SOUTH) {
            by = (byte)(by | 0x10);
        }
        if (TRIPWIRE_DATA_MAP.containsKey(n5) || TRIPWIRE_HOOKS.get(n5) == BlockFace.NORTH) {
            by = (byte)(by | 0x20);
        }
        if (TRIPWIRE_DATA_MAP.containsKey(n6) || TRIPWIRE_HOOKS.get(n6) == BlockFace.EAST) {
            by = (byte)(by | 0x40);
        }
        return (n2 = CONNECTED_BLOCKS[by]) == -1 ? n : n2;
    }

    private record TripwireData(boolean attached, boolean disarmed, boolean powered) {
    }
}

