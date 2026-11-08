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

public class StairConnectionHandler
implements ConnectionHandler {
    private static final Int2ObjectMap<StairData> STAIR_DATA_MAP = new Int2ObjectOpenHashMap<StairData>();
    private static final Int2IntMap CONNECTED_BLOCKS = new Int2IntOpenHashMap();

    static ConnectionData.ConnectorInitAction init() {
        List<String> list = Arrays.asList("minecraft:oak_stairs", "minecraft:cobblestone_stairs", "minecraft:brick_stairs", "minecraft:stone_brick_stairs", "minecraft:nether_brick_stairs", "minecraft:sandstone_stairs", "minecraft:spruce_stairs", "minecraft:birch_stairs", "minecraft:jungle_stairs", "minecraft:quartz_stairs", "minecraft:acacia_stairs", "minecraft:dark_oak_stairs", "minecraft:red_sandstone_stairs", "minecraft:purpur_stairs", "minecraft:prismarine_stairs", "minecraft:prismarine_brick_stairs", "minecraft:dark_prismarine_stairs");
        StairConnectionHandler stairConnectionHandler = new StairConnectionHandler();
        return wrappedBlockData -> {
            byte by;
            int n = list.indexOf(wrappedBlockData.getMinecraftKey());
            if (n == -1) {
                return;
            }
            if (wrappedBlockData.getValue("waterlogged").equals("true")) {
                return;
            }
            switch (wrappedBlockData.getValue("shape")) {
                case "straight": {
                    by = 0;
                    break;
                }
                case "inner_left": {
                    by = 1;
                    break;
                }
                case "inner_right": {
                    by = 2;
                    break;
                }
                case "outer_left": {
                    by = 3;
                    break;
                }
                case "outer_right": {
                    by = 4;
                    break;
                }
                default: {
                    return;
                }
            }
            Object object = new StairData(wrappedBlockData.getValue("half").equals("bottom"), by, (byte)n, BlockFace.valueOf(wrappedBlockData.getValue("facing").toUpperCase(Locale.ROOT)));
            STAIR_DATA_MAP.put(wrappedBlockData.getSavedBlockStateId(), (StairData)object);
            CONNECTED_BLOCKS.put(StairConnectionHandler.getStates((StairData)object), wrappedBlockData.getSavedBlockStateId());
            ConnectionData.connectionHandlerMap.put(wrappedBlockData.getSavedBlockStateId(), (ConnectionHandler)stairConnectionHandler);
        };
    }

    private static short getStates(StairData stairData) {
        short s = 0;
        if (stairData.bottom()) {
            s = (short)(s | 1);
        }
        s = (short)(s | stairData.shape() << 1);
        s = (short)(s | stairData.type() << 4);
        s = (short)(s | stairData.facing().ordinal() << 9);
        return s;
    }

    @Override
    public int connect(UserConnection userConnection, BlockPosition blockPosition, int n) {
        StairData stairData = (StairData)STAIR_DATA_MAP.get(n);
        if (stairData == null) {
            return n;
        }
        short s = 0;
        if (stairData.bottom()) {
            s = (short)(s | 1);
        }
        s = (short)(s | this.getShape(userConnection, blockPosition, stairData) << 1);
        s = (short)(s | stairData.type() << 4);
        s = (short)(s | stairData.facing().ordinal() << 9);
        return CONNECTED_BLOCKS.getOrDefault(s, n);
    }

    private int getShape(UserConnection userConnection, BlockPosition blockPosition, StairData stairData) {
        BlockFace blockFace;
        BlockFace blockFace2 = stairData.facing();
        StairData stairData2 = (StairData)STAIR_DATA_MAP.get(this.getBlockData(userConnection, blockPosition.getRelative(blockFace2)));
        if (stairData2 != null && stairData2.bottom() == stairData.bottom()) {
            blockFace = stairData2.facing();
            if (blockFace2.axis() != blockFace.axis() && this.checkOpposite(userConnection, stairData, blockPosition, blockFace.opposite())) {
                return blockFace == this.rotateAntiClockwise(blockFace2) ? 3 : 4;
            }
        }
        if ((stairData2 = (StairData)STAIR_DATA_MAP.get(this.getBlockData(userConnection, blockPosition.getRelative(blockFace2.opposite())))) != null && stairData2.bottom() == stairData.bottom()) {
            blockFace = stairData2.facing();
            if (blockFace2.axis() != blockFace.axis() && this.checkOpposite(userConnection, stairData, blockPosition, blockFace)) {
                return blockFace == this.rotateAntiClockwise(blockFace2) ? 1 : 2;
            }
        }
        return 0;
    }

    private boolean checkOpposite(UserConnection userConnection, StairData stairData, BlockPosition blockPosition, BlockFace blockFace) {
        StairData stairData2 = (StairData)STAIR_DATA_MAP.get(this.getBlockData(userConnection, blockPosition.getRelative(blockFace)));
        return stairData2 == null || stairData2.facing() != stairData.facing() || stairData2.bottom() != stairData.bottom();
    }

    private BlockFace rotateAntiClockwise(BlockFace blockFace) {
        return switch (blockFace) {
            case BlockFace.NORTH -> BlockFace.WEST;
            case BlockFace.SOUTH -> BlockFace.EAST;
            case BlockFace.EAST -> BlockFace.NORTH;
            case BlockFace.WEST -> BlockFace.SOUTH;
            default -> blockFace;
        };
    }

    private record StairData(boolean bottom, byte shape, byte type, BlockFace facing) {
    }
}

