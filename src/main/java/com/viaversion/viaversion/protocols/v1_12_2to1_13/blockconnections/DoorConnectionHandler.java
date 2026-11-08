/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionHandler;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DoorConnectionHandler
implements ConnectionHandler {
    private static final Int2ObjectMap<DoorData> DOOR_DATA_MAP = new Int2ObjectOpenHashMap<DoorData>();
    private static final Int2IntMap CONNECTED_STATES = new Int2IntOpenHashMap();

    static ConnectionData.ConnectorInitAction init() {
        List<String> list = Arrays.asList("minecraft:oak_door", "minecraft:birch_door", "minecraft:jungle_door", "minecraft:dark_oak_door", "minecraft:acacia_door", "minecraft:spruce_door", "minecraft:iron_door");
        DoorConnectionHandler doorConnectionHandler = new DoorConnectionHandler();
        return wrappedBlockData -> {
            int n = list.indexOf(wrappedBlockData.getMinecraftKey());
            if (n == -1) {
                return;
            }
            int n2 = wrappedBlockData.getSavedBlockStateId();
            DoorData doorData = new DoorData(wrappedBlockData.getValue("half").equals("lower"), wrappedBlockData.getValue("hinge").equals("right"), wrappedBlockData.getValue("powered").equals("true"), wrappedBlockData.getValue("open").equals("true"), BlockFace.valueOf(wrappedBlockData.getValue("facing").toUpperCase(Locale.ROOT)), n);
            DOOR_DATA_MAP.put(n2, doorData);
            CONNECTED_STATES.put(DoorConnectionHandler.getStates(doorData), n2);
            ConnectionData.connectionHandlerMap.put(n2, (ConnectionHandler)doorConnectionHandler);
        };
    }

    private static short getStates(DoorData doorData) {
        short s = 0;
        if (doorData.lower()) {
            s = (short)(s | 1);
        }
        if (doorData.open()) {
            s = (short)(s | 2);
        }
        if (doorData.powered()) {
            s = (short)(s | 4);
        }
        if (doorData.rightHinge()) {
            s = (short)(s | 8);
        }
        s = (short)(s | doorData.facing().ordinal() << 4);
        s = (short)(s | (doorData.type() & 7) << 6);
        return s;
    }

    @Override
    public int connect(UserConnection userConnection, BlockPosition blockPosition, int n) {
        DoorData doorData = (DoorData)DOOR_DATA_MAP.get(n);
        if (doorData == null) {
            return n;
        }
        int n2 = 0;
        n2 = (short)(n2 | (doorData.type() & 7) << 6);
        if (doorData.lower()) {
            DoorData doorData2 = (DoorData)DOOR_DATA_MAP.get(this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.TOP)));
            if (doorData2 == null) {
                return n;
            }
            n2 = (short)(n2 | 1);
            if (doorData.open()) {
                n2 = (short)(n2 | 2);
            }
            if (doorData2.powered()) {
                n2 = (short)(n2 | 4);
            }
            if (doorData2.rightHinge()) {
                n2 = (short)(n2 | 8);
            }
            n2 = (short)(n2 | doorData.facing().ordinal() << 4);
        } else {
            DoorData doorData3 = (DoorData)DOOR_DATA_MAP.get(this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.BOTTOM)));
            if (doorData3 == null) {
                return n;
            }
            if (doorData3.open()) {
                n2 = (short)(n2 | 2);
            }
            if (doorData.powered()) {
                n2 = (short)(n2 | 4);
            }
            if (doorData.rightHinge()) {
                n2 = (short)(n2 | 8);
            }
            n2 = (short)(n2 | doorData3.facing().ordinal() << 4);
        }
        return CONNECTED_STATES.getOrDefault(n2, n);
    }

    private record DoorData(boolean lower, boolean rightHinge, boolean powered, boolean open, BlockFace facing, int type) {
    }
}

