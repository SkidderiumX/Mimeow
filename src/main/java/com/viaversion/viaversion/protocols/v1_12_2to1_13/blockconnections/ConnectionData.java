/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.IdRanges;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord1_8;
import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.BasicFenceConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.BlockData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ChestConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ChorusPlantConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.DoorConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.FireConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.FlowerConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.GlassConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.MelonConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.NetherFenceConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.PumpkinConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.RedstoneConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.SnowyGrassConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.StairConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.TripwireConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.VineConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.WallConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.WrappedBlockData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.providers.BlockConnectionProvider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.providers.PacketBlockConnectionProvider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.providers.UserBlockData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.BlockStates1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConnectionData {
    public static BlockConnectionProvider blockConnectionProvider;
    static final Object2IntMap<String> KEY_TO_ID;
    static final IntSet OCCLUDING_STATES;
    static Int2ObjectMap<ConnectionHandler> connectionHandlerMap;
    static Int2ObjectMap<BlockData> blockConnectionData;
    private static final BlockChangeRecord1_8[] EMPTY_RECORDS;

    public static void update(UserConnection userConnection, BlockPosition blockPosition) {
        Boolean bl = null;
        for (BlockFace blockFace : BlockFace.values()) {
            BlockPosition blockPosition2 = blockPosition.getRelative(blockFace);
            int n = blockConnectionProvider.getBlockData(userConnection, blockPosition2.x(), blockPosition2.y(), blockPosition2.z());
            ConnectionHandler connectionHandler = (ConnectionHandler)connectionHandlerMap.get(n);
            if (connectionHandler == null) continue;
            int n2 = connectionHandler.connect(userConnection, blockPosition2, n);
            if (n2 == n) {
                if (bl == null) {
                    bl = blockConnectionProvider.storesBlocks(userConnection, blockPosition);
                }
                if (bl.booleanValue()) continue;
            }
            ConnectionData.updateBlockStorage(userConnection, blockPosition2.x(), blockPosition2.y(), blockPosition2.z(), n2);
            PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_13.BLOCK_UPDATE, null, userConnection);
            packetWrapper.write(Types.BLOCK_POSITION1_8, blockPosition2);
            packetWrapper.write(Types.VAR_INT, n2);
            packetWrapper.send(Protocol1_12_2To1_13.class);
        }
    }

    public static void updateBlockStorage(UserConnection userConnection, int n, int n2, int n3, int n4) {
        if (!ConnectionData.needStoreBlocks()) {
            return;
        }
        if (ConnectionData.isWelcome(n4)) {
            blockConnectionProvider.storeBlock(userConnection, n, n2, n3, n4);
        } else {
            blockConnectionProvider.removeBlock(userConnection, n, n2, n3);
        }
    }

    public static void clearBlockStorage(UserConnection userConnection) {
        if (!ConnectionData.needStoreBlocks()) {
            return;
        }
        blockConnectionProvider.clearStorage(userConnection);
    }

    public static void markModified(UserConnection userConnection, BlockPosition blockPosition) {
        if (!ConnectionData.needStoreBlocks()) {
            return;
        }
        blockConnectionProvider.modifiedBlock(userConnection, blockPosition);
    }

    public static boolean needStoreBlocks() {
        return blockConnectionProvider.storesBlocks(null, null);
    }

    public static void connectBlocks(UserConnection userConnection, Chunk chunk) {
        int n = chunk.getX() << 4;
        int n2 = chunk.getZ() << 4;
        for (int i = 0; i < chunk.getSections().length; ++i) {
            int n3;
            int n4;
            ChunkSection chunkSection = chunk.getSections()[i];
            if (chunkSection == null) continue;
            DataPalette dataPalette = chunkSection.palette(PaletteType.BLOCKS);
            boolean bl = false;
            for (n4 = 0; n4 < dataPalette.size(); ++n4) {
                n3 = dataPalette.idByIndex(n4);
                if (!ConnectionData.connects(n3)) continue;
                bl = true;
                break;
            }
            if (!bl) continue;
            n4 = i << 4;
            for (n3 = 0; n3 < 4096; ++n3) {
                BlockPosition blockPosition;
                int n5;
                int n6 = dataPalette.idAt(n3);
                ConnectionHandler connectionHandler = ConnectionData.getConnectionHandler(n6);
                if (connectionHandler == null || (n5 = connectionHandler.connect(userConnection, blockPosition = new BlockPosition(n + ChunkSection.xFromIndex(n3), n4 + ChunkSection.yFromIndex(n3), n2 + ChunkSection.zFromIndex(n3)), n6)) == n6) continue;
                dataPalette.setIdAt(n3, n5);
                ConnectionData.updateBlockStorage(userConnection, blockPosition.x(), blockPosition.y(), blockPosition.z(), n5);
            }
        }
    }

    public static void init() {
        Object object;
        Iterable<ConnectorInitAction> iterable;
        ProtocolVersion protocolVersion = Via.getAPI().getServerVersion().lowestSupportedProtocolVersion();
        if (!Via.getConfig().isServersideBlockConnections() || protocolVersion.isKnown() && protocolVersion.newerThan(ProtocolVersion.v1_12_2)) {
            return;
        }
        Via.getPlatform().getLogger().info("Loading block connection mappings ...");
        CompoundTag compoundTag = MappingDataLoader.INSTANCE.loadNBT("blockstates-1.13.nbt");
        BlockStates1_13.forEach(compoundTag, KEY_TO_ID::put);
        connectionHandlerMap = new Int2ObjectOpenHashMap<ConnectionHandler>(3650);
        if (!Via.getConfig().isReduceBlockStorageMemory()) {
            blockConnectionData = new Int2ObjectOpenHashMap<BlockData>(2048);
            iterable = MappingDataLoader.INSTANCE.loadNBT("blockConnections.nbt");
            for (CompoundTag object2 : ((CompoundTag)iterable).getListTag("profiles", CompoundTag.class)) {
                object = new BlockData();
                for (Map.Entry<String, Tag> entry : object2.entrySet()) {
                    int n;
                    String string = entry.getKey();
                    if (string.equals("ids")) continue;
                    byte by = ((NumberTag)entry.getValue()).asByte();
                    boolean[] blArray = new boolean[4];
                    for (n = 0; n < blArray.length; ++n) {
                        blArray[n] = (by & 1 << n) != 0;
                    }
                    n = Integer.parseInt(string);
                    ((BlockData)object).put(n, blArray);
                }
                IdRanges.forEachId(object2.getByteArrayTag("ids"), arg_0 -> ConnectionData.lambda$init$0((BlockData)object, arg_0));
            }
            IdRanges.forEachId(((CompoundTag)iterable).getByteArrayTag("occluding-states"), OCCLUDING_STATES::add);
        }
        iterable = new ArrayList<ConnectorInitAction>();
        iterable.add(PumpkinConnectionHandler.init());
        iterable.addAll(BasicFenceConnectionHandler.init());
        iterable.add((ConnectorInitAction)NetherFenceConnectionHandler.init());
        iterable.addAll(WallConnectionHandler.init());
        iterable.add((ConnectorInitAction)MelonConnectionHandler.init());
        iterable.addAll(GlassConnectionHandler.init());
        iterable.add((ConnectorInitAction)ChestConnectionHandler.init());
        iterable.add((ConnectorInitAction)DoorConnectionHandler.init());
        iterable.add((ConnectorInitAction)RedstoneConnectionHandler.init());
        iterable.add((ConnectorInitAction)StairConnectionHandler.init());
        iterable.add((ConnectorInitAction)FlowerConnectionHandler.init());
        iterable.addAll(ChorusPlantConnectionHandler.init());
        iterable.add((ConnectorInitAction)TripwireConnectionHandler.init());
        iterable.add((ConnectorInitAction)SnowyGrassConnectionHandler.init());
        iterable.add((ConnectorInitAction)FireConnectionHandler.init());
        if (Via.getConfig().isVineClimbFix()) {
            iterable.add((ConnectorInitAction)VineConnectionHandler.init());
        }
        for (String string : KEY_TO_ID.keySet()) {
            object = WrappedBlockData.fromString(string);
            for (ConnectorInitAction connectorInitAction : iterable) {
                connectorInitAction.check((WrappedBlockData)object);
            }
        }
        if (Via.getConfig().getBlockConnectionMethod().equalsIgnoreCase("packet")) {
            blockConnectionProvider = new PacketBlockConnectionProvider();
            Via.getManager().getProviders().register(BlockConnectionProvider.class, blockConnectionProvider);
        }
    }

    public static boolean isWelcome(int n) {
        return blockConnectionData.containsKey(n) || connectionHandlerMap.containsKey(n);
    }

    public static boolean connects(int n) {
        return connectionHandlerMap.containsKey(n);
    }

    public static int connect(UserConnection userConnection, BlockPosition blockPosition, int n) {
        ConnectionHandler connectionHandler = (ConnectionHandler)connectionHandlerMap.get(n);
        return connectionHandler != null ? connectionHandler.connect(userConnection, blockPosition, n) : n;
    }

    public static ConnectionHandler getConnectionHandler(int n) {
        return (ConnectionHandler)connectionHandlerMap.get(n);
    }

    public static int getId(String string) {
        return KEY_TO_ID.getOrDefault((Object)Key.stripMinecraftNamespace(string), -1);
    }

    public static Object2IntMap<String> getKeyToId() {
        return KEY_TO_ID;
    }

    private static /* synthetic */ void lambda$init$0(BlockData blockData, int n) {
        blockConnectionData.put(n, blockData);
    }

    static {
        KEY_TO_ID = new Object2IntOpenHashMap<String>(8582);
        OCCLUDING_STATES = new IntOpenHashSet(377);
        connectionHandlerMap = new Int2ObjectOpenHashMap<ConnectionHandler>();
        blockConnectionData = new Int2ObjectOpenHashMap<BlockData>();
        EMPTY_RECORDS = new BlockChangeRecord1_8[0];
        KEY_TO_ID.defaultReturnValue(-1);
    }

    @FunctionalInterface
    public static interface ConnectorInitAction {
        public void check(WrappedBlockData var1);
    }

    public static final class NeighbourUpdater {
        private final UserConnection user;
        private final UserBlockData userBlockData;

        public NeighbourUpdater(UserConnection userConnection) {
            this.user = userConnection;
            this.userBlockData = blockConnectionProvider.forUser(userConnection);
        }

        public void updateChunkSectionNeighbours(int n, int n2, int n3) {
            int n4 = n3 << 4;
            ArrayList<BlockChangeRecord1_8> arrayList = new ArrayList<BlockChangeRecord1_8>();
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    int n5 = Math.abs(i) + Math.abs(j);
                    if (n5 == 0) continue;
                    int n6 = n + i << 4;
                    int n7 = n2 + j << 4;
                    if (n5 == 2) {
                        for (var11_11 = n4; var11_11 < n4 + 16; ++var11_11) {
                            var12_13 = i == 1 ? 0 : 15;
                            var13_14 = j == 1 ? 0 : 15;
                            this.updateBlock(n6 + var12_13, var11_11, n7 + var13_14, arrayList);
                        }
                    } else {
                        for (var11_11 = n4; var11_11 < n4 + 16; ++var11_11) {
                            int n8;
                            if (i == 1) {
                                var12_13 = 0;
                                var13_14 = 2;
                                var14_15 = 0;
                                n8 = 16;
                            } else if (i == -1) {
                                var12_13 = 14;
                                var13_14 = 16;
                                var14_15 = 0;
                                n8 = 16;
                            } else if (j == 1) {
                                var12_13 = 0;
                                var13_14 = 16;
                                var14_15 = 0;
                                n8 = 2;
                            } else {
                                var12_13 = 0;
                                var13_14 = 16;
                                var14_15 = 14;
                                n8 = 16;
                            }
                            for (int k = var12_13; k < var13_14; ++k) {
                                for (int i2 = var14_15; i2 < n8; ++i2) {
                                    this.updateBlock(n6 + k, var11_11, n7 + i2, arrayList);
                                }
                            }
                        }
                    }
                    if (arrayList.isEmpty()) continue;
                    PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_13.CHUNK_BLOCKS_UPDATE, null, this.user);
                    packetWrapper.write(Types.INT, n + i);
                    packetWrapper.write(Types.INT, n2 + j);
                    packetWrapper.write(Types.BLOCK_CHANGE_ARRAY, (BlockChangeRecord[])arrayList.toArray(EMPTY_RECORDS));
                    packetWrapper.send(Protocol1_12_2To1_13.class);
                    arrayList.clear();
                }
            }
        }

        private void updateBlock(int n, int n2, int n3, List<BlockChangeRecord1_8> list) {
            int n4 = this.userBlockData.getBlockData(n, n2, n3);
            ConnectionHandler connectionHandler = ConnectionData.getConnectionHandler(n4);
            if (connectionHandler == null) {
                return;
            }
            BlockPosition blockPosition = new BlockPosition(n, n2, n3);
            int n5 = connectionHandler.connect(this.user, blockPosition, n4);
            if (n4 != n5 || !blockConnectionProvider.storesBlocks(this.user, null)) {
                list.add(new BlockChangeRecord1_8(n & 0xF, n2, n3 & 0xF, n5));
                ConnectionData.updateBlockStorage(this.user, n, n2, n3, n5);
            }
        }
    }
}

