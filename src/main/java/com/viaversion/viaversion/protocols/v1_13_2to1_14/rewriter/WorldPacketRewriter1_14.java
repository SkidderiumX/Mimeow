/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13_2to1_14.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.NibbleArray;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_13;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_14;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.Protocol1_13_2To1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.storage.EntityTracker1_14;
import com.viaversion.viaversion.util.CompactArrayUtil;
import java.util.Arrays;

public class WorldPacketRewriter1_14 {
    public static final int SERVERSIDE_VIEW_DISTANCE = 64;
    private static final byte[] FULL_LIGHT = new byte[2048];
    public static int air;
    public static int voidAir;
    public static int caveAir;

    public static void register(final Protocol1_13_2To1_14 protocol1_13_2To1_14) {
        protocol1_13_2To1_14.registerClientbound(ClientboundPackets1_13.BLOCK_DESTRUCTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
                this.map(Types.BYTE);
            }
        });
        protocol1_13_2To1_14.registerClientbound(ClientboundPackets1_13.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
            }
        });
        protocol1_13_2To1_14.replaceClientbound(ClientboundPackets1_13.BLOCK_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> packetWrapper.set(Types.VAR_INT, 0, protocol1_13_2To1_14.getMappingData().getNewBlockId(packetWrapper.get(Types.VAR_INT, 0))));
            }
        });
        protocol1_13_2To1_14.replaceClientbound(ClientboundPackets1_13.BLOCK_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    packetWrapper.set(Types.VAR_INT, 0, protocol1_13_2To1_14.getMappingData().getNewBlockStateId(n));
                });
            }
        });
        protocol1_13_2To1_14.registerClientbound(ClientboundPackets1_13.CHANGE_DIFFICULTY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> packetWrapper.write(Types.BOOLEAN, false));
            }
        });
        protocol1_13_2To1_14.registerClientbound(ClientboundPackets1_13.EXPLODE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> {
                    for (int i = 0; i < 3; ++i) {
                        float f = packetWrapper.get(Types.FLOAT, i).floatValue();
                        if (!(f < 0.0f)) continue;
                        f = (int)f;
                        packetWrapper.set(Types.FLOAT, i, Float.valueOf(f));
                    }
                });
            }
        });
        protocol1_13_2To1_14.registerClientbound(ClientboundPackets1_13.LEVEL_CHUNK, packetWrapper -> {
            int n;
            int n2;
            int n3;
            Object object;
            Object t = packetWrapper.user().getClientWorld(Protocol1_13_2To1_14.class);
            Chunk chunk = packetWrapper.read(ChunkType1_13.forEnvironment(((ClientWorld)t).getEnvironment()));
            packetWrapper.write(ChunkType1_14.TYPE, chunk);
            int[] nArray = new int[256];
            int[] nArray2 = new int[256];
            for (int i = 0; i < chunk.getSections().length; ++i) {
                int n4;
                object = chunk.getSections()[i];
                if (object == null) continue;
                DataPalette dataPalette = object.palette(PaletteType.BLOCKS);
                n3 = 0;
                for (n2 = 0; n2 < dataPalette.size(); ++n2) {
                    n4 = dataPalette.idByIndex(n2);
                    n = protocol1_13_2To1_14.getMappingData().getNewBlockStateId(n4);
                    if (n3 == 0 && n != air && n != voidAir && n != caveAir) {
                        n3 = 1;
                    }
                    dataPalette.setIdByIndex(n2, n);
                }
                if (n3 == 0) {
                    object.setNonAirBlocksCount(0);
                    continue;
                }
                n2 = 0;
                n4 = i << 4;
                for (n = 0; n < 4096; ++n) {
                    int n5 = dataPalette.idAt(n);
                    if (n5 == air || n5 == voidAir || n5 == caveAir) continue;
                    ++n2;
                    int n6 = n & 0xFF;
                    int n7 = ChunkSection.yFromIndex(n);
                    nArray2[n6] = n4 + n7 + 1;
                    if (protocol1_13_2To1_14.getMappingData().getMotionBlocking().contains(n5)) {
                        nArray[n6] = n4 + n7 + 1;
                    }
                    if (!Via.getConfig().isNonFullBlockLightFix() || !protocol1_13_2To1_14.getMappingData().getNonFullBlocks().contains(n5)) continue;
                    int n8 = ChunkSection.xFromIndex(n);
                    int n9 = ChunkSection.zFromIndex(n);
                    WorldPacketRewriter1_14.setNonFullLight(chunk, (ChunkSection)object, i, n8, n7, n9);
                }
                object.setNonAirBlocksCount(n2);
            }
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.put("MOTION_BLOCKING", new LongArrayTag(WorldPacketRewriter1_14.encodeHeightMap(nArray)));
            compoundTag.put("WORLD_SURFACE", new LongArrayTag(WorldPacketRewriter1_14.encodeHeightMap(nArray2)));
            chunk.setHeightMap(compoundTag);
            object = packetWrapper.create(ClientboundPackets1_14.LIGHT_UPDATE);
            object.write(Types.VAR_INT, chunk.getX());
            object.write(Types.VAR_INT, chunk.getZ());
            int n10 = chunk.isFullChunk() ? 262143 : 0;
            n3 = 0;
            for (n2 = 0; n2 < chunk.getSections().length; ++n2) {
                ChunkSection chunkSection = chunk.getSections()[n2];
                if (chunkSection == null) continue;
                if (!chunk.isFullChunk() && chunkSection.getLight().hasSkyLight()) {
                    n10 |= 1 << n2 + 1;
                }
                n3 |= 1 << n2 + 1;
            }
            object.write(Types.VAR_INT, n10);
            object.write(Types.VAR_INT, n3);
            object.write(Types.VAR_INT, 0);
            object.write(Types.VAR_INT, 0);
            if (chunk.isFullChunk()) {
                object.write(Types.BYTE_ARRAY_PRIMITIVE, FULL_LIGHT);
            }
            for (ChunkSection chunkSection : chunk.getSections()) {
                if (chunkSection == null || !chunkSection.getLight().hasSkyLight()) {
                    if (!chunk.isFullChunk()) continue;
                    object.write(Types.BYTE_ARRAY_PRIMITIVE, FULL_LIGHT);
                    continue;
                }
                object.write(Types.BYTE_ARRAY_PRIMITIVE, chunkSection.getLight().getSkyLight());
            }
            if (chunk.isFullChunk()) {
                object.write(Types.BYTE_ARRAY_PRIMITIVE, FULL_LIGHT);
            }
            for (ChunkSection chunkSection : chunk.getSections()) {
                if (chunkSection == null) continue;
                object.write(Types.BYTE_ARRAY_PRIMITIVE, chunkSection.getLight().getBlockLight());
            }
            EntityTracker1_14 entityTracker1_14 = (EntityTracker1_14)packetWrapper.user().getEntityTracker(Protocol1_13_2To1_14.class);
            int n11 = Math.abs(entityTracker1_14.getChunkCenterX() - chunk.getX());
            n = Math.abs(entityTracker1_14.getChunkCenterZ() - chunk.getZ());
            if (entityTracker1_14.isForceSendCenterChunk() || n11 >= 64 || n >= 64) {
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_14.SET_CHUNK_CACHE_CENTER);
                packetWrapper2.write(Types.VAR_INT, chunk.getX());
                packetWrapper2.write(Types.VAR_INT, chunk.getZ());
                packetWrapper2.send(Protocol1_13_2To1_14.class);
                entityTracker1_14.setChunkCenterX(chunk.getX());
                entityTracker1_14.setChunkCenterZ(chunk.getZ());
            }
            object.send(Protocol1_13_2To1_14.class);
            for (ChunkSection chunkSection : chunk.getSections()) {
                if (chunkSection == null) continue;
                chunkSection.setLight(null);
            }
        });
        protocol1_13_2To1_14.replaceClientbound(ClientboundPackets1_13.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    int n2 = packetWrapper.get(Types.INT, 1);
                    if (n == 1010) {
                        packetWrapper.set(Types.INT, 1, protocol1_13_2To1_14.getMappingData().getNewItemId(n2));
                    } else if (n == 2001) {
                        packetWrapper.set(Types.INT, 1, protocol1_13_2To1_14.getMappingData().getNewBlockStateId(n2));
                    }
                });
            }
        });
        protocol1_13_2To1_14.registerClientbound(ClientboundPackets1_13.MAP_ITEM_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> packetWrapper.write(Types.BOOLEAN, false));
            }
        });
        protocol1_13_2To1_14.registerClientbound(ClientboundPackets1_13.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    short s = packetWrapper.read(Types.UNSIGNED_BYTE);
                    Object t = packetWrapper.user().getClientWorld(Protocol1_13_2To1_14.class);
                    if (!((ClientWorld)t).setEnvironment(n = packetWrapper.get(Types.INT, 0).intValue())) {
                        return;
                    }
                    EntityTracker1_14 entityTracker1_14 = (EntityTracker1_14)packetWrapper.user().getEntityTracker(Protocol1_13_2To1_14.class);
                    entityTracker1_14.clearEntities();
                    entityTracker1_14.setForceSendCenterChunk(true);
                    PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_14.CHANGE_DIFFICULTY);
                    packetWrapper2.write(Types.UNSIGNED_BYTE, s);
                    packetWrapper2.write(Types.BOOLEAN, false);
                    packetWrapper2.scheduleSend(protocol1_13_2To1_14.getClass());
                    packetWrapper.send(Protocol1_13_2To1_14.class);
                    packetWrapper.cancel();
                    WorldPacketRewriter1_14.sendViewDistancePacket(packetWrapper.user());
                });
            }
        });
        protocol1_13_2To1_14.registerClientbound(ClientboundPackets1_13.SET_DEFAULT_SPAWN_POSITION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
            }
        });
    }

    static void sendViewDistancePacket(UserConnection userConnection) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_14.SET_CHUNK_CACHE_RADIUS, userConnection);
        packetWrapper.write(Types.VAR_INT, 64);
        packetWrapper.send(Protocol1_13_2To1_14.class);
    }

    private static long[] encodeHeightMap(int[] nArray) {
        return CompactArrayUtil.createCompactArray(9, nArray.length, n -> nArray[n]);
    }

    private static void setNonFullLight(Chunk chunk, ChunkSection chunkSection, int n, int n2, int n3, int n4) {
        int n5 = 0;
        int n6 = 0;
        for (BlockFace blockFace : BlockFace.values()) {
            NibbleArray nibbleArray = chunkSection.getLight().getSkyLightNibbleArray();
            NibbleArray nibbleArray2 = chunkSection.getLight().getBlockLightNibbleArray();
            int n7 = n2 + blockFace.modX();
            int n8 = n3 + blockFace.modY();
            int n9 = n4 + blockFace.modZ();
            if (blockFace.modX() != 0) {
                if (n7 == 16 || n7 == -1) {
                    continue;
                }
            } else if (blockFace.modY() != 0) {
                if (n8 == 16 || n8 == -1) {
                    ChunkSection n10;
                    if (n8 == 16) {
                        ++n;
                        n8 = 0;
                    } else {
                        --n;
                        n8 = 15;
                    }
                    if (n == chunk.getSections().length || n == -1 || (n10 = chunk.getSections()[n]) == null) continue;
                    nibbleArray = n10.getLight().getSkyLightNibbleArray();
                    nibbleArray2 = n10.getLight().getBlockLightNibbleArray();
                }
            } else if (blockFace.modZ() != 0 && (n9 == 16 || n9 == -1)) continue;
            if (nibbleArray2 != null && n6 != 15) {
                int n11 = nibbleArray2.get(n7, n8, n9);
                if (n11 == 15) {
                    n6 = 14;
                } else if (n11 > n6) {
                    n6 = n11 - 1;
                }
            }
            if (nibbleArray == null || n5 == 15) continue;
            int n10 = nibbleArray.get(n7, n8, n9);
            if (n10 == 15) {
                if (blockFace.modY() == 1) {
                    n5 = 15;
                    continue;
                }
                n5 = 14;
                continue;
            }
            if (n10 <= n5) continue;
            n5 = n10 - 1;
        }
        if (n5 != 0) {
            if (!chunkSection.getLight().hasSkyLight()) {
                byte[] byArray = new byte[2028];
                chunkSection.getLight().setSkyLight(byArray);
            }
            chunkSection.getLight().getSkyLightNibbleArray().set(n2, n3, n4, n5);
        }
        if (n6 != 0) {
            chunkSection.getLight().getBlockLightNibbleArray().set(n2, n3, n4, n6);
        }
    }

    static {
        Arrays.fill(FULL_LIGHT, (byte)-1);
    }
}

